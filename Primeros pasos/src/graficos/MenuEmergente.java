/*(v109), vamos a ver los menus emergentes, son esos menus que salen cuando damos click derecho sobre algo,por ejemplo en word cuando damos click derecho sale un menu emergente con sus opciones,para crear estos menus debemos utilizar la clase JPopupMenu la cual tiene solo dos constructores y tiene varios metodos,entre estos metodos esta el metodo setComponentPopupMenu(Component c) el cual nos permite establecer en donde se ejecutara este menu emergente,osea sobre que componente se hara click para que aparezca este menu,se le debe asar un objeto tipo Component,este hara referencia al  menu emergente.

Ahora, cuando tenemos una gui mas compleja donde hay varios componentes se hace mas complejo poner un menu emergente, vamos a crear un menu en una lamina y la ponemos en la parte norte de la lamina principal y creamos un area de texto en la zona central, esto para poder  hacer que al dar click en el area de texto que ocupara toda la zona central,osea estara tapando la lamina,al dar click en esta area salga el menu emergente,asi con este ejercicio podremos ver como ubicarnos con el metodo setComponetPopupMenu para que aparezca el menu emergente donde queremos.



*/

package graficos;

import javax.swing.*;
import java.awt.*;

public class MenuEmergente {
    public static void main(String[] args) {

        MarcoEmergente1 miMarco = new MarcoEmergente1();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoEmergente1 extends JFrame {

    public MarcoEmergente1() {
        setTitle("Menú Emergente");
        setBounds(300, 250, 550, 350);

        LaminaEmergente miLamina = new LaminaEmergente();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaEmergente extends JPanel {

    public LaminaEmergente() {

        setLayout(new BorderLayout());

        // creamos un menu normal
        JMenuBar miBarra = new JMenuBar();
        JMenu fuente = new JMenu("Fuente");
        JMenu estilo = new JMenu("Estilo");
        JMenu tamaño = new JMenu("Tamaño");
        miBarra.add(fuente);
        miBarra.add(estilo);
        miBarra.add(tamaño);

        // lamina para el menu normal y la agregamos a la principal en zona norte
        JPanel laminaMenu = new JPanel();
        laminaMenu.add(miBarra);
        add(laminaMenu, BorderLayout.NORTH);

        // area de texto ubicada en zona centro de la lamina principal
        JTextPane miArea = new JTextPane();
        add(miArea, BorderLayout.CENTER);

        // creamos el menu emergente
        JPopupMenu emergente = new JPopupMenu();

        // creamos los items para el menu y los agregamos
        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");
        JMenuItem opcion3 = new JMenuItem("Opción 3");

        emergente.add(opcion1);
        emergente.add(opcion2);
        emergente.add(opcion3);

        // con el metodo setComponentPopuMenu decimos sobre que componente al dar click
        // aparecera el menu,como queremos que al dar click sobre la lamina aparezca
        // este menu,pues como ya estamos dentro de la lamina en su
        // constructor,simplemente ejecutamos este metodo indicandole en sus parametros
        // el menu que creamos,osea que al ejecutarse este metodo en la lamina debe
        // aparecer el menu.Como despues adicionamos a la lamina un area de
        // texto,entonces debemos indicarle al metodo que ya no aparecera el menu al dar
        // click sobre la lamina sino sobre esta area de texto.
        miArea.setComponentPopupMenu(emergente);

    }
}