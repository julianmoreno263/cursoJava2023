/*(v92) vamos a ver los botones de tipo checkbox, para crear este tipo de botones se utiliza la clase JCheckBox la cual hereda los metodos isSelected() y setSelected() de la clase AbstractButton, el primero nos devuelve un boolean y sirve para saber si un checkbox esta seleccionado, y el segundo no devuelve nada y sirve para establecer un checkbox como seleccionado o no,este recibe un boolean como parametro(verAPI).

Vamos a hacer que en la parte de arriba del marco haya un texto y en la parte sur creamos dos checkbox,uno que ponga la letra en negrita y el otro en cursiva,como los checkbox permiten seleccionar varios al tiempo se puede tener la letra en negrita y cursiva tambien.Con la clase Font podemos manipular un texto y cambiar sus propiedades.


 */

package graficos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBox {
    public static void main(String[] args) {

        MarcoCheck miMarco = new MarcoCheck();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoCheck extends JFrame {

    public MarcoCheck() {

        setTitle("Prueba checkbox");
        setBounds(300, 250, 500, 350);

        LaminaCheck miLamina = new LaminaCheck();
        add(miLamina);

        setVisible(true);

    }
}

// lamina
class LaminaCheck extends JPanel {

    private JLabel texto;
    private JCheckBox check1, check2;

    public LaminaCheck() {

        setLayout(new BorderLayout());

        // establezco tipo de letra y creo un texto
        Font miLetra = new Font("Serif", Font.PLAIN, 24);
        texto = new JLabel("En un lugar de la mancha de cuyo nombre...");
        texto.setFont(miLetra);

        // creo una segunda lamina y le agrego el texto,esta ira en la zona central de
        // la lamina principal
        JPanel laminaTexto = new JPanel();
        laminaTexto.add(texto);
        add(laminaTexto, BorderLayout.CENTER);

        // creamos los checkbox,los ponemos a la escucha de un evento,los agregamos a
        // una tercera lamina y esa ira en la zona sur de la lamina principal,usamos un
        // constructor para los check que permite pasarles un texto.
        check1 = new JCheckBox("Negrita");
        check2 = new JCheckBox("Cursiva");

        // pongo a la escucha los check instanciando la clase oyente todo en una linea
        check1.addActionListener(new ManejaChecks());
        check2.addActionListener(new ManejaChecks());

        // creamos lamina para los checks y los agregamos a la zona sur
        JPanel laminaCheckbox = new JPanel();
        laminaCheckbox.add(check1);
        laminaCheckbox.add(check2);
        add(laminaCheckbox, BorderLayout.SOUTH);

    }

    // clase interna oyente que va a evaluar las tres combianciones que pueden tener
    // los dos checkbox,para esto usamos mejor las constantes de la clase Font
    // BOLD(QUE VALE 1) e ITALIC(QUE VALE 2),estas constantes retornan un entero(ver
    // API).Si check1 es seleccionado pone la variable tipo en 1(porque bold vale 1)
    // o si es selecionado check2 la pone en 2,segun esta validacion el texto se
    // establece en bold,o en italic,o como estamos usando el tercer constructor de
    // la clase Font el cual admite tres parametros,el segundo es el estilo de la
    // fuente(la variable tipo), en la descripcion de este constructor dice que en
    // este segundo parametro se admite la union de BOLD e ITALIC (osea la suma de
    // 1+2=3) para que si ambos check estan seleccionados se den ambos cambios,el
    // texto en negrita y en cursiva.
    private class ManejaChecks implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int tipo = 0;

            // segun el check seleccionado se establece el valor de tipo,si ambos son
            // seleccionados se suman y se almacena el 3 en tipo.
            if (check1.isSelected()) {
                tipo += Font.BOLD;
            }
            if (check2.isSelected()) {
                tipo += Font.ITALIC;
            }

            // aqui se establece la fuente del texto con el constructor que permite 3
            // parametros
            texto.setFont(new Font("Serif", tipo, 24));

        }

    }

}
