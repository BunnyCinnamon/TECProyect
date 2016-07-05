
package Vista;

import Controlador.SalirControlador;

public class VBuscarSocios extends javax.swing.JFrame {

    public VBuscarSocios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jIconLeeyAprende = new javax.swing.JLabel();
        jRegistrarLibro = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableBSocio = new javax.swing.JTable();
        JTabbedBusquedaSocios = new javax.swing.JTabbedPane();
        JInternalEditar4 = new javax.swing.JInternalFrame();
        JDetallesSocio = new javax.swing.JButton();
        JLimpiarTablaSocio = new javax.swing.JButton();
        JBuscarSocio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JInternalBuscar = new javax.swing.JInternalFrame();
        JCheckNombre = new javax.swing.JCheckBox();
        JCheckApellidoP = new javax.swing.JCheckBox();
        JCheckApellidoM = new javax.swing.JCheckBox();
        JBuscarSocio1 = new javax.swing.JButton();
        JCheckEstado = new javax.swing.JCheckBox();
        JCheckMunicipio = new javax.swing.JCheckBox();
        JCheckTelefono = new javax.swing.JCheckBox();
        JCheckNombre1 = new javax.swing.JCheckBox();
        jTitulo = new javax.swing.JLabel();
        JNombreText = new javax.swing.JTextField();
        jISBN = new javax.swing.JLabel();
        JApellidoPText = new javax.swing.JTextField();
        jNPag = new javax.swing.JLabel();
        JApellidoMText = new javax.swing.JTextField();
        jTitulo1 = new javax.swing.JLabel();
        JEstadoText = new javax.swing.JTextField();
        jTitulo2 = new javax.swing.JLabel();
        JMunicipioText = new javax.swing.JTextField();
        jTitulo3 = new javax.swing.JLabel();
        JCalleText = new javax.swing.JTextField();
        jTitulo5 = new javax.swing.JLabel();
        JTelefonoText = new javax.swing.JTextField();
        jTitulo4 = new javax.swing.JLabel();
        JNCalleText = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JMenuBuscarPrestamos = new javax.swing.JMenuItem();
        JMenuBuscarLibro = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        jRegistrarLibro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jRegistrarLibro.setText("Búsqueda de Socios");

