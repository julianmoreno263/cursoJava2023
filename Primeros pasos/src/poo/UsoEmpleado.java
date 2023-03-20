/*en este ejercicio veremos como se puede programar en java en un unico archivo, pero es mejor hacerlo de la forma modular,en varios archivos, este ejercicio es para ver que tambien se uede hacer todo en un unico archivo pero lo mejor es usar la modularizacion. Haremos un programa para poder crear objetos de tipo empleado y que tengan propiedades y metodos.Recordar que la clase principal es la que tiene el metodo main y desde alli se ejecuta el programa,y habra una clase que es donde se crea el metodo constructor para crear los objetos de tipo Empleado. Para crear la fechaAlta usamos la clase Date del paquete java.util(importamos este paquete), y para construir esta fecha debemos usar la clase GregorianCalendar del mismo paquete java.util, esta clase tiene varios constructores porque se pueden crear diferentes tipos o formatos de fechas,usaremos el segundo constructor que nos pide un dia,mes y año de tipo int, tener en cuenta que los meses los comienza a contar desde cero,osea enero es el mes 0,etc,entonces ponemos mes-1 para que comienze a contar los meses desde 1 y no haya problema.Entonces para crear esta fecha como usamos esta clase GregorianCalendar debemos crear un objeto de esa clase.Ahora para que en la variable fechaAlta se almacene lo que le pasemos a este objeto GregorianCalendar usamos un metodo de esta clase llamado getTime() que me devuelve la fecha.Si vemos la api,GregorianCalendar no tiene este metodo,es porque esta clase esta heredando a la vez de la clase Calendar la cual tiene el metodo getTime() y este metodo devuelve un objeto de tipo Date,ver v34. Una vez creada la clase Empleado,podemos pasar a la clase main UsoEmpleado y comenzar a crear objetos de tipo Empleado,recordar que los meses comienzan a contar desde cero,entonces el mes 12 sera noviembre. Podemos hacer un codigo alternativo a la hora de crear los objetos y utilizarlos en la clase main para que sea menos codigo,utilizando un array para almacenar los objetos creados y despues recorrerlos con un for o con un for-each(for mejorado).

NOTA: A PESAR DE QUE ESTE EJERCICIO LO HICIMOS EN UN SOLO ARCHIVO, CUANDO SE GENERA EL CODIGO BYTECODES AL COMPILAR, SE GENERA UN ARCHIVO .CLASS POR CADA CLASE QUE HAYAMOS CREADO EN EL PROGRAMA.

-------------------------------------------------------------------------

La sobrecarga de constructores se refiere a que en una clase de java es posible crear varios metodos constructores para darles el estado inicial a los objetos de esa clase.(v39)

La clase puede tener varios constructores,estos pueden tener el mismo nombre de la clase,pero no pueden tener el mismo numero de argumentos ni del mismo tipo. Se pueden crear varios constructores por ejemplo en esta clase, tenemos un primer constructor que le da un estado inicial a los objetos y les asigna un nombre,un sueldo y una fecha de alta,pero por ejemplo necesitamos crear un objeto empleado del cual sabemos solo el nombre,por ejemplo un empleado que llego a la empresa hace poco, y no sabemos el sueldo ni la fecha de alta, entonces para poder darle estado inicial a ese objeto podemos hacer otro constructor que solo asigne el nombre.El jdk sabe a cual constructor debe llamar segun el numero de argumentos que pasemos cuando creamos el objeto,porque como los constructores no pueden tener el mismo numero de argumentos,el jdk los diferencia asi.

NOTA: CUANDO ALGO NOS SALE null, ES PORQUE SE REFIERE A UN OBJETO SIN VALOR,QUE NO TIENE UN VALOR ESTABLECIDO,Y ES UN OBJETO, NO ES UN TIPO PRIMITIVO DE DATOS COMO INT,ETC,POR ESO SALE null.

Ahora, si debo crear varios objetos de los cuales solo se el nombre,puedo darles un sueldo y fecha por defecto utilizando en ese segundo constructor el primer constructor que me deja poner los 5 argumentos,para llamar a ese primer constructor dentro del segundo utilizo el this. Cuando utilice el segundo constructor que solo me pide un nombre,dentro de este llamo al primer constructor con this() y alli dentro le paso los argumentos por defecto que le dare a esos objetos de los que solo se el nombre. Por ultimo,en java una clase puede crearse sin metodo constructor,depende lo que haga la clase, en estos casos se estara usando el constructor por defecto,es un constructor vacio. Tambien como puede haber sobrecarga de constructores en un programa java, tambien puede haber sobrecarga de metodos, esto es tener mas de un metodo con el mismo nombre pero con diferente numero de parametros, mas adelante lo veremos.
*/

