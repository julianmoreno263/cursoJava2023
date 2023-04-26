/*(v76) vamos a ver como manejar multiples fuentes de eventos, en una aplicacion,puede disparase un evento desde varias fuentes,ya sea desde un boton y a la vez una combinacion de teclas. Para manejar multiples fuentes de eventos debemos utilizar la interfazAction la cual tiene 6 metodos y a la vez hereda el metodo actionPerformed que ya hemos utilizado.Esta interfaz no tiene una clase adapatadora para reemplazarla,pero si tiene una clase abstracta llamada AbstractAction la cual ya tiene implementados los metodos para ser sobreescritos.

Vamos a crear un programa que tenga un marco y una lamina y en la lamina haya tres botones para que cada boton le de un color de fondo a la lamina,pero ademas que los colores se puedan cambiar no solo dando click en el boton sino segun el color tener una combinacion de teclas, asi habra mas de una fuente de eventos,los botones y las teclas.

 */

package graficos;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Eventos9 {
    public static void main(String[] args) {

        MarcoEventos9 miMarco = new MarcoEventos9();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoEventos9 extends JFrame {

    public MarcoEventos9() {
        setTitle("PRUEBA ACCIONES");
        setBounds(300, 300, 600, 300);

        PanelAction miLamina = new PanelAction();
        add(miLamina);
    }
}

// lamina
class PanelAction extends JPanel {

    public PanelAction() {

        // creamos los tres botones con la clase JButton y los agregamos
        JButton botonAmarillo = new JButton("Amarillo");
        JButton botonAzul = new JButton("Azul");
        JButton botonRojo = new JButton("Rojo");

        add(botonAmarillo);
        add(botonAzul);
        add(botonRojo);

    }

}

// creamos la clase oyente que pondra a ala escucha a la lamina,lo hacemos con
// la clase AbstracAction, esta clase implementa por defecto los 6 metodos de la
// interfaz Action,pero toca escribir el metodo actionPerformed manualmente.
class AccionColor extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
