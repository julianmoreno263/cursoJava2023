/*en java el uso del paquete por defecto java.lang esta desaconsejado, osea se debe crear paquetes para las clases que estan relacionadas entre si,esto es para dar un mejor orden al codigo,osea es ordenar por carpetas.
 * 
 El metodo constructor da un estado inicial a los objetos que se crean de una clase, el constructor comienza con la palabra public y debe llevar el mismo nombre de la clase.
 */

package poo;

public class Coche {

    int ruedas;
    int largo;
    int ancho;
    int motor;
    int peso;

    // metodo constructor
    public Coche() {

        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        peso = 500;
    }
}
