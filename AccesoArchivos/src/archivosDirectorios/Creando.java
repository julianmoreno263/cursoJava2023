/*(v160) vamos a ver como crear carpetas y archivos con java en nuestro pc.Vamos a crear una nueva carpeta en nuestra carpeta del curso.


Entonces en nuestra ruta nombramos a esa carpeta que queremos crear,y utilizamos la funcion mkdir de File para crear una carpeta,este metodo nos devuelve un boolean.

Si queremos crear un nuevo archivo hacemos lo mismo,lo nombramos en la ruta y utilizamos el metodo createNewFile(),este lanza una excepcion IOException,por lo que toca poner el try-catch.


 */

package archivosDirectorios;

import java.io.*;

public class Creando {
    public static void main(String[] args) {

        // ruta con el nombre de la nueva carpeta a crear
        File ruta = new File("C:/Users/USER/Desktop/cursoJava2023-master/nuevaCarpeta/nuevoArchivo.txt".replace("\\",
                File.separator));

        // aqui con mkdir creamos esa nueva carpeta
        // ruta.mkdir();

        // aqui creamos un nuevo archivo con createNewFile().
        try {
            ruta.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
