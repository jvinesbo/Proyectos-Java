package ModeloDatos;

import Presentacion.Login;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Juan
 */
public class Sesiones extends Crud {

    private String usuario;
    private String contrasenya;

    public Sesiones() {
    }

    public Sesiones(String usuario, String contrasenya) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int iniciarSesion() {
        String queryLogin = "SELECT nombreLogin,contrasenya FROM usuarios WHERE nombreLogin = '" + this.getUsuario() + "' AND contrasenya = sha1('" + this.getContrasenya() + "')";
        int id = -1;
        ResultSet rs = null;

        try {
            rs = selectBD(queryLogin);

            if (rs.first()) {
                String querySelect = "SELECT id FROM usuarios WHERE nombreLogin = '" + this.getUsuario() + "'";

                rs = selectBD(querySelect);

                while (rs.next()) {
                    id = Integer.parseInt(String.valueOf(rs.getObject("id")));
                }

                String query = "SELECT * FROM sesionesiniciadas WHERE idUsuario = '" + id + "'";

                rs = selectBD(query);

                if (rs.first()) {
                    id = -1;
                    JOptionPane.showMessageDialog(null, "Este usuario ya tiene una sesión iniciada.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    query = "INSERT INTO sesionesiniciadas VALUES ('" + (maximo("sesionesiniciadas", "id") + 1) + "', '" + id + "');";
                    insertarBD(query);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
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

        return id;
    }

    public void cerrarSesion(int idUsuario, JRootPane rootPane, boolean aux, JFrame frame) {
        String query = "DELETE FROM sesionesiniciadas WHERE sesionesiniciadas.idUsuario = '" + idUsuario + "';";

        int eleccion = -1;

        eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Desea salir?");

        if (eleccion == 0) {
            updateBD(query);
        }

        if (aux && eleccion == 0) {
            MysqlConnect.getDbCon().cerrarConexiones();
            System.exit(0);
        } else {
            if (eleccion == 0) {
                frame.dispose();
                frame.setVisible(false);
                Login login = new Login();
                login.setVisible(true);
            }
        }
    }
    
    public void cerrar(final JRootPane rootPane, final JFrame frame, final int idUsuario) {
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                cerrarSesion(idUsuario, rootPane, true, frame);
            }
        });
    }
}