/*------------------------------------------------------------------------------ */

/*en este mismo ejercicio vamos a implementar la herencia, como esta clase Empleado me sirve para convertirla en clase padre de otras subclases,por ejemplo la clase Jefatura,porque un jefe es un empleado,pues vamos a realizar aqui la herencia de clases(recordar que vamos a hacer este programa en este mismo archivo,aqui estara todo).
 


 */

package poo;

import java.util.*;

//clase main
public class UsoEmpleado {
    public static void main(String[] args) {

        // objetos de tipo Jefatura
        Jefatura jefeRRHH = new Jefatura("Juan", 55000, 2006, 9, 25);
        jefeRRHH.setIncentivo(2500);

        // creacion de objetos de tipo Empleado
        // Empleado empleado1 = new Empleado("Pepe trueno", 85000, 1990, 12, 22);

        // Empleado empleado2 = new Empleado("Ana lopez", 95000, 1995, 06, 02);

        // Empleado empleado3 = new Empleado("Maria Perez", 105000, 2002, 03, 15);

        // uso de los objetos
        // empleado1.setSubeSueldo(5);
        // empleado2.setSubeSueldo(5);
        // empleado3.setSubeSueldo(5);

        // System.out.println("Nombre: " + empleado1.getNombre() + " Sueldo: " +
        // empleado1.getSueldo() + " Fecha de alta: "
        // + empleado1.getFechaAlta());

        // System.out.println("Nombre: " + empleado2.getNombre() + " Sueldo: " +
        // empleado2.getSueldo() + " Fecha de alta: "
        // + empleado2.getFechaAlta());

        // System.out.println("Nombre: " + empleado3.getNombre() + " Sueldo: " +
        // empleado3.getSueldo() + " Fecha de alta: "
        // + empleado3.getFechaAlta());

        // codigo alternativo usando un array
        Empleado misEmpleados[] = new Empleado[6];

        misEmpleados[0] = new Empleado("Pepe trueno", 85000, 1990, 12, 22);
        misEmpleados[1] = new Empleado("Ana Lopez", 95000, 1995, 06, 02);
        misEmpleados[2] = new Empleado("Maria Perez", 105000, 2002, 03, 15);
        misEmpleados[3] = new Empleado("Antonio Fernandez");
        misEmpleados[4] = jefeRRHH;// aqui estamos usando el polimorfismo,principio de sustitucion

        /*
         * aqui podemos tambien almacenar un objeto tipo jefatura creandolo con el
         * constructor y almacenandolo en el array que es de tipo empleado,pero a la
         * hora de querer utilizar los metodos de la clase jefatura no lo podemos hacer
         * porque en si este objeto de tipo jefatura se almacena en una posicion de un
         * array de tipo empleado,esto pasa cuando almacenamos de este modo los objetos
         * de la subclase, si queremos ahora usar por ejemplo el metodo setIncentivo()
         * para este objeto de la posicion 5 debemos hacer una refundicion o casting,que
         * es pasar de un tipo de objeto a otro.El casting de objetos se hace igual que
         * con las variables, y al realizarlo ya puedo utilizar los metodos
         * correspondientes a ese objeto.Pero el casting se puede hacer utilizando la
         * reglade "es un...", osea viendo que un jefe es un empleado,pero un empleado
         * no siempre es un jefe,por lo que no se puede hacer un casting de un empleado
         * pasarlo a jefe.
         */
        misEmpleados[5] = new Jefatura("Ana Perez", 95000, 1999, 5, 26);
        Jefatura jefeFinanzas = (Jefatura) misEmpleados[5];// asi hago el casting de objetos
        jefeFinanzas.setIncentivo(55000);

        // primer for para subir el porcentaje del sueldo
        // for (int index = 0; index < misEmpleados.length; index++) {

        // misEmpleados[index].setSubeSueldo(5);
        // }

        // codigo con bucle for mejorado
        for (Empleado e : misEmpleados) {
            e.setSubeSueldo(5);
        }

        // segundo for para mostrar la informacion de los empleados
        // for (int index = 0; index < misEmpleados.length; index++) {

        // System.out.println("Nombre: " + misEmpleados[index].getNombre() + " Sueldo: "
        // + misEmpleados[index].getSueldo() + " Fecha de alta: " +
        // misEmpleados[index].getFechaAlta());
        // }

        // segundo for mejorado para mostrar los datos de los empleados
        for (Empleado e : misEmpleados) {

            System.out.println("Nombre: " + e.getNombre() + " Sueldo: "
                    + e.getSueldo() + " Fecha de alta: " + e.getFechaAlta());
        }

    }
}

