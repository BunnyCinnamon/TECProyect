package Vista;

import Controlador.AdministradorControlador;
import Controlador.CargarInfoControlador;
import Controlador.Otros.AreaControlador;
import Controlador.Otros.EditorialControlador;
import Controlador.Otros.LocalizacionControlador;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arekkuusu
 */
public class VAdministrador extends javax.swing.JFrame {

    public VAdministrador() {
        initComponents();
        Iniciar();
        this.setResizable(false);
        ////////////////////////////////////////////////////////////////////////
        JIngresarLibro.setToolTipText("Ingresar datos a la Tabla");
        JModificarLibroTabla.setToolTipText("Modificar Selección con datos");
        JEliminarLibroTabla.setToolTipText("Dar de Baja la Selección");
        JEliminarLibroTabla.setForeground(Color.red);
        JBuscarLibro.setToolTipText("Buscar Libro con datos parecidos");
        JEstadisticas.setToolTipText("Ver las Estadísticas de Biblioteca");
        ////////////////////////////////////////////////////////////////////////
        JIngresarSocio.setToolTipText("Ingresar datos a la Tabla");
        JModificarSocioTabla.setToolTipText("Modificar Selección con datos");
        JEliminarSocioTabla.setToolTipText("Dar de Baja la Selección");
        JEliminarSocioTabla.setForeground(Color.red);
        JBuscarSocio.setToolTipText("Buscar Socio con datos parecidos");
        ////////////////////////////////////////////////////////////////////////
        JIngresarAutor.setToolTipText("Ingresar datos a la Tabla");
        JModificarAutorTabla.setToolTipText("Modificar Selección con datos");
        JEliminarAutorTabla.setToolTipText("Dar de Baja la Selección");
        JEliminarAutorTabla.setForeground(Color.red);
        JBuscarAutor.setToolTipText("Buscar Autor con datos parecidos");
        ////////////////////////////////////////////////////////////////////////
        JIngresarNuevoEditorial.setToolTipText("Ingresar datos a la Tabla");
        JModificarEditorial.setToolTipText("Modificar Selección con datos");
        JEliminarEditorial.setToolTipText("Dar de Baja la Selección");
        JEliminarEditorial.setForeground(Color.red);
        ////////////////////////////////////////////////////////////////////////
        JIngresarNuevoLocalizacion.setToolTipText("Ingresar datos a la Tabla");
        JModificarLocalizacion.setToolTipText("Modificar Selección con datos");
        JEliminarLocalizacion.setToolTipText("Dar de Baja la Selección");
        JEliminarLocalizacion.setForeground(Color.red);
        ////////////////////////////////////////////////////////////////////////
        JIngresarNuevaArea.setToolTipText("Ingresar datos a la Tabla");
        JModificarArea.setToolTipText("Modificar Selección con datos");
        JEliminarArea.setToolTipText("Dar de Baja la Selección");
        JEliminarArea.setForeground(Color.red);
        ////////////////////////////////////////////////////////////////////////
        JActualizar.setToolTipText("Actualizar todos los datos en la ventana");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jIconLeeyAprende = new javax.swing.JLabel();
        jRegistrarLibro = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JTabbedRegistroLibro = new javax.swing.JTabbedPane();
        JInternalLibro = new javax.swing.JInternalFrame();
        jTitulo = new javax.swing.JLabel();
        JTituloText = new javax.swing.JTextField();
        jISBN = new javax.swing.JLabel();
        JISBNText = new javax.swing.JTextField();
        jNPag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JListAutor = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListEditorial = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRLibro = new javax.swing.JTable();
        JTabbedAdminLibros = new javax.swing.JTabbedPane();
        JInternalEditar1 = new javax.swing.JInternalFrame();
        JIngresarLibro = new javax.swing.JButton();
        JModificarLibroTabla = new javax.swing.JButton();
        JEliminarLibroTabla = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JInternalBuscar = new javax.swing.JInternalFrame();
        JBuscarLibro = new javax.swing.JButton();
        JCheckTitulo = new javax.swing.JCheckBox();
        JCheckISBN = new javax.swing.JCheckBox();
        JCheckAutor = new javax.swing.JCheckBox();
        JCheckEditorial = new javax.swing.JCheckBox();
        JEstadisticas = new javax.swing.JButton();
        jISBN3 = new javax.swing.JLabel();
        jISBN4 = new javax.swing.JLabel();
        JLocalizacionLibro = new javax.swing.JComboBox<>();
        JAreaLibro = new javax.swing.JComboBox<>();
        jISBN5 = new javax.swing.JLabel();
        JEstadoLibro = new javax.swing.JComboBox<>();
        jNPag3 = new javax.swing.JLabel();
        JSpinnerCantidad = new javax.swing.JSpinner();
        JSpinnerNPag = new javax.swing.JSpinner();
        JInternalSocio = new javax.swing.JInternalFrame();
        jTitulo1 = new javax.swing.JLabel();
        jISBN1 = new javax.swing.JLabel();
        jNPag1 = new javax.swing.JLabel();
        jTitulo2 = new javax.swing.JLabel();
        jTitulo3 = new javax.swing.JLabel();
        jTitulo4 = new javax.swing.JLabel();
        JCalleTextSocio = new javax.swing.JTextField();
        jTitulo5 = new javax.swing.JLabel();
        JTelefonoTextSocio = new javax.swing.JTextField();
        jTitulo6 = new javax.swing.JLabel();
        JNCalleTextSocio = new javax.swing.JTextField();
        JMunicipioTextSocio = new javax.swing.JTextField();
        JEstadoTextSocio = new javax.swing.JTextField();
        JApellidoMTextSocio = new javax.swing.JTextField();
        JApellidoPTextSocio = new javax.swing.JTextField();
        JNombreTextSocio = new javax.swing.JTextField();
        JTabbedBusquedaSocios = new javax.swing.JTabbedPane();
        JInternalEditar5 = new javax.swing.JInternalFrame();
        JEliminarSocioTabla = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        JIngresarSocio = new javax.swing.JButton();
        JModificarSocioTabla = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        JInternalBuscar1 = new javax.swing.JInternalFrame();
        JCheckNombre = new javax.swing.JCheckBox();
        JCheckApellidoP = new javax.swing.JCheckBox();
        JCheckApellidoM = new javax.swing.JCheckBox();
        JBuscarSocio = new javax.swing.JButton();
        JCheckUsuario = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTableRSocio = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        JTextUsuario = new javax.swing.JTextField();
        JEstatusSocio = new javax.swing.JComboBox<>();
        jTitulo8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTextContraseñaSocio = new javax.swing.JPasswordField();
        JInternalAutor = new javax.swing.JInternalFrame();
        jTitulo7 = new javax.swing.JLabel();
        JNombreTextAutor = new javax.swing.JTextField();
        jISBN2 = new javax.swing.JLabel();
        JApellidoPAutor = new javax.swing.JTextField();
        jNPag2 = new javax.swing.JLabel();
        JApellidoMAutor = new javax.swing.JTextField();
        JTabbedBusquedaSocios2 = new javax.swing.JTabbedPane();
        JInternalEditar6 = new javax.swing.JInternalFrame();
        JEliminarAutorTabla = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        JIngresarAutor = new javax.swing.JButton();
        JModificarAutorTabla = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JInternalBuscar2 = new javax.swing.JInternalFrame();
        JCheckNombreAutor = new javax.swing.JCheckBox();
        JCheckApellidoP1 = new javax.swing.JCheckBox();
        JCheckApellidoM1 = new javax.swing.JCheckBox();
        JBuscarAutor = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTableRAutor = new javax.swing.JTable();
        jTitulo10 = new javax.swing.JLabel();
        JComboEstatusAutor = new javax.swing.JComboBox<>();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel12 = new javax.swing.JLabel();
        JNombreTextEditorial = new javax.swing.JTextField();
        jTitulo13 = new javax.swing.JLabel();
        jTitulo14 = new javax.swing.JLabel();
        JComboEstatusEditorial = new javax.swing.JComboBox<>();
        JIngresarNuevoEditorial = new javax.swing.JButton();
        JModificarEditorial = new javax.swing.JButton();
        JEliminarEditorial = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        JTableREditorial = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jTitulo15 = new javax.swing.JLabel();
        JLocalizacionText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTitulo16 = new javax.swing.JLabel();
        JAreaText = new javax.swing.JTextField();
        jTitulo17 = new javax.swing.JLabel();
        JComboEstatusArea = new javax.swing.JComboBox<>();
        JIngresarNuevoLocalizacion = new javax.swing.JButton();
        JModificarLocalizacion = new javax.swing.JButton();
        JEliminarLocalizacion = new javax.swing.JButton();
        JIngresarNuevaArea = new javax.swing.JButton();
        JModificarArea = new javax.swing.JButton();
        JEliminarArea = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        JTableRArea = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        JTableRLocalizacion = new javax.swing.JTable();
        jTitulo18 = new javax.swing.JLabel();
        JComboEstatusLocalizacion = new javax.swing.JComboBox<>();
        JActualizar = new javax.swing.JButton();
        JRegresar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        jRegistrarLibro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jRegistrarLibro.setText("Administrador");

        JInternalLibro.setVisible(true);

        jTitulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo.setText("Título:");

        jISBN.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN.setText("ISBN:");

        jNPag.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag.setText("N° Pág:");

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Autor");

        JListAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(JListAutor);

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Editorial");

        JListEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(JListEditorial);

        JTableRLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "ISBN", "Titulo", "N° Pag", "Estatus", "Autor", "Editorial", "Localización", "Área", "Existencias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRLibro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTableRLibro);

        JInternalEditar1.setVisible(true);

        JIngresarLibro.setText("Ingresar");
        JIngresarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarLibroActionPerformed(evt);
            }
        });

        JModificarLibroTabla.setText("Modificar");
        JModificarLibroTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarLibroTablaActionPerformed(evt);
            }
        });

        JEliminarLibroTabla.setText("Eliminar");
        JEliminarLibroTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarLibroTablaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Selección:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467286183_bookshelf.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar1Layout = new javax.swing.GroupLayout(JInternalEditar1.getContentPane());
        JInternalEditar1.getContentPane().setLayout(JInternalEditar1Layout);
        JInternalEditar1Layout.setHorizontalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JIngresarLibro)
                    .addComponent(JEliminarLibroTabla)
                    .addComponent(JModificarLibroTabla)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        JInternalEditar1Layout.setVerticalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalEditar1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JIngresarLibro)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JModificarLibroTabla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarLibroTabla))
                    .addComponent(jLabel11))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        JTabbedAdminLibros.addTab("Editar", JInternalEditar1);

        JInternalBuscar.setVisible(true);

        JBuscarLibro.setText("Buscar");
        JBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBuscarLibroActionPerformed(evt);
            }
        });

        JCheckTitulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckTitulo.setSelected(true);
        JCheckTitulo.setText("Título");

        JCheckISBN.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckISBN.setSelected(true);
        JCheckISBN.setText("ISBN");

        JCheckAutor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckAutor.setSelected(true);
        JCheckAutor.setText("Autor");

        JCheckEditorial.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckEditorial.setSelected(true);
        JCheckEditorial.setText("Editorial");

        JEstadisticas.setText("Estadísticas");
        JEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEstadisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JInternalBuscarLayout = new javax.swing.GroupLayout(JInternalBuscar.getContentPane());
        JInternalBuscar.getContentPane().setLayout(JInternalBuscarLayout);
        JInternalBuscarLayout.setHorizontalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JBuscarLibro)
                    .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JCheckTitulo)
                        .addComponent(JCheckISBN)))
                .addGap(18, 18, 18)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCheckEditorial)
                    .addComponent(JCheckAutor)
                    .addComponent(JEstadisticas))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        JInternalBuscarLayout.setVerticalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckTitulo)
                    .addComponent(JCheckAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckISBN)
                    .addComponent(JCheckEditorial))
                .addGap(18, 18, 18)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JEstadisticas)
                    .addComponent(JBuscarLibro))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        JTabbedAdminLibros.addTab("Buscar", JInternalBuscar);

        jISBN3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN3.setText("Localización:");

        jISBN4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN4.setText("Área:");

        jISBN5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN5.setText("Estado:");

        JEstadoLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jNPag3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag3.setText("Cant:");

        javax.swing.GroupLayout JInternalLibroLayout = new javax.swing.GroupLayout(JInternalLibro.getContentPane());
        JInternalLibro.getContentPane().setLayout(JInternalLibroLayout);
        JInternalLibroLayout.setHorizontalGroup(
            JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalLibroLayout.createSequentialGroup()
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jISBN)
                                    .addComponent(jTitulo))
                                .addGap(13, 13, 13)
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                                        .addComponent(JISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jNPag)
                                        .addGap(10, 10, 10)
                                        .addComponent(JSpinnerNPag, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jNPag3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JTituloText)))
                            .addGroup(JInternalLibroLayout.createSequentialGroup()
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalLibroLayout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(JInternalLibroLayout.createSequentialGroup()
                                                .addComponent(jISBN3)
                                                .addGap(15, 15, 15)
                                                .addComponent(JLocalizacionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalLibroLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jISBN4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JAreaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jISBN5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedAdminLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalLibroLayout.setVerticalGroup(
            JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo)
                            .addComponent(JTituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN)
                            .addComponent(JISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNPag)
                            .addComponent(jNPag3)
                            .addComponent(JSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSpinnerNPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN3)
                            .addComponent(JLocalizacionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN4)
                            .addComponent(JAreaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN5)
                            .addComponent(JEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(JTabbedAdminLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        JTabbedRegistroLibro.addTab("Registros de Libro", JInternalLibro);

        JInternalSocio.setVisible(true);

        jTitulo1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo1.setText("Nombre:");

        jISBN1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN1.setText("Apellido Paterno:");

        jNPag1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag1.setText("Apellido Materno:");

        jTitulo2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo2.setText("Estado:");

        jTitulo3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo3.setText("Mucicipio:");

        jTitulo4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo4.setText("Calle:");

        jTitulo5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo5.setText("Teléfono:");

        jTitulo6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo6.setText("N°Calle:");

        JInternalEditar5.setVisible(true);

        JEliminarSocioTabla.setText("Eliminar");
        JEliminarSocioTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JEliminarSocioTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarSocioTablaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel8.setText("Selección:");

        JIngresarSocio.setText("Ingresar");
        JIngresarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarSocioActionPerformed(evt);
            }
        });

        JModificarSocioTabla.setText("Modificar");
        JModificarSocioTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarSocioTablaActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467286183_bookshelf.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar5Layout = new javax.swing.GroupLayout(JInternalEditar5.getContentPane());
        JInternalEditar5.getContentPane().setLayout(JInternalEditar5Layout);
        JInternalEditar5Layout.setHorizontalGroup(
            JInternalEditar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEliminarSocioTabla)
                    .addComponent(jLabel8)
                    .addComponent(JIngresarSocio)
                    .addComponent(JModificarSocioTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        JInternalEditar5Layout.setVerticalGroup(
            JInternalEditar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JIngresarSocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JModificarSocioTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JEliminarSocioTabla)
                .addGap(20, 20, 20))
            .addGroup(JInternalEditar5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios.addTab("Editar", JInternalEditar5);

        JInternalBuscar1.setVisible(true);

        JCheckNombre.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckNombre.setSelected(true);
        JCheckNombre.setText("Nombre");

        JCheckApellidoP.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoP.setSelected(true);
        JCheckApellidoP.setText("Apellido Paterno");

        JCheckApellidoM.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoM.setSelected(true);
        JCheckApellidoM.setText("Apellido Materno");

        JBuscarSocio.setText("Buscar");
        JBuscarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBuscarSocioActionPerformed(evt);
            }
        });

        JCheckUsuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckUsuario.setSelected(true);
        JCheckUsuario.setText("Usuario");

        javax.swing.GroupLayout JInternalBuscar1Layout = new javax.swing.GroupLayout(JInternalBuscar1.getContentPane());
        JInternalBuscar1.getContentPane().setLayout(JInternalBuscar1Layout);
        JInternalBuscar1Layout.setHorizontalGroup(
            JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBuscarSocio)
                .addGap(101, 101, 101))
            .addGroup(JInternalBuscar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalBuscar1Layout.createSequentialGroup()
                        .addComponent(JCheckApellidoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCheckUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JInternalBuscar1Layout.createSequentialGroup()
                        .addComponent(JCheckNombre)
                        .addGap(18, 18, 18)
                        .addComponent(JCheckApellidoP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JInternalBuscar1Layout.setVerticalGroup(
            JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckNombre)
                    .addComponent(JCheckApellidoP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckApellidoM)
                    .addComponent(JCheckUsuario))
                .addGap(40, 40, 40)
                .addComponent(JBuscarSocio)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios.addTab("Buscar", JInternalBuscar1);

        JTableRSocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Teléfono", "Estatus", "Préstamos", "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRSocio.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(JTableRSocio);

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        JEstatusSocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jTitulo8.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo8.setText("Estatus:");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout JInternalSocioLayout = new javax.swing.GroupLayout(JInternalSocio.getContentPane());
        JInternalSocio.getContentPane().setLayout(JInternalSocioLayout);
        JInternalSocioLayout.setHorizontalGroup(
            JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jNPag1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JApellidoMTextSocio))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jISBN1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JApellidoPTextSocio))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jTitulo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(JNombreTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                        .addComponent(jTitulo4)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCalleTextSocio))
                                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                                        .addComponent(jTitulo2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JEstadoTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTitulo5)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JTextUsuario)
                                            .addComponent(JTelefonoTextSocio))))
                                .addGap(10, 10, 10)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTitulo3)
                                    .addComponent(jTitulo6)
                                    .addComponent(jTitulo8)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JNCalleTextSocio)
                                    .addComponent(JMunicipioTextSocio)
                                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                                        .addComponent(JEstatusSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(JTextContraseñaSocio))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
        );
        JInternalSocioLayout.setVerticalGroup(
            JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNombreTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JApellidoPTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag1)
                            .addComponent(JApellidoMTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo2)
                            .addComponent(JEstadoTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo3)
                            .addComponent(JMunicipioTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo4)
                            .addComponent(JCalleTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo6)
                            .addComponent(JNCalleTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo5)
                            .addComponent(JTelefonoTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo8)
                            .addComponent(JEstatusSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(JTextContraseñaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        JTabbedRegistroLibro.addTab("Registros de Socio", JInternalSocio);

        JInternalAutor.setVisible(true);

        jTitulo7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo7.setText("Nombre:");

        jISBN2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN2.setText("Apellido Paterno:");

        jNPag2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag2.setText("Apellido Materno:");

        JInternalEditar6.setVisible(true);

        JEliminarAutorTabla.setText("Eliminar");
        JEliminarAutorTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JEliminarAutorTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarAutorTablaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel10.setText("Selección:");

        JIngresarAutor.setText("Ingresar");
        JIngresarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarAutorActionPerformed(evt);
            }
        });

        JModificarAutorTabla.setText("Modificar");
        JModificarAutorTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarAutorTablaActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467286183_bookshelf.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar6Layout = new javax.swing.GroupLayout(JInternalEditar6.getContentPane());
        JInternalEditar6.getContentPane().setLayout(JInternalEditar6Layout);
        JInternalEditar6Layout.setHorizontalGroup(
            JInternalEditar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEliminarAutorTabla)
                    .addComponent(jLabel10)
                    .addComponent(JIngresarAutor)
                    .addComponent(JModificarAutorTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        JInternalEditar6Layout.setVerticalGroup(
            JInternalEditar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JIngresarAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JModificarAutorTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JEliminarAutorTabla)
                .addGap(20, 20, 20))
            .addGroup(JInternalEditar6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios2.addTab("Editar", JInternalEditar6);

        JInternalBuscar2.setVisible(true);

        JCheckNombreAutor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckNombreAutor.setSelected(true);
        JCheckNombreAutor.setText("Nombre");

        JCheckApellidoP1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoP1.setSelected(true);
        JCheckApellidoP1.setText("Apellido Paterno");

        JCheckApellidoM1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoM1.setSelected(true);
        JCheckApellidoM1.setText("Apellido Materno");

        JBuscarAutor.setText("Buscar");
        JBuscarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBuscarAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JInternalBuscar2Layout = new javax.swing.GroupLayout(JInternalBuscar2.getContentPane());
        JInternalBuscar2.getContentPane().setLayout(JInternalBuscar2Layout);
        JInternalBuscar2Layout.setHorizontalGroup(
            JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBuscarAutor)
                .addGap(101, 101, 101))
            .addGroup(JInternalBuscar2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCheckApellidoM1)
                    .addGroup(JInternalBuscar2Layout.createSequentialGroup()
                        .addComponent(JCheckNombreAutor)
                        .addGap(18, 18, 18)
                        .addComponent(JCheckApellidoP1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JInternalBuscar2Layout.setVerticalGroup(
            JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckNombreAutor)
                    .addComponent(JCheckApellidoP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCheckApellidoM1)
                .addGap(38, 38, 38)
                .addComponent(JBuscarAutor)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios2.addTab("Buscar", JInternalBuscar2);

        JTableRAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRAutor.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(JTableRAutor);

        jTitulo10.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo10.setText("Estatus:");

        JComboEstatusAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout JInternalAutorLayout = new javax.swing.GroupLayout(JInternalAutor.getContentPane());
        JInternalAutor.getContentPane().setLayout(JInternalAutorLayout);
        JInternalAutorLayout.setHorizontalGroup(
            JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalAutorLayout.createSequentialGroup()
                                .addComponent(jISBN2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JApellidoPAutor))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalAutorLayout.createSequentialGroup()
                                .addComponent(jNPag2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JApellidoMAutor))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalAutorLayout.createSequentialGroup()
                                .addComponent(jTitulo10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JComboEstatusAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalAutorLayout.createSequentialGroup()
                                .addComponent(jTitulo7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JNombreTextAutor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedBusquedaSocios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        JInternalAutorLayout.setVerticalGroup(
            JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTabbedBusquedaSocios2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNombreTextAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JApellidoPAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag2)
                            .addComponent(JApellidoMAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo10)
                            .addComponent(JComboEstatusAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        JTabbedRegistroLibro.addTab("Registros de Autor", JInternalAutor);

        jInternalFrame4.setVisible(true);

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel12.setText("Editoriales");

        jTitulo13.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo13.setText("Nombre:");

        jTitulo14.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo14.setText("Estatus:");

        JComboEstatusEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        JIngresarNuevoEditorial.setText("Ingresar");
        JIngresarNuevoEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevoEditorialActionPerformed(evt);
            }
        });

        JModificarEditorial.setText("Modificar");
        JModificarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarEditorialActionPerformed(evt);
            }
        });

        JEliminarEditorial.setText("Eliminar");
        JEliminarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarEditorialActionPerformed(evt);
            }
        });

        JTableREditorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableREditorial.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(JTableREditorial);

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel13.setText("Localización");

        jTitulo15.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo15.setText("Pasillo:");

        jLabel14.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel14.setText("Área");

        jTitulo16.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo16.setText("Sección:");

        jTitulo17.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo17.setText("Estatus:");

        JComboEstatusArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        JIngresarNuevoLocalizacion.setText("Ingresar");
        JIngresarNuevoLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevoLocalizacionActionPerformed(evt);
            }
        });

        JModificarLocalizacion.setText("Modificar");
        JModificarLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarLocalizacionActionPerformed(evt);
            }
        });

        JEliminarLocalizacion.setText("Eliminar");
        JEliminarLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarLocalizacionActionPerformed(evt);
            }
        });

        JIngresarNuevaArea.setText("Ingresar");
        JIngresarNuevaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevaAreaActionPerformed(evt);
            }
        });

        JModificarArea.setText("Modificar");
        JModificarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarAreaActionPerformed(evt);
            }
        });

        JEliminarArea.setText("Eliminar");
        JEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarAreaActionPerformed(evt);
            }
        });

        JTableRArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sección", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRArea.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(JTableRArea);

        JTableRLocalizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Pasillo", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRLocalizacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(JTableRLocalizacion);

        jTitulo18.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo18.setText("Estatus:");

        JComboEstatusLocalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        JActualizar.setText("Actualizar");
        JActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitulo13)
                            .addComponent(jTitulo14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JNombreTextEditorial)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JComboEstatusEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(JIngresarNuevoEditorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JModificarEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarEditorial)))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jTitulo18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JComboEstatusLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(JIngresarNuevoLocalizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JModificarLocalizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarLocalizacion))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jTitulo15)
                        .addGap(18, 18, 18)
                        .addComponent(JLocalizacionText, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitulo17)
                            .addComponent(jTitulo16))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JAreaText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JComboEstatusArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(JIngresarNuevaArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JModificarArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JNombreTextEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo13)
                    .addComponent(JAreaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo16)
                    .addComponent(JLocalizacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTitulo17)
                        .addComponent(JComboEstatusArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JComboEstatusLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTitulo14)
                        .addComponent(JComboEstatusEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTitulo18)))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JEliminarEditorial)
                        .addComponent(JEliminarLocalizacion)
                        .addComponent(JIngresarNuevoLocalizacion)
                        .addComponent(JModificarLocalizacion)
                        .addComponent(JModificarEditorial)
                        .addComponent(JIngresarNuevoEditorial))
                    .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JEliminarArea)
                        .addComponent(JModificarArea)
                        .addComponent(JIngresarNuevaArea)))
                .addGap(19, 19, 19)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Editorial/Localización/Área", jInternalFrame4);

        JRegresar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JRegresar.setText("Regresar");
        JRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRegresarActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JTabbedRegistroLibro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jRegistrarLibro)
                        .addGap(188, 188, 188)
                        .addComponent(jIconLeeyAprende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRegresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRegistrarLibro))
                    .addComponent(jIconLeeyAprende)
                    .addComponent(JRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTabbedRegistroLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Iniciar Página*
     */
    private void Iniciar() {
        CargarInfoControlador Cargar = new CargarInfoControlador();
        /**
         * VRegistro de Libro*
         */
        JLocalizacionLibro.removeAllItems();
        JAreaLibro.removeAllItems();
        JListAutor.setListData(new String[0]);
        JListEditorial.setListData(new String[0]);
        Cargar.CargarInfoListas(this);
        /**
         * VRegistro de Editorial/Localizacion/Area*
         */
        DefaultTableModel Editorial = (DefaultTableModel) JTableREditorial.getModel();
        Cargar.CargarEditorial(this, Editorial);
        DefaultTableModel Localizacion = (DefaultTableModel) JTableRLocalizacion.getModel();
        Cargar.CargarLocalizacion(this, Localizacion);
        DefaultTableModel Area = (DefaultTableModel) JTableRArea.getModel();
        Cargar.CargarArea(this, Area);
    }

    /**
     * Verificar Nombre Válido de Socio
     *
     *
     * @param a
     * @return
     */
    private static boolean ValidadorTexto(String a) {
        Pattern pat = Pattern.compile("^[a-zA-Z]*");
        Matcher mat = pat.matcher(a);
        return mat.matches();
    }

    /**
     * Verificar Número Válido de Socio
     *
     *
     * @param a
     * @return
     */
    private static boolean ValidadorNumero(String a) {
        Pattern pat = Pattern.compile(".*\\d+.*");
        Matcher mat = pat.matcher(a);
        return mat.matches();
    }

    /**
     * Registros de Libro*
     */

    private void JIngresarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarLibroActionPerformed
        AdministradorControlador AdministradorControlador = new AdministradorControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRLibro.getModel();
        AdministradorControlador.actionPerformedJIngresarLibro(model, this);
    }//GEN-LAST:event_JIngresarLibroActionPerformed

    private void JModificarLibroTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarLibroTablaActionPerformed
        AdministradorControlador AdministradorControlador = new AdministradorControlador();
        AdministradorControlador.actionPerformedJModificarLibro(this);
    }//GEN-LAST:event_JModificarLibroTablaActionPerformed

    private void JEliminarLibroTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarLibroTablaActionPerformed
        AdministradorControlador AdministradorControlador = new AdministradorControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRLibro.getModel();
        AdministradorControlador.actionPerformedJEliminarLibro(model, this);
    }//GEN-LAST:event_JEliminarLibroTablaActionPerformed

    /**
     * Busqueda de Libro*
     */

    private void JBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarLibroActionPerformed
        AdministradorControlador AdministradorControlador = new AdministradorControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRLibro.getModel();
        AdministradorControlador.actionPerformedJBuscarLibro(model, this);
    }//GEN-LAST:event_JBuscarLibroActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registro de Socios*
     */

    private void JIngresarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarSocioActionPerformed
        String A;
        A = JMunicipioTextSocio.getText() + JNombreTextSocio.getText() + JApellidoPTextSocio.getText() + JApellidoMTextSocio.getText() + JEstadoTextSocio.getText();
        String B;
        B = JTelefonoTextSocio.getText() + JNCalleTextSocio.getText();
        if (ValidadorTexto(A) && ValidadorNumero(B)) {
            AdministradorControlador AdministradorControlador = new AdministradorControlador();
            DefaultTableModel model = (DefaultTableModel) JTableRSocio.getModel();
            AdministradorControlador.actionPerformedJIngresarSocio(model, this);
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no validos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JIngresarSocioActionPerformed

    private void JModificarSocioTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarSocioTablaActionPerformed
        String A;
        A = JMunicipioTextSocio.getText() + JNombreTextSocio.getText() + JApellidoPTextSocio.getText() + JApellidoMTextSocio.getText() + JEstadoTextSocio.getText();
        String B;
        B = JTelefonoTextSocio.getText() + JNCalleTextSocio.getText();
        if (ValidadorTexto(A) && ValidadorNumero(B)) {
            AdministradorControlador AdministradorControlador = new AdministradorControlador();
            AdministradorControlador.actionPerformedJModificarSocio(this);
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no validos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JModificarSocioTablaActionPerformed

    private void JEliminarSocioTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarSocioTablaActionPerformed
        AdministradorControlador AdministradorControlador = new AdministradorControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRSocio.getModel();
        AdministradorControlador.actionPerformedJEliminarSocio(model, this);
    }//GEN-LAST:event_JEliminarSocioTablaActionPerformed

    /**
     * Busqueda de Socios*
     */

    private void JBuscarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarSocioActionPerformed
        AdministradorControlador AdministradorControlador = new AdministradorControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRSocio.getModel();
        AdministradorControlador.actionPerformedJBuscarSocio(model, this);
    }//GEN-LAST:event_JBuscarSocioActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registro de Autor*
     */

    private void JIngresarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarAutorActionPerformed
        String A;
        A = JNombreTextAutor.getText() + JApellidoPAutor.getText() + JApellidoMAutor.getText();
        if (ValidadorTexto(A)) {
            AdministradorControlador AdministradorControlador = new AdministradorControlador();
            DefaultTableModel model = (DefaultTableModel) JTableRAutor.getModel();
            AdministradorControlador.actionPerformedJIngresarAutor(model, this);
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no validos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JIngresarAutorActionPerformed

    private void JModificarAutorTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarAutorTablaActionPerformed
        String A;
        A = JNombreTextAutor.getText() + JApellidoPAutor.getText() + JApellidoMAutor.getText();
        if (ValidadorTexto(A)) {
            AdministradorControlador AdministradorControlador = new AdministradorControlador();
            AdministradorControlador.actionPerformedJModificarAutor(this);
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no validos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JModificarAutorTablaActionPerformed

    private void JEliminarAutorTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarAutorTablaActionPerformed
        AdministradorControlador AdministradorControlador = new AdministradorControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRAutor.getModel();
        AdministradorControlador.actionPerformedJEliminarAutor(model, this);
    }//GEN-LAST:event_JEliminarAutorTablaActionPerformed

    /**
     * Busqueda de Autor*
     */

    private void JBuscarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarAutorActionPerformed
        String A;
        A = JNombreTextAutor.getText() + JApellidoPAutor.getText() + JApellidoMAutor.getText();
        if (ValidadorTexto(A)) {
            AdministradorControlador AdministradorControlador = new AdministradorControlador();
            DefaultTableModel model = (DefaultTableModel) JTableRAutor.getModel();
            AdministradorControlador.actionPerformedJBuscarAutor(model, this);
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no validos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JBuscarAutorActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registros de Editorial*
     */

    private void JIngresarNuevoEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarNuevoEditorialActionPerformed
        EditorialControlador EditorialControlador = new EditorialControlador();
        DefaultTableModel model = (DefaultTableModel) JTableREditorial.getModel();
        EditorialControlador.actionPerformedJIngresarEditorial(model, this);
    }//GEN-LAST:event_JIngresarNuevoEditorialActionPerformed

    private void JModificarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarEditorialActionPerformed
        EditorialControlador EditorialControlador = new EditorialControlador();
        EditorialControlador.actionPerformedJModificarEditorial(this);
    }//GEN-LAST:event_JModificarEditorialActionPerformed

    private void JEliminarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarEditorialActionPerformed
        EditorialControlador EditorialControlador = new EditorialControlador();
        DefaultTableModel model = (DefaultTableModel) JTableREditorial.getModel();
        EditorialControlador.actionPerformedJEliminarEditorial(model, this);
    }//GEN-LAST:event_JEliminarEditorialActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registros de Localización*
     */

    private void JIngresarNuevoLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarNuevoLocalizacionActionPerformed
        LocalizacionControlador LocalizacionControlador = new LocalizacionControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRLocalizacion.getModel();
        LocalizacionControlador.actionPerformedJIngresarLocalizacion(model, this);
    }//GEN-LAST:event_JIngresarNuevoLocalizacionActionPerformed

    private void JModificarLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarLocalizacionActionPerformed
        LocalizacionControlador LocalizacionControlador = new LocalizacionControlador();
        LocalizacionControlador.actionPerformedJModificarLocalizacion(this);
    }//GEN-LAST:event_JModificarLocalizacionActionPerformed

    private void JEliminarLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarLocalizacionActionPerformed
        LocalizacionControlador LocalizacionControlador = new LocalizacionControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRLocalizacion.getModel();
        LocalizacionControlador.actionPerformedJEliminarLocalizacion(model, this);
    }//GEN-LAST:event_JEliminarLocalizacionActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registros de Area*
     */

    private void JIngresarNuevaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarNuevaAreaActionPerformed
        AreaControlador AreaControlador = new AreaControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRArea.getModel();
        AreaControlador.actionPerformedJIngresarArea(model, this);
    }//GEN-LAST:event_JIngresarNuevaAreaActionPerformed

    private void JModificarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarAreaActionPerformed
        AreaControlador AreaControlador = new AreaControlador();
        AreaControlador.actionPerformedJModificarArea(this);
    }//GEN-LAST:event_JModificarAreaActionPerformed

    private void JEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarAreaActionPerformed
        AreaControlador AreaControlador = new AreaControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRArea.getModel();
        AreaControlador.actionPerformedJEliminarArea(model, this);
    }//GEN-LAST:event_JEliminarAreaActionPerformed

    private void JRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_JRegresarActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Estadisticas*
     */

    private void JEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEstadisticasActionPerformed
        CargarInfoControlador Cargar = new CargarInfoControlador();
        Cargar.CargarInfoEstadisticas();
    }//GEN-LAST:event_JEstadisticasActionPerformed

    private void JActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JActualizarActionPerformed
        JTableREditorial.removeAll();
        JTableRLocalizacion.removeAll();
        JTableRArea.removeAll();
        Iniciar();
    }//GEN-LAST:event_JActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JActualizar;
    public javax.swing.JTextField JApellidoMAutor;
    public javax.swing.JTextField JApellidoMTextSocio;
    public javax.swing.JTextField JApellidoPAutor;
    public javax.swing.JTextField JApellidoPTextSocio;
    public javax.swing.JComboBox<String> JAreaLibro;
    public javax.swing.JTextField JAreaText;
    private javax.swing.JButton JBuscarAutor;
    private javax.swing.JButton JBuscarLibro;
    private javax.swing.JButton JBuscarSocio;
    public javax.swing.JTextField JCalleTextSocio;
    public javax.swing.JCheckBox JCheckApellidoM;
    public javax.swing.JCheckBox JCheckApellidoM1;
    public javax.swing.JCheckBox JCheckApellidoP;
    public javax.swing.JCheckBox JCheckApellidoP1;
    public javax.swing.JCheckBox JCheckAutor;
    public javax.swing.JCheckBox JCheckEditorial;
    public javax.swing.JCheckBox JCheckISBN;
    public javax.swing.JCheckBox JCheckNombre;
    public javax.swing.JCheckBox JCheckNombreAutor;
    public javax.swing.JCheckBox JCheckTitulo;
    public javax.swing.JCheckBox JCheckUsuario;
    public javax.swing.JComboBox<String> JComboEstatusArea;
    public javax.swing.JComboBox<String> JComboEstatusAutor;
    public javax.swing.JComboBox<String> JComboEstatusEditorial;
    public javax.swing.JComboBox<String> JComboEstatusLocalizacion;
    public javax.swing.JButton JEliminarArea;
    private javax.swing.JButton JEliminarAutorTabla;
    public javax.swing.JButton JEliminarEditorial;
    private javax.swing.JButton JEliminarLibroTabla;
    public javax.swing.JButton JEliminarLocalizacion;
    private javax.swing.JButton JEliminarSocioTabla;
    private javax.swing.JButton JEstadisticas;
    public javax.swing.JComboBox<String> JEstadoLibro;
    public javax.swing.JTextField JEstadoTextSocio;
    public javax.swing.JComboBox<String> JEstatusSocio;
    public javax.swing.JTextField JISBNText;
    private javax.swing.JButton JIngresarAutor;
    private javax.swing.JButton JIngresarLibro;
    public javax.swing.JButton JIngresarNuevaArea;
    public javax.swing.JButton JIngresarNuevoEditorial;
    public javax.swing.JButton JIngresarNuevoLocalizacion;
    private javax.swing.JButton JIngresarSocio;
    private javax.swing.JInternalFrame JInternalAutor;
    private javax.swing.JInternalFrame JInternalBuscar;
    private javax.swing.JInternalFrame JInternalBuscar1;
    private javax.swing.JInternalFrame JInternalBuscar2;
    private javax.swing.JInternalFrame JInternalEditar1;
    private javax.swing.JInternalFrame JInternalEditar5;
    private javax.swing.JInternalFrame JInternalEditar6;
    private javax.swing.JInternalFrame JInternalLibro;
    private javax.swing.JInternalFrame JInternalSocio;
    public javax.swing.JList<String> JListAutor;
    public javax.swing.JList<String> JListEditorial;
    public javax.swing.JComboBox<String> JLocalizacionLibro;
    public javax.swing.JTextField JLocalizacionText;
    public javax.swing.JButton JModificarArea;
    private javax.swing.JButton JModificarAutorTabla;
    public javax.swing.JButton JModificarEditorial;
    private javax.swing.JButton JModificarLibroTabla;
    public javax.swing.JButton JModificarLocalizacion;
    private javax.swing.JButton JModificarSocioTabla;
    public javax.swing.JTextField JMunicipioTextSocio;
    public javax.swing.JTextField JNCalleTextSocio;
    public javax.swing.JTextField JNombreTextAutor;
    public javax.swing.JTextField JNombreTextEditorial;
    public javax.swing.JTextField JNombreTextSocio;
    private javax.swing.JButton JRegresar;
    public javax.swing.JSpinner JSpinnerCantidad;
    public javax.swing.JSpinner JSpinnerNPag;
    private javax.swing.JTabbedPane JTabbedAdminLibros;
    private javax.swing.JTabbedPane JTabbedBusquedaSocios;
    private javax.swing.JTabbedPane JTabbedBusquedaSocios2;
    private javax.swing.JTabbedPane JTabbedRegistroLibro;
    public javax.swing.JTable JTableRArea;
    public javax.swing.JTable JTableRAutor;
    public javax.swing.JTable JTableREditorial;
    public javax.swing.JTable JTableRLibro;
    public javax.swing.JTable JTableRLocalizacion;
    public javax.swing.JTable JTableRSocio;
    public javax.swing.JTextField JTelefonoTextSocio;
    public javax.swing.JPasswordField JTextContraseñaSocio;
    public javax.swing.JTextField JTextUsuario;
    public javax.swing.JTextField JTituloText;
    private javax.swing.JLabel jISBN;
    private javax.swing.JLabel jISBN1;
    private javax.swing.JLabel jISBN2;
    private javax.swing.JLabel jISBN3;
    private javax.swing.JLabel jISBN4;
    private javax.swing.JLabel jISBN5;
    private javax.swing.JLabel jIconLeeyAprende;
    public javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jNPag;
    private javax.swing.JLabel jNPag1;
    private javax.swing.JLabel jNPag2;
    private javax.swing.JLabel jNPag3;
    private javax.swing.JLabel jRegistrarLibro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JLabel jTitulo1;
    private javax.swing.JLabel jTitulo10;
    private javax.swing.JLabel jTitulo13;
    private javax.swing.JLabel jTitulo14;
    private javax.swing.JLabel jTitulo15;
    private javax.swing.JLabel jTitulo16;
    private javax.swing.JLabel jTitulo17;
    private javax.swing.JLabel jTitulo18;
    private javax.swing.JLabel jTitulo2;
    private javax.swing.JLabel jTitulo3;
    private javax.swing.JLabel jTitulo4;
    private javax.swing.JLabel jTitulo5;
    private javax.swing.JLabel jTitulo6;
    private javax.swing.JLabel jTitulo7;
    private javax.swing.JLabel jTitulo8;
    // End of variables declaration//GEN-END:variables
}
