/*(v153) ya vimos como leer un archivo con java,ahora veremos como escribir en un archivo desde java.Para escribir en el archivo usamos la clase FileWriter que hereda de la clase Writer.Usamos el primer constructor que pide el archivo,esta clase tambien lanza la excepcion de tipo IOException.

En si lo que haremos con este programa es crear un nuevo archivo con una frase.

El codigo sera parecido al de la lectura de archivos,solo que aqui usamos un bucle for para ir llenando el nuevo archivo caracter a caracter,en la lectura usamos un while.

En este ejercicio creamos un archivo nuevo y le ponemos la frase,porque usamos el constructor que pide solo un argumento que es la ruta a este archivo nuevo,si quisieramos escribir en un archivo existente,usamos el constructor que pide la ruta del archivo y como segundo argumento le ponemos un true,asi escribiriamos sobre un archivo existente.
 */

package escribiendo;

import java.io.*;

public class EscribirArchivo {
    public static void main(String[] args) {

        Escribiendo accedeEscritura = new Escribiendo();
        accedeEscritura.escribir();
    }
}

// clase que sirve para escribir en el archivo externo
class Escribiendo {

    public void escribir() {

        String frase = "Esto es una prueba de escritura!";

        try {
            // aqui le decimos que cree el archivo en la ubicacion indicada
            FileWriter escritura = new FileWriter("C:/Users/USER/Desktop/udemy/archivoNuevo.txt");

            // aqui le indicamos que vaya llenando el archivo con cada caracter de la frase
            // que queremos que escriba
            for (int i = 0; i < frase.length(); i++) {

                escritura.write(frase.charAt(i));
            }

            System.out.println("Archivo nuevo creado con exito!");

            // cerramos el stream
            escritura.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
