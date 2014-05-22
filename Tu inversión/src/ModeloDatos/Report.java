package ModeloDatos;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juan
 */
public class Report extends Crud {

    private String fecha;
    private String nombreEmpresa;
    private int cantidad;
    private double precio;
    private double total;
    private double precioHistorico;
    private double totalHistorico;
    private double gan_per;
    private int idUsuario;

    public Report() {
    }

    public Report(String fecha, String nombreEmpresa, int cantidad, double precio, double total, double precioHistorico, double totalHistorico, double gan_per, int idUsuario) {
        this.fecha = fecha;
        this.nombreEmpresa = nombreEmpresa;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.precioHistorico = precioHistorico;
        this.totalHistorico = totalHistorico;
        this.gan_per = gan_per;
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrecioHistorico() {
        return precioHistorico;
    }

    public void setPrecioHistorico(double precioHistorico) {
        this.precioHistorico = precioHistorico;
    }

    public double getTotalHistorico() {
        return totalHistorico;
    }

    public void setTotalHistorico(double totalHistorico) {
        this.totalHistorico = totalHistorico;
    }

    public double getGan_per() {
        return gan_per;
    }

    public void setGan_per(double gan_per) {
        this.gan_per = gan_per;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void actualizarFicheroHistorico(int idUsuario) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("ReportHistorico.txt")));
            String inputLine;
            String fichero = "";
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("SELECCION")) {
                    inputLine = inputLine.replace("SELECCION", "SELECT * FROM report WHERE idUsuario = " + idUsuario + " ORDER BY fecha ASC;");
                }
                fichero += inputLine + "\n";
            }
            in.close();

            PrintWriter escribir = new PrintWriter(new File("reports/ReportHistorico.jrxml"));
            escribir.println(fichero);
            escribir.close();
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }

    public void actualizarFicheroDiario(int idUsuario) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("ReportDiario.txt")));
            String inputLine;
            String fichero = "";

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String fecha = dateFormat.format(date);
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("PONDERADO")) {
                    inputLine = inputLine.replace("PONDERADO", "SELECT * FROM report WHERE idUsuario = " + idUsuario + " AND fecha = '" + fecha + "'");
                }

                if (inputLine.contains("COMPRAS")) {
                    inputLine = inputLine.replace("COMPRAS", "SELECT * FROM compras WHERE idUsuario = " + idUsuario + " AND idPartida = 0");
                }

                if (inputLine.contains("VENTAS")) {
                    inputLine = inputLine.replace("VENTAS", "SELECT * FROM ventas WHERE idUsuario = " + idUsuario + " AND idPartida = 0");
                }
                fichero += inputLine + "\n";
            }
            in.close();

            PrintWriter escribir = new PrintWriter(new File("reports/ReportDiario.jrxml"));
            escribir.println(fichero);
            escribir.close();
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }

    public void crearTabla(int idUsuario, String fecha, boolean aux) {
        Historicos historicos = new Historicos();
        Ponderado ponderados = new Ponderado();

        if (aux) {
            actualizarFicheroHistorico(idUsuario);
        } else {
            actualizarFicheroDiario(idUsuario);
        }

        Date fechaActual = new Date();
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSistema = formateadorFecha.format(fechaActual);

        try {
            long oneDayMilSec = 86400000; // number of milliseconds in one day
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            DecimalFormat formateador = new DecimalFormat("###0.##");
            ResultSet rs = null, rs1 = null, rs2 = null;

            // variables necesarias
            int numAccionesOld = 0, numAccionesActual = 0, cont = 0;
            double precioOld = 0, precioActual = 0, ponderado = 0, valorHistorico = 0;
            String nombreEmpresa;
            ArrayList<Ponderado> array = new ArrayList<>();
            boolean comprobar = false;

            String query = "DELETE FROM report WHERE idUsuario = '" + idUsuario + "';";
            updateBD(query);

            Date startDate = null;
            Date endDate = null;
            try {

                startDate = sdf.parse(fecha);
                endDate = sdf.parse(fechaSistema);
            } catch (ParseException ex) {

            }

            long startDateMilSec = startDate.getTime();
            long endDateMilSec = endDate.getTime();

            // en esta parte lo que hemos desarrollado ha sido los ponderados desde principio de nuestra base de datos hasta la fecha
            // que el usuario nos pasa como parámetro. Esto lo hacemos para a partir de aquí ya iremos iterando con las fechas
            // calculando el ponderado y las ganancias o pérdidas.
            query = "SELECT DISTINCT nombreEmpresa\n"
                    + "FROM compras\n"
                    + "WHERE idUsuario = '" + idUsuario + "' AND idPartida = 0 AND fecha < '" + fecha + "';";

            rs = selectBD(query);

            while (rs.next()) {
                nombreEmpresa = rs.getString("nombreEmpresa");
                query = "SELECT *\n"
                        + "FROM compras\n"
                        + "WHERE idUsuario = '" + idUsuario + "' AND idPartida = 0 AND fecha < '" + fecha + "' \n"
                        + "AND nombreEmpresa = '" + nombreEmpresa + "';";

                rs1 = selectBD(query);

                while (rs1.next()) {
                    int id = rs1.getInt("id");
                    nombreEmpresa = rs1.getString("nombreEmpresa");
                    numAccionesActual = rs1.getInt("cantidad");
                    precioActual = rs1.getDouble("precioCompra");

                    precioOld = precioActual;
                    numAccionesOld = numAccionesActual;

                    //obtener todas las compras de una empresa para obtener el ponderado.
                    query = "SELECT *\n"
                            + "FROM compras\n"
                            + "WHERE compras.idUsuario = '" + idUsuario + "' AND compras.idPartida = 0 AND compras.fecha < '" + fecha + "' AND compras.id != '" + id + "' AND compras.nombreEmpresa = '" + nombreEmpresa + "';";

                    rs2 = selectBD(query);

                    while (rs2.next()) {
                        numAccionesActual = rs2.getInt("cantidad");
                        precioActual = rs2.getDouble("precioCompra");
                        ponderado = ponderados.sacarPonderado(precioActual, numAccionesActual, precioOld, numAccionesOld);
                        numAccionesOld += numAccionesActual;
                        precioOld = ponderado;
                    }
                }
                //creamos un array que contiene el número de acciones que tenemos y el precio.
                array.add(new Ponderado(nombreEmpresa, numAccionesOld, precioOld));
            }

            //iteramos por todas las ventas que tenemos y lo que hacemos es actualizar el número de acciones que tenemos.
            query = "SELECT *\n"
                    + "FROM ventas\n"
                    + "WHERE ventas.idUsuario = '" + idUsuario + "' AND ventas.idPartida = 0 AND ventas.fecha < '" + fecha + "';";

            rs = selectBD(query);

            while (rs.next()) {
                nombreEmpresa = rs.getString("nombreEmpresa");
                int cantidad = rs.getInt("cantidad");

                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i).getNombre().equals(nombreEmpresa)) {
                        array.get(i).setNumAcciones(array.get(i).getNumAcciones() - cantidad);
                    }
                }
            }

            for (long d = startDateMilSec; d <= endDateMilSec; d = d + oneDayMilSec) {
                Date date = new Date(d);
                long mili = date.getTime();
                java.sql.Date fechaIteradora = new java.sql.Date(mili);

                query = "SELECT *\n"
                        + "FROM compras\n"
                        + "WHERE compras.idUsuario = '" + idUsuario + "' AND compras.idPartida = 0 AND compras.fecha = '" + fechaIteradora + "';";

                rs = selectBD(query);

                while (rs.next()) {
                    nombreEmpresa = rs.getString("nombreEmpresa");
                    precioActual = rs.getDouble("precioCompra");
                    numAccionesActual = rs.getInt("cantidad");

                    int contador = 0;
                    comprobar = false;

                    for (int i = 0; i < array.size(); i++) {
                        if (array.get(i).getNombre().equals(nombreEmpresa)) {
                            ponderado = ponderados.sacarPonderado(precioActual, numAccionesActual, array.get(i).getPrecio(), array.get(i).getNumAcciones());
                            array.get(i).setNumAcciones(array.get(i).getNumAcciones() + numAccionesActual);
                            array.get(i).setPrecio(ponderado);
                        } else {
                            contador++;
                        }
                    }

                    if (contador == array.size()) {
                        array.add(new Ponderado(nombreEmpresa, numAccionesActual, precioActual));
                        comprobar = true;
                    }
                }

                // en este punto ya tenemos las compras de una empresa comprobadas y nuestro array actualizado. Ahora vamos con las ventas.
                query = "SELECT * \n"
                        + "FROM ventas\n"
                        + "WHERE ventas.idUsuario = '" + idUsuario + "' AND ventas.idPartida = 0  AND fecha = '" + fechaIteradora + "';";

                rs1 = selectBD(query);

                while (rs1.next()) {
                    nombreEmpresa = rs1.getString("nombreEmpresa");
                    int cantidad = rs1.getInt("cantidad");

                    for (int i = 0; i < array.size(); i++) {
                        if (array.get(i).getNombre().equals(nombreEmpresa)) {
                            array.get(i).setNumAcciones(array.get(i).getNumAcciones() - cantidad);
                        }
                    }
                }
                for (int i = 0; i < array.size(); i++) {
                    query = "SELECT historicos.ultimoValor\n"
                            + "FROM historicos\n"
                            + "WHERE historicos.nombreEmpresa = '" + array.get(i).getNombre() + "' AND historicos.fecha = '" + historicos.comprobarDatosHistoricos(fechaIteradora.toString()) + "';";

                    rs1 = selectBD(query);

                    while (rs1.next()) {
                        valorHistorico = rs1.getDouble("ultimoValor");
                    }

                    int max = (maximo("report", "id") + 1);
                    String nom = array.get(i).getNombre();
                    int cant = array.get(i).getNumAcciones();
                    double precio = array.get(i).getPrecio();
                    double total = (cant * precio);
                    double totalHistorico = (valorHistorico * cant);
                    double gan_per = ((cant * valorHistorico) - total);

                    try {
                        precio = formateador.parse(formateador.format(precio)).doubleValue();
                        total = formateador.parse(formateador.format(total)).doubleValue();
                        totalHistorico = formateador.parse(formateador.format(totalHistorico)).doubleValue();
                        gan_per = formateador.parse(formateador.format(gan_per)).doubleValue();
                    } catch (ParseException ex) {
                        System.err.println("ERROR: " + ex.getMessage());
                    }

                    if (cant > 0) {
                        query = "INSERT INTO report VALUES('" + max + "', '" + fechaIteradora + "', '" + nom + "', '" + cant + "', '" + precio + "', '" + total + "', '" + valorHistorico + "', '" + totalHistorico + "', '" + gan_per + "', '" + idUsuario + "');";
                        insertarBD(query);
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        if (aux) {
            creacionReport("/reports/ReportHistorico.jrxml");
        } else{
            creacionReport("/reports/ReportDiario.jrxml");
        }
    }

    public void creacionReport(String nombre) {
        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(System.getProperty("user.dir").concat(nombre));
            JasperPrint print = JasperFillManager.fillReport(report, null, this.getCon());
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Tu inversión");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }
}
