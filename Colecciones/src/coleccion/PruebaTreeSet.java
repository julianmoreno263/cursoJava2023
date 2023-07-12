/*(v186) vamos a ver las colecciones tipo arbol o TreeSet, estas heredan de la interfaz Set y por eso no permiten elementos duplicados,pero a diferencia de las colecciones tipo Set,si permiten ordenamiento.


1-importamos java.util

2-instanciamos la coleccion

3- si la imprimimos,veremos que la imprime pero en orden alfabetico,esto es porque el objeto treeSet al decirle que sera string,la clase string implementa la interfaz comparable la cual tiene el metodo compareTo(),entonces treeSet utiliza este metodo para comparar automaticamente los elementos y los ordena.

4- ahora, si yo creo una lista treeSet pero de otro tipo de objetos,por ejemplo de una clase que yo cree,para que haya ordenacion debo implementar en esa clase la interfaz comparable para despues poder usar el metodo compareTo() de esa interfaz.

----------------------------------------------------------------
(v187) si queremos comparar dos objetos de una clase que no implemente la interfaz Comparable y por lo tanto no podemos usar el metodo compareTo(), la clase TreeSet tiene sobrecarga de constructores, uno de ellos pide como parametro un objeto de tipo Comparator, esta interfaz admite un generico <T> y tiene dos metodos para realizar la comparacion entre dos objetos(ver API).Entonces podemos crear un objeto Comparator para poder usar estos metodos y asi poder pasar ese objeto a nuestra coleccion de tipo TreeSet, asi podemos ordenar la coleccion de acuerdo a otro criterio si necesitamos.Entonces para implementar esta interfaz en nuestra clase Articulo hacemos:

1- una clase puede implementar varas interfaces,por lo que en Articulos implementamos tambien la interfaz Comparator.

2-implementamos los metodos de esta interfaz, como ambas tienen el metodo compareTo() pues borramos uno de esos metodos porque ya lo teniamos sobreescrito y solo adicionamos el metodo compare().Lo que haremos sera usar este metodo para ordenar alfabeticamente la coleccion.

3- en el metodo compare creo dos variables para las descripciones y las comparo con compareTo().

4- creo en la clase main un objeto de tipo comparator,osea instancio la clase Articulo con su constructor,porque la clase Articulo implementa esta interfaz,pero como este constructor pide dos parametros y para usar Comparator no necesito estos parametros creo un segundo constructor en Articulo sin parametros y este constructor es el que utilizo para crear mi objeto de tipo Comparator.Esta solucion no es la mas adecuada pero vamos por pasos.

5- ahora creo la coleccion TreeSet y a esta coleccion le paso nuestro objeto comparador

----------------------------------------------------
(v188) vamos a ver como podemos usar los TreesEt sin necesidad de implementar la interfaz Comparator en el caso de que queramos usar objetos de nuestras propias clases y no implementen esta interfaz.

1- copio la clase Articulo para no borrarla y esta copia no implementara comparator por lo que no lleva la implementacion de la interfaz ni el metodo compare, ni el constructor por defecto.

2- vamos a crear un nuevo objeto comparador,por lo que creo una clase para este objeto comparador, esta clase si implementara Comparator, pero de esta forma ya no es necesario que la clase Articulos que es la que crea los objetos implemente la interfaz.

3-creada la clase vamos a main y creamos este objeto comparador y la coleccion con este objeto.

4- ahora, podemos hacer lo mismo de crear este objeto comparador en la misma definicion del TreeSet,osea usar una clase interna y asi no necesitamos crear una nueva clase aparte, en esta clase interna ponemos el metodo sobreescrito compare.


 */

package coleccion;

import java.util.*;

