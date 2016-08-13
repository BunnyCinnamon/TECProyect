package Vista;

import Classes.Beans.SocioBean;
import Controlador.CargarInfoControlador;
import Controlador.PrestamosControlador;
import Utils.CleanupDone;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

@CleanupDone
/**
 * Descripción: Vista de Prestamos, ver Prestamos con o sin fecha de expiración
 *
 */
public class VPrestamos extends javax.swing.JFrame {

    private static final CargarInfoControlador CARGAR = new CargarInfoControlador();
    private static final PrestamosControlador PRESTAMOS_CONTROLER = new PrestamosControlador();
    private int Login = 0;
    private SocioBean Stat;

    /**
     * Descripción: Inicializa la Vista.
     *
     */
    public VPrestamos() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent ev) {
//                dispose();
//            }
//        });
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
        IniciarAdmin(0);
        SetToolTipText();
    }

    /**
     * Descripción: Inicializa la Vista.
     *
     * @param Bean // Contiene el Bean de Socio
     */
    public VPrestamos(SocioBean Bean) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent ev) {
//                dispose();
//            }
//        });
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
        JLiberarSeleccion.setEnabled(false);
        this.Stat = Bean;
        this.Login = 1;
        IniciarSocio(Bean, 0);
        SetToolTipText();
    }

    private void SetToolTipText() {
        JDetalles.setToolTipText("Ver Detalles del Préstamo Seleccionado");
        JLiberarSeleccion.setToolTipText("Devolver Libro/Pagar Penalización");
        JLiberarSeleccion.setForeground(Color.red);
        ////////////////////////////////////////////////////////////////////////
        JRecargar.setToolTipText("Recargar Tabla");
    }

    /**
     * VRegistro de Prestamos*
     */
    private void IniciarAdmin(int accion) {
        DefaultTableModel Area = (DefaultTableModel) JTablePrestamos.getModel();
        CARGAR.CargarInfoPrestamos(Area, accion);
    }

    private void IniciarSocio(SocioBean Bean, int accion) {
        DefaultTableModel Area = (DefaultTableModel) JTablePrestamos.getModel();
        CARGAR.CargarInfoPrestamos(Area, Bean, accion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIconLeeyAprende = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablePrestamos = new javax.swing.JTable();
        jRegistrarLibro = new javax.swing.JLabel();
        JTabbedPrestamos = new javax.swing.JTabbedPane();
        JInternalEditar1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        JDetalles = new javax.swing.JButton();
        JLiberarSeleccion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JCheckExpirado = new javax.swing.JCheckBox();
        JRegresar = new javax.swing.JButton();
        JRecargar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Préstamos");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        JTablePrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Socio", "Titulo", "ISBN", "Fecha Inicial", "Expira"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTablePrestamos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTablePrestamos);

        jRegistrarLibro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jRegistrarLibro.setText("Préstamo de Libros");

        JInternalEditar1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel1.setText("Selección:");

        JDetalles.setText("Detalles");
        JDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDetallesActionPerformed(evt);
            }
        });

        JLiberarSeleccion.setText("Liberar");
        JLiberarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLiberarSeleccionActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconPrestamos.png"))); // NOI18N

        JCheckExpirado.setText("Expirado");

        javax.swing.GroupLayout JInternalEditar1Layout = new javax.swing.GroupLayout(JInternalEditar1.getContentPane());
        JInternalEditar1.getContentPane().setLayout(JInternalEditar1Layout);
        JInternalEditar1Layout.setHorizontalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(JDetalles)
                    .addComponent(JLiberarSeleccion)
                    .addComponent(JCheckExpirado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JInternalEditar1Layout.setVerticalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDetalles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLiberarSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckExpirado)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedPrestamos.addTab("Acciones", JInternalEditar1);

        JRegresar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JRegresar.setText("Regresar");
        JRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRegresarActionPerformed(evt);
            }
        });

        JRecargar.setText("Recargar");
        JRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRecargarActionPerformed(evt);
            }
        });

        jMenu1.setText("Ventana");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JMenuSalir.setText("Salir");
        JMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRegistrarLibro)
                        .addGap(136, 136, 136)
                        .addComponent(jIconLeeyAprende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(JTabbedPrestamos))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(JRecargar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jIconLeeyAprende)
                        .addComponent(JRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRegistrarLibro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(JTabbedPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JRecargar)
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_JRegresarActionPerformed

    private void JDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDetallesActionPerformed
        PRESTAMOS_CONTROLER.JDetallesActionPerformed(JTablePrestamos);
    }//GEN-LAST:event_JDetallesActionPerformed

    private void JLiberarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLiberarSeleccionActionPerformed
        PRESTAMOS_CONTROLER.JLiberarSeleccionActionPerformed(JTablePrestamos);
    }//GEN-LAST:event_JLiberarSeleccionActionPerformed

    private void JRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRecargarActionPerformed
        int accion = 0;
        if (JCheckExpirado.isSelected()) {
            accion = 1;
        }
        if (Login != 0) {
            IniciarSocio(Stat, accion);
        } else {
            IniciarAdmin(accion);
        }
    }//GEN-LAST:event_JRecargarActionPerformed

    private void JMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JMenuSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCheckExpirado;
    private javax.swing.JButton JDetalles;
    private javax.swing.JInternalFrame JInternalEditar1;
    private javax.swing.JButton JLiberarSeleccion;
    private javax.swing.JMenuItem JMenuSalir;
    private javax.swing.JButton JRecargar;
    private javax.swing.JButton JRegresar;
    private javax.swing.JTabbedPane JTabbedPrestamos;
    public javax.swing.JTable JTablePrestamos;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jRegistrarLibro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
