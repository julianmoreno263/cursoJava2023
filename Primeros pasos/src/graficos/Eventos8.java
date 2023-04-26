/*(v74) siguiendo con los eventos de foco vamos a ver como manejar los eventos de foco pero en ventanas,en los ejemplos anteriores estabamos manejando el foco de elementos generales,pero ahora veremos como manejar el foco en ventanas pues una app puede tener multiples ventanas.Ademas manejaremos todo desde una sola clase(main). 

Para manejar el foco de ventanas debemos implementar la interfaz WindowFocusListener la cual tiene solo dos metodos.(ver API), tambien reciben un parametro de tipo WindowEvent.

vamos a hacer que la ventana que tenga el foco muestre un titulo que diga "tengo el foco" y al perderlo se quite este titulo,esto lo hacemos con los dos metodos de la interfaz.

*/

package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos8 extends JFrame implements WindowFocusListener {
    public static void main(String[] args) {

        Eventos8 miVentana = new Eventos8();
        miVentana.iniciar();

    }

    Eventos8 marco1;
    Eventos8 marco2;

    // metodo para construir los marcos,ponemos el this porque la clase donde
    // estamos creando todo es la misma que se usa para crear los objetos
    // oyentes,osea los marcos.
    public void iniciar() {
        this.marco1 = new Eventos8();
        this.marco2 = new Eventos8();

        // creamos los marcos
        marco1.setVisible(true);
        marco1.setBounds(100, 300, 600, 350);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco2.setVisible(true);
        marco2.setBounds(800, 300, 600, 350);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ponemos a la escucha del evento a los objetos oyentes
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);

    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

        if (e.getSource() == marco1) {
            marco1.setTitle("Tengo el foco!");
        } else {
            marco2.setTitle("Tengo el foco!");
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {

        if (e.getSource() == marco1) {
            marco1.setTitle("");
        } else {
            marco2.setTitle("");
        }
    }
}
