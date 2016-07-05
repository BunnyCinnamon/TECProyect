package Controlador;

import Modelo.AdministradorDAO;
import Vista.VAdministrador;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class AdministradorControlador extends VAdministrador{

    public AdministradorDAO adm = new AdministradorDAO();

    public void actionPerformedJIngresarLibro(DefaultTableModel ae, VAdministrador va) {
        if (adm.IngresarLibro(ae, va.JISBNText.getText(), va.JTituloText.getText(), va.JSpinnerNPag.getComponentCount(), va.JEstadoLibro.getSelectedItem().toString(), 1, 18)) {
            ae.addRow(new Object[]{va.JISBNText.getText(), va.JTituloText.getText(), 7, va.JEstadoLibro.getSelectedItem().toString(), 1, 18});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformedJModificarLibro(VAdministrador va) {
        int Select = va.JTableRLibro.getSelectedRow();
        if (Select< 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
                if(adm.ModificarLibro(va.JTableRLibro.getValueAt(Select, 0).toString(), va.JTableRLibro.getValueAt(Select, 1).toString(), va.JTableRLibro.getValueAt(Select, 2).toString(), va.JTableRLibro.getValueAt(Select, 3).toString(), va.JTableRLibro.getValueAt(Select, 4).toString(), va.JTableRLibro.getValueAt(Select, 5).toString())){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

    public void actionPerformedJEliminarLibro(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRLibro.getSelectedRow();
        if (Select< 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
                if(adm.EliminarLibro(va.JTableRLibro.getValueAt(Select, 5).toString())){
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    public void actionPerformedJBuscarLibro(DefaultTableModel ae) {
        adm.BuscarLibro(ae);
    }

}
