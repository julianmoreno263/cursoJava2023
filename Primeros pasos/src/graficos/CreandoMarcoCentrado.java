/* (v57) clase Toolkit, sirve para poder comunicarnos con el sistema operativo en el que estemos trabajando y manipular las ventanas de dicho sistema, tiene varios metodos para esto,hay metodos para obtener el tamaño de la pantalla y asi poder posicionar nuestros frames de acuerdo a esa pantalla. 

vamos a crear un frame que aparezca centrado en nuestra pantalla,y para eso debemos utilizar la clase Toolkit para poder usar los metodos que nos permitan saber la resolucion de nuestra pantalla.Y sabiendo el tamaño real de mi pantalla dibujaremos un frame que sea de la mitad de mi pantalla.
 
Por ultimo para poner un icono diferente al default,uso la clase Image con su metodo getImage() y setIconImage()


 */

package graficos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.*;

public class CreandoMarcoCentrado {
    public static void main(String[] args) {

        MarcoCentrado miMarco = new MarcoCentrado();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}

class MarcoCentrado extends JFrame {

    // constructor
    public MarcoCentrado() {

        // objeto de tipo Toolkit, para el tamaño debemos crear un objeto de tipo
        // Dimension(de clase Dimension) para poder usar el metodo getScreenSize(), ver
        // API.Despues para obtener el ancho y alto de mi pantalla usamos los campos de
        // la clase Dimension width y height.
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();

        // capturo los valores de mi pantalla
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;

        // establezco el tamaño de mi marco a la mitad de mi pantalla y lo pongo a 1/4
        // de x y de y para su ubicacion
        setSize(anchoPantalla / 2, alturaPantalla / 2);
        setLocation(anchoPantalla / 4, alturaPantalla / 4);
        setTitle("Marco Centrado Java");
        Image miIcono = miPantalla.getImage("icono2.jpg");
        setIconImage(miIcono);

    }
}