package Modelo;

import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestamosDAO {

    Connection conn;
    
    private final String SQL_ELIMINAR_PRESTAMO="DELETE FROM Prestamo WHERE IdPrestamo=?";
    
    public boolean EliminarPrestamo(int id) {
        boolean SUCCESS = true;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ELIMINAR_PRESTAMO);
            prs.setInt(1, id);
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

}
