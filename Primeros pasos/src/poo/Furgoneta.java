/*en este ejercicio veremos la herencia, es cuando una clase hereda las propiedades y metodos de una clase padre, asi esa clase que hereda se va haciendo mas especializada al tener las proiedades y metodos que hereda mas los suyos propios.Para decirle a una clase que va a heredar de otra se usa la palabra resrvada extends. Javano admite la herencia multiple,osea una clase heredando de varias, para solventar esto se usan las interfaces. Cuando heredamos de una clase, debemos llamar al constructor de la clase padre para traernos las caracteristicas de la clase padre, lo hacemos con super(). La herencia me sirve para reutilizar codigo.
 
Ahora, asi como estan heredando nuestras clases furgoneta de coche, no esta bien diseñada la herencia, para hacer un buen diseño de herencia entre clases debemos siempre preguntarnos: "Es un...?", esto significa por ejemplo que debemos preguntarnos si una furgoneta es un coche(automovil) y no lo es, entonces la herencia de este ejemplo deberia estar diseñada a partir de una clase padre Vehiculo, y de alli crear la clase coche,furgoneta,camion,moto,etc, teniendo en cuenta la pregunta "es un...?" se hace un buen diseño de herencia.
*/

package poo;

public class Furgoneta extends Coche {

    // caracteristicas propias de la furgoneta
    private int capacidadCarga;
    private int plazasExtra;

    // constructor
    public Furgoneta(int capacidadCarga, int plazasExtra) {

        super();// llamada al constructor padre
        this.capacidadCarga = capacidadCarga;
        this.plazasExtra = plazasExtra;
    }

    // getter
    public String getDatosFurgoneta() {

        return "La capacidad de carga es: " + this.capacidadCarga + " kg" + " Y las plazas extra son: "
                + this.plazasExtra;
    }

}
