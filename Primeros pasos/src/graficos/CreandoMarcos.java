/*vamos a comenzar a ver aplicaciones graficas con el paquete swing,que es el paquete que tiene las clases para crear ventanas,etc en java.Este paquete se encuentra en la libreria javax.swing por lo que toca primero importarlo.Antes de la version 1.2 se utilizaba el paquete AWT para crear graficos pero no eran ventanas estandarizadas porque este paquete dejaba que el S.O en donde se implementaban fuera el que creara el comportamineto y estilo de los graficos,y no era acorde a la filosofia de java de "escribir una sola vez y correr en cualquier parte", por lo que a partir de la version 1.2 aparecio swing y este introdujo la creacion de un frame en donde se va creando el gráfico correspondiente. 

Para empezar,debemos crear un frame,esto lo hacemos con la clase JFrame del paquete swing, si vemos la API veremos que esta clase tiene una cadena de herencia larga,lo que la hace muy especializada y con una gran cantidad de metodos y herramientas para crear ventanas.

Por defecto las ventanas creadas con JFrame no aparecen visibles y no tienen tamaño,por lo que se les debe dar estas caracteristicas usando los metodos setVisible y setSize.Creada la clase para el marco,la instanciamos desde la clase main.

Por ultimo debemos decirle a la ventana que tiene que hacer cuando se cierre,esto lo hacemos con el metodo setDefaulClosetOperation(JFrame.EXIT_ON_CLOSE),el metodo setDefault recibe como parametro un int,si vemos la API lo veremos,ponemos exit_on_close porque si vemos esta es una constante de clase,en la API la describen,y esta constante es static,por lo que debemos utilizar la clase a la que pertenece(JFrame),y esta constante tiene un valor entero que e s1.3,por eso se pone,y lo que indica es que cierre la aplicacion,o termine la operacion del programa.

----------------------------------------------------------------------------------------
(v56) ahora vamos a ver como abrir la ventana pero en una ubicacion diferente a la que sale por defecto(que es la esquina superior izquierda),y tambien como cambiar el icono y ponerle un titulo.Como la clase FJframe hereda de muchas otras clases,ya tiene varios metodos para cambiar la posicion de un frame,ponerle un icono,redimensionar la ventana,etc.(ver API). setLocation usa el plano cartesiano para posicionar el frame,donde el punto 0,0 sera la esquina superior izquierda de la pantalla y a apartir de alli podemos posicionar el frame usando numeros positivod(ver video). setBounds hace todo de una vez,da posicion y tamaño. setResizable permite o no redimensionar la pantalla,osea que se pueda agrandar con el puntero del mouse. setExtendedState(Frame.MAXIMIZED_BOTH) permite que al abrir el frame salga del tamaño completo de la pantalla,usa como parametros MAXIMIZED_BOTH de la clase Frame.

----------------------------------------------------------------------------------------------

*/

package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {
    public static void main(String[] args) {

        // instanciamos la clase miMarco(creamos un objeto de miMarco)
        miMarco miMarco1 = new miMarco();
        miMarco1.setVisible(true);
        miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// creamos la clase para el marco la cual debeheredar de la clase JFrame
class miMarco extends JFrame {

    // constructor
    public miMarco() {
        // setSize(500, 300);
        // setLocation(500, 300);

        setBounds(500, 300, 550, 250);
        setResizable(false);
        // setExtendedState(Frame.MAXIMIZED_BOTH);
        setTitle("MI VENTANA JAVA");
    }

}
