/*(100) menus, para crear menus en swing usamos tres clases,JMenuBar,JMenu yJMenuItem,primero con JMenuBar se crea la barra donde ira el menu,despues se agregan los elementos del menu a esta barra con JMenu,cada vez que se instancie esta clase se crea un elemento de menu,y para las opciones de cada menu se usa JMenuItem.Se pueden agregar submenus con estas mismas clases.

si quiero hacer un submenu,el item del que se va a desprender ese submenu ya no es un item creado con JMenuItem,debera ser otro elemento JMenu y este tendra sus propios items.

Para separar cada grupo de items puedo utilizar lo que en swing se denomina como separador,utilizando el metodo addSeparator de la clase JMenu(ver api).

-------------------------------------------------------------------------------
(v107) podemos ponerles iconos a los items del menu,para esto utilizamos el constructor de la clase JMenuItem que admite dos arguemntos,un texto y un objeto de tipo Icon,Icon es una interface.Dentro de las clases que implementan esta interfaz esta la clase ImageIcon,por lo que si pasamos un objeto de tipo ImageIcon tambien funciona,esta clase tiene sobrecarga de constructores,podemos usar el mas sencillo que solo pide como parametro la ruta del icono.Para no confundirme con las rutas de los iconos,en vsc simplemente voy a la imagen,click derecho y doy donde dice Copy Relative Path.




 */

package graficos;

import javax.swing.*;

public class Menus1 {
    public static void main(String[] args) {

        MarcoMenu miMarco = new MarcoMenu();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// frame
class MarcoMenu extends JFrame {

    public MarcoMenu() {
        setTitle("Menu");
        setBounds(300, 250, 550, 350);

        LaminaMenu miLamina = new LaminaMenu();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaMenu extends JPanel {

    public LaminaMenu() {

        // creamos la barra de menu con JMenuBar
        JMenuBar miBarra = new JMenuBar();

        // creamos las opciones con JMenu,sus items con JMenuItem y los agregamos a la
        // barra
        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Editar");
        JMenu herramientas = new JMenu("Herramientas");

        // este sera otro menu pero tendra el submenu y va colgado del menu edicion
        JMenu opciones = new JMenu("opciones");

        // items para archivo
        JMenuItem guardar = new JMenuItem("guardar");
        JMenuItem guardarComo = new JMenuItem("guardar como");
        archivo.add(guardar);
        archivo.add(guardarComo);

        // items para edicion,utilizo addSeparator para poner un separador(linea) entre
        // cada grupo que quiera separar
        JMenuItem cortar = new JMenuItem("cortar", new ImageIcon(
                "Primeros pasos/src/graficos/img/cortar.jpg"));
        JMenuItem copiar = new JMenuItem("copiar", new ImageIcon(
                "Primeros pasos/src/graficos/img/icono-copiar.jpg"));
        JMenuItem pegar = new JMenuItem("pegar", new ImageIcon(
                "Primeros pasos/src/graficos/img/pegar.png"));
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.addSeparator();// separador
        edicion.add(opciones);

        // items para herramientas
        JMenuItem generales = new JMenuItem("general");
        herramientas.add(generales);

        // items para el submenu de opciones
        JMenuItem opcion1 = new JMenuItem("opción 1");
        JMenuItem opcion2 = new JMenuItem("opción 2");
        opciones.add(opcion1);
        opciones.add(opcion2);

        miBarra.add(archivo);
        miBarra.add(edicion);
        miBarra.add(herramientas);

        add(miBarra);

    }
}
