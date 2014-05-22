package Negocio;

import ModeloDatos.Herramientas;
import ModeloDatos.MysqlConnect;
import Presentacion.DialogoValor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Juan
 */
public class UtilesGraficos {

    private Herramientas herramientas;

    public UtilesGraficos() {
        herramientas = new Herramientas();
    }

    public void pantallaCompleta(JFrame frame) {
        frame.setSize(frame.getToolkit().getScreenSize().width, frame.getToolkit().getScreenSize().height - 40);
        frame.setTitle("Tu inversión");
    }

    public void centrarPanel(JFrame frame, JPanel panel) {
        Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setLocation((pantallaTamano.width / 2) - (frame.getWidth() / 2), (pantallaTamano.height / 2) - (frame.getHeight() / 2));
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
    }

    public void cerrar(final JRootPane rootPane, JFrame frame) {
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Desea salir?");
                if (eleccion == 0) {
                    MysqlConnect.getDbCon().cerrarConexiones();
                    System.exit(0);
                }
            }
        });
    }

    public void panelTransparente(JPanel panel) {
        panel.setOpaque(true);
        panel.setBackground(new Color(0, 0, 0, 0));
    }

    public void cambiarLetraCabeceraTabla(JTable table) {
        JTableHeader th;
        th = table.getTableHeader();
        Border empty = BorderFactory.createLineBorder(Color.GRAY);
        Font fuente = new Font("Arial", Font.BOLD, 14);
        th.setBorder(empty);
        th.setBackground(Color.GRAY);
        th.setFont(fuente);
    }

    public void mostrarLabelSesion(JFrame frame, int idUsuario) {
        JLabel label = new JLabel(asignarNombreSesion(idUsuario));
        Font fuente = new Font("Arial", Font.BOLD, 16);
        label.setFont(fuente);
        label.setBounds(40, 0, 800, 30);
        frame.add(label);
    }

    public String asignarNombreSesion(int idUsuario) {
        String query = "SELECT DISTINCT usuarios.nombre, usuarios.primerApellido , usuarios.segundoApellido\n"
                + "FROM sesionesiniciadas,usuarios\n"
                + "WHERE sesionesiniciadas.idUsuario = usuarios.id AND usuarios.id = '" + idUsuario + "'";

        ResultSet rs = null;

        String nombreSesion = "Bienvenido: ";
        try {
            rs = herramientas.selectBD(query);
            if (rs.first()) {
                rs = herramientas.selectBD(query);
                while (rs.next()) {
                    nombreSesion += String.valueOf(rs.getObject("nombre"));
                    nombreSesion += " ";
                    nombreSesion += String.valueOf(rs.getObject("primerApellido"));
                    nombreSesion += " ";
                    nombreSesion += String.valueOf(rs.getObject("segundoApellido"));
                }
            } else {
                return "";
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }

        return nombreSesion;
    }

    public int obtenerId(String query) {
        int id = 0;
        ResultSet rs = null;

        rs = herramientas.selectBD(query);
        try {
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println("ERROR: " + ex.getMessage());
                }
            }
        }

        return id;
    }

    public void cargarComboBox(JComboBox cb, String query) {
        cb.removeAllItems();
        cb.addItem("");
        ResultSet rs = null;

        try {
            rs = herramientas.selectBD(query);

            while (rs.next()) {
                cb.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        }
    }

    public void renderTablaGanancias(JTable table, final boolean aux) {
        TableCellRenderer render = new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                JLabel lbl = new JLabel(value == null ? "" : value.toString());

                Font fuente = new Font("Arial", Font.BOLD, 12);
                Color color = new Color(34, 139, 34);

                if (aux) {
                    if (column == 6) {
                        String valor = value.toString();
                        valor = valor.replace(',', '.');
                        double aux = Double.parseDouble(valor);

                        if (aux > 0) {
                            lbl.setHorizontalAlignment(SwingConstants.CENTER);
                            lbl.setForeground(color);
                            lbl.setOpaque(true);
                            lbl.setBackground(Color.LIGHT_GRAY);
                            lbl.setFont(fuente);
                        } else {
                            if (aux < 0) {
                                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                                lbl.setForeground(Color.RED);
                                lbl.setOpaque(true);
                                lbl.setBackground(Color.LIGHT_GRAY);
                                lbl.setFont(fuente);
                            } else {
                                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                                lbl.setForeground(Color.BLACK);
                                lbl.setOpaque(true);
                                lbl.setBackground(Color.LIGHT_GRAY);
                            }
                        }
                    } else {
                        lbl.setHorizontalAlignment(SwingConstants.CENTER);
                        lbl.setForeground(Color.BLACK);
                        lbl.setOpaque(true);

                        lbl.setBackground(Color.LIGHT_GRAY);
                    }
                } else {
                    if (column == 5) {
                        String valor = value.toString();
                        valor = valor.replace(',', '.');
                        double aux = Double.parseDouble(valor);

                        if (aux > 0) {
                            lbl.setHorizontalAlignment(SwingConstants.CENTER);
                            lbl.setForeground(color);
                            lbl.setOpaque(true);
                            lbl.setBackground(Color.LIGHT_GRAY);
                            lbl.setFont(fuente);
                        } else {
                            if (aux < 0) {
                                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                                lbl.setForeground(Color.RED);
                                lbl.setOpaque(true);
                                lbl.setBackground(Color.LIGHT_GRAY);
                                lbl.setFont(fuente);
                            } else {
                                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                                lbl.setForeground(Color.BLACK);
                                lbl.setOpaque(true);
                                lbl.setBackground(Color.LIGHT_GRAY);
                            }
                        }
                    } else {
                        lbl.setHorizontalAlignment(SwingConstants.CENTER);
                        lbl.setForeground(Color.BLACK);
                        lbl.setOpaque(true);

                        lbl.setBackground(Color.LIGHT_GRAY);
                    }
                }

                return lbl;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

    public void renderTabla(JTable table, final boolean aux) {
        TableCellRenderer render = new TableCellRenderer() {
            int filas = 0;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                JLabel lbl = new JLabel(value == null ? "" : value.toString());

                URL pathIcon = this.getClass().getClassLoader().getResource("Imagenes/flecha_subida.png");
                Toolkit kit = Toolkit.getDefaultToolkit();
                Image imagenRoja = kit.createImage(pathIcon);
                ImageIcon iconVerde = new ImageIcon(imagenRoja);

                URL pathIcon1 = this.getClass().getClassLoader().getResource("Imagenes/flecha_bajada.png");
                Toolkit kit1 = Toolkit.getDefaultToolkit();
                Image imagenVerde = kit1.createImage(pathIcon1);
                ImageIcon iconRojo = new ImageIcon(imagenVerde);

                URL pathIcon2 = this.getClass().getClassLoader().getResource("Imagenes/igual.png");
                Toolkit kit2 = Toolkit.getDefaultToolkit();
                Image imagenIgual = kit2.createImage(pathIcon2);
                ImageIcon iconIgual = new ImageIcon(imagenIgual);

                if (aux) {
                    if (column == 0) {
                        String query = "SELECT diferencia FROM ibex WHERE nombreEmpresa = '" + value + "'";
                        ResultSet rs = herramientas.selectBD(query);
                        double ultimo = 0;
                        try {
                            while (rs.next()) {
                                ultimo = Double.parseDouble(rs.getString("diferencia").replace(',', '.'));
                            }
                        } catch (SQLException ex) {
                            System.err.println("ERROR: " + ex.getMessage());
                        }

                        if (ultimo > 0) {
                            lbl.setIcon(iconVerde);
                        } else {
                            if (ultimo < 0.0) {
                                lbl.setIcon(iconRojo);
                            } else {
                                lbl.setIcon(iconIgual);
                            }
                        }

                        lbl.setHorizontalAlignment(SwingConstants.LEFT);
                        lbl.setForeground(Color.BLACK);
                        lbl.setOpaque(true);
                        lbl.setBackground(Color.LIGHT_GRAY);
                    } else {
                        lbl.setHorizontalAlignment(SwingConstants.CENTER);
                        lbl.setForeground(Color.BLACK);
                        lbl.setOpaque(true);
                        lbl.setBackground(Color.LIGHT_GRAY);
                    }

                    Font fuente = new Font("Arial", Font.BOLD, 12);
                    Color color = new Color(34, 139, 34);

                    if (column == 2) {
                        String valor = value.toString();
                        valor = valor.replace(',', '.');
                        double aux = Double.parseDouble(valor);

                        if (aux > 0) {
                            lbl.setHorizontalAlignment(SwingConstants.CENTER);
                            lbl.setForeground(color);
                            lbl.setOpaque(true);
                            lbl.setBackground(Color.LIGHT_GRAY);
                            lbl.setFont(fuente);
                        } else {
                            if (aux < 0) {
                                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                                lbl.setForeground(Color.RED);
                                lbl.setOpaque(true);
                                lbl.setBackground(Color.LIGHT_GRAY);
                                lbl.setFont(fuente);
                            } else {
                                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                                lbl.setForeground(Color.BLACK);
                                lbl.setOpaque(true);
                                lbl.setBackground(Color.LIGHT_GRAY);
                            }
                        }
                    }

                } else {
                    lbl.setHorizontalAlignment(SwingConstants.CENTER);
                    lbl.setForeground(Color.BLACK);
                    lbl.setOpaque(true);

                    lbl.setBackground(Color.LIGHT_GRAY);
                }

                return lbl;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

    public void ponerIcono(JFrame frame) {
        URL pathIcon = this.getClass().getClassLoader().getResource("Imagenes/process.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(pathIcon);
        frame.setIconImage(img);
    }

    public void cargarTabla(JTable table, String query) {
        ResultSet rs = null;

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try {
            rs = herramientas.selectBD(query);

            Object[] vector = new Object[table.getColumnCount()];
            while (rs.next()) {
                for (int i = 0; i < table.getColumnCount(); i++) {
                    vector[i] = String.valueOf(rs.getObject((i + 1)));
                }
                model.addRow(vector);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }
    }

    public ChartFrame dibujarGraficoLineas(JFrame frame, String nombreEmpresa, int num) {
        String query = "";
        ResultSet rs = null;
        String ultimo = "";

        ChartFrame charFrame = null;

        String formatoDia = "dd";
        SimpleDateFormat dateFormatDia = new SimpleDateFormat(formatoDia);
        String formatoMes = "MM";
        SimpleDateFormat dateFormatMes = new SimpleDateFormat(formatoMes);
        String formatoAnyo = "yyyy";
        SimpleDateFormat dateFormatAnyo = new SimpleDateFormat(formatoAnyo);

        if (nombreEmpresa.equals("IBEX")) {
            query = "SELECT ultimo,fecha FROM historicos_ibex;";
            rs = herramientas.selectBD(query);
            ultimo = "ultimo";
        } else {
            query = "SELECT ultimoValor,fecha FROM historicos WHERE nombreEmpresa = '" + nombreEmpresa + "'";
            rs = herramientas.selectBD(query);
            ultimo = "ultimoValor";
        }

        TimeSeries pop = new TimeSeries(nombreEmpresa, Day.class);

        Calendar calendario = Calendar.getInstance();
        long milis1 = calendario.getTimeInMillis();
        Calendar cal = Calendar.getInstance();

        try {

            while (rs.next()) {
                Date fecha = rs.getDate("fecha");
                Double ultimoValor = rs.getDouble(ultimo);

                cal.setTime(fecha);
                long milis2 = cal.getTimeInMillis();
                long diff = milis1 - milis2;
                long difDias = diff / (24 * 60 * 60 * 1000);

                if (difDias <= num) {
                    int dia = Integer.parseInt(dateFormatDia.format(fecha));
                    int mes = Integer.parseInt(dateFormatMes.format(fecha));
                    int anyo = Integer.parseInt(dateFormatAnyo.format(fecha));

                    pop.add(new Day(dia, mes, anyo), ultimoValor);
                }
            }

            TimeSeriesCollection dataset = new TimeSeriesCollection();
            dataset.addSeries(pop);

            JFreeChart chart = ChartFactory.createTimeSeriesChart("", "Fecha", "Cierre Bolsa", dataset, true, true, false);
            chart.getPlot().setBackgroundPaint(Color.WHITE);

            XYPlot plot = chart.getXYPlot();
            DateAxis axis = (DateAxis) plot.getDomainAxis();
            axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));
            charFrame = new ChartFrame("Gráfico histórico " + nombreEmpresa.toUpperCase(), chart);
            charFrame.pack();
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }

        return charFrame;
    }

    public void cargarTablarDialogoValor(DialogoValor dialogo, String nombreEmpresa) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM ibex WHERE nombreEmpresa = '" + nombreEmpresa + "'";
            rs = herramientas.selectBD(query);
            DefaultTableModel model = (DefaultTableModel) dialogo.tablaFichaValor.getModel();
            String[] vector = new String[2];

            while (rs.next()) {
                vector[0] = "Último precio";
                vector[1] = String.valueOf(rs.getObject("ultimo"));
                model.addRow(vector);
                vector[0] = "Fecha / Hora";
                vector[1] = String.valueOf(rs.getObject("fecha")) + " / " + String.valueOf(rs.getObject("hora"));
                model.addRow(vector);
                vector[0] = "Variación";
                vector[1] = String.valueOf(rs.getObject("diferencia"));
                model.addRow(vector);
                vector[0] = "Máx / Mín sesión";
                vector[1] = String.valueOf(rs.getObject("maximo")) + " / " + String.valueOf(rs.getObject("minimo"));
                model.addRow(vector);
                vector[0] = "Volumen";
                vector[1] = String.valueOf(rs.getObject("volumen"));
                model.addRow(vector);
            }
            String[] vector2 = new String[3];
            rs = herramientas.selectBD(query);
            model = (DefaultTableModel) dialogo.tableMaxMin.getModel();
            while (rs.next()) {
                vector2[0] = "Diario";
                vector2[1] = String.valueOf(rs.getObject("maximo"));
                vector2[2] = String.valueOf(rs.getObject("minimo"));
                model.addRow(vector2);
            }

            if (nombreEmpresa.equals("IBEX")) {
                query = "SELECT fecha,MAX(historicos_ibex.ultimo) \n"
                        + "FROM historicos_ibex\n"
                        + "WHERE historicos_ibex.fecha > '2014/01/01' AND historicos_ibex.ultimo = (SELECT MAX(historicos_ibex.ultimo) \n"
                        + "FROM historicos_ibex);";

                rs = herramientas.selectBD(query);

                String aux = "";

                while (rs.next()) {
                    vector2[0] = "Anual";
                    aux = String.valueOf(rs.getObject(2)) + " - " + String.valueOf(rs.getObject(1));
                    vector2[1] = aux;
                }

                query = "SELECT fecha,MIN(historicos_ibex.ultimo) \n"
                        + "FROM historicos_ibex\n"
                        + "WHERE historicos_ibex.fecha > '2014/01/01' AND historicos_ibex.ultimo = (SELECT MIN(historicos_ibex.ultimo) \n"
                        + "FROM historicos_ibex \n "
                        + "WHERE historicos_ibex.fecha > '2014/01/01');";

                rs = herramientas.selectBD(query);

                while (rs.next()) {
                    aux = String.valueOf(rs.getObject(2)) + " - " + String.valueOf(rs.getObject(1));
                    vector2[2] = aux;
                    model.addRow(vector2);
                }
            } else {
                query = "SELECT historicos.fecha, MAX(historicos.ultimoValor)\n"
                        + "FROM historicos\n"
                        + "WHERE historicos.nombreEmpresa = '" + nombreEmpresa + "' AND historicos.ultimoValor = (SELECT MAX(historicos.ultimoValor) \n"
                        + "FROM historicos\n"
                        + "WHERE historicos.nombreEmpresa = '" + nombreEmpresa + "');";

                rs = herramientas.selectBD(query);

                String aux = "";

                while (rs.next()) {
                    vector2[0] = "Anual";
                    aux = String.valueOf(rs.getObject(2)) + " - " + String.valueOf(rs.getObject(1));
                    vector2[1] = aux;
                }

                query = "SELECT historicos.fecha, MIN(historicos.ultimoValor)\n"
                        + "FROM historicos\n"
                        + "WHERE historicos.nombreEmpresa = '" + nombreEmpresa + "' AND historicos.ultimoValor = (SELECT MIN(historicos.ultimoValor) \n"
                        + "FROM historicos\n"
                        + "WHERE historicos.nombreEmpresa = '" + nombreEmpresa + "');";
                rs = herramientas.selectBD(query);

                while (rs.next()) {
                    aux = String.valueOf(rs.getObject(2)) + " - " + String.valueOf(rs.getObject(1));
                    vector2[2] = aux;
                    model.addRow(vector2);
                }
            }

        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }
    }

    public void cargarTablaPonderado(JTable table, int idUsuario, int idPartida, JTable tableTotales) {
        String query = "SELECT nombreEmpresa, numAcciones, precio\n"
                + "FROM ponderado\n"
                + "WHERE idUsuario = '" + idUsuario + "' AND idPartida = '" + idPartida + "';";
        ResultSet rs = null;
        ResultSet aux = null;

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DecimalFormat formateador = new DecimalFormat("###0.##");
        double formato = 0;

        rs = herramientas.selectBD(query);
        String[] vector = new String[7];

        double precioActual = 0.0;
        double ganancias_perdidas = 0.0;
        double totalInvertido = 0.0;
        double importeTotal = 0.0;

        ArrayList<Object> array = new ArrayList<Object>();

        try {
            while (rs.next()) {
                int numAcciones = rs.getInt("numAcciones");
                double precioPonderado = rs.getDouble("precio");
                String nombreEmpresa = rs.getString("nombreEmpresa");

                query = "SELECT ultimo FROM ibex WHERE nombreEmpresa = '" + nombreEmpresa + "'";

                aux = herramientas.selectBD(query);

                while (aux.next()) {
                    precioActual = aux.getDouble("ultimo");
                }

                vector[0] = String.valueOf(nombreEmpresa);
                vector[1] = String.valueOf(numAcciones);
                vector[2] = String.valueOf(precioPonderado);

                formato = formateador.parse(formateador.format(numAcciones * precioPonderado)).doubleValue();

                vector[3] = String.valueOf(formato);
                vector[4] = String.valueOf(precioActual);

                formato = formateador.parse(formateador.format(precioActual * numAcciones)).doubleValue();

                vector[5] = String.valueOf(formato);

                formato = formateador.parse(formateador.format((precioActual * numAcciones) - (precioPonderado * numAcciones))).doubleValue();

                vector[6] = String.valueOf(formato);

                ganancias_perdidas += (precioActual * numAcciones) - (precioPonderado * numAcciones);
                totalInvertido += (numAcciones * precioPonderado);
                importeTotal += (precioActual * numAcciones);

                model.addRow(vector);

                array.clear();
            }

            if (tableTotales != null) {
                String[] vectorAux = new String[3];
                formato = formateador.parse(formateador.format(totalInvertido)).doubleValue();
                vectorAux[0] = String.valueOf(formato);
                formato = formateador.parse(formateador.format(importeTotal)).doubleValue();
                vectorAux[1] = String.valueOf((formato));
                formato = formateador.parse(formateador.format(ganancias_perdidas)).doubleValue();
                vectorAux[2] = String.valueOf(formato);

                DefaultTableModel modelo = (DefaultTableModel) tableTotales.getModel();
                modelo.addRow(vectorAux);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(UtilesGraficos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (aux != null) {
                    aux.close();
                }

                render(tableTotales);
            } catch (SQLException ex) {
                System.err.println("ERROR: 1 " + ex.getMessage());
            }
        }
    }

    public void render(JTable table) {
        TableCellRenderer render = new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                JLabel lbl = new JLabel(value == null ? "" : value.toString());

                Font fuente = new Font("Arial", Font.BOLD, 12);
                Color color = new Color(34, 139, 34);

                if (column == 2) {
                    String valor = value.toString();
                    valor = valor.replace(',', '.');
                    double aux = Double.parseDouble(valor);

                    if (aux > 0) {
                        lbl.setHorizontalAlignment(SwingConstants.CENTER);
                        lbl.setForeground(color);
                        lbl.setOpaque(true);
                        lbl.setBackground(Color.LIGHT_GRAY);
                        lbl.setFont(fuente);
                    } else {
                        if (aux < 0) {
                            lbl.setHorizontalAlignment(SwingConstants.CENTER);
                            lbl.setForeground(Color.RED);
                            lbl.setOpaque(true);
                            lbl.setBackground(Color.LIGHT_GRAY);
                            lbl.setFont(fuente);
                        } else {
                            lbl.setHorizontalAlignment(SwingConstants.CENTER);
                            lbl.setForeground(Color.BLACK);
                            lbl.setOpaque(true);
                            lbl.setBackground(Color.LIGHT_GRAY);
                        }
                    }
                } else {
                    lbl.setHorizontalAlignment(SwingConstants.CENTER);
                    lbl.setForeground(Color.BLACK);
                    lbl.setOpaque(true);

                    lbl.setBackground(Color.LIGHT_GRAY);
                }

                return lbl;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }
}
