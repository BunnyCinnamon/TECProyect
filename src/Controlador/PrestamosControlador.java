package Controlador;

import Modelo.PrestamosDAO;
import Utils.CleanupDone;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Prestamos
 *
 */
@CleanupDone
public class PrestamosControlador {

    private static final PrestamosDAO ADM = new PrestamosDAO();

    /**
     * Descripción: Elimina el Préstamo de la base de datos.
     *
     * Variables:
     *
     * @param jTablePrestamos //Contiene el objeto Tabla de la Vista
     */
    public void JLiberarSeleccionActionPerformed(JTable jTablePrestamos) {
        DefaultTableModel Area = (DefaultTableModel) jTablePrestamos.getModel();
        int Select = jTablePrestamos.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro por completo?")) {
            int id = Integer.parseInt(jTablePrestamos.getValueAt(Select, 0).toString());
            if (ADM.EliminarPrestamo(id)) {
                Area.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Descripción: Abre una nueva ventana de Detalles.
     *
     * Variables:
     *
     * @param jTablePrestamos //Contiene el objeto Tabla de la Vista
     */
    public void JDetallesActionPerformed(JTable jTablePrestamos) {
        int Select = jTablePrestamos.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else {
            int id = Integer.parseInt(jTablePrestamos.getValueAt(Select, 0).toString());
        }
    }

}
