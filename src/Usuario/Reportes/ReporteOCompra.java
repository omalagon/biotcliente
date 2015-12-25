/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Reportes;

import Usuario.OCompra.*;
import EstructurasAux.ItemInventario;
import EstructurasAux.datosFormatos;
import EstructurasAux.itemRecep;
import EstructurasAux.itemsOrdenCompra;
import EstructurasAux.proveedor;
import EstructurasAux.recepcionProd;
import EstructurasAux.users;
import Formatos.fdc002;
import Usuario.Reportes.ReporteSolicitudes;
import interfaces.Usuario;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Usuario.solicitudes.MenuSolicitud;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Oscar Dario Malagon Murcia
 */
public class ReporteOCompra extends javax.swing.JFrame {

    private static String id = null;
    private static String area = new String();
    private ArrayList<ItemInventario> itemsXSolicitud = null;
    private String numSol;
    HashMap<String, String> mapProv = new HashMap();
    ArrayList<ItemInventario> itemAsociados = null;

    public ReporteOCompra(String id) throws RemoteException {
        initComponents();
        ReporteOCompra.id = id;
        setIcon();
        this.lbl_nit.setText("");
        this.lbl_nombre.setText("");
        this.lbl_direccion.setText("");
        this.lbl_tel.setText("");
        this.lbl_fax.setText("");
        this.lbl_cel.setText("");
        this.jta_verObs.setLineWrap(true);
        this.jta_verObs.setEditable(false);

        Usuario u = cliente.Cliente.conectarU();
        String user = new String();
        this.setLocationRelativeTo(null);

        tablaOrdenes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                llenarInfo();
            }
        });
        llenarOrdenes();
    }

    /**
     * Creates new form Proc_Solicitudes
     */
    public ReporteOCompra() {
        initComponents();
        tablaOrdenes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
        tablaOrdenes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnrefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnGenerarFDC001 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_verObs = new javax.swing.JTextArea();
        lblSubtotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_tel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_cel = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_fax = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_nit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num. Sol", "C. Interno", "Descripción", "Cant. Aprobada", "Presentación", "Precio", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaContenido);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Información de los ítems");

        tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Orden"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaOrdenes);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("Reporte Ordenes de Compra");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnrefrescar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerarFDC001, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGenerarFDC001, btnrefrescar, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(btnGenerarFDC001)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGenerarFDC001, btnrefrescar, jButton2});

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Observaciones");

        jta_verObs.setColumns(20);
        jta_verObs.setRows(5);
        jScrollPane2.setViewportView(jta_verObs);

        lblSubtotal.setText("jLabel6");

        jLabel8.setText("Subtotal: $");

        jLabel7.setText("Nombre");

        jLabel9.setText("Dirección");

        jLabel6.setText("NIT");

        lbl_tel.setText("jLabel21");

        jLabel11.setText("Fax");

        lbl_cel.setText("jLabel23");

        lbl_direccion.setText("jLabel20");

        jLabel12.setText("Celular");

        jLabel10.setText("Teléfono");

        lbl_fax.setText("jLabel22");

        lbl_nombre.setText("jLabel19");

        lbl_nit.setText("jLabel18");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Información del Proveedor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tel)
                            .addComponent(lbl_direccion)
                            .addComponent(lbl_cel)
                            .addComponent(lbl_fax)
                            .addComponent(lbl_nombre)
                            .addComponent(lbl_nit))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_nit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbl_direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbl_tel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbl_fax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cel)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jSeparator2))
                                .addGap(16, 16, 16)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtotal)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MenuReportes menu = new MenuReportes(id);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        ReporteOCompra p;
        try {
            p = new ReporteOCompra(id);
            p.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ReporteOCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void btnGenerarFDC001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFDC001ActionPerformed
        try {
            JOptionPane.showMessageDialog(null, "Recopilando información...");
            Usuario u = cliente.Cliente.conectarU();
            datosFormatos datos = u.getDatos("2");
            proveedor datosProveedor = u.getDatosProveedor(this.lbl_nit.getText());
            DefaultTableModel df_items = (DefaultTableModel) this.tablaContenido.getModel();
            ArrayList<itemsOrdenCompra> listaItems = new ArrayList<itemsOrdenCompra>();
            ArrayList<ItemInventario> aAprobar = new ArrayList<>();
            for (int i = 0; i < df_items.getRowCount(); i++) {
                ItemInventario get = this.itemAsociados.get(i);
                aAprobar.add(get);
                itemsOrdenCompra itm = new itemsOrdenCompra( get.getNumero(), get.getInventario(), get.getDescripcion(), get.getCantidadAprobada(),
                        get.getPresentacion(), get.getPrecio(), "", new BigDecimal(0));
                itm.setvTotal(itm.getCaprobada() * itm.getPrecioU());
                listaItems.add(itm);
            }
            String rutaImagen;
            String property = System.getProperty("user.dir");
            rutaImagen = property.concat("\\src\\Imagenes\\iconB.png");
            HashMap<String, String> parametros = new HashMap<>();
            parametros.put("image", rutaImagen);
            parametros.put("fechaElab", u.getFecha());
            parametros.put("oCompra", this.tablaOrdenes.getValueAt(this.tablaOrdenes.getSelectedRow(), 0).toString());
            parametros.put("revision", datos.getRevision());
            parametros.put("fechaact", datos.getFechaActualizacion());
            parametros.put("titulo", datos.getTitulo());
            parametros.put("Obs", this.jta_verObs.getText());
            parametros.put("subtotal", this.lblSubtotal.getText());
            parametros.put("nit", datosProveedor.getNIT());
            parametros.put("nombreProv", datosProveedor.getNombre());
            parametros.put("direccionProv", datosProveedor.getDireccion() + "-" + datosProveedor.getCelular());
            parametros.put("fax", datosProveedor.getTelefax());
            parametros.put("nombreProv", datosProveedor.getNombre());
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showOpenDialog(this);
            String path = chooser.getSelectedFile().getPath();
            File archivo = fdc002.metodo(path, parametros, listaItems);
            if (JOptionPane.showConfirmDialog(null, "¿Desea abrir el archivo?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    Desktop.getDesktop().open(archivo);
                } catch (IOException ex) {
                    Logger.getLogger(ReporteSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(DesaprobarOCompra.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ReporteOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ReporteOCompra().setVisible(true);
            }
        });
    }

    private void llenarInfo() {
        try {
            Usuario u = cliente.Cliente.conectarU();
            String numorden = this.tablaOrdenes.getValueAt(this.tablaOrdenes.getSelectedRow(), 0).toString();
            recepcionProd datosRec = u.getDatosRec2(new BigDecimal(numorden), id);
            this.lbl_nit.setText(datosRec.getP().getNIT());
            this.lbl_nombre.setText(datosRec.getP().getNombre());
            this.lbl_direccion.setText(datosRec.getP().getDireccion());
            this.lbl_tel.setText(datosRec.getP().getTelefono());
            this.lbl_fax.setText(datosRec.getP().getTelefax());
            this.lbl_cel.setText(datosRec.getP().getCelular());

            DefaultTableModel df_items = (DefaultTableModel) this.tablaContenido.getModel();
            for (int i = df_items.getRowCount() - 1; i >= 0; i--) {
                df_items.removeRow(i);
            }
            ArrayList<itemRecep> articulos = datosRec.getArticulos();
            this.itemAsociados= new ArrayList<>();
            float tot = 0;
            int i = 0;
            for (itemRecep articulo : articulos) {
                ItemInventario d = u.buscarInfoItem(articulo.getCinterno());
                Object[] datos = new Object[7];
                datos[0] = d.getInventario();
                datos[1] = d.getNumero();
                datos[2] = d.getDescripcion();
                datos[3] = articulo.getcAprobada();
                datos[4] = d.getPresentacion();
                datos[5] = articulo.getPrecio();
                datos[6] = articulo.getcAprobada() * articulo.getPrecio();
                d.setCantidadAprobada(articulo.getcAprobada());
                d.setPrecio(articulo.getPrecio());
                itemAsociados.add(d);
                df_items.addRow(datos);
                tot += articulo.getcAprobada() * articulo.getPrecio();
                this.lblSubtotal.setText(Float.toString(tot));
            }
            this.jta_verObs.setText(datosRec.getObservaciones());
        } catch (RemoteException ex) {
            Logger.getLogger(ReporteOCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarOrdenes() throws RemoteException {
        Usuario u = cliente.Cliente.conectarU();
        DefaultTableModel dfOrdenes = (DefaultTableModel) this.tablaOrdenes.getModel();
        for (int i = dfOrdenes.getRowCount() - 1; i >= 0; i--) {
            dfOrdenes.removeRow(i);
        }
        ArrayList<Integer> numerosDeOrden = u.numerosDeOrden();
        for (Integer i : numerosDeOrden) {
            Object[] infoItems = new Object[8];
            infoItems[0] = i;
            dfOrdenes.addRow(infoItems);
        }

    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarFDC001;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jta_verObs;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lbl_cel;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_fax;
    private javax.swing.JLabel lbl_nit;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JTable tablaContenido;
    private javax.swing.JTable tablaOrdenes;
    // End of variables declaration//GEN-END:variables

}
