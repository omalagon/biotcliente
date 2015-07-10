package Reportes;


import net.sf.jasperreports.view.JasperViewer;

public class Proveedores {

    

    /*public SimpleReport() {
        JasperPrint jasperPrint = null;
        DefaultTableModel TableModelData = TableModelData();
        try {
            jasperPrint = JasperFillManager.fillReport("C:\\Users\\OscarDarío\\Desktop\\TablaReportes\\src\\report1.jasper", new HashMap(),
                    new JRTableModelDataSource(TableModelData));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    private DefaultTableModel TableModelData() {
        String[] columnNames = {"ID", "Name", "Department", "Email"};
        String[][] data = {
            {"111", "G Conger", " Orthopaedic", "jim@wheremail.com"},
            {"222", "A Date", "ENT", "adate@somemail.com"},
            {"333", "R Linz", "Paedriatics", "rlinz@heremail.com"},
            {"444", "V Sethi", "Nephrology", "vsethi@whomail.com"},
            {"555", "K Rao", "Orthopaedics", "krao@whatmail.com"},
            {"666", "V Santana", "Nephrology", "vsan@whenmail.com"},
            {"777", "J Pollock", "Nephrology", "jpol@domail.com"},
            {"888", "H David", "Nephrology", "hdavid@donemail.com"},
            {"999", "P Patel", "Nephrology", "ppatel@gomail.com"},
            {"101", "C Comer", "Nephrology", "ccomer@whymail.com"}
        };
        
        return  new DefaultTableModel(data, columnNames);
    }*/

    public void generarfdc002()
    {
        try {
            
            String direccion = "E:\\Final Version\\Biot_Cliente\\src\\Reportes\\newReport.jasper";
            JasperViewer.viewReport(direccion, true);
            System.out.println("NO");
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        new Proveedores().generarfdc002();
    }
}
