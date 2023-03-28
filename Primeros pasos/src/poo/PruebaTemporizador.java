/*vamos a hacer un ejercicio para terminar de ver las interfaces y dar una introduccion a las clases internas.Sera un temporizador que cada cierto tiempo ejecute una accion,para esto utilizamos la clase Timer(hay tres clases Timer en la API,pero de paquetes diferentes,utilizaremos la tercera que esta en el paquete javax.swing,debemos importarlo).Si vemos el constructor de esta clase vemos que recibe 2 parametros,uno es el tiempo de delay para ir contando y temporizando y el segundo es el evento(que es una interfaz ActionListener,en la API podemos dar click y ver la descripcion detallada.). Entonces para crear el temporizador instanciamos un objeto de la clase Timer usando ese constructor,el cual nos pide un delay y el evento. Ahora,la interfaz ActionListener viene del paquete java.awt.event por lo que debemos importar tambien este paquete, y como es una interfaz que estamos implementando en una clase,debemos desarrollar todos los metodos de esa interfaz de forma obligatoria.Esta interfaz solo tiene el metodo actionPerformed(e), recibe el objeto del evento e como parametro y es tipo void,no retorna nada.En el constructor nos pide el delay y el evento,pero este evento debe ser un objeto de tipo interfaz ActionListener(porque java es 100% orientado a objetos), asi que para crear este objeto de tipo interfaz debemos crear una clase que implemente esta interfaz ActionListener. Vamos a hacer que el programa nos diga la hora cada 5 segundos.Con el metodo start() de la clase Timer se comienza a correr el programa.Con System.exit detenemos la ejecucion del programa. Podemos hacer que suene un pitido segun el SO que estemos usando cuando el programa este dando la hora,esto lo hacemos utilizando la clase abstracta Toolkit(abstracta porque tiene metodos abstractos.),esta clase esta en el paquete java.awt.
 * 
NOTA: CADA VEZ QUE NECESITEMOS EJECUTAR UN EVENTO EN UNA CLASE, ESTA CLASE DEBE IMPLEMENTAR LA INTERFAZ ActionListener QUE ES LA QUE TIENE EL METODO actionPerformed(ActionEvent e) EL CUAL RECIBE POR PARAMETRO EL OBJETO DE EVENTO e, Y ASI SE EJECUTAN LOS EVENTOS.
*/

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PruebaTemporizador {
    public static void main(String[] args) {

        // aqui creo el objeto de la clase DameLaHora la cual implementa la interfaz
        DameLaHora oyente = new DameLaHora();

        // instancia de Timer
        Timer miTemporizador = new Timer(5000, oyente);
        miTemporizador.start();

        JOptionPane.showInputDialog(null, "Pulsa aceptar para detener");

        System.exit(0);

    }
}

// clase que implementa la interfaz ActionListener
class DameLaHora implements ActionListener {

    // desarrollamos el metodo de la interfaz ActionListener llamado
    // actionPerformed()
    public void actionPerformed(ActionEvent e) {

        Date ahora = new Date();
        System.out.println("Te digo la hora cada 5 segundos: " + ahora);
        Toolkit.getDefaultToolkit().beep();

    }
}