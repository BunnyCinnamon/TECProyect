package Controlador;

import Classes.Beans.SocioBean;
import Modelo.CargarInfoDAO;
import Utils.CleanupDone;
import Vista.VDetalles;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Cargador de textos
 *
 */
@CleanupDone
public class CargarInfoControlador {

    private static final CargarInfoDAO CARGAR = new CargarInfoDAO();

    /**
     * Uso: CARGAR Información de las Listas en Vista Administador.
     *
     * Descripción: Envia los objetos para ser llenados con información.
     *
     * @param jFieldCombo // Contiene los objetos ComboBox
     * @param jFieldList // Contiene los objetos List
     */
    public void CargarInfoListas(JComboBox[] jFieldCombo, JList[] jFieldList) {
        if (!CARGAR.LoadInfoVAdmin(jFieldCombo, jFieldList)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: CARGAR Información de las Listas en Vista Socio.
     *
     * Descripción: Envia los objetos para ser llenados con información.
     *
     * @param jFieldList // Contiene los objetos List
     */
    public void CargarInfoListas(JList[] jFieldList) {
        if (!CARGAR.LoadInfoVSocio(jFieldList)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: CARGAR Información de Prestamos en Vista Administrador.
     *
     * Descripción: Si ocurre un error se manda un Texto en JOptionPane.
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @param accion // Contiene el tipo de acción
     */
    public void CargarInfoPrestamos(DefaultTableModel t, int accion) {
        if (!CARGAR.LoadPrestamos(t, accion)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: CARGAR Información de Prestamos en Vista Administrador.
     *
     * Descripción: Si ocurre un error se manda un Texto en JOptionPane.
     *
     * @param t // Contiene el objeto Tabla de la Vista
     * @param Bean // Contiene los datos del Socio
     * @param accion // Contiene el tipo de acción
     */
    public void CargarInfoPrestamos(DefaultTableModel t, SocioBean Bean, int accion) {
        if (!CARGAR.LoadPrestamos(t, Bean, accion)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: CARGAR Información de Estadisticas.
     *
     * Descripción: Si ocurre un error se manda un Texto en JOptionPane.
     *
     */
    public void CargarInfoEstadisticas() {
        VDetalles Detalles = new VDetalles();
        Detalles.setLocationRelativeTo(null);
        Detalles.setVisible(true);
        if (!CARGAR.LoadDetalles(Detalles)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Información!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: Buscar Información de Localizacion.
     *
     * Descripción: Si ocurre un error se manda un Texto en JOptionPane.
     *
     * @param t // Contiene el objeto Tabla de la Vista
     */
    public void CargarLocalizacion(DefaultTableModel t) {
        if (!CARGAR.LoadLocalizacion(t)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Localización!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: Buscar Información de Area.
     *
     * Descripción: Si ocurre un error se manda un Texto en JOptionPane.
     *
     * @param t // Contiene el objeto Tabla de la Vista
     */
    public void CargarArea(DefaultTableModel t) {
        if (!CARGAR.LoadArea(t)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Área!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: Buscar Información de Editorial.
     *
     * Descripción: Si ocurre un error se manda un Texto en JOptionPane.
     *
     * @param t // Contiene el objeto Tabla de la Vista
     */
    public void CargarEditorial(DefaultTableModel t) {
        if (!CARGAR.LoadEditorial(t)) {
            JOptionPane.showMessageDialog(null, "Error al cargar Editorial!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Uso: Buscar Texto de Libros.
     *
     * Descripción: Busca información y la ingresa en un arraylist.
     *
     * @return // Regresa los Textos encontrados
     */
    public ArrayList<String> CargarTexts() {
        ArrayList array = CARGAR.LoadTexts();
        return array;
    }
}
