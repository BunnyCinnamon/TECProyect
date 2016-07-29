package Controlador.Otros;

import Classes.Beans.EditorialBean;
import Modelo.Otros.EditorialDAO;
import Utils.CleanupDone;
import Vista.VAdministrador;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

@CleanupDone
public class EditorialControlador {

    public EditorialDAO adm = new EditorialDAO();

    /**
     * Ingresar Editorial. Crea un nuevo editorial bean y le ingresa los datos
     * en los text field, envia el bean al dao correspondiente, si es exitoso
     * envia un JOptionPane con texto correcto, si no es exitoso envia un texto
     * erroneo
     *
     * @param ae // Contiene el objeto Tabla de la Vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJIngresarEditorial(DefaultTableModel ae, VAdministrador va) {
        EditorialBean Bean = new EditorialBean();
        Bean.setNombre(va.JNombreTextEditorial.getText());
        if (adm.IngresarEditorial(ae, Bean)) {
            JOptionPane.showMessageDialog(null, "La editorial ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó la editorial", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Editorial. Crea un nuevo editorial bean, Si la tabla está
     * seleccionada consigue el id de la editorial seleccionada y lo ingresa en
     * el bean con todos los valores en los text field. Envia los datos al dao
     * correspondiente, si es exitoso envia un JOptionPane con texto correcto,
     * si no es exitoso envia un texto erroneo
     *
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJModificarEditorial(VAdministrador va) {
        EditorialBean Bean = new EditorialBean();
        int Select = va.JTableREditorial.getSelectedRow();
        Bean.setIdEditorial(Integer.parseInt(va.JTableREditorial.getValueAt(Select, 0).toString()));
        Bean.setNombre(va.JNombreTextEditorial.getText());
        Bean.setEstatus(va.JComboEstatusEditorial.getSelectedItem().toString());
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            if (adm.ModificarEditorial(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

    /**
     * Eliminar Editorial. Si la tabla está seleccionada consigue el id de la
     * editorial seleccionada. Envia el id al dao correspondiente, si es exitoso
     * envia un JOptionPane con texto correcto, si no es exitoso envia un texto
     * erroneo
     *
     * @param ae // Contiene el objeto Tabla de Vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJEliminarEditorial(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableREditorial.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarEditorial(Integer.parseInt(va.JTableREditorial.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

}
