package ModeloDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Ibex extends Crud {

    private int id;
    private String nombreEmpresa;
    private double ultimo;
    private String diferencia;
    private String maximo;
    private String minimo;
    private String volumen;
    private String efectivo;
    private String fecha;
    private String hora;

    public Ibex() {
    }

    public Ibex(int id, String nombreEmpresa, double ultimo, String diferencia, String maximo, String minimo, String volumen, String efectivo, String fecha, String hora) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.ultimo = ultimo;
        this.diferencia = diferencia;
        this.maximo = maximo;
        this.minimo = minimo;
        this.volumen = volumen;
        this.efectivo = efectivo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public double getUltimo() {
        return ultimo;
    }

    public void setUltimo(double ultimo) {
        this.ultimo = ultimo;
    }

    public String getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(String diferencia) {
        this.diferencia = diferencia;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(String efectivo) {
        this.efectivo = efectivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void insertarBD() {
        String query = "INSERT INTO ibex VALUES(?,?,?,?,?,?,?,?,?,?)";

        ArrayList array = new ArrayList();

        array.add(this.getId());
        array.add(this.getNombreEmpresa());
        array.add(this.getUltimo());
        array.add(this.getDiferencia());
        array.add(this.getMaximo());
        array.add(this.getMinimo());
        array.add(this.getVolumen());
        array.add(this.getEfectivo());
        array.add(this.getFecha());
        array.add(this.getHora());

        insertatPSBD(query, array);
    }

    public boolean selectBD() {
        String query = "SELECT * FROM ibex";
        boolean aux = false;
        ResultSet rs = selectBD(query);
        try {
            if (rs.first()) {
                aux = true;
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        return aux;
    }

    public void updateBD() {
        String query = "UPDATE ibex\n"
                + "SET nombreEmpresa = ?, ultimo = ?, diferencia = ?,\n"
                + "maximo = ?, minimo = ?, volumen = ?, efectivo = ?, fecha = ?, hora = ?\n"
                + "WHERE id = ?;";
        
        ArrayList array = new ArrayList();
        
        array.add(this.getNombreEmpresa());
        array.add(this.getUltimo());
        array.add(this.getDiferencia());
        array.add(this.getMaximo());
        array.add(this.getMinimo());
        array.add(this.getVolumen());
        array.add(this.getEfectivo());
        array.add(this.getFecha());
        array.add(this.getHora());
        array.add(this.getId());
        
        updatePSBD(query, array);
    }

    @Override
    public String toString() {
        return "Ibex{" + "id=" + id + ", nombreEmpresa=" + nombreEmpresa + ", ultimo=" + ultimo + ", diferencia=" + diferencia + ", maximo=" + maximo + ", minimo=" + minimo + ", volumen=" + volumen + ", efectivo=" + efectivo + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
}
