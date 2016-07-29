package Controlador.Otros;

import Classes.Beans.LocalizacionBean;
import Modelo.Otros.LocalizacionDAO;
import Utils.CleanupDone;
import Vista.VAdministrador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class LocalizacionControlador {

    public LocalizacionDAO adm = new LocalizacionDAO();

    /**
     * Ingresar Localizacion. Crea un nuevo localizacion bean y le ingresa los
     * datos en los text field, envia el bean al dao correspondiente, si es
     * exitoso envia un JOptionPane con texto correcto, si no es exitoso envia
     * un texto erroneo
     *
     * @param ae // Contiene el objeto Tabla de la Vista
     * @param va // Contiene el objeto Vista
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
     * Modificar Localizacion. Crea un nuevo localizacion bean, Si la tabla está
     * seleccionada consigue el id de la localizacion seleccionada y lo ingresa
     * en el bean con todos los valores en los text field. Envia los datos al
     * dao correspondiente, si es exitoso envia un JOptionPane con texto
     * correcto, si no es exitoso envia un texto erroneo
     *
     * @param va // Contiene el objeto Vista
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
     * Eliminar Localizacion. Si la tabla está seleccionada consigue el id de la
     * Localizacion seleccionada. Envia el id al dao correspondiente, si es
     * exitoso envia un JOptionPane con texto correcto, si no es exitoso envia
     * un texto erroneo
     *
     * @param ae // Contiene el objeto Tabla de Vista
     * @param va // Contiene el objeto Vista
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
