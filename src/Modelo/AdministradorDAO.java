package Modelo;

import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
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
     * Funciones de Libro*
     */
    private final String SQL_ADD_BOOKS = "INSERT INTO Libro (IdLibro,Isbn,Titulo,Paginas,Estatus,NumeroPrestamos,Editorial,Area,Localizacion)";
    private final String SQL_SEARCH_IDLIBRO = "SELECT IdLibro FROM Libro WHERE Isbn=? AND Titulo=? AND Paginas=? AND Estatus=?";
    private final String SQL_ADD_AUTOR_TO_LIBRO = "INSERT INTO Escribe values (?,?)";
    private final String SQL_ADD_LIBRO_TO_EJEMPLAR = "INSERT INTO Ejemplar values(null,?,?)";
    ////////////////////////////////////////////////////////////////////////////
    private final String SQL_MODIFY_BOOKS = "UPDATE Libro SET Isbn=?, Titulo=?, Paginas=?, Estatus=?, Editorial=?, Area=?, Localizacion=? WHERE IdLibro=?";
    private final String SQL_REMOVE_BOOKS = "UPDATE Libro SET Estatus='Inactivo' WHERE IdLibro=?";
    private final String SQL_SEARCH_BOOKS = "SELECT IdLibro,Isbn,Titulo,Paginas,Estatus,NombreAutor,NombreEditorial,Seccion,Pasillo,Existencias FROM Libro AS A join Editorial B,Area C,Localizacion D,Autor E,Escribe F,Ejemplar G WHERE A.Editorial=B.IdEditorial AND A.Area=C.IdArea AND A.Localizacion=D.IdLocalizacion AND F.Autor=E.IdAutor AND G.Libro=IdLibro AND F.Libro=A.IdLibro";

    /**
     *
     * @param Bean
     * @return
     */
    public boolean IngresarLibro(LibroBean Bean) {
        boolean SUCCESSI = false;
        boolean SUCCESSM = false;
        boolean SUCCESSF = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_BOOKS + " values (null,?,?,?,?,?,?,?,?)");
            prs.setString(1, Bean.getIsbn());
            prs.setString(2, Bean.getTitulo());
            prs.setInt(3, Bean.getPaginas());
            prs.setString(4, Bean.getEstatus());
            prs.setInt(5, 0);
            prs.setInt(6, Bean.getEditorial());
            prs.setInt(7, Bean.getArea());
            prs.setInt(8, Bean.getLocalizacion());
            SUCCESSI = prs.executeUpdate() == 1;
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
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            ResultSet rs;
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_IDLIBRO);
            prs.setString(1, Bean.getIsbn());
            prs.setString(2, Bean.getTitulo());
            prs.setInt(3, Bean.getPaginas());
            prs.setString(4, Bean.getEstatus());
            rs = prs.executeQuery();
            if (rs.next()) {
                Bean.setIdLibro(rs.getInt(1));
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
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_AUTOR_TO_LIBRO);
            prs.setInt(1, Bean.getAutor());
            prs.setInt(2, Bean.getIdLibro());
            SUCCESSM = prs.executeUpdate() == 1;
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
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_LIBRO_TO_EJEMPLAR);
            prs.setInt(1, Bean.getNumeroPrestamos());
            prs.setInt(2, Bean.getIdLibro());
            SUCCESSM = prs.executeUpdate() == 1;
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
        if (SUCCESSI && SUCCESSM) {
            SUCCESSF = true;
        }
        return SUCCESSF;
    }

    /**
     *
     * @param Bean
     * @return
     */
    public boolean ModificarLibro(LibroBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_BOOKS);
            prs.setString(1, Bean.getIsbn());
            prs.setString(2, Bean.getTitulo());
            prs.setInt(3, Bean.getPaginas());
            prs.setString(4, Bean.getEstatus());
            prs.setInt(5, Bean.getEditorial());
            prs.setInt(6, Bean.getArea());
            prs.setInt(7, Bean.getLocalizacion());
            prs.setInt(8, Bean.getIdLibro());
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

    /**
     *
     * @param id
     * @return
     */
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

    /**
     *
     * @param t
     * @param Bean
     * @param Editorial
     * @param Autor
     * @param action
     */
    public void BuscarLibro(DefaultTableModel t, LibroBean Bean, String Editorial, String Autor, int action) {
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
                    prs.setString(1, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 2: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Isbn like ?");
                    prs.setString(1, '%' + Bean.getIsbn() + '%');
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
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Titulo like ?");
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 6: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Titulo like ?");
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 7: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND A.Isbn like ? AND A.Titulo like ?");
                    prs.setString(1, '%' + Bean.getIsbn() + "%");
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 8: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Isbn like ?");
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getIsbn() + "%");
                    rs = prs.executeQuery();
                    break;
                }
                case 9: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Isbn like ?");
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 10: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND E.NombreAutor=?");
                    prs.setString(1, Editorial);
                    prs.setString(2, Autor);
                    rs = prs.executeQuery();
                    break;
                }
                case 11: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND A.Titulo like ? AND A.Isbn like ?");
                    prs.setString(1, Autor);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 12: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND B.NombreEditorial=? AND A.Titulo like ? AND A.Isbn like ?");
                    prs.setString(1, Editorial);
                    prs.setString(2, '%' + Bean.getTitulo() + '%');
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 13: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Isbn like ?");
                    prs.setString(1, Autor);
                    prs.setString(2, Editorial);
                    prs.setString(3, '%' + Bean.getIsbn() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 14: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Titulo like ?");
                    prs.setString(1, Autor);
                    prs.setString(2, Editorial);
                    prs.setString(3, '%' + Bean.getTitulo() + '%');
                    rs = prs.executeQuery();
                    break;
                }
                case 15: {
                    prs = conn.prepareStatement(SQL_SEARCH_BOOKS + " AND E.NombreAutor=? AND B.NombreEditorial=? AND A.Titulo like ? AND A.Isbn like ?");
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

    /**
     * Funciones de Socio*
     */
    private final String SQL_ADD_SOCIO = "INSERT INTO Socio values(null,?,?,?,?,?,?,?,?,?,'Activo',?)";
    private final String SQL_MODIFY_SOCIO = "UPDATE Socio SET Nombre=?, ApellidoP=?, ApellidoM=?, Estado=?, Municipio=?, Calle=?, Numero=?, Telefono=?, Usuario=?, Estatus=?, Contraseña=? WHERE IdSocio=?";
    private final String SQL_DELETE_SOCIO = "UPDATE Socio SET Estado='Inactivo' WHERE IdSocio=?";

    /**
     *
     * @param Bean
     * @return
     */
    public boolean IngresarSocio(SocioBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ADD_SOCIO);
            prs.setString(1, Bean.getNormbre());
            prs.setString(2, Bean.getApellidoP());
            prs.setString(3, Bean.getApellidoM());
            prs.setString(4, Bean.getEstado());
            prs.setString(5, Bean.getMunicipio());
            prs.setString(6, Bean.getCalle());
            prs.setInt(7, Bean.getNumero());
            prs.setInt(8, Bean.getTelefono());
            prs.setString(9, Bean.getUsuario());
            prs.setString(10, Bean.getContraseña());
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

    public boolean ModificarSocio(SocioBean Bean) {
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_MODIFY_SOCIO);
            prs.setString(1, Bean.getNormbre());
            prs.setString(2, Bean.getApellidoP());
            prs.setString(3, Bean.getApellidoM());
            prs.setString(4, Bean.getEstado());
            prs.setString(5, Bean.getMunicipio());
            prs.setString(6, Bean.getCalle());
            prs.setInt(7, Bean.getNumero());
            prs.setInt(8, Bean.getTelefono());
            prs.setString(9, Bean.getUsuario());
            prs.setString(10, Bean.getEstatus());
            prs.setString(11, Bean.getContraseña());
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

    public boolean EliminarSocio(int id) {
        boolean SUCCESS = true;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_DELETE_SOCIO);
            prs.setInt(1, id);
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

}
