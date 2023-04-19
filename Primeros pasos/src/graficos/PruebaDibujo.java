/*vamos a ver como dibujar figuras sencillas con la clase Graphics, esta clase tiene varios metodos para realizar dibujosd e figuras,etc,crearemos nuestro marco y plantilla para dibujar.Esta clase pertenece a java.awt,y para nuestro frame javax.swing. 

La clase Graphics hace cosas sencillas,para poder hacer cosas mas complejas hay que utilizar la biblioteca Java 2d la cual tiene muchas clases para poder dibujar y hacer cosas mas complejas graficamente, solo que hay que escribir mas codigo pues hay que instanciar objetos,pues java es 100% orientado a objetos.Estas nuevas clases implementan la interfaz Shape y a la vez viene de la clase Graphics2d.

*/

package graficos;

import javax.swing.*;
import java.awt.*;

public class PruebaDibujo {
    public static void main(String[] args) {

        MarcoConDibujos miMarco = new MarcoConDibujos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Frame
class MarcoConDibujos extends JFrame {
    public MarcoConDibujos() {

        setTitle("prueba de Dibujo");
        setSize(400, 400);

        // agregamos la lamina
        LaminaConFiguras miLamina = new LaminaConFiguras();
        add(miLamina);
    }
}

// Lamina
class LaminaConFiguras extends JPanel {

    // sobreescribimos el metodo paintComponent
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        // g.drawRect(50, 50, 200, 200);dibujamos un cuadrado
        // g.drawLine(100, 100, 300, 200);dibujamos una linea
        // g.drawArc(50, 100, 150, 80, 120, 200);arco

    }
}