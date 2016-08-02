package Vista;

import Controlador.AdministradorControlador;
import Controlador.CargarInfoControlador;
import Controlador.Otros.AreaControlador;
import Controlador.Otros.EditorialControlador;
import Controlador.Otros.LocalizacionControlador;
import Utils.Autocompleter;
import Utils.CleanupDone;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import Utils.TextChecker;
import javax.swing.JPasswordField;

@CleanupDone
/**
 * Vista de Administrador, edición de Libros, Socios, Autores, Localizaciones,
 * Areas, y Editoriales
 *
 */
public class VAdministrador extends javax.swing.JFrame {

    private static final TextChecker TEXT_CHECKER = new TextChecker();

    public VAdministrador() {
        initComponents();
        Iniciar();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ev) {
                dispose();
            }
        });
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
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
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
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
        jISBN5 = new javax.swing.JLabel();
        JEstadoLibro = new javax.swing.JComboBox<>();
        JSpinnerNPag = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListEditorial = new javax.swing.JList<>();
        JLocalizacionLibro = new javax.swing.JComboBox<>();
        JSpinnerCantidad = new javax.swing.JSpinner();
        jNPag3 = new javax.swing.JLabel();
        jISBN3 = new javax.swing.JLabel();
        JAreaLibro = new javax.swing.JComboBox<>();
        jISBN4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel16 = new javax.swing.JLabel();
        jISBN7 = new javax.swing.JLabel();
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
        jLabel15 = new javax.swing.JLabel();
        jISBN6 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        JComboEstatusEditorial = new javax.swing.JComboBox<>();
        JNombreTextEditorial = new javax.swing.JTextField();
        JIngresarNuevoEditorial = new javax.swing.JButton();
        JModificarEditorial = new javax.swing.JButton();
        jTitulo14 = new javax.swing.JLabel();
        JEliminarEditorial = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        JTableREditorial = new javax.swing.JTable();
        jTitulo13 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jTitulo15 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        JTableRLocalizacion = new javax.swing.JTable();
        JModificarLocalizacion = new javax.swing.JButton();
        jTitulo18 = new javax.swing.JLabel();
        JComboEstatusLocalizacion = new javax.swing.JComboBox<>();
        JIngresarNuevoLocalizacion = new javax.swing.JButton();
        JEliminarLocalizacion = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        JLocalizacionText = new javax.swing.JTextField();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jTitulo17 = new javax.swing.JLabel();
        JAreaText = new javax.swing.JTextField();
        JIngresarNuevaArea = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        JTableRArea = new javax.swing.JTable();
        JModificarArea = new javax.swing.JButton();
        JActualizar = new javax.swing.JButton();
        JEliminarArea = new javax.swing.JButton();
        JComboEstatusArea = new javax.swing.JComboBox<>();
        jTitulo16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JRegresar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        jRegistrarLibro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jRegistrarLibro.setText("Administrador");

        JInternalLibro.setVisible(true);

        jTitulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo.setText("Título:");

        JTituloText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTituloTextKeyTyped(evt);
            }
        });

        jISBN.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN.setText("ISBN:");

        jNPag.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag.setText("N° Pág:");

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Autor");

        JListAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(JListAutor);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(JModificarLibroTabla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarLibroTabla))
                    .addComponent(jLabel11))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedAdminLibros.addTab("Buscar", JInternalBuscar);

        jISBN5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN5.setText("Estado:");

        JEstadoLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jLabel17.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel17.setText("Libro");

        JListEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(JListEditorial);

        jNPag3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag3.setText("Cantidad:");

        jISBN3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN3.setText("Localización:");

        jISBN4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN4.setText("Área:");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Editorial");

        jLayeredPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(JLocalizacionLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(JSpinnerCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jNPag3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jISBN3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(JAreaLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jISBN4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jISBN4)
                        .addGap(99, 99, 99)
                        .addComponent(JAreaLibro, 0, 99, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jISBN3)
                        .addGap(35, 35, 35)
                        .addComponent(JLocalizacionLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jNPag3)
                        .addGap(18, 18, 18)
                        .addComponent(JSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNPag3)
                    .addComponent(JSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jISBN3)
                    .addComponent(JLocalizacionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JAreaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jISBN4))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

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
                            .addComponent(jLabel17)
                            .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addGroup(JInternalLibroLayout.createSequentialGroup()
                                    .addComponent(jNPag)
                                    .addGap(18, 18, 18)
                                    .addComponent(JSpinnerNPag, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jISBN5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(JInternalLibroLayout.createSequentialGroup()
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTitulo)
                                    .addComponent(jISBN))
                                .addGap(18, 18, 18)
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTituloText, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(JISBNText))))
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedAdminLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalLibroLayout.setVerticalGroup(
            JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(5, 5, 5)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo)
                            .addComponent(JTituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN)
                            .addComponent(JISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag)
                            .addComponent(JSpinnerNPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN5)
                            .addComponent(JEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addComponent(JTabbedAdminLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Libro", JInternalLibro);

        JInternalSocio.setVisible(true);

        jTitulo1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo1.setText("Nombre:");

        jISBN1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN1.setText("Paterno:");

        jNPag1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag1.setText("Materno:");

        jTitulo2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo2.setText("Estado:");

        jTitulo3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo3.setText("Mucicipio:");

        jTitulo4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo4.setText("Calle:");

        JCalleTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JCalleTextSocioKeyTyped(evt);
            }
        });

        jTitulo5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo5.setText("Teléfono:");

        JTelefonoTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTelefonoTextSocioKeyTyped(evt);
            }
        });

        jTitulo6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo6.setText("N°Calle:");

        JNCalleTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JNCalleTextSocioKeyTyped(evt);
            }
        });

        JMunicipioTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JMunicipioTextSocioKeyTyped(evt);
            }
        });

        JEstadoTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JEstadoTextSocioKeyTyped(evt);
            }
        });

        JApellidoMTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoMTextSocioKeyTyped(evt);
            }
        });

        JApellidoPTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoPTextSocioKeyTyped(evt);
            }
        });

        JNombreTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JNombreTextSocioKeyTyped(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        JTextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextUsuarioKeyTyped(evt);
            }
        });

        JEstatusSocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jTitulo8.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo8.setText("Estatus:");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña:");

        JTextContraseñaSocio.setEditable(false);
        JTextContraseñaSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextContraseñaSocioMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel16.setText("Socio");

        jISBN7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN7.setText("Apellido(s):");

        javax.swing.GroupLayout JInternalSocioLayout = new javax.swing.GroupLayout(JInternalSocio.getContentPane());
        JInternalSocio.getContentPane().setLayout(JInternalSocioLayout);
        JInternalSocioLayout.setHorizontalGroup(
            JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTitulo5)
                                            .addComponent(jLabel3))
                                        .addGap(10, 10, 10)
                                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JTelefonoTextSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(JTextUsuario)))
                                    .addComponent(jISBN7)
                                    .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                            .addComponent(jNPag1)
                                            .addGap(18, 18, 18)
                                            .addComponent(JApellidoMTextSocio))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                            .addComponent(jISBN1)
                                            .addGap(18, 18, 18)
                                            .addComponent(JApellidoPTextSocio))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                            .addComponent(jTitulo1)
                                            .addGap(26, 26, 26)
                                            .addComponent(JNombreTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(22, 31, Short.MAX_VALUE)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTitulo6)
                                    .addComponent(jTitulo8)
                                    .addComponent(jLabel4)
                                    .addComponent(jTitulo4)
                                    .addComponent(jTitulo2)
                                    .addComponent(jTitulo3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JEstadoTextSocio)
                                    .addComponent(JNCalleTextSocio)
                                    .addComponent(JTextContraseñaSocio)
                                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                                        .addComponent(JEstatusSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 82, Short.MAX_VALUE))
                                    .addComponent(JCalleTextSocio)
                                    .addComponent(JMunicipioTextSocio, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalSocioLayout.setVerticalGroup(
            JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(8, 8, 8)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNombreTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo1)
                            .addComponent(jTitulo2)
                            .addComponent(JEstadoTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JMunicipioTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTitulo3))
                            .addComponent(jISBN7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTitulo4)
                                    .addComponent(JCalleTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTitulo6)
                                    .addComponent(JNCalleTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JApellidoPTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jISBN1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jNPag1)
                                    .addComponent(JApellidoMTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Socio", JInternalSocio);

        JInternalAutor.setVisible(true);

        jTitulo7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo7.setText("Nombre:");

        JNombreTextAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JNombreTextAutorKeyTyped(evt);
            }
        });

        jISBN2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN2.setText("Paterno:");

        JApellidoPAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoPAutorKeyTyped(evt);
            }
        });

        jNPag2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag2.setText("Materno:");

        JApellidoMAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoMAutorKeyTyped(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel15.setText("Autor");

        jISBN6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN6.setText("Apellido(s):");

        javax.swing.GroupLayout JInternalAutorLayout = new javax.swing.GroupLayout(JInternalAutor.getContentPane());
        JInternalAutor.getContentPane().setLayout(JInternalAutorLayout);
        JInternalAutorLayout.setHorizontalGroup(
            JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalAutorLayout.createSequentialGroup()
                                .addComponent(jNPag2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JApellidoMAutor))
                            .addGroup(JInternalAutorLayout.createSequentialGroup()
                                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jISBN2)
                                    .addComponent(jTitulo7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JNombreTextAutor)
                                    .addComponent(JApellidoPAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
                            .addGroup(JInternalAutorLayout.createSequentialGroup()
                                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                                        .addComponent(jTitulo10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JComboEstatusAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel15)
                                    .addComponent(jISBN6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedBusquedaSocios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalAutorLayout.setVerticalGroup(
            JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTabbedBusquedaSocios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo7)
                            .addComponent(JNombreTextAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jISBN6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN2)
                            .addComponent(JApellidoPAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag2)
                            .addComponent(JApellidoMAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo10)
                            .addComponent(JComboEstatusAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Autor", JInternalAutor);

        jInternalFrame4.setVisible(true);

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

        jTitulo14.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo14.setText("Estatus:");

        JEliminarEditorial.setText("Eliminar");
        JEliminarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarEditorialActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel12.setText("Editoriales");

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

        jTitulo13.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo13.setText("Nombre:");

        jLayeredPane2.setLayer(JComboEstatusEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JNombreTextEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JIngresarNuevoEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JModificarEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTitulo14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JEliminarEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTitulo13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitulo13)
                            .addComponent(jTitulo14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(JComboEstatusEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JIngresarNuevoEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JNombreTextEditorial)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(JModificarEditorial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JEliminarEditorial))
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JNombreTextEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitulo14)
                    .addComponent(JComboEstatusEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JIngresarNuevoEditorial))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JModificarEditorial)
                    .addComponent(JEliminarEditorial))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTitulo15.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo15.setText("Pasillo:");

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

        JModificarLocalizacion.setText("Modificar");
        JModificarLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarLocalizacionActionPerformed(evt);
            }
        });

        jTitulo18.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo18.setText("Estatus:");

        JComboEstatusLocalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        JIngresarNuevoLocalizacion.setText("Ingresar");
        JIngresarNuevoLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevoLocalizacionActionPerformed(evt);
            }
        });

        JEliminarLocalizacion.setText("Eliminar");
        JEliminarLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarLocalizacionActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel13.setText("Localización");

        jLayeredPane3.setLayer(jTitulo15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JModificarLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jTitulo18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JComboEstatusLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JIngresarNuevoLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JEliminarLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JLocalizacionText, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(JModificarLocalizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarLocalizacion))
                    .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane3Layout.createSequentialGroup()
                            .addComponent(jTitulo18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JComboEstatusLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(JIngresarNuevoLocalizacion))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane3Layout.createSequentialGroup()
                            .addComponent(jTitulo15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JLocalizacionText, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLocalizacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitulo18)
                    .addComponent(JComboEstatusLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JIngresarNuevoLocalizacion))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JModificarLocalizacion)
                    .addComponent(JEliminarLocalizacion))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTitulo17.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo17.setText("Estatus:");

        JIngresarNuevaArea.setText("Ingresar");
        JIngresarNuevaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevaAreaActionPerformed(evt);
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

        JModificarArea.setText("Modificar");
        JModificarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarAreaActionPerformed(evt);
            }
        });

        JActualizar.setText("Actualizar");
        JActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActualizarActionPerformed(evt);
            }
        });

        JEliminarArea.setText("Eliminar");
        JEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarAreaActionPerformed(evt);
            }
        });

        JComboEstatusArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jTitulo16.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo16.setText("Sección:");

        jLabel14.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel14.setText("Área");

        jLayeredPane4.setLayer(jTitulo17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JAreaText, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JIngresarNuevaArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JModificarArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JEliminarArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JComboEstatusArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jTitulo16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JActualizar))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(JModificarArea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JEliminarArea))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTitulo16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTitulo17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                        .addComponent(JComboEstatusArea, 0, 1, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JIngresarNuevaArea))
                                    .addComponent(JAreaText, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(JActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JAreaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitulo17)
                    .addComponent(JComboEstatusArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JIngresarNuevaArea))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JModificarArea)
                    .addComponent(JEliminarArea))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2)
                .addGap(29, 29, 29)
                .addComponent(jLayeredPane3)
                .addGap(27, 27, 27)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(861, 861, 861))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane4)
                    .addComponent(jLayeredPane3)
                    .addComponent(jLayeredPane2))
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
                        .addComponent(JTabbedRegistroLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
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
     * Iniciar Página. Crea un objeto Controlador, remueve cualquier texto
     * remanente en combo box y list, Carga la información a los mismos. Un
     * try-catch que llama al método de autocompletar
     *
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
        try {
            loadAuto(Cargar.CargarTexts());
        } catch (java.lang.ExceptionInInitializerError ex) {
            System.err.println("Error in JTatoo file: " + ex.getLocalizedMessage());
        }
        /**
         * VRegistro de Editorial/Localizacion/Area*
         */
        DefaultTableModel Editorial = (DefaultTableModel) JTableREditorial.getModel();
        Cargar.CargarEditorial(Editorial);
        DefaultTableModel Localizacion = (DefaultTableModel) JTableRLocalizacion.getModel();
        Cargar.CargarLocalizacion(Localizacion);
        DefaultTableModel Area = (DefaultTableModel) JTableRArea.getModel();
        Cargar.CargarArea(Area);

    }

    /**
     * Cargar libreria Autocompleter. Si la libreria no se encuentra presente,
     * el programa inicia con normalidad pero sin las funciones de
     * autocompletado
     *
     * @param array
     */
    private void loadAuto(ArrayList array) throws java.lang.ExceptionInInitializerError {
        Autocompleter Autocompleter;
        Autocompleter = new Autocompleter(JTituloText, array);
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
        if (TEXT_CHECKER.ValidadorTexto(A) && TEXT_CHECKER.ValidadorNumero(B)) {
            AdministradorControlador AdministradorControlador = new AdministradorControlador();
            DefaultTableModel model = (DefaultTableModel) JTableRSocio.getModel();
            AdministradorControlador.actionPerformedJIngresarSocio(model, this);
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no validos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JIngresarSocioActionPerformed

    private void JModificarSocioTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarSocioTablaActionPerformed
        String A;
        A = JMunicipioTextSocio.getText() + JNombreTextSocio.getText() + JApellidoPTextSocio.getText() + JApellidoMTextSocio.getText() + JEstadoTextSocio.getText();
        String B;
        B = JTelefonoTextSocio.getText() + JNCalleTextSocio.getText();
        if (TEXT_CHECKER.ValidadorTexto(A) && TEXT_CHECKER.ValidadorNumero(B)) {
            AdministradorControlador AdministradorControlador = new AdministradorControlador();
            AdministradorControlador.actionPerformedJModificarSocio(this);
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no validos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
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
        if (TEXT_CHECKER.ValidadorTexto(A)) {
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
        if (TEXT_CHECKER.ValidadorTexto(A)) {
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
        if (TEXT_CHECKER.ValidadorTexto(A)) {
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

    private void JRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_JRegresarActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Estadisticas*
     */

    private void JEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEstadisticasActionPerformed
        CargarInfoControlador Cargar = new CargarInfoControlador();
        Cargar.CargarInfoEstadisticas();
    }//GEN-LAST:event_JEstadisticasActionPerformed

    private void JTituloTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTituloTextKeyTyped

    }//GEN-LAST:event_JTituloTextKeyTyped

    private void JNombreTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNombreTextSocioKeyTyped
        TEXT_CHECKER.checkColors(JNombreTextSocio);
    }//GEN-LAST:event_JNombreTextSocioKeyTyped

    private void JApellidoPTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoPTextSocioKeyTyped
        TEXT_CHECKER.checkColors(JApellidoPTextSocio);
    }//GEN-LAST:event_JApellidoPTextSocioKeyTyped

    private void JApellidoMTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoMTextSocioKeyTyped
        TEXT_CHECKER.checkColors(JApellidoMTextSocio);
    }//GEN-LAST:event_JApellidoMTextSocioKeyTyped

    private void JEstadoTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JEstadoTextSocioKeyTyped
        TEXT_CHECKER.checkColors(JEstadoTextSocio);
    }//GEN-LAST:event_JEstadoTextSocioKeyTyped

    private void JMunicipioTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JMunicipioTextSocioKeyTyped
        TEXT_CHECKER.checkColors(JMunicipioTextSocio);
    }//GEN-LAST:event_JMunicipioTextSocioKeyTyped

    private void JCalleTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCalleTextSocioKeyTyped
        TEXT_CHECKER.checkColors(JCalleTextSocio);
    }//GEN-LAST:event_JCalleTextSocioKeyTyped

    private void JTelefonoTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTelefonoTextSocioKeyTyped
        if (!TEXT_CHECKER.ValidadorNumero(JTelefonoTextSocio.getText())) {
            JTelefonoTextSocio.setForeground(Color.red);
        } else {
            JTelefonoTextSocio.setForeground(Color.black);
        }
    }//GEN-LAST:event_JTelefonoTextSocioKeyTyped

    private void JNCalleTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNCalleTextSocioKeyTyped
        if (!TEXT_CHECKER.ValidadorNumero(JNCalleTextSocio.getText())) {
            JNCalleTextSocio.setForeground(Color.red);
        } else {
            JNCalleTextSocio.setForeground(Color.black);
        }
    }//GEN-LAST:event_JNCalleTextSocioKeyTyped

    private void JTextUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextUsuarioKeyTyped
        if (!TEXT_CHECKER.checkEmail(JTextUsuario.getText())) {
            JTextUsuario.setForeground(Color.red);
        } else {
            JTextUsuario.setForeground(Color.black);
        }
    }//GEN-LAST:event_JTextUsuarioKeyTyped

    private void JNombreTextAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNombreTextAutorKeyTyped
        TEXT_CHECKER.checkColors(JNombreTextAutor);
    }//GEN-LAST:event_JNombreTextAutorKeyTyped

    private void JApellidoPAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoPAutorKeyTyped
        TEXT_CHECKER.checkColors(JApellidoPAutor);
    }//GEN-LAST:event_JApellidoPAutorKeyTyped

    private void JApellidoMAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoMAutorKeyTyped
        TEXT_CHECKER.checkColors(JApellidoMAutor);
    }//GEN-LAST:event_JApellidoMAutorKeyTyped

    private void JEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarAreaActionPerformed
        AreaControlador AreaControlador = new AreaControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRArea.getModel();
        AreaControlador.actionPerformedJEliminarArea(model, this);
    }//GEN-LAST:event_JEliminarAreaActionPerformed

    private void JActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JActualizarActionPerformed
        JTableREditorial.removeAll();
        JTableRLocalizacion.removeAll();
        JTableRArea.removeAll();
        Iniciar();
    }//GEN-LAST:event_JActualizarActionPerformed

    private void JModificarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarAreaActionPerformed
        AreaControlador AreaControlador = new AreaControlador();
        AreaControlador.actionPerformedJModificarArea(this);
    }//GEN-LAST:event_JModificarAreaActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registros de Area*
     */

    private void JIngresarNuevaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarNuevaAreaActionPerformed
        AreaControlador AreaControlador = new AreaControlador();
        DefaultTableModel model = (DefaultTableModel) JTableRArea.getModel();
        AreaControlador.actionPerformedJIngresarArea(model, this);
    }//GEN-LAST:event_JIngresarNuevaAreaActionPerformed

    private void JTextContraseñaSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTextContraseñaSocioMouseClicked
        JPasswordField pwd = new JPasswordField(10);
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, pwd, "Introducir contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE)) {
            JTextContraseñaSocio.setText(new String(pwd.getPassword()));
        }
    }//GEN-LAST:event_JTextContraseñaSocioMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("DONT CHEAT YOU BAKA");
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
    private javax.swing.JLabel jISBN6;
    private javax.swing.JLabel jISBN7;
    private javax.swing.JLabel jIconLeeyAprende;
    public javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
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
