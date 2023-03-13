/* esta clase sera para ver como se usan las constantes en java y para ver que significa la palabra static en java. Haremos un programa que cree empleados de una empresa,en principio todos perteneceran a la seccion de administracion.Digamos que hacemos un metodo setter para poder cambiar el nombre de el empleado, esto no tendria sentido porque el nombre debe ser el mismo para un empleado,la seccion si puede cambiar pero no su nombre,entonces aqui es donde entra la palabra reservada final que se usa para establecer el valor final de un parametro(en la practica ese parametro pues funciona como una constante) y asi nos aseguramos que ciertos parametros no puedan ser alterados ni siquiera con setters. 
 
Ahora, la palbra static se puede aplicar tanto a variables,constantes y metodos,y cuando se aplica esta palabra quiere decir que ese metodo,variable o constante pertenecen a una clase.Por ejemplo vamos a signarle a cada empleado un id, debemos hacer esa variable de id, pero si tenemos una lista larga de empleados,asignarles el id manualmente puede que en un momento cometamos unerror y asignemos el mismo id a dos empleados,entonces necesitamos que el id se vaya asignando automaticamente.Cuando se van creando objetod de tipo empleado,cada objeto va teniendo su propia copia de las variables y por esto con el id se puede cometer un error,porque esa variable id es independiente en cada objeto,puede almacenar valores diferentes,lo que necesitamos es que esa variable no sea una copia diferente para cada objeto sino que sea la misma variable para todos los objetos que se van creando.Para eso se usa static, al declarar esa variable id como static significa que es una variable de la clase Empleado y sera comun para todos los objetos,no sera una copia para cada objeto,todos los objetos compartiran esa misma variable, y por lo mismo no sera una variable private sino public para que todos los objetos puedan usarla.De esta forma no hay necesidad de irle pasando por parametro el id a cada objeto creado.Para que ese id se vaya incrementando, ponemos este codigo antes de imprimir el segundo objeto empleado: Empleados.id++; Como ese parametro id pertenece es a la clase por ser static,se debe usar llamando a la clase a la que pertenece,osea la clase Empleado.Asi el id se va asignando automaticamente para cada objeto sin riesgo de ir a repetirlo.

Asi como esta el programa, con id de tipo public y static, tenemos dos problemas,por eso esta solucion es parcial,primero nos saltamos la encapsulacion,porque estamos usando una variable por fuera de la clase donde la definimos,deberia el id ser private para no poderse modificar fuera de la clase y ademas para ir incrementando el id de cada objeto creado nos toca repetir el codigo de Empleados.id++;. Para solucionar esto,volvemos a dejar el id de tipo private sin static, y debajo creo otra variable que si sera public static y la inicializo en 1.Despues voy al constructor e igualo la variable id=IdSiguiente, y debajo aumento en uno IdSiguiente++; de esta forma al crear el primer objeto su id valdra 1 porque es lo que vale inicialmente IdSiguiente, y se incrementa IdSiguiente en uno,osea vale 2, al crear el segundo objeto el id ya no vale 1,vale 2,y asi sucesivamente,se van incrementando los id en uno a medida que se vayan creando objetos.

RESUMEN:
1- PUBLIC SIGNIFICA QUE PUEDO USAR ESA VARIABLE FUERA DE LA CLASE
2- STATIC SIGNIFICA QUE ES UNA VARIABLE DE LA CLASE,NO DE UN OBJETO EN ESPECIFICO,SE DEBE USAR EL NOMBRE DE LA CLASE PARA USARLA.
3- FINAL SIGNIFICA QUE SU VALOR NO PUEDE VARIAR,POR ESO SE DICE EN LA PRACTICA QUE ES UNA CONSTANTE.
*/

package poo;

public class PruebasConstantes {
    public static void main(String[] args) {

        // creamos objetos de tipo Empleados
        Empleados trabajador1 = new Empleados("Paco");
        Empleados trabajador2 = new Empleados("Ana");
        Empleados trabajador3 = new Empleados("Juan");
        Empleados trabajador4 = new Empleados("Sandra");

        trabajador1.setCambiaSeccion("RRHH");

        System.out.println(trabajador1.getDatos());
        System.out.println(trabajador2.getDatos());
        System.out.println(trabajador3.getDatos());
        System.out.println(trabajador4.getDatos());

    }
}

class Empleados {

    private final String nombre;
    private String seccion;
    private int id;
    public static int IdSiguiente = 1;

    public Empleados(String nom) {

        this.nombre = nom;
        this.seccion = "Administración";
        id = IdSiguiente;
        IdSiguiente++;

    }

    // setter para poder cambiar la seccion de un empleado
    public void setCambiaSeccion(String seccion) {

        this.seccion = seccion;
    }

    // setter para cambiar el nombre del empleado lo cual seria un error
    // public void setCambiaNombre(String nombre) {

    // this.nombre = nombre;
    // }

    // getter
    public String getDatos() {

        return "El nombre es: " + this.nombre + " ,la sección es: " + this.seccion + " y su id es: " + this.id;
    }
}