        JRegresar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JRegresar.setText("Regresar");
        JRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRegresarActionPerformed(evt);
            }
        });

        JTableBSocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(JTableBSocio);

        JInternalEditar4.setVisible(true);

        JDetallesSocio.setText("Detalles");
        JDetallesSocio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        JLimpiarTablaSocio.setText("Vaciar Tabla");

        JBuscarSocio.setText("Buscar");

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel1.setText("Selección:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467284734_OFFice-66.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar4Layout = new javax.swing.GroupLayout(JInternalEditar4.getContentPane());
        JInternalEditar4.getContentPane().setLayout(JInternalEditar4Layout);
        JInternalEditar4Layout.setHorizontalGroup(
            JInternalEditar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDetallesSocio)
                    .addComponent(JBuscarSocio)
                    .addComponent(jLabel1)
                    .addComponent(JLimpiarTablaSocio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(7, 7, 7))
        );
        JInternalEditar4Layout.setVerticalGroup(
            JInternalEditar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalEditar4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(JBuscarSocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLimpiarTablaSocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(JDetallesSocio)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalEditar4Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        JTabbedBusquedaSocios.addTab("Acciones", JInternalEditar4);

        JInternalBuscar.setVisible(true);

        JCheckNombre.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckNombre.setSelected(true);
        JCheckNombre.setText("Nombre");

        JCheckApellidoP.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoP.setSelected(true);
        JCheckApellidoP.setText("Apellido Paterno");

        JCheckApellidoM.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoM.setSelected(true);
        JCheckApellidoM.setText("Apellido Materno");

        JBuscarSocio1.setText("Buscar");

        JCheckEstado.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckEstado.setSelected(true);
        JCheckEstado.setText("Estado");

        JCheckMunicipio.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckMunicipio.setSelected(true);
        JCheckMunicipio.setText("Municipio");

        JCheckTelefono.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckTelefono.setSelected(true);
        JCheckTelefono.setText("Teléfono");

        JCheckNombre1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckNombre1.setSelected(true);
        JCheckNombre1.setText("Calle");

        javax.swing.GroupLayout JInternalBuscarLayout = new javax.swing.GroupLayout(JInternalBuscar.getContentPane());
        JInternalBuscar.getContentPane().setLayout(JInternalBuscarLayout);
        JInternalBuscarLayout.setHorizontalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBuscarSocio1)
                .addGap(101, 101, 101))
            .addGroup(JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalBuscarLayout.createSequentialGroup()
                        .addComponent(JCheckMunicipio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JCheckNombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCheckTelefono))
                    .addGroup(JInternalBuscarLayout.createSequentialGroup()
                        .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalBuscarLayout.createSequentialGroup()
                                .addComponent(JCheckApellidoM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCheckEstado))
                            .addGroup(JInternalBuscarLayout.createSequentialGroup()
                                .addComponent(JCheckNombre)
                                .addGap(18, 18, 18)
                                .addComponent(JCheckApellidoP)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JInternalBuscarLayout.setVerticalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckNombre)
                    .addComponent(JCheckApellidoP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckApellidoM)
                    .addComponent(JCheckEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckMunicipio)
                    .addComponent(JCheckTelefono)
                    .addComponent(JCheckNombre1))
                .addGap(10, 10, 10)
                .addComponent(JBuscarSocio1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios.addTab("Buscar", JInternalBuscar);

        jTitulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo.setText("Nombre:");

        jISBN.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN.setText("Apellido Paterno:");

        jNPag.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag.setText("Apellido Materno:");

        jTitulo1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo1.setText("Estado:");

        jTitulo2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo2.setText("Mucicipio:");

        jTitulo3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo3.setText("Calle:");

        jTitulo5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo5.setText("Teléfono:");

        jTitulo4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo4.setText("N°Calle:");

        jMenu1.setText("Opciones");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JMenuSalir.setText("Salir");
        JMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JMenuBuscarPrestamos.setText("Saltar a Prestamos");
        JMenuBuscarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuBuscarPrestamosActionPerformed(evt);
            }
        });
        jMenu2.add(JMenuBuscarPrestamos);

        JMenuBuscarLibro.setText("Saltar a Buscar Libro");
        JMenuBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuBuscarLibroActionPerformed(evt);
            }
        });
        jMenu2.add(JMenuBuscarLibro);

        jMenuBar1.add(jMenu2);

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
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTitulo3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JCalleText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTitulo4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JNCalleText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTitulo1)
                                        .addComponent(jTitulo2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JEstadoText, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                        .addComponent(JMunicipioText)))
                                .addComponent(jTitulo5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jNPag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTitulo, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(JNombreText, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                                .addComponent(JApellidoPText)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(JApellidoMText, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(JTelefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jRegistrarLibro)
                        .addGap(134, 134, 134)
                        .addComponent(jIconLeeyAprende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRegresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jRegistrarLibro))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(JRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jIconLeeyAprende))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JApellidoPText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag)
                            .addComponent(JApellidoMText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo1)
                            .addComponent(JEstadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JMunicipioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo3)
                            .addComponent(jTitulo4)
                            .addComponent(JNCalleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCalleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo5)
                            .addComponent(JTelefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRegresarActionPerformed
        SalirControlador SalirControlador = new SalirControlador();
        SalirControlador.actionPerformedReturn(evt);
        this.setVisible(false);
    }//GEN-LAST:event_JRegresarActionPerformed

    private void JMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSalirActionPerformed
        SalirControlador SalirControlador = new SalirControlador();
        SalirControlador.actionPerformed(evt);
        this.setVisible(false);
    }//GEN-LAST:event_JMenuSalirActionPerformed

    private void JMenuBuscarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuBuscarPrestamosActionPerformed
        SalirControlador SalirControlador = new SalirControlador();
        SalirControlador.actionPerformedVPrestamo(evt);
        this.setVisible(false);
    }//GEN-LAST:event_JMenuBuscarPrestamosActionPerformed

    private void JMenuBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuBuscarLibroActionPerformed
        SalirControlador SalirControlador = new SalirControlador();
        SalirControlador.actionPerformedVBuscarLibro(evt);
        this.setVisible(false);
    }//GEN-LAST:event_JMenuBuscarLibroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VBuscarSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VBuscarSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VBuscarSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VBuscarSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VBuscarSocios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField JApellidoMText;
    public javax.swing.JTextField JApellidoPText;
    private javax.swing.JButton JBuscarSocio;
    private javax.swing.JButton JBuscarSocio1;
    public javax.swing.JTextField JCalleText;
    public javax.swing.JCheckBox JCheckApellidoM;
    public javax.swing.JCheckBox JCheckApellidoP;
    public javax.swing.JCheckBox JCheckEstado;
    public javax.swing.JCheckBox JCheckMunicipio;
    public javax.swing.JCheckBox JCheckNombre;
    public javax.swing.JCheckBox JCheckNombre1;
    public javax.swing.JCheckBox JCheckTelefono;
    private javax.swing.JButton JDetallesSocio;
    public javax.swing.JTextField JEstadoText;
    private javax.swing.JInternalFrame JInternalBuscar;
    private javax.swing.JInternalFrame JInternalEditar4;
    private javax.swing.JButton JLimpiarTablaSocio;
    private javax.swing.JMenuItem JMenuBuscarLibro;
    private javax.swing.JMenuItem JMenuBuscarPrestamos;
    private javax.swing.JMenuItem JMenuSalir;
    public javax.swing.JTextField JMunicipioText;
    public javax.swing.JTextField JNCalleText;
    public javax.swing.JTextField JNombreText;
    private javax.swing.JButton JRegresar;
    private javax.swing.JTabbedPane JTabbedBusquedaSocios;
    public javax.swing.JTable JTableBSocio;
    public javax.swing.JTextField JTelefonoText;
    private javax.swing.JLabel jISBN;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jNPag;
    private javax.swing.JLabel jRegistrarLibro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JLabel jTitulo1;
    private javax.swing.JLabel jTitulo2;
    private javax.swing.JLabel jTitulo3;
    private javax.swing.JLabel jTitulo4;
    private javax.swing.JLabel jTitulo5;
    // End of variables declaration//GEN-END:variables
}
