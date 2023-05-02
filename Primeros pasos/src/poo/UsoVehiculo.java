
/*aqui vamos a crear objetos de la clase Coche,para eso utilizamos el nombre de la clase Coche y despues el  constructor de la clase Coche por medio de "new Coche()", ya despues de creado el objeto puedo comenzar a ver sus propiedades y metodos. Recordar que para que un objeto pueda acceder a las propiedades de la clase donde esta el constructor debe hacerlo por medio de los metodos,asi se comunican las clases.Como creamos el objeto Mazda y queremos darle un color,debemos hacerlo por medio del metodo setColor(), y despues para verlo en consola debemos hacerlo por medio del metodo getColor(). Podemos utilizar la clase JOptionPane de javax.swing para que el programa le pregunte al usuario los datos y este los ingrese por las ventanas que salen.*/

package poo;

import javax.swing.*;

public class UsoVehiculo {
    public static void main(String[] args) {

        Coche Renault = new Coche();// instanciamos la clase Coche
        Renault.setColor(JOptionPane.showInputDialog("Establece un color", Renault));
        Renault.setAsientosCuero(JOptionPane.showInputDialog("Tiene asientos de cuero? si/no", Renault));
        Renault.setClimatizador(JOptionPane.showInputDialog("Tiene climatizador? si/no", Renault));

        Coche Mazda = new Coche();// creamos otro objeto y usamos el setter
        Mazda.setColor(JOptionPane.showInputDialog("Establece un color", Mazda));
        Mazda.setAsientosCuero(JOptionPane.showInputDialog("Tiene asientos de cuero? si/no", Mazda));
        Mazda.setClimatizador(JOptionPane.showInputDialog("Tiene climatizador? si/no", Mazda));

        // objetos de la clase Furgoneta que hereda de Coche.
        Furgoneta Audi = new Furgoneta(580, 7);
        Audi.setColor("azul");
        Audi.setAsientosCuero("si");
        Audi.setClimatizador("si");

        System.out.println("-----------------------coche Renault----------------------------");
        // usamos los metodos getter para poder acceder a las propiedades
        System.out.println(Renault.getDatosGenerales());
        System.out.println(Renault.getAsientos());
        System.out.println(Renault.getClimatizador());
        System.out.println(Renault.getColor());
        System.out.println(Renault.getPesoTotal());// aqui llamamos al metodo tipo getter-setter
        System.out.println("El precio final del Renault es " + Renault.getPrecioFinal());

        System.out.println("------------------------coche Mazda---------------------------");

        System.out.println(Mazda.getDatosGenerales());
        System.out.println(Mazda.getAsientos());
        System.out.println(Mazda.getClimatizador());
        System.out.println(Mazda.getColor());
        System.out.println(Mazda.getPesoTotal());// tipo getter-setter
        System.out.println("El precio final del Mazda es " + Mazda.getPrecioFinal());

        System.out.println("------------------------furgoneta Audi---------------------------");

        System.out.println(Audi.getDatosGenerales() + Audi.getDatosFurgoneta());

        // System.out.println("El coche Renault tiene " + Renault.ruedas + " ruedas");

    }
}
