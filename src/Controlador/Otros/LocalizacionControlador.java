/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Otros;

import Classes.Beans.LocalizacionBean;
import Modelo.Otros.LocalizacionDAO;
import Vista.VAdministrador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josaded
 */
public class LocalizacionControlador {

    public LocalizacionDAO adm = new LocalizacionDAO();

    /**
     * Ingresar Editorial
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarLocalizacion(DefaultTableModel ae, VAdministrador va) {
        LocalizacionBean Bean = new LocalizacionBean();
        Bean.setPasillo(va.JLocalizacionText.getText());
        if (adm.IngresarLocalizacion(ae, Bean)) {
            JOptionPane.showMessageDialog(null, "La localización ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó la localización", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Editorial
     *
     *
     * @param va
     */
    public void actionPerformedJModificarLocalizacion(VAdministrador va) {
        LocalizacionBean Bean = new LocalizacionBean();
        int Select = va.JTableRLocalizacion.getSelectedRow();
        Bean.setIdLocalización(Integer.parseInt(va.JTableRLocalizacion.getValueAt(Select, 0).toString()));
        Bean.setPasillo(va.JLocalizacionText.getText());
        Bean.setEstatus(va.JComboEstatusLocalizacion.getSelectedItem().toString());
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            if (adm.ModificarLocalizacion(Bean)) {
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
    public void actionPerformedJEliminarLocalizacion(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRLocalizacion.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarLocalizacion(Integer.parseInt(va.JTableRLocalizacion.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }
}
