package Usuario.Utils;

import javax.swing.*;

/**
 * JOptionPane showInputDialog example #3. Using a combo box in an input dialog
 * (showInputDialog).
 *
 * @author alvin alexander, http://alvinalexander.com
 */
public class InputDialogCBox {

    private Object[] valores;
    private String retorno;
    private String titulo;
    private String tituloItems;

    public String retorno() {
        JFrame frame = new JFrame("");
        String seleccion = (String) JOptionPane.showInputDialog(frame,
                titulo,
                tituloItems,
                JOptionPane.QUESTION_MESSAGE,
                null,
                valores,
                valores[0]);

        return seleccion;
    }

    public InputDialogCBox(Object[] valores, String titulo, String tituloItems) {
        this.valores = valores;
        this.titulo = titulo;
        this.tituloItems = tituloItems;
    }
    
    

}
