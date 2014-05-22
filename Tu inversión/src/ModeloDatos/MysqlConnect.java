package ModeloDatos;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Juan
 */
public final class MysqlConnect {

    public Connection con;
    private Statement stm;
    private ResultSet rs;
    public static MysqlConnect db;

    private MysqlConnect() {
        String ip = "";
        String userName = "";
        String password = "";
        String url = "";
        String dbName = "";
        String driver = "";
        try {
            Properties propiedades = new Properties();
            Propiedades p = new Propiedades();
            propiedades.load(new FileInputStream("Archivo.properties"));

            ip = propiedades.getProperty("ip");
            userName = propiedades.getProperty("userName");
            password = propiedades.getProperty("password");
            url = propiedades.getProperty("url");
            dbName = propiedades.getProperty("dbName");
            driver = propiedades.getProperty("driver");
            
            ip = p.desencriptar("IP", ip);
            password = p.desencriptar("PASSWORD", password);
            userName = p.desencriptar("USER", userName);
        } catch (FileNotFoundException e) {
            System.err.println("Error, El archivo no exite");
        } catch (IOException e) {
            System.err.println("Error, No se puede leer el archivo");
        }

        try {
            Class.forName(driver).newInstance();
            this.con = (Connection) DriverManager.getConnection(url + ip + dbName, userName, password);
            System.out.println("CREADA");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException sqle) {
            System.err.println("ERROR: " + sqle.getMessage());
        }
    }

    public static synchronized MysqlConnect getDbCon() {
        if (db == null) {
            db = new MysqlConnect();
        }
        return db;

    }

    public java.sql.Connection getCon() {
        return con;
    }

    public int executeUpdateStatement(String query) {
        int num = -1;
        try {
            stm = con.createStatement();
            num = stm.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("ERROR: 3 " + ex.getMessage());
        }

        return num;
    }

    public ResultSet executeQueryStatement(String query) {
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("ERROR: 4 " + ex.getMessage());
        }

        return rs;
    }

    public int executeUpdatePreparedstatement(String query, ArrayList array) throws SQLException {
        PreparedStatement pst = con.prepareStatement(query);

        for (int i = 0; i < array.size(); i++) {
            Object o = array.get(i);
            Class classObject = o.getClass();
            String className = classObject.getName();

            if (className.equals("java.lang.String")) {
                pst.setString(i + 1, array.get(i).toString());
            } else {
                if (className.equals("java.lang.Integer")) {
                    pst.setInt(i + 1, Integer.parseInt(array.get(i).toString()));
                } else {
                    pst.setDouble(i + 1, Double.parseDouble(array.get(i).toString()));
                }
            }
        }

        int num = pst.executeUpdate();

        return num;
    }

    public ResultSet executeQueryPreparedstatement(String query, ArrayList array) {
        try {
            PreparedStatement pst = con.prepareStatement(query);

            for (int i = 0; i < array.size(); i++) {
                Object o = array.get(i);
                Class classObject = o.getClass();
                String className = classObject.getName();

                if (className.equals("java.lang.String")) {
                    pst.setString(i + 1, array.get(i).toString());
                } else {
                    if (className.equals("java.lang.Integer")) {
                        pst.setInt(i + 1, Integer.parseInt(array.get(i).toString()));
                    } else {
                        pst.setDouble(i + 1, Double.parseDouble(array.get(i).toString()));
                    }
                }
            }

            rs = pst.executeQuery();
        } catch (SQLException | NumberFormatException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        return rs;
    }

    public void cerrarConexiones() {
        System.out.println("\tCERRADA");
        try {
            if (stm != null) {
                stm.close();
            }

            if (rs != null) {
                rs.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }
}
