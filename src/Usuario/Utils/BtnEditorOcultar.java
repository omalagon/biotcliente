/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Utils;

import EstructurasAux.ItemInventario;
import EstructurasAux.proveedor;
import EstructurasAux.users;
import static Usuario.Bloqueos.BloquearUsuario.id;
import Usuario.Creaciones.CrearItem;
import Usuario.Creaciones.CrearProveedor;
import Usuario.Creaciones.CrearUsuario;
import Usuario.Creaciones.PermisosUsuario;
import interfaces.Usuario;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author malag
 */
public class BtnEditorOcultar extends DefaultCellEditor {

    private JButton btn;
    private String lbl;
    private Boolean clicked;
    private EnumAcciones accion;
    private String idUsuario;
    private String idRecurso;
    private String tipoRecurso;

    public BtnEditorOcultar(JTextField textField, EnumAcciones accion, String idUsuario, String idRecurso, String tipoRecurso) {
        super(textField);
        this.accion = accion;
        this.tipoRecurso = tipoRecurso;
        this.idUsuario = idUsuario;
        this.idRecurso = idRecurso;
        btn = new JButton();
        btn.setOpaque(true);
        //Clicked
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        lbl = (value == null) ? "" : value.toString();
        this.idRecurso = lbl.substring(lbl.indexOf("r") + 1, lbl.length());

        clicked = true;
        return btn;
    }

    @Override
    public Object getCellEditorValue() {
        boolean huboCambios = false;
        if (clicked) {
            Usuario ad = cliente.Cliente.conectarU();
            System.out.println(this.idUsuario);
            System.out.println(this.idRecurso);
            System.out.println(this.tipoRecurso);
            try {
                huboCambios =ad.ocultar(this.idUsuario, this.idRecurso, this.tipoRecurso);
            } catch (RemoteException ex) {
                Logger.getLogger(BtnEditorOcultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (huboCambios) {
            JOptionPane.showMessageDialog(null, "Oprima \"Refrescar\" para ver los cambios");
        }
        clicked = false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped(); //To change body of generated methods, choose Tools | Templates.
    }
}
