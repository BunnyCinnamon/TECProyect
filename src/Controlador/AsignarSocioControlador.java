package Controlador;

import Classes.Beans.SocioBean;
import Modelo.AsignarSocioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AsignarSocioControlador {

    public void LoadData(Object[] U) {
        DefaultTableModel model = (DefaultTableModel) U[0];
        DefaultTableModel model0 = (DefaultTableModel) U[1];
        SocioBean SocioBean = (SocioBean) U[2];
        ArrayList Array = (ArrayList) U[3];
        ////////////////////////////////////////////////////////////////////////
        model.addRow(new Object[]{Array.get(1), Array.get(2), Array.get(3), Array.get(4), Array.get(5)});
        model0.addRow(new Object[]{SocioBean.getNormbre(), SocioBean.getApellidoP(), SocioBean.getApellidoM(), SocioBean.getEstado() + " " + SocioBean.getMunicipio(), SocioBean.getUsuario()});
    }

    public void actionPerformedJAceptarPrestamo(Object[] U) {
        AsignarSocioDAO AsignarSocioDAO = new AsignarSocioDAO();
        if (AsignarSocioDAO.AsignarSocioDAO(U)) {
            JOptionPane.showMessageDialog(null, "El Libro ha sido prestado", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Este Libro no se puede prestar", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

}
