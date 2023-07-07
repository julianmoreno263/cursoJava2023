/*(v184) vamos a ver las linkedList, son muy parecidas a los arrays.Cuando creamos un arrayList y le agregamos elementos,si quitamos un elemento debemos reordenar el arrayList porque no puede dejar un hueco, esto en terminos de eficiencia es muy costoso. Ahora, un linkedList trabaja diferente, cuando creamos un linkedList cada elemento esta vinculado(linkado) tanto al anterior elemento como al que le sigue por medio de links, de esta forma si reordenamos el linkedList no importa porque no pierden la referencia de sus links. Ahora, si eleiminamos un elemento del linkedList los enlaces se vinculan automaticamente con los elementos que estan al lado tanto anterior como posterior. La clase LinkedList implementa la interfaz List, tambien esta clase tiene varios metodos como add() y otros para manipular las linkedList. Cuando se agrega un elemento a un linkedList por defecto este se agrega siempre al final de la lista.En resumen, cuando necesitemos una lista que estara constantemente agregando y eliminando elementos,podemos usar un linkedList por temas de eficiencia en vez de un arrayList.


haremos un ejercicio para ver como se crean y manipulan las linkedList.

1- lo primero es importar java.util porque LinkedList esta en este paquete

2- LinkedList es una clase generica,usa <>, entonces creamos una instancia de esta clase estableciendo el tipo, como con los arrayList.

3- para agregar elementos a esta lista usamos el metodo add().Con size() me dice cuantos elementos tiene la linkedList.

4- para recorrela lo puedo hacer con un for-each.

5- si agrego otro elemento,lo agrega al final de la lista,si quiero ponerlo en una posicion en concreto uso el otro metodo add() que pide un indice y el elemento.Pero si yo no se cuantos indices tiene la lista,debo recorrerla con un iterador,para esto me puede servir ListIterator que hereda de la interfaz Iterator,lo que pasa con Iterator es que me sirve cuando tengo listas sin un orden,pero cuando tengo listas ordenadas me sirve mas ListIterator pues tiene mas metodos para poder recorrer la lista ya sea hacia adelante o hacia atras,etc.Entonces lo primero sera crear un ListIterator para poder usar esos metodos con nuestra lista.

6- el iterador es como un puntero que se va moviendo por la lista, segun su ubicacion podemos poner los elementos donde nosotros queramos,para agregar elementos en una ubicacion en concreto usamos el iterador que creamos y los metodos de LinkedList. Si yo le digo ahora: it.next(), el iterador no comienza desde el primer elemento de la lsita sino del siguiente,entonces si agrego un nuevo elemento con it.add("juan"), este estara en la segunda posicion de la lista, ya no se agrega al final por defecto sino donde yo quiero.


*/

package coleccion;

import java.util.*;

public class PruebaLinkedList {
    public static void main(String[] args) {

        // creo la linkedList
        LinkedList<String> personas = new LinkedList<>();

        // agrego elementos
        personas.add("pepe");
        personas.add("ingrid");
        personas.add("sandra");
        personas.add("paula");

        // veo el numero de elementos que tiene la linkedList
        System.out.println("La lista tiene " + personas.size() + " elementos.");

        // creo iterador ListIterator para nuestra lista personas y lo ubico en una
        // posicion especifica
        ListIterator<String> it = personas.listIterator();
        it.next();

        // agrego otro elemento pero ahora estara en la segunda posicion de la lista
        it.add("juan");

        // recorriendo la lista
        for (String persona : personas) {

            System.out.println(persona);
        }

    }
}
