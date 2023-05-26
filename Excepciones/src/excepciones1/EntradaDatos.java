/*(v144) vamos a seguir viendo los errores de tipo no controlados.Este programa nos pide introducir unos datos por consola, si en la edad le pasamos un texto nos saldra un tipo de error InputMismatchExcepcion, entonces si buscamos esta clase en la API y no hereda de la clase IOExcepcion podemos determinar que sera un error de tipo no controlado y deberemos mejorar el codigo para que no se provoque un error asi,si heredara de IOExcepcion simplemente nos veriamos obligados a implementar el try-catch.Esto no quiere decir que no podamos implementar el try en un error no controlado,depende de nuestra logica, en este caso para el ejercicio lo que hacemos es con la clausula throw lanzar el tipo de error,osea le indicamos al metodo que es el que puede oiginar este error que lance esta excepcion y pues podemos capturarlo con un try-catch.Ahora,esto lo hacemos para ver como se manejan estos errores con throw y try catch,pero como es un error de tipo no controlado lo que seria buena practica es corregir el codigo para evitar que se produzca un error de estos,por ejemplo validando con un if los tipos de datos que se van a ingresar,etc.

La ventaja de utilizar el try catch es que el programa no se cae,tanto si esta bien o no,el programa corre y se ejecuta lo que haya despues del catch,aunque haya un error,el catch lo atrapa y sigue la ejecucion del programa.

Para no complicarnos mirando que tipo de excepcion debemos poner en el catch y en el throws,podemos poner la clase Excepcion porque de esta heredan tanto los IOExcepcion como los de tipo RuntimeExcepcion o no controlados.

----------------------------------------------------------------

(v145) ahora, no tiene sentido que en el mismo metodo se capture la excepcion,el metodo es el codigo que puede generar ese error y no tiene sentido que sea el mismo metodo el que lo capture, lo logico es capturar el error fuera del metodo,por ejemplo cuando se llama a la funcion,entonces lo correcto es poner el llamado afuncion dentro del try-catch.

NOTA: no confundir la clausula throws con throw(singular), la primera se usa en los metodos e indica que ese metodo puede lanzar una excepcion,y la clausula throw en singular se puede usar en cualquier parte del codigo para lanzar excepciones.

*/

package excepciones1;

import java.util.Scanner;

public class EntradaDatos {

    public static void main(String[] args) throws Exception {

        System.out.println("Qué deseas hacer?");
        System.out.println("1-Introducir datos");
        System.out.println("2-Salir del programa");

        Scanner entrada = new Scanner(System.in);
        int decision = entrada.nextInt();

        if (decision == 1) {

            // aqui en la llamada al metodo manejamos la excepcion
            try {

                pedirDatos();

            } catch (Exception e) {

                System.out.println("Tipo de dato erroneo!");
            }

        } else {

            System.out.println("Adios!");
            System.exit(0);
        }

        entrada.close();

    }

    static void pedirDatos() throws Exception {

        // try {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce tu nombre, por favor");

        String nombre_usuario = entrada.nextLine();

        System.out.println("Introduce edad, por favor");

        int edad = entrada.nextInt();

        System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás "
                + (edad + 1) + " años.");

        entrada.close();
        // } catch (Exception e) {

        // System.out.println("Tipo de dato erroneo!");
        // }

        System.out.println("Hemos terminado");
    }
}
