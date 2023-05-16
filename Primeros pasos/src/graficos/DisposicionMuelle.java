/*(v116) vamos a ver la disposicion en muelle,para esto utilizamos las clases SpringLayout y Spring.

SpringLayout le indica al contenedor que disposicion vamos a usar,tiene un metodo putConstraint,y la clase Spring construye este muelle,tiene el metodo constant().

vamos a crear un marco con una lamina y la lamina tendra tres botones, para establecer la distancia entre los botones y la lamina crearemos varios muelles(como resortes).Los muelles sirven para cuando redimensionamos asi mismo se van adaptando los elementos.


 */

package graficos;

import javax.swing.*;
import java.awt.*;

public class DisposicionMuelle {
    public static void main(String[] args) {

        MarcoMuelle miMarco = new MarcoMuelle();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// frame
class MarcoMuelle extends JFrame {

    public MarcoMuelle() {
        setTitle("Disposición en Muelle");
        setBounds(150, 250, 1000, 350);

        LaminaMuelle miLamina = new LaminaMuelle();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaMuelle extends JPanel {

    public LaminaMuelle() {

        // creamos los botones
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");

        // creamos la disposicion en muelle para la lamina
        SpringLayout miLayout = new SpringLayout();
        setLayout(miLayout);

        add(boton1);
        add(boton2);
        add(boton3);

        // creamos los muelles para los botones con la clase Spring y utilizamos el
        // metodo constant() que recibe tres argumentos,este metodo con 3 argumentos
        // permite que el muelle sea elastico,si no ponemos los tres argumentos sino
        // solo 1,el muelle sera fijo,sin elasticidad.
        Spring miMuelle = Spring.constant(0, 10, 100);

        // ahora debo ir poniendo este muelle entre el borde de mi lamina y el primer
        // boton,entre los botones y entre el ultimo boton y el otro borde de la
        // lamina,para esto utilizo la instancia de SpringLayout que creamos para
        // utilizar el metodo putConstraint().El this hace referencia a la lamina,para
        // este primer boton pues el borde al que tiene que llegar el muelle es la
        // propia lamina,por eso se pone el this en este boton1.
        miLayout.putConstraint(SpringLayout.WEST, boton1, miMuelle, SpringLayout.WEST, this);
        miLayout.putConstraint(SpringLayout.WEST, boton2, miMuelle, SpringLayout.EAST, boton1);
        miLayout.putConstraint(SpringLayout.WEST, boton3, miMuelle, SpringLayout.EAST, boton2);
        miLayout.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, boton3);

    }
}