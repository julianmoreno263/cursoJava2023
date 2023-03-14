/*en este ejercicio veremos como se puede programar en java en un unico archivo, pero es mejor hacerlo de la forma modular,en varios archivos, este ejercicio es para ver que tambien se uede hacer todo en un unico archivo pero lo mejor es usar la modularizacion. Haremos un programa para poder crear objetos de tipo empleado y que tengan propiedades y metodos.Recordar que la clase principal es la que tiene el metodo main y desde alli se ejecuta el programa,y habra una clase que es donde se crea el metodo constructor para crear los objetos de tipo Empleado. Para crear la fechaAlta usamos la clase Date del paquete java.util(importamos este paquete), y para construir esta fecha debemos usar la clase GregorianCalendar del mismo paquete java.util, esta clase tiene varios constructores porque se pueden crear diferentes tipos o formatos de fechas,usaremos el segundo constructor que nos pide un dia,mes y año de tipo int, tener en cuenta que los meses los comienza a contar desde cero,osea enero es el mes 0,etc,entonces ponemos mes-1 para que comienze a contar los meses desde 1 y no haya problema.Entonces para crear esta fecha como usamos esta clase GregorianCalendar debemos crear un objeto de esa clase.Ahora para que en la variable fechaAlta se almacene lo que le pasemos a este objeto GregorianCalendar usamos un metodo de esta clase llamado getTime() que me devuelve la fecha.Si vemos la api,GregorianCalendar no tiene este metodo,es porque esta clase esta heredando a la vez de la clase Calendar la cual tiene el metodo getTime() y este metodo devuelve un objeto de tipo Date,ver v34. Una vez creada la clase Empleado,podemos pasar a la clase main UsoEmpleado y comenzar a crear objetos de tipo Empleado,recordar que los meses comienzan a contar desde cero,entonces el mes 12 sera noviembre. Podemos hacer un codigo alternativo a la hora de crear los objetos y utilizarlos en la clase main para que sea menos codigo,utilizando un array para almacenar los objetos creados y despues recorrerlos con un for o con un for-each(for mejorado).

NOTA: A PESAR DE QUE ESTE EJERCICIO LO HICIMOS EN UN SOLO ARCHIVO, CUANDO SE GENERA EL CODIGO BYTECODES AL COMPILAR, SE GENERA UN ARCHIVO .CLASS POR CADA CLASE QUE HAYAMOS CREADO EN EL PROGRAMA.

-------------------------------------------------------------------------

La sobrecarga de constructores se refiere a que en una clase de java es posible crear varios metodos constructores para darles el estado inicial a los objetos de esa clase.(v39)

La clase puede tener varios constructores,estos pueden tener el mismo nombre de la clase,pero no pueden tener el mismo numero de argumentos ni del mismo tipo. Se pueden crear varios constructores por ejemplo en esta clase, tenemos un primer constructor que le da un estado inicial a los objetos y les asigna un nombre,un sueldo y una fecha de alta,pero por ejemplo necesitamos crear un objeto empleado del cual sabemos solo el nombre,por ejemplo un empleado que llego a la empresa hace poco, y no sabemos el sueldo ni la fecha de alta, entonces para poder darle estado inicial a ese objeto podemos hacer otro constructor que solo asigne el nombre.El jdk sabe a cual constructor debe llamar segun el numero de argumentos que pasemos cuando creamos el objeto,porque como los constructores no pueden tener el mismo numero de argumentos,el jdk los diferencia asi.

NOTA: CUANDO ALGO NOS SALE null, ES PORQUE SE REFIERE A UN OBJETO SIN VALOR,QUE NO TIENE UN VALOR ESTABLECIDO,Y ES UN OBJETO, NO ES UN TIPO PRIMITIVO DE DATOS COMO INT,ETC,POR ESO SALE null.

Ahora, si debo crear varios objetos de los cuales solo se el nombre,puedo darles un sueldo y fecha por defecto utilizando en ese segundo constructor el primer constructor que me deja poner los 5 argumentos,para llamar a ese primer constructor dentro del segundo utilizo el this. Cuando utilice el segundo constructor que solo me pide un nombre,dentro de este llamo al primer constructor con this() y alli dentro le paso los argumentos por defecto que le dare a esos objetos de los que solo se el nombre. Por ultimo,en java una clase puede crearse sin metodo constructor,depende lo que haga la clase, en estos casos se estara usando el constructor por defecto,es un constructor vacio. Tambien como puede haber sobrecarga de constructores en un programa java, tambien puede haber sobrecarga de metodos, esto es tener mas de un metodo con el mismo nombre pero con diferente numero de parametros, mas adelante lo veremos.
*/

package poo;

import java.util.*;

//clase main
public class UsoEmpleado {
    public static void main(String[] args) {

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
        Empleado misEmpleados[] = new Empleado[4];

        misEmpleados[0] = new Empleado("Pepe trueno", 85000, 1990, 12, 22);
        misEmpleados[1] = new Empleado("Ana Lopez", 95000, 1995, 06, 02);
        misEmpleados[2] = new Empleado("Maria Perez", 105000, 2002, 03, 15);
        misEmpleados[3] = new Empleado("Antonio Fernandez");

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

// clase con metodo constructor para crear los objetos
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
