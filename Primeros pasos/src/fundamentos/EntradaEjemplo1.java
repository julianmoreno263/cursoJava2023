import java.util.*;

public class EntradaEjemplo1 {
    public static void main(String[] args) {
        /*
         * System.in es la misma consola del sistema pero para sacar informacion. La
         * clase Scanner tiene metodos para entrar informacion,uno es nextLine() que
         * sirve para meter texto, como este metodo es dinamico(para invocarlo se debe
         * poner el nombre de la instancia de la clase,estatico se debe poner primero el
         * nombre de la clase antes del metodo), entonces creamos un objeto de clase
         * Scanner y lo creamos con el metodo constructor Scanner que pide como
         * parametro el archivo especificado,osea la consola de entrada(System.in).Si
         * vemos la api de java, si un metodo es estatico lo indica en la parte
         * izquierda del metodo con la palabra static, si no lo es no lo indica,se sabe
         * que se debe entonces crear un objeto de la clase.
         */

        Scanner entrada = new Scanner(System.in);// aqui creamos el objeto

        System.out.println("Introduce tu nombre, por favor");
        String nombreUsuario = entrada.nextLine();// aqui usamos el metodo con el objeto

        System.out.println("Introduce tu edad, por favor");
        int edadUsuario = entrada.nextInt();

        System.out.println("Hola " + nombreUsuario + " el próximo año tendras " + (edadUsuario + 1) + " años");

        entrada.close();// se cierra el objeto despues de utilizarse

    }
}
