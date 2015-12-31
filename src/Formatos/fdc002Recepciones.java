/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formatos;

import EstructurasAux.infoItems;
import EstructurasAux.itemsOrdenCompra;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Oscar Dario Malagon Murcia
 */
public class fdc002Recepciones implements JRDataSource {

    private List<infoItems> pedido = new ArrayList<>();
    private int i = -1;

    public fdc002Recepciones() {

    }

    @Override
    public boolean next() throws JRException {
        return ++i < pedido.size();
    }

    public void addAsistente(infoItems Asistente) {

        this.pedido.add(Asistente);

    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {

        Object valor = null;

        if ("cInterno".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getCinterno();
        } else if ("Desc".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getDescripcion();
        } else if ("Cant".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getCantidad();
        } else if ("pres".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getPresentacion();
        } else if ("vUnitario".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getVunitario();
        } else if ("Vtotal".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getVtotal();
        } else if ("fRecepcion".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getFrecepcion();
        } else if ("CalidaSi".equalsIgnoreCase(jrf.getName())) {
            if(pedido.get(i).getCcalidad().equalsIgnoreCase("SI"))
            {
                valor = "X";
            }else
            {
                valor="";
            }
        } else if ("CalidadNo".equalsIgnoreCase(jrf.getName())) {
            if(pedido.get(i).getCcalidad().equalsIgnoreCase("NO"))
            {
                valor = "X";
            }else
            {
                valor="";
            }
        }else if ("EspSi".equalsIgnoreCase(jrf.getName())) {
            if(pedido.get(i).getCcalidad().equalsIgnoreCase("SI"))
            {
                valor = "X";
            }else
            {
                valor="";
            }
        } else if ("EspNo".equalsIgnoreCase(jrf.getName())) {
            if(pedido.get(i).getCcalidad().equalsIgnoreCase("NO"))
            {
                valor = "X";
            }else
            {
                valor="";
            }
        } else if ("Venci".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getFvencimiento();
        } else if ("Verif".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).getMverificacion();
        } 

        return valor;
    }

    public static File metodo(String ruta, HashMap parametros, ArrayList<infoItems> pedido) {
        // TODO code application logic here

        InputStream inputStream = null;
        JasperPrint jasperPrint = null;
        fdc002Recepciones datasource = new fdc002Recepciones();
        File pdf = null;
        String rutaArchivo = null;
        for (infoItems pp : pedido) {
            System.out.println(pp.getCinterno());
            datasource.addAsistente(pp);
        }

        String property = System.getProperty("user.dir");
        rutaArchivo = property.concat("\\src\\Formatos\\fdc002.jrxml");
        try {
            inputStream = new FileInputStream(rutaArchivo);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el fichero de carga jasper report " + ex.getMessage());
        }

        try {

            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, datasource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, ruta + "\\" + parametros.get("oCompra") + ".pdf");
            pdf = new File(ruta + "\\" + parametros.get("oCompra") + ".pdf");
            //JasperViewer.viewReport(jasperPrint);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar fichero jrml jasper report " + e.getMessage());
        }
        return pdf;
    }

}
