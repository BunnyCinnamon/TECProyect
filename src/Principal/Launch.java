package Principal;

import Utils.CleanupDone;
import Vista.VIniciarSesion;
import java.awt.Color;
import javax.swing.UIManager;

@CleanupDone
public class Launch {

    private static boolean isLoaded;

    /**
     * Llama el método de Textura y carga una nueva ventana Iniciar Sesión. Si
     * isloaded es false manda un aviso a la vista inicio
     */
    public static void main(String[] args) {
        isLoaded = loadTexture();
        VIniciarSesion IniciarSesion = new VIniciarSesion();
        IniciarSesion.setLocationRelativeTo(null);
        IniciarSesion.setVisible(true);
        if (!isLoaded) {
            IniciarSesion.JIngresar.setToolTipText("La Textura del Programa no se ha podido cargar, proceda con normalidad");
            IniciarSesion.JIngresar.setForeground(Color.RED);
        }
    }

    /**
     * Carga la Textura del programa. Devuelve un true si encuentra el look and
     * feel, false si ocurre un error
     *
     */
    private static boolean loadTexture() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
