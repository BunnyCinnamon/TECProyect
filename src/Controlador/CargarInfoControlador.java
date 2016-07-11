package Controlador;

import Classes.Beans.SocioBean;
import Modelo.CargarInfoDAO;
import Vista.VAdministrador;
import Vista.VBuscarLibro;
import Vista.VDetalles;
import Vista.VPrestamos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CargarInfoControlador {

    public CargarInfoDAO Cargar = new CargarInfoDAO();

    /**
     * Cargar Información
     *
     *
     * @param va
     */
    public void CargarInfoListas(VAdministrador va) {
        if (!Cargar.LoadInfoVAdmin(va)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CargarInfoListas(VBuscarLibro va) {
        if (!Cargar.LoadInfoVSocio(va)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cargar Prestamos
     *
     *
     * @param va
     * @param t
     */
    public void CargarInfoPrestamos(VPrestamos va, DefaultTableModel t) {
        if (!Cargar.LoadPrestamos(va, t)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CargarInfoPrestamos(VPrestamos va, DefaultTableModel t, SocioBean Bean) {
        if (!Cargar.LoadPrestamos(va, t, Bean)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cargar Estadisticas
     *
     *
     */
    public void CargarInfoEstadisticas() {
        VDetalles Detalles = new VDetalles();
        Detalles.setLocationRelativeTo(null);
        Detalles.setVisible(true);
        if (!Cargar.LoadDetalles(Detalles)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Buscar Localizacion
     *
     *
     * @param va
     * @param t
     */
    public void CargarLocalizacion(VAdministrador va, DefaultTableModel t) {
        if (!Cargar.LoadLocalizacion(va, t)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Localización!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Buscar Area
     *
     *
     * @param va
     * @param t
     */
    public void CargarArea(VAdministrador va, DefaultTableModel t) {
        if (!Cargar.LoadArea(va, t)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Área!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Buscar Editorial
     *
     *
     * @param va
     * @param t
     */
    public void CargarEditorial(VAdministrador va, DefaultTableModel t) {
        if (!Cargar.LoadEditorial(va, t)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Editorial!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