// clase con metodo constructor para crear los objetos, esta es la clase padre.
class Empleado {

    // propiedades
    private String nombre;
    private double sueldo;
    private Date fechaAlta;

    // constructor 1
    public Empleado(String nom, double sue, int año, int mes, int dia) {

        this.nombre = nom;
        this.sueldo = sue;
        // asi contruyo la fecha,utilizando la clase GregorianCalendar y su metodo
        // getTime()
        GregorianCalendar calendario = new GregorianCalendar(año, mes - 1, dia);
        this.fechaAlta = calendario.getTime();

    }

    // constructor 2
    public Empleado(String nom) {

        // this.nombre = nom;

        // asi utilizo el primer constructor para darle valores por defecto a objetos de
        // los que solo se el nombre
        this(nom, 3000, 2002, 01, 01);
    }

    // metodos getter
    public String getNombre() {

        return this.nombre;
    }

    public double getSueldo() {

        return this.sueldo;
    }

    public Date getFechaAlta() {

        return this.fechaAlta;
    }

    // metodo setter,recibira un parametro de tipo double que sera el porcentaje a
    // ser aumentado
    public void setSubeSueldo(double porcentaje) {

        double aumento = this.sueldo * (porcentaje / 100);
        sueldo += aumento;
    }
}

/*
 * 
 */
class Jefatura extends Empleado {

    private double incentivo;

