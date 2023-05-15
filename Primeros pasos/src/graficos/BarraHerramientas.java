/*(v111) vamos a ver como crear barras de herramientas, esto lo hacemos con la clase JToolBar y el metodo add(Action accion) al cual le pasamos una accion.

Entonces, vamosa crear una barra de herramientas y cuando pulsemos en sus botones,la lamina se pondra del respectivo color(es parecido al ejercicio de eventos9 pero no con botones sino con una barra de herramientas).

Entonces crearemos un menu pequeño y una barra de herramientas,asi podremos cambiar el color de fondo de la lamina ya sea desde el menu o desde la barra.

NOTA: TENER EN CUENTA QUE PARA QUE LA LAMINA QUEDE A LA ESCUCHA DE LAS ACCIONES Y CAMBIE SU COLOR DE FONDO, EN EL METODO actionPerformed() DEBEMOS INDICARLE ESTO CON miLamina.setBackground(c),EN ESTE CASO DONDE NO HAY UNA CLASE PARA LA LAMINA,SINO QUE LA INSTANCIAMOS DENTRO DEL FRAME DE UNA VEZ.

podemos agregar a la barra de herramientas un boton mas para salir de toda la aplicacion.Entonces como este boton tendra una accion diferente a los de colores, no nos sirve la clase interna que tenemos,por lo que debemos crear este boton con su propia accion.

1- para crear la accion de salir instanciamos directamente la interfaz AbstractAction y le pasamos los parametros de nombre,la ruta del icono y debo implementar los metodos de esta interfaz directamente(ver video),que es el metodo actionPerformed().

2- en actionPerformed ponemos el codigo a ejecutar cuando demos click en el boton de salir,simplemente ponemos la funcion System.exit(0).

3- podemos agregar un separador para este boton con addSeparator() y despues lo agregamos a la barra.

 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BarraHerramientas {
    public static void main(String[] args) {

        MarcoBarra2 miMarco = new MarcoBarra2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// frame
class MarcoBarra2 extends JFrame {

    JPanel miLamina;

    public MarcoBarra2() {
        setTitle("Barra Herramientas");
        setBounds(300, 250, 600, 400);

        // lamina
        miLamina = new JPanel();

        add(miLamina);

        // acciones
        Action colorAmarillo = new AccionColor2("Amarillo",
                new ImageIcon("Primeros pasos/src/graficos/img/amarilla.jpg"),
                Color.YELLOW);

        Action colorAzul = new AccionColor2("Azul",
                new ImageIcon("Primeros pasos/src/graficos/img/azul.png"),
                Color.BLUE);

        Action colorRojo = new AccionColor2("Rojo",
                new ImageIcon("Primeros pasos/src/graficos/img/rojo.jpg"),
                Color.RED);

        // accion para boton de salir d ela barra de herramientas
        Action accionSalir = new AbstractAction("Salir", new ImageIcon("Primeros pasos/src/graficos/img/salir.png")) {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        };

        // creamos la barra de menu, el menu al cual le agregamos las acciones y este
        // menu lo agregamos a la barra.Luego esta barra con el menu la agregamos
        // directamente al marco con el metodo setJMenuBar que es heredado de la clase
        // JFrame.
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Color");
        menu.add(colorAmarillo);
        menu.add(colorAzul);
        menu.add(colorRojo);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        // creacion barra de herramientas con la clase JToolBar y agregamos las acciones
        // con el metodo add(), luego la agregamos al marco pero por defecto la pone
        // arriba y no se puede arrastrar,para que la podamos arrastrar le indicamos un
        // border layout norte y la agrega en zona norte pero se deja arrastrar y
        // cambiar de posicion.
        JToolBar barra = new JToolBar();
        barra.add(colorAmarillo);
        barra.add(colorAzul);
        barra.add(colorRojo);
        barra.addSeparator();
        barra.add(accionSalir);
        add(barra, BorderLayout.NORTH);

        setVisible(true);
    }

    private class AccionColor2 extends AbstractAction {

        public AccionColor2(String nombre, Icon icono, Color color) {

            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color" + nombre);
            putValue("colorFondo", color);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Color c = (Color) getValue("colorFondo");
            miLamina.setBackground(c);
        }

    }

}
