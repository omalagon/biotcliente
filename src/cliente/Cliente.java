/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfaces.Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar Dario Malagon Murcia
 */
public class Cliente {

    /**
     * @return 
     */
    public static Usuario conectarU() {

        Usuario u = null;
        try {
            //192.168.10.166
            Registry registry = LocateRegistry.getRegistry("localhost", 222);
            
            u = (Usuario) registry.lookup("Test");

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

}
