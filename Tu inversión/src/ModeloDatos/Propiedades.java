package ModeloDatos;

import Presentacion.Configuracion;
import Presentacion.Principal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Juan
 */


public class Propiedades {
    public void leerArchivo() {
        try {
            Properties propiedades = new Properties();

            propiedades.load(new FileInputStream(new File("Archivo.properties")));

            String ip = propiedades.getProperty("ip");
            String username = propiedades.getProperty("userName");
            String password = propiedades.getProperty("password");

            if (username.isEmpty() || ip.isEmpty()) {
                Configuracion configuracionVista = new Configuracion(null, true, false);
                configuracionVista.setVisible(true);
            } else{
                Principal p = new Principal();
                p.setVisible(true);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error, El archivo no exite. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error, No se puede leer el archivo");
        }
    }
    
    public String encriptar(String clave, String text){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(clave);

        String myEncryptedText = textEncryptor.encrypt(text);
        
        return myEncryptedText;
    }
    
    public String desencriptar(String clave, String text){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(clave);
        
        String plainText = textEncryptor.decrypt(text);
        
        return plainText;
    }
}
