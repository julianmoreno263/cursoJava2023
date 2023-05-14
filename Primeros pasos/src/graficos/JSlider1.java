/*(v96) vamos a ver los JSlider o controles deslizantes(barras numeradas para ajustar un tamaño), para crear estos elementos debemos utilizar la clase JSlider,tiene varios metodos,el setPaintTicks(boolean) es para pintar las lineas del slider,setPaintLabels pinta los numeros,setMajor(para las lineas mas largas) y setMinor(para las lineas mas cortas) es para decir de cuanto en cuento iran las marcas del slider.

Ahora, haremos el mismo ejercicio de ir cambiando el tamaño de un texto pero con un jslider y utilizaremos sus metodos correspondientes.Pero para que un objeto de tipo jslider pueda tener interactividad debe implementar la interfaz ChangeListener junto a su unico metodo stateChanged que recibe por parametro un objeto de tipo ChangeEvent e,el cual pone a la escucha el objeto oyente de los cambios de estado del jslider.

Para capturar el valor del slider usamos un metodo de la clase JSlider llamado getValue,este nos da el valor(el numero en que se posiciona el slider).






 */

package graficos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class JSlider1 {
    public static void main(String[] args) {

        MarcoSlider miMarco = new MarcoSlider();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

// marco
class MarcoSlider extends JFrame {

    public MarcoSlider() {

        setTitle("Slider");
        setBounds(300, 250, 550, 350);

        LaminaSlider miLamina = new LaminaSlider();
        add(miLamina);

        setVisible(true);

    }
}

// lamina
class LaminaSlider extends JPanel {

    private JLabel rotulo;
    private JSlider control;

    public LaminaSlider() {

        setLayout(new BorderLayout());

        // texto
        rotulo = new JLabel("En un lugar de la mancha de cuyo nombre...");
        add(rotulo, BorderLayout.CENTER);

        // slider
        control = new JSlider(8, 50, 12);
        control.setMajorTickSpacing(20);
        control.setMinorTickSpacing(5);
        control.setPaintTicks(true);
        control.setPaintLabels(true);
        control.setFont(new Font("Serif", Font.ITALIC, 10));

        // ponemos el slider a la escucha
        control.addChangeListener(new EventoSlider());

        // segunda lamina para poner el slider arriba
        JPanel laminaSlider = new JPanel();
        laminaSlider.add(control);

        // agregar segunda lamina a la lamina principal
        add(laminaSlider, BorderLayout.NORTH);

    }

    // clase oyente
    private class EventoSlider implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

            rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
        }

    }

}