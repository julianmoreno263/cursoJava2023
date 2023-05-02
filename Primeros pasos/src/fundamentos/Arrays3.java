package fundamentos;

/*vamos a ver como recorrer un array bidimensional de una forma mas facil,primero para declarar e iniciar un array bidimensional lo hacemos como si fuera un array normal pero ahora lo iniciamos con llaves anidadas. Para recorrerlo con el bucle for-each, lo hacemos igual , con la misma sintaxis del for-each,solo que habra un for-each anidado el cual recorrera la segunda dimension apuntando a la variable que va recorriendo la primera dimension,asi de esta forma, al entrar en el primer bucle pasa al for-each anidado y recorre toda esa primra dimension,cuandotermina salta de nuevo al primer bucle ya incrementado en uno y vuelve al for anidado y asi sucesivamente.*/

public class Arrays3 {
    public static void main(String[] args) {

        // matriz de dos dimensiones con 20 elementos
        int miArray[][] = {

                { 10, 15, 34, 56, 23 },
                { 34, 89, 100, 23, 57 },
                { 11, 2, 78, 71, 28 },
                { 15, 90, 70, 45, 17 },

        };

        // recorrer array bidimensional con for-each anidado
        for (int[] fila : miArray) {

            System.out.println();// este print es para dar un salto de linea

            for (int z : fila) {

                System.out.print(z + " ");
            }
        }
    }
}
