
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {
    
    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String portService;
    private static String driver;
    private static ResourceBundle propertiesDB;
    
    public static void main(String [] args){
    
        Connection conn = null;
        
        try {
            conn = getConnection();
            System.out.println("Conexión Exitosa!");
        } catch (SQLException n){
            System.out.println("Conexión Erronea!");
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m){
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, m, null);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
    if(propertiesDB == null){
        propertiesDB = ResourceBundle.getBundle("BD");
        ipAddress = propertiesDB.getString("ip_address");
        dbName = propertiesDB.getString("db_name");
        user = propertiesDB.getString("user");
        password = propertiesDB.getString("password");
        portService = propertiesDB.getString("port_service");
        driver = propertiesDB.getString("driver");
        }
    try {
        Class.forName(driver);
        } catch(ClassNotFoundException e){
        System.err.println(e.getMessage());
        }
    return  DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + portService + "/" + dbName, user, password);
    }
    
}
