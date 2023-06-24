/*(v168) vamos a ver como se maneja el tema d ela herencia en la PG porque no funciona igual  como en las clases normales de la POO. En POO una clase Jefe puede heredar de una clase Empleado por la logica de "es un", pero en la PG esto no se maneja asi,la PG manejaria estas clases independientes y por eso el "es un" no aplica aqui,para esto se deben utilizar los tipos comodin

Vamos a realizar un ejemplo utilizando cuatro clases,Pareja,HerenciaGenericos,Empleado y Jefe.

1- entonces, utilizando primero las tres clases normales de HerenciaGenericos,Jefe y Empleado puedo crear 2 objetos,uno de tipo Jefe y otro de tipo Empleado,y como en la herencia normal puedo usar el principio de "es un", puedo crear otro objeto de tipo Empleado y almacenar alli uno de tipo Jefe,esto es la herencia normal,porque un Jefe es un Empleado.

2- ahora, en PG esto no trabaja igual,vamos a crear un objeto de la clase generica Pareja y le pasamos un objeto de tipo Empleado, y otro objeto Pareja y le pasamos un tipo Jefe.Osea hacemos lo mismo que con POO.

3- ahora,si quiero tratar de hacer lo mismo que con POO, osea crear con Pareja<Empleado> un objeto y le paso el objeto de tipo Jefe me saca error.

4- pasa lo mismo si por ejemplo creo un metodo en la clase Pareja para que me imprima un objeto de tipo Empleado,al invocarlo y pasarle como parametro el objeto de tipo Empleado que creamos con Pareja no hay error,pero si con ese metodo intentamos imprimir el objeto de tipo Jefe da error,porque aqui no se aplica la herencia.

5- para solucionar esto de la herencia en PG, por ejemplo si queremos utilizar este metodo para que sirva para los objetos de tipo Empleado y los que hereden de el,lo unico que hay que hacer es utilizar los tipos comodin en la declaracion de los parametros de la funcion asi:

            public static void imprimirTrabajador(Pareja <? extends Empleado> p) 

ponemos el comodin ? con extends en el tipo de objeto,asi le estamos diciendo que se pueden usar los objetos de tipo Empleado y todos los que hereden de este.
 */

package clasesPropias;

public class HerenciaGenericos {
    public static void main(String[] args) {

        // Empleado administrativo = new Empleado("Ana", 45, 1500);
        // Jefe gerente = new Jefe("Maria", 28, 3500);

        // // aqui utilizo la herencia
        // Jefe nuevoEmpleado = gerente;

        // ---------------------------------------
        // con PG
        Pareja<Empleado> administrativo = new Pareja<Empleado>();
        Pareja<Jefe> directoraComercial = new Pareja<Jefe>();

        // aqui el codigo saca error al intentar aplicar el principio de sustitucion "es
        // un", no puede convertir el tipo Jefe a un Empleado.Si utilizo el comodin ya
        // puedo utilizar las clases heredadas y por ende los objetos de estas.
        Pareja<? extends Empleado> nuevoEmpleado = directoraComercial;

        // si utilizo la funcion para imprimir un trabajador con Jefe me da error,con un
        // tipo Empleado no pero con Jefe si porque la herencia no aplica igual en PG.
        Pareja.imprimirTrabajador(administrativo);
        Pareja.imprimirTrabajador(directoraComercial);

    }
}
