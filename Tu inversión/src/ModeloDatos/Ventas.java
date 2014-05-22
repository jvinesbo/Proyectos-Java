package ModeloDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Ventas extends Crud {

    private int idUsuario;
    private String fecha;
    private String nombreEmpresa;
    private int cantidad;
    private double precioVenta;
    private double total;
    private double gan_per;
    private int idPartida;

    public Ventas() {
    }

    public Ventas(int idUsuario, int idPartida) {
        this.idUsuario = idUsuario;
        this.idPartida = idPartida;
    }

    public Ventas(int idUsuario, String fecha, String nombreEmpresa, int cantidad, double precioVenta, double total, double gan_per, int idPartida) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.nombreEmpresa = nombreEmpresa;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.total = total;
        this.gan_per = gan_per;
        this.idPartida = idPartida;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getGan_per() {
        return gan_per;
    }

    public void setGan_per(double gan_per) {
        this.gan_per = gan_per;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String numeroAcciones() {
        String query = "SELECT numAcciones \n"
                + "FROM ponderado\n"
                + "WHERE ponderado.idPartida = '" + this.getIdPartida() + "' AND ponderado.idUsuario = '" + this.getIdUsuario() + "' AND ponderado.nombreEmpresa = '" + this.getNombreEmpresa() + "';";
        String resultado = "";

        ResultSet rs = selectBD(query);
        try {
            while (rs.next()) {
                resultado = String.valueOf(rs.getObject("numAcciones"));
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        return resultado;
    }

    public int insert() {
        String query = "INSERT INTO ventas VALUES(?,?,?,?,?,?,?,?,?);";
        ArrayList<Object> array = new ArrayList<>();
        int num = 0;
        double precioCompra = sacarPrecioCompra();

        array.clear();
        array.add(maximo("ventas", "id") + 1);
        array.add(this.getIdUsuario());
        array.add(this.getFecha());
        array.add(this.getNombreEmpresa());
        array.add(this.getCantidad());
        array.add(this.getPrecioVenta());
        array.add((this.getCantidad() * this.getPrecioVenta()));
        array.add(precioCompra);
        array.add(this.getIdPartida());

        num = insertatPSBD(query, array);

        return num;
    }

    public double sacarPrecioCompra() {
        String query;
        Double precioPonderado = 0.0;
        ResultSet rs;

        query = "SELECT precio FROM ponderado WHERE idUsuario = '" + this.getIdUsuario() + "' AND idPartida = '" + this.getIdPartida() + "' AND nombreEmpresa = '" + this.getNombreEmpresa() + "'";
        rs = selectBD(query);
        try {
            while (rs.next()) {
                precioPonderado = rs.getDouble("precio");
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

        Double resultado = (precioVenta * this.getCantidad()) - (precioPonderado * this.getCantidad());

        DecimalFormat formateador = new DecimalFormat("###0.##");
        try {
            resultado = formateador.parse(formateador.format(resultado)).doubleValue();
        } catch (ParseException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        return resultado;
    }

    public int delete() {
        String query = "DELETE FROM ponderado WHERE idUsuario = '" + this.getIdUsuario() + "' AND nombreEmpresa = '" + this.getNombreEmpresa() + "' AND idPartida = '" + this.getIdPartida() + "'";
        int num = 0;

        num = updateBD(query);

        return num;
    }

    public int update() {
        String query = "UPDATE ponderado SET numAcciones = numAcciones - '" + this.getCantidad() + "'  WHERE idUsuario = '" + this.getIdUsuario() + "' AND nombreEmpresa = '" + this.getNombreEmpresa() + "' AND idPartida = '" + this.getIdPartida() + "';";
        int num = 0;

        num = updateBD(query);

        return num;
    }

    public double sumatorio() {
        String query = "SELECT SUM(gan_per)\n"
                + "FROM ventas\n"
                + "WHERE idUsuario = '" + this.getIdUsuario() + "' AND idPartida = '" + this.getIdPartida() + "';";
        ResultSet rs = null;
        double resultado = 0;
        try {
            rs = selectBD(query);

            while (rs.next()) {
                resultado = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println("ERROR: " + ex.getMessage());
                }
            }
        }
        
        return resultado;
    }
}
