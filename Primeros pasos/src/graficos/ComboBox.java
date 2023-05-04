/*(v95) vamos a ver los componentes swing tipo combo box,son los menus desplegables(como los select en html),para manejar estos elementos se utiliza la clase JComboBox que hereda de JComponent(ver API), tiene varios metodos,esta el addItem para agregar las opciones y el getSelectItem para seleccionar una opcion.

Vamos a hacer el mismo ejercicio de cambiar la fuente de un texto a traves de un combobox.El combo estara en una segunda lamina en la zona norte de la primera,usaremos el constructor por defecto de la clase JComboBox que no pide parametros(ver API).

Hay un metodo de la clase JComboBox que permite que el combo sea editable,osea,puede tener sus opciones establecidas,pero si queremos buscar una que no este dentro del combo,con este metodo nos permite buscarla editando el texto del combo, el metodo es setEditable(),este recibe un boolean,true o false.

Listo, podemos cambiar el tipo de fuente del texto con las opciones del combo y ademas podemos escribir una fuente que no este dentro de las opciones y asi editar el texto,siempre y cuando ese tipo de fuente esté instalada en el pc.



 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox {
    public static void main(String[] args) {

        MarcoCombo miMarco = new MarcoCombo();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// marco
class MarcoCombo extends JFrame {

    public MarcoCombo() {

        setTitle("ComboBox");
        setBounds(300, 250, 550, 350);

        LaminaCombo miLamina = new LaminaCombo();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaCombo extends JPanel {

    private JLabel texto;
    private JComboBox miCombo;

    public LaminaCombo() {

        // establecemos layout
        setLayout(new BorderLayout());

        // establecemos el texto
        texto = new JLabel("En algún lugar de la mancha de cuyo nombre...");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        add(texto, BorderLayout.CENTER);

        // creamos una segunda lamina para el combobox y instanciamos ese combo y con
        // addItem le ponemos las opciones,despues agregamos este combo a la segunda
        // lamina y esta segunda lamina la agregamos al norte de la primera.Podemos
        // poner el combo como editable con setEditable().
        JPanel laminaNorte = new JPanel();
        miCombo = new JComboBox<>();
        miCombo.setEditable(true);

        miCombo.addItem("Serif");
        miCombo.addItem("Sans Serif");
        miCombo.addItem("Monospaced");
        miCombo.addItem("JetBrains Mono");

        // creamos objeto de clase oyente y ponemos el combo a la escucha del evento
        EventoCombo miEvento = new EventoCombo();
        miCombo.addActionListener(miEvento);

        // agregamos combo a la segunda lamina
        laminaNorte.add(miCombo);

        // agregamos la segunda lamina a la primera en su zona norte
        add(laminaNorte, BorderLayout.NORTH);

    }

    // clase oyente, aqui establecemos la fuente del texto segun el item
    // seleccionado del combo,para esto usamos como antes el constructor de la clase
    // Font que tiene 3 parametros,el primero es para decirle que tipo de fuente
    // vamos a usar,esto lo indicamos con el metodo getSelectItem pues se one el
    // tipo de letra segun el item seleccionado del combo,pero asi no mas da un
    // error,porque en este constructor este primer parametro debe ser de tipo
    // String y el metodo getSelectItem nos devuelve un tipoObject(ver API),asi que
    // para corregir esto casteamos este primer parametro a String.
    private class EventoCombo implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            texto.setFont(new Font((String) miCombo.getSelectedItem(), Font.PLAIN, 18));
        }

    }
}
