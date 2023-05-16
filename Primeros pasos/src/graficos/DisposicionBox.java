/*(v115) vamos a ver otros layouts que son mas flexibles que los que hemos visto hasta ahora,el primero es un layout en caja o box,el cual utiliza la clase Box y tiene varios metodos para poner los elementos horizontalemnete o verticalmente y con espacios entre ellos,cuando por ejemplo ponemos un frame tipo box en horizontal,los elementos se van poniendo uno al lado del otro,si se acaba el espacio y seguimos poniendo mas elementos estos no se ven porque de todas formas se siguen poniendo uno al lado del otro,toca expandir el marco para ver los demas elementos.

si tenemos un marco,podemos crear una caja vertical box, y dentro de esta podemos poner cajas horizontales o verticales si queremos.Vamos a crear una disposicion de box y a poner varias cajas en un marco,cada caja tendra un texto y un cuadro de texto para hacer un login.

1-en el constructor del marco creamos los label y cuadros de texto.


 */

package graficos;

import javax.swing.*;
import java.awt.*;

public class DisposicionBox {
    public static void main(String[] args) {

        MarcoBox miMarco = new MarcoBox();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// frame
class MarcoBox extends JFrame {

    public MarcoBox() {
        setTitle("Disposición Box");
        setBounds(300, 250, 400, 350);

        // ----------- labels y cuadros de texto para el nombre
        JLabel rotulo1 = new JLabel("Nombre");
        JTextField nombre = new JTextField(10);
        nombre.setMaximumSize(nombre.getPreferredSize());
        // creamos una caja horizontal y le adicionamos el label y el cuadro de
        // texto,ponemos un espacio entre ambos elementos con createHorizontalStrut()
        Box cajaH1 = Box.createHorizontalBox();
        cajaH1.add(rotulo1);
        cajaH1.add(Box.createHorizontalStrut(10));
        cajaH1.add(nombre);

        // ------------ labels y cuadros de texto para el password
        JLabel rotulo2 = new JLabel("Password");
        JTextField password = new JTextField(10);
        password.setMaximumSize(password.getPreferredSize());
        Box cajaH2 = Box.createHorizontalBox();
        cajaH2.add(rotulo2);
        cajaH2.add(Box.createHorizontalStrut(10));
        cajaH2.add(password);

        // ------------ botones de ok y cancelar,utilizamos createGlue para que cree un
        // espacio automatico al redimensionar
        JButton ok = new JButton("Ok");
        JButton cancelar = new JButton("Cancelar");
        Box cajaH3 = Box.createHorizontalBox();
        cajaH3.add(ok);
        cajaH3.add(Box.createGlue());
        cajaH3.add(cancelar);

        // -----creamos la caja padre box vertical y metemos alli las otras cajas hijas
        Box verticalPadre = Box.createVerticalBox();
        verticalPadre.add(cajaH1);
        verticalPadre.add(cajaH2);
        verticalPadre.add(cajaH3);

        // -- por ultimo agregamos esta caja padre al marco,y al agregarla podemos darle
        // un border layout.
        add(verticalPadre, BorderLayout.CENTER);

        setVisible(true);
    }
}