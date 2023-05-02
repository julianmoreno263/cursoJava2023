package fundamentos;

/*en este ejercicio rellenaremos un array con numeros aleatorios y luego la recorremos. Utilizaremos el metodo random de Math para generar numeros aleatorios, como este metodo devuelve un double lo redondeamos con el metodo round y todo lo refundimos en un int.*/

public class BucleForEach2 {
    public static void main(String[] args) {

        int miArray[] = new int[150];

        for (int index = 0; index < miArray.length; index++) {

            miArray[index] = (int) Math.round(Math.random() * 100);
        }

        // este es el bucle for-each en java,o for simplificado
        for (int numero : miArray) {

            System.out.println("Número " + numero);
            System.out.println("Total de números: " + miArray.length);
        }
    }
}
