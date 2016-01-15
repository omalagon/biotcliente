/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Reportes;

import Formatos.fdc001;
import Usuario.MenuPrincipal;
import interfaces.Usuario;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logica.DatosFormatos;
import logica.ItemInventario;
import logica.SolicitudPr;
import logica.Users;
import net.sf.jasperreports.engine.JREmptyDataSource;

/**
 *
 * @author Oscar Dario Malagon Murcia
 */
public class ReporteSolicitudes extends javax.swing.JFrame {

    private static String id;
    private ArrayList<Object[]> items = new ArrayList<>();

    /**
     * Creates new form ReporteSolicitudes
     */
    public ReporteSolicitudes() {
        initComponents();
    }

    public ReporteSolicitudes(String id) {
        initComponents();
        this.id = id;
        this.setLocationRelativeTo(null);
        this.btnRefrescar.doClick();
        setIcon();
        tabla_sol.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                BigDecimal aux = new BigDecimal(tabla_sol.getValueAt(tabla_sol.getSelectedRow(), 0).toString());
                System.out.println(aux);
                DefaultTableModel df = (DefaultTableModel) tablaItems.getModel();
                for (int i = df.getRowCount() - 1; i >= 0; i--) {
                    df.removeRow(i);
                }

                for (int i = items.size() - 1; i >= 0; i--) {
                    items.remove(i);

                }

                System.out.println("entra");
                ArrayList<ItemInventario> items_numSol = (ArrayList<ItemInventario>) getItemsNumSol(aux);
                for (ItemInventario i : items_numSol) {
                    Object[] datos = new Object[6];
                    datos[0] = i.getCantidad();
                    datos[1] = i.getNumero();
                    datos[2] = i.getDescripcion();
                    datos[3] = i.getCantidadSolicitada();
                    datos[4] = i.getInventario();
                    datos[5] = i.getPrecio();
                    items.add(datos);
                    df.addRow(datos);
                    
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

        jlb_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_sol = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaItems = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlb_titulo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlb_titulo.setText("Listado de Solicitudes");

        tabla_sol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Sol", "Fecha", "Id Solicitante", "Nombre Sol.", "Observaciones"
            }
        ));
        jScrollPane1.setViewportView(tabla_sol);

        tablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inv. ACtual", "Cinterno", "Descripción", "Cant. Sol", "Lab", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tablaItems);
        if (tablaItems.getColumnModel().getColumnCount() > 0) {
            tablaItems.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pdf.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Volver");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NO.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Generar .pdf");

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ACT.png"))); // NOI18N
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Refrescar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRefrescar, btnVolver});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRefrescar, btnVolver});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlb_titulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlb_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal menu = new MenuPrincipal(id);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fdc001 fdc = new fdc001();
        String numSol = tabla_sol.getValueAt(tabla_sol.getSelectedRow(), 0).toString();
        String fecha = tabla_sol.getValueAt(tabla_sol.getSelectedRow(), 1).toString();
        String solicitante = tabla_sol.getValueAt(tabla_sol.getSelectedRow(), 3).toString();
        String observaciones = tabla_sol.getValueAt(tabla_sol.getSelectedRow(), 4).toString();
        String area = null;
        String nombreAo = null;
        JOptionPane.showMessageDialog(null, "Obteniendo información de la solicitud", "Solicitud",JOptionPane.INFORMATION_MESSAGE);
        DatosFormatos datos= null;        
        area = getDatosUsuario((String) tabla_sol.getValueAt(tabla_sol.getSelectedRow(), 2)).getLab();
        nombreAo = getUsuario(id);
        datos= getDatos("1");
        String rutaImagen;
        String property = System.getProperty("user.dir");
        System.out.println(property);
        rutaImagen = property.concat("\\src\\Imagenes\\iconB.png");

        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("cargo", area);
        parametros.put("fechaAct", datos.getFechaActualizacion());
        parametros.put("titulo", datos.getTitulo());
        parametros.put("image", rutaImagen);
        parametros.put("numsol", numSol);
        parametros.put("fecha", fecha);
        parametros.put("area", area);
        parametros.put("nombreRA", solicitante);
        parametros.put("observaciones", observaciones);
        parametros.put("nombreAO", nombreAo);
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(this);
        String path = chooser.getSelectedFile().getPath();
        File archivo = fdc001.metodo(path, parametros, items);
        if (JOptionPane.showConfirmDialog(null, "¿Desea abrir el archivo?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                Desktop.getDesktop().open(archivo);
            } catch (IOException ex) {
                Logger.getLogger(ReporteSolicitudes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        ArrayList<SolicitudPr> sol = new ArrayList<>();
        sol = (ArrayList<SolicitudPr>) numsSol();
        DefaultTableModel df = (DefaultTableModel) this.tabla_sol.getModel();
        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        for (SolicitudPr s : sol) {
            Object[] datos = new Object[5];
            datos[0] = s.getNumSol();
            datos[1] = new Date(s.getFecha().toGregorianCalendar().getTimeInMillis());
            datos[2] = s.getIdSolicitante();
            datos[3] = s.getNombreSolicitante();
            datos[4] = s.getObservaciones();
            df.addRow(datos);
        }
    }//GEN-LAST:event_btnRefrescarActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteSolicitudes().setVisible(true);
            }
        });
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlb_titulo;
    private javax.swing.JTable tablaItems;
    private javax.swing.JTable tabla_sol;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<logica.ItemInventario> getItemsNumSol(java.math.BigDecimal numSol) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.getItemsNumSol(numSol);
    }

    private static Users getDatosUsuario(java.lang.String id) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.getDatosUsuario(id);
    }

    private static String getUsuario(java.lang.String id) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.getUsuario(id);
    }

    private static DatosFormatos getDatos(java.lang.String id) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.getDatos(id);
    }

    private static java.util.List<logica.SolicitudPr> numsSol() {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.numsSol();
    }
}
