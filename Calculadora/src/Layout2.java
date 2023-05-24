package src;

/*(v137) Vamos a ver como se empaqueta una app de java para poder distribuirla por red de forma mas facil,una app generalmente esta echa de varios archivos,por lo que para enviarla por red es mejor empaquetarla,osea comprimirla en un archivo con extension .jar y asi se puede enviar mas facil por red.Para esto se empaqueta todo el proyecto.

NOTA: recordar que para generar un nuevo proyecto en vsc y que este genere automaticamente las carpetas de lib, bin y src, damos CTRL+SHIFT+P y se abre la paleta de comandos, alli escribimos Java: Create Java Project. Nos pedira elegir en que carpeta queremos crear el proyecto, luego al crearse el proyecto y darle un nombre veremos que ya se crean automaticamente todas sus carpetas con la clase main dentro de src.Podemos crear en src una carpeta nueva para que sea el paquete del proyecto y asi ordenar mejor los archivos,en este paquete podemos pasar la clase main App.java que se genera y a partir de alli comenzar a trabajar,todo esto para ordenar mejor los archivos.Apenas se compila la aplicacion,automaticamente se generan los archivos .class dentro de bin,estos archivos .class se crean uno por cada clase que haya en la aplicacion,asi sea una clase interna.Los paquetes son necesarios si van a aver varios archivos,aqui solo hay uno entonces no creamos el paquete.

EN VSC PARA GENERAR EL ARCHIVO .JAR VOY AL PANEL IZQUIERDO ABAJO,JAVA PROJECTS Y DOY CLICK EN LA FLECHA -> QUE INDICA EXPORT JAR Y HAY ME PREGUNTA CUAL ES LA CLASE MAIN DEL PROYECTO,LA SELECCIONO Y LISTO,GENERA EL ARCHIVO.

se genera un archivo .jar,este se puede descomprimir como un archivo zip,simplemente se da click derecho y se elige donde extraer los archivos,apareceran archivos .class.

------------------------------------------------------------
(v138) vamos a ver como se firman digitalmente los archivos .jar que enviamos hacia la red, la firma de archivos es una medidad de seguridad que le indica al usuario que va a recibir nuestro programa java que este es confiable,a veces el programa en java para ejecutarse debe poder acceder a archivos del ordenador del usuario donde va a correr, por defecto el archivo .jar no tiene permisoso para acceder a recursos de los pcs donde se va a ejecutar por seguridad,asi que nosotros como programadores debemos firmar los archivos .jar que enviamos para que los usuarios sepan que es confiable,esto lo hacemos con una firma digital la cual en principio tiene informacion sobre nombre del programador,organizacion,departamento,ciudad,pais.

Para firmar el .jar se necesitan dos cosas:

1- Crear la firma digital con la herramienta keytool.
2- Firmar la aplicacion .jar con el certificado generado,esto lo hacemos con la herramienta jarsigner.

Estas dos herramientas vienen dentro del jdk. Para ver como firmar una aplicacion vamos a crear un nuevo proyecto y lo transformamos en un applet,sera una aplicacion que acceda a imagenes.


 */

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
