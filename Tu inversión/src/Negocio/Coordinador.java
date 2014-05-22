package Negocio;

import Presentacion.CompraVenta;
import Presentacion.CrearJuego;
import Presentacion.GestionarCarteraParticular;
import Presentacion.Ibex;
import Presentacion.ListaPartidas;
import Presentacion.Login;
import Presentacion.NewUser;
import Presentacion.Principal;
import Presentacion.UsuariosLogeados;
import javax.swing.JFrame;

/**
 *
 * @author Juan
 */
public class Coordinador {

    private CrearJuego crearJuego;
    private Login login;
    private Ibex ibex;
    private NewUser new_user;
    private Principal principal;
    private UsuariosLogeados usuariosLogeados;
    private CompraVenta compra_Venta;
    private GestionarCarteraParticular gestionarCarteraParticular;
    private ListaPartidas listaPartidas;

    public void cambiarVista(JFrame frame, String nuevoFrame,int idUsuario, String nombrePartida) {
        frame.dispose();
        frame.setVisible(false);

        switch (nuevoFrame) {
            case "CrearJuego":
                crearJuego = new CrearJuego(idUsuario);
                crearJuego.setVisible(true);
                break;
            case "Login":
                login = new Login();
                login.setVisible(true);
                break;
            case "Ibex":
                ibex = new Ibex(idUsuario);
                ibex.setVisible(true);
                break;
            case "NewUser":
                new_user = new NewUser();
                new_user.setVisible(true);
                break;
            case "Principal":
                principal = new Principal();
                principal.setVisible(true);
                break;
            case "UsuariosLogeados":
                usuariosLogeados = new UsuariosLogeados(idUsuario);
                usuariosLogeados.setVisible(true);
                break;
            case "CompraVenta":
                compra_Venta = new CompraVenta(idUsuario, nombrePartida);
                compra_Venta.setVisible(true);
                break;
            case "GestionarCarteraParticular":
                gestionarCarteraParticular = new GestionarCarteraParticular(idUsuario);
                gestionarCarteraParticular.setVisible(true);
                break;
            case "ListaPartidas":
                listaPartidas = new ListaPartidas(idUsuario);
                listaPartidas.setVisible(true);
                break;
        }
    }
}
