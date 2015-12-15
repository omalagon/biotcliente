/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Creaciones;

import EstructurasAux.ItemInventario;
import EstructurasAux.users;
import Usuario.MenuPrincipal;
import interfaces.Usuario;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CrearUsuario extends javax.swing.JFrame {

    private static String id = null;
    private static String tabla = "";
    private String idCreacion = "";
    private boolean existia = false;

    /**
     * Creates new form creaciones
     */
    public CrearUsuario() {
        initComponents();
    }

    public CrearUsuario(String id, String idCreacion) {
        initComponents();
        this.setLocationRelativeTo(null);
        CrearUsuario.id = id;
        this.idCreacion = idCreacion;
        this.jtf_id.setText(idCreacion);
        this.jLabel2.setVisible(existia);
        setIcon();
        if (this.idCreacion != "") {
            jtf_id.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    Usuario u = cliente.Cliente.conectarU();
                    try {
                        System.out.println("hace algo");
                        users aux = u.getDatosUsuario(jtf_id.getText());
                        if (aux != null) {
                            jtf_nombre.setText(aux.getNombre());
                            jtf_correo.setText(aux.getCorreo());
                            existia = true;
                            jLabel2.setVisible(existia);
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(CrearProveedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    jtf_nombre.setText("");
                    jtf_correo.setText("");
                    existia = false;
                    jLabel2.setVisible(existia);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        if (!idCreacion.equalsIgnoreCase("")) {
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
        btn_Aceptar = new javax.swing.JButton();
        btn_Cerrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_identificacion = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        jlb_creacion6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtf_id = new javax.swing.JTextField();
        jtf_nombre = new javax.swing.JTextField();
        jtf_correo = new javax.swing.JTextField();
        jcbx_area = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jlb_titulo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jlb_titulo.setText("Usuario");

        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        btn_Cerrar.setText("Cerrar");
        btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarActionPerformed(evt);
            }
        });

        lbl_identificacion.setText("Identificación");

        lbl_nombre.setText("Nombre");

        lbl_correo.setText("Correo");

        jlb_creacion6.setText("Área");

        jtf_id.setMaximumSize(new java.awt.Dimension(6, 20));

        jcbx_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lab Microbiológico", "Lab Físicoquímico", "Lab Medio ambiental", "Equipo de Oficina" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_nombre)
                    .addComponent(jtf_correo)
                    .addComponent(jcbx_area, 0, 248, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbx_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_identificacion)
                    .addComponent(lbl_nombre)
                    .addComponent(lbl_correo)
                    .addComponent(jlb_creacion6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_identificacion)
                .addGap(18, 18, 18)
                .addComponent(lbl_nombre)
                .addGap(18, 18, 18)
                .addComponent(lbl_correo)
                .addGap(18, 18, 18)
                .addComponent(jlb_creacion6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Debe seleccionar de nuevo este campo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb_titulo)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btn_Cerrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_Aceptar)
                            .addGap(19, 19, 19)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Aceptar)
                    .addComponent(btn_Cerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        if (existia == false) {
            this.crearUsuario();
        } else {
            this.editarUsuario();
        }
     }//GEN-LAST:event_btn_AceptarActionPerformed

    private void btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarActionPerformed
        if (this.idCreacion.equalsIgnoreCase("")) {
            MenuCreaciones menu = new MenuCreaciones(id);
            menu.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_btn_CerrarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Cerrar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox jcbx_area;
    private javax.swing.JLabel jlb_creacion6;
    private javax.swing.JLabel jlb_titulo;
    private javax.swing.JTextField jtf_correo;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_identificacion;
    private javax.swing.JLabel lbl_nombre;
    // End of variables declaration//GEN-END:variables

    private void crearUsuario() {
        String identificacion = this.jtf_id.getText();
        String nombre = this.jtf_nombre.getText();
        String correo = this.jtf_correo.getText();
        String psw = this.jtf_id.getText();
        int area = this.jcbx_area.getSelectedIndex();
        String labo = null;
        boolean creado = false;
        boolean val = validar(correo);
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
            labo = "EQ";
        }
        Usuario ad = cliente.Cliente.conectarU();
        if (val == true && identificacion.isEmpty() == false && nombre.isEmpty()
                == false && correo.isEmpty() == false && psw.isEmpty() == false) {
            try {
                creado = ad.crearUsuario(identificacion, nombre, correo, psw, labo, id);
                if (creado == true) {
                    JOptionPane.showMessageDialog(null, "Usuario creado satisfactoriamente");
                    PermisosUsuario perm = new PermisosUsuario(id, this.jtf_id.getText());
                    perm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear el usuario");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
        }

    }

    /**
     *
     * @param correo
     * @return boolean
     *
     * Verifica que el formato del correo sea:
     * alfanumérico@alfanumérico.alfabético
     */
    private boolean validar(String correo) {
        String emailValid = "^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.A-Za-z0-9]+)*(\\.[A-Za-z]{2,})*$";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(emailValid);
        boolean ret = false;
        if (correo.isEmpty() == false) {
            matcher = pattern.matcher(correo);
            System.out.println(correo + " " + matcher.matches());
            ret = matcher.matches();
        }
        return ret;

    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconB.png")));
    }

    private void editarUsuario() {
        String identificacion = this.jtf_id.getText();
        String nombre = this.jtf_nombre.getText();
        String correo = this.jtf_correo.getText();
        String psw = this.jtf_id.getText();
        int area = this.jcbx_area.getSelectedIndex();
        String labo = null;
        boolean editado = false;
        boolean val = validar(correo);
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
            labo = "EQ";
        }
        Usuario ad = cliente.Cliente.conectarU();
        if (val == true && identificacion.isEmpty() == false && nombre.isEmpty()
                == false && correo.isEmpty() == false && psw.isEmpty() == false) {
            try {
                users uuuu = new users(new BigDecimal(identificacion.trim()), nombre, correo, labo);
                editado = ad.EditarUsuario(uuuu);
                if (editado == true) {
                    JOptionPane.showMessageDialog(null, "Usuario editado satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo editar el usuario");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
        }

    }
}
