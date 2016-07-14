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

public class BuscarLibroDAO {

    Connection conn;

    /**
     * Funciones de Libro*
     */
    private final String SQL_SEARCH_BOOKS = "SELECT IdLibro,Isbn,Titulo,Paginas,Estatus,NombreAutor,NombreEditorial,Seccion,Pasillo,Existencias FROM Libro AS A join Editorial B,Area C,Localizacion D,Autor E,Escribe F,Ejemplar G WHERE A.Editorial=B.IdEditorial AND A.Area=C.IdArea AND A.Localizacion=D.IdLocalizacion AND F.Autor=E.IdAutor AND G.Libro=IdLibro AND F.Libro=A.IdLibro";

    public void BuscarLibro(DefaultTableModel t, LibroBean Bean, String Editorial, String Autor, int action) {
        ArrayList<String> Array = new ArrayList<String>();
        try {
            conn = Connexion.getConnection();
            ResultSet rs = null;
            PreparedStatement prs = null;
            switch (action) {
                case 0: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " ORDER BY IdLibro");
                    rs = prs.executeQuery();
                    break;
                }
                case 1: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Titulo like ? ORDER BY IdLibro");
                    prs.setString(1, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 2: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Isbn like ? ORDER BY IdLibro");
                    prs.setString(1, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 3: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? ORDER BY IdLibro");
                    prs.setString(1, Autor);
                    rs = prs.executeQuery();
                    break;
                }
                case 4: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? ORDER BY IdLibro");
                    prs.setString(1, Editorial);
                    rs = prs.executeQuery();
                    break;
                }
                case 5: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Titulo like ? ORDER BY IdLibro");
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 6: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Titulo like ? ORDER BY IdLibro");
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 7: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Isbn like ? AND A.Titulo like ? ORDER BY IdLibro");
                    prs.setString(1, '%' + Bean.getIsbn() + "%");
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 8: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Isbn like ? ORDER BY IdLibro");
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getIsbn() + "%");
                    rs = prs.executeQuery();
                    break;
                }
                case 9: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Isbn like ? ORDER BY IdLibro");
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 10: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND E.NombreAutor=? ORDER BY IdLibro");
                    prs.setString(1, Editorial);
                    prs.setString(2, Autor);
                    rs = prs.executeQuery();
                    break;
                }
                case 11: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Titulo like ? AND A.Isbn like ? ORDER BY IdLibro");
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 12: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Titulo like ? AND A.Isbn like ? ORDER BY IdLibro");
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 13: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Isbn like ? ORDER BY IdLibro");
                    prs.setString(1, Autor);
                    prs.setString(2, Editorial);
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 14: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Titulo like ? ORDER BY IdLibro");
                    prs.setString(1, Autor);
                    prs.setString(2, Editorial);
                    prs.setString(3, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 15: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Titulo like ? AND A.Isbn like ? ORDER BY IdLibro");
                    prs.setString(1, Autor);
                    prs.setString(2, Editorial);
                    prs.setString(3, '%' + Bean.getTitulo() + '%');
                    prs.setString(4, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
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
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
    }
}
