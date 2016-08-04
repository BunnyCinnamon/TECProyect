package Vista;

import Classes.Beans.SocioBean;
import Controlador.AsignarSocioControlador;
import Utils.CleanupDone;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

@CleanupDone
/**
 * Vista de Asignación de Libro a Socio
 *
 */
public class VAsignarSocio extends javax.swing.JFrame {

    private static final AsignarSocioControlador ASIGNAR_SOCIO_CONTROLER = new AsignarSocioControlador();
    private final SocioBean SOCIO_BEAN;
    private final ArrayList ARRAY_LIST;

    public VAsignarSocio(SocioBean Bean, ArrayList Array) {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
        LoadData(Bean, Array);
        this.SOCIO_BEAN = Bean;
        this.ARRAY_LIST = Array;
        ////////////////////////////////////////////////////////////////////////
        JTableBLibro.setToolTipText("Libro Seleccionado Previamente");
        JTableBSocio.setToolTipText("Socio loggeado en el sistema");
        JAceptarAsignar.setForeground(Color.red);
        JAbortar.setForeground(Color.red);
    }

    private void LoadData(SocioBean Bean, ArrayList Array) {
        DefaultTableModel model = (DefaultTableModel) JTableBLibro.getModel();
        DefaultTableModel model0 = (DefaultTableModel) JTableBSocio.getModel();
        ASIGNAR_SOCIO_CONTROLER.LoadData(new Object[]{model, model0, Bean, Array});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIconLeeyAprende = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JAbortar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableBLibro = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableBSocio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JAceptarAsignar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuOpciones = new javax.swing.JMenu();
        JMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Préstamos");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        JAbortar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JAbortar.setText("Abortar");
        JAbortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAbortarActionPerformed(evt);
            }
        });

        JTableBLibro.setForeground(new java.awt.Color(186, 57, 169));
        JTableBLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "ISBN", "N° Pag", "Autor", "Editorial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableBLibro.setEnabled(false);
        JTableBLibro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTableBLibro);

        JTableBSocio.setForeground(new java.awt.Color(0, 208, 40));
        JTableBSocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableBSocio.setEnabled(false);
        JTableBSocio.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(JTableBSocio);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Asignando Libro:");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("A Socio:");

        JAceptarAsignar.setText("Aceptar");
        JAceptarAsignar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JAceptarAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAceptarAsignarActionPerformed(evt);
            }
        });

        JMenuOpciones.setText("Opciones");

        JMenuSalir.setText("Salir");
        JMenuOpciones.add(JMenuSalir);

        jMenuBar1.add(JMenuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jIconLeeyAprende)
                                .addGap(116, 116, 116)
                                .addComponent(JAbortar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(JAceptarAsignar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIconLeeyAprende)
                    .addComponent(JAbortar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JAceptarAsignar)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JAceptarAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAceptarAsignarActionPerformed
        ASIGNAR_SOCIO_CONTROLER.actionPerformedJAceptarPrestamo(new Object[]{SOCIO_BEAN, ARRAY_LIST});
        dispose();
    }//GEN-LAST:event_JAceptarAsignarActionPerformed

    private void JAbortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAbortarActionPerformed
        dispose();
    }//GEN-LAST:event_JAbortarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JAbortar;
    private javax.swing.JButton JAceptarAsignar;
    private javax.swing.JMenu JMenuOpciones;
    private javax.swing.JMenuItem JMenuSalir;
    public javax.swing.JTable JTableBLibro;
    public javax.swing.JTable JTableBSocio;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
