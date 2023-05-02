/*(v72) vamos a ver los eventos de raton, para manejar estos eventos utilizamos la interfaz MouseListener la cual tiene varios metodos a ser implementados,por lo que tambien podemos usar la clase adaptadora MouseAdapter para asi no tener que declararlos todos. 

Estos metodos de e sta interfaz necesitan como parametro un objeto de tipo MouseEvent, esta clase tiene campos de clase y metodos como getX(), getY(), etc,(ver API

Recordar que la clase adaptadora ya tiene implementada la interfaz, por lo que si heredo en mi clase oyente la clase adaptadora ya no hay necesidad de declarar los metodos,solo se reescriben los que vaya a usar.

La interface MouseMotionListener nos sirve para controlar cuando estamos moviendo o arrastrando el mouse con sus dos unicos metodos mouseDragged y mouseMoved.


*/

package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos6 {
    public static void main(String[] args) {

        MarcoEventos6 miMarco = new MarcoEventos6();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// frame
class MarcoEventos6 extends JFrame {

    public MarcoEventos6() {

        setVisible(true);
        setBounds(450, 300, 600, 450);

        // creamos objeto oyente
        EventosRaton eventoRaton = new EventosRaton();
        // addMouse(eventoRaton);
        addMouseMotionListener(eventoRaton);
    }
}

// clase oyente
// class EventosRaton extends MouseAdapter {

// // @Override
// // public void mouseClicked(MouseEvent e) {
// // // System.out.println("Coordenada en x: " + e.getX() + " Coordenada y: " +
// // // e.getY());
// // System.out.println(e.getClickCount());
// // }

// public void mouseEntered(MouseEvent e) {
// System.out.println("El mouse entro al marco");
// }

// public void mousePressed(MouseEvent e) {
// // nos da los tres valores de los tres botones del mouse
// // System.out.println(e.getModifiersEx());
// if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
// System.out.println("Has pulsado el botón izquierdo del mouse");
// } else if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
// System.out.println("Has pulsado la rueda del mouse");
// } else if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
// System.out.println("Has pulsado el botón derecho del mouse");
// }
// }

// }

// clase oyente con interfaz MouseMotionListener
class EventosRaton implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Estás arrastrando el mouse");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Estás moviendo el mouse");
    }

}
