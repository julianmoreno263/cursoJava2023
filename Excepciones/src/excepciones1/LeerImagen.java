/*(v143) con este ejercicio vamos a ver como manejar los errores de tipo IOExcepcion en java,los cuales no son culpa del programador,este programa debe mostrar una imagen en la lamina,para esto en el constructor de la clase LaminaConImagen debemos poner una imagen usando el metodo read de la clase ImageIO.


Si vemos este metodo en la API veremos que lanza un error IOExepcion,o esta preparado para manejar un error de este tipo.Tiene la clausula throw(lanzar) y indica que puede lanzar un objeto de tipo IOExcepcion.Para controlar estos errores java nos obliga a implementar la estructura try-catch.

Entonces,si tratamos de llamar por ejemplo a una imagen que no esta en nuestro proyecto con el metodo read,este nos saca un error,y nos obliga a implemnetar la estructura try-catch para manejar este posible error.

Cuando nos salga un error,lo leemos y vemos de que tipo es,podemos buscar en la API la clase de ese error,y si es un error de tipo IOExcepcion o que herede de IOExcepcion,estamos obligados a implementar el try-catch en ese codigo que lanza el error.Si es un error de tipo RuntimeExcepcion no es obligatorio poner el try-catch,depende de la logica.


 */

package excepciones1;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LeerImagen {

    public static void main(String[] args) {

        MarcoImagen mimarco = new MarcoImagen();

        mimarco.setVisible(true);

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoImagen extends JFrame {
    public MarcoImagen() {
        setTitle("Marco con imagen");

        setBounds(750, 300, 300, 200);

        LaminaConImagen milamina = new LaminaConImagen();

        add(milamina);
    }
}

class LaminaConImagen extends JPanel {

    private Image imagen;

    public LaminaConImagen() {

        // ASI MANEJAMOS EL ERROR
        try {
            imagen = ImageIO.read(new File("src/excepciones1/auto.png"));
        } catch (IOException e) {

            System.out.println("La imagen no se encuentra!");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // con este codigo solventamos el error de tipo RuntimeExcepcion que sale que es
        // un error de tipo NullPointerException en este pedazo de codigo
        if (imagen == null) {

            g.drawString("No se puede cargar la imagen", 20, 20);

        } else {

            int anchuraImagen = imagen.getWidth(this);
            int alturaImagen = imagen.getHeight(this);

            g.drawImage(imagen, 0, 0, null);

            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 200; j++) {
                    if (i + j > 0) {
                        g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen * i, alturaImagen * j);
                    }
                }
            }
        }

    }
}
