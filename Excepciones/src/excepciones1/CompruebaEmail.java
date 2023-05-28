/*(v146) este programa valida una direccion de email, pero si por ejemplo ponemos e@. nos dira que es correcto porque cumple con las condiciones de tener una @ y un punto,pero no es una direccion valida,con la clausula throw podemos manejar manualmente una excepcion, recordar que existe la clausula throws que se usa para manejar las excepciones en las funciones,y esta clausula throw en singular se puede usar en cualquier parte del codigo.


Entonces, manualmente con throw podemos indicarle al codigo que si el email tiene una longitud menor o igual a solo tres caracteres pues que lanze el error porque sera un mail incorrecto.

Ahora, entonces podemos evaluar con un if si el mail es menor a tres caracteres y lanzar una excepcion con throw, como hay varias excepciones en la API es dificil saber que excepcion en especifico nos sirve para lanzarla en este caso,por lo que primero lanzaremos una excepcion generica para ver  como es que se hace esto manualmente.

Entonces se crea un objeto del tipo de la excepcion que vamos a lanzar y despues se lanza con throw.Pero generalmente se abrevia el codigo instanciando la excepcion al momento de lanzarla.Ahora ya creada la excepcion,de igual forma toca decirle al programa que la capture con try catch en el llamado de la funcion,porque hasta ahora solo la lanzamos,pero el programa no sabe como manejarla,y esto se hace usando el try-catch.

Si el tipo de excepcion que queremos lanzar no se encuentra en la API podemos crear nuestras propias excepciones,esto lo veremos mas adelante.

--------------------------------------------------
(v147) vamos a ver como crear nuestras propias excepciones,porque por ejemplo en este ejercicio queremos validar si la longitud del email es menor o igual a 3 entonces que lance la respectiva excepcion,pero resulta que en la API de java no hay una claseespecifica para este tipo de error,entonces aqui es donde podemos hacer nuestra propia excepcion,y esto es hacer una clase que herede de Excepcion,o de IOExcepcion o de RuntimeExcepcion,si hereda d e las dos primeras debemos poner el try-catch obligado.

Entonces creamos nuestra propia clase para nuestra excepcion.

1- lo recomendable aunque no obligatorio es que estas clases para las excepciones propias tengan 2 constructores,el por defecto y el contructor que admita un parametro string.

2- ahora en el metodo examinaEmail le decimos con throws que este lanzara un error de tipo de la clase que hicimos.

3- dentro del if lanzo la excepcion y utilizo el constructor que pide un string para personalizar ese mensaje de error.

4-Ahora llamamos al metodo en la clase main pero debera estar dentro de un bloque try-catch porque este metodo lanza una excepcion de la clase que hicimos y esta clase hereda de Excepcion la cual nos obliga a usar el try-catch.Si usamos el try-catch el cual en el catch pasamos un mensaje de error,pues podemos solo usar el constructor por defecto que no pide argumento string porque ya no necesitamos otro mensaje.

En la API, si vemos las clases de Excepcion,IOExcepcion o RuntimeExcepcion, veremos que estas tendran al menos dos constructores,el por defecto y otro u otros que admiten uno o varios argumentos,por esta razon al crear las clases para nuestras excepciones es recomendable poner dos constructores por si queremos usar argumentos o no.

Por ultimo con la instruccion printStackTrace() podemos imprimir mas informacion sobre el error ocurrido,nos aparecera la clase que maneja el error(osea la que hicimos) y la linea donde se produjo, entonces aqui podemos usar el constructor que pide un string y ese mensaje que ponemos personalizado aparecera y asi al usuario se le da una idea mas precisa del error.


 */

package excepciones1;

import javax.swing.*;

public class CompruebaEmail {

    public static void main(String[] args) {

        String email = JOptionPane.showInputDialog("Introduce el email", args);

        try {
            examinaEmail(email);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("La longitud del email no es correcta! ");
            e.printStackTrace();
        }

        // try {
        // examinaEmail(email);
        // } catch (Exception e) {
        // // TODO: handle exception
        // System.out.println("La longitud del email no es correcta! ");
        // }

    }

    static void examinaEmail(String mail) throws LongitudMailErronea {

        int arroba = 0;
        boolean punto = false;

        // evaluando y lanzando excepcion manualmente con throw

        if (mail.length() <= 3) {

            // Exception e = new Exception();
            // throw new Exception();

            throw new LongitudMailErronea("El email no puede tener menos de tres caracteres!");

        } else {

            /*
             * el for va evaluando caracter por caracter hasta que vea un arroba,recordar
             * que los datos de tipo char van en comilla simple,y los string en doble.
             */

            for (int index = 0; index < mail.length(); index++) {

                if (mail.charAt(index) == '@') {

                    arroba++;

                }

                if (mail.charAt(index) == '.') {

                    punto = true;
                }
            }

            if (arroba == 1 && punto == true) {
                System.out.println("Email correcto");
            } else {

                System.out.println("Email incorrecto!");
            }

        }
    }
}

class LongitudMailErronea extends Exception {

    // primer constructor por defecto
    public LongitudMailErronea() {
    }

    // segundo constructor con parametro
    public LongitudMailErronea(String error) {
        // aqui llamamos al constructor de la clase padre Exception y le pasamos el
        // parametro
        super(error);
    }

}
