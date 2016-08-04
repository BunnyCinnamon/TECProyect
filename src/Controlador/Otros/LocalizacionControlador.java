package Controlador.Otros;

import Classes.Beans.LocalizacionBean;
import Modelo.Otros.LocalizacionDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class LocalizacionControlador {

    private final LocalizacionDAO adm = new LocalizacionDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();

    /**
     * Ingresar Localizacion. Crea un nuevo localizacion bean y le ingresa los
     * datos en los text field, envia el bean al dao correspondiente, si es
     * exitoso envia un JOptionPane con texto correcto, si no es exitoso envia
     * un texto erroneo
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene el objeto Texto
     */
    public void actionPerformedJIngresarLocalizacion(DefaultTableModel jModel, Object[] jField) {
        LocalizacionBean Bean = new LocalizacionBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de Localizacion", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setPasillo(jField[0].toString());
        if (adm.IngresarLocalizacion(jModel, Bean)) {
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
     * @param jTableRLocalizacion // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     */
    public void actionPerformedJModificarLocalizacion(JTable jTableRLocalizacion, Object[] jField) {
        LocalizacionBean Bean = new LocalizacionBean();
        int Select = jTableRLocalizacion.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de Localizacion", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdLocalización(Integer.parseInt(jTableRLocalizacion.getValueAt(Select, 0).toString()));
            Bean.setPasillo(jField[0].toString());
            Bean.setEstatus(jField[1].toString());
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
     * @param jTableRLocalizacion // Contiene el objeto Tabla de la Vista
     */
    public void actionPerformedJEliminarLocalizacion(JTable jTableRLocalizacion) {
        DefaultTableModel ae = (DefaultTableModel) jTableRLocalizacion.getModel();
        int Select = jTableRLocalizacion.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarLocalizacion(Integer.parseInt(jTableRLocalizacion.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }
}
