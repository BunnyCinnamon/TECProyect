package Vista;

import Controlador.OpcionesControladorAdmin;
import Controlador.SalirControlador;
import Utils.CleanupDone;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

@CleanupDone
/**
 * Vista de Administrador
 *
 */
public class VOpcionesAdmin extends javax.swing.JFrame {

    private static final OpcionesControladorAdmin OPCIONES_CONTROLER = new OpcionesControladorAdmin();

    public VOpcionesAdmin() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
        JBibliotecaOpen.setToolTipText("Agregar, Modificar, y Eliminar Registros");
        JPrestamosOpen.setToolTipText("Ver todos los Préstamos pendientes");
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

        JPrestamosOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467284813_OFFice-90.png"))); // NOI18N
        JPrestamosOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JPrestamosOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPrestamosOpenMouseClicked(evt);
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
            .addComponent(JPrestamosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JBibliotecaOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467286183_bookshelf.png"))); // NOI18N
        JBibliotecaOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBibliotecaOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBibliotecaOpenMouseClicked(evt);
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
            .addComponent(JBibliotecaOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPrestamos.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPrestamos.setText("Préstamos");

        jBiblioteca.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jBiblioteca.setText("Biblioteca");

        jMenu1.setText("Opciones");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JModificarBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jBiblioteca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JVerContabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(177, 177, 177))
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
                        .addGap(102, 102, 102)
                        .addComponent(JModificarBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBiblioteca)))
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
        this.setVisible(false);
    }//GEN-LAST:event_JMenuCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JBibliotecaOpen;
    private javax.swing.JMenuItem JMenuCerrarSesion;
    private javax.swing.JPanel JModificarBiblioteca;
    public javax.swing.JLabel JPrestamosOpen;
    private javax.swing.JPanel JVerContabilidad;
    private javax.swing.JLabel jBiblioteca;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel jPrestamos;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
