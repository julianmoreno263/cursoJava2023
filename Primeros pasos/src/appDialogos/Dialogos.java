package appDialogos;

/*(v122) ejercicio para repasar todo lo que se ha visto de swing y los otros temas. 

Esta practica la haremos con modulos,osea hacer varios archivos para cada clase y asi es mas legible el codigo.

1- dividimos el codigo en archivos para la clase main,el marco y la lamina.

2- el marco tendra una lamina con gridLayout,entonces la creamos en la clase del marco.

3- debemos crear una clase que cree las cajas de tipo BoxLayout para poner esas cajas en cada celda de la grilla,debemos ver que tienen en comun esas cajas,el titulo y que tienen radio buttons.

*/

import javax.swing.*;

public class Dialogos {
    public static void main(String[] args) {

        MarcoDialogos miMarco = new MarcoDialogos();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}
