package ModeloDatos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class HistoricosIbex extends Crud{

    private double ultimo;
    private double diferencia;
    private double maximo;
    private double minimo;
    private String fecha;

    public HistoricosIbex() {
    }

    public HistoricosIbex(double ultimo, double diferencia, double maximo, double minimo, String fecha) {
        this.ultimo = ultimo;
        this.diferencia = diferencia;
        this.maximo = maximo;
        this.minimo = minimo;
        this.fecha = fecha;
    }

    public double getUltimo() {
        return ultimo;
    }

    public void setUltimo(double ultimo) {
        this.ultimo = ultimo;
    }

    public double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(double diferencia) {
        this.diferencia = diferencia;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void insertarBD(){
        String query = "INSERT INTO historicos_ibex VALUES('" + (maximo("historicos_ibex", "id") + 1) + "','" + this.getUltimo() + "','" + this.getDiferencia() + "','" + this.getMaximo() + "','" + this.getMinimo() + "','" + this.getFecha() + "');";
        
        insertarBD(query);
    }
    
    public boolean comprobarBD() {
        String query = "SELECT id FROM historicos_ibex WHERE fecha = '" + this.getFecha() + "'";
        boolean aux = false;
        ResultSet rs = null;
        try {
            rs = selectBD(query);
            if (rs.first()) {
                aux = false;
            } else{
                aux = true;
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println("ERROR: " + ex.getMessage());
                }
            }
        }
        return aux;
    }

    public void update() {
        String query = "UPDATE historicos_ibex SET ultimo = '" + this.getUltimo() + "', diferencia = '" + this.getDiferencia() + "', maximo = '" + this.getMaximo() + "', minimo = '" + this.getMinimo() + "' WHERE fecha = '" + this.getFecha() + "'";
        
        updateBD(query);
    }
}
