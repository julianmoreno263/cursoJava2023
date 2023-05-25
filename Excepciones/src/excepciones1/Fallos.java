
/*(v142) vamos a ver las excepciones y su manejo,el manejo de errores. Hay dos clases de errores,los de sintaxis y los de logica, Java maneja los errores desde la clase Throwable,de esta clase s edesprenden dos mas,la clase Error y Excepcion,de la clase Excepcion se desprenden las clases IOExcepcion y RuntimeExcepcion, IOExcepcion maneja errores que no son culpa del programador(excepciones comprobadas),por ejemplo alguien borro un archivo que se necesita para que la aplicacion funcione,etc y RuntimeExcepcion maneja errores que si son culpa del programador(excepciones no comprobadas),por ejemplo tratar de recorrer una posicion de un array que no existe. Recordar que todo en java es un objeto,asi que cuando se produce un error,se esta creando un objeto de ese tipo de error. 

vamos a hacer este archivo que contiene dos partes,la creacion y recorrido de una matriz y la otra es la creacion de una ventana emergente que pide el nombre y la edad y la imprimimos.

NOTA: SI CREO UN PROYECTO Y ME SALE QUE EL ARCHIVO NO ESTA EN LA CLASSPATH DEL PROYECTO,LO SOLUCIONO DANDO CLICK DERECHO EN LA CARPETA src Y ELIJO LA OPCION DE Add Folder to Java Source Path, Y LISTO.

Entonces este archivo es solo para practicar el tipo de errores que pueden salir,por ejemplo si olvidamos en java un punto y coma,saldra un error en tiempo de compilacion,osea el programa ni siquiera se ejecuta.Tambien si intentamos recorrer el array y ponemos un indice mas del que le estipulamos,saltara un error de logica,tampoco se ejecutara el programa.

Para el tipo de excepciones de IOexcepcion, java nos obliga a crear el bloque try-catch para manejar este tipo de errores,java los tiene implementados y sabe cuando se deben de capturar,en vsc o eclipse nos ayuda porque nos sale las advertencias para manejar estos errores.


*/

package excepciones1;

import javax.swing.*;

public class Fallos {
    public static void main(String[] args) {

        int miArray[] = new int[5];

        miArray[0] = 5;
        miArray[1] = 38;
        miArray[2] = 72;
        miArray[3] = 91;
        miArray[4] = 23;

        for (int i = 0; i < miArray[5]; i++) {

            System.out.println("Posición " + i + " = " + miArray[i]);
        }

        // Petición de datos personales
        String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad"));

        System.out.println("Tu nombre es " + nombre + " y tu edad es " + edad + " años. Fin del programa");

    }
}
