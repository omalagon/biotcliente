/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import EstructurasAux.aprobacion;
import EstructurasAux.cotizaciones;
import EstructurasAux.fdc_001;
import interfaces.Usuario;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RevisarSolicitudes extends javax.swing.JFrame {

    private static BigDecimal id = null;

    /**
     * Creates new form RevisarSolicitudes
     */
    public RevisarSolicitudes() {
        initComponents();
    }

    RevisarSolicitudes(BigDecimal id) {
        initComponents();
        this.id = id;
        this.setExtendedState(MAXIMIZED_BOTH);
        setIcon();
        this.btnRefrescarSolRev.doClick();
        this.btnRefrescarSolNoRev.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlb_titulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaSolicitudesRev = new javax.swing.JTable();
        btnPdf001 = new javax.swing.JButton();
        btnDevolverCot = new javax.swing.JButton();
        btnRefrescarSolRev = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolNoRev = new javax.swing.JTable();
        btnSelectAll = new javax.swing.JButton();
        btnAprobarSel = new javax.swing.JButton();
        btnRefrescarSolNoRev = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jlb_titulo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlb_titulo.setText("Menú de Solicitudes");

        TablaSolicitudesRev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Cotización", "Aux Oficina", "Resp. Área", "Proveedor", "Inv", "Código", "Cant. Solicitada", "Cant. Aprobada", "Precio Unitario", "Num Solicitud"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TablaSolicitudesRev);

        btnPdf001.setText("Generar .pdf");
        btnPdf001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdf001ActionPerformed(evt);
            }
        });

        btnDevolverCot.setText("Devolver a revisión");
        btnDevolverCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverCotActionPerformed(evt);
            }
        });

        btnRefrescarSolRev.setText("Refrescar");
        btnRefrescarSolRev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarSolRevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPdf001)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolverCot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefrescarSolRev)
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescarSolRev)
                    .addComponent(btnDevolverCot)
                    .addComponent(btnPdf001))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Solicitudes Revisadas", jPanel1);

        tblSolNoRev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Cotización", "Aux Oficina", "Resp. Área", "Proveedor", "Inv", "Código", "Cant. Solicitada", "Cant. Aprobada", "Precio Unitario", "Num Solicitud"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSolNoRev);

        btnSelectAll.setText("Seleccionar todas las filas");
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllActionPerformed(evt);
            }
        });

        btnAprobarSel.setText("Aprobar seleccionadas");
        btnAprobarSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarSelActionPerformed(evt);
            }
        });

        btnRefrescarSolNoRev.setText("Refrescar");
        btnRefrescarSolNoRev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarSolNoRevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSelectAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAprobarSel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefrescarSolNoRev)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescarSolNoRev)
                    .addComponent(btnAprobarSel)
                    .addComponent(btnSelectAll))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Solicitudes No Revisadas", jPanel2);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlb_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_titulo)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAprobarSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobarSelActionPerformed
        int[] filasSelec = this.tblSolNoRev.getSelectedRows();
        BigDecimal noCot;
        String lab = "";
        BigDecimal codigoInt;
        float cantAprobada;
        GregorianCalendar fecha = new GregorianCalendar();
        Usuario u = cliente.Cliente.conectarU();
        aprobacion ap = null;
        boolean aprobado = false;
        for (int i : filasSelec) {
            String valor = this.tblSolNoRev.getValueAt(i, 7).toString();
            if (valor.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Hay campos vacios");
            } else {
                noCot = new BigDecimal(this.tblSolNoRev.getValueAt(i, 0).toString());
                lab = this.tblSolNoRev.getValueAt(i, 4).toString();
                codigoInt = new BigDecimal(this.tblSolNoRev.getValueAt(i, 5).toString());
                cantAprobada = new Float(valor);
                ap = new aprobacion(noCot, lab, codigoInt, cantAprobada, fecha, id, 0);

                try {
                    aprobado = u.aprobar(ap, "SI");

                    if (!aprobado) {
                        JOptionPane.showMessageDialog(null, "Error en la aprobacion");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hecho");
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(RevisarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.btnRefrescarSolNoRev.doClick();
        //this.BotonRefrescarSolRev.doClick();
    }//GEN-LAST:event_btnAprobarSelActionPerformed

    private void btnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllActionPerformed
        this.tblSolNoRev.selectAll();
    }//GEN-LAST:event_btnSelectAllActionPerformed

    private void btnRefrescarSolNoRevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarSolNoRevActionPerformed
        DefaultTableModel df = (DefaultTableModel) this.tblSolNoRev.getModel();
        Usuario u = cliente.Cliente.conectarU();
        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        ArrayList<cotizaciones> cotizacione = null;

        try {
            cotizacione = u.getCotizaciones("NO");

            for (cotizaciones c : cotizacione) {
                Vector datos = new Vector();
                datos.add(c.getCotizacionId());
                datos.add(c.getAO());
                datos.add(c.getRA());
                datos.add(c.getProveedor());
                datos.add(c.getLab());
                datos.add(c.getCinterno());
                datos.add(c.getCantSol());
                datos.add("");
                datos.add(c.getPrecioUnitario());
                datos.add(c.getNumSol());
                df.addRow(datos);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RevisarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefrescarSolNoRevActionPerformed

    private void btnPdf001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdf001ActionPerformed
        Usuario u = cliente.Cliente.conectarU();
        int selectedRows = this.TablaSolicitudesRev.getSelectedRow();
        BigDecimal numCot = new BigDecimal(this.TablaSolicitudesRev.getValueAt(selectedRows, 0).toString());
        BigDecimal numSOl = new BigDecimal(this.TablaSolicitudesRev.getValueAt(selectedRows, 9).toString());
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(this);
        String path = chooser.getSelectedFile().getPath();
        try {
            fdc_001 datosGenerales = u.datosGenerales(numSOl, numCot);
            File pdf_001 = u.pdf_001(path, datosGenerales);
            if (JOptionPane.showConfirmDialog(null, "¿Desea abrir el archivo?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().open(pdf_001);
            }
        } catch (IOException ex) {
            Logger.getLogger(RevisarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPdf001ActionPerformed

    private void btnDevolverCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverCotActionPerformed
        int[] filasSelec = this.TablaSolicitudesRev.getSelectedRows();
        BigDecimal noCot;
        String lab = "";
        BigDecimal codigoInt;
        GregorianCalendar fecha = new GregorianCalendar();
        Usuario u = cliente.Cliente.conectarU();
        aprobacion ap = null;
        boolean aprobado = false;
        for (int i : filasSelec) {
            noCot = new BigDecimal(this.TablaSolicitudesRev.getValueAt(i, 0).toString());
            lab = this.TablaSolicitudesRev.getValueAt(i, 4).toString();
            codigoInt = new BigDecimal(this.TablaSolicitudesRev.getValueAt(i, 5).toString());
            ap = new aprobacion(noCot, lab, codigoInt, -1, fecha, id, 0);
            try {
                aprobado = u.eliminarAprobacion(ap);
                if (!aprobado) {
                    JOptionPane.showMessageDialog(null, "Error en la aprobacion");
                } else {
                    JOptionPane.showMessageDialog(null, "Hecho");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(RevisarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnDevolverCotActionPerformed

    private void btnRefrescarSolRevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarSolRevActionPerformed
        DefaultTableModel df = (DefaultTableModel) this.TablaSolicitudesRev.getModel();
        Usuario u = cliente.Cliente.conectarU();
        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        ArrayList<cotizaciones> cotizacione = null;
        try {
            cotizacione = u.getCotizaciones("SI");
            for (cotizaciones c : cotizacione) {
                Vector datos = new Vector();
                datos.add(c.getCotizacionId());
                datos.add(c.getAO());
                datos.add(c.getRA());
                datos.add(c.getProveedor());
                datos.add(c.getLab());
                datos.add(c.getCinterno());
                datos.add(c.getCantSol());
                datos.add(new Float(u.getCantAprobada(c).toString()));
                datos.add(c.getPrecioUnitario());
                datos.add(c.getNumSol());
                df.addRow(datos);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RevisarSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefrescarSolRevActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaInicio_Adm vent = new VentanaInicio_Adm(this.id.toString());
        vent.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RevisarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RevisarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RevisarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RevisarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevisarSolicitudes().setVisible(true);
            }
        });
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaSolicitudesRev;
    private javax.swing.JButton btnAprobarSel;
    private javax.swing.JButton btnDevolverCot;
    private javax.swing.JButton btnPdf001;
    private javax.swing.JButton btnRefrescarSolNoRev;
    private javax.swing.JButton btnRefrescarSolRev;
    private javax.swing.JButton btnSelectAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlb_titulo;
    private javax.swing.JTable tblSolNoRev;
    // End of variables declaration//GEN-END:variables
}
