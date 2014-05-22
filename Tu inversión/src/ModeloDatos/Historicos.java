package ModeloDatos;

import Negocio.HistoricosNegocio;
import Negocio.LeerDatosWeb;
import Negocio.Utiles;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Juan
 */
public class Historicos extends Crud {

    private String nombreEmpresa;
    private double ultimoValor;
    private String fecha;
    private Utiles utiles;

    public Historicos() {
        utiles = new Utiles();
    }

    public Historicos(String nombreEmpresa, double ultimoValor, String fecha) {
        this.nombreEmpresa = nombreEmpresa;
        this.ultimoValor = ultimoValor;
        this.fecha = fecha;
        
        utiles = new Utiles();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public double getUltimoValor() {
        return ultimoValor;
    }

    public void setUltimoValor(double ultimoValor) {
        this.ultimoValor = ultimoValor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void insertarBD() {
        String query = "INSERT INTO historicos VALUES('" + (maximo("historicos", "id") + 1) + "', '" + this.getNombreEmpresa() + "', '" + this.getUltimoValor() + "', '" + this.getFecha() + "');";

        insertarBD(query);
    }

    public boolean comprobarBD() {
        String query = "SELECT id FROM historicos WHERE fecha = '" + this.getFecha() + "' AND nombreEmpresa = '" + this.getNombreEmpresa() + "'";
        boolean aux = false;
        ResultSet rs = null;
        try {
            rs = selectBD(query);
            if (rs.first()) {
                aux = false;
            } else {
                aux = true;
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println("ERROR: " + ex.getMessage());
                }
            }
        }
        return aux;
    }

    public void creacionHistoricos() {
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DATE);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anyo = calendario.get(Calendar.YEAR);
        String fecha = anyo + "-" + mes + "-" + dia;

        LeerDatosWeb leerWeb = new LeerDatosWeb("http://www.bolsamadrid.es/esp/aspx/Mercados/Precios.aspx?indice=ESI100000000&punto=indice");

        Scanner leer;
        try {
            leer = new Scanner(new File("web.txt"));

            PrintWriter escribir = new PrintWriter("web.xml", "utf-8");
            String linea = "";
            while (leer.hasNext()) {
                linea = leer.nextLine();

                if (linea.contains("<table class=\"TblPort")) {
                    escribir.println("<div>");
                    escribir.println(linea);
                    for (int i = 0; i < 85; i++) {
                        linea = leer.nextLine();
                        if (!linea.contains("</div>")) {
                            if (!linea.contains("<div>")) {
                                escribir.println(linea);
                            }
                        }
                    }
                }
            }
            escribir.print("</div>");
            escribir.close();
            leer.close();

            try {
                XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
                HistoricosNegocio gestor = new HistoricosNegocio();
                procesadorXML.setContentHandler(gestor);
                InputSource fileXML = new InputSource("web.xml");
                procesadorXML.parse(fileXML);
            } catch (SAXException ex) {
                System.err.println("Error: " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println("Error: " + ex.getMessage());
            }

        } catch (FileNotFoundException ex) {

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Historicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String comprobarDatosHistoricos(String fecha) {
        String fechaFinal = "";
        try {
            String query = "";
            ResultSet rs = null;
            long oneDayMilSec = 86400000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date endDate = null;
            try {
                endDate = sdf.parse(fecha);
            } catch (ParseException ex) {

            }

            long endDateMilSec = endDate.getTime();

            boolean aux = true;

            while (aux) {
                endDateMilSec = endDateMilSec - oneDayMilSec;
                java.sql.Date fechaIteradora = utiles.retrocederDia(endDateMilSec);

                query = "SELECT * FROM historicos WHERE fecha = '" + fechaIteradora + "'";
                rs = selectBD(query);

                if (rs.first()) {
                    aux = false;
                    rs = selectBD(query);

                    while (rs.next()) {
                        fechaFinal = String.valueOf(rs.getDate("fecha"));
                    }
                } else {

                }
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        return fechaFinal;
    }
}
