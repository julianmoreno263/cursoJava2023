package fundamentos;

public class ManipulaCadenas {
    public static void main(String[] args) {
        // manipulacion de cadenas con la clase String,en java el string no es un dato
        // primitivo,es una clase que se maneja con la clase String y sus metodos, por
        // lo que para manipular cadenas creamos un objeto de clase String.

        String nombre = "Julian";

        System.out.println("Mi nombre es " + nombre);
        System.out.println("Mi nombre tiene " + nombre.length() + " letras");
        System.out.println("La primera letra de mi nombre es la " + nombre.charAt(0));

        // con ultimaLetra-1, indico que a ultima letra que vale 4 le reste 1,asi si
        // vemos nos devolvera el ultimo caracter de lo que haya en nombre
        int ultimaLetra = nombre.length();
        System.out.println("La última letra del nombre " + nombre + " es la letra " + nombre.charAt(ultimaLetra - 1));

        // con substring podemos sacar una parte de una cadena,le pasamos indice d
        // einicio y de final,los espacios en blanco tambien cuentan
        String frase = "Hoy es un estupendo día para aprender a programar en Java";
        String fraseResumen = frase.substring(29, 57);
        System.out.println(fraseResumen);

        // equals compara si dos strings son iguales o no,devuelve true o
        // false,equalsIgnoreCase no distingue sistring esta en matyusculas o
        // minusculas.

        String alumno1, alumno2;
        alumno1 = "David";
        alumno2 = "david";

        System.out.println(alumno1.equals(alumno2));
        System.out.println(alumno1.equalsIgnoreCase(alumno2));

    }
}
