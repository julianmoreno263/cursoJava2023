/*(v186) vamos a ver las colecciones tipo arbol o TreeSet, estas heredan de la interfaz Set y por eso no permiten elementos duplicados,pero a diferencia de las colecciones tipo Set,si permiten ordenamiento.


1-importamos java.util

2-instanciamos la coleccion

3- si la imprimimos,veremos que la imprime pero en orden alfabetico,esto es porque el objeto treeSet al decirle que sera string,la clase string implementa la interfaz comparable la cual tiene el metodo compareTo(),entonces treeSet utiliza este metodo para comparar automaticamente los elementos y los ordena.

4- ahora, si yo creo una lista treeSet pero de otro tipo de objetos,por ejemplo de una clase que yo cree,para que haya ordenacion debo implementar en esa clase la interfaz comparable para despues poder usar el metodo compareTo() de esa interfaz.


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

    }
}

// clase propia
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