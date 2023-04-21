/*(v65) Trabajando con eventos en java, un evento es un desencadenante de una accion,puede ser un click,pulsar una tecla,etc. Para trabajar con eventos en java debemos tener en cuenta tres factores,el evento,el objeto fuente,osea quien desencadena la accion,y el listener o oyente que es el objeto que recibe la accion,recordar que todo en java son objetos.

Para esto,java tiene:

1- Para los eventos java tiene la clase EventObject que viene del paquete java.awt, esta clase a la vez tiene las clases ActionEvent y WindowEvent para manejar los eventos(los clicks,etc)

2- Si tenemos un boton en una lamina,este sera nuestro objeto fuente,osea el que desencadena la accion, si pulsamos este boton para que por ejemplo la lamina cambie de color,la lamina sera el listener,entonces el objeto boton debe usar el metodo addActionListener(objeto Listener) para indicar a que objeto le va a realizar esa accion(en este caso la lamina)

3- como nuestra lamina sera el listener, todo objeto que sea listener,osea que vaya a recibir una accion,debe implementar la interfaz ActionListener,y esta interfaz tiene un metodo llamado actionPerformed(objeto Evento) que recibe como parametro el objeto evento.

Si queremos poner mas botones a la escucha del evento y que cada boton cambie a un color diferente la lamina,debemos utilizar dentro de actionPerformed el metodo getSource del objeto ActionEvent que se esta pasando por parametro,asi se captura cual es el boton que esta desencadenando la accion al dar click.Para esto creamos un objeto de tipo Object y este utilizara el metodo getSource.(v66)





 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eventos {

    public static void main(String[] args) {

        MarcoEventos miMarco = new MarcoEventos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoEventos extends JFrame {

    public MarcoEventos() {

        setTitle("Trabajando con eventos");
        setBounds(450, 300, 500, 300);

        LaminaEventos miLamina = new LaminaEventos();
        add(miLamina);
    }
}

class LaminaEventos extends JPanel implements java.awt.event.ActionListener {

    // creamos un boton en la lamina para trabajar los eventos, para agregarlo a la
    // lamina lo hacemos desde el constructor de la lamina. Ahora,para poner la
    // lamina a la escucha del evento que se desencadena en el boton,utilizamos el
    // boton con el metodo addActionListener, y como el objeto listener que se le
    // debe pasar a este metodo es la misma lamina,lo indicamos con this,porque
    // estamos trabajando aqui dentro de la clase Lamina. La clase Lamina debe
    // implementar la interfaz ActionListener porque es la que usara el metodo
    // addActionListener,y por lo mismo debe implementar el metodo
    // actionPerformed().En vsc salia un error con addActionListener que no era
    // compatible el this ,pero se soluciono al implementar la interface
    // ActionListener con la ruta completa especificando el paquete de donde viene.
    JButton botonAzul = new JButton("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");

    // constructor
    public LaminaEventos() {

        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);

        // aqui se le dice al boton que va a desencadenar una accion en el objeto lamina
        botonAzul.addActionListener(this);
        botonAmarillo.addActionListener(this);
        botonRojo.addActionListener(this);

    }

    // implementamos el metodo actionPerformed de la interfaz,es el que especifica
    // el evento que va a desencadenar la accion,osea el evento de raton,se le
    // denomina e.Este metodo en si es donde se dice que debe hacer el evento,osea
    // poner de azul el fondo de la lamina
    public void actionPerformed(ActionEvent e) {

        // objeto para capturar el boton que desencadena el evento
        Object botonPulsado = e.getSource();

        if (botonPulsado == botonAzul) {

            setBackground(Color.BLUE);
        } else if (botonPulsado == botonAmarillo) {

            setBackground(Color.YELLOW);
        } else {

            setBackground(Color.RED);
        }

    }

}