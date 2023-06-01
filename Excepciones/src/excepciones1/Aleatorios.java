/*(v150) vamos a ver como debuggear un programa, debuggear es encontrar el error logico,puede que a veces nuestro programa está bien escrito en sintaxis pero no funciona y por mas que le demos vueltas no encontramos donde esta el error,el editor no saca errores pero no arranca o no funciona bien,entonces no queda de otra mas que debuggear el codigo,el profe lo hace con las herramientas de eclipse pero yo busco como se hace con vsc.

Debugear es encontrar el error en el codigo,en este ejemplo puede que veamos el error a ojo porque es muy corto,pero si un programa de 500 lineas tiene un error hay nos sirve la herramienta de debugg.

En general, ya sea en eclipse o e vsc hay que hacer estos pasos:

1. ubicar en la linea donde creemos que esta el error un punto de interrupcion.Un punto de interrupción indica dónde Visual Studio debe suspender la ejecución de código para poder echar un vistazo a los valores de las variables o al comportamiento de la memoria, o determinar si se está ejecutando o no una bifurcación de código.Si tiene un archivo abierto en el editor de código, puede establecer un punto de interrupción si hace clic en el margen situado a la izquierda de una línea de código,osea a la izquierda del numero de la linea donde vamos a poner el punto.

2- Presione F5 (Depurar > Iniciar depuración) o el botón Iniciar depuraciónIniciar depuración en la barra de herramientas de depuración para que el depurador se ejecute hasta el primer punto de interrupción que encuentre. Si la aplicación todavía no se está ejecutando, F5 inicia el depurador y lo detiene en el primer punto de interrupción.

3- entonces,en este ejercicio el error esta en que en el for donde vamos rellenando el array la expresion (int)Math.random()*100 lo que esta haciendo es pasar a int todo lo de Math.random()*100, sabemos que esta expresion genera numeros de 0 a 1, osea 0.234, 0.45, etc, si lo pasamos a entero todos los numeros que genere random pasan a cero(se ponene como entero osea cero) y por eso imprime solo ceros, entonces toca poner primero en parentesis la expresion (Math.random()*100) y asi el casting se hace bien,porque ya se pasa a int un numero que estara por encima del cero,osea hacian falta los parentesis de esa expresion.

4- La herramienta de debugger nos sirve para ir localizando la linea o lineas del posible error en el codigo,pero de todas formas debemos saber programar en java para ver en si que genera el error,como en este ejercicio.Cuando activamos el debugger aparece un cuadro arriba con varias flechas,la primera Step Over es para ir saltando a la siguiente linea desde el punto de interrupcion y asi ir probando linea a linea el programa.

5-el debugger se va ejecutando en un archivo aparte,para salir del debugger damos click en el cuadro rojo de la barra que sale arriba,asi cerramos la sesion de debugger,para quitar el punto de interrupcion simplemente le damos click encima. De todas formas cuando se hace debugger es solo para ver en que linea hay un error,pero debemos ir viendo la logica de ejecucion del programa y como deberia de ir corriendo,si estamos en eun bucle debemos ir viendo como funciona ese bucle, cuantas veces se debe de ir recorriendo,etc.
 */

package excepciones1;

import javax.swing.*;

public class Aleatorios {
    public static void main(String[] args) {

        // aqui digo cuantos indices tendra el array
        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Ingresa números al array"));
        int arrayAleatorios[] = new int[elementos];

        // aqui relleno el array con numeros aleatorios
        for (int i = 0; i < arrayAleatorios.length; i++) {

            arrayAleatorios[i] = (int) (Math.random() * 100);
        }

        // aqui imprimo los elementos del array
        for (int i : arrayAleatorios) {

            System.out.println(i);
        }
    }

}
