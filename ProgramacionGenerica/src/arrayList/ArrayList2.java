package arrayList;

public class ArrayList2 {

    private Object datosElemento[];
    private int i;

    // constructor,al pasarle un int como parametro determina la cantidad de
    // elementos del array
    public ArrayList2(int z) {

        datosElemento = new Object[z];
    }

    // este metodo devuelve un elemento de una posicion que le pasemos
    public Object get(int i) {

        return datosElemento[i];
    }

    // este metodo recibe un objeto y lo almacena en el array
    public void add(Object o) {

        datosElemento[i] = o;

        i++;
    }

}
