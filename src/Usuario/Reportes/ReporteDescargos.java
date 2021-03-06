/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Reportes;

import EstructurasAux.BuscarUsuario;
import EstructurasAux.informeDescargos;
import interfaces.Usuario;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ReporteDescargos extends javax.swing.JFrame {

    private static String id = null;
    private static BigDecimal busqueda = null;
    private JList<String> list;
    /**
     * Creates new form ReporteDescargos
     */
    public ReporteDescargos() {
        initComponents();
    }

    public ReporteDescargos(String id) {
        initComponents();
        ReporteDescargos.id = id;
        this.setLocationRelativeTo(null);
        this.setSize(753, this.getHeight());
        setIcon();
    }

    public ReporteDescargos(String id, BigDecimal busqueda) {
        initComponents();
        ReporteDescargos.id = id;
        ReporteDescargos.busqueda = busqueda;
        this.setLocation(600, 200);
        this.setSize(753, this.getHeight());
        setIcon();
        Usuario u = cliente.Cliente.conectarU();
        String cabecera[] = {"Código", "Descripción", "Inventario Actual", "Gastado", "Fecha"};
        ArrayList<informeDescargos> Informe;
        DefaultTableModel df = (DefaultTableModel) this.tablaInformes.getModel();
        df.setColumnIdentifiers(cabecera);
        this.tablaInformes.setModel(df);
        for (int i = df.getRowCount() - 1; i >= 0; i--) {
            df.removeRow(i);
        }
        try {
            ArrayList<BuscarUsuario> buscarEmpleado = u.buscarEmpleado("id", busqueda.toString());
            BuscarUsuario b = buscarEmpleado.get(0);
            Informe = u.generarInformePorRA(b.getLab(), busqueda);
            for (informeDescargos i : Informe) {
                Object[] datos = new Object[5];
                datos[0] = i.getCinterno();
                datos[1] = i.getDescripcion();
                datos[2] = i.getEninventario();
                datos[3] = i.getEmpleado();
                GregorianCalendar hoy = i.getFecha();
                String cadenaFecha = hoy.get(Calendar.DAY_OF_MONTH) + "/" + (hoy.get(Calendar.MONTH) + 1) + "/" + hoy.get(Calendar.YEAR);
                datos[4] = cadenaFecha;
                df.addRow(datos);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ReporteDescargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.tablaInformes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se han encontrado descargos para ese usuario");
        }
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
        jPanel16 = new javax.swing.JPanel();
        btnVerInforme = new javax.swing.JButton();
        btnVerConsumoPorLab = new javax.swing.JButton();
        btnBuscarConEmp = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaInformes = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jlb_titulo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlb_titulo.setText("Menú de Descargos");

        btnVerInforme.setText("Ver Informe de Descargos");
        btnVerInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInformeActionPerformed(evt);
            }
        });

        btnVerConsumoPorLab.setText("Ver Consumo por Laboratorio");
        btnVerConsumoPorLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerConsumoPorLabActionPerformed(evt);
            }
        });

        btnBuscarConEmp.setText("Buscar Consumo de Empleado");
        btnBuscarConEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarConEmpActionPerformed(evt);
            }
        });

        tablaInformes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaInformes);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVerConsumoPorLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBuscarConEmp))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVerInforme)
                .addGap(17, 17, 17)
                .addComponent(btnVerConsumoPorLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarConEmp)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
        );

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_titulo)
                .addContainerGap(457, Short.MAX_VALUE))
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInformeActionPerformed
        Usuario u = cliente.Cliente.conectarU();
        ArrayList<informeDescargos> Informe;
        String meses[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        String cabeceras[] = {"Código", "Descripción", "Inventario Actual", "Consumido", "Nombre", "Área"};
        this.list= new JList<String>( meses);
        int si_no = -20;
        int aux = -20;
        DefaultTableModel df = null;
        JOptionPane.showConfirmDialog(null, list, "Seleccione el mes", JOptionPane.PLAIN_MESSAGE);
        if (list.getSelectedValue() != null) {
            si_no = JOptionPane.showConfirmDialog(null, "Se generará el informe para el mes de: " + list.getSelectedValue());
            aux = list.getSelectedIndex() + 1;
            df = (DefaultTableModel) this.tablaInformes.getModel();
            df.setColumnIdentifiers(cabeceras);
            this.tablaInformes.setModel(df);
            for (int i = df.getRowCount() - 1; i >= 0; i--) {
                df.removeRow(i);
            }
        }

        try {
            if (list.getSelectedValue() != null && si_no == JOptionPane.YES_OPTION) {
                if (aux < 10) {
                    Informe = u.generarInforme("0".concat(Integer.toString(aux)));
                } else {
                    Informe = u.generarInforme(Integer.toString(aux));
                }
                
                for (informeDescargos i : Informe) {
                    Object[] datos = new Object[6];
                    datos[0] = i.getCinterno();
                    datos[1] = i.getDescripcion();
                    datos[2] = i.getEninventario();
                    datos[3] = i.getEmpleado();
                    datos[4] = i.getNombre();
                    datos[5] = i.getArea();
                   
                    df.addRow(datos);
                }
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ReporteDescargos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerInformeActionPerformed

    private void btnVerConsumoPorLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerConsumoPorLabActionPerformed
        Usuario u = cliente.Cliente.conectarU();
        String cabecera[] = {"Código", "Descripción", "Inventario Actual", "Consumido"};
        ArrayList<informeDescargos> Informe;
        DefaultTableModel df = (DefaultTableModel) this.tablaInformes.getModel();
        df.setColumnIdentifiers(cabecera);
        this.tablaInformes.setModel(df);
        
        String meses[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        list = new JList<String>(meses);
        JOptionPane elegir = new JOptionPane();
        int si_no = -20;
        int aux = -20;
        int contadorMA = 0;
        int contadorMB = 0;
        int contadorFQ = 0;
        JOptionPane.showConfirmDialog(null, list, "Seleccione el mes", JOptionPane.PLAIN_MESSAGE);
        if (list.getSelectedValue() != null) {
            si_no = JOptionPane.showConfirmDialog(null, "Se generará el informe para el mes de: " + list.getSelectedValue());
            aux = list.getSelectedIndex() + 1;

            for (int i = df.getRowCount() - 1; i >= 0; i--) {
                df.removeRow(i);
            }
        }
        try {
            if (list.getSelectedValue() != null && si_no == JOptionPane.YES_OPTION) {
                if (aux < 10) {
                    Informe = u.generarInformePorLab("0".concat(Integer.toString(aux)));
                } else {
                    Informe = u.generarInformePorLab(Integer.toString(aux));
                }
                for (informeDescargos i : Informe) {
                    if (i.getInventario().equalsIgnoreCase("MA")) {
                        contadorMA += 1;
                    }
                    if (i.getInventario().equalsIgnoreCase("MB")) {
                        contadorMB += 1;
                    }
                    if (i.getInventario().equalsIgnoreCase("FQ")) {
                        contadorFQ += 1;
                    }
                }
                for (informeDescargos i : Informe) {
                    Object[] datos = new Object[4];
                    datos[0] = i.getCinterno();
                    datos[1] = i.getDescripcion();
                    datos[2] = i.getEninventario();
                    datos[3] = i.getEmpleado();
                    
                    df.addRow(datos);

                }

            }

        } catch (RemoteException ex) {
            Logger.getLogger(ReporteDescargos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerConsumoPorLabActionPerformed

    private void btnBuscarConEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarConEmpActionPerformed
        Reportes_BuscarUsuario busqueda1 = new Reportes_BuscarUsuario(ReporteDescargos.id);
        busqueda1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBuscarConEmpActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuReportes rep = new MenuReportes(id);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteDescargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReporteDescargos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarConEmp;
    private javax.swing.JButton btnVerConsumoPorLab;
    private javax.swing.JButton btnVerInforme;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlb_titulo;
    private javax.swing.JTable tablaInformes;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));

    }
}
