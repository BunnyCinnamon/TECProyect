
package Modelo;

import Classes.Beans.AdministradorBean;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IniciarSesionDAO {

    Connection conn;
    
    private final String SQL_CHECK_PASSWORD="SELECT u.id FROM usuario u WHERE u.usuario=? and u.contraseña=?";
    
    public boolean CheckPassword(AdministradorBean adm) {
        boolean CORRECT = false;
        try{
        conn = Connexion.getConnection();
        PreparedStatement prs = conn.prepareStatement(SQL_CHECK_PASSWORD);
        prs.setString(1, adm.getUsuario());
        prs.setString(2, adm.getContraseña());
        CORRECT = prs.executeUpdate() == 1;
        prs.close();
        } catch(SQLException n){
        Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try{
                conn.close();
            } catch (SQLException m){
                Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
    return CORRECT;
    }
    
}
