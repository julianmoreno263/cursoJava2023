/*(v88) vamos a ver como gestionamos los eventos en un campo de texto,osea cuando se cambia el texto,cuando se elimina,etc. Para esto la clase JTextField hereda de JTextComponent el metodo getDocument, cuando se escribe texto en un campo se crea un objeto de tipo documento,este objeto se puede poner a la escucha de eventos implementandole la interfaz Document y usando el metodo de esta interfaz addDocumentListener.

Ahora, para crear una clase oyente para este tipo de eventos se utiliza la interfaz DocumentListener,esta tiene tres metodos a implemnetar,no hay una clase adaptadora por lo que se tiene que implementar esta interfaz. 

vamos a ver primero como manejar el evento cuando se escribe en el campo de texto y cuando se elimina el texto.

1-Lo primero es en la clase de la lamina crear la clase interna que maneje los eventos.
2-creamos un objeto de esta clase oyente,en el constructor de la lamina.
3- ponemos a la escucha el campo JTextField,para esto primero capturamos lo que haya en ese campo de texto con el metodo getDocument,este metodo devuelve un objeto de tipo Document(ver API) y este lo ponemos a la escucha con addDocumentListener y le pasamos por parametro el objeto de la clase oyente que creamos antes.



 */

package graficos;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;

public class PruebaJTextField {
    public static void main(String[] args) {

        MarcoPrueba miMarco = new MarcoPrueba();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoPrueba extends JFrame {

    public MarcoPrueba() {

        setBounds(300, 300, 500, 350);

        LaminaPrueba miLamina = new LaminaPrueba();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaPrueba extends JPanel {

    public LaminaPrueba() {

        // creamos el campo de texto
        JTextField miCampo = new JTextField(20);

        // creamos objeto de la clase oyente
        EscuchaTexto elEvento = new EscuchaTexto();

        // capturamos lo del campo de texto en un documento y lo ponemos a la escucha
        Document miDoc = miCampo.getDocument();
        miDoc.addDocumentListener(elEvento);

        add(miCampo);
    }

    // clase interna oyente
    private class EscuchaTexto implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {

            System.out.println("Has insertado un texto!");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {

            System.out.println("Has borrado un texto!");

        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }

    }
}
