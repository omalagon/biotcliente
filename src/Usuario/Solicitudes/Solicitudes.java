/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.solicitudes;

import EstructurasAux.ItemInventario;
import EstructurasAux.datosFormatos;
import EstructurasAux.solicitudPr;
import EstructurasAux.users;
import Formatos.fdc001;
import Usuario.Reportes.ReporteSolicitudes;
import Usuario.Utils.InputDialogCBox;
import cliente.Cliente;
import interfaces.Usuario;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Solicitudes extends javax.swing.JFrame {

    private static String id = null;
    private static final GregorianCalendar hoy = new GregorianCalendar();
    public static ArrayList<ItemInventario> itemsSolicitud = new ArrayList<>();
    private ArrayList<ItemInventario> aux = new ArrayList<>();
    private static String cadenaFecha = hoy.get(Calendar.DAY_OF_MONTH) + "/" + (hoy.get(Calendar.MONTH) + 1) + "/" + hoy.get(Calendar.YEAR);
    private String area = null;
    String usuario = null;
    private ArrayList<solicitudPr> solicitudes = null;
    private ArrayList<Object[]> items = new ArrayList<>();

    /**
     * Creates new form Solicitudes
     */
    public Solicitudes() {
        initComponents();
    }

    Solicitudes(String id) {
        initComponents();
        setIcon();
        Usuario u = cliente.Cliente.conectarU();
        Solicitudes.id = id;
        this.setLocationRelativeTo(null);
        this.setSize(1050, this.getHeight());
        try {
            users datosUsuario = u.getDatosUsuario(id);
            this.area = datosUsuario.getLab();
            this.usuario = datosUsuario.getNombre();
        } catch (RemoteException ex) {
            Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.jTFieldAreaProcesoSolicitante.setText(area);
        this.jTFieldAreaProcesoSolicitante.setEditable(false);
        this.jTFieldNombreSolicitante.setText(usuario);
        this.jTFieldNombreSolicitante.setEditable(false);
        this.jlbFecha.setText(cadenaFecha);
        this.btnRefrescarSolicitudes.doClick();
        this.Observaciones.setLineWrap(true);
        this.jta_verObs.setLineWrap(true);
        this.jta_verObs.setEditable(false);
        Observaciones.getDocument().addDocumentListener(new DocumentListener() {
            int length = Observaciones.getText().length();

            @Override
            public void insertUpdate(DocumentEvent e) {
                length = Observaciones.getText().length();
                lblRestantes.setText(Integer.toString((475 - length)));
                String maximo = "";
                if (new Integer(lblRestantes.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, ""
                            + "<html>"
                            + "<body>"
                            + "Si la cantidad de caracteres ingresados en el campo de observaciones"
                            + " es mayor a 475,<br></br> la solicitud no se guardará"
                            + "</body>"
                            + "</html>");
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                length = Observaciones.getText().length();
                lblRestantes.setText(Integer.toString((475 - length)));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        tablaVerSolicitudes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            Usuario u = cliente.Cliente.conectarU();

            @Override
            public void valueChanged(ListSelectionEvent e) {
                BigDecimal aux = new BigDecimal(tablaVerSolicitudes.getValueAt(tablaVerSolicitudes.getSelectedRow(), 0).toString());
                DefaultTableModel df = (DefaultTableModel) tablaItems.getModel();
                for (int i = df.getRowCount() - 1; i >= 0; i--) {
                    df.removeRow(i);
                }
                for (int i = items.size() - 1; i >= 0; i--) {
                    items.remove(i);
                }

                try {
                    ArrayList<ItemInventario> items_numSol = u.getItems_numSol(aux);
                    for (ItemInventario i : items_numSol) {
                        Object[] datos = new Object[3];
                        datos[0] = i.getNumero();
                        datos[1] = i.getDescripcion();
                        datos[2] = i.getCantidadSolicitada();
                        items.add(datos);
                        df.addRow(datos);

                    }
                    jta_verObs.setText(u.getSolicitud(Integer.toString(aux.intValue())).getObservaciones());
                } catch (RemoteException ex) {
                    Logger.getLogger(ReporteSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAdministrador = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbFecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTFieldAreaProcesoSolicitante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFieldNombreSolicitante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableIngresarItems = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        BotonEnviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Observaciones = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        lblRestantes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVerSolicitudes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnGenerarFDC001 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnRefrescarSolicitudes = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnVolver1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaItems = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jta_verObs = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        labelAdministrador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelAdministrador.setText("Menú de Solicitudes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Diligencie el siguiente formato");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fecha");

        jlbFecha.setText("jLabel3");

        jLabel3.setText("Nota: Si necesita algún ítem que no se encuentre en el inventario,");

        jLabel5.setText("Observaciones");

        jLabel6.setText("Area o Proceso solicitante");

        jTFieldAreaProcesoSolicitante.setText("jTextField1");

        jLabel7.setText("Nombre del Solicitante");

        jTFieldNombreSolicitante.setText("jTextField2");

        jLabel8.setText("Items");

        jTableIngresarItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lab Solicitante", "Codigo", "Descripción", "Cantidad Actual", "Presentación", "Cantidad Solicitada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableIngresarItems);

        jLabel10.setText(" debe comunicarse directamente con el Director Administrativo. ");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Enviar Solicitud");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NO.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar Ítem");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Volver");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Carrito.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        BotonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OK.png"))); // NOI18N
        BotonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(BotonEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotonEnviar, btnAgregar, btnVolver});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonEnviar, btnAgregar, btnVolver});

        Observaciones.setColumns(20);
        Observaciones.setRows(5);
        jScrollPane3.setViewportView(Observaciones);

        jLabel13.setText("Caracteres restantes:");

        lblRestantes.setText("475");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlbFecha))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(41, 41, 41))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFieldNombreSolicitante, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                    .addComponent(jTFieldAreaProcesoSolicitante))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblRestantes)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jlbFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFieldAreaProcesoSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFieldNombreSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblRestantes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Productos", jPanel1);

        tablaVerSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Solicitud", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVerSolicitudes);

        btnGenerarFDC001.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/L_reportes.png"))); // NOI18N
        btnGenerarFDC001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFDC001ActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Generar Archivo");

        btnRefrescarSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ACT.png"))); // NOI18N
        btnRefrescarSolicitudes.setMaximumSize(new java.awt.Dimension(133, 91));
        btnRefrescarSolicitudes.setMinimumSize(new java.awt.Dimension(133, 91));
        btnRefrescarSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarSolicitudesActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Refrescar");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NO.png"))); // NOI18N
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Volver");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerarFDC001, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefrescarSolicitudes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGenerarFDC001, btnRefrescarSolicitudes, btnVolver1});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefrescarSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarFDC001, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGenerarFDC001, btnRefrescarSolicitudes, btnVolver1});

        tablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Interno", "Descripción", "Cantidad Solicitada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaItems);

        jLabel16.setText("Observaciones:");

        jta_verObs.setColumns(20);
        jta_verObs.setRows(5);
        jScrollPane4.setViewportView(jta_verObs);

        jLabel17.setText("Items de la solicitud");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mis Solicitudes", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdministrador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarSolicitudesActionPerformed
        DefaultTableModel df = (DefaultTableModel) this.tablaVerSolicitudes.getModel();
        Usuario u = cliente.Cliente.conectarU();

        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        try {
            solicitudes = u.getIdSolicitud(Solicitudes.id);
            System.out.println(solicitudes);
        } catch (RemoteException ex) {
            Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
        GregorianCalendar fecha;
        for (solicitudPr s : solicitudes) {
            fecha = s.getFecha();

            Object[] datos = new Object[2];
            datos[0] = s.getNum_sol();
            datos[1] = fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);

            df.addRow(datos);
        }
    }//GEN-LAST:event_btnRefrescarSolicitudesActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        SeleccionarDatos s = new SeleccionarDatos(Solicitudes.id);
        s.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuSolicitud menu = new MenuSolicitud(id);
        menu.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void BotonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviarActionPerformed
        try {
            DefaultTableModel df = (DefaultTableModel) Solicitudes.jTableIngresarItems.getModel();
            Usuario u = cliente.Cliente.conectarU();
            users datosUsuario = u.getDatosUsuario(id);
            solicitudPr sol = new solicitudPr(hoy, this.Observaciones.getText(), null, Solicitudes.id, jTFieldNombreSolicitante.getText(), datosUsuario.getLab());
            Integer numSol = 0;
            int ite = 0;
            boolean aceptado = true;

            for (ItemInventario i : itemsSolicitud) {
                if (df.getValueAt(ite, 5) != null) {
                    if (new Float(df.getValueAt(ite, 5).toString()) > 0) {
                        i.setCantidadSolicitada(new Float(df.getValueAt(ite, 5).toString()));
                        ite++;
                    } else {
                        JOptionPane.showMessageDialog(null, "El valor de la cantidad solicitada debe ser mayor a cero");
                        df.setValueAt("", ite, 5);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad solicitada");

                }
            }
            for (ItemInventario ii : itemsSolicitud) {
                if (ii.getCantidadSolicitada() == 0) {
                    aceptado = false;
                }
            }

            if (aceptado == true) {
                numSol = u.crearSolicitud(sol, Solicitudes.itemsSolicitud);
                if (numSol != 0) {
                    JOptionPane.showMessageDialog(null, "El número de la solicitud hecha es:  " + numSol);
                } else {
                    JOptionPane.showMessageDialog(null, "No fue posible realizar la solicitud");

                }
            }

            this.btnRefrescarSolicitudes.doClick();
            this.Observaciones.setText("");
            for (int i = df.getRowCount() - 1; i >= 0; i--) {
                df.removeRow(i);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonEnviarActionPerformed

    private void btnGenerarFDC001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFDC001ActionPerformed
        Usuario u = Cliente.conectarU();
        ArrayList<Object> aux = new ArrayList<>();
        for (solicitudPr s : this.solicitudes) {
            aux.add(Integer.toString(s.getNum_sol().intValue()));
        }
        InputDialogCBox seleccion = new InputDialogCBox(aux.toArray(), "Seleccione el numero de solicitud", "Numero solicitud");
        String numSol = seleccion.retorno();
        if (numSol != null) {
            try {
                solicitudPr solicitud = u.getSolicitud(numSol);
                JOptionPane.showMessageDialog(null, "Obteniendo información de la solicitud", "Solicitud", JOptionPane.INFORMATION_MESSAGE);
                ArrayList<ItemInventario> items_numSol = u.getItems_numSol(new BigDecimal(numSol));
                users datosUsuario = u.getDatosUsuario(this.id);
                fdc001 fdc = new fdc001();
                datosFormatos datos = u.getDatos("1");
                String rutaImagen;
                String property = System.getProperty("user.dir");
                System.out.println(property);
                rutaImagen = property.concat("\\src\\Imagenes\\iconB.png");
                HashMap<String, String> parametros = new HashMap<>();
                parametros.put("revision", datos.getRevision());
                parametros.put("fechaAct", datos.getFechaActualizacion());
                parametros.put("titulo", datos.getTitulo());
                parametros.put("image", rutaImagen);
                parametros.put("numsol", numSol);
                parametros.put("fecha", new java.util.Date(solicitud.getFecha().getTimeInMillis()).toString());
                parametros.put("area", datosUsuario.getLab());
                parametros.put("nombreRA", datosUsuario.getNombre());
                parametros.put("observaciones", solicitud.getObservaciones());
                parametros.put("nombreAO", "");
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.showOpenDialog(this);
                String path = chooser.getSelectedFile().getPath();
                File archivo = fdc001.metodo(path, parametros, ItemInventario.toObjectArray(items_numSol));
                if (JOptionPane.showConfirmDialog(null, "¿Desea abrir el archivo?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(archivo);
                    } catch (IOException ex) {
                        Logger.getLogger(ReporteSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (RemoteException ex) {
                Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGenerarFDC001ActionPerformed

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        this.btnVolver.doClick();
    }//GEN-LAST:event_btnVolver1ActionPerformed

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
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Solicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEnviar;
    private javax.swing.JTextArea Observaciones;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGenerarFDC001;
    private javax.swing.JButton btnRefrescarSolicitudes;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolver1;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTFieldAreaProcesoSolicitante;
    private javax.swing.JTextField jTFieldNombreSolicitante;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTableIngresarItems;
    private javax.swing.JLabel jlbFecha;
    private javax.swing.JTextArea jta_verObs;
    private javax.swing.JLabel labelAdministrador;
    private javax.swing.JLabel lblRestantes;
    private javax.swing.JTable tablaItems;
    private javax.swing.JTable tablaVerSolicitudes;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }

    public static void actTabla(ArrayList<ItemInventario> items) {
        DefaultTableModel df = (DefaultTableModel) Solicitudes.jTableIngresarItems.getModel();
        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        for (ItemInventario i : items) {
            Object[] datos = new Object[5];
            datos[0] = i.getInventario();
            datos[1] = i.getNumero();
            datos[2] = i.getDescripcion();
            datos[3] = i.getCantidad();
            datos[4] = i.getPresentacion();
            df.addRow(datos);
        }
    }

}
