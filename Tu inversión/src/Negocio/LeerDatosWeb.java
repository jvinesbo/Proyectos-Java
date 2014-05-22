package Negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public final class LeerDatosWeb {

    private URL url;

    public LeerDatosWeb(String pagina) {
        try {
            url = new URL(pagina);
            lecturaWeb();
        } catch (MalformedURLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }

    public void lecturaWeb() {
        InputStreamReader reader;
        try {
            reader = new InputStreamReader(url.openStream());
            PrintWriter escribir = new PrintWriter(new File("web.txt"));
            BufferedReader in = new BufferedReader(reader);
            String inputLine;
            String fichero = "";
            while ((inputLine = in.readLine()) != null) {
                fichero += inputLine + "\n";
            }
            in.close();
            escribir.println(fichero);
            escribir.close();
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }
}
