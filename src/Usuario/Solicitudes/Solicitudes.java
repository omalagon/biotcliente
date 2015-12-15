/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.solicitudes;

import EstructurasAux.ItemInventario;
import EstructurasAux.solicitudPr;
import interfaces.Usuario;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
            this.area = u.area(id);
            this.usuario = u.getUsuario(id);
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
        Observaciones.getDocument().addDocumentListener(new DocumentListener() {
            int length = Observaciones.getText().length();
            @Override
            public void insertUpdate(DocumentEvent e) {
                length = Observaciones.getText().length();
                lblRestantes.setText(Integer.toString((500-length)));
                String maximo ="";
                if(new Integer(lblRestantes.getText())<0)
                {
                    JOptionPane.showMessageDialog(null, ""
                            + "<html>"
                            + "<body>"
                            + "Si la cantidad de caracteres ingresados en el campo de observaciones"
                            + " es mayor a 500,<br></br> la solicitud no se guardará"
                            + "</body>"
                            + "</html>" );
                }
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                length = Observaciones.getText().length();
                lblRestantes.setText(Integer.toString((500-length)));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        btnRefrescarSolicitudes = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

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

        lblRestantes.setText("500");

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
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
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
                "Numero de Solicitud", "Fecha", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVerSolicitudes);

        btnRefrescarSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ACT.png"))); // NOI18N
        btnRefrescarSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarSolicitudesActionPerformed(evt);
            }
        });

        jLabel12.setText("Refrescar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefrescarSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRefrescarSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addGap(40, 40, 40))))
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
    ArrayList<solicitudPr> solicitudes = null;
    try {
        solicitudes = u.getIdSolicitud(Solicitudes.id);
        System.out.println(solicitudes);
    } catch (RemoteException ex) {
        Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
    }
    GregorianCalendar fecha;
    for (solicitudPr s : solicitudes) {
        fecha = s.getFecha();

        Object[] datos = new Object[3];
        datos[0] = s.getNum_sol();
        datos[1] = fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
        datos[2] = s.getObservaciones();
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
            solicitudPr sol = new solicitudPr(hoy, this.Observaciones.getText(), null, Solicitudes.id, jTFieldNombreSolicitante.getText(), u.area(id));
            BigDecimal numSol = null;
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
                try {
                    u.crearSolicitud(sol);
                    numSol = u.solicitudValida(Solicitudes.id);
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(numSol);
                if (numSol != null) {
                    try {
                        u.itemxsolicitud(Solicitudes.itemsSolicitud, numSol);
                    } catch (RemoteException ex) {
                        Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "El número de la solicitud hecha es:  " + numSol);
                } else {
                    JOptionPane.showMessageDialog(null, "No fue posible realizar la solicitud");
                    
                }
            }
            
            this.btnRefrescarSolicitudes.doClick();
            for (int i = df.getRowCount() - 1; i >= 0; i--) {
                df.removeRow(i);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonEnviarActionPerformed

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
    private javax.swing.JButton btnRefrescarSolicitudes;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTFieldAreaProcesoSolicitante;
    private javax.swing.JTextField jTFieldNombreSolicitante;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTableIngresarItems;
    private javax.swing.JLabel jlbFecha;
    private javax.swing.JLabel labelAdministrador;
    private javax.swing.JLabel lblRestantes;
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
/*
            Vector datos = new Vector();
            datos.add(i.getInventario());
            datos.add(i.getNumero());
            datos.add(i.getDescripcion());
            datos.add(i.getCantidad());
            datos.add(i.getPresentacion());*/
            df.addRow(datos);
        }
    }

}
