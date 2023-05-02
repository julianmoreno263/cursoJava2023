/*veremos como funcionan los modificadores de acceso utilizando dos clases en un paquete(clase1 y clase2), y otra clase que esta dentro de otro paquete llamado paquetePruebas(clase3)

los modificadores de acceso en java son: 
 
1- Modificador por defecto(cuando no se pone nada)
2- private
3- protected
4- public

Los modificadores de acceso se pueden implementar para las variables y los metodos, cuando en una clase no pongo el constructor, java asume que esta el constructor por defecto,un constructor vacio.

1- con el modificador por defecto,puedo acceder a una variable o metodo que este dentro de la misma clase,a otra clase que este en el mismo paquete, pero no puedo accedera una clase que este en otro paquete, ni tampoco se puede acceder a una subclase que este en un paquete diferente.El objeto de tipo clase3 que hereda de clase1 y que esta en otro paquete no puede ser accedido desde clase2.(ver tabla video 47).

2- si queremos acceder a un metodo o variable de una subclase(clase que hereda de otra) y que esta en otro paquete podemos poner ese metodo o variable como protected.


----------------- clase object --------------------------------------

la clase object o clase cosmica es la clase que esta en la cima de todas las clases en java,todas las clases que hagamos y que estan en la api de java heredan de object.Si vemos cualquier clase en la api, veremos que comienza desde la clase Object y el paquete por defecto java.lang asi:  java.lang.Object. Cuando creamos una clase class MiClase, es como poner class MiClase extends Object. Por esto cuando creamos un objeto de una clase me salen otros metodos,esos son los que se heredan de Object.


 */

package poo;

public class Clase1 {

    protected int miVar = 5;
    int miVar2 = 7;

    protected String getMiMetodo() {

        return "El valor de miVar2 es: " + miVar2;
    }
}
