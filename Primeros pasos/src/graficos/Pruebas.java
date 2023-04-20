/*esta clase es para solo probar que tipo de letras tenemos instaladas en el PC ,utilizamos la clase GraphicsEnvironment que tiene metodos para esto.Como uno de estos metodos nos devuelve un array de String para alamcenar los resultados,creamos un objeto que sea array de string.Podemos con esto hacer un programa que nos diga si tenemos una fuente especifica instalada o no. */

package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class Pruebas {
    public static void main(String[] args) {

        String nombreFuente = JOptionPane.showInputDialog("Introduce fuente", args);
        boolean estaLaFuente = false;

        String nombreFuentes[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String fuente : nombreFuentes) {
            if (fuente.equals(nombreFuente)) {
                estaLaFuente = true;
            }
        }

        if (estaLaFuente) {
            System.out.println("Está instalada la fuente");
        } else {
            System.out.println("No está instalada");
        }
    }
}
