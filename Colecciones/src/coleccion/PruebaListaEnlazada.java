/*(v185) haremos un ejercicio con linkedList, crearemos dos listas una de paises y otra de ciudades y las uniremos y a la de ciudades le eliminaremos los elementos pares y veremos que efecto tiene en la otra lista que estaba unida a la de ciudades.

en el while se indica que mientras haya un siguiente elemento en capitales, valide si hay un siguiente elemento en paises y si lo hay que lo salte, al haberlo saltado ya lo mapeo y entonces a ese elemento le agrege el siguiente elemento de capitales, asi va mostrando pais y su capital.


*/

package coleccion;

import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaListaEnlazada {
    public static void main(String[] args) {

        // lista de paises
        LinkedList<String> paises = new LinkedList<>();

        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Peru");

        // lista de ciudades
        LinkedList<String> capitales = new LinkedList<>();

        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("DF");
        capitales.add("Lima");

        // creo un iterator para la primera lista y otro para la segunda
        ListIterator<String> itA = paises.listIterator();
        ListIterator<String> itB = capitales.listIterator();

        // aqui valido si hay elementos en las listas y voy agregando capitales a la
        // lista de paises
        while (itB.hasNext()) {

            if (itA.hasNext()) {

                itA.next();
            }

            itA.add(itB.next());
        }

        System.out.println(paises);

        // asi volvemos a la posicion inicial al iterador,lo ponemos de nuevo al
        // principio de la lista
        itB = capitales.listIterator();

        // aqui elimino los elementos pares de capitales, evaluo si hay un elemento a
        // saltar con while,si lo hay,evaluo si hay otro elemento a saltar(porque
        // necesito los pares) con el if y si lo hay le digo que lo salte(para que lo
        // mapee) y lo elimine con remove().
        while (itB.hasNext()) {

            itB.next();

            if (itB.hasNext()) {

                itB.next();
                itB.remove();

            }
        }

        System.out.println(capitales);

        // En este punto la lista capitales solo tiene a madrid y DF,si le digo a paises
        // que elimine las capitales,pues elimina a madrid y DF que son las que hay,y si
        // vuelvo a imprimir paises,esta lista tendra los paises y las capitales de
        // bogota y lima.
        paises.removeAll(capitales);

        System.out.println(paises);

    }
}
