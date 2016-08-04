package Controlador.Otros;

import Classes.Beans.EditorialBean;
import Modelo.Otros.EditorialDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class EditorialControlador {

    private final EditorialDAO adm = new EditorialDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();

    /**
     * Ingresar Editorial. Crea un nuevo editorial bean y le ingresa los datos
     * en los text field, envia el bean al dao correspondiente, si es exitoso
     * envia un JOptionPane con texto correcto, si no es exitoso envia un texto
     * erroneo
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene el objeto Texto
     */
    public void actionPerformedJIngresarEditorial(DefaultTableModel jModel, Object[] jField) {
        EditorialBean Bean = new EditorialBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de la Editorial", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setNombre(jField[0].toString());
        if (adm.IngresarEditorial(Bean)) {
            jModel.addRow(new Object[]{Bean.getIdEditorial(), Bean.getNombre(), "Activo"});
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
     * @param jTableREditorial // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     */
    public void actionPerformedJModificarEditorial(JTable jTableREditorial, Object[] jField) {
        EditorialBean Bean = new EditorialBean();
        int Select = jTableREditorial.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de la Editorial", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdEditorial(Integer.parseInt(jTableREditorial.getValueAt(Select, 0).toString()));
            Bean.setNombre(jField[0].toString());
            Bean.setEstatus(jField[1].toString());
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
     * @param jTableREditorial // Contiene el objeto Tabla de la Vista
     */
    public void actionPerformedJEliminarEditorial(JTable jTableREditorial) {
        DefaultTableModel ae = (DefaultTableModel) jTableREditorial.getModel();
        int Select = jTableREditorial.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarEditorial(Integer.parseInt(jTableREditorial.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

}
