/*(v146) este programa valida una direccion de email, pero si por ejemplo ponemos e@. nos dira que es correcto porque cumple con las condiciones de tener una @ y un punto,pero no es una direccion valida,con la clausula throw podemos manejar manualmente una excepcion, recordar que existe la clausula throws que se usa para manejar las excepciones en las funciones,y esta clausula throw en singular se puede usar en cualquier parte del codigo.


Entonces, manualmente con throw podemos indicarle al codigo que si el email tiene una longitud menor o igual a solo tres caracteres pues que lanze el error porque sera un mail incorrecto.

Ahora, entonces podemos evaluar con un if si el mail es menor a tres caracteres y lanzar una excepcion con throw, como hay varias excepciones en la API es dificil saber que excepcion en especifico nos sirve para lanzarla en este caso,por lo que primero lanzaremos una excepcion generica para ver  como es que se hace esto manualmente.

Entonces se crea un objeto del tipo de la excepcion que vamos a lanzar y despues se lanza con throw.Pero generalmente se abrevia el codigo instanciando la excepcion al momento de lanzarla.Ahora ya creada la excepcion,de igual forma toca decirle al programa que la capture con try catch en el llamado de la funcion,porque hasta ahora solo la lanzamos,pero el programa no sabe como manejarla,y esto se hace usando el try-catch.

Si el tipo de excepcion que queremos lanzar no se encuentra en la API podemos crear nuestras propias excepciones,esto lo veremos mas adelante.


 */

package excepciones1;

import javax.swing.*;

public class CompruebaEmail {

    public static void main(String[] args) throws Exception {

        String email = JOptionPane.showInputDialog("Introduce el email", args);

        try {
            examinaEmail(email);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("La longitud del email no es correcta! ");
        }

    }

    static void examinaEmail(String mail) throws Exception {

        int arroba = 0;
        boolean punto = false;

        // evaluando y lanzando excepcion manualmente con throw

        if (mail.length() <= 3) {

            // Exception e = new Exception();
            throw new Exception();

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
                System.out.println("El email no es correcto");
            }
        }

    }
}
