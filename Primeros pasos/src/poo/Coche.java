/*en java el uso del paquete por defecto java.lang esta desaconsejado, osea se debe crear paquetes para las clases que estan relacionadas entre si,esto es para dar un mejor orden al codigo,osea es ordenar por carpetas.
 * 
 El metodo constructor da un estado inicial a los objetos que se crean de una clase, el constructor comienza con la palabra public y debe llevar el mismo nombre de la clase.

 La modularizacion es dividir el programa en clases para hacerlo mas legible,y manejable, siempre habra una clase principal que es la que lleva el metodo main,y a partir de ese unico metodo main es que se comienza a ejecutar el programa que este modularizado.

 Encapsulacion es hacer que la funcionalidad de una clase solo se pueda hacer dentro de esa clase,osea,que cada clase que tiene sus funciones definidas no puedan ejecutar funciones de otra clase,por eso se llama encapsulacion.En nuestro ejemplo de Coche, como no hemos encapsulado nada, puedo desde la clase main de UsoCoche.java cambiar el numero de ruedas de los objetos,lo cual no esta bien porque el numero de ruedas se establecio en el constructor de la clase Coche y solo alli se deberia poder cambiar esa propiedad.Entonces para encapsular estas propiedades y que no puedan ser modificadas desde otra clase del programa les debemos poner un modificador de acceso "private".Ahora, como las propiedades quedan encapsuladas,ya no son accesibles por otras clases,solo se pueden acceder en la clase en que se declararon,osea la clase Coche,para poder acceder desde otra clase a las propiedades debemos usar metodos,pero no para modificar las propiedades,porque estas ya estan encapsuladas,sino para usarlas nada mas.
 */

package poo;

public class Coche {

    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int peso;

    // metodo constructor
    public Coche() {

        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        peso = 500;
    }
}
