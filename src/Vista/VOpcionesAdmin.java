package Vista;

import Classes.Beans.AdministradorBean;
import Controlador.OpcionesControladorAdmin;
import Controlador.SalirControlador;
import Resources.ResourceHelper;
import Utils.CleanupDone;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Descripción: Vista de Administrador
 *
 */
@CleanupDone
public class VOpcionesAdmin extends javax.swing.JFrame {

    private static final OpcionesControladorAdmin OPCIONES_CONTROLER = new OpcionesControladorAdmin();
    private static final String ICON_RING = "Load.gif";
    private static final String ICON_BOOK = "IconLibros.png";
    private static final String ICON_LIBRARY = "IconBookshelf.png";
    private static final String ICON_BORROW = "IconPrestamos.png";

    /**
     * Descripción: Inicializa la Vista.
     *
     * @param Bean // Contiene el Bean de Administrador
     */
    public VOpcionesAdmin(AdministradorBean Bean) {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ev) {
                SalirControlador SalirControlador = new SalirControlador();
                SalirControlador.actionPerformed();
            }
        });
        SetBean(Bean);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
        JBibliotecaOpen.setToolTipText("Agregar, Modificar, y Eliminar Registros");
        JPrestamosOpen.setToolTipText("Ver todos los Préstamos");
    }

    private AdministradorBean Bean;

    private void SetBean(AdministradorBean Bean) {
        this.Bean = Bean;
    }

    private void setIcon(JLabel label, String icon) {
        label.setIcon(ResourceHelper.cargarImagen(icon));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jIconLeeyAprende = new javax.swing.JLabel();
        JVerContabilidad = new javax.swing.JPanel();
        JPrestamosOpen = new javax.swing.JLabel();
        JModificarBiblioteca = new javax.swing.JPanel();
        JBibliotecaOpen = new javax.swing.JLabel();
        jPrestamos = new javax.swing.JLabel();
        jBiblioteca = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPrestamos1 = new javax.swing.JLabel();
        JVerContabilidad1 = new javax.swing.JPanel();
        JLibrosOpen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenuCerrarSesion = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        JPrestamosOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconPrestamos.png"))); // NOI18N
        JPrestamosOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JPrestamosOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPrestamosOpenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPrestamosOpenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPrestamosOpenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JVerContabilidadLayout = new javax.swing.GroupLayout(JVerContabilidad);
        JVerContabilidad.setLayout(JVerContabilidadLayout);
        JVerContabilidadLayout.setHorizontalGroup(
            JVerContabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPrestamosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JVerContabilidadLayout.setVerticalGroup(
            JVerContabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPrestamosOpen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JBibliotecaOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconBookshelf.png"))); // NOI18N
        JBibliotecaOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBibliotecaOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBibliotecaOpenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JBibliotecaOpenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JBibliotecaOpenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JModificarBibliotecaLayout = new javax.swing.GroupLayout(JModificarBiblioteca);
        JModificarBiblioteca.setLayout(JModificarBibliotecaLayout);
        JModificarBibliotecaLayout.setHorizontalGroup(
            JModificarBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JBibliotecaOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JModificarBibliotecaLayout.setVerticalGroup(
            JModificarBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JBibliotecaOpen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPrestamos.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPrestamos.setText("Préstamos");

        jBiblioteca.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jBiblioteca.setText("Biblioteca");

        jPrestamos1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jPrestamos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPrestamos1.setText("Asignación");

        JLibrosOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconLibros.png"))); // NOI18N
        JLibrosOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLibrosOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLibrosOpenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLibrosOpenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLibrosOpenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JVerContabilidad1Layout = new javax.swing.GroupLayout(JVerContabilidad1);
        JVerContabilidad1.setLayout(JVerContabilidad1Layout);
        JVerContabilidad1Layout.setHorizontalGroup(
            JVerContabilidad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLibrosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JVerContabilidad1Layout.setVerticalGroup(
            JVerContabilidad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLibrosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Ventana");

        JMenuCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.SHIFT_MASK));
        JMenuCerrarSesion.setText("Cerrar Sesión");
        JMenuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuCerrarSesion);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jIconLeeyAprende)
                .addContainerGap(315, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JModificarBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jBiblioteca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JVerContabilidad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPrestamos1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JVerContabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JVerContabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPrestamos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jIconLeeyAprende)
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(JModificarBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBiblioteca))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(JVerContabilidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPrestamos1)))))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JPrestamosOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPrestamosOpenMouseClicked
        OPCIONES_CONTROLER.actionPerformedJPrestamosOpen();
    }//GEN-LAST:event_JPrestamosOpenMouseClicked

    private void JBibliotecaOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBibliotecaOpenMouseClicked
        OPCIONES_CONTROLER.actionPerformedJBibliotecaOpen();
    }//GEN-LAST:event_JBibliotecaOpenMouseClicked

    private void JMenuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuCerrarSesionActionPerformed
        SalirControlador SalirControlador = new SalirControlador();
        SalirControlador.actionPerformed();
    }//GEN-LAST:event_JMenuCerrarSesionActionPerformed

    private void JBibliotecaOpenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBibliotecaOpenMouseEntered
        setIcon(JBibliotecaOpen, ICON_RING);
    }//GEN-LAST:event_JBibliotecaOpenMouseEntered

    private void JBibliotecaOpenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBibliotecaOpenMouseExited
        setIcon(JBibliotecaOpen, ICON_LIBRARY);
    }//GEN-LAST:event_JBibliotecaOpenMouseExited

    private void JPrestamosOpenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPrestamosOpenMouseEntered
        setIcon(JPrestamosOpen, ICON_RING);
    }//GEN-LAST:event_JPrestamosOpenMouseEntered

    private void JPrestamosOpenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPrestamosOpenMouseExited
        setIcon(JPrestamosOpen, ICON_BORROW);
    }//GEN-LAST:event_JPrestamosOpenMouseExited

    private void JLibrosOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLibrosOpenMouseClicked
        OPCIONES_CONTROLER.actionPerformedJLibrosOpen(Bean);
    }//GEN-LAST:event_JLibrosOpenMouseClicked

    private void JLibrosOpenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLibrosOpenMouseEntered
        setIcon(JLibrosOpen, ICON_RING);
    }//GEN-LAST:event_JLibrosOpenMouseEntered

    private void JLibrosOpenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLibrosOpenMouseExited
        setIcon(JLibrosOpen, ICON_BOOK);
    }//GEN-LAST:event_JLibrosOpenMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JBibliotecaOpen;
    public javax.swing.JLabel JLibrosOpen;
    private javax.swing.JMenuItem JMenuCerrarSesion;
    private javax.swing.JPanel JModificarBiblioteca;
    public javax.swing.JLabel JPrestamosOpen;
    private javax.swing.JPanel JVerContabilidad;
    private javax.swing.JPanel JVerContabilidad1;
    private javax.swing.JLabel jBiblioteca;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel jPrestamos;
    private javax.swing.JLabel jPrestamos1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
