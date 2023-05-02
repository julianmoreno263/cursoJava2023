/*(v61) para manejar colores utilizamosel metodo setPaint(Color) de la clase Graphics2D el cual pide como parametro un color,estos colores estan en la clase Color como constantes,y utilizando los metodos setBacground(Color) y setForeground(Color) de la clase JPanel establecemos el color de fondo y de frente de la lamina.El metodo fill rellena el interior de una figura,este metodo viene de la clase Graphics2D. 

con los metodos brighter y darker le ponemos mas o menos brillo al color.Tambien la clase Color tiene sobrecarga de constructores,osea tiene mas de un constructor que podemos usar para crear los objetos y dar colores,hay un constructor que recibe como parametros el codigo en rgb.A la lamina,en la clase del frame donde la adiciono,le puedo poner un color de fondo con setBackground.

*/

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class TrabajandoColores {
    public static void main(String[] args) {

        MarcoConColor miMarco = new MarcoConColor();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoConColor extends JFrame {

    public MarcoConColor() {
        setTitle("Prueba con colores");
        setSize(400, 400);

        LaminaConColor miLamina = new LaminaConColor();
        add(miLamina);

        // miLamina.setBackground(new Color(24, 123, 45));

        // para ponerle el color por defecto que tienen las ventanas del SO en el que
        // estemos,utilizamos SystemColor.window

        miLamina.setBackground(SystemColor.window);

    }
}

class LaminaConColor extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // utilizando java 2d para crear figuras
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setPaint(Color.BLUE.brighter());
        g2.fill(rectangulo);

        // elipse
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.setPaint(Color.RED.darker());
        g2.fill(elipse);
    }
}
