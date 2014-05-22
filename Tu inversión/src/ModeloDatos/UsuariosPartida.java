package ModeloDatos;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class UsuariosPartida extends Crud{

    private int idUsuario;
    private int idPartida;
    private double saldo;

    public UsuariosPartida() {
    }

    public UsuariosPartida(int idUsuario, int idPartida, double saldo) {
        this.idUsuario = idUsuario;
        this.idPartida = idPartida;
        this.saldo = saldo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void insertarBD() {
        String query = "INSERT INTO userspartida VALUES (?,?,?,?)";
        ArrayList array = new ArrayList();

        array.add(maximo("userspartida", "id") + 1);
        array.add(this.getIdUsuario());
        array.add(this.getIdPartida());
        array.add(this.getSaldo());
        
        insertatPSBD(query, array);
    }
}
