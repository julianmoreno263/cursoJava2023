package fundamentos;

/*Vamos a ver los condicionales en java,primero el if. Con el else if hay que entender una cosa, si por ejemplo introducimos un 25, java va recorriendo de arriba a abajo, la primera condicion es falsa porque 25 no es menor a 18, entonces salta a la segunda condicion,el else if de 40, como 25 es menor de 40 la condicion es verdadera y ejecuta ese codigo y sale del condicional,osea java va viendo las condiciones en orden y la primera condicion que cumpla la condicion la ejecuta y sale,porque podriamos escribir un 15 y este numero cabe dentro de todas las condiciones pues es menor a 18,40 y 65, entonces nos podria sacar todos los mensajes,pero java solo toma la primera condicion que sea verdad y la ejecuta y listo,por eso el programa funciona bien. */

import java.util.*;

public class CondicionalIf {
    public static void main(String[] args) {

        Scanner edad = new Scanner(System.in);

        System.out.println("Introduce tu edad");

        int edadUsuario = edad.nextInt();

        if (edadUsuario < 18) {
            System.out.println("Eres adolescente");
        } else if (edadUsuario < 40) {
            System.out.println("Eres joven");
        } else if (edadUsuario < 65) {
            System.out.println("Eres maduro");
        } else {
            System.out.println("Cuidate!");
        }

        edad.close();
    }
}
