/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Creaciones;

import EstructurasAux.ItemInventario;
import interfaces.Usuario;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CrearItem extends javax.swing.JFrame {

    private static String id = null;
    private static String tabla = "";
    private boolean existia = false;
    private String cinterno = "";

    /**
     * Creates new form creaciones
     */
    public CrearItem() {
        initComponents();
    }

    public CrearItem(String id, String cinterno) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.id = id;
        setIcon();
        this.jtf_cinterno.setText(cinterno);
        jLabel2.setVisible(false);
        this.cinterno = cinterno;
        if(this.cinterno!="")
        {
            jtf_cinterno.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                Usuario u = cliente.Cliente.conectarU();
                try {
                    System.out.println("hace algo");
                    ItemInventario aux = u.buscarInfoItem(jtf_cinterno.getText());
                    if (aux != null) {
                        jtf_desc.setText(aux.getDescripcion());
                        jtf_pres.setText(aux.getPresentacion());
                        jtf_cantidad.setText(Float.toString(aux.getCantidad()));
                        jtf_precio.setText(Float.toString(aux.getPrecio()));
                        jtf_ccalidad.setText(aux.getcCalidad());
                        jtf_cesp.setText(aux.getCEsp());
                        existia = true;
                        jLabel2.setVisible(existia);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(CrearProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jtf_desc.setText("");
                jtf_pres.setText("");
                jtf_cantidad.setText("");
                jtf_precio.setText("");
                jtf_ccalidad.setText("");
                jtf_cesp.setText("");
                existia = false;
                jLabel2.setVisible(existia);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        }
        if (!cinterno.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Haga clic en aceptar y oprima la tecla espacio");
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

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jlb_titulo = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_desc = new javax.swing.JLabel();
        lbl_pres = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        lbl_cCalidad = new javax.swing.JLabel();
        lbl_inv = new javax.swing.JLabel();
        lbl_cEsp = new javax.swing.JLabel();
        lbl_provAs = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtf_desc = new javax.swing.JTextField();
        jtf_pres = new javax.swing.JTextField();
        jtf_cantidad = new javax.swing.JTextField();
        jtf_precio = new javax.swing.JTextField();
        jtf_ccalidad = new javax.swing.JTextField();
        jcbbxArea = new javax.swing.JComboBox();
        jtf_cesp = new javax.swing.JTextField();
        jtf_provAs = new javax.swing.JTextField();
        jtf_cinterno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jlb_titulo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlb_titulo.setText("Ítem");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lbl_desc.setText("Descripción");

        lbl_pres.setText("Presentación");

        lbl_cantidad.setText("Cantidad");

        lbl_precio.setText("Precio");

        lbl_cCalidad.setText("Cert Calidad");

        lbl_inv.setText("Inventario");

        lbl_cEsp.setText("Cumple Especificaciones");

        lbl_provAs.setText("Proveedor Asociado");

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Debe seleccionar de nuevo este campo");

        jLabel1.setText("Código Interno");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_inv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_desc)
                            .addComponent(lbl_cEsp)
                            .addComponent(lbl_cCalidad)
                            .addComponent(lbl_pres)
                            .addComponent(lbl_cantidad)
                            .addComponent(lbl_precio)
                            .addComponent(lbl_provAs)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbl_desc)
                .addGap(18, 18, 18)
                .addComponent(lbl_pres)
                .addGap(18, 18, 18)
                .addComponent(lbl_cantidad)
                .addGap(18, 18, 18)
                .addComponent(lbl_precio)
                .addGap(18, 18, 18)
                .addComponent(lbl_cCalidad)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_inv)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(lbl_cEsp)
                .addGap(18, 18, 18)
                .addComponent(lbl_provAs)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jtf_desc.setMaximumSize(new java.awt.Dimension(6, 20));

        jcbbxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lab Microbiológico", "Lab Físicoquímico", "Lab Medio ambiental", "S.Gene.", "Compras" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbbxArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_pres, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_ccalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_cesp, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_provAs, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_cinterno, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtf_cantidad, jtf_ccalidad, jtf_cesp, jtf_cinterno, jtf_desc, jtf_precio, jtf_pres, jtf_provAs});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtf_cinterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_pres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_ccalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_cesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_provAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtf_cantidad, jtf_ccalidad, jtf_cesp, jtf_cinterno, jtf_desc, jtf_precio, jtf_pres, jtf_provAs});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlb_titulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_titulo)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!existia) {
            this.crearItem();
        } else {
            this.editarItem();
        }
     }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        if (this.cinterno.equalsIgnoreCase("")) {
            CrearItem_Version2 cr = new CrearItem_Version2(id);
            cr.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new CrearItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox jcbbxArea;
    private javax.swing.JLabel jlb_titulo;
    private javax.swing.JTextField jtf_cantidad;
    private javax.swing.JTextField jtf_ccalidad;
    private javax.swing.JTextField jtf_cesp;
    private javax.swing.JTextField jtf_cinterno;
    private javax.swing.JTextField jtf_desc;
    private javax.swing.JTextField jtf_precio;
    private javax.swing.JTextField jtf_pres;
    private javax.swing.JTextField jtf_provAs;
    private javax.swing.JLabel lbl_cCalidad;
    private javax.swing.JLabel lbl_cEsp;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_desc;
    private javax.swing.JLabel lbl_inv;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_pres;
    private javax.swing.JLabel lbl_provAs;
    // End of variables declaration//GEN-END:variables

    private void crearItem() {
        Usuario u = cliente.Cliente.conectarU();
        boolean valido;
        boolean asociado = false;
        int area = this.jcbbxArea.getSelectedIndex();
        String labo = null;
        if (area == 0) {
            labo = "MB";
        }
        if (area == 1) {
            labo = "FQ";
        }
        if (area == 2) {
            labo = "MA";
        }
        if (area == 3) {
            labo = "S.Gene.";
        }
        if (area == 4) {
            labo = "Compras";
        }

        ItemInventario item = new ItemInventario(
                this.jtf_cinterno.getText(),
                this.jtf_desc.getText(),
                this.jtf_pres.getText(),
                new Float(this.jtf_cantidad.getText()),
                new Float(this.jtf_precio.getText()),
                this.jtf_ccalidad.getText(),
                labo,
                "",
                this.jtf_cesp.getText());
        try {
            valido = u.crearItem(item);
            if (!jtf_provAs.getText().isEmpty()) {
                asociado = u.asociarItem(this.jtf_cinterno.getText(), this.jtf_provAs.getText(), this.jtf_precio.getText());
            }
            if (valido && asociado) {
                JOptionPane.showMessageDialog(null, "Item creado y asociado");
                JOptionPane.showMessageDialog(null, "Oprima \"Refrescar\" para ver los cambios");
            } else if (valido) {
                JOptionPane.showMessageDialog(null, "Item creado");
                JOptionPane.showMessageDialog(null, "Oprima \"Refrescar\" para ver los cambios");
            } else {
                JOptionPane.showMessageDialog(null, "Error en la creación del ítem\nSugerencia: "
                        + "Revise el inventario");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(CrearItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }

    private void editarItem() {
        Usuario u = cliente.Cliente.conectarU();
        boolean valido;
        boolean asociado = false;
        int area = this.jcbbxArea.getSelectedIndex();
        String labo = null;
        if (area == 0) {
            labo = "MB";
        }
        if (area == 1) {
            labo = "FQ";
        }
        if (area == 2) {
            labo = "MA";
        }
        if (area == 3) {
            labo = "S.Gene.";
        }
        if (area == 4) {
            labo = "Compras";
        }

        ItemInventario item = new ItemInventario(
                this.jtf_cinterno.getText(),
                this.jtf_desc.getText(),
                this.jtf_pres.getText(),
                new Float(this.jtf_cantidad.getText()),
                new Float(this.jtf_precio.getText()),
                this.jtf_ccalidad.getText(),
                labo,
                "",
                this.jtf_cesp.getText());
        try {
            valido = u.editarItem(item);
            if (jtf_provAs.getText() == null || !jtf_provAs.getText().trim().equalsIgnoreCase("")) {
                asociado = u.asociarItem(this.jtf_cinterno.getText(), this.jtf_provAs.getText(), this.jtf_precio.getText());

            } else {
                asociado = true;
            }

            if (valido && asociado) {
                JOptionPane.showMessageDialog(null, "Item editado");
                JOptionPane.showMessageDialog(null, "Oprima \"Refrescar\" para ver los cambios");
            } else if (asociado == false) {
                JOptionPane.showMessageDialog(null, "Item editado, pero ocurrió un error al asociarlo\nRevise el NIT del proveedor");
            } else {
                JOptionPane.showMessageDialog(null, "Error en la creación del ítem\nSugerencia: "
                        + "Revise el inventario");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(CrearItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
