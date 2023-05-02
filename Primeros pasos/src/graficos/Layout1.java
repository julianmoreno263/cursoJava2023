
/*(v81) vamos a ver las disposiciones o layouts que en si es la forma de posicionar elementos dentro de un contenedor,como un frame o una lamina.Java maneja 3 layouts,el layout por defecto(flow layout), el border layout y el grid layout.

1-flow layout es el layout por defecto
2-border layout divide el contenedor en zona norte,sur,este,oeste y centro.Si creamos un elemento dentro de una de estas zonas,ese elemento tiende a llenar todo el espacio de la zona.
3-grid layout divide el contenedor en una grilla.

Para manejar estos layouts java tiene clases,tienen el mismo nombre de los layouts y vienen del paquete java.awt, y para establecer primero con cual layout queremos trabajar ennuestro contenedor usamos el metodo setLayout de la clase Container,la cual le hereda este metodo a la clase JPanel en la que hemos venido trabajando.

1 el flow layout alinea por defecto los elementos arriba y en el centro,y una separacion(gap) de 5px entre elementos, pero esto se puede cambiar indicando con las constantes de clase la posicion que queremos,la clase FlowLayout maneja 5 campos de clase o constantes(CENTER,LEFT,RIGTH,etc),esta clase tambien tiene sobrecarga de constructores,asi que si usamos el constructor que nos pide como parametro una de estas constantes,podemos cambiar la alineacion por defecto.(ver API)

Entonces,si quiero cambiar la posicion de los botones de mi marco, voy al constructor de la lamina y creo un objeto de tipo FlowLayout y con su correspondiente constructor le indico la horientacion que quiero para los elementos.Luego con el metodo setLayout que viene en la clase JPanel(osea en la lamina) establesco esta disposicion pasandole este objeto de tipo FlowLayout.Este codigo lo puedo abreviar instanciando dentro de setLayout de una vez.

si queremos jugar con la separacion entre elementos(gap) podemos usar el tercer constructor de FlowLayout donde admite 2 parametros mas,la separacion horizontal y vertical.
-------------------------------------------------------------------------

Para border layout solo hay dos constructores,el constructor por defecto sin parametros y el constructor que admite los valores de separacion(gap).Establecemos el border layout igual que con flow layout,y despues debemos decirle a los elementos(botones) en que zona deben ir,el metodo add donde agregamos los botones admite un segundo parametro que es la posicion.

No puedo crear dos disposiciones dentro de un mismo contenedor,en este caso la lamina,osea,si quiero tener dos layouts diferentes debo crear dos laminas,una para cada layout y luego adicionarlas a mi marco.Para adicionarlas al marco y que se pueda ver cada layout de cada lamina,en los metodos add donde adiciono las laminas indico tambien la disposicion de cada lamina con BorderLayout, asi se ve cada layout de cada lamina,si no indico esto en el metodo add pues la segunda lamina creada lo que hace es ponerse encima de la primera y solo se veria el layout de la segunda lamina.



 */

package graficos;

import javax.swing.*;
import java.awt.*;

public class Layout1 {
    public static void main(String[] args) {

        MarcoLayout miMarco = new MarcoLayout();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoLayout extends JFrame {

    public MarcoLayout() {
        setTitle("Prueba acciones layout");
        setBounds(300, 300, 600, 300);

        LaminaLayout miLamina = new LaminaLayout();
        add(miLamina);
    }
}

// lamina
class LaminaLayout extends JPanel {

    public LaminaLayout() {

        // ---------------- flow layout ----------------------------
        // cambio el layout por defecto flow layout de los botones
        // FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
        // miLamina.setLayout(disposicion);

        // abrevio el codigo del layout instanciando de una vez en la lamina con
        // setLayout
        // setLayout(new FlowLayout(FlowLayout.CENTER, 100, 200));
        // -----------------------------------------------------------

        // --------------------- border layout -------------------------------
        // aqui establecemos el border layout y en el metodo add indicamos la zona en
        // que ira cada elemento, por defecto cada elemento tiende a rellenar todo el
        // espacio de la zona donde esta.
        setLayout(new BorderLayout(5, 5));

        add(new JButton("Amarillo"), BorderLayout.NORTH);
        add(new JButton("Rojo"), BorderLayout.CENTER);
        add(new JButton("Azul"), BorderLayout.SOUTH);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Black"), BorderLayout.WEST);

    }
}