/*

--------------------------------------------------------------------------------
(v67) Tambien podemos crear un oyente diferente a la lamina para tener separados tanto el objeto fuente(los botones) como el listener(la lamina en este caso) y asi ver mejor todo el codigo, porque en este momento el objeto fuente se encuentra dentro del listener que es la misma lamina y puede ser algo confuso,entonces crearemos otro objeto diferente que sera el listener y le cambiaremos el color de fondo.

Entonces la lamina como ya no sera el listener le quitamos la implementacion de la interfaz y a los botones ya no se les pasa el this que hacia referencia a la lamina,ademas quitamos el action performed de donde estaba.

Como para este nuevo objeto oyente creamos una clase donde usaremos el metodo setBackground que pertenece a la clase Lamina(porque setBackground es un metodo de JPanel) para poder usarlo ponemos esta nueva clase como clase interna de Lamina,asi ya se puede usar este metodo.Ya despues,en el constructor de Lamina creamos los objetos de esta nueva clase oyente y estos objetos son los que le paso a los botones en el metodo addActionListener.Asi quedan separados los objetos fuente y oyentes.


 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eventos2 {

    public static void main(String[] args) {

        MarcoEventos miMarco = new MarcoEventos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoEventos2 extends JFrame {

    public MarcoEventos2() {

        setTitle("Trabajando con eventos");
        setBounds(450, 300, 500, 300);

        LaminaEventos miLamina = new LaminaEventos();
        add(miLamina);
    }
}

class LaminaEventos2 extends JPanel {

    JButton botonAzul = new JButton("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");

    // constructor
    public LaminaEventos2() {

        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);

        // objetos de la clase oyente ColorFondo
        ColorFondo azul = new ColorFondo(Color.BLUE);
        ColorFondo amarillo = new ColorFondo(Color.YELLOW);
        ColorFondo rojo = new ColorFondo(Color.RED);

        // aqui se le dice al boton que va a desencadenar una accion en el objeto lamina
        botonAzul.addActionListener(azul);
        botonAmarillo.addActionListener(amarillo);
        botonRojo.addActionListener(rojo);

    }

    // clase interna para el nuevo objeto oyente,implementa en su constructor el
    // color de fondo
    private class ColorFondo implements ActionListener, java.awt.event.ActionListener {

        private Color colorDeFondo;

        public ColorFondo(Color c) {
            this.colorDeFondo = c;
        }

        public void actionPerformed(ActionEvent e) {

            setBackground(colorDeFondo);
        }

    }

}
