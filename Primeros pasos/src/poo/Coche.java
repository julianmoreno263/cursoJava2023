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

 A los metodos se les pueden pasar parametros, estos son valores que se les pueden pasar para que operen con esos valores y asi el usuario que llame al metodo le pueda pasar un valor que quiera para que el metodo ejecute el codigo con ese valor,en el momento el setter setColor establece el color en azul,es fijo,pero si quiero que los objetos que yo haga sean de colores diferentes les paso un parametro. Cuando vayamos a llamar dentro del metodo a una variable o a otro metodo,debemos referenciar estas variables o metodos con "this", This hace referencia al objeto actual de la clase, es decir, a un objeto concreto de la clase y nos sirve para usar los métodos y atributos de esa clase desde alguno de sus métodos, para llamar a otro de sus constructores o simplemente para pasarle el objeto completo a algún otro método u objeto.Cuando a un metodo le pasamos un parametro con el mismo nombre de una propiedad de la clase,por ejemplo al setter de setColor() le pasamos el parametro color setColor(color) podemos diferenciar la variable color de la clase con el parametro color con el this, el this.color hace referencia a la variable de la clase,y asi no hay confusion.

 NOTA: RECORDAR QUE TODAS LAS PROPIEDADES DEBEN SER PRIVATE,DEBEN IR ENCAPSULADAS PARA QUE NO SE PUEDAN MANIPULAR DESDE OTRA CLASE A MENOS QUE SE USEN LOS METODOS INDICADOS,LOS CUALES SON LOS QUE PERMITEN LA COMUNICACION ENTRE CLASES.

 NOTA: EN LOS IF DE LOS SETTERS DONDE COMPARAMOS EL PARAMETRO DE TIPO sTRING CON EL STRING "SI", LO HACEMOS USANDO EL METODO EQUALS,PORQUE EN JAVA SE DEBE USAR EL EQUALS PARA COMPARAR STRINGS,NO SE USA EL ==, AUNQUE EN ESTE CODIGO FUNCIONARIA IGUAL,PERO SE DEBE USAR EL METODO EQUALS DE LA CLASE STRING, O EL METODO EQUALSIGNORECASE PARA QUE NO HAYA PROBLEMA SI SON MAYUSCULAS O MINUSCULAS.


 */

package poo;

public class Coche {

    // declaramos propiedades
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int pesoChasis;

    // estas propiedades podran variar
    private String color;
    private int pesoTotal;
    private boolean asientosCuero, climatizador;

    // metodo constructor
    public Coche() {

        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        pesoChasis = 500;
    }

    // --------------------------------------------------------------------------------------------

    // metodos getters
    // public String getLargo() {
    // return "El largo del coche es " + largo + " cms";
    // }

    public String getDatosGenerales() {
        return "El vehículo tiene " + ruedas + " ruedas, mide " + (largo / 1000) + " mts, con un ancho de "
                + (ancho) + " cms, y un peso de chasis de " + pesoChasis + " kg.";
    }

    public String getColor() {
        return "El color del coche es " + color;
    }

    public String getAsientos() {

        if (this.asientosCuero == true) {

            return "El coche tiene asientos de cuero";
        } else {

            return "El coche  tiene asientos de fabrica";
        }
    }

    public String getClimatizador() {

        if (this.climatizador == true) {

            return "El coche tiene climatizador";
        } else {

            return "El coche  tiene aire acondicionado";
        }
    }

    // -------------------------------------------------------------------------------

    // setters
    public void setColor(String color) {
        this.color = color;
    }

    public void setAsientosCuero(String asientosCuero) {

        if (asientosCuero.equalsIgnoreCase("si")) {
            this.asientosCuero = true;
        } else {
            this.asientosCuero = false;
        }
    }

    public void setClimatizador(String climatizador) {

        if (climatizador.equalsIgnoreCase("si")) {
            this.climatizador = true;
        } else {
            this.climatizador = false;
        }

    }

    // aqui vamos a hacer un metodo que sera un setter y un getter a la vez,esto no
    // se debe hacer por buenas practicas,lo correcto es hacer los setters y getters
    // separados,pero para este ejercicio no hay mucho problema, es un getter porque
    // nos devuelve en un return el pesoTotal, osea nos devuelve algo, y es un
    // setter porque aqui estamos estableciendo valores para las variables.
    public String getPesoTotal() {

        int pesoCarroceria = 500;
        this.pesoTotal = this.pesoChasis + pesoCarroceria;

        if (this.asientosCuero == true) {
            pesoTotal = pesoTotal + 50;
        }
        if (this.climatizador == true) {
            pesoTotal = pesoTotal + 20;
        }

        return "El peso total del coche es " + pesoTotal;
    }

    // aqui hacemos otro metodo getter normal, porque no estamos cambiando el valor
    // de ninguna variable de clase, ,inicialmente los vehiculos sin accesorios
    // valdran 10000,si llevan accesorios van aumentando el valor.Utilizamos el
    // operador += que es lo mismo que hacer precioFinal=precioFinal+2000.

    public int getPrecioFinal() {
        int precioFinal = 10000;

        if (this.asientosCuero == true) {
            precioFinal += 2000;
        }
        if (this.climatizador == true) {
            precioFinal += 1500;
        }

        return precioFinal;
    }

}
