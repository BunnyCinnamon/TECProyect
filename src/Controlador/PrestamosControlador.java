package Controlador;

import Modelo.PrestamosDAO;
import Utils.CleanupDone;
import Vista.VDynamicTable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Prestamos
 *
 */
@CleanupDone
public class PrestamosControlador {

    private static final PrestamosDAO ADM = new PrestamosDAO();

    /**
     * Descripción: Elimina el Préstamo de la base de datos.
     *
     * Variables:
     *
     * @param jTablePrestamos //Contiene el objeto Tabla de la Vista
     */
    public void JLiberarSeleccionActionPerformed(JTable jTablePrestamos) {
        DefaultTableModel Area = (DefaultTableModel) jTablePrestamos.getModel();
        int Select = jTablePrestamos.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro por completo?")) {
            int id = Integer.parseInt(jTablePrestamos.getValueAt(Select, 0).toString());
            if (ADM.EliminarPrestamo(id)) {
                Area.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Descripción: Abre una nueva ventana de Detalles.
     *
     * Variables:
     *
     * @param jTablePrestamos //Contiene el objeto Tabla de la Vista
     */
    public void JDetallesActionPerformed(JTable jTablePrestamos) {
        DefaultTableModel model = (DefaultTableModel) jTablePrestamos.getModel();
        int Select = jTablePrestamos.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else {
            String[] columns = {"id", "Socio", "Titulo", "ISBN", "Fecha Inicial", "Expira", "Retraso", "Monto a Pagar"};
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList jArray = new ArrayList();
            long diffDays;
            for (int i = 0; i < model.getColumnCount(); i++) {
                jArray.add(model.getValueAt(Select, i));
            }
            try {
                Date startDate = formatter.parse(jArray.get(4).toString());
                Date finalDate = formatter.parse(jArray.get(5).toString());
                long diff = Math.abs(finalDate.getTime() - startDate.getTime());
                diffDays = diff / (24 * 60 * 60 * 1000);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
                return;
            }
            jArray.add(diffDays + " Dias");
            if (diffDays <= 3) {
                jArray.add("$5");
            } else if (diffDays <= 6) {
                jArray.add("$10");
            } else if (diffDays <= 10) {
                jArray.add("$20");
            } else if (diffDays <= 20) {
                jArray.add("$50");
            } else if (diffDays <= 50) {
                jArray.add("$499.99");
            }
            DefaultTableModel jModel = new DefaultTableModel(columns, 0);
            jModel.addRow(jArray.toArray());
            VDynamicTable vDynamic = new VDynamicTable(jModel);
            vDynamic.setVisible(true);
        }
    }

}
