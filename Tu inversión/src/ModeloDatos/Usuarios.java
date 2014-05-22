package ModeloDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Usuarios extends Crud {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String fechaNacimiento;
    private String dni;
    private String telefono;
    private String email;
    private String tipoVia;
    private String nombreVia;
    private String numeroVia;
    private String poblacion;
    private String provincia;
    private String pais;
    private String nombreLogin;
    private String contrasenya;

    public Usuarios() {
    }

    public Usuarios(String nombreLogin, String contrasenya) {
        this.nombreLogin = nombreLogin;
        this.contrasenya = contrasenya;
    }

    public Usuarios(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, String dni, String telefono, String email, String tipoVia, String nombreVia, String numeroVia, String poblacion, String provincia, String pais, String nombreLogin, String contrasenya) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numeroVia = numeroVia;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
        this.nombreLogin = nombreLogin;
        this.contrasenya = contrasenya;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(String numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreLogin() {
        return nombreLogin;
    }

    public void setNombreLogin(String nombreLogin) {
        this.nombreLogin = nombreLogin;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int insertarBD() {
        String query = "INSERT INTO usuarios VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sha1(?))";

        ArrayList<Object> array = new ArrayList();

        array.add(maximo("usuarios", "id") + 1);
        array.add(this.getNombre());
        array.add(this.getPrimerApellido());
        array.add(this.getSegundoApellido());
        array.add(this.getFechaNacimiento());
        array.add(this.getDni());
        array.add(this.getTelefono());
        array.add(this.getEmail());
        array.add(this.getTipoVia());
        array.add(this.getNombreVia());
        array.add(this.getNumeroVia());
        array.add(this.getPoblacion());
        array.add(this.getProvincia());
        array.add(this.getPais());
        array.add(this.getNombreLogin());
        array.add(this.getContrasenya());

        return insertatPSBD(query, array);
    }

    public String buscarUsuario(int idUsuario) {
        String query = "SELECT nombreLogin FROM usuarios WHERE id != '" + idUsuario + "' AND nombreLogin = '" + this.getNombreLogin() + "'";
        String resultado = "";
        ResultSet rs = null;

        try {
            rs = selectBD(query);

            if (rs.first()) {
                resultado = String.valueOf(rs.getObject("nombreLogin"));

                int eleccion = JOptionPane.showConfirmDialog(null, "USUARIO ENCONTRADO \n¿Desea añadirlo a la lista?");

                if (eleccion == 0) {
                    return resultado;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado en nuesta Base de Datos");
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
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
}
