package ModeloDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */


public class Crud {

    public Crud() {
    }
    
    public int insertarBD(String query){
        int num = MysqlConnect.getDbCon().executeUpdateStatement(query);
        
        return num;
    }
    
    public int insertatPSBD(String query, ArrayList<Object> array){
        int num = 0;
        try {
            num = MysqlConnect.getDbCon().executeUpdatePreparedstatement(query, array);
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
        
        return num;
    }
    
    public int updatePSBD(String query, ArrayList<Object> array){
        int num = 0;
        try {
            num = MysqlConnect.getDbCon().executeUpdatePreparedstatement(query, array);
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
        
        return num;
    }
    
    public ResultSet selectBD(String query){
        ResultSet rs = MysqlConnect.getDbCon().executeQueryStatement(query);
        
        return rs;
    }
    
    public int maximo(String tabla, String columna) {
        int max = 0;
        String query = "SELECT " + columna + " FROM " + tabla;
        ResultSet rs = null;

        try {
            rs = MysqlConnect.getDbCon().executeQueryStatement(query);

            while (rs.next()) {
                if (max < Integer.parseInt(String.valueOf(rs.getObject("id")))) {
                    max = Integer.parseInt(String.valueOf(rs.getObject("id")));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error: 10 " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error:  " + ex.getMessage());
            }
        }

        return max;
    }
    
    public Connection getCon(){
        return MysqlConnect.getDbCon().getCon();
    }
    
    public int updateBD(String query){
        return MysqlConnect.getDbCon().executeUpdateStatement(query);
    }
    
//    public void cerrarConexion(){
//        MysqlConnect.getDbCon().cerrarConexiones();
//    }
}
