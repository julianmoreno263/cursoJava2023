/*(v165) ya sabiendo que es la programacion geenrica y el uso de la clase ArrayList para esto,vamos a ver como programar nuestras propias clases genericas para poder manejar diferentes tipos de objetos en una sola clase.

1- para crear una clase generica se crea una clase normal pero se le agrega el tipo de parametro generico <T>,esto le indica a java que es una clase generica,por convencion se utilizan letras mayusculas T,U,K.La clase se llamara Pareja y trabajar con la clase UsoPareja.

2-listo,asi se define la clase generica,ahora programamos dentro lo que hara esta clase.El profe crea una variable generica llamada "primero", como esta variable sera generica,osea en principio no se sabe que tipo de objeto almacenara,se le indica tambien T.

3- en el constructor solo definimos que el valor de esa variable sera null.

4- creamos un metodo setter para poder cambiar ese valor de esa variable.Este metodo recibira un argumento generico T.

5- creamos el correspondiente getter para que nos devuelva el dato, como no sabemos que tipo de dato devolvera,por eso todo es generico,lo definimos de nuevo con T.Listo, aqui esta la clase generica sencilla, ahora la podemos usar desde UsoPareja.

6- en la clase main instanciamos un objeto de Pareja,para esto crearemos una primera instancia de tipo String.Al crear este objeto,como el constructor de Pareja en principio pone a "primero=null" pues este primer objeto creado sera null.

7- ahora, si queremos establecer ese objeto creado a el tipo String que queremos, aqui esta la magia de la programacion generica, porque si apunto a mi objeto y utilizo el setter que construi y que recibe un parametro de tipo T, ahora,el intellisense de mi editor marcara este metodo setter pero con el parametro de tipo String,ya no generico,porque esta clase se va adpatando a lo que le indiquemos que le vamos a pasar.Osea cuando usamos el constructor para crear el objeto lo que estamos indicando es que primero=null, y al usar el setter con este objeto creado al que le pusimos el tipo String,lo que hacemos es cambiar a primero="julian", osea un String.

8- Ahora con el getter simplemente imprimimos el valor almacenado en el objeto.

Para ver mas claramente la programacion generica, creamos una segunda clase Persona la cual recibe un nombre en su constructor y creamos un objeto de esta clase, luego creamos un segundo objeto de Pareja, y utilizando la PG podemos establecerle ahora al objeto de tipo Pareja que en principio es "persona=null" el nombre del objeto de tipo Persona por medio del setter.Osea,en si es ver que con esta clase generica,podemos crear objetos de diferente tipo y usarlos.

 */

package clasesPropias;

public class Pareja<T> {

    private T primero;

    // constructor
    public Pareja() {

        primero = null;
    }

    // setter
    public void setPrimero(T nuevoValor) {

        this.primero = nuevoValor;
    }

    // getter
    public T getPrimero() {

        return this.primero;
    }

}
