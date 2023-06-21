
package clasesPropias;

public class UsoPareja {
    public static void main(String[] args) {

        // instancia generica de tipo String
        Pareja<String> una = new Pareja<String>();

        // utilizamos el setter y vemos que aunque lo programamos para recibir un
        // argumento generico T,se adapta para recibir un objeto String que es el tipo
        // de objeto que creamos.
        una.setPrimero("Julian");

        // getter
        System.out.println(una.getPrimero());

        // ----------------------------------------------------------------

        // objeto de tipo Persona
        Persona persona1 = new Persona("Ana");

        // objeto de tipo Pareja pero le pasamos ahora un objeto de tipo Persona, al
        // utilizar el setter y getter veremos que se adaptan al tipo de objeto que se
        // le pase. Aqui no se devuelve el nombre "Ana" porque lo que estamos indicando
        // es que estamos pasando un objeto de tipo Persona(porque estamos pasando
        // Persona ersona1),entonces devuelve el tipo de objeto,osea la referencia a ese
        // objeto. Si quiero que devuelva el String "Ana" utilizo el metodo toString()
        // para que me retorne el nombre.
        Pareja<Persona> otra = new Pareja<Persona>();
        otra.setPrimero(persona1);
        System.out.println(otra.getPrimero());
        System.out.println(otra.toString());
    }
}

// clase Persona
class Persona {

    private String nombre;

    // constructor
    public Persona(String nombre) {

        this.nombre = nombre;
    }

    // toString si devuelve el string ana
    public String toString() {

        return nombre;
    }
}