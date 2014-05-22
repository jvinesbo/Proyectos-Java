package Negocio;

public class HiloBolsa extends Thread {
    
    private Utiles utiles;

    public HiloBolsa() {
        utiles = new Utiles();
    }
    
    @Override
    public void run() {
        while (true) {
            utiles.leerWeb();
            try {
                //esperar 5 minutos
                Thread.sleep(300000);
            } catch (InterruptedException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }
    }
}
