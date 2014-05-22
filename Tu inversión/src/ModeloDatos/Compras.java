package ModeloDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Compras extends Crud {

    private int idUsuario;
    private String fecha;
    private String nombreEmpresa;
    private int cantidad;
    private double precioCompra;
    private double total;
    private int idPartida;

    public Compras() {
    }

    public Compras(int idUsuario, int idPartida) {
        this.idUsuario = idUsuario;
        this.idPartida = idPartida;
    }

    public Compras(int idUsuario, String fecha, String nombreEmpresa, int cantidad, double precioCompra, double total, int idPartida) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.nombreEmpresa = nombreEmpresa;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.total = total;
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

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int insert() {
        String query = "INSERT INTO compras VALUES(?,?,?,?,?,?,?,?);";
        ArrayList<Object> array = new ArrayList<>();
        int num = 0;

        array.clear();
        array.add(maximo("compras", "id") + 1);
        array.add(this.getIdUsuario());
        array.add(this.getFecha());
        array.add(this.getNombreEmpresa());
        array.add(this.getCantidad());
        array.add(this.getPrecioCompra());
        array.add(this.getTotal());
        array.add(this.getIdPartida());

        num = insertatPSBD(query, array);

        return num;
    }

    public Ponderado selectDB() {
        String query = "SELECT numAcciones,precio FROM ponderado WHERE nombreEmpresa = '" + this.getNombreEmpresa() + "' AND idUsuario = '" + this.getIdUsuario() + "'AND idPartida = '" + this.getIdPartida() + "';";
        Ponderado ponderado = new Ponderado();
        ResultSet rs = null;

        rs = selectBD(query);
        try {
            if (rs.first()) {
                rs = selectBD(query);
                while (rs.next()) {
                    ponderado.setNumAcciones(rs.getInt("numAcciones"));
                    ponderado.setPrecio(rs.getDouble("precio"));
                }
            } else {
                ponderado.setNumAcciones(0);
                ponderado.setPrecio(0);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            ponderado.setNombre(this.getNombreEmpresa());
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println("ERROR: " + ex.getMessage());
                }
            }
        }

        return ponderado;
    }

    public double sumatorio() {
        String query = "SELECT SUM(total)\n"
                + "FROM compras\n"
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
        }
        return resultado;
    }

    public double comprobarSaldo() {
        String query = "SELECT saldo\n"
                + "FROM usersPartida \n"
                + "WHERE idUsuario = '" + this.getIdUsuario() + "' AND idPartida = '" + this.getIdPartida() + "'";

        ResultSet rs = null;
        double resultado = 0;
        try {
            rs = selectBD(query);

            while (rs.next()) {
                resultado = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
        
        return resultado;
    }
    
    public void actualizarSaldo(){
        String query = "UPDATE userspartida\n" +
                       "SET saldo = saldo - '" + this.getTotal() + "'\n" +
                       "WHERE idUsuario = '" + this.getIdUsuario() + "' AND idPartida = '" + this.getIdPartida() + "'";
    
        updateBD(query);
    }
}
