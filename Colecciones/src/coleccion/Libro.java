/*(v181) vamos a ver como usar los metodos equals y hashCode() utilies en colecciones.

En el ejercicio de la coleccion de tipo HashSet para el banco, este no permite agregar objetos duplicados a la coleccion,pero si por ejemplo nosotros hacemos un cl5 con los mismos datos del cl1,aparentemente seran el mismo objeto porque tienen los mismos datos,pero los deja agregar,esto es porque cl1 y cl5 son referencias distintas.

hashCode: cuando creamos variables de tipo primitivo,por ejemplo int=5, esta se alamacena en la memoria stack(pila), pero cuando creamos objetos estos se almacenan en otra memoria llamada heap, la referencia de estos objetos(osea su nombre) si se almacena en la memoria stack, en la memoria heap a cada objeto almacenado s ele va dando un numero identificativo llamado hashcode.El metodo hashCode() nos da la posicion de un objeto en la memoria heap.

equals: cuando creamos una clase libro1 y vamos creando objetos de esa clase el metodo equals los puede comparar porque son de la misma clase,pero si creamos una clase libro2 y varios objetos de esa clase,equals no puede comparar objetos de libro1 con libro2 porque son diferentes, en este caso toca sobreescribir el metodo para que pueda comparar objetos.

equals() nos dice si dos objetos son iguales,pero solo puede comparar objetos del tipo predefinido en java,osea objetos de tipo String,Date,etc, si queremos comparar objetos creados de una clase echa por nosotros debemos sobreescribir ese método equals para poderlos comparar.

1- si creamos dos instancias iguales de la clase Libro,osea con los mismos datos,aparentemente usando equals() para compararlos deberia decir que son iguales,pero no lo dira porque equals no puede comparar objetos de una clase definida por nosotros,solo compara objetos de clases predefinidas de java como Date,etc. La solucion para poder usar equals en nuestras clases es reescribir el metodo.




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
}
