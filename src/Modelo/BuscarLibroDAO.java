package Modelo;

import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Utils.CleanupDone;
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

/**
 * Descripción: MYQSL para BuscarLibro
 *
 */
@CleanupDone
public class BuscarLibroDAO {

    Connection conn;

    /**
     * Funciones de Libro*
     */
    private final String SQL_SEARCH_BOOKS = "SELECT IdLibro,Isbn,Titulo,Paginas,Estatus,NombreAutor,NombreEditorial,Seccion,Pasillo,Existencias FROM Libro AS A join Editorial B,Area C,Localizacion D,Autor E,Escribe F,Ejemplar G WHERE A.Editorial=B.IdEditorial AND A.Area=C.IdArea AND A.Localizacion=D.IdLocalizacion AND F.Autor=E.IdAutor AND G.Libro=IdLibro AND F.Libro=A.IdLibro AND Estatus='Activo'";
    private final String SQL_SEARCH_SOCIO = "SELECT IdSocio,Nombre,ApellidoP,ApellidoM,CONCAT(Estado,' ',Municipio,' ',Calle,' ',Numero),Telefono,Estatus,Prestamos,Usuario FROM Socio WHERE Estatus='Activo'";
    private static final String ORDER = " ORDER BY IdLibro";
    private static final String ORDER_SOCIO = " ORDER BY Prestamos DESC";

    /**
     * Uso: Busca todos Libros con los datos de titulo, isbn, autor y editorial,
     * accion, en la base de datos.
     *
     * Descripción: Con la acción, busca los libros que tienen los datos
     * similares. Ingresa los datos encontrados con los datos del libro en un
     * array list. Ingresa el array list en la tabla, elimina los datos del
     * array list y repite hasta encontrar todos los datos.
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @param Bean // Contiene los datos del Libro
     * @param Editorial // Contiene la editorial
     * @param Autor // Contiene el Autor
     * @param action // Contiene el tipo de acción 0-15 segun la búsqueda
     */
    public void BuscarLibro(DefaultTableModel t, LibroBean Bean, String Editorial, String Autor, int action) {
        ArrayList<String> Array = new ArrayList<String>();
        try {
            conn = Connexion.getConnection();
            ResultSet rs = null;
            PreparedStatement prs = null;
            switch (action) {
                case 0: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + ORDER);
                    rs = prs.executeQuery();
                    break;
                }
                case 1: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Titulo like ?" + ORDER);
                    prs.setString(1, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 2: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Isbn like ?" + ORDER);
                    prs.setString(1, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 3: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=?" + ORDER);
                    prs.setString(1, Autor);
                    rs = prs.executeQuery();
                    break;
                }
                case 4: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=?" + ORDER);
                    prs.setString(1, Editorial);
                    rs = prs.executeQuery();
                    break;
                }
                case 5: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Titulo like ?" + ORDER);
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 6: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Titulo like ?" + ORDER);
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 7: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Isbn like ? AND A.Titulo like ?" + ORDER);
                    prs.setString(1, '%' + Bean.getIsbn() + "%");
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 8: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Isbn like ?" + ORDER);
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getIsbn() + "%");
                    rs = prs.executeQuery();
                    break;
                }
                case 9: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Isbn like ?" + ORDER);
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 10: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND E.NombreAutor=?" + ORDER);
                    prs.setString(1, Editorial);
                    prs.setString(2, Autor);
                    rs = prs.executeQuery();
                    break;
                }
                case 11: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Titulo like ? AND A.Isbn like ?" + ORDER);
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 12: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Titulo like ? AND A.Isbn like ?" + ORDER);
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 13: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Isbn like ?" + ORDER);
                    prs.setString(1, Autor);
                    prs.setString(2, Editorial);
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 14: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Titulo like ?" + ORDER);
                    prs.setString(1, Autor);
                    prs.setString(2, Editorial);
                    prs.setString(3, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 15: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Titulo like ? AND A.Isbn like ?" + ORDER);
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

    /**
     * Uso: Busca todos Socios con los datos de nombre, apellido paterno,
     * apellido materno, usuario, accion en la base de datos.
     *
     * Descripción: Con la acción, busca los socios que tienen los datos
     * similares. Ingresa los datos encontrados con los datos del socio en un
     * array list. Ingresa el array list en la tabla, elimina los datos del
     * array list y repite hasta encontrar todos los datos.
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @param Bean // Contiene los datos del Libro
     * @param action // Contiene el tipo de acción 0-15 segun la búsqueda
     */
    public void BuscarSocio(DefaultTableModel t, SocioBean Bean, int action) {
        ArrayList<String> Array = new ArrayList<String>();
        try {
            conn = Connexion.getConnection();
            ResultSet rs = null;
            PreparedStatement prs = null;
            switch (action) {
                case 0: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + ORDER_SOCIO);
                    rs = prs.executeQuery();
                    break;
                }
                case 1: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND Nombre like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getNombre() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 2: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoP like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoP() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 3: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoM like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoM() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 4: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND Usuario like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getUsuario() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 5: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND B.NombreEditorial=? AND Nombre like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getUsuario() + '%');
                    prs.setString(2, '%' + Bean.getNombre() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 6: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoM like ? Nombre like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoM() + '%');
                    prs.setString(2, '%' + Bean.getNombre() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 7: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoP like ? AND Nombre like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoP() + "%");
                    prs.setString(2, '%' + Bean.getNombre() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 8: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoM like ? AND ApellidoP like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoM() + '%');
                    prs.setString(2, '%' + Bean.getApellidoP() + "%");
                    rs = prs.executeQuery();
                    break;
                }
                case 9: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND B.NombreEditorial=? AND ApellidoP like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getUsuario() + '%');
                    prs.setString(2, '%' + Bean.getApellidoP() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 10: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND B.NombreEditorial=? AND ApellidoM like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getUsuario() + '%');
                    prs.setString(2, '%' + Bean.getApellidoM() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 11: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoM like ? AND Nombre like ? AND ApellidoP like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoM() + '%');
                    prs.setString(2, '%' + Bean.getNombre() + '%');
                    prs.setString(3, '%' + Bean.getApellidoP() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 12: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND Usuario like ? AND Nombre like ? AND ApellidoP like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getUsuario() + '%');
                    prs.setString(2, '%' + Bean.getNombre() + '%');
                    prs.setString(3, '%' + Bean.getApellidoP() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 13: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoM like ? AND Usuario like ? AND ApellidoP like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoM() + '%');
                    prs.setString(2, '%' + Bean.getUsuario() + '%');
                    prs.setString(3, '%' + Bean.getApellidoP() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 14: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoM like ? AND Usuario like ? AND Nombre like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoM() + '%');
                    prs.setString(2, '%' + Bean.getUsuario() + '%');
                    prs.setString(3, '%' + Bean.getNombre() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 15: {
                    prs = conn.prepareStatement(SQL_SEARCH_SOCIO + " AND ApellidoM like ? AND Usuario like ? AND Nombre like ? AND ApellidoP like ?" + ORDER_SOCIO);
                    prs.setString(1, '%' + Bean.getApellidoM() + '%');
                    prs.setString(2, '%' + Bean.getUsuario() + '%');
                    prs.setString(3, '%' + Bean.getNombre() + '%');
                    prs.setString(4, '%' + Bean.getApellidoP() + '%');
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
                Array.add("**********");
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
