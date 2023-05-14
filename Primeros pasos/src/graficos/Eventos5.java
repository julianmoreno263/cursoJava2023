/*(v71) en este archivo veremos los eventos de teclado, para manejarlos samos la  interfaz KeyListener que cuenta con tres metodos, estos reciben como parametro un objeto de la clase KeyEvent la cual tiene varios metodos.Podemos recurrir a la clase adaptadora KeyAdapter para manejar solo uno de estos metodos si no queremos declararlos todos(aunque solo sean tres)

Aqui en este video se explica bien que pasa internamente cuando manejamos eventos,como se utiliza la interfaz correspondiente y como se crea ese objeto evento que es el que viaja a los parametros del metodo que se va a utilizar segun el tipo de evento.

Siempre crear despues el objeto de la clase oyente y ponerlo a laescucha del evento, en este caso se utiliza el metodo addKeyListener().


 */

package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos5 {
    public static void main(String[] args) {

        MarcoEventos5 miMarco = new MarcoEventos5();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoEventos5 extends JFrame {

    public MarcoEventos5() {

        setVisible(true);
        setBounds(450, 300, 600, 450);

        // creamos el objeto oyente y lo ponemos a la escucha
        EventoTeclado tecla = new EventoTeclado();
        addKeyListener(tecla);
    }
}

// clase oyente
class EventoTeclado implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int codigoLetra = e.getKeyCode();
        // System.out.println(codigoLetra);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        char teclaPulsada = e.getKeyChar();
        System.out.println(teclaPulsada);
    }

}
