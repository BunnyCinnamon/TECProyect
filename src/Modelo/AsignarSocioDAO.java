package Modelo;

import Classes.Beans.SocioBean;
import Utils.CleanupDone;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Descripción: MYQSL para AsignarSocio
 *
 */
@CleanupDone
public class AsignarSocioDAO {

    Connection conn;

    private final String SQL_CHECK_AVALIABLE = "SELECT Existencias FROM Ejemplar WHERE Libro=? AND Existencias>3";
    private final String SQL_CHECK_REPEATED = "SELECT COUNT(Socio) FROM Prestamo WHERE Socio=?";
    private final String SQL_ADD_PRESTAMO = "INSERT INTO Prestamo values(null,CURDATE(),CURDATE() + INTERVAL 3 DAY,?,?)";
    private final String SQL_INCREASE_BOOK_PRESTAMO = "UPDATE Libro,Ejemplar SET NumeroPrestamos=NumeroPrestamos+1, Existencias=Existencias-1 WHERE IdLibro=Libro AND IdLibro=?";
    private final String SQL_INCREASE_PRESTAMOS = "UPDATE Socio SET Prestamos=Prestamos+1 WHERE IdSocio=?";

    /**
     * Uso: Registra un Prestamo en la base de datos con los datos del Libro y
     * del Socio, en el ArrayList y el Bean respectivamente.
     *
     * Descripción: Busca si el libro tiene más de 3 existencias, si es true
     * busca el número de préstamos del socio y envia true o false si el socio
     * tiene menos-igual o más de 3 libros respectivamente, si es true se añade
     * el préstamo con el id del socio y el id del libro, si se añade
     * exitosamente se incrementa el número de préstamos del libro y reduce las
     * existencias por 1, si es exitoso icrementa el número de préstamos que ha
     * hecho el socio.
     *
     * Variables:
     *
     * @param U // Contiene el objeto Bean y ArrayList
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean AsignarSocioDAO(Object[] U) {
        SocioBean SocioBean = (SocioBean) U[0];
        ArrayList Array = (ArrayList) U[1];
        boolean AVAILABLE = false;
        boolean SUCCESS = false;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_CHECK_AVALIABLE);
            prs.setInt(1, Integer.parseInt(Array.get(0).toString()));
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                AVAILABLE = true;
            }
            prs.close();
        } catch (SQLException n) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            if (AVAILABLE) {
                AVAILABLE = false;
                try {
                    PreparedStatement prs = conn.prepareStatement(SQL_CHECK_REPEATED);
                    prs.setInt(1, SocioBean.getIdUsuario());
                    ResultSet rs = prs.executeQuery();
                    if (rs.next()) {
                        int cant = rs.getInt(1);
                        if (cant <= 2) {
                            AVAILABLE = true;
                        }
                    }
                    prs.close();
                } catch (SQLException n) {
                    Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, "Error", n);
                } finally {
                    if (AVAILABLE) {
                        try {
                            PreparedStatement prs = conn.prepareStatement(SQL_ADD_PRESTAMO);
                            prs.setInt(1, SocioBean.getIdUsuario());
                            prs.setInt(2, Integer.parseInt(Array.get(0).toString()));
                            SUCCESS = prs.executeUpdate() == 1;
                            prs.close();
                        } catch (SQLException n) {
                            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, "Error", n);
                        } finally {
                            ////////////////////////////////////////////////////////////////
                            try {
                                PreparedStatement prs = conn.prepareStatement(SQL_INCREASE_BOOK_PRESTAMO);
                                prs.setInt(1, Integer.parseInt(Array.get(0).toString()));
                                prs.executeUpdate();
                                prs.close();
                            } catch (SQLException n) {
                                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, "Error", n);
                            } finally {
                                ////////////////////////////////////////////////////////////////
                                try {
                                    PreparedStatement prs = conn.prepareStatement(SQL_INCREASE_PRESTAMOS);
                                    prs.setInt(1, SocioBean.getIdUsuario());
                                    prs.executeUpdate();
                                    prs.close();
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
                    }
                }
            }
        }
        try {
            conn.close();
        } catch (SQLException m) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, "Error", m);
        }
        return SUCCESS;
    }

}
