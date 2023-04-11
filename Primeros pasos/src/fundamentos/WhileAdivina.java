package fundamentos;

/*bucle while, juego de adivina numero entre 0 y 100,utilizaremos la  clase scanner de java.util.Utilizamos el metodo random de la clase Math.random saca numeros entre 0.0 y 1,porque devuelve un double y su rango es solo entre 0.0 hasta 1.0, entonces para que nos saque un 100 multiplicamos random por 100 para que desplaze la coma dos decimales a la izquierda, y como debe ser un entero,pasamos el double a int utilizando refundicion. */

import java.util.*;

public class WhileAdivina {
    public static void main(String[] args) {

        // saco el numero aleatorio y lo paso a int
        int aleatorio = (int) (Math.random() * 100);

        Scanner entrada = new Scanner(System.in);

        int numero = 0;
        int intentos = 0;

        while (numero != aleatorio) {

            intentos++;

            System.out.println("Introduce un número entre 0 y 100");
            numero = entrada.nextInt();

            if (aleatorio < numero) {
                System.out.println("El número debe ser menor");
            } else if (aleatorio > numero) {
                System.out.println("El número debe ser mayor");
            }

        }

        System.out.println("Número correcto, adivinaste en " + intentos + " intentos!!");

        entrada.close();
    }
}
