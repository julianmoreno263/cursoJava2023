/*(v63) vamos a trabajar con imagenes, para esto debemos primero capturar una imagen,si la tenemos por fuera de nuestro programa,osea en otra parte del PC debemos capturarla utilizando la clase ImageIO del paquete javax.imageio junto con su metodo read(),este metodo puede lanzar excepciones(esto lo veremso mas adelante), una vez capturada la imagen la debemos guardar en un objeto de la clase Image,esta clase pertenece al paquete java.awt, y tiene dos metodos para almacenarla con un ancho y un alto, por ultimo con nuestra clase Graphics la pintamos en la lamina con el metodo drawImage(), tambien podemos reproducir esa imagen en diferentes zonas de la lamina con el metodo copyArea. */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class TrabajandoImagenes {
    public static void main(String[] args) {

        MarcoImagenes miMarco = new MarcoImagenes();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoImagenes extends JFrame {

    public MarcoImagenes() {

        setTitle("Prueba con Imagenes");
        setBounds(450, 300, 500, 300);

        LaminaImagenes miLamina = new LaminaImagenes();
        add(miLamina);
    }
}

class LaminaImagenes extends JPanel {

    // creamos objeto para almacenar la imagen
    private Image imagen;

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // capturamos la imagen con read(File) debemos usar la clase File del paquete
        // java.io con este metodo(hay 4 metodos iguales pero con parametros
        // diferentes), read lanza excepciones por lo que hay que trabajar con try/catch

        File miImagen = new File(
                "C:/Users/USER/Desktop/udemy/cursoJava2023-master/Primeros pasos/src/graficos/auto.png");
        try {
            this.imagen = ImageIO.read(miImagen);
        } catch (IOException e) {

            System.out.println("La imagen no se puede encontrar!");
        }

        g.drawImage(imagen, 5, 5, null);

    }

}