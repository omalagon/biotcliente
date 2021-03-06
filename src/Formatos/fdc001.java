/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formatos;

import EstructurasAux.ItemInventario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class fdc001 implements JRDataSource {

    private List<Object[]> pedido = new ArrayList<>();
    private int i = -1;

    public fdc001() {

    }

    @Override
    public boolean next() throws JRException {
        return ++i < pedido.size();
    }

    public void addAsistente(Object[] Asistente) {

        this.pedido.add(Asistente);

    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {

        Object valor = null;
        if ("inv".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i)[0].toString();
            System.out.println("inv "+valor);
        } else if ("nombre".equalsIgnoreCase(jrf.getName())) {
            System.out.println("nombre "+valor);
            valor = pedido.get(i)[1].toString();

        } else if ("desc".equalsIgnoreCase(jrf.getName())) {
            System.out.println("desc "+valor);
            valor = pedido.get(i)[2].toString();

        } else if ("cants".equalsIgnoreCase(jrf.getName())) {
            System.out.println("cants "+valor);
            valor = pedido.get(i)[3].toString();
        } else if ("pUnitario".equalsIgnoreCase(jrf.getName())) {
            System.out.println("pUnitario"+valor);
            valor = pedido.get(i)[5].toString();
        } else if ("Prov".equalsIgnoreCase(jrf.getName())) {
            System.out.println("prov"+valor);
            valor = pedido.get(i)[6].toString();
        } else if ("cantApr".equalsIgnoreCase(jrf.getName())) {
            System.out.println("cantApr " +valor);
            valor = pedido.get(i)[7].toString();
        } else if ("NOrden".equalsIgnoreCase(jrf.getName())) {
            valor = pedido.get(i).length==9?pedido.get(i)[8].toString():"";
        }

        return valor;
    }

    public static File metodo(String ruta, HashMap parametros, ArrayList<Object[]> pedido) {
        for (Object[] p : pedido) {
            System.out.println("longitud " +p.length);
            System.out.println(p[0]);
            System.out.println(p[1]);
            System.out.println(p[2]);
            System.out.println(p[3]);
            System.out.println(p[4]);
            System.out.println(p[5]);
            System.out.println("====================================\n");
        }
        InputStream inputStream = null;
        JasperPrint jasperPrint = null;
        fdc001 datasource = new fdc001();
        File pdf = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        String rutaArchivo = null;
        java.util.Date date = new java.util.Date();
        ruta += "\\FDC001" + date.toString().substring(0, 4) +" - Solicitud no." + parametros.get("numsol") + ".pdf";
        for (Object[] pp : pedido) {
            datasource.addAsistente(pp);
        }
        String property = System.getProperty("user.dir");
        rutaArchivo= property.concat("\\src\\Formatos\\fdc001.jrxml");
        try {
            inputStream = new FileInputStream(rutaArchivo);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el fichero de carga jasper report " + ex.getMessage());
            
        }

        try {

            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, datasource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, ruta);
            pdf = new File(ruta);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar fichero jrml jasper report " + e.getMessage());
            System.out.println(e.getCause());
        }
        return pdf;
    }

}
//uuid="((([0-9])*([A-Za-z])*)*-*)*"