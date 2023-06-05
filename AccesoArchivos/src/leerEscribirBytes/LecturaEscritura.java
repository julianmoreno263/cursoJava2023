/*(v155) vamos a ver ahora stream de bytes, con este tipo de stream podemos acceder a cualquier tipo de archivo porque en informatica un archivo(llamese pdf,imagen,powerpoint,etc) en si es una sucesion de bytes.

Para leer con un stream byte un archivo utilizamos la clase FileInputStream y su metodo read() y para escribir utilizamos FileOutputStream y su clase write(),al final ambas cierran el stream con close().

Vamos en este mismo archivo a leer una imagen y despues la copiamos(escribimos) en otra carpeta.

1- importamos java.io

2- creamos la instancia de la clase FileInputStream,la cual lanza una excepcion,asi que la ponemos en un try-catch.

3- este programa va a imprimir los bytes de la imagen.

4-podemos imprimir cuantas lineas tiene nuestro archivo(la imagen) utilizando un contador.Mi imagen tiene 9105 bytes,ahora, si tomamos estos bytes y los usamos para escribir,se supone que deberia sacarnos una imagen igual a la que estamos leyendo.

5-entonces para poder escribir,osea hacer una copia de la imagen,creamos un array especificando el numero de posiciones que debe tener,osea lo que nos arroja la variable contador,y este array despues lo volcamos en una ruta donde queramos que aparezca la imagen copiada.Con un if vamos diciendole que vaya almacenando los bytes en el array sin el -1,el -1 no es un byte,solo es la forma en que read tiene para indicar que ha finalizado la lectura.

6- entonces el codigo queda dividido en dos partes,en el primer try se lee un archivo y los bytes del archivo se van guardando en un array, y la segunda parte es para con esos datos guardados en el array,cremos una funcion que tomara el array y creara la coia del archivo(escribira),para leer usamos la clase FileInputStream,y para escribir debemos usar la clase FileOutputStream.Vamos a crear esta copia de la imagen en la misma carpeta de la original.

7- este metodo de crear la copia se debe llamar al final del primer try-catch porque primero se debe de haber guardado los bytes en el array para poder tenerlos y crear la coia,y esto se hace en el primer try-catch, alli llamamos esta funcion y le pasamos como parametro ese array.Al ejecutar el programa debe leer el archivo y a la vez me crea la copia de esa imagen en la ruta especificada.

 */

package leerEscribirBytes;

import java.io.*;

public class LecturaEscritura {
    public static void main(String[] args) {

        int contador = 0;
        int datosEntrada[] = new int[9105];

        // leemos nuestra imagen,todo este codigo del try es para leer los bytes de la
        // imagen y guardarlos en un array para despues coger ese array y copiar los
        // bytes(leerlos) para hacer una copia de la imagen en otro destino que
        // queramos.
        try {

            // creamos el stream
            FileInputStream archivoLectura = new FileInputStream("img pruebas/php.png");

            // vamos leyendo el archivo,read va leyendo byte a byte el archivo,osea la
            // imagen,almacenamos esto en una variable int porque cuando termine de
            // leer,read retorna un -1.
            boolean finalArchivo = false;
            while (!finalArchivo) {

                int byteEntrada = archivoLectura.read();

                // linde icamos que si termina de leer todo(osea saca un -1) ponga la variable
                // archivoEntrada a true, y vaya imprimiendo lo que va leyendo,osea
                // byteEntradaen el caso de que este solo leyendo,pero si va a escribir,debera
                // ir almacenando los bytes en el array que creamos,menos el dato de -1.Despues
                // le indicamos que imprima la posicion del array.
                if (byteEntrada != -1) {

                    datosEntrada[contador] = byteEntrada;
                } else {
                    finalArchivo = true;

                }

                System.out.println(datosEntrada[contador]);

                contador++;

                System.out.println(contador);

            }

            // cerramos el stream
            archivoLectura.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al acceder a la imagen!");
        }

        // aqui llamamos al metodo que crea la copia de la imagen y le pasamos el array
        creaArchivo(datosEntrada);
    }

    // aqui creo el metodo que escribira la copia de la imagen,recibe por parametro
    // un array
    static void creaArchivo(int datosArchivoNuevo[]) {

        try {

            FileOutputStream nuevoArchivo = new FileOutputStream("img pruebas/php-copia.png");

            // leemos el array con un bucle for
            for (int i = 0; i < datosArchivoNuevo.length; i++) {

                nuevoArchivo.write(datosArchivoNuevo[i]);
            }

            nuevoArchivo.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al crear el archivo!");

        }
    }
}
