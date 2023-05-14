package poo;

/*Las clases internas son clases dentro de otras(como los if anidados), las clases internas nos sirven para:

1- poder acceder a los campos private de una clase desde otra clase
2- ocultar una clase de otras pertenecientes al mismo paquete(como encapsular una clase)
3- para crear clases internas "anonimas", utiles en eventos y retrollamadas
4- cuando solo una clase debe acceder a los campos de ejemplar de otra clase sin necesidad de crear metodos de acceso(getter ysetter).

haremos el mismo ejercicio del PruebaTemporizador pero con una clase interna para ver sus ventajas.

Las clases internas pueden ser private.

Aqui vemos que el programa ttrabaja igual que el otro temporizador,la novedad es que aqui lo hacemos con clases internas,y podemos ver que esta clase interna puede acceder a un campo de clase private que es de otra clase,no es suyo,pero lo puede acceder aunque sea private,este es el campo "sonido",este campo pertenece a la clase Reloj,y la clase interna puede acceder a el.

-------------------------------------------------------------
CLASES INTERNAS LOCALES

son clases que se crean dentro de un metodo, la condicion principal para hacer clases internas locales es que solo se usaran una vez,osea solo se instancian una sola vez.El objetivo es simplificar mas el codigo.

Su ambito queda restringido al metodo donde son declaradas.
Son muy restringuidas,ni siquiera la clase a la que pertenecen puede acceder a estas clases locales,solo el metodo donde se declaran puede acceder a ellas,asi el codigo es mas simple.Cuando se declaran no llevan ningun modificador de acceso, solo se puede acceder a ellas usando los metodos setter o getter correspondientes. 

En el ejemplo del temporizador de este archivo podemos modificar el codigo para que quede usando una clase interna local,porque la clase DameLaHora2 queda como la clase interna local y solo la usaremos una vez,asi que simplemente para que quede como clase interna local la pasamos al metodo enMarcha() y le quitamos el modificador de acceso private.De igual forma la clase interna local podra acceder a los campos de clase y variables de la clase a la que pertenece.



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
        // clase interna local DameLaHora2
        class DameLaHora2 implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                Date ahora = new Date();
                System.out.println("Dame la hora cada 3 seg " + ahora);

                if (sonido) {

                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener oyente = new DameLaHora2();
        Timer miTemporizador = new Timer(this.intervalo, oyente);
        miTemporizador.start();
    }

    // clase interna DameLaHora2
    // private class DameLaHora2 implements ActionListener {

    // public void actionPerformed(ActionEvent e) {

    // Date ahora = new Date();
    // System.out.println("Dame la hora cada 3 seg " + ahora);

    // if (sonido) {

    // Toolkit.getDefaultToolkit().beep();
    // }
    // }
    // }
}