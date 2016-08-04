package Controlador.Otros;

import Classes.Beans.AreaBean;
import Modelo.Otros.AreaDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene el objeto Texto
     */
    public void actionPerformedJIngresarArea(DefaultTableModel jModel, Object[] jField) {
        AreaBean Bean = new AreaBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Area", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setSeccion(jField[0].toString());
        if (adm.IngresarArea(jModel, Bean)) {
            JOptionPane.showMessageDialog(null, "El área ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el área", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Area. Crea un nuevo area bean, Si la tabla está seleccionada
     * consigue el id de la area seleccionada y lo ingresa en el bean con todos
     * los valores en los text field. Envia los datos al dao correspondiente, si
     * es exitoso envia un JOptionPane con texto correcto, si no es exitoso
     * envia un texto erroneo
     *
     * @param jTableRArea // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     */
    public void actionPerformedJModificarArea(JTable jTableRArea, Object[] jField) {
        AreaBean Bean = new AreaBean();
        int Select = jTableRArea.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Area", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setIdArea(Integer.parseInt(jTableRArea.getValueAt(Select, 0).toString()));
        Bean.setSeccion(jField[0].toString());
        Bean.setEstatus(jField[1].toString());
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
     * @param jTableRArea // Contiene el objeto Tabla de la Vista
     */
    public void actionPerformedJEliminarArea(JTable jTableRArea) {
        DefaultTableModel ae = (DefaultTableModel) jTableRArea.getModel();
        int Select = jTableRArea.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarArea(Integer.parseInt(jTableRArea.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

}
