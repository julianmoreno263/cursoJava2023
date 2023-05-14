/*vamos a ver como dibujar figuras sencillas con la clase Graphics, esta clase tiene varios metodos para realizar dibujosd e figuras,etc,crearemos nuestro marco y plantilla para dibujar.Esta clase pertenece a java.awt,y para nuestro frame javax.swing. 

La clase Graphics hace cosas sencillas,para poder hacer cosas mas complejas hay que utilizar la biblioteca Java 2d la cual tiene muchas clases para poder dibujar y hacer cosas mas complejas graficamente, solo que hay que escribir mas codigo pues hay que instanciar objetos,pues java es 100% orientado a objetos.Estas nuevas clases implementan la interfaz Shape y a la vez viene de la clase Graphics2d.

Entonces, si por ejemplo quiero dibujar un rectangulo,uso la clase Rectangle2d, con esta clase debo utilizar la clase Graphics2d,creo un objeto de esta clase y puedo ahora utilizar el metodo draw(Shape s) al cual le tengo que pasar un parametro que sera un objeto de la clase que implemente la interfaz Shape.

Lo primero es importar el paquete java.awt.geom que es el que tiene la libreria java 2d.

1- hacemos una refundicion de nuestro objeto g de tipo Graphics a Graphics2d.
2- creamos un objeto de la clase Rectangle2d la cual es abstracta,como no podemos instanciar directamente una clase abstracta,instanciamos la clase Rectangle2d.double, la cual si se puede instanciar y hereda de Rectangle2D.Asi no instanciamos directamente de la clase abstracta Rectangle2D(porque no se puede) sino que lo hacemos desde la clase Rectangle2D.Double la cual hereda de Rectangle2D.
3-ya instanciado nuestro rectangulo utilizamos el metodo draw de la clase Graphics2D para dibujar el triangulo.Este metodo nos pide nuestro objeto de clase Rectangle2D que creamos y este objeto debe implemnetar la interfaz Shape,esta interfaz ya la implemneta la clase Graphics2D por lo que el objeto que creamos de esta clase ya tiene esa interfaz.(ver v60)

podemos hacer lo mismo para dibujar una elipse,solo que una elipse no tiene un punto inicial porque es circular,por lo que partimos de  un rectangulo y dentro de ese rectangulo dibujamos la elipse,podemos utilizar el rectangulo que ya creamos como limite de nuestra elipse.

podemos instanciar nuestro objeto directamente dentro del metodo draw,por ejemplo vamos a crear una linea utilizando la clase Line2D y la instanciamos directamente en el metodo draw.

-------------------------------------------------------------------------------


*/

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

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
        // g.drawArc(50, 100, 150, 80, 120, 200);// arco

        // utilizando java 2d para crear figuras
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.draw(rectangulo);

        // elipse
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.draw(elipse);

        // linea instanciada en el metodo draw
        g2.draw(new Line2D.Double(100, 100, 300, 250));

        // ponemos todo dentro de un circulo,para esto capturamos el centro del
        // rectangulo.
        double centroX = rectangulo.getCenterX();
        double centroY = rectangulo.getCenterY();
        double radio = 125;
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroX, centroY, radio + centroX, radio + centroY);
        g2.draw(circulo);

    }
}