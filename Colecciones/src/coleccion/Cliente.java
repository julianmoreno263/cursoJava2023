/*(v180) vamos aver el tema d elas colecciones en java, una coleccion es un almacen de objetos dinamico, una coleccion solo puede almacenar objetos pero es dinamica,osea no tiene un tamaño fijo, mientras que un array puede almacenar objetos y datos primitivos pero es de tamaño fijo.

Las ventajas de las colecciones es que son dinamicas, pueden ser provistas de ordenamiento y se pueden ir insertando y eliminando elementos.

Las colecciones viene  de la implementacion de la interfaz Collection y esta a su vez tiene otras interfaces que descienden de ella:

1- Set= almacena objetos no repetidos y sin ordenar, ejemplo,los titulares de una cuenta corriente,no se repiten y no están ordenados.

2- List= objetos repetidos e indexados,ofrece acceso aleatorio,osea podemos acceder al elemento que queramos.

3- Queue= no permite acceso aleatorio,solo permite acceder al principio o al final,y almacena elementos al principio o al final de la cola.

4- Map=pueden haber elementos repetidos,almacena elementos indexados por clave única aleatoria,osea se identifican los elementos por una clave.

NOTA: EL PROFE DEJA UN PDF DONDE SE VEN LAS INTERFACES Y SUS VENTAJAS Y DESVENTAJAS DE CADA UNA.

 crearemos un ejercicio donde crearemos un banco que tendra varios clientes y luego estos clientes los pondremos en una coleccion para administrarlos.

PASOS PARA TYRABAJAR CON LAS COLECCIONES:

1- crear clase Cliente

2- crear la coleccion,y para esto debemos preguntarnos si necesitamos agregar objetos repetidos o no, en este caso de nuestro banco no tiene sentido agregar objetos de tipo Cliente repetidos, ademas debemos preguntarnos si vamos a realizar varias operaciones de agregar y borrar,y si esta coleccion sera de solo lectura.Dependiendo de esto escogemos la coleccion adecuada.En principio utilizaremos la interfaz set para nuestra coleccion,pues por ahora no vamos a implementar ordenacion de ningun tipo.

3- agregar estos clientes a la coleccion

4- recorrer la coleccion

NOTA: PARA GENEAR GETTERS Y SETTERS AUTOMATICAMENTE EN VSC: 
Donde quieres ingresar tus getters y setters:
Click derecho > Source Action > Generate Getters and Setters.


 */

package coleccion;

public class Cliente {

    private String nombre;
    private String numCuenta;
    private double saldo;

    // constructor
    public Cliente(String nombre, String nCuenta, double saldo) {

        this.nombre = nombre;
        this.numCuenta = nCuenta;
        this.saldo = saldo;
    }

    // getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
