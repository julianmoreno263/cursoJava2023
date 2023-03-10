
/*aqui vamos a crear objetos de la clase Coche,para eso utilizamos el nombre de la clase Coche y despues el  constructor de la clase Coche por medio de "new Coche()", ya despues de creado el objeto puedo comenzar a ver sus propiedades y metodos. Recordar que para que un objeto pueda acceder a las propiedades de la clase donde esta el constructor debe hacerlo por medio de los metodos,asi se comunican las clases.Como creamos el objeto Mazda y queremos darle un color,debemos hacerlo por medio del metodo setColor(), y despues para verlo en consola debemos hacerlo por medio del metodo getColor().*/

package poo;

public class UsoCoche {
    public static void main(String[] args) {

        Coche Renault = new Coche();// instanciamos la clase Coche
        Coche Mazda = new Coche();
        Mazda.setColor();

        // usamos los metodos getter para poder acceder a las propiedades
        System.out.println(Renault.getLargo());
        System.out.println(Mazda.getColor());

        // System.out.println("El coche Renault tiene " + Renault.ruedas + " ruedas");

    }
}
