package Modelo.Otros;

import Classes.Beans.EditorialBean;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class EditorialDAO {

    Connection conn;

    /**
     * Funciones de Libro*
     */
    private final String SQL_ADD_EDITORIAL = "INSERT INTO Editorial (IdEditorial,NombreEditorial,EstatusEditorial)";
    private final String SQL_ID_EDITORIAL = "SELECT IdEditorial FROM Editorial WHERE NombreEditorial=? AND EstatusEditorial='Activo'";
    private final String SQL_MODIFY_REMOVE_EDITORIAL = "UPDATE Editorial SET";

    /**
     *
     * @param t
     * @param Bean
     * @return
     */
    public boolean IngresarEditorial(DefaultTableModel t, EditorialBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_EDITORIAL + " values (null,?,'Activo')");
            prs.setString(1, Bean.getNombre());
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        try {
            conn = Connexion.getConnection();
            ResultSet rs;
            PreparedStatement prs = conn.prepareStatement(SQL_ID_EDITORIAL);
            prs.setString(1, Bean.getNombre());
            rs = prs.executeQuery();
            if(rs.next()){
            Bean.setIdEditorial(rs.getInt(1));
            }
            t.addRow(new Object[]{Bean.getIdEditorial(),Bean.getNombre(),"Activo"});
            prs.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return SUCCESS;
    }

    /**
     *
     * @param Bean
     * @return
     */
    public boolean ModificarEditorial(EditorialBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_REMOVE_EDITORIAL + " NombreEditorial=?,EstatusEditorial=? WHERE IdEditorial=?");
            prs.setString(1, Bean.getNombre());
            prs.setString(2, Bean.getEstatus());
            prs.setInt(3, Bean.getIdEditorial());
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return SUCCESS;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean EliminarEditorial(int id) {
        boolean SUCCESS = true;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_REMOVE_EDITORIAL + " EstatusEditorial='Inactivo' WHERE IdEditorial=?");
            prs.setInt(1, id);
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return SUCCESS;
    }

}
