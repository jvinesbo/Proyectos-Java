package Presentacion;

import ModeloDatos.MysqlConnect;
import ModeloDatos.Usuarios;
import Negocio.Coordinador;
import Negocio.Utiles;
import Negocio.UtilesGraficos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

public class NewUser extends javax.swing.JFrame {

    private UtilesGraficos utilesGraficos;
    private Usuarios usuarios;
    private String provincia;
    private Utiles utiles;
    private Coordinador coordinador;

    private static final String VALIDASTRING = "([a-zñáéíóúòèà ]|[A-ZÑÁÉÍÓÚÀÈÒ ]|\\s)+";
    private static final String VALIDATELEFONO = "([0-9]{9,20})";
    private static final String VALIDAEMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String VALIDAINT = "[0-9]+";
    private static final String VALIDADNI = "([0-9]{8}[A-Z]{1})";
    
    public final int idProvincia(String provincia) {
        String query = "SELECT provincias.id FROM provincias WHERE provincias.provincia = '" + provincia + "';";


        int idProvincia = 0;
        ResultSet rs = null;
        try {
            rs = usuarios.selectBD(query);

            while (rs.next()) {
                idProvincia = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Error: 7 " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error: 8 " + ex.getMessage());
            }
        }

        return idProvincia;
    }

    public NewUser() {
        initComponents();

        utilesGraficos = new UtilesGraficos();
        usuarios = new Usuarios();
        utiles = new Utiles();
        coordinador = new Coordinador();

        utilesGraficos.centrarPanel(this, panel);

        utilesGraficos.mostrarLabelSesion(this, -1);
        utilesGraficos.pantallaCompleta(this);
        utilesGraficos.cerrar(rootPane, this);
        utilesGraficos.ponerIcono(this);
        this.btnInsertar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

        utilesGraficos.cargarComboBox(cbProvincia,"SELECT DISTINCT provincia FROM provincias;");
        provincia = cbProvincia.getSelectedItem().toString();
        String query = "SELECT municipios.municipio \n"
                     + "FROM municipios,provincias \n"
                     + "WHERE municipios.provincia = provincias.id AND provincias.id = '" + idProvincia(cbProvincia.getSelectedItem().toString()) + "';";
        utilesGraficos.cargarComboBox(cbMunicipio, query);
        utilesGraficos.cargarComboBox(cbPais, "SELECT DISTINCT nombrePais FROM pais;");
        utilesGraficos.cargarComboBox(cbMunicipio, query);
        utilesGraficos.panelTransparente(panel);
        utilesGraficos.panelTransparente(panelDatos);
        utilesGraficos.panelTransparente(panelDatosLogin);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panelDatosLogin = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreLogin = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtContrasenya = new javax.swing.JPasswordField();
        txtContrasenya2 = new javax.swing.JPasswordField();
        panelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNumeroVia = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtPrimerApellido = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbProvincia = new javax.swing.JComboBox();
        cbMunicipio = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNombreVia = new javax.swing.JTextField();
        cbTipoVia = new javax.swing.JComboBox();
        cbPais = new javax.swing.JComboBox();
        calendar = new com.toedter.calendar.JDateChooser();
        btnInsertar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itRegistrarse = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itLogin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itAcercade = new javax.swing.JMenuItem();
        itSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        panelDatosLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel9.setText("* Nombre Login: ");

        txtNombreLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombreLogin.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel23.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel23.setText("* Contraseña:");

        jLabel24.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel24.setText("Repita Contraseña: ");

        txtContrasenya.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtContrasenya.setPreferredSize(new java.awt.Dimension(6, 25));

        txtContrasenya2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtContrasenya2.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout panelDatosLoginLayout = new javax.swing.GroupLayout(panelDatosLogin);
        panelDatosLogin.setLayout(panelDatosLoginLayout);
        panelDatosLoginLayout.setHorizontalGroup(
            panelDatosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelDatosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelDatosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(txtContrasenya, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContrasenya2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelDatosLoginLayout.setVerticalGroup(
            panelDatosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLoginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelDatosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombreLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtContrasenya2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        panelDatos.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel1.setText("* Nombre: ");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel2.setText("* Primer Apellido: ");

        jLabel7.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel7.setText("* Segundo Apellido: ");

        jLabel8.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel8.setText("* DNI: ");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel3.setText("* Teléfono: ");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel5.setText("* Nombre vía: ");

        jLabel6.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel6.setText("* Población: ");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel4.setText("* Provincia: ");

        jLabel10.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel10.setText("* País: ");

        txtNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombre.setPreferredSize(new java.awt.Dimension(6, 25));

        txtNumeroVia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNumeroVia.setMinimumSize(new java.awt.Dimension(6, 25));

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTelefono.setPreferredSize(new java.awt.Dimension(6, 25));

        txtDni.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDni.setPreferredSize(new java.awt.Dimension(6, 25));

        txtPrimerApellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrimerApellido.setPreferredSize(new java.awt.Dimension(6, 25));

        txtSegundoApellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtSegundoApellido.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel12.setText("* Email: ");

        txtEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel14.setText("* Fecha Nacimiento: ");

        cbProvincia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProvincia.setPreferredSize(new java.awt.Dimension(60, 25));
        cbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProvinciaItemStateChanged(evt);
            }
        });
        cbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProvinciaActionPerformed(evt);
            }
        });

        cbMunicipio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMunicipio.setPreferredSize(new java.awt.Dimension(60, 25));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel11.setText("* Tipo de vía: ");

        jLabel16.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel16.setText("* Número: ");

        txtNombreVia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombreVia.setPreferredSize(new java.awt.Dimension(6, 25));

        cbTipoVia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipoVia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acceso ", "Acera ", "Alameda ", "Autopista ", "Autovía ", "Avenida ", "C. Comercial ", "Calle ", "Callejón ", "Camino ", "Cañada ", "Carrer ", "Carrera ", "Carretera ", "Cuesta ", "Glorieta ", "Pasadizo ", "Pasaje ", "Paseo ", "Plaza ", "Rambla ", "Ronda ", "Sendero ", "Travesía ", "Urbanización ", "Vía" }));
        cbTipoVia.setPreferredSize(new java.awt.Dimension(101, 25));

        cbPais.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbPais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPais.setPreferredSize(new java.awt.Dimension(60, 25));

        calendar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        calendar.setPreferredSize(new java.awt.Dimension(95, 25));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3)
                                .addComponent(jLabel16)
                                .addComponent(jLabel14))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel6)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(191, 191, 191)))
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumeroVia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreVia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13))
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(cbTipoVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        btnInsertar.setBackground(new java.awt.Color(254, 254, 254));
        btnInsertar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        btnInsertar.setText("Crear Usuario");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user_48.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/users_128.png"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(panelDatosLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addGap(130, 130, 130))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(panelDatosLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel18)
                        .addGap(50, 50, 50)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user_24.png"))); // NOI18N
        jMenu1.setText("Registrarse");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itRegistrarse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itRegistrarse.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user_16.png"))); // NOI18N
        itRegistrarse.setText("Registrarse");
        itRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itRegistrarseActionPerformed(evt);
            }
        });
        jMenu1.add(itRegistrarse);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next_24.png"))); // NOI18N
        jMenu2.setText("Login");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next_16.png"))); // NOI18N
        itLogin.setText("Login");
        itLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itLoginActionPerformed(evt);
            }
        });
        jMenu2.add(itLogin);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_24.png"))); // NOI18N
        jMenu3.setText("Salir");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itAcercade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.CTRL_MASK));
        itAcercade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/comment_16.png"))); // NOI18N
        itAcercade.setText("Acerca de");
        itAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itAcercadeActionPerformed(evt);
            }
        });
        jMenu3.add(itAcercade);

        itSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_16.png"))); // NOI18N
        itSalir.setText("Salir");
        itSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itSalirActionPerformed(evt);
            }
        });
        jMenu3.add(itSalir);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (!txtNombre.getText().isEmpty() || !txtPrimerApellido.getText().isEmpty() || !txtSegundoApellido.getText().isEmpty()
                || !txtDni.getText().isEmpty() || !txtTelefono.getText().isEmpty() || !cbTipoVia.getSelectedItem().toString().isEmpty() || !txtNombreVia.getText().isEmpty()
                || !txtNumeroVia.getText().isEmpty() || !cbMunicipio.getSelectedItem().toString().isEmpty() || !cbProvincia.getSelectedItem().toString().isEmpty()
                || !cbPais.getSelectedItem().toString().isEmpty() || !txtNombreLogin.getText().isEmpty() || !txtEmail.getText().isEmpty() || !txtContrasenya.getText().isEmpty() || !txtContrasenya2.getText().isEmpty()) {
            if (utiles.validar(txtNombre.getText(), VALIDASTRING) && utiles.validar(txtPrimerApellido.getText(), VALIDASTRING) && utiles.validar(txtSegundoApellido.getText(), VALIDASTRING)) {
                if (utiles.validar(txtDni.getText(), VALIDADNI)) {
                    if (utiles.validar(txtTelefono.getText(), VALIDATELEFONO)) {
                        if (utiles.validar(txtNombreVia.getText(), VALIDASTRING)) {
                            if (utiles.validar(txtNumeroVia.getText(), VALIDAINT)) {
                                if (utiles.validar(txtEmail.getText(), VALIDAEMAIL)) {
                                    int num = 2;
                                    if (calendar.getCalendar() != null) {
                                        Calendar calendario = calendar.getCalendar();

                                        int dia = calendario.get(Calendar.DATE);
                                        int mes = calendario.get(Calendar.MONTH) + 1;
                                        int anyo = calendario.get(Calendar.YEAR);

                                        String fecha = anyo + "-" + mes + "-" + dia;
                                        if (txtContrasenya.getText().equals(txtContrasenya2.getText())) {

                                            usuarios = new Usuarios(txtNombre.getText(), txtPrimerApellido.getText(), txtSegundoApellido.getText(), fecha, txtDni.getText(), txtTelefono.getText(), txtEmail.getText(), cbTipoVia.getSelectedItem().toString(), txtNombreVia.getText(), txtNumeroVia.getText(), cbMunicipio.getSelectedItem().toString(), cbProvincia.getSelectedItem().toString(), cbPais.getSelectedItem().toString(), txtNombreLogin.getText(), txtContrasenya.getText());
                                            
                                            if(usuarios.insertarBD() == 1){
                                                JOptionPane.showMessageDialog(rootPane, "Usuario creado correctamente.", "", JOptionPane.INFORMATION_MESSAGE);
                                            } else{
                                                JOptionPane.showMessageDialog(rootPane, "No se ha podido crear el usuario.", "", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            
                                            txtNombreVia.setText("");
                                            txtNumeroVia.setText("");
                                            txtDni.setText("");
                                            txtEmail.setText("");
                                            txtNombre.setText("");
                                            txtNombreLogin.setText("");
                                            txtPrimerApellido.setText("");
                                            txtSegundoApellido.setText("");
                                            txtTelefono.setText("");
                                            txtContrasenya.setText("");
                                            txtContrasenya2.setText("");
                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Las contraseñas deben de ser iguales", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Selecciona una fecha.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "El email insertado no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Comprueba que el campo número de vía no contiene \nletras ni carácteres especiales", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Revisa que el nombre de la vía no contiene ni \n números ni carácteres especiales",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "El teléfono no puede contener letras y debe \ncontener contener un mínimo de 9 dígitos", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error en el campo DNI", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Compruebe que el nombre, y los apellidos no \ncontienen números ni carácteres que no sean letras", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Los campos marcados con * no pueden estar vacíos", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void cbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProvinciaItemStateChanged
        if (evt.getStateChange() == 1) {
            provincia = cbProvincia.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cbProvinciaItemStateChanged

    private void cbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProvinciaActionPerformed
        if (provincia != null) {
            int idProvincia = idProvincia(provincia);
            String query = "SELECT municipios.municipio \n"
                     + "FROM municipios,provincias \n"
                     + "WHERE municipios.provincia = provincias.id AND provincias.id = '" + idProvincia + "';";
            utilesGraficos.cargarComboBox(cbMunicipio, query);
        }
    }//GEN-LAST:event_cbProvinciaActionPerformed

    private void itRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itRegistrarseActionPerformed
        coordinador.cambiarVista(this, "NewUser", 0, "");
    }//GEN-LAST:event_itRegistrarseActionPerformed

    private void itLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itLoginActionPerformed
        coordinador.cambiarVista(this, "Login", 0, "");
    }//GEN-LAST:event_itLoginActionPerformed

    private void itAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itAcercadeActionPerformed
        AcercaDe acercaDe = new AcercaDe(this, true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_itAcercadeActionPerformed

    private void itSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itSalirActionPerformed
        int eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Desea salir?");
        if (eleccion == 0) {
            MysqlConnect.getDbCon().cerrarConexiones();
            System.exit(0);
        }
    }//GEN-LAST:event_itSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JComboBox cbMunicipio;
    private javax.swing.JComboBox cbPais;
    private javax.swing.JComboBox cbProvincia;
    private javax.swing.JComboBox cbTipoVia;
    private javax.swing.JMenuItem itAcercade;
    private javax.swing.JMenuItem itLogin;
    private javax.swing.JMenuItem itRegistrarse;
    private javax.swing.JMenuItem itSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelDatosLogin;
    private javax.swing.JPasswordField txtContrasenya;
    private javax.swing.JPasswordField txtContrasenya2;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreLogin;
    private javax.swing.JTextField txtNombreVia;
    private javax.swing.JTextField txtNumeroVia;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
