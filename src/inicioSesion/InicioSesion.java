/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicioSesion;

import administrador.VentanaInicio_Adm;
import auxiliarOficina.VentanaInicio_AO;
import auxiliarOficina.AOficina;
import interfaces.Usuario;
import java.awt.Color;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import responsableArea.VentanaInicio_RA;

/**
 *
 * @author Oscar_Malagon
 */
public class InicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form InicioSesion
     */
    public InicioSesion() {
        initComponents();
        this.buttonGroupTipo.add(RbuttonDA);
        this.buttonGroupTipo.add(RButtonRA);
        this.buttonGroupTipo.add(RButtonAO);
        this.setSize(280, 351);
        this.setLocationRelativeTo(null);
        setIcon();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        labelInicioSesion = new javax.swing.JLabel();
        labelError = new javax.swing.JLabel();
        BotonIngresar = new javax.swing.JButton();
        RButtonAO = new javax.swing.JRadioButton();
        RButtonRA = new javax.swing.JRadioButton();
        RbuttonDA = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        contrasena = new javax.swing.JPasswordField();
        labelIdentificacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        labelInicioSesion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelInicioSesion.setText("Inicio Sesion");

        labelError.setForeground(new java.awt.Color(255, 0, 0));

        BotonIngresar.setText("Ingresar");
        BotonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIngresarActionPerformed(evt);
            }
        });
        BotonIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BotonIngresarKeyPressed(evt);
            }
        });

        RButtonAO.setText("Auxiliar Oficina");

        RButtonRA.setText("Responsable Area");

        RbuttonDA.setText("Director Administrativo");

        jLabel3.setText("Tipo de Usuario");

        jLabel2.setText("Contraseña");

        contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenaActionPerformed(evt);
            }
        });

        labelIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelIdentificacionActionPerformed(evt);
            }
        });

        jLabel1.setText("Identificación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RButtonRA)
                            .addComponent(RbuttonDA)
                            .addComponent(jLabel3)
                            .addComponent(RButtonAO)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelError)
                            .addComponent(labelInicioSesion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(contrasena))
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonIngresar)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInicioSesion)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RbuttonDA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RButtonRA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RButtonAO)
                .addGap(0, 0, 0)
                .addComponent(labelError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(BotonIngresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaActionPerformed

    private void BotonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIngresarActionPerformed
        String usuario = labelIdentificacion.getText();
        String psw = contrasena.getText();
        String tipo = new String();
        String cadenaError = "Verifique nombre, contraseña y tipo de usuario";
        boolean validarTipoUsuario = false;

        if (RbuttonDA.isSelected()) {
            tipo = "da";
        }
        if (RButtonRA.isSelected()) {
            tipo = "ra";
        }
        if (RButtonAO.isSelected()) {
            tipo = "ao";
        }
        Usuario u = cliente.Cliente.conectarU();
        if (u == null) {
            JOptionPane.showMessageDialog(null, "Error en la conexion con el servidor");
        } else {
            try {
                validarTipoUsuario = u.validarTipoUsuario(usuario, psw, tipo);
                System.out.println(validarTipoUsuario);
                System.out.println(usuario);
                System.out.println(psw);
                System.out.println(tipo);
            } catch (RemoteException ex) {
                Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (validarTipoUsuario == true && tipo.equalsIgnoreCase("da")) {
                VentanaInicio_Adm adm = new VentanaInicio_Adm(usuario);
                adm.setVisible(true);
                this.labelError.setText("Correcto");
                this.labelError.setForeground(Color.BLUE);
                this.setVisible(false);
            }
            if (validarTipoUsuario == true && tipo.equalsIgnoreCase("ra")) {
                //RArea responsable = new RArea(usuario);
                //responsable.setVisible(true);
                VentanaInicio_RA responsable = new VentanaInicio_RA(usuario);
                responsable.setVisible(true);
                this.labelError.setText("Correcto");
                this.labelError.setForeground(Color.BLUE);
                this.setVisible(false);
            }
            if (validarTipoUsuario == true && tipo.equalsIgnoreCase("ao")) {
                //AOficina auxiliar = new AOficina(usuario);
                //auxiliar.setVisible(true);
                VentanaInicio_AO vent= new VentanaInicio_AO(usuario);
                vent.setVisible(true);
                this.labelError.setText("Correcto");
                this.labelError.setForeground(Color.BLUE);
                this.setVisible(false);
            }
            if (validarTipoUsuario == false) {
                this.labelError.setForeground(Color.red);
                this.labelError.setText(cadenaError);
            }
        }
    }//GEN-LAST:event_BotonIngresarActionPerformed

    private void labelIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelIdentificacionActionPerformed

    private void BotonIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BotonIngresarKeyPressed

    }//GEN-LAST:event_BotonIngresarKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

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
                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicioSesion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIngresar;
    private javax.swing.JRadioButton RButtonAO;
    private javax.swing.JRadioButton RButtonRA;
    private javax.swing.JRadioButton RbuttonDA;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelError;
    private javax.swing.JTextField labelIdentificacion;
    private javax.swing.JLabel labelInicioSesion;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Recursos/iconB.png")));
    }

}
