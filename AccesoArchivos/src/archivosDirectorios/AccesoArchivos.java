
package archivosDirectorios;

import java.io.*;

public class AccesoArchivos {
    public static void main(String[] args) {

        File ruta = new File("C:/Users/USER/Desktop/udemy/cursoJava2023-master");

        System.out.println(ruta.getAbsolutePath());

        // aqui almaceno en un array los nombres de lo que haya en la carpeta que quiero
        // explorar y luego lo recorro con un foreach,debe ser un array porque al
        // utilizar el metodo list() este devuelve un array.
        String nombresArchivos[] = ruta.list();

        for (String nombre : nombresArchivos) {

            System.out.println(nombre);
        }

    }
}
