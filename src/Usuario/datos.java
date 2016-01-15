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
import logica.Permisos;

/**
 * 
 * @author Oscar Dario Malagon Murcia
 */
public class datos implements Serializable{
    private permisos listadoPermisos= null;
    
    public permisos lista(String id)
    {
        Permisos l = lista_1(id);
        listadoPermisos = new permisos(id,
                l.getCrearItem(), l.getCrearProveedor(),
                l.getCrearUsuario(), l.getDescargarConsumos(),
                l.getRecibirPedidos(), l.getGenRepDescargos(), 
                l.getGenRepInventario(), l.getGenRepUsuarios(),
                l.getGenRepProveedores(), l.getGenRepItemxProveedor(),
                l.getSolicitarProductos(),l.getRealizarCotizaciones(),
                l.getAprobarCotizaciones(), l.getGenerarOrdenesCompra(),
                l.getBloquearUsuario(), l.getGenfdc001());
        return listadoPermisos;
    }

    private static Permisos lista_1(java.lang.String id) {
        logica.LogicaBiotrends_Service service = new logica.LogicaBiotrends_Service();
        logica.LogicaBiotrends port = service.getLogicaBiotrendsPort();
        return port.lista(id);
    }
}
