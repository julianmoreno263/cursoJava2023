package fundamentos;

/*El bucle while repite un bloque de codigo en un indeterminado numero de veces,osea no se sabe cuantas veces lo repita,depende de la condicion que este evaluando,solo hasta que esa condicion sea falsa deja de repetir el codigo.Aqui el bucle se ejecuta hasta que el usuario introduzca bien el password.Aqui el if hace que pueda cambiar la condicion de falso a verdadero.Siempre en un bucle toca crear un codigo que pueda hacer que la condicion cambie,o si no se vuelve un bucle infinito. */

import javax.swing.*;

public class BucleWhile {
    public static void main(String[] args) {

        String clave = "jota";
        String password = "";

        while (clave.equals(password) == false) {
            password = JOptionPane.showInputDialog("Introduce la clave");

            if (clave.equals(password) == false) {
                System.out.println("Contraseña incorrecta");
            }
        }

        System.out.println("Acceso permitido!");

    }
}
