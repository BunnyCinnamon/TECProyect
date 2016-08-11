package Resources;

import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Uso: Cargar Imágenes en la carpeta del jar.
 *
 */
public class ResourceHelper {

    private ResourceHelper() {
    }

    public static ImageIcon cargarImagen(String n) {
        ImageIcon img = null;
        try {
            URL url = ResourceHelper.class.getResource(n);
            if (url != null) {
                Image i = Toolkit.getDefaultToolkit().createImage(url);
                if (i != null) {
                    img = new ImageIcon(i);
                }
            }
        } catch (Throwable ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return img;
    }
}
