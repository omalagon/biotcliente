/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Reportes;

import Usuario.Solicitudes.*;
import EstructurasAux.ItemInventario;
import EstructurasAux.datosFormatos;
import EstructurasAux.itemxproveedor;
import EstructurasAux.proveedor;
import EstructurasAux.solicitudPr;
import EstructurasAux.users;
import Formatos.fdc001;
import Usuario.Reportes.ReporteSolicitudes;
import Usuario.Utils.BtnEditorOcultar;
import Usuario.Utils.ButtonRenderer;
import Usuario.Utils.EnumAcciones;
import Usuario.Utils.InputDialogCBox;
import interfaces.Usuario;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Usuario.solicitudes.MenuSolicitud;
import cliente.Cliente;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Oscar Dario Malagon Murcia
 */
public class Proc_SolicitudesRevisadas extends javax.swing.JFrame {

    private static String id = null;
    private static String area = new String();
    private ArrayList<ItemInventario> itemsXSolicitud = null;
    private String numSol;
    HashMap<String, String> mapProv = new HashMap<String, String>();
    EnumAcciones acciones;
    
    public Proc_SolicitudesRevisadas(String id) throws RemoteException {
        initComponents();
        Proc_SolicitudesRevisadas.id = id;
        setIcon();
        this.jta_verObs.setLineWrap(true);
        Usuario u = cliente.Cliente.conectarU();
        String user = new String();
        try {
            users datosUsuario = u.getDatosUsuario(id);
            user = datosUsuario.getNombre();
            area = datosUsuario.getLab();
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablaSolicitudesNoRev.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                BigDecimal aux = new BigDecimal(tablaSolicitudesNoRev.getValueAt(tablaSolicitudesNoRev.getSelectedRow(), 0).toString());
                Usuario u = cliente.Cliente.conectarU();

                DefaultTableModel df = (DefaultTableModel) tablaSolicitudesNoRev.getModel();
                try {
                    llenarContenidoSol(new BigDecimal(tablaSolicitudesNoRev.getValueAt(tablaSolicitudesNoRev.getSelectedRow(), 0).toString()));

                    jta_verObs.setText(u.getSolicitud(Integer.toString(aux.intValue())).getObservaciones());
                    numSol = tablaSolicitudesNoRev.getValueAt(tablaSolicitudesNoRev.getSelectedRow(), 0).toString();
                } catch (RemoteException ex) {
                    Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        this.setLocationRelativeTo(null);
        DefaultTableModel df_NoRevisadas = (DefaultTableModel) this.tablaSolicitudesNoRev.getModel();
        for (int i = df_NoRevisadas.getRowCount() - 1; i >= 0; i--) {
            df_NoRevisadas.removeRow(i);
        }

        ArrayList<solicitudPr> solNoRev = null;
        try {
            solNoRev = u.getSolicitudes("", id);
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        GregorianCalendar fecha = new GregorianCalendar();
        for (solicitudPr s : solNoRev) {
            fecha = s.getFecha();
            Object[] datos = new Object[4];
            datos[0] = s.getNum_sol();
            datos[1] = fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
            datos[2] = s.getNombreSolicitante();
            datos[3] = "Ocultar"+s.getNum_sol();
            df_NoRevisadas.addRow(datos);
        }
        ArrayList<proveedor> todosProveedores = u.todosProveedores();
        for (proveedor p : todosProveedores) {
            mapProv.put(p.getNombre(), p.getNIT());
        }
        this.tablaSolicitudesNoRev.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        this.tablaSolicitudesNoRev.getColumnModel().getColumn(3).setCellEditor(new BtnEditorOcultar(new JTextField(),acciones.OCULTAR, id, "", "SolicitudRev" ));
        
    }

    /**
     * Creates new form Proc_Solicitudes
     */
    public Proc_SolicitudesRevisadas() {
        initComponents();
        tablaSolicitudesNoRev.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                System.out.println("escucha");

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaContenido = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaSolicitudesNoRev = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnrefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGenerarFDC001 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_verObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C. Interno", "Inventario", "Descripción", "Cant. Solicitada", "Precio", "Cant. Aprobada", "Desaprobar", "Proveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaContenido);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Contenido de la Solicitud");

        tablaSolicitudesNoRev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Solicitud", "Fecha", "Responsable Area (Solicitante)", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaSolicitudesNoRev);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("Solicitudes revisadas");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NO.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Volver");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/apro.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Desaprobar");

        btnrefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ACT.png"))); // NOI18N
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Refrescar");

        btnGenerarFDC001.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/L_reportes.png"))); // NOI18N
        btnGenerarFDC001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFDC001ActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Generar Archivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnGenerarFDC001, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGenerarFDC001, btnrefrescar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarFDC001)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnrefrescar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGenerarFDC001, btnrefrescar});

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Observaciones");

        jta_verObs.setColumns(20);
        jta_verObs.setRows(5);
        jScrollPane2.setViewportView(jta_verObs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                                    .addComponent(jSeparator1)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2))
                                .addGap(16, 16, 16)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MenuSolicitud menu = new MenuSolicitud(id);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            DefaultTableModel df_contenido = (DefaultTableModel) this.tablaContenido.getModel();
            Usuario u = cliente.Cliente.conectarU();
            boolean valido;
            ItemInventario itm;
            ArrayList<ItemInventario> itemsAprobados = new ArrayList<>();

            boolean desaprobarItems = false;
            ArrayList<String> arrProv = new ArrayList<>();
            for (int i = 0; i < df_contenido.getRowCount(); i++) {
                valido = (boolean) df_contenido.getValueAt(i, 6);
                if (valido) {

                    itm = this.itemsXSolicitud.get(i);
                    String cadCantAprobada = df_contenido.getValueAt(i, 5).toString();
                    String cadProveedor = df_contenido.getValueAt(i, 7).toString();
                    String nitProveedor = "";
                    if (!cadCantAprobada.equalsIgnoreCase("")
                            && !cadProveedor.equalsIgnoreCase("")) {
                        float cantAprobada = new Float(cadCantAprobada);
                        itm.setPrecio(0);
                        itm.setCantidadSolicitada(cantAprobada); //Se cambia por la cantidad aprobada
                        nitProveedor = this.mapProv.get(cadProveedor);
                        arrProv.add(nitProveedor);
                        itemsAprobados.add(itm);
                    }
                }

            }

                    solicitudPr sol = new solicitudPr(new BigDecimal(numSol), id);
                    desaprobarItems = u.desaprobarItems(itemsAprobados, sol, arrProv);
            if (desaprobarItems) {
                JOptionPane.showMessageDialog(null, "Los ítems han sido devueltos a aprobación");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        Proc_SolicitudesRevisadas p;
        try {
            p = new Proc_SolicitudesRevisadas(id);
            p.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void btnGenerarFDC001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFDC001ActionPerformed

        try {
            Usuario u = Cliente.conectarU();
            DefaultTableModel dfTablaSol = (DefaultTableModel) this.tablaSolicitudesNoRev.getModel();
            DefaultTableModel df_contenido = (DefaultTableModel) this.tablaContenido.getModel();
            String numSol = dfTablaSol.getValueAt(tablaSolicitudesNoRev.getSelectedRow(), 0).toString();
            if (numSol != null) {
                solicitudPr solicitud = u.getSolicitud(numSol);
                JOptionPane.showMessageDialog(null, "Obteniendo información de la solicitud", "Solicitud", JOptionPane.INFORMATION_MESSAGE);
                ArrayList<ItemInventario> items_numSol = u.getItemsAprobado(new BigDecimal(numSol), "SI");
                users datosSolicitante = u.getDatosUsuario(solicitud.getIdSolicitante());
                users datosAO = u.getDatosUsuario(id);
                fdc001 fdc = new fdc001();
                datosFormatos datos = u.getDatos("1");
                String rutaImagen;
                String property = System.getProperty("user.dir");
                System.out.println(property);
                rutaImagen = property.concat("\\src\\Imagenes\\iconB.png");
                HashMap<String, String> parametros = new HashMap<>();
                parametros.put("revision", datos.getRevision());
                parametros.put("cargo", datosSolicitante.getLab());
                parametros.put("fechaAct", datos.getFechaActualizacion());
                parametros.put("titulo", datos.getTitulo());
                parametros.put("image", rutaImagen);
                parametros.put("numsol", numSol);
                parametros.put("fecha", new java.util.Date(solicitud.getFecha().getTimeInMillis()).toString());
                parametros.put("area", datosSolicitante.getLab());
                parametros.put("nombreRA", datosSolicitante.getNombre());
                parametros.put("observaciones", this.jta_verObs.getText());
                parametros.put("nombreAO", datosAO.getNombre());
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.showOpenDialog(this);
                String path = chooser.getSelectedFile().getPath();
                ArrayList<String> proveedores = new ArrayList<>();
                ArrayList<String> cantAprobada = new ArrayList<>();
                for (int i = 0; i < df_contenido.getRowCount(); i++) {
                    proveedores.add(df_contenido.getValueAt(i, 7).toString());
                    cantAprobada.add(df_contenido.getValueAt(i, 5).toString());
                }

                File archivo = fdc001.metodo(path, parametros, ItemInventario.toObjectArray(items_numSol, proveedores, cantAprobada));
                if (JOptionPane.showConfirmDialog(null, "¿Desea abrir el archivo?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(archivo);
                    } catch (IOException ex) {
                        Logger.getLogger(ReporteSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarFDC001ActionPerformed

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
            java.util.logging.Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Proc_SolicitudesRevisadas().setVisible(true);
            }
        });
    }

    private void llenarContenidoSol(BigDecimal numsol) throws RemoteException {
        Usuario n = cliente.Cliente.conectarU();
        DefaultTableModel df_contenido = (DefaultTableModel) this.tablaContenido.getModel();

        for (int i = df_contenido.getRowCount() - 1; i >= 0; i--) {
            df_contenido.removeRow(i);
        }

        try {
            itemsXSolicitud = n.getItemsAprobado(numsol, "SI");
            if (!itemsXSolicitud.isEmpty()) {
                int j = 0;
                for (ItemInventario i : itemsXSolicitud) {
                    Object[] datos = new Object[8];
                    datos[0] = i.getNumero();
                    datos[1] = i.getInventario();
                    datos[2] = i.getDescripcion();
                    datos[3] = i.getCantidadSolicitada();
                    datos[4] = i.getPrecio();
                    datos[5] = n.getCantAprobada(numsol.toString(), i.getNumero());
                    datos[7] = n.getProveedorAsociado(new itemxproveedor("", i.getPrecio(), i.getNumero())).get(0).getNombre();
                    df_contenido.addRow(datos);
                    df_contenido.setValueAt(false, j, 6);
                    j++;
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_SolicitudesRevisadas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarFDC001;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jta_verObs;
    private javax.swing.JTable tablaContenido;
    private javax.swing.JTable tablaSolicitudesNoRev;
    // End of variables declaration//GEN-END:variables
}
