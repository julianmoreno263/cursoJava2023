/*(v152) vamos a ver las secuencias o streams en java, o flujos de datos sirven para  varios propositos por ejemplo para enviar informacion a traves de la red,tambien para acceder a archivos de nuestro pc desde nuestros programas java. Hay dos formas de acceder a los archivos con los streams, con streams de bytes o streams de caracteres, los primeros sirven cuando vamos a enviar informacion desde nuestro programa java a traves de la red, y con streams de caracteres cuando vamos a acceder a un archivo para leerlo o editarlo.

Si vamos a trabajar con streams de bytes debemos usar las clases abstractas InputStream o OutputStream del paquete java.io, y si vamos a trabajar con stremas de caracteres debemos usar las clases abstractas Reader o Writer. Para estos ejercicios trabajaremos con streams de caracteres para acceder a un archivo .txt que creamos en el escritorio con el bloc de notas y que solo tiene una frase simple,es importante saber donde tenemos el archivo al que queremos acceder.Lo primero sera importar el paquete java.io de donde vienen las clases que necesitamos.
 */

package leyendo;

import java.io.*;

public class AccesoArchivo {
    public static void main(String[] args) {

        // aqui en el main creamos una instancia de la clase que lee el archivo y
        // ejecutamos el metodo leer()
        LeerArchivo accediendo = new LeerArchivo();
        accediendo.leer();

    }
}

// clase que hara el trabajo para acceder al archivo .txt, como lo que queremos
// hacer primero es leerlo debemos usar la clase Reader.Esta clase tiene varias
// subclases,entre ellas InputStreamReader la cual a su vez tiene la subclase
// FileReader que es la que nos sirve para ubicar el archivo que queremos
// leer.Esta clase tiene sobrecarga de constructores,utilizaremos el primero que
// pide el archivo en si, si vemos esta clase lanza una excepcion de tipo
// FileNotFoundException si el archivo no existe o no se encuentra u otra
// razon, esta excepcion si la vemos hereda de IOException por lo que estamos
// obligados a usar el try-catch para capturarla.(ver API).

// ahora con el metodo read() de la clase InputStreamReader leemos el archivo,en
// la descripcion de este metodo nos dicen que va leyendo los caracteres uno a
// uno y va sacando el codigo de cada caracter,al finalizar la lectura retorna
// un -1.Tambien lanza una excepcion IOException por lo que debe estar dentro de
// un try-catch.Como ya capturamos una excepcion en el try catch,y ambas son de
// tipo IOException podemos capturar una excepcion mas general,osea la propia
// IOException.
class LeerArchivo {

    public void leer() {

        // usamos try-catch para capturar el posible error
        try {

            // capturamos el archivo que queremos leer,aqui abrimos un stream de datos por
            // lo que debe ser cerrado para que no quede abierto
            FileReader entrada = new FileReader("C:/Users/USER/Desktop/udemy/ejemplo.txt");

            // creamos esta variable tipo int porque read nos devolvera un int y en esta
            // variable vamos almacenando los caracteres,pero se inicia en 0 para que sea
            // capaz de comenzar a leer desde el primer caracter del mensaje.
            int c = 0;

            // aqui le decimos que mientras c sea diferente de -1(osea que no ha llegado al
            // final) que vaya guardando en la misma variable cada caracter y lo
            // imprima,pero sera el caracter unicode.Como queremos es ver los caracteres
            // normales,las letras,hacemos un casting a char.Como al finalizar de leer todo
            // read lanza un -1,aparecera en el mensaje al final el caracter ?,porque su
            // codigo es -1.
            while (c != -1) {

                // aqui me guarda pero en caracteres unicode,asi que hacemos un casting a char
                c = entrada.read();
                char letra = (char) c;

                // imprimimos pero con print en vez de println para que salga todo en una linea
                System.out.print(letra);
            }

            // aqui cerramos el flujo del stream porque se supone que se debe cerrar despues
            // de que se ha ejecutado bien todo el codigo,osea el try se ha ejecutado
            entrada.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("No se ha encontrado el archivo!");
        }
    }
}