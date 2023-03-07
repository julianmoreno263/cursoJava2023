/*En este ejercicio vemos otra forma de entrar datos pero utilizando la clase JOptionPane que viene del paquete javax.swing, esta clase tiene varios metodos para esto,utilizaremos el metodo showInputDialog() el cual devuelve un string, este metodo crea una ventana de entrada de datos grafica.Si lo que quiero es introducir un numero,debo parsear este metodo showInputDialog con el metodo parseInt de la clase Integer.
 * 
 NOTA: si quiero formatear un numero para que tenga por ejemplo solo dos decimales utilizo el metodo printf() de la clase NumberFormat, este metodo me pide el formato y el valor al que voy a aplicarle formato, para establecer por ejemplo el formato en dos decimales pongo : "%1.2f" y asi le aplico un formato a un valor numerico.
 */

import javax.swing.*;

public class EntradaEjemplo2 {
    public static void main(String[] args) {

        String nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre");

        int edadUsuario = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));

        System.out.println("Hola " + nombreUsuario + " el año que viene tendrás " + (edadUsuario + 1) + " años");
    }
}
