/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Otros;

import Classes.Beans.LocalizacionBean;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josaded
 */
public class LocalizacionDAO {

    Connection conn;

    /**
     * Funciones de Libro*
     */
    private final String SQL_ADD_LOCALIZACION = "INSERT INTO Localizacion (IdLocalizacion,Pasillo,EstatusLocalizacion)";
    private final String SQL_ID_LOCALIZACION = "SELECT IdLocalizacion FROM Localizacion WHERE Pasillo=? AND EstatusLocalizacion='Activo'";
    private final String SQL_MODIFY_REMOVE_LOCALIZACION = "UPDATE Localizacion SET";

    /**
     *
     * @param t
     * @param Bean
     * @return
     */
    public boolean IngresarLocalizacion(DefaultTableModel t, LocalizacionBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_LOCALIZACION + " values (null,?,'Activo')");
            prs.setString(1, Bean.getPasillo());
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        try {
            conn = Connexion.getConnection();
            ResultSet rs;
            PreparedStatement prs = conn.prepareStatement(SQL_ID_LOCALIZACION);
            prs.setString(1, Bean.getPasillo());
            rs = prs.executeQuery();
            if (rs.next()) {
                Bean.setIdLocalización(rs.getInt(1));
            }
            t.addRow(new Object[]{Bean.getIdLocalización(), Bean.getPasillo(), "Activo"});
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     *
     * @param Bean
     * @return
     */
    public boolean ModificarLocalizacion(LocalizacionBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_REMOVE_LOCALIZACION + " Pasillo=?, EstatusLocalizacion=? WHERE IdLocalizacion=?");
            prs.setString(1, Bean.getPasillo());
            prs.setString(2, Bean.getEstatus());
            prs.setInt(3, Bean.getIdLocalización());
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean EliminarLocalizacion(int id) {
        boolean SUCCESS = true;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_REMOVE_LOCALIZACION + " EstatusLocalizacion='Inactivo' WHERE IdLocalizacion=?");
            prs.setInt(1, id);
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(LocalizacionDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }
}
