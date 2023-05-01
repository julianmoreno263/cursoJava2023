/*(v83) vamos a ver el grid layout,en si es construir una rejilla por medio de filas y columnas dentro de un contenedor, vamos a hacer un ejercicio de crear una calculadora, para esto tendremos dos laminas,una tendra con border layout un boton en la parte de arriba para ser el display,y la otra lamina sera la que tenga la grilla para los botones.
 
Para que el boton se parezca a un display primero lo deshabilitamos con setEnable(false).

Ahora, en la parte central de esta lamina vamos a poner los botones,entonces en el mismo constructor de esta lamina creamos otra lamina y al agregarla le indicamos que ira en la parte central de la primera,podiamos hacer otra clase aparte para esta segunda lamina pero el codigo queda mejor haciendolo en el mismo constructor de la primera instanciando un nuevo objeto de JPanel.Esta lamina es la que tendra el grid layout.

Para crear los botones hacemos un metodo que los vaya creando,asi el codigo es mas sencillo que al hacerlo de la forma normal creando instanciasd e JButton.

---------------------------------------------------------------------------------
(v84)Si queremos que el contenedor(el marco) se adapte al tamaño por defecto que tienen los botones en java,lo hacemos con el metodo pack(), de esta forma ya no sera necesario usar el setBounds().

Ahora,vamos a hacer que cuando pulsemos un boton,se ponga el texto de ese boton en el display,el display es otro boton inactivo,pero aunque este inactivo podemos hacer que se ponga un nuevo texto en ese boton simulando un display,para esto usamos los metodos setText y getText.Para esto debemos hacer una clase que maneje los eventos y poner a la escucha los botones para que cuando se haga click en alguno desencadene un evento y ponga el texto en el display.

Entonces creamos en la lamina una clase interna para esto.

Para poner a la escucha del evento los botones lo hacemos dentro de la misma funcion donde los vamos creando(ponerBoton), para ponerlos a la escucha le pasamos a esta funcion un segundo parametro de tipo ActionListener y usamos el metodo de esa interfaz addActionListener.Asi cuando el usuario pulse un boton,se crea el objeto de tipo oyente,ese objeto viaja y se almacena en este segundo argumento de la funcion y asi cada boton creado estara a la escuha de este objeto oyente.Este objeto oyente solo se le pone a los botones de los numeros para que puedan verse en el display,a los botones de los signos de suma,resta,etc no porque no queremos que al pulsarlos se vean en el display.

NOTA: PARA EDITAR VARIAS LINEAS AL TIEMPO EN VSC ES CON: ALT+BOTON IZQUIERDO DEL MOUSE.

--------------------------------------------------------------------------
(v85) vamos a darle funcionalidad a la calculadora,primero vamos a hacer que cuando queramos hacer una operacion con numeros, el numero que este en el display se quite y se ponga el nuevo numero,osea,cuando vayamos por ejemplo a hacer una suma,2+34,ponemos el 2,y al pulsar el + y escribir el 34 se quite el 2 y nos muestre el 34,asi funcionan las calculadoras.Para esto debemos poner a la escucha los botones de las operaciones,asi que debemos hacer otra clase interna para estos botones.Esta clase interna con la interfaz ActionListener lo unico que tendra sera una linea de codigo que pone la variable principio en true,esto es para que al pulsar un boton de alguna operacion se resetee el display.

Ahora, creamos una variable para ir guardando el resultado de las operaciones,tambien creamos un metodo que en si sera el cerebro del programa,este metodo realizara el calculo de las operaciones,para esto le debo ir pasando por parametro lo que haya en el display,pero como el display muestra es texto y debo calcular con numeros,lo parseo con el metodo parseDouble de la clase Double.

Tambien creamos una variable para ir poniendo la ultima operacion ejecutada por el usuario,porque si el usuario oprime el = debemos mostrar el resultado total.


 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout2 {
    public static void main(String[] args) {

        MarcoCalculadora miMarco = new MarcoCalculadora();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}

// marco
class MarcoCalculadora extends JFrame {

    public MarcoCalculadora() {

        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);

        LaminaDisplay miLamina = new LaminaDisplay();
        add(miLamina);

    }

}

// lamina para el display
class LaminaDisplay extends JPanel {

    private JPanel miLamina2;
    private JButton pantalla;
    private boolean principio;
    private double resultado;
    private String ultimaOperacion = "=";

    public LaminaDisplay() {

        principio = true;

        setLayout(new BorderLayout());
        pantalla = new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla, BorderLayout.NORTH);

        // creamos el objeto de tipo ActionListener para el oyente de los botones
        // numericos
        java.awt.event.ActionListener insertar = new InsertaNumero();

        // creamos el objeto de tipo ActionListener para el oyente de los botones de las
        // operaciones
        java.awt.event.ActionListener orden = new AccionOrden();

        // segunda lamina para los botones,con el metodo ponerBoton creamos cada
        // boton,tener en cuenta que los botones se van agregando por filas.
        miLamina2 = new JPanel();
        miLamina2.setLayout(new GridLayout(4, 4));
        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBoton("/", orden);
        ponerBoton("4", insertar);
        ponerBoton("5", insertar);
        ponerBoton("6", insertar);
        ponerBoton("*", orden);
        ponerBoton("1", insertar);
        ponerBoton("2", insertar);
        ponerBoton("3", insertar);
        ponerBoton("-", orden);
        ponerBoton("0", insertar);
        ponerBoton(".", insertar);
        ponerBoton("=", orden);
        ponerBoton("+", orden);

        // agregamos esta lamina ala parte central de la primera
        add(miLamina2, BorderLayout.CENTER);

    }

    // funcion para agregar los botones en la segunda lamina y ponerlos a la escucha
    // del evento
    public void ponerBoton(String rotulo, java.awt.event.ActionListener oyente) {

        JButton boton = new JButton(rotulo);
        boton.addActionListener(oyente);
        miLamina2.add(boton);
    }

    // clase interna que maneja los eventos para los botones numericos
    private class InsertaNumero implements java.awt.event.ActionListener {

        public void actionPerformed(ActionEvent e) {

            // capturamos el texto del boton pulsado y lo ponemos en el display,en setText
            // debemos indicar que al texto que tenga el display le ponga a continuacion el
            // nuevo texto de entrada y no que lo reemplace,porque en una calculadora al ir
            // oprimiendo botones de numeros,esos nuemros van apareciendo en el display uno
            // despues del otro,no se reemplazan.
            String entrada = e.getActionCommand();

            // codigo para que si el boton pulsado es el primero en pulsarse,pues borre el
            // cero del display y comience a poner los numeros,para que principio sea true y
            // se pueda ejecutar este if lo ponemos en true en el constructor de la
            // lamina,como este constructor se ejecuta al iniciar el programa entonces le
            // decimos que principio es true porque es la primera vez que se ejecuta y entra
            // en el if y pone el display en blanco,se quita el cero inicial,si no es la
            // primera vez que se ejecuta no hay necesidad de usar este
            // if y los numeros se van poniendo uno despues del otro.Recordar que al
            // declarar una variable booleana,si no se inicia,esta se pone en false por
            // defecto.
            if (principio) {
                pantalla.setText(" ");
                principio = false;
            }

            pantalla.setText(pantalla.getText() + entrada);

        }
    }

    // clase interna que maneja los eventos para los botones de las operaciones
    private class AccionOrden implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // variable para guardar la operacion que el usuario pulso
            String operacion = e.getActionCommand();

            calcular(Double.parseDouble(pantalla.getText()));

            ultimaOperacion = operacion;

            principio = true;
        }

        public void calcular(double x) {

            if (ultimaOperacion.equals("+")) {

                resultado += x;

            } else if (ultimaOperacion.equals("-")) {

                resultado -= x;
            } else if (ultimaOperacion.equals("*")) {

                resultado *= x;
            } else if (ultimaOperacion.equals("/")) {

                resultado /= x;
            } else if (ultimaOperacion.equals("=")) {

                resultado = x;
            }

            // le ponemos el string "" para concatenarlo con la variable resultado y que no
            // me de error,porque el metodo setText espera un string y si le ponemos
            // resultado solo(el cual es un double) saca error,por eso lo concatenamos con
            // un string.
            pantalla.setText("" + resultado);
        }

    }

}
