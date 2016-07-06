package Modelo;

import Classes.Beans.LibroBean;
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
    private final String SQL_ADD_BOOKS = "INSERT INTO Libro (IdLibro,Isbn,Titulo,Paginas,Estatus,NumeroPrestamos,Editorial,Area,Localizacion) values (?,?,?,?,?,?,?,?)";
    private final String SQL_MODIFY_BOOKS = "UPDATE Libro SET ";
    private final String SQL_REMOVE_BOOKS = "DELETE FROM Libro WHERE IdLibro=?";
    private final String SQL_SEARCH_BOOKS = "SELECT IdLibro,Isbn,Titulo,Paginas,Estatus,NombreAutor,NombreEditorial,Seccion,Pasillo FROM Libro AS A join Editorial B,Area C,Localizacion D,Autor E,Escribe F WHERE A.Editorial=B.IdEditorial AND A.Area=C.IdArea AND A.Localizacion=D.IdLocalizacion AND F.Autor=E.IdAutor AND F.Libro=A.IdLibro";

    public boolean IngresarLibro(DefaultTableModel t, LibroBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_BOOKS);
            prs.setString(1, "null");
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
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
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_BOOKS);
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
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
            PreparedStatement prs = conn.prepareStatement(SQL_REMOVE_BOOKS);
            prs.setString(1, id);
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
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

    public void BuscarLibro(DefaultTableModel t, LibroBean Bean,String Editorial, String Autor, int action) {
        ArrayList<String> Array = new ArrayList<String>();
        try {
            conn = Connexion.getConnection();
            ResultSet rs = null;
            PreparedStatement prs = null;
            switch (action) {
                case 0: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS);
                    rs = prs.executeQuery();
                    break;
                }
                case 1: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Titulo like ?");
                    prs.setString(1,'%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 2: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Isbn like ?");
                    prs.setString(1,'%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 3: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=?");
                    prs.setString(1, Autor);
                    rs = prs.executeQuery();
                    break;
                }
                case 4: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=?");
                    prs.setString(1, Editorial);
                    rs = prs.executeQuery();
                    break;
                }
                case 5: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Titulo like ?");
                    prs.setString(1, Autor);
                    prs.setString(2,'%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                default:
                    break;
            }
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
