/*(v164)este archivo trabaja junto al archivo ArrayList.java.

Vamos a ver la programacion generica en java, es un paradigma de java que sirve para reutilizar codigo manejando diferentes tipos de objetos con una sola clase,osea no debemos crear diferentes clases por cada tipo de objetos,por eso se llama generica.

Por ejemplo tenemos la clase ArrayList y con esta clase manipulando el parámetro de tipo podemos manejar objetos de diferente tipo con una única clase,osea podemos hacer ArrayList<String> y ArrayList<File>,etc. Por eso se llama programación genérica,para manejar objetos en general con una sola clase.

Esto mismo se puede hacer utilizando la herencia,pero tiene mas complicaciones como:

1- uso continuo del casting
2- complicacion del codigo
3- no hay posibilidad de comprobar errores en tiempo de compilacion,osea nos salen los errores en ejecucion por lo que debemos manejar el try-catch, si salieran en tiempo de compilacion(osea cuando estamos escribiendo el codigo) el mismo editor nos podria ir diciendo que errores manejar,pero salen es en ejecucion.

La programacion generica s eutiliza por:

1- mayor sencillez del codigo
2- reutilizacion del codigo
3- comprobacion de errores en tiempo de compilacion.

Vamos a hacer un ejercicio en donde supondremos que no existe la clase ArrayList(esta programacion generica se introdujo en java en la version 5,antes no existia) para ver como se programaba antes d eexistir la programacion generica y sus inconvenientes.

1- creo el array de tipo ArrayList con el constructor y le paso el numero de elementos que quiero que tenga.

2- le adiciono elementos a mi array con el metodo add de la clase ArrayList que cree,vamos a enviarle elementos de tipo String.

3- capturo uno de estos elementos con el metodo get,aqui veo el primer inconveniente de no utilizar programacion generica,porque el metodo get lo programe de tipo Object y como en la variable quiero almacenar un String debo utilizar el casting.Ya despues lo puedo imprimir en consola.

4- ahora,si quisiera almacenar objetos de tipo File lo podria hacer casteando con File.De igual modo puedo almacenar en el array un elemento de tipo File por ejemplo y en principio no da error,osea en tiempo de compilacion no marca error,pero apenas lo ejecute saca el error(en tiempo de ejecucion) por lo mismo,por el casting.

Esto no pasa utilizando la clase ArrayList de la programacion generica porque en esta clase ya permite establecer el tipo de dato del objeto a menjar,osea podemos hacer ArrayList<String>=new ArrayList(), o ArrayList<File>=new ArrayList, etc.

Si vamos al archivo UsoEmpleado que usa la clase ArrayList de java,podemos ver otra de las ventajas de la programacion generica,que es marcar los errores pero en tiempo de compilacion,porque si intentamos almacenar un objeto en ese array de tipo String y no de tipo Empleado,el mismo editro marca el error.

En definitiva la programacion generica con la clase ArrayList mejora la escritura de codigo con objetos.



 */

package arrayList;

import java.io.*;

public class UsoArrayList {
    public static void main(String[] args) {

        // creo mi array
        ArrayList2 archivos = new ArrayList2(4);

        // almaceno los cuatro elementos de tipo String
        archivos.add("Juan");
        archivos.add("Maria");
        archivos.add("Pedro");
        archivos.add("Ingrid");

        // debo castear el tipo de dato de get para que me permita almacenarlo
        String nombrePersona = (String) archivos.get(2);

        // ahora para probar,almaceno datos de tipo File
        // archivos.add(new File("gestionPedidos.db"));
        // File nombrePersona = (File) archivos.get(0);

        System.out.println(nombrePersona);

    }
}