public class PruebaTreeSet {
    public static void main(String[] args) {

        // TreeSet<String> ordenaPersonas = new TreeSet<>();

        // ordenaPersonas.add("sandra");
        // ordenaPersonas.add("amanda");
        // ordenaPersonas.add("diana");

        // for (String s : ordenaPersonas) {
        // System.out.println(s);
        // }

        // creamos los objetos de Articulo
        Articulo primero = new Articulo(1, "Primer articulo");
        Articulo segundo = new Articulo(2, "Segundo articulo");
        Articulo tercero = new Articulo(3, "Tercer articulo");

        // creamos nuestra lista TreeSet y le agregamos los articulos y usando el metodo
        // compareTo() debe de mostrarlos en orden.
        TreeSet<Articulo> ordenaArticulos = new TreeSet<>();
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(segundo);
        ordenaArticulos.add(primero);

        for (Articulo art : ordenaArticulos) {

            System.out.println(art.getDescripcion());

        }

        System.out.println("------------------------------");

        // objeto Articulo que usara la interfaz Comparator
        // Articulo comparadorArticulos = new Articulo();

        // coleccion TreeSet,aqui establecemos que esta coleccion se va a ordenar segun
        // lo que establezca el objeto comparador,y en este caso esta comparando por el
        // string de descripcion entonces lo ordenara alfabeticamente
        // TreeSet<Articulo> ordenaArticulos2 = new TreeSet<>(comparadorArticulos);

        // objeto comparador creado con una clase interna
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {

                String desc1 = o1.getDescripcion();
                String desc2 = o2.getDescripcion();

                return desc1.compareTo(desc2);

            }
        });
        ordenaArticulos2.add(tercero);
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);

        for (Articulo art2 : ordenaArticulos2) {

            System.out.println(art2.getDescripcion());
        }

    }
}

// clase propia que no implementa Comparator
class Articulo implements Comparable<Articulo> {

    private int numArticulo;
    private String descripcion;

    // constructor
    public Articulo(int num, String desc) {

        this.numArticulo = num;
        this.descripcion = desc;
    }

    // metodo sobreescrito,compara los elementos y segun eso devuelve un -1,0, o un
    // 1. Aqui le decimos que devuelva el numero de articulo que le pasamos al
    // objeto creado menos otro numero de articulo de otro objeto.Este metodo se
    // hace para que compare los objetos que se creen por orden de articulo y los
    // organice.
    @Override
    public int compareTo(Articulo o) {
        return this.numArticulo - o.numArticulo;
    }

    public String getDescripcion() {

        return this.descripcion;
    }

}

// ---------------------------------------------------------------------

// clase que creara el objeto comparador,por lo tanto implementara Comparator
// class ComparadorArticulos implements Comparator<Articulo> {

// @Override
// public int compare(Articulo o1, Articulo o2) {

// String desc1 = o1.getDescripcion();
// String desc2 = o2.getDescripcion();

// return desc1.compareTo(desc2);

// }

// }

// ---------------------------------------------------------------------

// // clase propia
// class Articulo implements Comparable<Articulo>, Comparator<Articulo> {

// private int numArticulo;
// private String descripcion;

// // constructor
// public Articulo(int num, String desc) {

// this.numArticulo = num;
// this.descripcion = desc;
// }

// // segundo constructor sin parametros
// public Articulo() {

// }

// // metodo sobreescrito,compara los elementos y segun eso devuelve un -1,0, o
// un
// // 1. Aqui le decimos que devuelva el numero de articulo que le pasamos al
// // objeto creado menos otro numero de articulo de otro objeto.Este metodo se
// // hace para que compare los objetos que se creen por orden de articulo y los
// // organice.
// @Override
// public int compareTo(Articulo o) {
// return this.numArticulo - o.numArticulo;
// }

// public String getDescripcion() {

// return this.descripcion;
// }

// @Override
// public int compare(Articulo o1, Articulo o2) {

// String descripcionA = o1.getDescripcion();
// String descripcionB = o2.getDescripcion();

// return descripcionA.compareTo(descripcionB);

// }

// }
