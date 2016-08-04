package Modelo;

import Classes.Beans.SocioBean;
import Utils.CleanupDone;
import Utils.Connexion;
import Vista.VDetalles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class CargarInfoDAO {

    Connection conn;

    private final String SQL_SEARCH_LOCALIZACION = "SELECT idLocalizacion, Pasillo FROM Localizacion";
    private final String SQL_SEARCH_AREA = "SELECT idArea, Seccion FROM Area";
    private final String SQL_SEARCH_AUTOR = "SELECT idAutor, NombreAutor FROM Autor";
    private final String SQL_SEARCH_EDITORIAL = "SELECT IdEditorial, NombreEditorial FROM Editorial";
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
    ////////////////////////////////////////////////////////////////////////////
    private final String SQL_SEARCH_TITULO_LIBRO = "SELECT Titulo FROM Libro";

    /**
     * Busca todos los datos de Localización, Area, Autor y Editorial, en la
     * base de datos. Ingresa los datos encontrados de la localización en el
     * Combo box de la vista administrador. Ingresa los datos encontrados del
     * área en el Combo box de la vista administrador. Ingresa los datos
     * encontrados del autor en el List Model de la vista administrador. Ingresa
     * los datos encontrados de la editorial en el List Model de la vista
     * administrador
     *
     * @param jFieldCombo // Contiene los objetos ComboBox
     * @param jFieldList // Contiene los objetos List
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean LoadInfoVAdmin(JComboBox[] jFieldCombo, JList[] jFieldList) {
        DefaultListModel ModelAutor = new DefaultListModel();
        DefaultListModel ModelEditorial = new DefaultListModel();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_LOCALIZACION + " WHERE EstatusLocalizacion='Activo' ORDER BY IdLocalizacion");
            ResultSet rs = prs.executeQuery();
            jFieldCombo[0].addItem("Sin Selección");
            while (rs.next()) {
                jFieldCombo[0].addItem(rs.getString(1) + ": " + rs.getString(2));
            }
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_AREA + " WHERE EstatusArea='Activo' ORDER BY IdArea");
            ResultSet rs = prs.executeQuery();
            jFieldCombo[1].addItem("Sin Selección");
            while (rs.next()) {
                jFieldCombo[1].addItem("" + rs.getString(1) + ": " + rs.getString(2));
            }
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_AUTOR + " WHERE EstatusAutor='Activo'  ORDER BY IdAutor");
            ResultSet rs = prs.executeQuery();
            ModelAutor.addElement("Sin Selección");
            while (rs.next()) {
                ModelAutor.addElement(rs.getString(1) + ": " + rs.getString(2));
            }
            rs.close();
            prs.close();
            conn.close();
            jFieldList[0].setModel(ModelAutor);
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_EDITORIAL + " WHERE EstatusEditorial='Activo'  ORDER BY IdEditorial");
            ResultSet rs = prs.executeQuery();
            ModelEditorial.addElement("Sin Selección");
            while (rs.next()) {
                ModelEditorial.addElement(rs.getString(1) + ": " + rs.getString(2));
            }
            rs.close();
            prs.close();
            conn.close();
            jFieldList[1].setModel(ModelEditorial);
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Busca todos los datos de Autor y Editorial en la base de datos. Ingresa
     * los datos encontrados del autor en el List Model de la vista buscar
     * libro. Ingresa los datos encontrados de la editorial en el List Model de
     * la vista administrador
     *
     * @param jFieldList // Contiene los objetos List
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean LoadInfoVSocio(JList[] jFieldList) {
        DefaultListModel ModelAutor = new DefaultListModel();
        DefaultListModel ModelEditorial = new DefaultListModel();
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_AUTOR + " WHERE EstatusAutor='Activo' ORDER BY IdAutor");
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                ModelAutor.addElement(rs.getString(2));
            }
            rs.close();
            prs.close();
            conn.close();
            jFieldList[0].setModel(ModelAutor);
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        ////////////////////////////////////////////////////////////////////////
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_SEARCH_EDITORIAL + " WHERE EstatusEditorial='Activo' ORDER BY IdEditorial");
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                ModelEditorial.addElement(rs.getString(2));
            }
            rs.close();
            prs.close();
            conn.close();
            jFieldList[1].setModel(ModelEditorial);
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Busca el Libro con más existencias, la Editorial con menos existencias, y
     * el Libro con más préstamos en la base de datos. Ingresa los datos
     * encontrados del libro con más existencias en un array list e introduce
     * texto descriptivo. Ingresa los datos encontrados de la editorial con
     * menos existencias en un array list e introduce texto descriptivo. Ingresa
     * los datos encontrados del libro con más préstamos en un array list e
     * introduce texto descriptivo Envia el Array junto con el titulo a la vista
     * detalles
     *
     * @param ea //Contiene el objeto Vista
     * @return // Regresa true si es exitosa y false si ocurre un error
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
            rs.close();
            prs.close();
            conn.close();
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
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
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
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
                Array.add(6, "");
                Array.add(7, "Editorial: " + rs.getString(3) + " Cantidad: " + rs.getInt(4));
                for (int i = 8; i <= 10; i++) {
                    Array.add("");
                }
                rs.close();
                prs.close();
                conn.close();
                ea.LoadData("Información", Array);
            }
            Array.clear();
            SUCCESS = true;

        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Busca todos los datos de Localización en la base de datos. Ingresa los
     * datos encontrados de la localización en un array list. Ingresa el array
     * list en la tabla, elimina los datos del array list y repite hasta
     * encontrar todos los datos
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean LoadLocalizacion(DefaultTableModel t) {
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
            rs.close();
            prs.close();
            conn.close();
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Busca todos los datos de Area en la base de datos. Ingresa los datos
     * encontrados del área en un array list. Ingresa el array list en la tabla,
     * elimina los datos del array list y repite hasta encontrar todos los datos
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean LoadArea(DefaultTableModel t) {
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
            rs.close();
            prs.close();
            conn.close();
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Busca todos los datos de Editorial en la base de datos. Ingresa los datos
     * encontrados de la editorial en un array list. Ingresa el array list en la
     * tabla, elimina los datos del array list y repite hasta encontrar todos
     * los datos
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean LoadEditorial(DefaultTableModel t) {
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
            rs.close();
            prs.close();
            conn.close();
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

    /**
     * Busca todos los datos de Prestamos en la base de datos. Ingresa los datos
     * encontrados de prestamos en un array list. Ingresa el array list en la
     * tabla, elimina los datos del array list y repite hasta encontrar todos
     * los datos
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @param accion // Contiene el tipo de accion 1 o 2 segun la búsqueda sin y
     * con fecha atrasada
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean LoadPrestamos(DefaultTableModel t, int accion) {
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
            rs.close();
            prs.close();
            conn.close();
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }

        return SUCCESS;
    }

    /**
     * Busca los datos de Prestamos del el Socio en la base de datos. Ingresa
     * los datos encontrados de prestamos en un array list. Ingresa el array
     * list en la tabla, elimina los datos del array list y repite hasta
     * encontrar todos los datos
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @param Bean // Contiene los datos del Socio
     * @param accion // Contiene el tipo de acción 0 o 1 segun la búsqueda sin y
     * con fecha atrasada
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean LoadPrestamos(DefaultTableModel t, SocioBean Bean, int accion) {
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
            rs.close();
            prs.close();
            conn.close();
            SUCCESS = true;
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }

        return SUCCESS;
    }

    /**
     * Busca los Titulos de Libros en la base de datos. Ingresa los datos
     * encontrados de Libros en un array list, repite hasta encontrar todos los
     * datos
     *
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public ArrayList LoadTexts() {
        ArrayList<String> Array = new ArrayList<String>();
        PreparedStatement prs;
        ResultSet rs;
        try {
            conn = Connexion.getConnection();
            prs = conn.prepareStatement(SQL_SEARCH_TITULO_LIBRO);
            rs = prs.executeQuery();
            while (rs.next()) {
                Array.add(rs.getString(1));
            }
            rs.close();
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(CargarInfoDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }

        return Array;
    }

}
