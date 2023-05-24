/*(v138) vamos a ver como se firman digitalmente los archivos .jar que enviamos hacia la red, la firma de archivos es una medidad de seguridad que le indica al usuario que va a recibir nuestro programa java que este es confiable,a veces el programa en java para ejecutarse debe poder acceder a archivos del ordenador del usuario donde va a correr, por defecto el archivo .jar no tiene permisoso para acceder a recursos de los pcs donde se va a ejecutar por seguridad,asi que nosotros como programadores debemos firmar los archivos .jar que enviamos para que los usuarios sepan que es confiable,esto lo hacemos con una firma digital la cual en principio tiene informacion sobre nombre del programador,organizacion,departamento,ciudad,pais.

Para firmar el .jar se necesitan dos cosas:

1- Crear la firma digital con la herramienta keytool.
2- Firmar la aplicacion .jar con el certificado generado,esto lo hacemos con la herramienta jarsigner.

Estas dos herramientas vienen dentro del jdk. Para ver como firmar una aplicacion vamos a crear un nuevo proyecto y sera una aplicacion que muestre una imagen en una lamina,luego la empaquetamos y vemos como se firma para poder enviar ese paquete a un correo, no cree un applet como en el video porque estos estan descontinuados desde jdk9 y yo tengo la ultima version,voy a ver si asi me sale.

 */

import javax.swing.*;
import java.awt.*;

public class ImagenMultimedia {

    public static void main(String[] args) {

        MarcoIcono miMarco = new MarcoIcono();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

// frame
class MarcoIcono extends JFrame {

    public MarcoIcono() {

        setTitle("Icono");
        setBounds(300, 250, 550, 350);

        LaminaIcono miLamina = new LaminaIcono();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaIcono extends JPanel {

    Image icono;

    public void paint(Graphics g) {

        super.paintComponent(g);

        icono = new ImageIcon("bin/logo.jpg").getImage();
        g.drawImage(icono, 50, 50, LaminaIcono.this);

    }

}