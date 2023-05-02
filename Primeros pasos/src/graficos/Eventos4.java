/* (v70) vamops a ver como manejar los cambios de estado de las ventanas, con cambios de estado nos referimos por ejemplo que una ventana esta abierta y cuando se minimiza pues cambia su estado,y con este cambio podemos programar que se ejecute alguna accion como un mensaje en consola,etc.

Para manejar el cambio de estado en ventanas debemos utilizar la interfaz WindowStateListener la cual solo tiene un metodo llamado windowStateChanged(WindowEvent e) este metodo recibe un objeto de clase tipo WindowEvent, esta clase WindowEvent tiene dos metodos que nos sirven para capturar el estado antiguo de la ventana y el nuevo estado cuando se produce el cambio.

Vamos primero a hacer un marco sencillo,y con una clase manejaremos el cambio de estado de este marco,esta clase implementara la interfaz WindowStateListener,en si el estado cambia cuando se realiza una accion en el elemento,en este caso el marco.Ver API para ver la interfaz y su metodo.

Para poner a la escucha el objeto de la clase que maneja el estado se usa el metodo addWindowStateListener()

Ahora, para usar los metodos getNewSate y getOldSate y ver los estados nuevos y anteriores debo ver la API y profundizar en ella,osea recorrerla hasta obtener los valores de las constantes de clase que me arrojara cada estado de estos metodos,si voy a la PI y veo el metodo getOldState,vere que me dice que hay 5 valores posibles para los estados, normal,iconified,maximized_horiz,etc, y en si estos son constantes de clase que tienen un valor entero(ver API), al usar este metodo,segun el cambio que se detecte en el frame, nos devolvera un entero,por ejemplo maximizar la ventana nos devuelve un 6,etc.Con esto podemos programa por ejemplo que nos salga un mensaje si la pantalla se maximiza.Para manejar mas claramente estos valores de estados podemos en vez de los numeros manejar los nombres de las constantes utilizando antes la clase Frame,porque son campos de clase static.

Como estos metodos pertenecen a la clase WindowEvent pues utilizo el objeto e para poder invocarlos.




 */

package graficos;

import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.event.*;

public class Eventos4 {
    public static void main(String[] args) {
        MarcoEstado miMarco = new MarcoEstado();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoEstado extends JFrame {

    public MarcoEstado() {
        setVisible(true);
        setBounds(450, 300, 500, 300);

        // creamos y ponemos a la escucha el objeto que manejara el estado
        CambioEstado nuevoEstado = new CambioEstado();
        addWindowStateListener(nuevoEstado);
    }
}

// clase oyente que maneja el estado
class CambioEstado implements WindowStateListener {

    public void windowStateChanged(WindowEvent e) {
        System.out.println("La ventana ha cambiado de estado!");

        // utilizando los metodos getOldState y getNewState para ver los eventos
        // System.out.println(e.getNewState());
        if (e.getNewState() == Frame.MAXIMIZED_BOTH) {
            System.out.println("La pantalla se maximizo!");
        } else if (e.getNewState() == Frame.NORMAL) {
            System.out.println("La ventana está a tamaño normal");
        } else if (e.getNewState() == Frame.ICONIFIED) {
            System.out.println("La ventana está minimizada");
        }
    }

}