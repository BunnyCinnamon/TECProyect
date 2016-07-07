package Modelo;

import Classes.Beans.AdministradorBean;
import Classes.Beans.SocioBean;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IniciarSesionDAO {

    Connection conn;
    ResultSet rs;

    private final String SQL_CHECK_PASSWORD_ADMIN = "SELECT IdAdministrador FROM Administrador WHERE Usuario=? AND Contraseña=?";
    private final String SQL_CHECK_PASSWORD_SOCIO = "SELECT * FROM Socio WHERE Usuario=? AND Constraseña=?";


    public boolean CheckPasswordAdmin(AdministradorBean adm) {
        boolean CORRECT = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_CHECK_PASSWORD_ADMIN);
            prs.setString(1, adm.getUsuario());
            prs.setString(2, adm.getContraseña());
            rs = prs.executeQuery();
            if (rs.next()) {
                adm.setidAdministrador(rs.getInt(1));
                CORRECT = true;
                rs.close();
                prs.close();
            }

        } catch (SQLException n) {
            Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return CORRECT;
    }
    
    public boolean CheckPasswordSocio(SocioBean adm) {
        boolean CORRECT = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_CHECK_PASSWORD_SOCIO);
            prs.setString(1, adm.getUsuario());
            prs.setString(2, adm.getContraseña());
            rs = prs.executeQuery();
            if (rs.next()) {
                adm.setIdUsuario(rs.getInt(1));
                CORRECT = true;
                rs.close();
                prs.close();
            }

        } catch (SQLException n) {
            Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return CORRECT;
    }
}
