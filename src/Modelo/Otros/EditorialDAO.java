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
     * Registra una Editorial en la base de datos con los datos: id, nombre y
     * estatus, en el Bean. Busca el id de la nueva Editorial y la ingresa en la
     * Tabla junto con sus datos.
     *
     * @param Bean // Contiene el nombre del área
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean IngresarEditorial(EditorialBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_EDITORIAL + " values (null,?,'Activo')");
            prs.setString(1, Bean.getNombre());
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        try {
            conn = Connexion.getConnection();
            ResultSet rs;
            PreparedStatement prs = conn.prepareStatement(SQL_ID_EDITORIAL);
            prs.setString(1, Bean.getNombre());
            rs = prs.executeQuery();
            if (rs.next()) {
                Bean.setIdEditorial(rs.getInt(1));
            }
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Modifica una Editorial con id específico en la base de datos con los
     * datos: nombre y estatus, en el Bean.
     *
     * @param Bean // Contiene el id, nombre y estatus de la Editorial
     * @return // Regresa true si es exitosa y false si ocurre un error
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
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Elimina una Editorial con id específico en la base de datos.
     *
     * @param id // Contiene el id de la Editorial
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean EliminarEditorial(int id) {
        boolean SUCCESS = true;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_REMOVE_EDITORIAL + " EstatusEditorial='Inactivo' WHERE IdEditorial=?");
            prs.setInt(1, id);
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

}
