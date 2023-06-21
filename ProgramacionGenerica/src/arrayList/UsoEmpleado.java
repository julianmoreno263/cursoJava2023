/*(v161) vamos a ver un concepto llamado ArrayList y principios d ela programacion generica en java.

La clase ArrayList nos permite manejar los arrays en ava de una forma mas flexible, cuando declaramos un array debemos especificar primero cuantas posiciones va a tener,si intentamos acceder a una posicion que no existe en ese array sale un error,si necesitamos crear un array del cual no sabemos inicialmente cuantas posiciones debera tener podemos utilizar la clase ArrayList la cual oermite generar un array dinamico.(ver API).

1- para crear un ArrayList primero importamos su paquete java.util.

2- para definir un ArrayList ponemos entre <> el tipo de datos del array. Un ArrayList solo permite almacenar objetos, no datos primitivos como string,int,etc,para esto se debe utilizar una clase envoltorio que veremos despues.

3-para agregarle elementos,en si este no es un array,es una lista,entonces no se rellena como los arrays(con sus indices) sino se utiliza el metodo add y podemos dentro de este metodo instanciar el objeto de una vez. Listo, si queremos agregar mas elementos podemos crearlo sin problemas de restriccion como con un array normal,este es mas dinamico.

4- cuando creamos un ArrayList con el constructor por defecto,este soporta por defecto 10 elementos,esto no quiere decir que no se dejen agregar mas,solo que al agregar mas elementos lo que hace java es un proceso interno donde crea una copia del array que se tiene y le agrega a esa copia los elementos demas,por lo que se consumen mas recursos,luego el array original se destruye y queda la copia pero en si se consumen mas recursos.Si quiero establecer mas de esos 10 elementos por defecto puedo utilizar el metodo ensureCapacity() y aqui le especifico el numero de elementos del array,asi determino un numero mayor a los 10 por defecto de este constructor,pero igual si le sigo almacenando mas elementos de todas formas se comienzan a crear copias.

5- ahora, si voy llenando el array y termino de llenarlo y se que ese array ya no va a almacenar mas elementos,para evitar que el ArrayList siga creando copias y utilizando mas memoria,lo cierro con el metodo trimToSize().

---------------------------------------------------------
(v162) si queremos poner un objeto(elemento) en nuestro array list pero en una posicion en concreto no podemos utilizar indices porque esto es en si una lista,para esto usamos los metodos set y get de la clase ArrayList. Los ArrayList igual comienzan desde la posicion 0.Entonces si quiero agregar un nuevo elemento en la posicion 1 por ejemplo,ya no utilizo add() sino que utilizo el metodo set() que pide la posicion y el elemento.

Con el metodo get() capturo un elemento de una posicion en concreto.
NOTA: PARA RECORRER MAS FACIL UN ARRAYLIST O CUALQUIER ARRAY UTILIZAMOS EL FOREACH,PERO PARA EL ARRAYLIST ES MEJOR EL FOREACH PORQUE COMO UN ARRAYLIST NO TIENE INDICES,SI QUEREMOS RECORRERLO CON UN FOR NORMAL SE COMPLICA MAS,SE PUEDE HACER PERO ES MAS COMPLEJO.

Por ultimo,si me siento mas comodo manejando sintaxis de arrays normales,pero necesito crear un array que sea dinamico y no este restringuido al numero de elementos,puedo crear una lista y esta lista la almaceno en un array normal y lo trabajo como array normal,es pasar los datos del ArrayList a un array normal, para esto uso la funcion toArray().(ver video al final).

----------------------------------------------------
(v163) vamos a ver como se itera un ArrayList sin utilizar los bucles normales for o foreach, para esto debemos usar el metodo iterator() el cual devuelve un objeto de tipo iterator<E>, si damos click en este objeto(en la API), vemos que en si es una interfaz llamada iterator<E> y tiene 3 metodos para manipular las listas de los ArrayList y recorrerlos,hasNext(),next() y remove().Entonces para recorrer ese ArrayList con un iterador se hace asi:

1- se crea un objeto de tipo Iterator<tipo de objeto> que sera el que va a ir recorriendo el array list,se le especifica el tipo de objeto que va a recorrer.

2- se le pone un nombre y con este objeto se usa el metodo iterator() de la clase ArrayList.Para usar la interfaz Iterator se debe de importar el paquete java.util.(ver API).

3- ya con la informacion de la lista almacenada en este objeto,con un bucle while y usando los metodos de esa interfaz,lo recorro para mostrar los datos.



 */

package arrayList;

import java.util.*;

public class UsoEmpleado {
    public static void main(String[] args) {

        // array normal en java
        // Empleado arrayEmpleados[] = new Empleado[3];
        // arrayEmpleados[0] = new Empleado("Juan", 23, 2500);
        // arrayEmpleados[1] = new Empleado("Maria", 35, 2000);
        // arrayEmpleados[2] = new Empleado("Juan", 45, 2600);

        // ArrayList
        ArrayList<Empleado> arrayEmpleados = new ArrayList<Empleado>();
        // arrayEmpleados.ensureCapacity(11);
        arrayEmpleados.add(new Empleado("Juan", 23, 2500));
        arrayEmpleados.add(new Empleado("Maria", 35, 2000));
        arrayEmpleados.add(new Empleado("Juan", 45, 2600));
        arrayEmpleados.add(new Empleado("Pepe", 35, 2600));
        arrayEmpleados.add(new Empleado("Sandra", 65, 3800));

        // aqui agrego un nuevo elemento en una posicion especifica con set()
        arrayEmpleados.set(1, new Empleado("Ingrid", 22, 3000));

        // aqui cierro el ArrayList para optimizar recursos
        arrayEmpleados.trimToSize();

        // aqui recorro el array list con un for-each normal
        // for (Empleado empleado : arrayEmpleados) {

        // System.out.println(empleado.dameDatos());
        // }

        // aqui recorro el array list con un iterador
        Iterator<Empleado> miIterador = arrayEmpleados.iterator();

        while (miIterador.hasNext()) {

            System.out.println(miIterador.next().dameDatos());
        }

        // // asi capturo un elemento de una posicion especifica
        // System.out.println("Datos del empleado posicion 3: " +
        // arrayEmpleados.get(2).dameDatos());

    }
}

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    // constructor
    public Empleado(String nombre, int edad, double salario) {

        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // metodopara dar los datos de los empleados
    public String dameDatos() {

        return "El empleado " + this.nombre + " tiene una edad de " + this.edad + " años" + " y un salario de "
                + this.salario + " pesos.";
    }
}