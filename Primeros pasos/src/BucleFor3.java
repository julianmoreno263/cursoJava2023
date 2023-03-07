/*vamos a ver otro ejercicio con for, sera un rograma que calcule el factorial de un numero, el factorial de un numero es el numero que nos dan multiplicado por todos los que le preceden,osea, nos dan un 6,el factorial sera el resultado de multiplicar 6x5x4x3x2x1. Para numeros grandes debemos poner la variable resultado de tipo Long para que pueda almacenar este tipo de datos grandes y asi nos de resultados correctos, pero incluso con long se llega a desbordar el resultado, hay una clase BigInteger para manejar datos mas grandes que el long,pero lo veremos despues. */

import javax.swing.*;

public class BucleFor3 {
    public static void main(String[] args) {

        Long resultado = 1L;
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa número para calcular factorial", args));

        for (int index = numero; index > 0; index--) {

            resultado = resultado * index;
        }

        System.out.println("El factorial del número " + numero + " es " + resultado);
    }
}
