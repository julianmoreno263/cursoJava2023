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

NOTA: PARA GENERAR GETTERS Y SETTERS AUTOMATICAMENTE EN VSC: 
Donde quieres ingresar tus getters y setters:
Click derecho > Source Action > Generate Getters and Setters.

ya despues de ver el metodo equals y hashCode y saber porque hay que sobreescribirlos para poder usarlos en nuestras clases propias,en este ejercicio del banco donde intentamos agregar un objeto dos veces y no debe poderse hacer esto porque no deberian haber dos cuentas con el mismo numero de cuenta,entonces sobreescribimos aqui estos metodos equals y hashCode para que nos ayuden a validar estos casos,pues en colecciones Set no deben permitirse objetos duplicados.Generamos estos metodos sobreescritos automaticamnete igual que hicimos con los getters y setters.

Listo!, asi si intento crear objetos iguales y almacenarlos en la coleccion,aunque tengan distintas referencias no me permitira agregarlos porque ya existira una cuenta con ese numero de cuenta.

--------------------------------------------------
(v183) veamos la interfaz Iterator para recorrer colecciones, antes de java 5.0 no habia bucle for-each,por lo que para recorrer colecciones se utilizaba un objeto de la interfaz Iterator,esta interfaz viene de la interfaz Collection y su subinterfaz Iterable, tiene tres metodos para recorrer colecciones:

1- next()- va saltando elemento por elemento de la coleccion y lo recorre, cuando ya no hay elemento para saltar lanza una excepcion.

2- hashNext()- indica si hay un elemento para saltar, devuelve un boolean.Se usa a la par con next().

3- remove()- elimina elementos d ela coleccion.

Podemos recorrer una coleccion con for-each pero a veces sera mejor usar un iterator.Entonces para recorrer nuestra coleccion con un iterator hacemos:

1- creamos un objeto de tipo Iterator que almacenara el tipo de dato que devuelve nuestra coleccion,esto se indica asi:

                    Iterator<Cliente> it=clientesBanco.iterator()

vemos que s eusa el constructor iterator() que devuelve el tipo de objeto de la coleccion que se este iterando,en este caso objetos de tipo Cliente(ver API).

2- recorremos la coleccion con un while y dentro usamos el next,lo que pasa es que en este ejercicio,para imprimir el nombre de los clientes nos sirve el iterator,pero si queremos imprimir todos los datos ya se complica porque debemos usar un next por cada propiedad y al hacer esto el next va saltando al siguiente elemento,entonces el primer next imprime el nombre del primer objeto,pero si damos otro next para imprimir el numero de cuenta,dara el salto y lo que hace es imprimir el numero de cuenta pero del siguiente objeto,entonces con iterator para este caso resultaria mas complicado recorrer la coleccion.

Ahora, con remove es mas facil utilizar el iterator porque si intentamos eliminar con remove en un for-each nos sale una excepcion que en si lo que dice es que no se puede ir eliminando cuando se e sta recorriendo una coleccion,es un problema d econcurrencia, en este caso es mas facil usar el iterator. Para esto primero se hace el iterator con un while para eliminar y despues cone l for-each se va recorriendo.


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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numCuenta == null) ? 0 : numCuenta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (numCuenta == null) {
            if (other.numCuenta != null)
                return false;
        } else if (!numCuenta.equals(other.numCuenta))
            return false;
        return true;
    }

}
