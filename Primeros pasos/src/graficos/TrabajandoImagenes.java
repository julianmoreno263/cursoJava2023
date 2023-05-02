/*(v63) vamos a trabajar con imagenes, para esto debemos primero capturar una imagen,si la tenemos por fuera de nuestro programa,osea en otra parte del PC debemos capturarla utilizando la clase ImageIO del paquete javax.imageio junto con su metodo read(),este metodo puede lanzar excepciones(esto lo veremso mas adelante), una vez capturada la imagen la debemos guardar en un objeto de la clase Image,esta clase pertenece al paquete java.awt, y tiene dos metodos para almacenarla con un ancho y un alto, por ultimo con nuestra clase Graphics la pintamos en la lamina con el metodo drawImage(), tambien podemos reproducir esa imagen en diferentes zonas de la lamina con el metodo copyArea. 

con copyArea de la clase Graphics lo que hago es copiar mi imagen y colocarla en otra area de mi lamina,asi doy un efecto de mosaico usando este metodo dentro de un bucle for,este metodo recibe 6 parametros(ver API.). esto se hace conociendo el ancho y alto de nuestra imagen,pero si no lo sabemos podemos utilizar el metodo getWidth y getHeight de la clase Image.Estos metodos necesitan como parametro un objeto observer,que es el objeto al que se le carga la imagen,en este caso es la lamina, para indicarle a este metodo que el observador es la lamina le pasamos el this,porque como estamos trabajando dentro de la propia clase Lamina,pues se lo indicamos con el this.(v64)


*/

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
                "C:/Users/USER/Desktop/udemy/cursoJava2023-master/Primeros pasos/src/graficos/balon.gif");
        try {
            this.imagen = ImageIO.read(miImagen);
        } catch (IOException e) {

            System.out.println("La imagen no se puede encontrar!");
        }

        // asi capturo el ancho y alto de la imagen si no conozco estos valores
        int anchoImagen = imagen.getWidth(this);
        int altoImagen = imagen.getHeight(this);

        g.drawImage(imagen, 0, 0, null);

        // utilizando copyArea con la imagen del balon dentro de bucles for anidados
        for (int i = 0; i < 500; i++) {

            for (int j = 0; j < 300; j++) {

                g.copyArea(5, 5, anchoImagen, altoImagen, i * anchoImagen, j * altoImagen);

            }
        }

    }

}