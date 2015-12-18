/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Reportes;

import EstructurasAux.ItemInventario;
import interfaces.Usuario;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ReporteInventario extends javax.swing.JFrame {

    private static String id = null;

    /**
     * Creates new form ReporteInventario
     */
    public ReporteInventario() {
        initComponents();
    }

    ReporteInventario(String id) {
        initComponents();
        ReporteInventario.id = id;
        setIcon();
        this.setLocationRelativeTo(null);
        this.setSize(654, this.getHeight());
        this.btnRefrescar.doClick();

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
        jPanel12 = new javax.swing.JPanel();
        btnRefrescar = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jlb_titulo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlb_titulo.setText("Inventario");

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ACT.png"))); // NOI18N
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel.png"))); // NOI18N
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NO.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Refrescar");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Generar .xls");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Volver");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnRefrescar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnInventario, btnRefrescar, btnVolver});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnInventario, btnRefrescar, btnVolver});

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Descripción:");

        jLabel40.setText("Ésta función permite generar un archivo .xls con el inventario actual de la empresa");

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripción", "Presentación", "Cantidad", "Precio", "Cert. Calidad", "Cumpl Especificaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaInventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb_titulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)))
                        .addGap(0, 446, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlb_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        DefaultTableModel df = (DefaultTableModel) this.tablaInventario.getModel();
        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        Usuario ad = cliente.Cliente.conectarU();
        ArrayList<ItemInventario> itemInventario = null;
        try {
            itemInventario = ad.itemInventarioAdmin();
        } catch (RemoteException ex) {
            Logger.getLogger(ReporteInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ItemInventario i : itemInventario) {
            Object[] aux = new Object[7];
            aux[0] = i.getNumero();
            aux[1] = i.getDescripcion();
            aux[2] = i.getPresentacion();
            aux[3] = i.getCantidad();
            aux[4] = i.getPrecio();
            aux[5] = i.getcCalidad();
            aux[6] = i.getCEsp();
            df.addRow(aux);
        }
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        Usuario u = cliente.Cliente.conectarU();
        try {
            File xls;
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showOpenDialog(this);
            String path = chooser.getSelectedFile().getPath();
            if (JOptionPane.showConfirmDialog(null, "Hay " + this.tablaInventario.getRowCount() + " registros. Generar el archivo puede tardar aproximadamente 3 minutos por cada 1000 registros"
                + "¿Desea Continuar?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            xls = this.imprimirInventario(path);

            if (JOptionPane.showConfirmDialog(null, "¿Desea abrir el archivo?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().open(xls);
            }
        }

        } catch (RemoteException ex) {
            Logger.getLogger(verProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(verProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuReportes rep = new MenuReportes(ReporteInventario.id);
        rep.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReporteInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_titulo;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
    
     File imprimirInventario(String ruta) throws RemoteException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        java.util.Date date = new java.util.Date();

        File xls = new File(ruta + "\\Inventario" + dateFormat.format(date) + ".xls");
        if (!xls.exists()) {
            try {
                xls.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Workbook libro = new HSSFWorkbook();
        FileOutputStream archivo;
        Sheet hoja;
        ArrayList<ItemInventario> todos;
        try {
            archivo = new FileOutputStream(xls);
            hoja = libro.createSheet("Inventario");
            Usuario u= cliente.Cliente.conectarU();
            todos = u.itemInventarioAdmin();
            int i = 0;

            for (int j = 0; j < 8; j++) {
                Row fila = hoja.createRow(i);
                Cell aux;
                if (i == 0) {

                    aux = fila.createCell(j);
                    aux.setCellValue("Código");
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue("Descripción");
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue("Presentación");
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue("Cantidad");
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue("Precio");
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue("Cert. Calidad");
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue("Cump. Especificaciones");
                    j++;
                    i++;
                }
            }

            for (ItemInventario t : todos) {
                Row fila = hoja.createRow(i);
                Cell aux;
                for (int j = 0; j < 8; j++) {
                    aux = fila.createCell(j);
                    aux.setCellValue(t.getNumero());
                    hoja.autoSizeColumn(j);
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue(t.getDescripcion());
                    hoja.autoSizeColumn(j);
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue(t.getPresentacion());
                    hoja.autoSizeColumn(j);
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue(t.getCantidad());
                    hoja.autoSizeColumn(j);
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue(t.getPrecio());
                    hoja.autoSizeColumn(j);
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue(t.getcCalidad());
                    hoja.autoSizeColumn(j);
                    j++;
                    aux = fila.createCell(j);
                    aux.setCellValue(t.getCEsp());
                    hoja.autoSizeColumn(j);
                    j++;
                }
                i++;
            }

            libro.write(archivo);
            archivo.close();

        } catch (IOException ex) {
            System.out.println("Error funcion\"Imprimir Inventario\"");
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return xls;
    }
}