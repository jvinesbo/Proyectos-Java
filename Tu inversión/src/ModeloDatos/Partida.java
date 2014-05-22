package ModeloDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Partida extends Crud {

    private String nombre;
    private int idUsuario;
    private double cantidad;
    private String fechaInicio;
    private String fechaFin;
    private int terminada;

    public Partida() {
    }

    public Partida(String nombre, int idUsuario, double cantidad, String fechaInicio, String fechaFin, int terminada) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.cantidad = cantidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.terminada = terminada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTerminada() {
        return terminada;
    }

    public void setTerminada(int terminada) {
        this.terminada = terminada;
    }

    public int obtenerId(String partida) {
        int id = 0;
        String query = "SELECT id FROM partida WHERE nombre = '" + partida + "' AND id != 0";
        ResultSet rs = null;

        rs = selectBD(query);
        try {
            while (rs.next()) {
                id = rs.getInt("id");
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

        return id;
    }

    public boolean comprobarPartidasTerminadas(String nombrePartida, int idUsuario) {
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        String fechaSistema = formateador.format(fecha);

        Historicos historicos = new Historicos();

        String query = "SELECT * \n"
                + "FROM partida \n"
                + "WHERE nombre = '" + nombrePartida + "';";

        ResultSet rs = null;

        rs = selectBD(query);

        boolean resultado = false;
        int idPartida = 0;
        Date fechaFin = null;
        String fechaFinal = "";

        try {

            Date fechaSistemaDate = formateador.parse(fechaSistema);

            while (rs.next()) {
                fechaFin = rs.getDate("fechaFin");
                idPartida = rs.getInt("id");
            }

            if (fechaSistemaDate.before(fechaFin)) {
                //sigue la partida
                resultado = true;
            } else {
                if (fechaFin.before(fechaSistemaDate)) {
                    // partida terminada
                    query = "SELECT * FROM historicos WHERE fecha = '" + fechaFin + "'";

                    rs = selectBD(query);
                    // esto lo hacemos para comprobar que en esa fecha tenemos datos en los históricos.
                    if (rs.first()) {
                        fechaFinal = fechaFin.toString();
                    } else {
                        fechaFinal = historicos.comprobarDatosHistoricos(fechaFin.toString());
                    }

                    query = "UPDATE partida SET terminada = 1 WHERE nombre = '" + nombrePartida + "';";
                    updateBD(query);
                    resultado = false;

                    // venta de todas las acciones de la partida.
                    query = "SELECT * FROM ponderado WHERE idUsuario = '" + idUsuario + "' AND idPartida = '" + idPartida + "'";

                    SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
                    String fechaActual = form.format(fecha);
                    fechaActual = fechaActual.replace('/', '-');
                    String nombreEmpresa = "";
                    int numAcciones = 0;
                    double precioHistorico = 0;
                    double total = 0;

                    rs = selectBD(query);

                    ResultSet rsAux = null;

                    // nos faltaria comprobar si en ese día de fin de partida tenemos datos guardados.
                    while (rs.next()) {
                        nombreEmpresa = rs.getString("nombreEmpresa");
                        numAcciones = rs.getInt("numAcciones");

                        query = "SELECT * FROM historicos WHERE nombreEmpresa = '" + nombreEmpresa + "' AND fecha = '" + fechaFinal + "'";

                        rsAux = selectBD(query);

                        while (rsAux.next()) {
                            precioHistorico = rsAux.getDouble("ultimoValor");
                        }

                        if (precioHistorico > 0) {
                            total = numAcciones * precioHistorico;

                            //actualizamos el saldo del usuario
                            query = "UPDATE userspartida SET saldo = saldo + '" + total + "' WHERE idPartida = '" + idPartida + "' AND idUsuario = '" + idUsuario + "'";
                            updateBD(query);

                            //eliminamos la fila del ponderado ya que la partida esta terminada y las acciones vendidas.
                            query = "DELETE FROM ponderado WHERE idPartida = '" + idPartida + "' AND idUsuario = '" + idUsuario + "'";
                            updateBD(query);

                            //insert en la tabla ventas.
                            query = "INSERT INTO ventas VALUES('" + (maximo("ventas", "id") + 1) + "', '" + idUsuario + "',\n"
                                    + " '" + fechaActual + "', '" + nombreEmpresa + "', '" + numAcciones + "', '" + precioHistorico + "', '" + total + "', '" + 0 + "', '" + idPartida + "');";
                            insertarBD(query);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ultimo día para la partida.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (ParseException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }

        return resultado;
    }

    public String saldoDisponible(int idUsuario) {
        String query = "";
        int idPartida = 0;
        String saldo = "";
        ResultSet rs = null;

        query = "SELECT id FROM partida WHERE nombre = '" + this.getNombre() + "'";

        try {
            rs = selectBD(query);

            while (rs.next()) {
                idPartida = rs.getInt("id");
            }

            query = "SELECT saldo FROM userspartida WHERE idPartida = '" + idPartida + "' AND idUsuario = '" + idUsuario + "';";

            rs = selectBD(query);

            while (rs.next()) {
                saldo = String.valueOf(rs.getDouble("saldo"));
            }

        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }

        return saldo;
    }

    public int habilitarCompraVenta() {
        String query = "SELECT terminada \n"
                + "FROM partida\n"
                + "WHERE nombre = '" + this.getNombre() + "';";

        ResultSet rs = selectBD(query);
        int terminada = -1;
        try {
            while (rs.next()) {
                terminada = rs.getInt("terminada");
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }

        return terminada;
    }

    public String fechaFinal() {
        String query = "SELECT DAY(fechaFin), MONTH(fechaFin), YEAR(fechaFin)\n"
                + "FROM partida\n"
                + "WHERE partida.nombre = '" + this.getNombre() + "';";

        ResultSet rs = selectBD(query);

        String fecha = "";

        try {
            while (rs.next()) {
                fecha += rs.getString(1) + " - ";
                fecha += rs.getString(2) + " - ";
                fecha += rs.getString(3);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }

        return fecha;
    }

    public boolean nombrePartida(String query) throws SQLException {
        ResultSet rs = selectBD(query);

        return rs.first();
    }

    public int seleccionDB(String query) {
        ResultSet rs = selectBD(query);
        int id = -1;
        try {
            while (rs.next()) {
                id = Integer.parseInt(String.valueOf(rs.getObject("id")));
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        return id;
    }

    public void insertarBD(int numJugadores) {
        String query = "INSERT INTO partida VALUES (?,?,?,?,?,?,?)";
        ArrayList array = new ArrayList();

        array.add(maximo("partida", "id") + 1);
        array.add(this.getNombre());
        array.add(this.getIdUsuario());
        array.add(this.getCantidad());
        array.add(this.getFechaInicio());
        array.add(this.getFechaFin());
        array.add(this.getTerminada());

        insertatPSBD(query, array);
    }
}
