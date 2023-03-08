/*arrays en java,para almacenar datos del mismo tipo,se pueden declarar y inicializar en la misma linea,o se  declaran en una linea diciendo antos elementos va a almacenar y se inicializa en la siguiente linea.Se debe especificar el tipo de dato  almacenar,igual que en variables. */

public class Arrays {
    public static void main(String[] args) {

        // int miArray[]=new int[5];//se inicializa poniendo el numero de elementos

        int miArray[] = { 5, 38, -15, -92, 713, 67, 80, 12, 11 };// se crea e inicializa de una vez

        for (int index = 0; index < miArray.length; index++) {

            System.out.println("Valor del índice " + index + " = " + miArray[index]);
        }
    }
}
