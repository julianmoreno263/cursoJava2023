/*en java el uso del paquete por defecto java.lang esta desaconsejado, osea se debe crear paquetes para las clases que estan relacionadas entre si,esto es para dar un mejor orden al codigo,osea es ordenar por carpetas.
 * 
 El metodo constructor da un estado inicial a los objetos que se crean de una clase, el constructor comienza con la palabra public y debe llevar el mismo nombre de la clase.

 La modularizacion es dividir el programa en clases para hacerlo mas legible,y manejable, siempre habra una clase principal que es la que lleva el metodo main,y a partir de ese unico metodo main es que se comienza a ejecutar el programa que este modularizado.

 Encapsulacion es hacer que la funcionalidad de una clase solo se pueda hacer dentro de esa clase,osea,que cada clase que tiene sus funciones definidas no puedan ejecutar funciones de otra clase,por eso se llama encapsulacion.En nuestro ejemplo de Coche, como no hemos encapsulado nada, puedo desde la clase main de UsoCoche.java cambiar el numero de ruedas de los objetos,lo cual no esta bien porque el numero de ruedas se establecio en el constructor de la clase Coche y solo alli se deberia poder cambiar esa propiedad.Entonces para encapsular estas propiedades y que no puedan ser modificadas desde otra clase del programa les debemos poner un modificador de acceso "private".Ahora, como las propiedades quedan encapsuladas,ya no son accesibles por otras clases,solo se pueden acceder en la clase en que se declararon,osea la clase Coche,para poder acceder desde otra clase a las propiedades encapsuladas debemos usar metodos getters(captura el valor de una propiedad) y setters(establece el valor de una propiedad) y asi interactuan las clases, atraves de metodos.

 Un metodo getter debe tener esta sintaxis:
 1-palabra public - para que pueda usarse en cualquier parte del programa
 2- tipo de dato que queremos que nos devuelva,si solo queremos que nos devuelva un int por ejemplo,le ponemos int,pero si queremos concatenar ese int con string pues debemos ponerle String.
 3- nombre del metodo,generalmente por convencion siempre comienza con get
 5-entre {} el codigo que ejecutara el metodo y la instruccion return porque debe devolvernos algo.

 estos metodos se crean en la clase donde esta el constructor. Aqui creamos los metodos setter y getters y podemos manipular las variables aunque sean private,porque las variables private son accesibles solo dentro de la misma clase donde se declaran. Ahora el objeto de clase Coche ya puede usar este metodo desde la clase UsoCoche. De este modo ya evitamos que se puedan cambiar los valores de las propiedades y nos generen codigo erroneo, solo se podra acceder a las propiedades desde los metodos correspondientes, esto son buenas practicas de programacion.
 
 Los setters me serviran para darle los valores propios de cada coche a la hora de hacer difernetes objetos.La sintaxis del setter es:
 1-palabra public
 2- palabra void(no devuelve dato,osea no tiene un return)
 3-nombre del metodo y entre {} el codigo del metodo.

 NOTA: AQUI EN VSC CON EL PLUGIN QUE INSTALE DE JAVA, PONGO GET O SET Y EL ME DA LAS OPCIONES PARA CREAR AUTOMATICAMENTE LOS METODOS GETTER Y SETTER SEGUN LAS PROPIEDADES QUE TENGA DEFINIDAS.
 */

package poo;

public class Coche {

    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int pesoChasis;

    // estas propiedades podran variar
    String color;
    int pesoTotal;
    boolean asientosCuero, climatizador;

    // metodo constructor
    public Coche() {

        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        pesoChasis = 500;
    }

    // metodos getters
    public String getLargo() {
        return "El largo del coche es " + largo + " cms";
    }

    public String getColor() {
        return "El color del coche es " + color;
    }

    // setters
    public void setColor() {
        color = "azul";
    }

}
