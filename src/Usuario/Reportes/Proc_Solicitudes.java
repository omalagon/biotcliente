/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Reportes;

import Usuario.Solicitudes.*;
import EstructurasAux.ItemInventario;
import EstructurasAux.proveedor;
import EstructurasAux.solicitudPr;
import EstructurasAux.users;
import Usuario.Reportes.itemxProveedor;
import Usuario.Reportes.verProveedores;
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
import java.util.HashMap;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Oscar Dario Malagon Murcia
 */
public class Proc_Solicitudes extends javax.swing.JFrame {

    private static String id = null;
    private static String area = new String();
    private ArrayList<ItemInventario> itemsXSolicitud = null;
    private String numSol;
    HashMap<String, String> mapProv = new HashMap<String, String>();

    public Proc_Solicitudes(String id){
        try {
            initComponents();
            Proc_Solicitudes.id = id;
            setIcon();
            this.jta_verObs.setLineWrap(true);
            this.jta_verObs.setEditable(false);
            Usuario u = cliente.Cliente.conectarU();
            String user = new String();
            try {
                users datosUsuario = u.getDatosUsuario(id);
                user = datosUsuario.getNombre();
                area = datosUsuario.getLab();
            } catch (RemoteException ex) {
                Logger.getLogger(Proc_Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
            }
            tablaSolicitudesNoRev.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    BigDecimal aux = new BigDecimal(tablaSolicitudesNoRev.getValueAt(tablaSolicitudesNoRev.getSelectedRow(), 0).toString());
                    Usuario u = cliente.Cliente.conectarU();
                    
                    DefaultTableModel df = (DefaultTableModel) tablaSolicitudesNoRev.getModel();
                    llenarContenidoSol(new BigDecimal(tablaSolicitudesNoRev.getValueAt(tablaSolicitudesNoRev.getSelectedRow(), 0).toString()));
                    try {
                        jta_verObs.setText(u.getSolicitud(Integer.toString(aux.intValue())).getObservaciones());
                        numSol = tablaSolicitudesNoRev.getValueAt(tablaSolicitudesNoRev.getSelectedRow(), 0).toString();
                    } catch (RemoteException ex) {
                        Logger.getLogger(Proc_Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
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
                solNoRev = u.getSolicitudes("NO", id);
            } catch (RemoteException ex) {
                Logger.getLogger(Proc_Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
            }
            GregorianCalendar fecha = new GregorianCalendar();
            for (solicitudPr s : solNoRev) {
                fecha = s.getFecha();
                Object[] datos = new Object[3];
                datos[0] = s.getNum_sol();
                datos[1] = fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
                datos[2] = s.getNombreSolicitante();
                df_NoRevisadas.addRow(datos);
            }
            TableColumn cCalidadCell = this.tablaContenido.getColumnModel().getColumn(7);
            JComboBox<String> Apro_NITProv = new JComboBox<String>();
            ArrayList<proveedor> todosProveedores = u.todosProveedores();
            for (proveedor p : todosProveedores) {
                Apro_NITProv.addItem(p.getNombre());
            mapProv.put(p.getNombre(), p.getNIT());
        }
            cCalidadCell.setCellEditor(new DefaultCellEditor(Apro_NITProv));
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form Proc_Solicitudes
     */
    public Proc_Solicitudes() {
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
        btnrefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_verObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C. Interno", "Inventario", "Descripción", "Cant. Solicitada", "Precio", "Cant. Aprobada", "Aprobar", "Proveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
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
                "Numero de Solicitud", "Fecha", "Responsable Area (Solicitante)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaSolicitudesNoRev);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("Solicitudes no revisadas");

        btnrefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ACT.png"))); // NOI18N
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Refrescar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NO.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Volver");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prov.png"))); // NOI18N
        jButton1.setToolTipText("Muestra los ítems por proveedor y el listado de proveedores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Item x Prov y Prov");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/apro.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Aprobar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnrefrescar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnrefrescar, jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(9, 9, 9)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnrefrescar, jButton1, jButton2});

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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                                    .addComponent(jSeparator1)
                                    .addComponent(jScrollPane1))
                                .addGap(16, 16, 16))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2))
                                .addGap(16, 16, 16)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        itemxProveedor itm = new itemxProveedor();
        itm.setVisible(true);
        verProveedores ver = new verProveedores();
        ver.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            DefaultTableModel df_contenido = (DefaultTableModel) this.tablaContenido.getModel();
            Usuario u = cliente.Cliente.conectarU();
            boolean valido;
            ItemInventario itm;
            ArrayList<ItemInventario> itemsAprobados = new ArrayList<>();
            boolean aprobarItems = false;
            ArrayList<String> arrProv = new ArrayList<>();
            for (int i = 0; i < df_contenido.getRowCount(); i++) {
                valido = (boolean) df_contenido.getValueAt(i, 6);
                if (valido) {
                    itm = this.itemsXSolicitud.get(i);
                    String cadPrecio = df_contenido.getValueAt(i, 4).toString();
                    String cadCantAprobada = df_contenido.getValueAt(i, 5).toString();
                    String cadProveedor = df_contenido.getValueAt(i, 7).toString();
                    String nitProveedor = "";
                    if (!cadPrecio.equalsIgnoreCase("") && !cadCantAprobada.equalsIgnoreCase("")
                            && !cadProveedor.equalsIgnoreCase("")) {
                        float precio = new Float(cadPrecio);
                        float cantAprobada = new Float(cadCantAprobada);
                        itm.setPrecio(precio);
                        itm.setCantidadSolicitada(cantAprobada); //Se cambia por la cantidad aprobada
                        nitProveedor = this.mapProv.get(cadProveedor);
                        arrProv.add(nitProveedor);
                        itemsAprobados.add(itm);
                    }
                }
            }
            
            solicitudPr sol = new solicitudPr(new BigDecimal(numSol), id);
            aprobarItems = u.aprobarItems(itemsAprobados, sol, arrProv);
            
            if (aprobarItems) {
                JOptionPane.showMessageDialog(null, "La solicitud ha sido aprobada");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        Proc_Solicitudes p;
        p = new Proc_Solicitudes(id);
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnrefrescarActionPerformed

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
            java.util.logging.Logger.getLogger(Proc_Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proc_Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proc_Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proc_Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Proc_Solicitudes().setVisible(true);
            }
        });
    }

    private void llenarContenidoSol(BigDecimal numsol) {
        Usuario n = cliente.Cliente.conectarU();
        DefaultTableModel df_contenido = (DefaultTableModel) this.tablaContenido.getModel();

        for (int i = df_contenido.getRowCount() - 1; i >= 0; i--) {
            df_contenido.removeRow(i);
        }

        try {
            itemsXSolicitud = n.getItemsAprobado(numsol, "NO");
        } catch (RemoteException ex) {
            Logger.getLogger(Proc_Solicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
        int j = 0;
        for (ItemInventario i : itemsXSolicitud) {
            Object[] datos = new Object[6];
            datos[0] = i.getNumero();
            datos[1] = i.getInventario();
            datos[2] = i.getDescripcion();
            datos[3] = i.getCantidadSolicitada();
            datos[4] = "";
            datos[5] = i.getCantidadSolicitada();
            df_contenido.addRow(datos);
            df_contenido.setValueAt(false, j, 6);
            j++;
        }
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
