/*los tipos enum son variables objeto de tipo enum, osea objetos de la clase Enum, las cuales sirven para almacenar solo un grupo de valores determinado y nada mas.Por ejemplo queremos crear una variable talla que almacene solo 4 tallas y nada mas,para que esa variable no admita otros valores diferentes a esas 4 tallas la creamos como una variabled e tipo enum.Para declarar una variable enum recordar que se hace fuera de la clase main,o en otra clase, y se hace como si estuvieramos instanciando un objeto de la clase Enum, por eso el nombre de esta variable objeto va en mayuscula.Ahora para usarla, como es un objeto de clase enum,usamos el punto para poder acceder a sus valores.Asi si intentamos almacenar otro valor diferente a los 4 que hemos establecido nos dara un error.Ahora, los enum tambien nos permiten crear constructores y metodos getter y setter, vamos a ver un ejemplo en donde creamos un objeto enum y su constructor recibira un parametro que sera las tallas ya sea s,m,x o xl,y con los metodos setter se establece que tipo de talla sera,si es s,m,etc y el getter nos devuelve la informacion.
 
Los tipos enum no admiten la creacion de objetos,osea no se puede hacer: Talla miTalla=new Talla, por eso el constructor debe ser private y no public,para que por fuera de la clase no se puedan crear objetos enum.

En este ejercicio le pediremos al usuario que ingrese la talla por consola,utilizamos para esto un objeto de tipo Scanner de la libreria java.util.
 */

package fundamentos;

import java.util.*;

public class UsoTallas {

    // variable tipo enum
    // enum Talla {
    // MINI, MEDIANA, GRANDE, EXTRA_GRANDE
    // };

    // ejemplo enum con constructor
    enum Talla {

        // aqui creamos los objetos usando el constructor y pasandole el parametro a
        // cada uno,estas constantes enum deben ir primero que cualquier variable para
        // que no halla error.Se tiene que definir primero los elementos tipo enum.
        MINI("s"), MEDIANO("m"), GRANDE("x"), EXTRA_GRANDE("xl");

        private String abreviatura;

        // constructor
        private Talla(String abreviatura) {

            this.abreviatura = abreviatura;
        }

        // no hace falta crear un setter porque en el constructor estamos estableciendo
        // el valor de la abreviatura,creamos solo un getter.
        public String getAbreviatura() {
            return this.abreviatura;
        }
    }

    public static void main(String[] args) {

        // Talla s = Talla.MINI;
        // Talla m = Talla.MEDIANA;
        // Talla x = Talla.GRANDE;
        // Talla xl = Talla.EXTRA_GRANDE;

        Scanner entrada = new Scanner(System.in);// objeto de clase Scanner

        System.out.println("Introduce una talla: MINI,MEDIANA,GRANDE,EXTRA_GRANDE");

        // aqui la consola se queda en espera del dato que el usuario ingrese,le ponemos
        // que lo pase a mayusculas.
        String entradaDatos = entrada.next().toUpperCase();

        // ahora, usamos el metodo valueOf de la clase Enum(ver api) que nos devuelve el
        // nombre de la constante enumerada,en si lo que hace el valueOf es detectar a
        // que tipo de dato pertenece el string que el usuario ingresa,por ejemplo
        // ingresa GRANDE,valueOf detecta que es un tipo enum y lo almacena en la
        // variable, entonces creamos una variable de tipo enum y almacenamos aqui lo
        // que nos devuelve ese metodo,este es un metodo static.Ya con este tipo enum
        // almacenado podemos llamar al metodo getter.

        Talla miTalla = Enum.valueOf(Talla.class, entradaDatos);
        System.out.println("La talla: " + miTalla);
        System.out.println("Abreviatura: " + miTalla.getAbreviatura());

        entrada.close();

    }
}
