/*(v152) vamos a ver las secuencias o streams en java, o flujos de datos sirven para  varios propositos por ejemplo para enviar informacion a traves de la red,tambien para acceder a archivos de nuestro pc desde nuestros programas java. Hay dos formas de acceder a los archivos con los streams, con streams de bytes o streams de caracteres, los primeros sirven cuando vamos a enviar informacion desde nuestro programa java a traves de la red, y con streams de caracteres cuando vamos a acceder a un archivo para leerlo o editarlo.

En si los stream lo que hacen es crear un flujo de datos entre mi app java y el archivo que quiero manipular.

Si vamos a trabajar con streams de bytes debemos usar las clases abstractas InputStream o OutputStream del paquete java.io, y si vamos a trabajar con stremas de caracteres debemos usar las clases abstractas Reader o Writer. Para estos ejercicios trabajaremos con streams de caracteres para acceder a un archivo .txt que creamos en el escritorio con el bloc de notas y que solo tiene una frase simple,es importante saber donde tenemos el archivo al que queremos acceder.Lo primero sera importar el paquete java.io de donde vienen las clases que necesitamos.

--------------------------------------------------------------------------------------------
(v154) vamos a ver que son los buffers en java, estos son memorias intermedias que se pueden crear entre nuestra app y el archivo que vamos a leer o escribir, si usamos un stream normal para leer en un archivo,este va a leer caracter a caracter,en el caso de que el archivo tenga muchas lineas el stream se vuelve poco eficiente y ademas consume muchos recursos,aqui entran los buffers, al ser memorias intermedias entre la app y el archivo,el archivo se va cargando en el buffer para que la app lo pueda ir leyendo mas rapido,ademas no leera carcater a caracter sino que va leyendo lineas completas,asi mejora el rendimiento y no consume tantos recursos del pc, al buffer tambien se le llama filtro.Para trabajar con buffers para leer en un archivo usamos la clase BufferedReader la cual tiene un metodo readLine que tiene dos constructores,el primero pide un objeto de tipo FileReader y el segundo pide ademas otro parametro que es un tamaño para el buffer(ver API), la clase para escribir con un buffer es BuferedWriter y es parecida a la anterior.

Entonces,para aplicar en este ejercicio el buffer, primero ponemos mas lineas de codigo en nuestro archivo que vamos a leer.

1- ahora, en el try,en la clase LeerArchivo,despues de crear el objeto FileReader, creamos el buffer,pues ira entre nuestro archivo al que tratamos de acceder y la app.

2- es importante ver en la API de java la descripcion del metodo readLine,porque alli dice que este metodo va leyendo las lineas del archivo,pero considera una linea cuando ve un salto de linea (\n) o un salto de carro(osea cuando se da enter),osea que el va leyendo el texto y considera que leyo una linea cuando ve alguna de estas dos,un salto de linea o un enter.

3- ahora,el codigo del while que hicimos para el stream ya no sirve,lo comentamos para tenerlo de referencia y lo sustituimos por la llamada al metodo readLine,y en la condicion del while le decimos que vaya leyendo desde que la linea no sea nula,osea debe existir la linea para que lea.Creamos esa variable linea para ir almacenando alli lo que va cargando el buffer.Tener en cuenta que el metodo readLine tambien puede lanzar una excepcion de tipo IOException por lo que debe ir en un try-catch.

4- a lo ultimo,cuando imprime nos imprime tambien un null porque ve que no hay mas lineas,para no imprimir ese null ponemos dentro de un if el println.Para escribir con un buffer es lo mismo pero con la clase BufferedWriter.
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

            // creamos el buffer para que carge el objeto FileReader,osea el archivo.
            BufferedReader miBuffer = new BufferedReader(entrada);

            // creamos esta variable tipo int porque read nos devolvera un int y en esta
            // variable vamos almacenando los caracteres,pero se inicia en 0 para que sea
            // capaz de comenzar a leer desde el primer caracter del mensaje.
            // int c = 0;

            // aqui le decimos que mientras c sea diferente de -1(osea que no ha llegado al
            // final) que vaya guardando en la misma variable cada caracter y lo
            // imprima,pero sera el caracter unicode.Como queremos es ver los caracteres
            // normales,las letras,hacemos un casting a char.Como al finalizar de leer todo
            // read lanza un -1,aparecera en el mensaje al final el caracter ?,porque su
            // codigo es -1.

            String linea = "";

            while (linea != null) {

                // aqui me guarda pero en caracteres unicode,asi que hacemos un casting a char
                // c = entrada.read();
                // char letra = (char) c;

                // aqui vamos leyendo lo que se va cargando en el buffer
                linea = miBuffer.readLine();

                // imprimimos pero con print en vez de println para que salga todo en una
                // linea,ponemos esto dentro de un if ara que no nos saque un null al final
                if (linea != null) {
                    System.out.println(linea);

                }
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