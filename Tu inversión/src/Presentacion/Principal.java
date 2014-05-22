package Presentacion;

import ModeloDatos.MysqlConnect;
import Negocio.Coordinador;
import Negocio.HiloBolsa;
import Negocio.UtilesGraficos;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    private UtilesGraficos utilesGraficos;
    private HiloBolsa hilo;
    private Coordinador coordinador;

    public Principal() {

        initComponents();

        utilesGraficos = new UtilesGraficos();
        coordinador = new Coordinador();

        utilesGraficos.centrarPanel(this, panel);
        utilesGraficos.pantallaCompleta(this);
        utilesGraficos.cerrar(rootPane, this);

        utilesGraficos.ponerIcono(this);

        hilo = new HiloBolsa();
        hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itRegistrarse = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itLogin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itAcercade = new javax.swing.JMenuItem();
        itConfiguracion = new javax.swing.JMenuItem();
        itSalir = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Prueba.png"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        itConfiguracion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itConfiguracion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/process_16.png"))); // NOI18N
        itConfiguracion.setText("Configuración");
        itConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itConfiguracionActionPerformed(evt);
            }
        });
        jMenu3.add(itConfiguracion);

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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itRegistrarseActionPerformed
        coordinador.cambiarVista(this, "NewUser", 0, "");
    }//GEN-LAST:event_itRegistrarseActionPerformed

    private void itLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itLoginActionPerformed
        coordinador.cambiarVista(this, "Login", 0, "");
    }//GEN-LAST:event_itLoginActionPerformed

    private void itSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itSalirActionPerformed
        int eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Desea salir?");
        if (eleccion == 0) {
            MysqlConnect.getDbCon().cerrarConexiones();
            System.exit(0);
        }
    }//GEN-LAST:event_itSalirActionPerformed

    private void itAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itAcercadeActionPerformed
        AcercaDe acercaDe = new AcercaDe(this, true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_itAcercadeActionPerformed

    private void itConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itConfiguracionActionPerformed
        Configuracion configuracionVista = new Configuracion(this, rootPaneCheckingEnabled, true);
        configuracionVista.setVisible(true);
    }//GEN-LAST:event_itConfiguracionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itAcercade;
    private javax.swing.JMenuItem itConfiguracion;
    private javax.swing.JMenuItem itLogin;
    private javax.swing.JMenuItem itRegistrarse;
    private javax.swing.JMenuItem itSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
