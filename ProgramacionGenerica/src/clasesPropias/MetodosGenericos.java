/*(v166) vamos a ver como crear metodos genericos,estos se pueden crear en clases genericas o en clases normales. 

1- en la clase MisMatrices vamos a crear el metodo generico, este metodo devolvera un string, este string nos dira la longitud que tendra un array que le pasaremos por parametro, la ventaja con este metodo generico es que puede recibir el array de cualquier tipo de dato,string,int,etc, y nos devolvera un texto que nos dira el numero de elementos que tenga ese array.

2- para definir un metodo generico,usamos la misma T para las clases,lo crearemos static en este ejercicio para no tener que crear objetos sino solo usar el nombre de la clase para usar este metodo.Como es un metodo generico que recibira parametros genericos,osea se le podra pasar arrays de cualquier tipo lo indicamos tambien con la T.Entonces se ra: public static tipo generico<T> devolvera un String y le pasaremos un array que sera de tipo generico en principio.

3- listo,ya creado, en main creo un array de string y se lo paso al metodo,y veremos que automaticamente se adapta el metodo al tipo de objeto que le pasemos por parametro.Si por ejemplo creo otro array tipo Integer con numeros,este mismo metodo sin cambiarle nada se adapta a ese tipo de datos y me da el resultado.

*/

package clasesPropias;

public class MetodosGenericos {

    public static void main(String[] args) {

        String nombres[] = { "Jose", "Maria", "Pepe" };
        Integer numeros[] = { 2, 3, 56, 78, 11, 90 };

        // imprimo el metodo generico
        System.out.println(MisMatrices.getElementos(nombres));
        System.out.println(MisMatrices.getElementos(numeros));

    }
}

// clase
class MisMatrices {

    // creamos metodo generico
    public static <T> String getElementos(T array[]) {

        return "El array tiene " + array.length + " elementos";
    }

}