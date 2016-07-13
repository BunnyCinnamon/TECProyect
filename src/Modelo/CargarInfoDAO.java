package Modelo;

import Classes.Beans.SocioBean;
import Utils.Connexion;
import Vista.VAdministrador;
import Vista.VBuscarLibro;
import Vista.VDetalles;
import Vista.VPrestamos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class CargarInfoDAO {

    Connection conn;

    private final String SQL_SEARCH_LOCALIZACION = "SELECT Pasillo FROM Localizacion";
    private final String SQL_SEARCH_AREA = "SELECT Seccion FROM Area";
    private final String SQL_SEARCH_AUTOR = "SELECT NombreAutor FROM Autor";
    private final String SQL_SEARCH_EDITORIAL = "SELECT NombreEditorial FROM Editorial";
    ////////////////////////////////////////////////////////////////////////////
    private final String SQL_SEARCH_ALL_LOCALIZACION = "SELECT * FROM Localizacion  ORDER BY IdLocalizacion";
    private final String SQL_SEARCH_ALL_AREA = "SELECT * FROM Area ORDER BY IdArea";
    private final String SQL_SEARCH_ALL_EDITORIAL = "SELECT * FROM Editorial ORDER BY IdEditorial";
    ////////////////////////////////////////////////////////////////////////////
    private final String SQL_SEARCH_ALL_PRESTAMOS = "SELECT IdPrestamo,Usuario,Titulo,Isbn,FechaPrestamo,FechaDevolucion FROM Prestamo AS P JOIN Libro L,Ejemplar E,Socio S WHERE P.Socio=S.IdSocio AND E.IdEjemplar=P.Ejemplar AND E.Libro=L.IdLibro";
    private final String SQL_SEARCH_SOME_PRESTAMOS = "SELECT IdPrestamo,Usuario,Titulo,Isbn,FechaPrestamo,FechaDevolucion FROM Prestamo AS P JOIN Libro L,Ejemplar E,Socio S WHERE S.IdSocio=? AND P.Socio=S.IdSocio AND E.IdEjemplar=P.Ejemplar AND E.Libro=L.IdLibro";
    ////////////////////////////////////////////////////////////////////////////
    private final String SQL_SEARCH_MAX_EXISTENCIA_LIBRO = "SELECT Titulo,Existencias FROM Libro JOIN Ejemplar WHERE IdLibro=Libro AND Existencias=(SELECT MAX(Existencias) FROM Ejemplar)";
    private final String SQL_SEARCH_MIN_EXISTENCIA_EDITORIAL = "SELECT NombreEditorial,Existencias FROM Libro JOIN Ejemplar,Editorial WHERE IdLibro=Libro AND Editorial=IdEditorial AND Existencias=(SELECT MIN(Existencias) FROM Ejemplar)";
    private final String SQL_SEARCH_MAX_PRESTAMO_LIBRO = "SELECT Titulo,Isbn,NombreEditorial,NumeroPrestamos FROM Libro JOIN Editorial WHERE NumeroPrestamos=(SELECT MAX(NumeroPrestamos) FROM Libro) AND Editorial=IdEditorial";

    /**
     * DAO de Localizacion
     *
     *
     * @param ea
     * @return
     */
    public boolean LoadInfoVAdmin(VAdministrador ea) {
        DefaultListModel ModelAutor = new DefaultListModel();
        DefaultListModel ModelEditorial = new DefaultListModel();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_LOCALIZACION + " WHERE EstatusLocalizacion='Activo' ORDER BY IdLocalizacion");
            ResultSet rs = prs.executeQuery();
            ea.JLocalizacionLibro.addItem("Sin Selección");
            while (rs.next()) {
                ea.JLocalizacionLibro.addItem(rs.getString(1));
            }
            rs.close();
            prs.close();

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_AREA + " WHERE EstatusArea='Activo' ORDER BY IdArea");
            ResultSet rs = prs.executeQuery();
            ea.JAreaLibro.addItem("Sin Selección");
            while (rs.next()) {
                ea.JAreaLibro.addItem(rs.getString(1));
            }
            rs.close();
            prs.close();

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_AUTOR + " WHERE EstatusAutor='Activo'  ORDER BY IdAutor");
            ResultSet rs = prs.executeQuery();
            ModelAutor.addElement("Sin Selección");
            while (rs.next()) {
                ModelAutor.addElement(rs.getString(1));
            }
            rs.close();
            prs.close();
            ea.JListAutor.setModel(ModelAutor);

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_EDITORIAL + " WHERE EstatusEditorial='Activo'  ORDER BY IdEditorial");
            ResultSet rs = prs.executeQuery();
            ModelEditorial.addElement("Sin Selección");
            while (rs.next()) {
                ModelEditorial.addElement(rs.getString(1));
            }
            rs.close();
            prs.close();
            ea.JListEditorial.setModel(ModelEditorial);
            SUCCESS = true;

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return SUCCESS;
    }

    public boolean LoadInfoVSocio(VBuscarLibro ea) {
        DefaultListModel ModelAutor = new DefaultListModel();
        DefaultListModel ModelEditorial = new DefaultListModel();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_AUTOR + " WHERE EstatusAutor='Activo' ORDER BY IdAutor");
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                ModelAutor.addElement(rs.getString(1));
            }
            rs.close();
            prs.close();
            ea.JListAutor.setModel(ModelAutor);

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_EDITORIAL + " WHERE EstatusEditorial='Activo' ORDER BY IdEditorial");
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                ModelEditorial.addElement(rs.getString(1));
            }
            rs.close();
            prs.close();
            ea.JListEditorial.setModel(ModelEditorial);
            SUCCESS = true;

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return SUCCESS;
    }

    /**
     * DAO de Localizacion
     *
     *
     * @param ea
     * @return
     */
    public boolean LoadDetalles(VDetalles ea) {
        ArrayList<String> Array = new ArrayList<String>();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_MAX_EXISTENCIA_LIBRO);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                Array.add(0, "Ejemplar con Más Existencias:");
                Array.add(1, "Libro: " + rs.getString(1) + " Cantidad: " + rs.getString(2));
            }
            SUCCESS = true;

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_MIN_EXISTENCIA_EDITORIAL);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                Array.add(2, "Editorial con Menos Existencias:");
                Array.add(3, "Editorial: " + rs.getString(1) + " Cantidad: " + rs.getString(2));
            }

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_MAX_PRESTAMO_LIBRO);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                Array.add(4, "Libro con más Préstamos:");
                Array.add(5, "Título: " + rs.getString(1) + " ISBN: " + rs.getString(2));
                Array.add(6,"");
                Array.add(7, "Editorial: " + rs.getString(3) + " Cantidad: " + rs.getInt(4));
                for (int i = 8; i <= 10; i++) {
                    Array.add("");
                }
                ea.LoadData("Información", Array);
            }
            Array.clear();
            SUCCESS = true;

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, n, null);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, m, null);
            }
        }
        return SUCCESS;
    }

    /**
     * DAO de Localizacion
     *
     *
     * @param ea
     * @param t
     * @return
     */
    public boolean LoadLocalizacion(VAdministrador ea, DefaultTableModel t) {
        ArrayList<String> Array = new ArrayList<String>();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_ALL_LOCALIZACION);
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
            SUCCESS = true;

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
     * DAO de Area
     *
     *
     * @param ea
     * @param t
     * @return
     */
    public boolean LoadArea(VAdministrador ea, DefaultTableModel t) {
        ArrayList<String> Array = new ArrayList<String>();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_ALL_AREA);
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
            SUCCESS = true;

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
     * DAO de Editorial
     *
     *
     * @param ea
     * @param t
     * @return
     */
    public boolean LoadEditorial(VAdministrador ea, DefaultTableModel t) {
        ArrayList<String> Array = new ArrayList<String>();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_ALL_EDITORIAL);
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
            SUCCESS = true;

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
     * DAO de Prestamos
     *
     *
     * @param ea
     * @param t
     * @return
     */
    public boolean LoadPrestamos(VPrestamos ea, DefaultTableModel t, int accion) {
        ArrayList<String> Array = new ArrayList<String>();
        boolean SUCCESS = false;
        PreparedStatement prs = null;
        ResultSet rs = null;
        try {
            conn = Connexion.getConnection();
            if (accion == 0) {
                prs = conn.prepareStatement(SQL_SEARCH_ALL_PRESTAMOS);
                rs = prs.executeQuery();
            } else if (accion == 1) {
                prs = conn.prepareStatement(SQL_SEARCH_ALL_PRESTAMOS + " AND FechaDevolucion<=CURDATE()");
                rs = prs.executeQuery();
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
            SUCCESS = true;

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

    public boolean LoadPrestamos(VPrestamos ea, DefaultTableModel t, SocioBean Bean, int accion) {
        ArrayList<String> Array = new ArrayList<String>();
        boolean SUCCESS = false;
        PreparedStatement prs = null;
        ResultSet rs = null;
        try {
            conn = Connexion.getConnection();
            if (accion == 0) {
                prs = conn.prepareStatement(SQL_SEARCH_SOME_PRESTAMOS);
                prs.setInt(1, Bean.getIdUsuario());
                rs = prs.executeQuery();
            } else if (accion == 1) {
                prs = conn.prepareStatement(SQL_SEARCH_SOME_PRESTAMOS + " AND FechaDevolucion<=CURDATE()");
                prs.setInt(1, Bean.getIdUsuario());
                rs = prs.executeQuery();
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
            SUCCESS = true;

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
