package Negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Juan
 */
public class Utiles {

    public boolean validar(String txt, String expresionRegular) {
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(txt);

        return matcher.matches();
    }

    public void insertarFila(DefaultTableModel model, JTextField txtNumAcciones, JTextField txtPrecioCompra, JComboBox cbEmpresas) {
        String[] vector = new String[3];
        int fila = -1;
        double numAcciones = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                if (model.getValueAt(i, 0).equals(cbEmpresas.getSelectedItem().toString()) && model.getValueAt(i, 2).equals(txtPrecioCompra.getText())) {
                    numAcciones = Double.parseDouble(String.valueOf(model.getValueAt(i, 1)));

                    fila = i;
                    numAcciones += Double.parseDouble(txtNumAcciones.getText());
                }
            }
        }

        if (fila == -1) {
            vector[0] = cbEmpresas.getSelectedItem().toString();
            vector[1] = txtNumAcciones.getText();
            vector[2] = txtPrecioCompra.getText();
            model.addRow(vector);
        } else {
            vector[0] = cbEmpresas.getSelectedItem().toString();
            vector[1] = String.valueOf(numAcciones);
            vector[2] = txtPrecioCompra.getText();
            model.addRow(vector);
            model.removeRow(fila);
        }

        txtNumAcciones.setText("");
        txtPrecioCompra.setText("");
    }

    public void leerWeb() {
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
            escribir.println("</div>");
            escribir.close();
            leer.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
                GestionEventos gestor = new GestionEventos();
                procesadorXML.setContentHandler(gestor);
                InputSource fileXML = new InputSource("web.xml");
                procesadorXML.parse(fileXML);
            } catch (SAXException ex) {
                System.err.println("Error: " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    public boolean comprobarFechas(String fechaSistema, String fecha) {
        boolean aux = false;
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaSistemaDate = formateador.parse(fechaSistema);
            Date fechaDate = formateador.parse(fecha);

            if (fechaSistemaDate.before(fechaDate)) {
                aux = true;
            } else {
                if (fechaDate.before(fechaSistemaDate)) {
                    aux = false;
                } else {
                    aux = true;
                }
            }
        } catch (ParseException e) {
            System.out.println("Se Produjo un Error!!!  " + e.getMessage());
        }

        return aux;
    }

    public java.sql.Date retrocederDia(long longPasado) {
        Date date = new Date(longPasado);
        long mili = date.getTime();
        java.sql.Date fechaIteradora = new java.sql.Date(mili);

        return fechaIteradora;
    }

    public void actualizarFicheroReport(int idUsuario) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("Report_old.txt")));
            String inputLine;
            String fichero = "";
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("COMPRA")) {
                    inputLine = inputLine.replace("COMPRA", "SELECT * FROM compras WHERE idUsuario = " + idUsuario + " AND idPartida = 0");
                }

                if (inputLine.contains("VENTAS")) {
                    inputLine = inputLine.replace("VENTAS", "SELECT * FROM ventas WHERE idUsuario = " + idUsuario + " AND idPartida = 0");
                }
                fichero += inputLine + "\n";
            }
            in.close();

            PrintWriter escribir = new PrintWriter(new File("reports/Report.jrxml"));
            escribir.println(fichero);
            escribir.close();
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }
    
    public void vaciarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int filas = table.getRowCount();
        for (int i = 0; filas > i; i++) {
            model.removeRow(0);
        }
    }
}
