/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsableArea;

import EstructurasAux.ItemInventario;
import EstructurasAux.itemRecep;
import EstructurasAux.recepcionProd;
import com.toedter.calendar.JDateChooserCellEditor;
import gui.RArea;
import interfaces.Usuario;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Recepciones extends javax.swing.JFrame {

    private static BigDecimal id = null;
    private static String area = null;
    private static GregorianCalendar hoy = new GregorianCalendar();
    private static String cadenaFecha = hoy.get(Calendar.DAY_OF_MONTH) + "/" + (hoy.get(Calendar.MONTH) + 1) + "/" + hoy.get(Calendar.YEAR);

    /**
     * Creates new form Recepciones
     */
    public Recepciones() {
        initComponents();
    }

    Recepciones(BigDecimal id, String area) {
        initComponents();
        this.id = id;
        this.area = area;
        TableColumn fecRec = this.tablaDatosPedido.getColumnModel().getColumn(7);
        fecRec.setCellEditor(new JDateChooserCellEditor());
        TableColumn fecVen = this.tablaDatosPedido.getColumnModel().getColumn(10);
        fecVen.setCellEditor(new JDateChooserCellEditor());
        this.jlblrecFecha.setText(cadenaFecha);
        setIcon();
        this.setSize(810, this.getHeight());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelInicioSesion = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jlblrecFecha = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        rec_nomProv = new javax.swing.JLabel();
        rec_nit = new javax.swing.JLabel();
        rec_dir = new javax.swing.JLabel();
        rec_cel = new javax.swing.JLabel();
        rec_fax = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaDatosPedido = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        iva = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        recobs = new javax.swing.JTextArea();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        numorden = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnProcesarRec = new javax.swing.JButton();
        btnEnviarRec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelInicioSesion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelInicioSesion.setText("Recepción de Pedidos");

        jLabel20.setText("Fecha recepción");

        jlblrecFecha.setText("jLabel21");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Datos Proveedor");

        jLabel23.setText("Nombre Proveedor/Prestador del servicio");

        jLabel24.setText("NIT");

        jLabel25.setText("Dirección");

        jLabel26.setText("Celular");

        jLabel27.setText("Telefax");

        tablaDatosPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inv", "Codigo Interno", "Descripción", "Cantidad", "Presentación", "Valor Unitario", "Valor Total", "Fecha Recepción", "Certificado de calidad", "Cump. Espe", "Fecha Vencimiento", "M. Ver. interna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tablaDatosPedido);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Datos Pedido");

        jLabel36.setText("Subtotal");

        subtotal.setText("jLabel37");

        jLabel38.setText("IVA");

        iva.setText("jLabel39");

        jLabel40.setText("Total");

        total.setText("jLabel41");

        jLabel42.setText("Observaciones");

        recobs.setColumns(20);
        recobs.setRows(5);
        jScrollPane10.setViewportView(recobs);

        jLabel21.setText("Numero de Orden");

        jButton4.setText("Ver Anexo 1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnProcesarRec.setText("Ingresar N° Orden");
        btnProcesarRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarRecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator9)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblrecFecha)
                                .addGap(204, 204, 204)
                                .addComponent(btnProcesarRec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(rec_nomProv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numorden))))
                    .addComponent(jLabel35)
                    .addComponent(jLabel23)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(256, 256, 256)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rec_nit)
                            .addComponent(rec_dir)
                            .addComponent(rec_cel)
                            .addComponent(rec_fax)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtotal)
                            .addComponent(total)
                            .addComponent(iva))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jlblrecFecha)
                    .addComponent(jButton4)
                    .addComponent(btnProcesarRec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21))
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(rec_nomProv)
                    .addComponent(numorden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(rec_nit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(rec_dir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(rec_cel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(rec_fax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(subtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(iva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );

        btnEnviarRec.setText("Enviar Revisión");
        btnEnviarRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarRecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelInicioSesion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviarRec)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInicioSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviarRec)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        anexo1 a = new anexo1();
        a.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnProcesarRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarRecActionPerformed
        String area = this.area;
        BigDecimal id = this.id;
        BigDecimal orden = null;
        Usuario u = cliente.Cliente.conectarU();
        DefaultTableModel df = (DefaultTableModel) this.tablaDatosPedido.getModel();
        TableColumn cCalidadCell = this.tablaDatosPedido.getColumnModel().getColumn(8);
        TableColumn cEspe = this.tablaDatosPedido.getColumnModel().getColumn(9);
        JComboBox calidad = new JComboBox();
        calidad.addItem("SI");
        calidad.addItem("NO");

        JComboBox cEspecificaciones = new JComboBox();
        cEspecificaciones.addItem("SI");
        cEspecificaciones.addItem("NO");

        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        JOptionPane j = new JOptionPane();
        String ordenIngresada = j.showInputDialog("Ingrese el número de orden");
        while (!ordenIngresada.matches("^[0-9][0-9]*") || ordenIngresada.equalsIgnoreCase("")) {
            ordenIngresada = j.showInputDialog("Numero de Orden inválido. Ingreselo nuevamente");
            if (j.CANCEL_OPTION == 2) {
                j.setVisible(false);
            }
        }
        orden = new BigDecimal(ordenIngresada);
        try {
            recepcionProd datosRec = u.getDatosRec(orden, id, area);
            if (datosRec != null) {

                this.rec_nomProv.setText(datosRec.getP().getNombre());
                this.rec_nit.setText(datosRec.getP().getNIT());
                this.rec_dir.setText(datosRec.getP().getDireccion());
                this.rec_fax.setText(new Integer(datosRec.getP().getTelefax()).toString());
                this.rec_cel.setText(new Integer(datosRec.getP().getTelefono()).toString());
                this.numorden.setText(ordenIngresada);
                ArrayList<itemRecep> articulos = datosRec.getArticulos();
                for (itemRecep articulo : articulos) {
                    Vector datos = new Vector();
                    ItemInventario datosCompletosItem = u.datosCompletosItem(articulo.getCinterno(), articulo.getLab());
                    datos.add(datosCompletosItem.getInventario());
                    datos.add(datosCompletosItem.getNumero());
                    datos.add(datosCompletosItem.getDescripcion());
                    datos.add(articulo.getcAprobada());
                    datos.add(datosCompletosItem.getPresentacion());
                    datos.add(articulo.getPrecio());
                    datos.add(articulo.getcAprobada() * articulo.getPrecio());
                    df.addRow(datos);
                    this.recobs.setText(articulo.getObs());
                    float tot = 0;
                    tot += articulo.getcAprobada() * articulo.getPrecio();
                    this.total.setText(new Float(tot).toString());
                    this.subtotal.setText(new Float(tot * 0.84).toString());
                    this.iva.setText(new Float(tot * 0.16).toString());
                }
                cCalidadCell.setCellEditor(new DefaultCellEditor(calidad));
                cEspe.setCellEditor(new DefaultCellEditor(cEspecificaciones));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró nada referente al número de orden dado");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Recepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProcesarRecActionPerformed

    private void btnEnviarRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarRecActionPerformed
        DefaultTableModel df = (DefaultTableModel) this.tablaDatosPedido.getModel();
        int[] selectedRows = this.tablaDatosPedido.getSelectedRows();
        String numorden = this.numorden.getText();
        ArrayList<itemRecep> articulos = new ArrayList<>();
        itemRecep ii = null;
        Usuario u = cliente.Cliente.conectarU();
        boolean recibirPedido = false;
        for (int i : selectedRows) {
            ii = new itemRecep(new BigDecimal(df.getValueAt(i, 1).toString()), df.getValueAt(i, 0).toString(), this.recobs.getText(), new Float(df.getValueAt(i, 3).toString()), new Float(df.getValueAt(i, 5).toString()));
            ii.setfLlegada((Date) df.getValueAt(i, 7));
            ii.setcCalidad(df.getValueAt(i, 8).toString());
            ii.setcEsp(df.getValueAt(i, 9).toString());
            ii.setfVencimiento((Date) df.getValueAt(i, 10));
            ii.setmVerificacion(df.getValueAt(i, 11));
            articulos.add(ii);
        }
        try {
            recibirPedido = u.recibirPedido(new BigDecimal(numorden), id, area, articulos);
            if (recibirPedido) {
                JOptionPane.showMessageDialog(null, "Hecho");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RArea.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_btnEnviarRecActionPerformed

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
            java.util.logging.Logger.getLogger(Recepciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recepciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recepciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recepciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recepciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarRec;
    private javax.swing.JButton btnProcesarRec;
    private javax.swing.JLabel iva;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jlblrecFecha;
    private javax.swing.JLabel labelInicioSesion;
    private javax.swing.JLabel numorden;
    private javax.swing.JLabel rec_cel;
    private javax.swing.JLabel rec_dir;
    private javax.swing.JLabel rec_fax;
    private javax.swing.JLabel rec_nit;
    private javax.swing.JLabel rec_nomProv;
    private javax.swing.JTextArea recobs;
    private javax.swing.JLabel subtotal;
    private javax.swing.JTable tablaDatosPedido;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
}