/*(v101) en este punto vamos a hacer una practica guiada,crearemos un procesador de texto basico.

La lamina tendra una disposicion border layout,en la parte norte estara la barra de menu dentro de otra lamina y en el centro de la lamina estara el area de texto,la cual crearemos con la clase JTextPane para que si queremos nos permita tener barras de scroll.

Para poner al area de texto a la escucha y poder cambiar el tipo de letra en la clase oyente utilizamos el metodo setFont().

Podemos abreviar codigo poniendo cada elemento a la escucha del evento utilizando clases internas anonimas usando ActionListener(){aqui va el metodo actionPerformed con el respectivo codigo},pero asi me saca un error de sobreescritura y no se como corregirlo,por lo menos con vsc, entonces el profesor de todas formas para abreviar el codigo y no tener que escribir una clase anonima para cada variable(fuentes,tamaños,etc) se crea mejor un metodo que haga todo el trabajo.

--------------------------------------------------------------------------------------
(v103)Entonces, esa funcion se va a encargar de crear los items de courier,verdana,tamaños 12,16,etc,todos los items, y ademas pondra esos elementos a la escucha para que sean capaces de reaccionar al evento cuando se quiera poner un tipo de letra pero ademas se quiera poner un estilo y un tamaño especifico.Esa funcion entonces la creamos dentro de la clase de la lamina principal.

Y tambien debemos crear una clase interna para poner los elementos a la escucha de los eventos., en si la funcion crea los items de menu y con ayuda de una clase oyente los pone a la escucha,con esta funcion nos ahorraremos codigo y ademas se podra tener la funcionalidad deseada que es el poder usar todas las ociones a la vez si queremos.

1-creamos la funcion, recibira un argumento string rotulo para crear cada texto de item,osea los textos de arial,verdana,12,etc.

2- otro argumento string llamado menu,que especifica a que menu ira cada item,osea si un item va para el menu de fuente,o de estilo o tamaño.

3- otro argumento string para especificar el tipo de letra de los items que cuelgan en el menu fuente.

4- otro argumento de tipo int para especificar los estilos de letra,estos estilos son constantes,por eso debe ser de tipo int(BOLD,ITALIC,etc).

5- un argumento de tipo int para los tamaños de letra,en si,creamos argumentos para cada tipo de item del menu.

en la clase oyente,como los argumentos para el constructor de la clase Font no pueden ser fijos,creo variables para poder utilizarlas y asi establecer los valores especificos que quiera tener al poner a la escucha esos elementos.

---------------------------------------------------------------------------
(v106) hasta aqui ya tenemos la funcionalidad del editor de texto,pero tiene algunas falencias,por ejemplo si quiero desactivar la negrita o cursiva no lo hace, para manejar mejor los textos en un componente de tipo swing tenemos la clase StyledEditorKit,para esto vamos a crear este nuevo archivo con parte del codigo anterior.

-------------------------------------------------------------------------------------
(v107) podemos ponerles iconos a los items del menu,para esto utilizamos el constructor de la clase JMenuItem que admite dos arguemntos,un texto y un objeto de tipo Icon,Icon es una interface.Dentro de las clases que implementan esta interfaz esta la clase ImageIcon,por lo que si pasamos un objeto de tipo ImageIcon tambien funciona,esta clase tiene sobrecarga de constructores,podemos usar el mas sencillo que solo pide como parametro la ruta del icono.Para no confundirme con las rutas de los iconos,en vsc simplemente voy a la imagen,click derecho y doy donde dice Copy Relative Path.

 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProcesadorTexto {
    public static void main(String[] args) {

        MarcoProcesador miMarco = new MarcoProcesador();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Frame
class MarcoProcesador extends JFrame {

    public MarcoProcesador() {
        setTitle("Procesador de texto");
        setBounds(300, 250, 550, 400);

        LaminaProcesador miLamina = new LaminaProcesador();
        add(miLamina);

        setVisible(true);
    }

}

// lamina
class LaminaProcesador extends JPanel {

    JTextPane miArea;
    JMenu fuente, estilo, tamaño;
    Font letra;

    public LaminaProcesador() {

        setLayout(new BorderLayout());

        // segunda lamina para el menu
        JPanel laminaMenu = new JPanel();

        // crear menu
        JMenuBar miBarra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamaño = new JMenu("Tamaño");

        // aqui usamos la funcion para crear items de fuente,estilo y tamaño
        creaMenu("Arial", "fuente", "Arial", 9, 10);
        creaMenu("Courier", "fuente", "Courier", 9, 10);
        creaMenu("Verdana", "fuente", "Verdana", 9, 10);

        creaMenu("Negrita", "estilo", "", Font.BOLD, 1);
        creaMenu("Cursiva", "estilo", "", Font.ITALIC, 1);

        creaMenu("12", "tamaño", "", 9, 12);
        creaMenu("16", "tamaño", "", 9, 16);
        creaMenu("20", "tamaño", "", 9, 20);
        creaMenu("24", "tamaño", "", 9, 24);

        miBarra.add(fuente);
        miBarra.add(estilo);
        miBarra.add(tamaño);
        laminaMenu.add(miBarra);

        // agregamos menu a la zona norte
        add(laminaMenu, BorderLayout.NORTH);

        // area de texto en la zona central de la lamina principal
        miArea = new JTextPane();
        add(miArea, BorderLayout.CENTER);

    }

    // funcion que construye los items del menu y pone a la escucha esos elementos
    public void creaMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {

        // aqui se construye cada item
        JMenuItem itemMenu = new JMenuItem(rotulo);

        // aqui evaluo en que menu pongo cada item
        if (menu == "fuente") {
            fuente.add(itemMenu);
        } else if (menu == "estilo") {
            estilo.add(itemMenu);
        } else if (menu == "tamaño") {
            tamaño.add(itemMenu);
        }

        // aqui usamos la clase oyente para poner el elemento del item creado a la
        // escucha del evento
        itemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
    }

    // clase interna oyente para poner al menu a la escucha,la variable tipoTexto
    // establecera el tipo de letra(arial,etc),menu servira para saber que item se
    // ha pulsado(arial,20,cursiva,etc),una int para el estilo de letra y otra int
    // para el tamaño. Despues,como necesitamos almacenar en estas variables los
    // valores que establecimos en la clase padre(la lamina principal),osea por
    // ejemplo el tipo de letra Arial con un tamaño 12,etc,creamos en la clase
    // interna oyente un constructor que reciba como argumentos un string
    // "itemPulsado"
    // para detectar que item se ha pulsado,otro string para almacenar el texto del
    // item pulsado en el tipo de fuente(arial,verdana o cursiva),y dos int para
    // almacenar el estilo y tamaño de letra.En si este constructor lo que hace es
    // detectar que item se ha pulsado.Dentro del constructor se establece a cual
    // argumento corresponde el valor de cada variable. Como en la funcion vamos a
    // usar el construcotr de la clase oyente y este constructor necesita que le
    // pasemos estos parametros que vienen de la clase padre,asi es la forma de
    // pasarselos,por medio de los argumentos de la funcion.

    // lo ultimo que hay que hacer para nuestro editor,es indicarle cual menu se ha
    // pulsado(fuente,estilo o tamaño) y dependiendo del menu pulsado que asi mismo
    // cambie el texto pero que deje los demas estados como esten,osea,si tiene un
    // tamaño 20 por ejemplo y queremos cambiar a Arial,pues que solo cambie a Arial
    // y el tamaño lo deje como esta,para esto la variable miArea que es de tipo
    // JTextPane tiene un metodo getFont() que devuelve un objeto de tipo Font,y con
    // esto usamos la variable letra que creamos para capturar alli el tipo de letra
    // que tiene el texto en el area en el momento,osea el texto del momento con su
    // tipo de letra,estilo y tamaño.Y despues con el texto capturado,utilizamos
    // otros metodos para ir sacando los diferentes valores de ese texto de tipo de
    // letra,tamaño y estilo, de esta forma con la variable menu evaluo que tipo de
    // letra se pulso y dependiendo de eso voy dejando los otros parametros de
    // estilo y tamaño como los tiene en ese momento,asi creamos la funcionalidad de
    // poder ir pulsando los diferentes items y que el texto cambie de acuerdo con
    // ellos.

    private class GestionaEventos implements java.awt.event.ActionListener {

        String tipoTexto, menu;
        int estiloLetra, tamañoLetra;

        GestionaEventos(String itemPulsado, String texto2, int estilo2, int tamLetra) {

            this.tipoTexto = texto2;
            this.estiloLetra = estilo2;
            this.tamañoLetra = tamLetra;
            this.menu = itemPulsado;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // almaceno el tipo de letra que haya en el area de texto
            letra = miArea.getFont();

            if (menu == "Arial" || menu == "Courier" || menu == "Verdana") {

                estiloLetra = letra.getStyle();
                tamañoLetra = letra.getSize();
            } else if (menu == "Negrita" || menu == "Cursiva") {

                // if para evaluar si tiene tanto negrita como cursiva que sume ambos valores
                if (letra.getStyle() == 1 || letra.getStyle() == 2) {

                    estiloLetra = 3;
                }

                tipoTexto = letra.getFontName();
                tamañoLetra = letra.getSize();
            } else if (menu == "12" || menu == "16" || menu == "20" || menu == "24") {

                tipoTexto = letra.getFontName();
                estiloLetra = letra.getStyle();

            }

            miArea.setFont(new Font(tipoTexto, estiloLetra, tamañoLetra));

        }

    }
}