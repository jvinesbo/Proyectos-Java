package Presentacion;

import ModeloDatos.Historicos;
import ModeloDatos.Sesiones;
import Negocio.Coordinador;
import Negocio.UtilesGraficos;

public class Ibex extends javax.swing.JFrame {

    private UtilesGraficos utilesGraficos;
    private Sesiones sesiones;
    private Historicos historicos;
    private Coordinador coordinador;
    private int idUsuario;

    public Ibex(final int idUsuario) {
        initComponents();

        this.idUsuario = idUsuario;

        utilesGraficos = new UtilesGraficos();
        sesiones = new Sesiones();
        historicos = new Historicos();
        coordinador = new Coordinador();

        utilesGraficos.mostrarLabelSesion(this, idUsuario);

        utilesGraficos.centrarPanel(this, panel);
        utilesGraficos.panelTransparente(panel);
        utilesGraficos.pantallaCompleta(this);
        utilesGraficos.ponerIcono(this);
        utilesGraficos.panelTransparente(panelInformacion);

        sesiones.cerrar(rootPane, this, idUsuario);

        utilesGraficos.renderTabla(table, true);
        utilesGraficos.renderTabla(tableIbex, true);
        utilesGraficos.cambiarLetraCabeceraTabla(table);
        utilesGraficos.cambiarLetraCabeceraTabla(tableIbex);

        utilesGraficos.cargarTabla(table, "SELECT nombreEmpresa,ultimo,diferencia,maximo,minimo,volumen,efectivo,fecha,hora FROM ibex WHERE id != 1;");
        utilesGraficos.cargarTabla(tableIbex, "SELECT nombreEmpresa,ultimo,diferencia,maximo,minimo,fecha FROM ibex WHERE id = 1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableIbex = new javax.swing.JTable();
        panelInformacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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

        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        table.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Últ.", "% Dif.", "Máx.", "Mín.", "Volumen", "Efectivo (miles €)", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(20);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel15.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel15.setText("IBEX 35");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ibex_128.png"))); // NOI18N

        tableIbex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Último", "Diferencia (%)", "Máximo", "Mínimo", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableIbex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIbexMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableIbex);

        panelInformacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText("Para ver los datos históricos de las diferentes empresas pulse sobre su fila en la tabla");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Precios expresados en euros.");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText("Efectivo expresado en miles de euros.");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("El volumen y efectivo total incluyendo las operaciones especiales realizadas después del cierre de la sesión está disponible en la consulta histórica.");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText("El volumen y efectivo para cada valor incluye todas las operaciones realizadas hasta el cierre de la sesión de contratación.");

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1)
                        .addGap(310, 310, 310)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        String nombreEmpresa = table.getValueAt(table.getSelectedRow(), 0).toString();

        DialogoValor dialogo_Valor = new DialogoValor(this, rootPaneCheckingEnabled, nombreEmpresa, this);
    }//GEN-LAST:event_tableMouseClicked

    private void tableIbexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIbexMouseClicked
        String nombreEmpresa = "IBEX";

        DialogoValor dialogo_Valor = new DialogoValor(this, rootPaneCheckingEnabled, nombreEmpresa, this);
    }//GEN-LAST:event_tableIbexMouseClicked

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
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JTable table;
    private javax.swing.JTable tableIbex;
    // End of variables declaration//GEN-END:variables
}
