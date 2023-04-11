package poo;

/*Las clases internas son clases dentro de otras(como los if anidados), las clases internas nos sirven para:

1- poder acceder a los campos private de una clase desde otra clase
2- ocultar una clase de otras pertenecientes al mismo paquete(como encapsular una clase)
3- para crear clases internas "anonimas", utiles en eventos y retrollamadas
4- cuando solo una clase debe acceder a los campos de ejemplar de otra clase sin necesidad de crear metodos de acceso(getter ysetter).

haremos el mismo ejercicio del PruebaTemporizador pero con una clase interna para ver sus ventajas.

Las clases internas pueden ser private.

Aqui vemos que el programa ttrabaja igual que el otro temporizador,la novedad es que aqui lo hacemos con clases internas,y podemos ver que esta clase interna puede acceder a un campo de clase private que es de otra clase,no es suyo,pero lo puede acceder aunque sea private,este es el campo "sonido",este campo pertenece a la clase Reloj,y la clase interna puede acceder a el.
 */
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.awt.Toolkit;

public class ClaseInternaTemporizador {
    public static void main(String[] args) {

        // aqui instanciamos la clase Reloj para crear un temporizador y echarlo a andar
        Reloj miReloj = new Reloj(3000, true);
        miReloj.enMarcha();

        JOptionPane.showMessageDialog(null, "Pulsa ok para terminar");

        System.exit(0);

    }
}

// clase para el temporizador
class Reloj {

    private int intervalo;
    private boolean sonido;

    public Reloj(int intervalo, boolean sonido) {

        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    // metodo para crear el objeto del evento
    public void enMarcha() {

        ActionListener oyente = new DameLaHora2();
        Timer miTemporizador = new Timer(this.intervalo, oyente);
        miTemporizador.start();
    }

    // clase interna DameLaHora2
    private class DameLaHora2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Date ahora = new Date();
            System.out.println("Dame la hora cada 3 seg " + ahora);

            if (sonido) {

                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}