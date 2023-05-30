/*(v148) vamos a ver como capturara varias excepciones,por ejemplo cuando una funcion puede lanzar varias excepciones de diferente tipo, en este ejercicio al dividir por cero puede salir una excepcion de tipo aritmetico y si en vez de ingresar un numero ingresamos un texto puede lanzar una excepcion de tipo NumberFormat,osea es una funcion que puede lanzar excepciones y estas pueden ser diferentes.


Entonces, si un codigo puede generar errores de varios tipos, podemos envolver la funcion en un try-catch para capturar el error,y el try puede ir seguido de varios catch,uno para cada tipo de error,en este caso capturamos los dos errores que nos salen.

como esto sirve para darle al usuario una informacion mas detallada del error que ha ocurrido,generalmente tambien se utilizan los metodos getMessage(),getClass() y getName() para capturar los mensajes del error que sale.


 */

package excepciones1;

import javax.swing.JOptionPane;

public class VariasExcepciones {
    public static void main(String[] args) {

        // ponemos un try seguido de varios cathc segun los errores que puedan salir
        try {
            division();

        } catch (ArithmeticException e) {

            System.out.println("No se puede dividir por cero");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {

            System.out.println("Se deben ingresar números enteros");
            System.out.println("Se ha generado un error de tipo: " + e.getClass().getName());

        }

    }

    static void division() {

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dividendo"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el divisor"));

        System.out.println("El resultado de la división es: " + num1 / num2);

    }
}
