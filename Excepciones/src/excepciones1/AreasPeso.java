/*(v149) vamos a ver la clausula finally,para esto creamos un programa que calcula areas de figuras y peso de una ersona segun si es hombre o mujer.

Recordar que cuando usamos scanner para ingresar datos por consola,es como si estuvieramos abriendo una conexion entre el programa y la consola,esta conexion abierta consume recursos del pc,por lo que cuando ya no se necesita se deb de cerrar con el metodo close().

Ahora, este programa hace dos cosas,calcula un area y un peso, si por ejemplo en el area en vez de pasar un numero pasamos un string sale un error y el programa cae,no se ejecuta lo del peso, entonces debemos capturar el error para asegurarnos que aunque no se ejecute lo del area,el programa no caiga sino que ejecute el codigo del peso, entonces en la parte del area puede ocurrir este error en la variable figura,porque es alli donde se comienza a ingresar los datos del usuario con nextInt(), entonces la envolvemos dentro del try y en el catch capturamos el error(aqui usamos el error mas generico solo para el ejemplo), y la finalidad del finally es poner el codigo que si o si debe ejecutarse,tanto si hay un error como si no,este codigo seria en este ejemplo el entrada.close(),porque la conexion debe cerrarse para no consumir mas recursos del pc.

Asi capturado el error con try-catch-finally ya el programa no cae.


 */

package excepciones1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class AreasPeso {

    static int figura;

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Círculo");

        // aqui se implementa el finally para el codigo que debe ejecutarse si o si
        try {

            figura = entrada.nextInt();

        } catch (Exception e) {

            System.out.println("Ocurrio un error!");

        } finally {

            // aqui cerramos la conexion Scanner
            entrada.close();
        }

        switch (figura) {
            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el lado"));

                System.out.println(Math.pow(lado, 2));
                break;

            case 2:
                int base = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la base"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la altura"));

                System.out.println("El área del rectángulo es: " + (base * altura));

                break;

            case 3:
                int baseTriangulo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la base"));
                int alturaTriangulo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la altura"));

                System.out.println("El área del triángulo es: " + (baseTriangulo * alturaTriangulo) / 2);

                break;

            case 4:
                int radio = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el radio del círculo"));

                System.out.println("El área del círculo es: " + (Math.PI) * (Math.pow(radio, 2)));

                break;

            default:
                System.out.println("La opción no es correcta!");
                break;
        }

        // codigo para calcular peso de una persona
        int alturaPersona = Integer.parseInt(JOptionPane.showInputDialog("Ingresa altura en cm"));

        System.out.println("Si eres hombre tu peso ideal es: " + (alturaPersona - 110) + " Kg");
        System.out.println("Si eres mujer tu peso ideal es: " + (alturaPersona - 120) + " Kg");

    }
}
