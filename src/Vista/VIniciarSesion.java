package Vista;

import Controlador.IniciarSesionControlador;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Arekkuusu
 */
public class VIniciarSesion extends javax.swing.JFrame {

    private static String usuario;
    private static ResourceBundle propertiesLogins;
    private String filePath;

    /**
     * Inicia los componentes de la vista y lee el archivo logins.properties.
     *
     */
    public VIniciarSesion() {
        initComponents();
        this.setResizable(false);
        ReadFile();
        ////////////////////////////////////////////////////////////////////////
        JUsuario.setToolTipText("Desactivar en caso de ser Socio");
        JRecordar.setToolTipText("Recuerda tu nombre de Usuario");
    }

    /**
     * Lee el contenido del archivo logins.properties y busca por errores en la
     * configuración. Si la vista tiene el recordar usuario activado el programa
     * lee el usuario y lo inserta en la vista. Si la vita si no puede leer el
     * archivo, manda un mensaje a la vista.
     *
     */
    private void ReadFile() {
        if (propertiesLogins == null) {
            propertiesLogins = ResourceBundle.getBundle("logins");
            try {
                filePath = propertiesLogins.getString("path");
                if (propertiesLogins.getString("login").equals("true")) {
                    JUsuario.setSelected(true);
                    JRecordar.setSelected(true);
                    usuario = propertiesLogins.getString("usuario");
                    JUsuarioInicio.setText(usuario);
                } else if (!propertiesLogins.getString("login").equals("true") && !propertiesLogins.getString("login").equals("false")) {
                    JAnounce.setText("Error in configuration file: Cannot reach TRUE or FALSE value");
                }
            } catch (java.util.MissingResourceException e) {
                System.err.println("Error in configuration file: " + e.getMessage());
                JAnounce.setText("Error in configuration file: " + e.getMessage());
            }
        }
    }

    /**
     * Encuentra el archivo y lo edita. Busca el archivo, lo carga como un
     * archivo de propiedades y lo cierra. Después busca la ubicación de
     * guardado, edita el usuario a "n" y login a "true" si el check box esta
     * seleccionado, si no lo esta edita el login a "false". Finalmente inserta
     * la fecha de modificación y un texo informativo en el archivo
     *
     */
    private void saveFile() {
        FileInputStream in = null;
        try {
            in = new FileInputStream(filePath);
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(filePath);
            if (JRecordar.isSelected()) {
                props.setProperty("usuario", JUsuarioInicio.getText());
                props.setProperty("login", "true");
            } else {
                props.setProperty("login", "false");
            }
            props.store(out, "--UsuarioDefault es \"usuario\" | Booleano-\"true-o-False\" es \"login\" | PathFile es \"path\"");
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VIniciarSesion.class.getName()).log(Level.SEVERE, "Error", ex);
        } catch (IOException ex) {
            Logger.getLogger(VIniciarSesion.class.getName()).log(Level.SEVERE, "Error", ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(VIniciarSesion.class.getName()).log(Level.SEVERE, "Error", ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTattooUtilities1 = new com.jtattoo.plaf.JTattooUtilities();
        jSeparator1 = new javax.swing.JSeparator();
        JCodeWorkIcon = new javax.swing.JPanel();
        jIconCodeWork = new javax.swing.JLabel();
        JLeeyAprendeIcon = new javax.swing.JPanel();
        jIconLeeyAprende = new javax.swing.JLabel();
        jUsuario = new javax.swing.JLabel();
        jContraseña = new javax.swing.JLabel();
        JUsuario = new javax.swing.JCheckBox();
        JIngresar = new javax.swing.JButton();
        JUsuarioInicio = new javax.swing.JTextField();
        JContraseñaInicio = new javax.swing.JPasswordField();
        JSesionIcon = new javax.swing.JPanel();
        jIconSession = new javax.swing.JLabel();
        JAnounce = new javax.swing.JLabel();
        JRecordar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");

        jIconCodeWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logo.jpg"))); // NOI18N

        javax.swing.GroupLayout JCodeWorkIconLayout = new javax.swing.GroupLayout(JCodeWorkIcon);
        JCodeWorkIcon.setLayout(JCodeWorkIconLayout);
        JCodeWorkIconLayout.setHorizontalGroup(
            JCodeWorkIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JCodeWorkIconLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jIconCodeWork)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        JCodeWorkIconLayout.setVerticalGroup(
            JCodeWorkIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JCodeWorkIconLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jIconCodeWork, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        javax.swing.GroupLayout JLeeyAprendeIconLayout = new javax.swing.GroupLayout(JLeeyAprendeIcon);
        JLeeyAprendeIcon.setLayout(JLeeyAprendeIconLayout);
        JLeeyAprendeIconLayout.setHorizontalGroup(
            JLeeyAprendeIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JLeeyAprendeIconLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jIconLeeyAprende)
                .addGap(18, 18, 18))
        );
        JLeeyAprendeIconLayout.setVerticalGroup(
            JLeeyAprendeIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIconLeeyAprende, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jUsuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jUsuario.setText("Usuario:");

        jContraseña.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jContraseña.setText("Contraseña:");

        JUsuario.setText("Ingresar como Administrador");

        JIngresar.setText("Ingresar");
        JIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarActionPerformed(evt);
            }
        });

        JUsuarioInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JUsuarioInicioKeyPressed(evt);
            }
        });

        jIconSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/key-icon.png"))); // NOI18N

        javax.swing.GroupLayout JSesionIconLayout = new javax.swing.GroupLayout(JSesionIcon);
        JSesionIcon.setLayout(JSesionIconLayout);
        JSesionIconLayout.setHorizontalGroup(
            JSesionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIconSession, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        JSesionIconLayout.setVerticalGroup(
            JSesionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIconSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JRecordar.setText("Recordar Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JCodeWorkIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLeeyAprendeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUsuario)
                            .addComponent(jContraseña))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JContraseñaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addComponent(JSesionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JAnounce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JRecordar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(193, 193, 193)
                                        .addComponent(JIngresar)))
                                .addGap(4, 187, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JCodeWorkIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLeeyAprendeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUsuario)
                            .addComponent(JUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jContraseña)
                            .addComponent(JContraseñaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JSesionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(JIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JUsuario)
                    .addComponent(JRecordar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JAnounce))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarActionPerformed
        IniciarSesionControlador IniciarSesionControlador = new IniciarSesionControlador();
        saveFile();
        IniciarSesionControlador.actionPerformed(this);
    }//GEN-LAST:event_JIngresarActionPerformed

    private void JUsuarioInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JUsuarioInicioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JContraseñaInicio.requestFocus();
        }
    }//GEN-LAST:event_JUsuarioInicioKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JAnounce;
    private javax.swing.JPanel JCodeWorkIcon;
    public javax.swing.JPasswordField JContraseñaInicio;
    public javax.swing.JButton JIngresar;
    private javax.swing.JPanel JLeeyAprendeIcon;
    private javax.swing.JCheckBox JRecordar;
    private javax.swing.JPanel JSesionIcon;
    public javax.swing.JCheckBox JUsuario;
    public javax.swing.JTextField JUsuarioInicio;
    private javax.swing.JLabel jContraseña;
    private javax.swing.JLabel jIconCodeWork;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jIconSession;
    private javax.swing.JSeparator jSeparator1;
    private com.jtattoo.plaf.JTattooUtilities jTattooUtilities1;
    private javax.swing.JLabel jUsuario;
    // End of variables declaration//GEN-END:variables
}
