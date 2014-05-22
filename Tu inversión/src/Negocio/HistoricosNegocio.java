package Negocio;

import ModeloDatos.Historicos;
import ModeloDatos.HistoricosIbex;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HistoricosNegocio extends DefaultHandler {

    private String car;
    private int contador = 0;
    private int contadorIbex = 0;

    private Historicos historicos;
    private HistoricosIbex historicosIbex;

    private boolean existen = false;
    private boolean antesHora = false;

    private int id = 0;
    private boolean flag = false;
    private boolean flagIbex = false;
    private String fecha;
    private String hora;
    private final DecimalFormat df = new DecimalFormat("#,###.#");

    public HistoricosNegocio() {
        super();

        historicos = new Historicos();
        historicosIbex = new HistoricosIbex();
    }

    @Override
    public void endDocument() {
        if (antesHora) {
            JOptionPane.showMessageDialog(null, "No se pueden crear los históricos hasta el cierre de la Bolsa.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (existen) {
                JOptionPane.showMessageDialog(null, "Los históricos ya están actualizados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Actualizado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void endElement(String uri, String nombre, String qName) {
        hora = "Cierre";
        if (nombre.equals("td")) {
            if (car.equals("®")) {
                flagIbex = true;
            }

            if (contadorIbex < 7 && flagIbex) {
                switch (contadorIbex) {
                    case 2:
                        try {
                            historicosIbex.setUltimo(Double.parseDouble(df.parse(car).toString()));
                        } catch (ParseException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            historicosIbex.setDiferencia(Double.parseDouble(df.parse(car).toString()));
                        } catch (ParseException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            historicosIbex.setMaximo(Double.parseDouble(df.parse(car).toString()));
                        } catch (ParseException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            historicosIbex.setMinimo(Double.parseDouble(df.parse(car).toString()));
                        } catch (ParseException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }
                        break;
                    case 6:
                        String dia = car.substring(0, 2);
                        String mes = car.substring(3, 5);
                        String año = car.substring(6, 10);
                        fecha = año + "/" + mes + "/" + dia;

                        historicosIbex.setFecha(fecha);
                        break;
                }
                contadorIbex++;
            } else {
                if (flagIbex) {
                    if (hora.equals("Cierre")) {
                        if (historicosIbex.comprobarBD()) {
                            historicosIbex.insertarBD();
                        } else {
                            historicosIbex.update();
                        }
                    } else {
                        antesHora = true;
                    }
                }
                flagIbex = false;
            }

            if (car.equals("ABERTIS SE.A")) {
                flag = true;
            }

            if (contador < 8 && flag) {
                switch (contador) {
                    case 0:
                        historicos.setNombreEmpresa(car);
                        break;
                    case 1:
                        try {
                            historicos.setUltimoValor(Double.parseDouble(df.parse(car).toString()));
                        } catch (ParseException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }
                        break;
                }
                contador++;
            } else {
                if (car.contains(":")) {
                    hora = car;
                }
                historicos.setFecha(fecha);
                if (contador == 8) {
                    if (hora.equals("Cierre")) {
                        if (historicos.comprobarBD()) {
                            historicos.insertarBD();
                        } else {
                            existen = true;
                        }
                    } else {
                        antesHora = true;
                    }
                    contador = 0;
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        car = new String(ch, inicio, longitud);
    }
}
