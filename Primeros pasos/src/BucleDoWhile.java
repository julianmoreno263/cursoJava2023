/*el otrobucle indeterminado es el do-while,se ejecuta al menos una vez el codigo de su interior aunque la condicion sea falsa, haremos un programa que calcule el peso de una persona,utilizaremos como entrada JOptionPane de javax.swing.El usuario debe introducir las letras h o m(sin importar si son mayusculas o minusculas) si introduce por ejemplo la palabra "hombre","mujer",u otra cosa, el bucle le sigue sacando la ventana,el peso se calcula segun el genero.El codigo del while se puede interpretar como: si el string genero es diferente a una h y el string genero es diferente a una m, se repetira el bucle. */

import javax.swing.*;

public class BucleDoWhile {
    public static void main(String[] args) {

        String genero = "";

        do {

            genero = JOptionPane.showInputDialog("Introduce tu género (H/M)");

        } while (genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);

        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));

        int pesoIdeal = 0;

        if (genero.equalsIgnoreCase("H")) {

            pesoIdeal = altura - 110;

        } else if (genero.equalsIgnoreCase(("M"))) {
            pesoIdeal = altura - 120;
        }

        System.out.println("Tu peso ideal es " + pesoIdeal + " Kgs");
    }
}
