/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import EstructurasAux.users;
import exampleinterface.TestRemote;
import interfaces.Usuario;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static Usuario conectarU() {

        Usuario u = null;
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.0.6", 222);
            u = (Usuario) registry.lookup("Test");

        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

}
