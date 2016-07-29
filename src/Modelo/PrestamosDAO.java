package Modelo;

import Utils.CleanupDone;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@CleanupDone
public class PrestamosDAO {

    Connection conn;

    private final String SQL_ELIMINAR_PRESTAMO = "DELETE FROM Prestamo WHERE IdPrestamo=?";

    /**
     * Elimina un Préstamo con id específico en la base de datos.
     *
     * @param id // Contiene el id del Préstamo
     * @return // Regresa true si es exitosa y false si ocurre un error
     */
    public boolean EliminarPrestamo(int id) {
        boolean SUCCESS = true;
        try {
            conn = Connexion.getConnection();
            PreparedStatement prs = conn.prepareStatement(SQL_ELIMINAR_PRESTAMO);
            prs.setInt(1, id);
            SUCCESS = prs.executeUpdate() == 1;
            prs.close();
            conn.close();
        } catch (SQLException n) {
            Logger.getLogger(PrestamosDAO.class.getName()).log(Level.SEVERE, "Error", n);
        } finally {
            try {
                conn.close();
            } catch (SQLException m) {
                Logger.getLogger(PrestamosDAO.class.getName()).log(Level.SEVERE, "Error", m);
            }
        }
        return SUCCESS;
    }

}
