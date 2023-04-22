/*(v68) vamos a ver eventos de ventana, para trabajar con estos eventos el objeto listener debera implementar la interfaz WindowListener la cual cuenta con varios metodos(7 en total), por esto es un poco mas complicado porque tiene mas metodos y deben ser implementados.Estos metodos necesitan como parametro el objeto ( WindowEvent e ). Mas adelante veremos que hay una forma de implementar solo el metodo que necesitemos y nada mas,pero en principio vamos a implemnetar(o al menos declarar) todos los metodos.

1-Vamos en principio a crear un marco y con este marco veremos los eventos de ventana,por ejemplo que al minimizar el marco aparezca un mensaje en la consola,etc.

2- creamos la clase oyente que sera la que implementara la interfaz WindowLiostener,debemos en principio declarar todos los metodos aunque solo usaremos el windowIconified() que es para cuando se minimiza la ventana.

3- ahora en el frame creamos el objeto oyente y lo ponemos a la escucha de los eventos con addWindowListener,igual que con addEventListener.Listo, cuando corramos el programa y minimizemos la ventana debe aparecer el mensaje en consola.Podemos usar los otros metodos y que aparezcan mensajes dependiendo lo que hagan.

4- si quiero hacer mas de un marco,debo darles su propio titulo,tamaño y posicion,porque como hasta ahora hay un solo constructor,se crearian los marcos con igual posicion y aparecerian uno encima del otro, ademas si queremos cerrar una ventana pero que la otra no se cierre debemos utilizar la constante de clase DISPOSE_ON_CLOSE de JFrame en aquella ventana que queremos cerrar y asi la otra seguira abierta.

-------------------------------------------------------------------
(v69) ahora, WindowEvent es la interfaz que se dbe implementar y esta tiene muchos metodos,pero en si a veces solo se utilizan si acaso 3, para no tener que implementar todos los metodos de una interfaz podemos utilizar las clases adaptadoras, hay tres clases llamadas:

1- KeyAdapter
2-WindowAdapter
3-MouseAdapter

estas clases implemnetan sus propias interfaces,por ahora solo vamos a ver WindowAdapter la cual tiene las interfaces:

1- WindowFocusListener
2- WindowStateListener
3- WindowListener
4- EventListener

ahora, si solo queremos trabajar con un metodo especifico para los eventos de ventana, pues utilizamos la clase adaptadora WindowAdapter la cual ya tiene implementados estos metodos por sus interfaces,entonces en la clase oyente de nuestro programa simplemente le decimos que herede WindowAdapter y asi ya podemos utilizar ese metodo especifico sin necesidad d eimplementarlos uno a uno,es como una clase puente o un truco que se creo en java para escribir menos codigo.Entonces en vez de que la clase oyente implemnete la interfaz WindowListener,le decimos que herede mejor la clase WindowAdapter.

Puedo minimizar mas el codigo al poner a la escucha el objeto oyente si en el metodo addWindowListener creo el objeto de una vez,poniendo new Mventana().



*/

package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos3 {
    public static void main(String[] args) {

        MarcoEventos3 miMarco = new MarcoEventos3();
        miMarco.setTitle("Ventana 1");
        miMarco.setBounds(100, 300, 500, 300);
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creamos un segundo marco
        MarcoEventos3 miMarco2 = new MarcoEventos3();
        miMarco2.setTitle("Ventana 2");
        miMarco2.setBounds(650, 300, 500, 300);
        miMarco2.setVisible(true);
        miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

// marco
class MarcoEventos3 extends JFrame {

    public MarcoEventos3() {

        // setTitle("Eventos de ventana");
        // setBounds(450, 300, 500, 300);

        // aqui creo el objeto oyente y lo pongo a la escucha al mismo tiempo.
        addWindowListener(new Mventana());

    }

}

// clase oyente implementando la clase adaptadora WindowAdapter
class Mventana extends WindowAdapter {

    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana minimizada!");
    }
}

// clase oyente implementando interfaz WindowListener
// class Mventana implements WindowListener {

// public void windowActivated(WindowEvent e) {
// System.out.println("Ventana activada!");
// };

// public void windowClosed(WindowEvent e) {
// System.out.println("La ventana se cerró!");
// };

// public void windowClosing(WindowEvent e) {
// System.out.println("Cerrando ventana!");
// };

// public void windowDeactivated(WindowEvent e) {
// System.out.println("Ventana desactivada!");
// };

// public void windowDeiconified(WindowEvent e) {
// System.out.println("Ventana restaurada!");
// };

// public void windowIconified(WindowEvent e) {
// System.out.println("Ventana minimizada");
// };

// public void windowOpened(WindowEvent e) {
// System.out.println("Ventana abierta!");
// };

// }
