/*(v159) vamos a ver como poder manipular archivos y carpetas de nuestro pc con java, para esto java tiene varias clases y metodos,trabajaremos inicialmente con la clase File la cual tiene sobrecarga de constructores y varios metodos.Comenzaremos a usar los metodos getAbsolutePath() y exists() para manipular los archivos y carpetas de nuestro pc.

1-importamos el paquete java.io porque la clase File pertenece a este paquete.

2- vamos a usar el metodo getAbsolutePath para que nos muestre la ruta de un archivo(el cual no existe,solo lo nombramos para el ejercicio), cuando a este metodo no le especificamos una carpeta,toma por defecto la carpeta del proyecto,osea toma como ruta inicial la carpeta del proyecto donde nos encontramos. Tambien para esto usamos el constructor de File que pide como parametro la ruta de ese archivo.

3-si queremos saber si ese archivo existe,usamos el metodo exist() el cual nos devuelve un boolean.Si ponemos la ruta de un archivo o carpeta que si exista,por ejemplo la carpeta lib,nos saldra true.

Ahora,si queremos explorar una carpeta especifica y ver su contenido,usamos nuevamente la clase File y usamos el metodo list(), este metodo devuelve un array con los nombres de los archivos y subcarpetas que puedan haber en esta carpeta que queremos explorar.Vamos a hacer esta prueba en el archivo AccesoArchivos.java y explorar una carpeta.

 */

package archivosDirectorios;

import java.io.*;

public class PruebasRutas {
    public static void main(String[] args) {

        File archivo = new File("AccesoArchivos/lib");

        System.out.println(archivo.getAbsolutePath());
        System.out.println(archivo.exists());
    }
}
