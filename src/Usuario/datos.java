/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

import EstructurasAux.permisos;
import interfaces.Usuario;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Oscar Dario Malagon Murcia
 */
public class datos implements Serializable{
    private permisos listadoPermisos= null;
    
    public permisos lista(String id)
    {
        Usuario u =cliente.Cliente.conectarU();
        try {
            System.out.println("entra aca");
            listadoPermisos = u.lista(id);
        } catch (RemoteException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoPermisos;
    }
}
