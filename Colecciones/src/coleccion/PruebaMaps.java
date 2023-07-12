/*(v189) vamos a ver las colecciones d etipo maps, la principal caracteristica es que ordenan los elementos con clave-valor y tiene varias clases para manipularlas.

Para crear una coleccion map se implementa la interfaz Map<k,v>, y esta interfaz tiene una interfaz interna Map.Entry<k,v> esta tiene un metodo entrySet() la cual devuelve una coleccion tipo Set.

Para ingresar elementos a una coleccion map se usa el metodo put(k,v) el cual pide la clave y el valor del elemento,y para capturara un elemento especifico se usa el metodo get(k) que pide la clave y devuelve el valor del elemento.Las claves en un map no se pueden repetir. Si repetimos un elemento con la misma clave  este elemento se reemplazara.

Los maps pueden almacenar cualquier tipo de dato,hasta cualquier tipo de objetos.

vamos a hacer un map que coleccione objetos de tipo empleado.Importamos java.util donde esta esta interfaz.


 */

package coleccion;

import java.util.*;

public class PruebaMaps {
    public static void main(String[] args) {

        // 1- aqui creamos el map con la clase HashMap y la clave sera de tipo string y
        // el valor el objeto empleado
        HashMap<String, Empleado> personal = new HashMap<String, Empleado>();

        // 2- ingresamos elementos al map con el metodo put() pasando la k y v.La clave
        // sera un string y el valor seran los objetos de tipo Empleado,los cuales
        // podemos instanciarlos directamente.
        personal.put("145", new Empleado("sandra"));
        personal.put("146", new Empleado("ingrid"));
        personal.put("147", new Empleado("paula"));
        personal.put("148", new Empleado("angie"));

        // 3-eliminamos un elemento con remove()
        personal.remove("148");

        // 4- si creamos un objeto con una clave que ya este creada,ese objeto se
        // reemplazara con el nuevo.
        personal.put("148", new Empleado("lucy"));

        // imprimimos el map,el map sale encerrado entre {}
        System.out.println(personal);

        // 5- con entrySet() nos devuelve la coleccion pero en forma de tipo Set,todo
        // encerrado entre [].Si queremos recorrer un entrySet con un for-each, lo
        // hacemos asi:

        // esto indica que en una variable entrada,almacene la k y el v de cada elemento
        // recorrido de la coleccion personal y devuelva un set.La interfaz Map.Entry
        // tiene los metodos getKey y getValue para obtener los datos de estos objetos.

        for (Map.Entry<String, Empleado> entrada : personal.entrySet()) {

            String key = entrada.getKey();
            Empleado valor = entrada.getValue();

            System.out.println("Clave: " + key + " Valor: " + valor);
        }

    }
}

// clase Empleado
class Empleado {

    private String nombre;
    private double sueldo;

    // constructor
    public Empleado(String nombre) {

        this.nombre = nombre;
        this.sueldo = 2000;
    }

    // metodo toString que me retorna un string con los datos de cada objeto
    public String toString() {

        return "[Nombre: " + this.nombre + " Sueldo: " + this.sueldo + " ]";
    }
}
