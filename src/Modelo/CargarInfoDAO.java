
package Modelo;

import Utils.Connexion;
import Vista.VAdministrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class CargarInfoDAO {
    Connection conn;

    /**
     * CRUD de Informacion*
     */
    private final String SQL_LOAD_ALL = "SELECT Pasillo, Seccion, NombreAutor, NombreEditorial FROM Localizacion JOIN Area JOIN Autor JOIN Editorial";
    private final String SQL_SEARCH_LOCALIZACION = "SELECT Pasillo FROM Localizacion";
    private final String SQL_SEARCH_AREA = "SELECT Seccion FROM Area";
    private final String SQL_SEARCH_AUTOR = "SELECT NombreAutor FROM Autor";
    private final String SQL_SEARCH_EDITORIAL = "SELECT NombreEditorial FROM Editorial";

    public void LoadAll(VAdministrador ea) {
        DefaultListModel ModelAutor = new DefaultListModel();
        DefaultListModel ModelEditorial = new DefaultListModel();
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = prs.executeQuery();
            ea.JLocalizacionLibro.addItem("Sin Selección");
                ea.JAreaLibro.addItem("Sin Selección");
                    ModelAutor.addElement("Sin Selección");
                        ModelEditorial.addElement("Sin Selección");
            if (rs.next()) {
                ea.JLocalizacionLibro.addItem(rs.getString(1));
                ea.JAreaLibro.addItem(rs.getString(2));
                ModelAutor.addElement(rs.getString(3));
                ModelEditorial.addElement(rs.getString(4));
                rs.close();
                prs.close();
            }
            ea.JListAutor.setModel(ModelAutor);
            ea.JListEditorial.setModel(ModelEditorial);

        } catch (SQLException n) {
            Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(IniciarSesionDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
    }
    
    public void LoadLocalizacion(VAdministrador ea) {
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                ea.JLocalizacionLibro.addItem(rs.getString(1));
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
    }
    
    public void LoadArea(VAdministrador ea) {
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                ea.JLocalizacionLibro.addItem(rs.getString(1));
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
    }
    
    public void LoadAutor(VAdministrador ea) {
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                ea.JLocalizacionLibro.addItem(rs.getString(1));
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
    }
    
    public void LoalEditorial(VAdministrador ea) {
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                ea.JLocalizacionLibro.addItem(rs.getString(1));
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
    }
    
}
