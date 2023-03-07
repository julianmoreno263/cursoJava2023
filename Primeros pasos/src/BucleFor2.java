import javax.swing.JOptionPane;

/*en este ejercicio validaremos una direccion de correo con un for,  la direccion de correo debe tener una arroba,entonces validaremos si lleva este caracter,para esto utilizaremos la clase String que viene del paquete por defecto java.lang y utilizaremos el metodo charat el cual retorna un caracter de un indice especificado(ver api), este metodo es dinamico porque no se especifica "static" en la api,por lo que debemos crear un objeto de la clase String para poder utilizar este metodo.Tambien utilizaremos el metodo length de esta misma clase String,este metodo nos retorna en un int la longitud de un string,tambien es dinamico. Tambien debemos evaluar si hay mas de una @,lo cual seria un error,tambien debe tener al menos un punto. */

public class BucleFor2 {
    public static void main(String[] args) {

        int arroba = 0;
        boolean punto = false;

        String email = JOptionPane.showInputDialog("Introduce el email", args);

        /*
         * el for va evaluando caracter por caracter hasta que vea un arroba,recordar
         * que los datos de tipo char van en comilla simple,y los string en doble.
         */
        for (int index = 0; index < email.length(); index++) {

            if (email.charAt(index) == '@') {

                arroba++;
            }

            if (email.charAt(index) == '.') {
                punto = true;
            }
        }

        if (arroba == 1 && punto == true) {
            System.out.println("Email correcto");
        } else {
            System.out.println("El email no es correcto");
        }
    }
}
