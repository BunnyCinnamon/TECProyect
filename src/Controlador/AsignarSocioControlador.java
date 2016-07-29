package Controlador;

import Classes.Beans.SocioBean;
import Modelo.AsignarSocioDAO;
import Utils.CleanupDone;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class AsignarSocioControlador {

    /**
     * Cargar Datos a la vista del Asignar Socio. Lee los objetos y los
     * introduce en variables tipo tabla objeto, tipo bean socio y tipo array
     * list. Introduce los datos a las tablas en la vista
     *
     * @param U // Contiene los objetos de Tablas
     */
    public void LoadData(Object[] U) {
        DefaultTableModel model = (DefaultTableModel) U[0];
        DefaultTableModel model0 = (DefaultTableModel) U[1];
        SocioBean SocioBean = (SocioBean) U[2];
        ArrayList Array = (ArrayList) U[3];
        ////////////////////////////////////////////////////////////////////////
        model.addRow(new Object[]{Array.get(1), Array.get(2), Array.get(3), Array.get(4), Array.get(5)});
        model0.addRow(new Object[]{SocioBean.getNombre(), SocioBean.getApellidoP(), SocioBean.getApellidoM(), SocioBean.getEstado() + " " + SocioBean.getMunicipio(), SocioBean.getUsuario()});
    }

    /**
     * Aceptar el Prestamo solicitado. Introduce los datos de las tablas a un
     * objeto y las envia a un dao correspondiente. Si el ingreso fué exitoso o
     * erroneo envia un texto a JOptionPane
     *
     * @param U // Contiene los objetos de Tablas
     */
    public void actionPerformedJAceptarPrestamo(Object[] U) {
        AsignarSocioDAO AsignarSocioDAO = new AsignarSocioDAO();
        if (AsignarSocioDAO.AsignarSocioDAO(U)) {
            JOptionPane.showMessageDialog(null, "El Libro ha sido prestado", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Este Libro no se puede prestar", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

}
