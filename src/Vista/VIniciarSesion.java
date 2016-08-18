package Vista;

import Controlador.IniciarSesionControlador;
import Utils.CleanupDone;
import Utils.FileReader;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * Descripción: Vista de Inicio
 *
 */
@CleanupDone
public class VIniciarSesion extends javax.swing.JFrame {
    
    private static final FileReader FILE_READER = new FileReader();
    private String user = "";
    private String login = "";

    /**
     * Descripción: Inicializa la Vista y lee el archivo logins.properties.
     *
     */
    public VIniciarSesion() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
        ReadFile();
        ////////////////////////////////////////////////////////////////////////
        JUsuario.setToolTipText("Desactivar en caso de ser Socio");
        JRecordar.setToolTipText("Recuerda tu nombre de Usuario");
        JUsuario.setSelected(true);
    }

    /**
     * Uso: Lee el contenido del archivo logins.properties y busca por errores
     * en la configuración.
     *
     * Descripción: Si la vista tiene el recordar usuario activado el programa
     * lee el usuario y lo inserta en la vista. Si la vista si no puede leer el
     * archivo, manda un mensaje a la vista.
     *
     */
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    private void ReadFile() {
        if (FILE_READER.readXML()) {
            if (FILE_READER.getLogin().equals("true")) {
                JUsuarioInicio.setText(FILE_READER.getUser());
                JRecordar.setSelected(true);
            }
        } else {
            JAnounce.setText("Error en el archivo de Login");
        }
    }

    /**
     * Uso: Encuentra el archivo y lo edita.
     *
     * Descripción: Busca la ubicación de guardado, edita el usuario a "n" y
     * login a "true" si el check box esta seleccionado, si no lo esta edita el
     * login a "false".
     *
     */
    private void saveFile() {
        if (JRecordar.isSelected()) {
            user = JUsuarioInicio.getText();
            login = "true";
        } else {
            user = "";
            login = "false";
        }
        FILE_READER.saveToXML(user, login);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
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
        jIconCodeWork = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        javax.swing.GroupLayout JLeeyAprendeIconLayout = new javax.swing.GroupLayout(JLeeyAprendeIcon);
        JLeeyAprendeIcon.setLayout(JLeeyAprendeIconLayout);
        JLeeyAprendeIconLayout.setHorizontalGroup(
            JLeeyAprendeIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JLeeyAprendeIconLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jIconLeeyAprende)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jIconSession, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        JRecordar.setText("Recordar Usuario");

        jIconCodeWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logomini.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(JLeeyAprendeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JAnounce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(JRecordar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jIconCodeWork))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUsuario)
                            .addComponent(jContraseña))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JContraseñaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JIngresar))
                        .addGap(55, 55, 55)
                        .addComponent(JSesionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JLeeyAprendeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUsuario)
                            .addComponent(JUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jContraseña)
                            .addComponent(JContraseñaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JSesionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JIngresar)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JRecordar)
                        .addComponent(JUsuario))
                    .addComponent(jIconCodeWork))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(JAnounce))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarActionPerformed
        if (JUsuarioInicio.getText().isEmpty() || JContraseñaInicio.getText().isEmpty()) {
            JAnounce.setText("Por favor ingrese un Usuario y Contraseña");
            return;
        }
        IniciarSesionControlador IniciarSesionControlador = new IniciarSesionControlador();
        saveFile();
        IniciarSesionControlador.actionPerformed(this);
    }//GEN-LAST:event_JIngresarActionPerformed

    private void JUsuarioInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JUsuarioInicioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JContraseñaInicio.requestFocus();
        }
    }//GEN-LAST:event_JUsuarioInicioKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JAnounce;
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
    private javax.swing.JLabel jUsuario;
    // End of variables declaration//GEN-END:variables
}
