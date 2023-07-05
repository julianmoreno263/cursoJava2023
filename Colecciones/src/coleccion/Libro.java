/*(v181) vamos a ver como usar los metodos equals y hashCode() utilies en colecciones.

En el ejercicio de la coleccion de tipo HashSet para el banco, este no permite agregar objetos duplicados a la coleccion,pero si por ejemplo nosotros hacemos un cl5 con los mismos datos del cl1,aparentemente seran el mismo objeto porque tienen los mismos datos,pero los deja agregar,esto es porque cl1 y cl5 son referencias distintas.

hashCode: cuando creamos variables de tipo primitivo,por ejemplo int=5, esta se alamacena en la memoria stack(pila), pero cuando creamos objetos estos se almacenan en otra memoria llamada heap, la referencia de estos objetos(osea su nombre) si se almacena en la memoria stack, en la memoria heap a cada objeto almacenado s ele va dando un numero identificativo llamado hashcode.El metodo hashCode() nos da la posicion de un objeto en la memoria heap.

equals() nos dice si dos objetos son iguales,pero solo puede comparar objetos del tipo predefinido en java,osea objetos de tipo String,Date,etc, si queremos comparar objetos creados de una clase echa por nosotros debemos sobreescribir ese método equals para poderlos comparar.

-------------------------------------------------------------
(v182)

1- si creamos dos instancias iguales de la clase Libro,osea con los mismos datos,aparentemente usando equals() para compararlos deberia decir que son iguales,pero no lo dira porque equals no puede comparar objetos de una clase definida por nosotros,solo compara objetos de clases predefinidas de java como Date,etc. La solucion para poder usar equals en nuestras clases es reescribir el metodo.

2- en nuestro caso, para hacerle saber al metodo equals que dos objetos son iguales en nuestra clase propia de Libro seria por medio del campo isbn que tiene el mismo numero en nuestro ejemplo,osea los dos objetos que creamos son iguales pero debemos indicarselo a equals por medio del numero isbn que hemos establecido igual para los objetos que creamos en este ejemplo.Si vemos la API y buscamos la clase Object aqui estara el metodo equals el cual devuelve un boolean y recibe un parametro de tipo Object.

3- entonces para sobreescribir el metodo vamos a la clase Libro, lo primero que hacemos dentro del metodo equals es decirle con un if si el objeto que le pasamos por parametro es un objeto d ela clase libro, esto lo hacemos usando el metodo instanceof().

4- ahora, dentro de ese if, debemos poder comparar el objeto de la clase Libro con el objeto que pasamos por parametro que tambien debe de ser de Libro por medio del isbn, como el objeto pasado por parametro es de tipo Object debemos castearlo a Libro para que pueda acceder al parametro isbn y asi podamos comparar los dos isbn de ambos objetos.Entonces creamos un campo de tipo Lbro y le decimos que es igual a un casting de Libro para obj.

5- listo, ya con este casting,podemos con otro if anidado comparar el objeto actual this si su isbn es igual al isbn del objeto pasado por parametro, asi: this.isbn==otro.isbn; y esto debe retornar un true si son iguales o un false si no lo son.

6- por ultimo tambien en el primer if que pregunta si los objetos son instanceof debo poner el correspondiente else si no lo son.Listo, de esta forma ya tendremos el metodo equals sobreescrito para nuestra propia clase y asi poder comparar objetos de esa clase propia Libro, si corro el programa ya me debe de decir que los objetos que cree con el mismo isbn son iguales.

Este metodo es importante porque al trabajar con colecciones muchas veces necesitaremos saber si un objeto es igual a otro o si se encuentra repetido,porque en las colecciones Set por ejemplo no permite objetos repetidos,etc.

ahora,sin usar el metodo equals que sobreescribimos, si por ejemplo utilizamos el metodo hashCode() para saber el numero hash de los objetos nos dira que son numeros diferentes porque son objetos diferentes.Pero si hago: libro1=libro2, lo que e stoy haciendo es que las referencias libro1 y libro2 apunten al mismo objeto,por lo que el numero hash sera el mismo para ambas referencias y por lo tanto me dira que son iguales.

Como el metodo equals y hashCode se usan muy a menudo, con VSC podemos generarlos automaticamente de la misma forma que los getters y setters,vamos al archivo donde queremos crearlos,click derecho,souce action,generate hashCode() and equals().Siempre que sobreescribamos el equals tambien sobreescribimos el hashCode.




 */

package coleccion;

public class Libro {

    private String titulo;
    private String autor;
    private int isbn;

    // constructor
    public Libro(String titulo, String autor, int isbn) {

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    // getter
    public String getDatos() {

        return "El titulo es: " + this.titulo + ". El autor es: " + this.autor + ". El isbn es: " + this.isbn;
    }

    // equals y hashCode sobreescritos por medio del vsc.

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + isbn;
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
        Libro other = (Libro) obj;
        if (isbn != other.isbn)
            return false;
        return true;
    }

    // equals sobreescrito
    // public boolean equals(Object obj) {

    // if (obj instanceof Libro) {

    // // casting de obj pasado por parametro
    // Libro otro = (Libro) obj;

    // // comparacion de ambos codigos isbn
    // if (this.isbn == otro.isbn) {
    // return true;
    // } else {
    // return false;
    // }

    // } else {

    // return false;
    // }
    // }

}
