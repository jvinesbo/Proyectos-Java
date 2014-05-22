package Presentacion;

import ModeloDatos.Propiedades;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

public class Proyecto {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
        
        Propiedades propiedades = new Propiedades();
        propiedades.leerArchivo();
    }
}
