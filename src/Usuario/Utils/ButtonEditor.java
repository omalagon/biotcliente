/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario.Utils;

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
import logica.ItemInventario;
import logica.Proveedor;
import logica.Users;

/**
 *
 * @author malag
 */
public class ButtonEditor extends DefaultCellEditor {

    private JButton btn;
    private String lbl;
    private Boolean clicked;
    private String idRecurso;
    private EnumAcciones accion;
    private String idUsuario;
    private String recurso;

    public ButtonEditor(JTextField textField, EnumAcciones accion, String id, String recurso) {
        super(textField);
        this.accion = accion;
        this.idUsuario = id;
        this.recurso = recurso;
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
        if (!accion.equals(EnumAcciones.PERMISOS)) {
            this.idRecurso = lbl.substring(lbl.indexOf("r") + 1, lbl.length());
        } else {
            this.idRecurso = lbl.substring(lbl.indexOf("s") + 3, lbl.length());
        }

        clicked = true;
        return btn;
    }

    @Override
    public Object getCellEditorValue() {
        boolean huboCambios = false;
        if (clicked) {
            switch (this.recurso.trim()) {
                case "item":
                    switch (accion) {
                        case ACTUALIZAR:
                            CrearItem cr = new CrearItem(this.idUsuario, idRecurso);
                            cr.setVisible(true);
                            break;
                        case ELIMINAR:
                            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el " + recurso + idRecurso + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                            if (dialogResult == 0) {
                                ItemInventario itm =new ItemInventario();
                                itm.setNumero(idRecurso);
                                itm.setDescripcion("");
                                itm.setPresentacion("");
                                itm.setCantidad(0);
                                itm.setPrecio(0);
                                itm.setCCalidad("");
                                itm.setInventario("");
                                itm.setSucursal("");
                                itm.setCEsp("");
                                huboCambios = eliminarItem(itm);
                            } else {
                                //No hace nada
                            }
                            break;
                        case VER: {
                            String msg = "";
                            ItemInventario find = buscarInfoItem(idRecurso);
                            msg = "<html>"
                                    + "Código Interno:" + find.getNumero() + "<br></br>"
                                    + "Descripción:   " + find.getDescripcion() + "<br></br>"
                                    + "Presentación:  " + find.getPresentacion() + "<br></br>"
                                    + "Cantidad:      " + find.getCantidad() + "<br></br>"
                                    + "Precio:        " + find.getPrecio() + "<br></br>"
                                    + "Cert Calidad:  " + find.getCCalidad() + "<br></br>"
                                    + "Cump Especific:" + find.getCEsp() + "<br></br>"
                                    + "</html>";
                            JOptionPane j = new JOptionPane(msg);
                            JDialog di = j.createDialog("Información del ítem");
                            di.setVisible(true);
                        }
                        break;
                    }
                    break;
                case "itemSinDetalles":
                    switch (accion) {
                        case VER: {
                            String msg = "";
                            ItemInventario find = buscarInfoItem(idRecurso);
                            msg = "<html>"
                                    + "Código Interno:" + find.getNumero() + "<br></br>"
                                    + "Descripción:   " + find.getDescripcion() + "<br></br>"
                                    + "Presentación:  " + find.getPresentacion() + "<br></br>"
                                    + "</html>";
                            JOptionPane j = new JOptionPane(msg);
                            JDialog di = j.createDialog("Información del ítem");
                            di.setVisible(true);
                        }
                        break;
                    }
                    break;
                case "proveedor":
                    switch (accion) {
                        case ACTUALIZAR:
                            CrearProveedor cr = new CrearProveedor(idUsuario, idRecurso);
                            cr.setVisible(true);
                            break;
                        case ELIMINAR:
                            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el " + recurso + idRecurso + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                            if (dialogResult == 0) {
                                huboCambios = eliminarProveedor(idRecurso);
                            } else {
                                //No hace nada
                            }
                            break;
                        case VER: {
                            String msg = "";
                            Proveedor find = getDatosProveedor(idRecurso);
                            msg = "<html>"
                                    + "NIT:" + find.getNIT() + "<br></br>"
                                    + "Nombre:   " + find.getNombre() + "<br></br>"
                                    + "Dirección:  " + find.getDireccion() + "<br></br>"
                                    + "Teléfono:      " + find.getTelefono() + "<br></br>"
                                    + "Telefax:        " + find.getTelefax() + "<br></br>"
                                    + "Celular:  " + find.getCelular() + "<br></br>"
                                    + "Correo:" + find.getCorreo() + "<br></br>"
                                    + "Contacto:" + find.getContacto() + "<br></br>"
                                    + "</html>";
                            JOptionPane j = new JOptionPane(msg);
                            JDialog di = j.createDialog("Información del proveedor");
                            di.setVisible(true);
                        }
                        break;
                    }
                    break;
                case "usuario":
                    switch (accion) {
                        case ACTUALIZAR:
                            CrearUsuario cu = new CrearUsuario(id, idRecurso);
                            cu.setVisible(true);
                            break;
                        case ELIMINAR:
                            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el " + recurso + idRecurso + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                            if (dialogResult == 0) {
                                huboCambios = eliminarUsuario(idRecurso);
                            } else {
                                //No hace nada
                            }
                            break;
                        case VER:
                            String msg = "";
                            Users find = getDatosUsuario(idRecurso);
                            msg = "<html>"
                                    + "Identificación:      " + find.getId() + "<br></br>"
                                    + "Nombre:" + find.getNombre() + "<br></br>"
                                    + "Correo:   " + find.getCorreo() + "<br></br>"
                                    + "Laboratorio:  " + find.getLab() + "<br></br>"
                                    + "</html>";
                            JOptionPane j = new JOptionPane(msg);
                            JDialog di = j.createDialog("Información del proveedor");
                            di.setVisible(true);

                            break;
                        case PERMISOS: {
                            try {
                                PermisosUsuario per = new PermisosUsuario(idUsuario, idRecurso);
                                per.setVisible(true);
                            } catch (RemoteException ex) {
                                Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    }
                    break;
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

    private static logica.ItemInventario buscarInfoItem(java.lang.String cinterno) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.buscarInfoItem(cinterno);
    }

    private static boolean eliminarItem(logica.ItemInventario item) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.eliminarItem(item);
    }

    private static boolean eliminarProveedor(java.lang.String nit) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.eliminarProveedor(nit);
    }

    private static Proveedor getDatosProveedor(java.lang.String nit) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.getDatosProveedor(nit);
    }

    private static boolean eliminarUsuario(java.lang.String id) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.eliminarUsuario(id);
    }

    private static Users getDatosUsuario(java.lang.String id) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.getDatosUsuario(id);
    }
}
