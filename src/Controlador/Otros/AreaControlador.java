/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Otros;

import Classes.Beans.AreaBean;
import Modelo.Otros.AreaDAO;
import Vista.VAdministrador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josaded
 */
public class AreaControlador {

    public AreaDAO adm = new AreaDAO();

    /**
     * Ingresar Editorial
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarArea(DefaultTableModel ae, VAdministrador va) {
        AreaBean Bean = new AreaBean();
        Bean.setSeccion(va.JAreaText.getText());
        if (adm.IngresarArea(ae, Bean)) {
            JOptionPane.showMessageDialog(null, "El autor ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el autor", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Editorial
     *
     *
     * @param va
     */
    public void actionPerformedJModificarArea(VAdministrador va) {
        AreaBean Bean = new AreaBean();
        int Select = va.JTableRArea.getSelectedRow();
        Bean.setIdArea(Integer.parseInt(va.JTableRArea.getValueAt(Select, 0).toString()));
        Bean.setSeccion(va.JAreaText.getText());
        Bean.setEstatus(va.JComboEstatusArea.getSelectedItem().toString());
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            if (adm.ModificarArea(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

    /**
     * Eliminar Editorial
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarArea(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRArea.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarArea(Integer.parseInt(va.JTableRArea.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

}
