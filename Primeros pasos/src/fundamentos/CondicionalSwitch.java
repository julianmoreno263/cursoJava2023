/*switch es un condicional que sirve para evaluar varias condiciones de forma facil basados en una condicion.Vamos a crear un programa que calcule áreas de figuras, con JOptionPane va a ir introduciendo los valores y con Scanner va a elegir las 4 opciones de las figuras.Importamos java.util para scanner y javax.swing para JOptioPane. */

import java.util.*;
import javax.swing.*;

public class CondicionalSwitch {
    public static void main(String[] args) {

        Scanner opcion = new Scanner(System.in);
        System.out.println(
                "Elige el número de la figura para saber su área \n1:Cuadrado \n2:Rectángulo \n3:Triángulo \n4:Circulo");
        int figura = opcion.nextInt();

        switch (figura) {
            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor del lado del cuadrado"));

                System.out.println("El área del cuadrado es " + Math.pow(lado, 2));
                break;

            case 2:
                int base = Integer
                        .parseInt(JOptionPane.showInputDialog("Introduce el valor de la base del rectangulo"));

                int altura = Integer
                        .parseInt(JOptionPane.showInputDialog("Introduce el valor de la altura del rectangulo"));

                System.out.println("El área del rectangulo es " + (base * altura));
                break;

            case 3:
                int baseTriangulo = Integer
                        .parseInt(JOptionPane.showInputDialog("Introduce el valor de la base del rectangulo"));

                int alturaTriangulo = Integer
                        .parseInt(JOptionPane.showInputDialog("Introduce el valor de la altura del rectangulo"));

                System.out.println("El área del rectangulo es " + (baseTriangulo * alturaTriangulo) / 2);
                break;

            case 4:
                int radio = Integer
                        .parseInt(JOptionPane.showInputDialog("Introduce el radio del circulo"));

                System.out.printf("El área del circulo es " + "%1.2f", (Math.PI * Math.pow(radio, 2)));
                break;

            default:
                System.out.println("La opción elegida no es correcta!");
                break;
        }

        opcion.close();
    }
}
