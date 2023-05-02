/*--------------clases y metodos abstractos--------------------------------

(v45). Ahora, como tenemos hasta ahora estructurada la herencia con estas clases todo va bien, pero podemos crear una clase por encima de la clase empleado mas generica(abstracta) que podria ser la clase "Persona", porque un empleado "es una persona", asi mismo un jefe es una persona,por lo que esta clase Persona estaria por encima en la cadena de la herencia. Ahora, en la clase Empleado tenemos un metodo llamado getNombre(), si vemos la logica,podemos llevarnos este metodo a la clase Persona porque una persona siempre tiene un nombre,entonces este metodo se puede trasladar alli.Si creamos una clase llamada Alumno que herede directamente de Persona,porque un alumno es una persona ya tenemos una herencia mas estructurada,por un lado estaran las clases que heredan de Persona y van por el lado de Empleado,y por otro estara la clase Alumno que hereda de Persona,el metodo getNombre les funciona bien a ambas clases que se dividen de Persona.Ahora,podemos crear un metodo para que nos devuelva la descripcion de cada clase,osea,un metodo getDescripcion() que sirva para darnos la descripcion de los Empleados y los alumnos,pero aqui surge un inconveniente, la descripcion para un empleado y un alumno es diferente,porque un empleado tiene un sueldo,uncargo,una fecha de alta,y un alumno no tiene estos parametros,aqui es donde se necesita crear un metodo abstracto,el cual es un metodo generico que se puede sobreescribir para que realice la funcion que necesitamos en cada caso, este metodo lo declaramos en la clase Persona que es donde heredan los demas,para declarar un metodo abstracto es asi: "public abstract String getDescripcion();"El metodo abstracto no tiene {}, simlemente se declara hasta los parentesis y no mas, en el caso de este metodo nos devolvera por ejemplo un String para la descripcion.Cuando declaramos en una clase un metodo abstracto,automaticamente la clase sera abstracta,y para declararla es asi: "abstract class Persona{aqui va el codigo de la clase ...}". Esto es una clase abstarcta,la clase que tiene metodos abstractos,que por lo general es la mas generica,la que esta en la cima de la cadena de la herencia.

NOTA: CUANDO DEFINIMOS UN METODO ABSTRACTO, ESTO OBLIGA A LAS CLASES QUE HEREDAN DE ESA CLASE ABSTRACTA A SOBREESCRIBIR EL METODO ABSTRACTO.LAS CLASES Y METODOS ABSTRACTOS SIRVEN PARA DISEÑAR BIEN LA LOGICA DE LA HERENCIA EN UN PROGRAMA.UNA CLASE ABSTRACTA ES LA QUE MARCA EL DISEÑO EN LA JERARQUIA DE LA HERENCIA,SEGUN LA LOGICA QUE QUERAMOS IMPLEMENTAR.

crearemos en este archivo una cadena de herencia simple utilizando lo que ya teniamos en la clase Empleado para ver como usar los metodos y clases abstractas.Recordar que no pueden existir dos clases en el mismo paquete con el mismo nombre,asi que a la clase Empleado que copiamos le cambiamos el nombre.

*/

package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {
    public static void main(String[] args) {

        // array para almacenar los diferentes objetos de las subclases
        Persona lasPersonas[] = new Persona[2];

        lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 02, 25);
        lasPersonas[1] = new Alumno("Sandra", "contabilidad");

        // for mejorado,se pone el tipo de dato que sera el del array a recorrer,osea de
        // tipo Persona
        for (Persona p : lasPersonas) {

            System.out.println(p.getNombre() + "," + p.getDescripcion());
        }
    }
}

// superclase Persona
abstract class Persona {

    private String nombre;

    public Persona(String nom) {

        this.nombre = nom;
    }

    // metodos getter
    public String getNombre() {

        return this.nombre;
    }

    // metodo get abstracto
    public abstract String getDescripcion();
}

// clase Empleado2, esta clase hereda de Persona, y como Persona tiene un metodo
// abstracto,Empleado2 esta obligado a sobreescribirlo
class Empleado2 extends Persona {

    // propiedades
    private double sueldo;
    private Date fechaAlta;

    // constructor 1
    public Empleado2(String nom, double sue, int año, int mes, int dia) {

        // llamado al constructor de la superclase
        super(nom);

        this.sueldo = sue;
        // asi contruyo la fecha,utilizando la clase GregorianCalendar y su metodo
        // getTime()
        GregorianCalendar calendario = new GregorianCalendar(año, mes - 1, dia);
        this.fechaAlta = calendario.getTime();

    }

    // metodos getter

    public double getSueldo() {

        return this.sueldo;
    }

    public Date getFechaAlta() {

        return this.fechaAlta;
    }

    // aqui sobreescribimos el metodo abstracto que se esta heredando de Persona
    @Override
    public String getDescripcion() {

        return "Este empleado tiene un sueldo de: " + this.sueldo;
    }

    // metodo setter,recibira un parametro de tipo double que sera el porcentaje a
    // ser aumentado
    public void setSubeSueldo(double porcentaje) {

        double aumento = this.sueldo * (porcentaje / 100);
        sueldo += aumento;
    }
}

// clase Alumno
class Alumno extends Persona {

    private String carrera;

    public Alumno(String nom, String car) {

        super(nom);
        this.carrera = car;
    }

    // metodo abstracto sobreescrito
    @Override
    public String getDescripcion() {

        return "Este alumno está estudiando la carrera de " + this.carrera;
    }
}