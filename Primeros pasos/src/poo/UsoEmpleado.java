/*en este ejercicio veremos como se puede programar en java en un unico archivo, pero es mejor hacerlo de la forma modular,en varios archivos, este ejercicio es para ver que tambien se uede hacer todo en un unico archivo pero lo mejor es usar la modularizacion. Haremos un programa para poder crear objetos de tipo empleado y que tengan propiedades y metodos.Recordar que la clase principal es la que tiene el metodo main y desde alli se ejecuta el programa,y habra una clase que es donde se crea el metodo constructor para crear los objetos de tipo Empleado. Para crear la fechaAlta usamos la clase Date del paquete java.util(importamos este paquete), y para construir esta fecha debemos usar la clase GregorianCalendar del mismo paquete java.util, esta clase tiene varios constructores porque se pueden crear diferentes tipos o formatos de fechas,usaremos el segundo constructor que nos pide un dia,mes y año de tipo int, tener en cuenta que los meses los comienza a contar desde cero,osea enero es el mes 0,etc,entonces ponemos mes-1 para que comienze a contar los meses desde 1 y no haya problema.Entonces para crear esta fecha como usamos esta clase GregorianCalendar debemos crear un objeto de esa clase.Ahora para que en la variable fechaAlta se almacene lo que le pasemos a este objeto GregorianCalendar usamos un metodo de esta clase llamado getTime() que me devuelve la fecha.Si vemos la api,GregorianCalendar no tiene este metodo,es porque esta clase esta heredando a la vez de la clase Calendar la cual tiene el metodo getTime() y este metodo devuelve un objeto de tipo Date,ver v34.*/

package poo;

import java.util.*;

//clase main
public class UsoEmpleado {
    public static void main(String[] args) {

    }
}

// clase con metodo constructor para crear los objetos
class Empleado {

    // propiedades
    private String nombre;
    private double sueldo;
    private Date fechaAlta;

    // constructor
    public Emleado(String nom,double sue,int año,int mes,int dia){
      
        this.nombre=nom;
        this.sueldo=sue;
        //asi contruyo la fecha,utilizando la clase GregorianCalendar y su metodo getTime()
        GregorianCalendar calendario=new GregorianCalendar(año,mes-1,dia);
        this.fechaAlta=calendario.getTime();

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
