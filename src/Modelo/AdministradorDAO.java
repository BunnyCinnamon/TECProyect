package Modelo;

import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class AdministradorDAO {

    Connection conn;

    /**
     * Registros de Libro*
     */
    private final String SQL_ADD_BOOKS = "INSERT INTO Libro values ";
    private final String SQL_MODIFY_BOOKS = "UPDATE Libro SET ";
    private final String SQL_REMOVE_BOOKS = "DELETE FROM Libro WHERE idLibro = ";
    private final String SQL_SEARCH_BOOKS = "SELECT * FROM Libro ";

    public boolean IngresarLibro(DefaultTableModel t, String text, String text0, int i, String toString, int i0, int i1) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            try (PreparedStatement prs = conn.prepareStatement(SQL_ADD_BOOKS + "('" + text + "','" + text0 + "'," + i + ",'" + toString + "'," + i0 + "," + i1 + ")")) {
                SUCCESS = prs.executeUpdate() == 1;
                prs.close();
            }
        } catch (SQLException n) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return SUCCESS;
    }

    public boolean ModificarLibro(String isbn, String title, String pag, String est, String np, String id) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            try (PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_BOOKS+"isbn='"+isbn+"',titulo='"+title+"',paginas="+pag+",estatus='"+est+"',numeroPrestamos="+np+" WHERE idLibro="+id)) {
                SUCCESS = prs.executeUpdate() == 1;
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
        return SUCCESS;
    }

    public boolean EliminarLibro(String id) {
        boolean SUCCESS = true;
        try {
            conn = Connexion.getConnection();
            try (PreparedStatement prs = conn.prepareStatement(SQL_REMOVE_BOOKS+id)) {
                SUCCESS = prs.executeUpdate() == 1;
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
        return SUCCESS;
    }

    public void BuscarLibro(DefaultTableModel t) {
        ArrayList<String> Array = new ArrayList<String>();
        try {
            conn = Connexion.getConnection();
            try (PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_BOOKS)) {
                ResultSet rs = prs.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                t.setRowCount(0);
                while (rs.next()) {
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        Array.add(rs.getString(columnIndex));
                    }
                    t.addRow(Array.toArray());
                    Array.clear();
                }
                rs.close();
                prs.close();
            }
        } catch (SQLException n) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
    }
}
