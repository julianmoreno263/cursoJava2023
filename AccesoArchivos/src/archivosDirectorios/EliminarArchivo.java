/*(v160) ejercicio para eliminar un archivo de nuestra pc usando java, tomamos la ruta del archivo que queremos eliminar y uso el metodo delete() de File.  */

package archivosDirectorios;

import java.io.*;

public class EliminarArchivo {
    public static void main(String[] args) {

        File ruta = new File("C:/Users/USER/Desktop/cursoJava2023-master/nuevaCarpeta/nuevoArchivo.txt".replace("\\",
                File.separator));

        // eliminamos el archivo
        ruta.delete();
    }
}
