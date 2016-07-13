package Controlador;

import Modelo.PrestamosDAO;
import Vista.VPrestamos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrestamosControlador {
    
    public PrestamosDAO adm = new PrestamosDAO();
    
    public void JLiberarSeleccionActionPerformed(DefaultTableModel t, VPrestamos vis){
        int Select = vis.JTablePrestamos.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro por completo?")) {
            int id = Integer.parseInt(vis.JTablePrestamos.getValueAt(Select, 0).toString());
            if (adm.EliminarPrestamo(id)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }
    
}
