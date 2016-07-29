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
    private final String SQL_CHECK_PASSWORD_SOCIO = "SELECT * FROM Socio WHERE Usuario=? AND Contraseña=?";

    /**
     * Busca un Administrador en la base de datos con los datos: usuario y
     * contraseña, en el Bean. Consigue el id del Administrador y lo almacena en
     * el Bean.
     *
     * @param adm // Contiene el usuario y contraseña del Administrador
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
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
            }
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return CORRECT;
    }

    /**
     * Busca un Socio en la base de datos con los datos: usuario y contraseña,
     * en el Bean. Consigue todos los datos del Socio y lo almacena en el Bean.
     *
     * @param adm // Contiene el usuario y contraseña del Socio
     * @return // Regresa un Objeto con el Bean del Socio junto con true si es
     * exitosa y false si ocurre un error
     */
    public Object[] CheckPasswordSocio(SocioBean adm) {
        boolean CORRECT = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_CHECK_PASSWORD_SOCIO);
            prs.setString(1, adm.getUsuario());
            prs.setString(2, adm.getContraseña());
            rs = prs.executeQuery();
            if (rs.next()) {
                adm.setIdUsuario(rs.getInt(1));
                adm.setNombre(rs.getString(2));
                adm.setApellidoP(rs.getString(3));
                adm.setApellidoM(rs.getString(4));
                adm.setEstado(rs.getString(5));
                adm.setMunicipio(rs.getString(6));
                adm.setCalle(rs.getString(7));
                adm.setNumero(rs.getInt(8));
                adm.setTelefono(rs.getInt(9));
                adm.setUsuario(rs.getString(10));
                CORRECT = true;
            }
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return new Object[]{adm, CORRECT};
    }
}
