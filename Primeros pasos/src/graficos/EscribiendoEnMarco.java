/*(v58) vamos a ver como escribir texto en nuestras ventanas, el frame es el marco y podemos escribir directamente texto en el,pero lo correcto es crear laminas o paneles encima del frame y escribir en estos paneles. En si es como poner laminas transparentes encima y trabajar en ellas. Para crear estas laminas o paneles usamos la clase JPanel,la cual al igual que JFrame, tiene una cadena de herencia larga,por lo cual es muy especializada.Entonces al igual que con JFrame,debemos crear una clase que herede de JPanel y asi crear objetos de esa clase que seran nuestras laminas, y ya podemos usar el metodo paintComponent(graphics g) que es el que nos permite dibujar,escribir,etc,encima de la lamina, este metodo recibe un objeto de tipo Graphics,la cual es la clase que permite escribir,dibujar,etc. especificamente para escribir,esta clase Graphics tiene el metodo drawString(dibujar texto).

El metodo paintComponente de JPanel es heredado desde la clase Component, este metodo hace un trabajo por defecto,y nosotros despues en JPanel lo sobreescribimos para decirle que ademas de su trabajo haga algo que queremos,como poner un texto,etc.Entonces,al utilizar este metodo es importante primero decirle que haga su trabajo llamandolo desde la clase padre donde se creo osea lo llamamos con super(pues viene desde la clase Component)y asi estaria haciendo primero su trabajo original,y despues de invocarlo con super hay si le podemos decir que haga el trabajo especifico que queremos,osea poner un texto.

Listo,ahora con el metodo drawString dibujamos el texto,se le pasan 3 parametros,el texto,y las coordenadas donde queremos que se pinte ese texto en la lamina.

Por ultimo agregamos esta lamina al frame, entonces vamos al constructor del frame y creamos un objeto de la clase Lamina y lo agregamos con el metodo add().Listo, nos aparece nuestra ventana pero aunque no la vemos tiene una lamina encima del frame.




 */

package graficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {
    public static void main(String[] args) {

        MarcoConTexto miMarco = new MarcoConTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// creamos el frame
class MarcoConTexto extends JFrame {
    public MarcoConTexto() {
        setVisible(true);
        setSize(600, 450);
        setLocation(400, 200);
        setTitle("Primer Marco con Texto");

        Lamina miLamina = new Lamina();
        add(miLamina);
    }
}

// creamos la lamina,debe heredar de JPanel
class Lamina extends JPanel {

    // sobreescribimos el metodo paintComponent
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawString("Estamos aprendiendo swing", 100, 100);
    }
}