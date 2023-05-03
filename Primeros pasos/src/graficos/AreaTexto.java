/*(v90) vamos a ver las areas de texto, se usa la clase JTextArea,y esta tiene varios metodos,entre ellos getText(), setLineWrap() para establecer saltos de linea y getLineWrap().

Crearemos un area de texto y un boton y cuando escribamos algo en el area,al pulsar el boton nos aparecera ese texto en consola.

Al tener creadad el area,si escribimos,aunque le hayamos dado unas dimensiones desde el constructor,si seguimos escribiendo el area se ensancha automaticamente,para evitar ese comportamiento se usa el metodo setLineWrap(),que establece que cuando llegue al final de una linea automaticamente de el salto de linea y no ensanche el area.

Para que no crezca verticalmente lo unico es ponerle barras de scroll,pero estas barras no se le pueden poner al area directamente,lo unico es crear una lamina nueva y a esa lamina ponerle las barras y agregar alli el area.Pero para esta nueva lamina con barras de scroll se utiliza la clase JScrollPane.

 */

package graficos;

import javax.swing.*;
import java.awt.event.*;

public class AreaTexto {
    public static void main(String[] args) {

        MarcoArea miMarco = new MarcoArea();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// marco
class MarcoArea extends JFrame {

    public MarcoArea() {

        setBounds(300, 250, 500, 350);

        LaminaArea miLamina = new LaminaArea();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaArea extends JPanel {

    private JTextArea miArea;

    public LaminaArea() {

        miArea = new JTextArea(8, 20);
        miArea.setLineWrap(true);

        // nueva lamina con scroll y agregamos el area de texto
        JScrollPane laminaBarras = new JScrollPane(miArea);

        add(laminaBarras);

        // creamos boton y lo ponemos a la escucha
        JButton miBoton = new JButton("Mostrar texto");
        miBoton.addActionListener(new GestionaArea());
        add(miBoton);
    }

    // clase interna oyente
    private class GestionaArea implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println(miArea.getText());
        }

    }
}