package Negocio;

import ModeloDatos.Ibex;
import java.text.DecimalFormat;
import java.text.ParseException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <b>Clase encargada leer fichero xml y insertar datos obtenidos en nuestra
 * base de datos</b>
 *
 * @author Juan Viñes Bordera
 */
public class GestionEventos extends DefaultHandler {

    private String car;
    private int contador = 0;

    private Ibex ibex = new Ibex();

    private int contaEmpresas = 1;
    private boolean flag = false;
    private boolean flagExiste = false;
    private DecimalFormat df = new DecimalFormat("#,###.#");
    private boolean flagIbex = false;
    private int contadorIbex = 0;
    private String hora;

    public GestionEventos() {
        super();
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
                    case 0:
                        ibex.setId(contaEmpresas);
                        ibex.setNombreEmpresa("IBEX");

                        contaEmpresas++;
                        break;

                    case 2:
                        try {
                            ibex.setUltimo(Double.parseDouble(df.parse(car).toString()));
                        } catch (ParseException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }
                        break;

                    case 3:
                        ibex.setDiferencia(car);
                        break;

                    case 4:
                        ibex.setMaximo(car);
                        break;

                    case 5:
                        ibex.setMinimo(car);
                        break;
                    case 6:
                        ibex.setVolumen("0.0");
                        ibex.setEfectivo("0.0");
                        ibex.setFecha(car);
                        break;
                }
                contadorIbex++;
            } else {
                if (flagIbex) {
                    if (flagExiste) {
                        ibex.setHora(hora);
                        ibex.updateBD();
                    } else {
                        ibex.setHora(hora);
                        ibex.insertarBD();
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
                        ibex.setId(contaEmpresas);
                        ibex.setNombreEmpresa(car);
                        contaEmpresas++;
                        break;

                    case 1:
                        try {
                            ibex.setUltimo(Double.parseDouble(df.parse(car).toString()));
                        } catch (ParseException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }
                        break;

                    case 2:
                        ibex.setDiferencia(car);
                        break;

                    case 3:
                        ibex.setMaximo(car);
                        break;

                    case 4:
                        ibex.setMinimo(car);
                        break;

                    case 5:
                        ibex.setVolumen(car);
                        break;

                    case 6:
                        ibex.setEfectivo(car);
                        break;
                    case 7:
                        ibex.setFecha(car);
                        break;
                }
                contador++;
            } else {
                if (car.contains(":")) {
                    hora = car;
                }

                if (flagExiste && contador == 8) {
                    ibex.setHora(hora);
                    ibex.updateBD();
                    contador = 0;
                } else {
                    if (contador == 8) {
                        ibex.setHora(hora);
                        ibex.insertarBD();
                        contador = 0;
                    }
                }
            }
        }
    }

    @Override
    public void startDocument() {
        flagExiste = ibex.selectBD();
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        car = new String(ch, inicio, longitud);
    }
}