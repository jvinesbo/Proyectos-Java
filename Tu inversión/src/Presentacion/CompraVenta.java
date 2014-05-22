package Presentacion;

import ModeloDatos.Compras;
import ModeloDatos.Historicos;
import ModeloDatos.Partida;
import ModeloDatos.Ponderado;
import ModeloDatos.Sesiones;
import ModeloDatos.Ventas;
import Negocio.Coordinador;
import Negocio.UtilesGraficos;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class CompraVenta extends javax.swing.JFrame {

    private UtilesGraficos utilesGraficos;
    private Sesiones sesiones;
    private Historicos historicos;
    private Partida partida;
    private Compras compras;
    private Ventas ventas;
    private Coordinador coordinador;
    private int idUsuario;
    private String nombrePartida;
    private boolean flag;

    public CompraVenta(final int idUsuario, String nombrePartida) {
        initComponents();

        this.idUsuario = idUsuario;
        this.nombrePartida = nombrePartida;

        utilesGraficos = new UtilesGraficos();
        sesiones = new Sesiones();
        historicos = new Historicos();
        partida = new Partida();
        compras = new Compras();
        ventas = new Ventas();
        coordinador = new Coordinador();

        utilesGraficos.mostrarLabelSesion(this, idUsuario);
        utilesGraficos.centrarPanel(this, panel);
        utilesGraficos.panelTransparente(panel);
        utilesGraficos.panelTransparente(panelCompra);
        utilesGraficos.panelTransparente(panelVenta);
        utilesGraficos.panelTransparente(panelOpciones);
        utilesGraficos.pantallaCompleta(this);

        utilesGraficos.ponerIcono(this);

        sesiones.cerrar(rootPane, this, idUsuario);

        utilesGraficos.renderTabla(table, false);

        utilesGraficos.cargarTabla(table, "SELECT nombreEmpresa,ultimo FROM ibex WHERE id != 1;");

        spinnerNumAccionesVenta.setEnabled(false);
        btnVender.setEnabled(false);
        flag = false;

        panelVenta.setVisible(false);

        if (nombrePartida.length() > 0) {
            calendarCompra.setEnabled(false);
            calendarVenta.setEnabled(false);
            txtPrecio.setEditable(false);
            txtPrecioVenta.setEditable(false);
        } else {
            txtPrecio.setEditable(true);
            txtPrecioVenta.setEditable(true);
        }

        calendarCompra.setDate(new Date());
        calendarVenta.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        rbCompra = new javax.swing.JRadioButton();
        rbVenta = new javax.swing.JRadioButton();
        capas = new javax.swing.JLayeredPane();
        panelCompra = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        calendarCompra = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        spinnerNumAcciones = new javax.swing.JSpinner();
        panelVenta = new javax.swing.JPanel();
        spinnerNumAccionesVenta = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreEmpresaVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        btnVender = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtAccionesPropias = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        calendarVenta = new com.toedter.calendar.JDateChooser();
        jMenuBar19 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        itIBEX = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        itGestionarCartera = new javax.swing.JMenuItem();
        it_compraVenta = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itInformeDiario = new javax.swing.JMenuItem();
        itInformeHistorico = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        itCrearJuego = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itLista = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        it_actualizar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itLogout = new javax.swing.JMenuItem();
        itAcercade = new javax.swing.JMenuItem();
        itSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Empresa", "Último"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compraVenta_48.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel15.setText("Compra / Venta");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Opciones");

        panelOpciones.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rbCompra);
        rbCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbCompra.setSelected(true);
        rbCompra.setText("Compra");
        rbCompra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCompraItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbVenta);
        rbVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbVenta.setText("Venta");
        rbVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbVentaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCompra)
                    .addComponent(rbVenta))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(rbCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbVenta)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelCompra.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nombre Empresa:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Precio Compra:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Núm. Acciones:");

        txtNombreEmpresa.setEditable(false);
        txtNombreEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnComprar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel10.setText("Compra");

        calendarCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        calendarCompra.setPreferredSize(new java.awt.Dimension(95, 25));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Fecha:");

        spinnerNumAcciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        spinnerNumAcciones.setMinimumSize(new java.awt.Dimension(129, 22));
        spinnerNumAcciones.setPreferredSize(new java.awt.Dimension(129, 22));

        javax.swing.GroupLayout panelCompraLayout = new javax.swing.GroupLayout(panelCompra);
        panelCompra.setLayout(panelCompraLayout);
        panelCompraLayout.setHorizontalGroup(
            panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompraLayout.createSequentialGroup()
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCompraLayout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(btnComprar))
                        .addGroup(panelCompraLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCompraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCompraLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCompraLayout.createSequentialGroup()
                                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(calendarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerNumAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(91, 91, 91))
        );
        panelCompraLayout.setVerticalGroup(
            panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCompraLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraLayout.createSequentialGroup()
                        .addComponent(spinnerNumAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(calendarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnComprar)
                .addContainerGap())
        );

        panelVenta.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        spinnerNumAccionesVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Nombre Empresa:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Precio Venta:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Núm. Acciones:");

        txtNombreEmpresaVenta.setEditable(false);
        txtNombreEmpresaVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnVender.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Acciones Propias:");

        txtAccionesPropias.setEditable(false);
        txtAccionesPropias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("Venta");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Fecha:");

        calendarVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        calendarVenta.setPreferredSize(new java.awt.Dimension(95, 25));

        javax.swing.GroupLayout panelVentaLayout = new javax.swing.GroupLayout(panelVenta);
        panelVenta.setLayout(panelVentaLayout);
        panelVentaLayout.setHorizontalGroup(
            panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(102, 102, 102))
            .addGroup(panelVentaLayout.createSequentialGroup()
                .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVentaLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnVender))
                    .addGroup(panelVentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreEmpresaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAccionesPropias, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerNumAccionesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelVentaLayout.setVerticalGroup(
            panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpresaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAccionesPropias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerNumAccionesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(calendarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVender)
                .addContainerGap())
        );

        javax.swing.GroupLayout capasLayout = new javax.swing.GroupLayout(capas);
        capas.setLayout(capasLayout);
        capasLayout.setHorizontalGroup(
            capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(capasLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(panelVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        capasLayout.setVerticalGroup(
            capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(capasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        capas.setLayer(panelCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(173, 173, 173)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(capas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(capas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ibex_24.png"))); // NOI18N
        jMenu9.setText("IBEX   ");
        jMenu9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itIBEX.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        itIBEX.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itIBEX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ibex_16.png"))); // NOI18N
        itIBEX.setText("Mostrar datos IBEX 35");
        itIBEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itIBEXActionPerformed(evt);
            }
        });
        jMenu9.add(itIBEX);

        jMenuBar19.add(jMenu9);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compraVenta_24.png"))); // NOI18N
        jMenu5.setText("Mis Inversiones   ");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itGestionarCartera.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itGestionarCartera.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itGestionarCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add_to_folder.png"))); // NOI18N
        itGestionarCartera.setText("Gestionar Mi Cartera");
        itGestionarCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itGestionarCarteraActionPerformed(evt);
            }
        });
        jMenu5.add(itGestionarCartera);

        it_compraVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        it_compraVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        it_compraVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compraVenta_16.png"))); // NOI18N
        it_compraVenta.setText("Compra / Venta");
        it_compraVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                it_compraVentaActionPerformed(evt);
            }
        });
        jMenu5.add(it_compraVenta);
        jMenu5.add(jSeparator2);

        itInformeDiario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        itInformeDiario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itInformeDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/folder.png"))); // NOI18N
        itInformeDiario.setText("Crear Informe Diario");
        itInformeDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itInformeDiarioActionPerformed(evt);
            }
        });
        jMenu5.add(itInformeDiario);

        itInformeHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        itInformeHistorico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itInformeHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/folder.png"))); // NOI18N
        itInformeHistorico.setText("Crear Informe Histórico");
        itInformeHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itInformeHistoricoActionPerformed(evt);
            }
        });
        jMenu5.add(itInformeHistorico);

        jMenuBar19.add(jMenu5);

        jMenu18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/juego_24.png"))); // NOI18N
        jMenu18.setText("Juego   ");
        jMenu18.setFocusable(false);
        jMenu18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itCrearJuego.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itCrearJuego.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itCrearJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/juego_16.png"))); // NOI18N
        itCrearJuego.setText("Crear Juego");
        itCrearJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itCrearJuegoActionPerformed(evt);
            }
        });
        jMenu18.add(itCrearJuego);
        jMenu18.add(jSeparator1);

        itLista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itLista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista_16.png"))); // NOI18N
        itLista.setText("Lista de Partidas");
        itLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itListaActionPerformed(evt);
            }
        });
        jMenu18.add(itLista);

        jMenuBar19.add(jMenu18);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_24.png"))); // NOI18N
        jMenu1.setText("Actualizar histórico");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        it_actualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        it_actualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        it_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_16.png"))); // NOI18N
        it_actualizar.setText("Actualizar");
        it_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                it_actualizarActionPerformed(evt);
            }
        });
        jMenu1.add(it_actualizar);

        jMenuBar19.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_24.png"))); // NOI18N
        jMenu2.setText("Salir");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itLogout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        itLogout.setText("Logout");
        itLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itLogoutActionPerformed(evt);
            }
        });
        jMenu2.add(itLogout);

        itAcercade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.CTRL_MASK));
        itAcercade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/comment_16.png"))); // NOI18N
        itAcercade.setText("Acerca de");
        itAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itAcercadeActionPerformed(evt);
            }
        });
        jMenu2.add(itAcercade);

        itSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_16.png"))); // NOI18N
        itSalir.setText("Salir");
        itSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itSalirActionPerformed(evt);
            }
        });
        jMenu2.add(itSalir);

        jMenuBar19.add(jMenu2);

        setJMenuBar(jMenuBar19);

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
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean venta(Ventas ventas) {
        int resultado = ventas.insert();
        boolean aux = false;

        if (resultado == 1) {
            double gan_per = ventas.sacarPrecioCompra();
            if (gan_per > 0) {
                JOptionPane.showMessageDialog(rootPane, "Venta realizada con éxito. Ganado: " + gan_per);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Venta realizada con éxito. Perdido: " + gan_per);
            }
            aux = true;
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se ha podido realizar la venta.", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = false;
        }

        return aux;
    }

    private void logicaVenta(Ventas ventas) {
        if (ventas.getCantidad() <= Integer.parseInt(txtAccionesPropias.getText())) {
            if (ventas.getCantidad() == Integer.parseInt(txtAccionesPropias.getText())) {
                if (venta(ventas)) {
                    ventas.delete();
                }
            } else {
                if (venta(ventas)) {
                    ventas.update();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No puedes vender más acciones de las que tienes en tu cartera.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        txtNombreEmpresaVenta.setText("");
        txtAccionesPropias.setText("");
        txtPrecioVenta.setText("");
        spinnerNumAccionesVenta.setValue(0);
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (flag) {
            txtNombreEmpresaVenta.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            txtPrecioVenta.setText(table.getValueAt(table.getSelectedRow(), 1).toString());

            int idPartida = 0;
            idPartida = partida.seleccionDB("SELECT id FROM partida WHERE nombre = '" + nombrePartida + "'");
            ventas.setIdUsuario(idUsuario);
            ventas.setIdPartida(idPartida);
            ventas.setNombreEmpresa(txtNombreEmpresaVenta.getText());

            txtAccionesPropias.setText(ventas.numeroAcciones());
        } else {
            txtNombreEmpresa.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            txtPrecio.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        int numCompra = 0;
        if (txtNombreEmpresa.getText().isEmpty() || txtPrecio.getText().isEmpty() || spinnerNumAcciones.getValue().toString().isEmpty() || calendarCompra.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "No pueden haber campos vacíos.");
        } else {
            partida.setNombre(nombrePartida);

            Ponderado ponderado = new Ponderado();

            Calendar calendario = calendarCompra.getCalendar();
            int dia = calendario.get(Calendar.DATE);
            int mes = calendario.get(Calendar.MONTH) + 1;
            int anyo = calendario.get(Calendar.YEAR);
            String fechaEmpezar = anyo + "-" + mes + "-" + dia;

            int ponInsert = 0, ponUpdate = 0;
            int idPartida = 0;
            idPartida = partida.seleccionDB("SELECT id FROM partida WHERE nombre = '" + partida.getNombre() + "'");

            compras.setPrecioCompra(Double.parseDouble(txtPrecio.getText()));
            compras.setCantidad(Integer.parseInt(spinnerNumAcciones.getValue().toString()));
            compras.setIdPartida(idPartida);
            compras.setNombreEmpresa(txtNombreEmpresa.getText());
            compras.setIdUsuario(idUsuario);
            compras.setFecha(fechaEmpezar);
            compras.setTotal((Double.parseDouble(txtPrecio.getText())) * (Integer.parseInt(spinnerNumAcciones.getValue().toString())));

            if (nombrePartida.length() <= 0) {
                ponderado = compras.selectDB();
                ponderado.setIdPartida(idPartida);
                ponderado.setIdUsuario(idUsuario);
                ponderado.setNombre(txtNombreEmpresa.getText());
                if (ponderado.getNumAcciones() == 0 && ponderado.getPrecio() == 0) {
                    ponderado.setNumAcciones(Integer.parseInt(spinnerNumAcciones.getValue().toString()));
                    ponderado.setPrecio(Double.parseDouble(txtPrecio.getText()));
                    ponInsert = ponderado.insert();
                    numCompra = compras.insert();
                } else {
                    ponderado.setNumAcciones(Integer.parseInt(spinnerNumAcciones.getValue().toString()));
                    ponUpdate = ponderado.update(compras);
                    numCompra = compras.insert();
                }
            } else {
                if (compras.comprobarSaldo() < ((Double.parseDouble(txtPrecio.getText())) * (Integer.parseInt(spinnerNumAcciones.getValue().toString())))) {
                    JOptionPane.showMessageDialog(rootPane, "La compra no se puede realizar porque no dispone de suficiente saldo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    ponderado = compras.selectDB();
                    ponderado.setIdPartida(idPartida);
                    ponderado.setIdUsuario(idUsuario);
                    ponderado.setNombre(txtNombreEmpresa.getText());
                    if (ponderado.getNumAcciones() == 0 && ponderado.getPrecio() == 0) {
                        ponderado.setNumAcciones(Integer.parseInt(spinnerNumAcciones.getValue().toString()));
                        ponderado.setPrecio(Double.parseDouble(txtPrecio.getText()));
                        ponInsert = ponderado.insert();
                        numCompra = compras.insert();
                    } else {
                        ponderado.setNumAcciones(Integer.parseInt(spinnerNumAcciones.getValue().toString()));
                        ponUpdate = ponderado.update(compras);
                        numCompra = compras.insert();
                    }
                }
            }

            if (numCompra == 1 && ponInsert == 1) {
                JOptionPane.showMessageDialog(rootPane, "Compra realizada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                 if (nombrePartida.length() > 0){
                     compras.actualizarSaldo();
                 }
            }

            if (numCompra == 1 && ponUpdate == 1) {
                JOptionPane.showMessageDialog(rootPane, "Compra realizada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                if (nombrePartida.length() > 0){
                     compras.actualizarSaldo();
                 }
            }

            if (numCompra != 1 && ponInsert != 1 && ponUpdate != 1) {
                JOptionPane.showMessageDialog(rootPane, "Error al realizar la compra.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

            txtNombreEmpresa.setText("");
            spinnerNumAcciones.setValue(0);
            txtPrecio.setText("");
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        if (txtNombreEmpresaVenta.getText().isEmpty() || txtPrecioVenta.getText().isEmpty() || txtAccionesPropias.getText().isEmpty()
                || spinnerNumAccionesVenta.getValue().toString().isEmpty() || calendarVenta.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "No pueden haber campos vacíos.");
        } else {
            Calendar calendario = calendarVenta.getCalendar();
            int dia = calendario.get(Calendar.DATE);
            int mes = calendario.get(Calendar.MONTH) + 1;
            int anyo = calendario.get(Calendar.YEAR);
            String fechaEmpezar = anyo + "-" + mes + "-" + dia;

            int idPartida = 0;
            idPartida = partida.seleccionDB("SELECT id FROM partida WHERE nombre = '" + nombrePartida + "'");

            ventas.setIdUsuario(idUsuario);
            ventas.setIdPartida(idPartida);
            ventas.setNombreEmpresa(txtNombreEmpresaVenta.getText());
            ventas.setFecha(fechaEmpezar);
            ventas.setNombreEmpresa(txtNombreEmpresaVenta.getText());
            ventas.setPrecioVenta(Double.parseDouble(txtPrecioVenta.getText()));
            ventas.setCantidad(Integer.parseInt(spinnerNumAccionesVenta.getValue().toString()));

            if (Integer.parseInt(spinnerNumAccionesVenta.getValue().toString()) <= 0) {
                JOptionPane.showMessageDialog(rootPane, "No se puede realizar una venta si el número de acciones es 0 o menor que 0.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (nombrePartida.length() <= 0) {
                    logicaVenta(ventas);
                } else {
                    logicaVenta(ventas);
                }
            }
        }
    }//GEN-LAST:event_btnVenderActionPerformed

    private void rbCompraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCompraItemStateChanged
        spinnerNumAccionesVenta.setEnabled(false);
        btnVender.setEnabled(false);
        spinnerNumAcciones.setEnabled(true);
        btnComprar.setEnabled(true);
        flag = false;
        txtNombreEmpresaVenta.setText("");
        txtPrecioVenta.setText("");
        txtAccionesPropias.setText("");

        panelCompra.setVisible(true);
        capas.setLayer(panelCompra, 0, 0);
        panelVenta.setVisible(false);

        this.repaint();
    }//GEN-LAST:event_rbCompraItemStateChanged

    private void rbVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbVentaItemStateChanged
        spinnerNumAcciones.setEnabled(false);
        spinnerNumAccionesVenta.setEnabled(true);
        btnComprar.setEnabled(false);
        btnVender.setEnabled(true);
        flag = true;
        txtNombreEmpresa.setText("");
        txtPrecio.setText("");

        panelVenta.setVisible(true);
        capas.setLayer(panelVenta, 0, 0);
        panelCompra.setVisible(false);

        this.repaint();
    }//GEN-LAST:event_rbVentaItemStateChanged

    private void itIBEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itIBEXActionPerformed
        coordinador.cambiarVista(this, "Ibex", idUsuario, "");
    }//GEN-LAST:event_itIBEXActionPerformed

    private void itGestionarCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itGestionarCarteraActionPerformed
        coordinador.cambiarVista(this, "GestionarCarteraParticular", idUsuario, "");
    }//GEN-LAST:event_itGestionarCarteraActionPerformed

    private void it_compraVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_it_compraVentaActionPerformed
        coordinador.cambiarVista(this, "CompraVenta", idUsuario, "");
    }//GEN-LAST:event_it_compraVentaActionPerformed

    private void itInformeDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itInformeDiarioActionPerformed
        ReportDiario reportDiario = new ReportDiario(this, rootPaneCheckingEnabled, idUsuario);
        reportDiario.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_itInformeDiarioActionPerformed

    private void itInformeHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itInformeHistoricoActionPerformed
        ReportHistorico dialogoReport = new ReportHistorico(this, true, idUsuario);
        dialogoReport.setVisible(true);
    }//GEN-LAST:event_itInformeHistoricoActionPerformed

    private void itCrearJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itCrearJuegoActionPerformed
        coordinador.cambiarVista(this, "CrearJuego", idUsuario, "");
    }//GEN-LAST:event_itCrearJuegoActionPerformed

    private void itListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itListaActionPerformed
        coordinador.cambiarVista(this, "ListaPartidas", idUsuario, "");
    }//GEN-LAST:event_itListaActionPerformed

    private void it_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_it_actualizarActionPerformed
        historicos.creacionHistoricos();
    }//GEN-LAST:event_it_actualizarActionPerformed

    private void itLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itLogoutActionPerformed
        sesiones.cerrarSesion(idUsuario, rootPane, false, this);
    }//GEN-LAST:event_itLogoutActionPerformed

    private void itAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itAcercadeActionPerformed
        AcercaDe acercaDe = new AcercaDe(this, true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_itAcercadeActionPerformed

    private void itSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itSalirActionPerformed
        sesiones.cerrarSesion(idUsuario, rootPane, true, this);
    }//GEN-LAST:event_itSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVender;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser calendarCompra;
    private com.toedter.calendar.JDateChooser calendarVenta;
    private javax.swing.JLayeredPane capas;
    private javax.swing.JMenuItem itAcercade;
    private javax.swing.JMenuItem itCrearJuego;
    private javax.swing.JMenuItem itGestionarCartera;
    private javax.swing.JMenuItem itIBEX;
    private javax.swing.JMenuItem itInformeDiario;
    private javax.swing.JMenuItem itInformeHistorico;
    private javax.swing.JMenuItem itLista;
    private javax.swing.JMenuItem itLogout;
    private javax.swing.JMenuItem itSalir;
    private javax.swing.JMenuItem it_actualizar;
    private javax.swing.JMenuItem it_compraVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelCompra;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelVenta;
    private javax.swing.JRadioButton rbCompra;
    private javax.swing.JRadioButton rbVenta;
    private javax.swing.JSpinner spinnerNumAcciones;
    private javax.swing.JSpinner spinnerNumAccionesVenta;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAccionesPropias;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNombreEmpresaVenta;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