    // metodo constructor
    public Jefatura(String nom, double sue, int año, int mes, int dia) {

        // como la clase padre Empleado tiene dos constructores y ambos reciben
        // parametros, estamos obligados a pasarle al constructor padre(super) los
        // parametros,ya sea los 5 del primer constructor o el unico parametro del
        // segundo. Entonces,como vamos a utilizar el primer constructor padre, al
        // constructor de Jefatura le pasamos los 5 parametros,cuando creemos un objeto
        // tipo jefe le pasamos estos 5 parametros,ya almacenados estos parametros se
        // pasan al constructor padre(super) el cual sabe que debe operar con el primer
        // constructor y asi crea el objeto.

        /*
         * ahora, esta clase tambien tendra un metodo propio para los jefes para poder
         * darles un incentivo. Ahora,debo ahcer un getter para que me devuelva el
         * sueldo de un jefe, en la clase padre tenemos un metodo llamado
         * getSueldo(),pero este no nos sirve porque este metodo se refiere a un sueldo
         * de un empleado normal y no al de un jefe que recibe ademas un incentivo,por
         * lo que se debe hacer una sobreescritura de metodo,osea,utilizamos ese metodo
         * getSueldo() pero dentro creamos un codigo diferente para que me permita
         * adicionar el incentivo que establecimos para el jefe.Cuando hacemos una
         * sobreescritura de metodos vsc nos lo indica con @Override encima del metodo,
         * esto por el plugin instalado de java.Hay que indicarle a java que vamos a
         * utilizar el metodo getSueldo pero de la superclase poniendo super delante del
         * metodo,osea, el getSueldo que creamos para jefe es uno diferente al getSueldo
         * de super que es el sueldo del emleado,por lo que tenemos que indicarlo,si
         * solo dejamos sueldoJefe=getSueldo(),java interpreta ese getSueldo como el
         * metodo pero de la clase jefe y este metodo no es el que tiene el sueldo de un
         * empleado por lo que no tiene un valor establecido para operar con el,lo que
         * necesitamos es traer el sueldo del empleado con super.getSueldo() y a este
         * sumarle el incentivo.
         * 
         * -----------------------------------------------------------------
         * 
         * El "polimorfismo" quiere decir que un objeto se puede comportar de una forma
         * u
         * otra dependiendo del contexto.Esto utiliza el principio de sustitucion,el
         * cual dice que se puede utilizar un objeto de la subclase siempre que el
         * programa espere un objeto de la superclase.Por ejemplo, podemos crear un
         * objeto tipo jefe que hereda de Empleado, ahora,ya creado este objeto lo
         * podemos guardar en el array misEmpleados en donde estamos guardando objetos
         * de tipo Empleado,para esto debemos aumentar a 5 el array para que espere otro
         * objeto mas: misEmpleados[5], y despues simplemente guardo en este array al
         * objeto jefe asi:
         * 
         * misEmplados[4]=jefeRRHH;
         * 
         * Aqui se utiliza el polimorfismo,se utiliza el principio de sustitucion porque
         * el array esta esperando un objeto de tipo empleado y le estamos pasando un
         * objeto tipo jefatura.(v43). En ultimas se puede hacer esto porque Jefatura
         * hereda de Empleado,estan relacionados. Porlo mismo, cuando recorremos ese
         * array con el for, en donde dentro de este for estamos llamando al metodo
         * getSueldo() para que nos traiga el sueldo de los objetos, java comienza a
         * recorrerlos y sabe de que tipo son los objetos y asi mismo llama a sus
         * correspondientes metodos,es decir, el metodo getSueldo() esta en la clase
         * empleado y hay otro getSueldo en jefatura el cual muestra el sueldo del jefe
         * con el incentivo, entonces java va recorriendo este array y sabe que metodo
         * getSueldo debe aplicar dependiendo del tipo de objeto,esto lo hace
         * automaticamente, porque aqui esta operando el polimorfismo.El jdk de java es
         * el que hace esto automaticamente,detecta el tipo de objeto y asi mismo
         * utiliza sus correspondientes metodos, esto es lo que se llama
         * "enlazado dinamico".
         * 
         * ---------------------------------- clases final ----------------------
         * 
         * Ahora, las clases pueden ser final,como las propiedades y los metodos, esto
         * implica que si establecemos una clase como final, no se podra continuar
         * heredando de esa clase,por ejemplo si en este momento quisieramos hacer una
         * clase Director que herede de Jefatura lo podemos hacer,pero si no queremos
         * que de jefatura se extiendan mas clases con la herencia la solucion es
         * declarar la clase Jefatura como final. Para declarar la clase Jefatura como
         * final es asi:
         * 
         * final class Jefatura extends Empleado{}
         * 
         * declaramos esta clase como final para detener aqui la cadena de la herencia y
         * de este modo ninguna clase podra hereda de Jefatura.
         * 
         * ---------------------metodos final ---------------------
         * 
         * Asi como las clases pueden ser final,tambien los metodo se pueden declarar
         * final,por ejemplo tenemos dos metodos getSueldo(), uno en la clase Empleado y
         * otro en Jefatura,si nosotros no quisieramos que en la clase Jefatura que
         * hereda de Empleado hubiera otro metodo con el mismo nombre pero que hace una
         * funcionalidad diferente(osea se sobreescriba),la solucion es declarar nuestro
         * metodo de Empleado como final, asi una clase aunque herede de Empleado no
         * podra sobreescribir ese metodo.Para declarar un metodo final seria asi:
         * 
         * public final double getSueldo(){}
         * 
         * Si necesitamos de todas formas crear ese metodo en la clase que hereda,lo
         * podemos llamar de forma diferente o simplemente obviamos la herencia,pero
         * depende de la logica del programa.Podemos ver en la api de java que hay
         * metodos y clases declarados como final,esto lo hacen esos programadores para
         * evitar que se creen metodos con el mismo nombre y se sobreescriban,igual con
         * las clases.
         */

        super(nom, sue, año, mes, dia);
    }

    // setter
    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    // getter utilizando sobreescritura de metodos con getSueldo()
    @Override
    public double getSueldo() {

        double sueldoJefe = super.getSueldo();
        return sueldoJefe + incentivo;
    }

}

// class Director extends Jefatura {

// public Director(String nom, double sue, int año, int mes, int dia) {

// super(nom, sue, año, mes, dia);
// }
// }

