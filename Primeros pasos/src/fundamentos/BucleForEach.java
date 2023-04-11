package fundamentos;

/*el bucle for-each(por cada) se creo para poder recorrer arrays mas facil. vamos a crear un array de string y la llenaremos con nombres de paises por medio de una ventana JOptionPane. */

import javax.swing.*;

public class BucleForEach {
    public static void main(String[] args) {

        // para rellenar el array uso un for
        String paises[] = new String[8];

        for (int index = 0; index < 8; index++) {

            paises[index] = JOptionPane.showInputDialog("Ingresa el país " + (index + 1));
        }

        // String paises[] = { "España", "Mexico", "Colombia", "Chile", "Peru",
        // "Argentina", "Ecuador", "Venezuela" };

        // recorrer array con for
        // for (int index = 0; index < paises.length; index++) {

        // System.out.println("País " + (index + 1) + " = " + paises[index]);
        // }

        // for-each,se declara variable del mismo tipo del array y dos puntos
        for (String pais : paises) {

            System.out.println("País: " + pais);
        }
    }
}
