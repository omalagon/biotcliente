/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.OCompra;

import EstructurasAux.ItemInventario;
import EstructurasAux.datosFormatos;
import EstructurasAux.itemsOrdenCompra;
import EstructurasAux.proveedor;
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
public class AprobarOCompra extends javax.swing.JFrame {

    private static String id = null;
    private static String area = new String();
    private ArrayList<ItemInventario> itemsXSolicitud = null;
    private String numSol;
    HashMap<String, String> mapProv = new HashMap();
    ArrayList<ItemInventario> itemAsociados = null;

    public AprobarOCompra(String id) throws RemoteException {
        initComponents();
        AprobarOCompra.id = id;
        setIcon();
        this.jta_verObs.setLineWrap(true);
        Usuario u = cliente.Cliente.conectarU();
        String user = new String();
        this.setLocationRelativeTo(null);
        try {
            users datosUsuario = u.getDatosUsuario(id);
            user = datosUsuario.getNombre();
            area = datosUsuario.getLab();
        } catch (RemoteException ex) {
            Logger.getLogger(AprobarOCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablaProveedor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                llenarTablaItems();
            }

        });

        tablaContenido.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                float precio = new Float(tablaContenido.getValueAt(tablaContenido.getSelectedRow(), 6).toString());
                float sub = new Float(lblSubtotal.getText());
                if ((boolean) tablaContenido.getValueAt(tablaContenido.getSelectedRow(), 7) == true) {

                    sub += precio;
                    lblSubtotal.setText(Float.toString(sub));
                } else {
                    sub -= precio;
                    lblSubtotal.setText(Float.toString(sub));
                }
            }

            @Override
            public void editingCanceled(ChangeEvent e) {

            }
        });

        this.jta_verObs.getDocument().addDocumentListener(new DocumentListener() {
            int length = jta_verObs.getText().length();

            @Override
            public void insertUpdate(DocumentEvent e) {
                length = jta_verObs.getText().length();
                lblRestantes.setText(Integer.toString((534 - length)));
                String maximo = "";
                if (new Integer(lblRestantes.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, ""
                            + "<html>"
                            + "<body>"
                            + "En el documento solo aparecerán los primeros 534 caracteres"
                            + "</body>"
                            + "</html>");
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                length = jta_verObs.getText().length();
                lblRestantes.setText(Integer.toString((543 - length)));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        llenarTablaProveedores();

    }

    /**
     * Creates new form Proc_Solicitudes
     */
    public AprobarOCompra() {
        initComponents();
        tablaProveedor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
        tablaProveedor = new javax.swing.JTable();
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
        lblRestantes = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num. Sol", "C. Interno", "Descripción", "Cant. Aprobada", "Presentación", "Precio", "Valor Total", "Generar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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
        jLabel4.setText("Información de los ítems");

        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIT", "Nombre", "Dirección", "Celular", "Teléfono", "Fax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaProveedor);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("Orden de Compra");

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

        lblRestantes.setText("534");

        jLabel13.setText("Caracteres restantes:");

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
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator2)
                                .addGap(16, 16, 16))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRestantes)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRestantes)
                    .addComponent(jLabel13))
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MenuSolicitud menu = new MenuSolicitud(id);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        AprobarOCompra p;
        try {
            p = new AprobarOCompra(id);
            p.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(AprobarOCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void btnGenerarFDC001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFDC001ActionPerformed
        try {
            JOptionPane.showMessageDialog(null, "Los ítem seleccionados se marcarán como generados. Recopilando información...");
            Usuario u = cliente.Cliente.conectarU();
            datosFormatos datos = u.getDatos("2");
            proveedor datosProveedor = u.getDatosProveedor(tablaProveedor.getValueAt(tablaProveedor.getSelectedRow(), 0).toString());
            DefaultTableModel df_items = (DefaultTableModel) this.tablaContenido.getModel();
            ArrayList<itemsOrdenCompra> listaItems = new ArrayList<itemsOrdenCompra>();
            ArrayList<ItemInventario> aAprobar = new ArrayList<>();
            boolean valido = false;
            for (int i = 0; i < df_items.getRowCount(); i++) {
                valido = (boolean) df_items.getValueAt(i, 7);
                if (valido) {
                    ItemInventario get = this.itemAsociados.get(i);
                    get.setNumSolAsociado(df_items.getValueAt(i, 0).toString());
                    aAprobar.add(get);
                    itemsOrdenCompra itm = new itemsOrdenCompra(df_items.getValueAt(i, 0).toString(),get.getNumero(), get.getInventario(), get.getDescripcion(), get.getCantidadAprobada(),
                            get.getPresentacion(), get.getPrecio(), "", new BigDecimal(0));
                    itm.setvTotal(itm.getCaprobada() * itm.getPrecioU());
                    listaItems.add(itm);
                }
            }
            Double numOrden = u.generarOCompra(aAprobar, id);
            String rutaImagen;
            String property = System.getProperty("user.dir");
            rutaImagen = property.concat("\\src\\Imagenes\\iconB.png");
            HashMap<String, String> parametros = new HashMap<>();
            parametros.put("image", rutaImagen);
            parametros.put("fechaElab", u.getFecha());
            parametros.put("oCompra", Integer.toString(numOrden.intValue()));
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
            java.util.logging.Logger.getLogger(AprobarOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AprobarOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AprobarOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AprobarOCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AprobarOCompra().setVisible(true);
            }
        });
    }

    private void llenarTablaProveedores() {
        Usuario u = cliente.Cliente.conectarU();
        DefaultTableModel df_proveedores = (DefaultTableModel) this.tablaProveedor.getModel();
        for (int i = df_proveedores.getRowCount() - 1; i >= 0; i--) {
            df_proveedores.removeRow(i);
        }
        ArrayList<proveedor> listaProveedores = null;
        try {
            listaProveedores = u.getProveedoresConSolicitudes("NO");
        } catch (RemoteException ex) {
            Logger.getLogger(AprobarOCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        GregorianCalendar fecha = new GregorianCalendar();
        if (listaProveedores != null) {
            for (proveedor s : listaProveedores) {
                Object[] datos = new Object[6];
                datos[0] = s.getNIT();
                datos[1] = s.getNombre();
                datos[2] = s.getDireccion();
                datos[3] = s.getCelular();
                datos[4] = s.getTelefono();
                datos[5] = s.getTelefax();
                df_proveedores.addRow(datos);

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay ordenes de compra por revisar");
        }
    }

    private void llenarTablaItems() {
        Usuario u = cliente.Cliente.conectarU();
        DefaultTableModel df_items = (DefaultTableModel) this.tablaContenido.getModel();

        for (int i = df_items.getRowCount() - 1; i >= 0; i--) {
            df_items.removeRow(i);
        }

        try {
            itemAsociados = u.getItemxProveedorSolicitudes(tablaProveedor.getValueAt(tablaProveedor.getSelectedRow(), 0).toString(), "NO");
        } catch (RemoteException ex) {
            Logger.getLogger(AprobarOCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Info items
        int j = 0;
        float subtotal = 0;
        if (itemAsociados != null) {
            for (ItemInventario i : itemAsociados) {
                Object[] infoItems = new Object[8];
                infoItems[0] = i.getNumSolAsociado();
                infoItems[1] = i.getNumero();
                infoItems[2] = i.getDescripcion();
                infoItems[3] = i.getCantidadAprobada();
                infoItems[4] = i.getPresentacion();
                infoItems[5] = i.getPrecio();
                infoItems[6] = i.getPrecio() * i.getCantidadAprobada();
                subtotal += i.getPrecio() * i.getCantidadAprobada();
                df_items.addRow(infoItems);
                df_items.setValueAt(true, j, 7);
                j++;
            }
        }
        this.lblSubtotal.setText(Float.toString(subtotal));

    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarFDC001;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jta_verObs;
    private javax.swing.JLabel lblRestantes;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JTable tablaContenido;
    private javax.swing.JTable tablaProveedor;
    // End of variables declaration//GEN-END:variables
}
