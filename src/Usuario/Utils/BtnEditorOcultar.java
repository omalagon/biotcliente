/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Utils;

import interfaces.Usuario;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
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
            System.out.println(this.idUsuario);
            System.out.println(this.idRecurso);
            System.out.println(this.tipoRecurso);
            huboCambios =ocultar(this.idUsuario, this.idRecurso, this.tipoRecurso);
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

    private static boolean ocultar(java.lang.String idUsuario, java.lang.String idRecurso, java.lang.String tipoRecurso) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.ocultar(idUsuario, idRecurso, tipoRecurso);
    }
}
