package Controlador.Otros;

import Classes.Beans.AreaBean;
import Modelo.Otros.AreaDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import Vista.VAdministrador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class AreaControlador {

    private final AreaDAO adm = new AreaDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();

    /**
     * Ingresar Area. Crea un nuevo area bean y le ingresa los datos en los text
     * field, envia el bean al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo
     *
     * @param ae // Contiene el objeto Tabla de la Vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJIngresarArea(DefaultTableModel ae, VAdministrador va) {
        AreaBean Bean = new AreaBean();
        Object[] texts = new Object[]{va.JAreaText.getText()};
        if (TEXT_CHECKER.checkIfEmpty(texts)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Area", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setSeccion(texts[0].toString());
        if (adm.IngresarArea(ae, Bean)) {
            JOptionPane.showMessageDialog(null, "El autor ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el autor", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Area. Crea un nuevo area bean, Si la tabla está seleccionada
     * consigue el id de la area seleccionada y lo ingresa en el bean con todos
     * los valores en los text field. Envia los datos al dao correspondiente, si
     * es exitoso envia un JOptionPane con texto correcto, si no es exitoso
     * envia un texto erroneo
     *
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJModificarArea(VAdministrador va) {
        AreaBean Bean = new AreaBean();
        int Select = va.JTableRArea.getSelectedRow();
        Object[] texts = new Object[]{va.JAreaText.getText()};
        if (TEXT_CHECKER.checkIfEmpty(texts)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Area", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setIdArea(Integer.parseInt(va.JTableRArea.getValueAt(Select, 0).toString()));
        Bean.setSeccion(texts[0].toString());
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
     * Eliminar Area. Si la tabla está seleccionada consigue el id de la area
     * seleccionada. Envia el id al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo
     *
     * @param ae // Contiene el objeto Tabla de Vista
     * @param va // Contiene el objeto Vista
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
