/*(v76) vamos a ver como manejar multiples fuentes de eventos, en una aplicacion,puede disparase un evento desde varias fuentes,ya sea desde un boton y a la vez una combinacion de teclas. Para manejar multiples fuentes de eventos debemos utilizar la interfazAction la cual tiene 6 metodos y a la vez hereda el metodo actionPerformed que ya hemos utilizado.Esta interfaz no tiene una clase adapatadora para reemplazarla,pero si tiene una clase abstracta llamada AbstractAction la cual ya tiene implementados los metodos para ser sobreescritos.

Vamos a crear un programa que tenga un marco y una lamina y en la lamina haya tres botones para que cada boton le de un color de fondo a la lamina,pero ademas que los colores se puedan cambiar no solo dando click en el boton sino segun el color tener una combinacion de teclas, asi habra mas de una fuente de eventos,los botones y las teclas.

_____________________________________________________________________
(v77) para entender las multiples fuentes de eventos en java debemos ver como trabaja la interfaz Action que vamos a usar para esto(aunque usemos la clase abstracta AbstracAction que en si es lo  mismo). Sabemos que cuando por ejemplo se pulsa una tecla,java maneja ese evento de pulsar una tecla como un objeto, entonces cuando se crea este objeto y estamos usando la interfaz Action,lo que se crea en si es un objeto evento que tiene informacion del boton y esta informacion es almacenada en un formato de clave:valor.Por ejemplo del boton podemos almacenar el nombre del boton,la accion que hace el boton,etc.Para almacenar esa informacion en el objeto evento utilizamos el metodo putValue, y una vez ya se tenga almacenada esta informacion en el objeto,este objeto se le pasa como parametro al metodo actionPerformed(ActionEvent e),que es el objeto e. Despues ya dentro de este metodo si necesitamos rescatar esa informacion del objeto lo hacemos con getValue().

Entonces,lo primero que debemos ver es que informacion nos interesa rescatar del objeto fuente,osea del boton en este caso. Vamos a rescatar el nombre del boton(Amarillo,Azul o Rojo),un icono,una descripcion de que hace ese boton (la descripcion es un pequeño cuadro que sale cuando nos posicionamos en el boton y tiene un mensaje informativo) y la accion que ejecuta, esto lo hacemos con putValue.

Para almacenar con putValue() los valores del objeto evento debemos ir a la API y en la interfaz Action ver los campos de clase (constantes) que aparecen alli,por ejemplo para manejar un nombre esta la constante NAME, estas constantes son estaticas por lo que debemos nombrar primero la interfaz y despues la constante.Si no voy a utilizar una clave de Action sino una diferente que yo quiera crear,simplemente la creo entre comillas y le doy su respectivo valor(como la clave para el color de fondo).

Ahora voy al constructor de la lamina y creo objetos de esta clase oyente,a las que le debo ir pasando los respectivos valores pues asi lo estipule en su constructor.

 */

package graficos;

import javax.swing.*;
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

        // objetos de la clase oyente(acciones)
        AccionColor colorAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/amarilla.jpg"),
                Color.YELLOW);

        AccionColor colorAzul = new AccionColor("Azul", new ImageIcon("src/graficos/azul.png"),
                Color.BLUE);

        AccionColor colorRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/rojo.jpg"),
                Color.RED);

        // creamos los tres botones con la clase JButton y los agregamos
        // JButton botonAmarillo = new JButton("Amarillo");
        // JButton botonAzul = new JButton("Azul");
        // JButton botonRojo = new JButton("Rojo");

        // add(botonAmarillo);
        // add(botonAzul);
        // add(botonRojo);

    }

}

// creamos la clase oyente que pondra a ala escucha a la lamina,lo hacemos con
// la clase AbstracAction, esta clase implementa por defecto los 6 metodos de la
// interfaz Action,pero toca escribir el metodo actionPerformed manualmente.
class AccionColor extends AbstractAction {

    public AccionColor(String nombre, Icon icono, Color colorBoton) {

        putValue(Action.NAME, nombre);
        putValue(Action.SMALL_ICON, icono);
        putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color" + nombre);
        putValue("colorFondo", colorBoton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
