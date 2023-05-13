/* 
 * ---------------------------------------------------------------------------
(v106) hasta aqui ya tenemos la funcionalidad del editor de texto,pero tiene algunas falencias,por ejemplo si quiero desactivar la negrita o cursiva no lo hace, para manejar mejor los textos en un componente de tipo swing tenemos la clase StyledEditorKit,para esto vamos a crear este nuevo archivo con parte del codigo anterior.

Entonces utilizando esta clase el codigo se abrevia mas para trabajar con elementos de texto de swing.

1- la clase interna sobra,entonces la eliminamos.Esto porque esta clase StyledEditorKit tiene sus propias clases internas,hay una para alinear el texto,otra para ponerlo en negrita,etc(ver API),para utilizar esta clase debo importar javax.swing.text.

2- ahora vamos a nuestra funcion y por ejemplo en el else if donde se evalua el tamaño usamos la clasee interna de FontSizeAction de StyledEditorKit.FontSizeAction pide dos parametros,un nombre identificativo para la accion que se va a ejecutar(osea como se va a cambiar el tamaño se pone un nombre para esta accion), y la variable donde se pasa el tamaño por parametro a nuestra funcion,osea el parametro tam.

NOTA: ME DABA UN ERROR DE COMPILACION Y NO EJECUTABA BIEN EL PROGRAMA PORQUE AL COPIAR Y PEGAR EL CODIGO DEL ARCHIVO ANTERIOR NO CAMBIE EL NOMBRE DE LAS CLASES Y QUEDARON IGUALES,RECORDAR QUE EN UN MISMO PAQUETE NO DEBEN HABER DOS CLASES CON EL MISMO NOMBRE,ESTO APLICA TAMBIEN PARA LAS CLASES DE LOS MARCOS Y LAS LAMINAS.

Listo!!  asi se abrevia mas el codigo utilizando esta clase para manipular los textos,esto funciona con JTextPane,con JTextArea no porque esa clase es mas compleja,pero asi es mas facil y se entiende mejor.

---------------------------------------------------------------------------
(v107) podemos ponerles iconos a los items del menu,para esto utilizamos el constructor de la clase JMenuItem que admite dos arguemntos,un texto y un objeto de tipo Icon,Icon es una interface.Dentro de las clases que implementan esta interfaz esta la clase ImageIcon,por lo que si pasamos un objeto de tipo ImageIcon tambien funciona,esta clase tiene sobrecarga de constructores,podemos usar el mas sencillo que solo pide como parametro la ruta del icono.Para no confundirme con las rutas de los iconos,en vsc simplemente voy a la imagen,click derecho y doy donde dice Copy Relative Path.

Para nuestro caso,si queremos poner iconos para negrita y cursiva, en este archivo estamos construyendo los items de menu desde la funcion creaMenu, y asi no le podemos pasar como segundo argumento el new ImageIcon(ruta) porque todos los items me los dejaria con el mismo icono,entonces hago:

1- pongo solamente como segundo argumento de JMenuItem el new ImageIcon() sencillo,sin ruta.
2- en las llamadas de la funcion creaMenu para los items de fuente y tamaño pongo un sexto argumento(para que indique que recibira un 6 argumento) que sera un texto vacio.Pero para los items de negrita y cursiva si paso la ruta a los iconos.
3-en la funcion, tambien le indico que recibira un sexto argumento de tipo String llamado por ejemplo icon. Listo,asi se le pasa el icono a los items en un JMenuItem.

-----------------------------------------------------------------------------
(v108) vamos a crear menus pero con checkbox y radioButtons, para esto debemos usar las clases JCheckBoxMenuItem y JRadioButtonMenuItem. En este ejercicio podemos poner las casillas de estilo como checkbox para que s epuedan seleccionar ambas a la vez,y en tamño podemos poner radioButtons.

1- como la funcion creaMenu hace todos los items,no podemos usarla para crear estos check y radios porque esta usando la clase JMenuItem,se podia modificar la funcion pero se complica mas,asi que simplemente no usaremos esta funcion para los items de estilo y tamaño(comentamos donde hacemos la llamada a esta funcion para estilo y tamaño.)

2- usamos la clase JCheckBoxMenuItem para crear los items tipo check y los pongo a la escucha,la funcionalidad la copio de lo que habiamos echo antes utilizando la clase StyleEditorKit.En la funcion comento el codigo del else if de estilo porque ya no aplica, y asi ya creolos check para estos items de estilo,hago lo mismo con radio buttons para los tamaños. Pero para mi gusto dejo todo como estaba trabajando en la funcion con JMenuItem porque asi lo entiendo mas.

------------------------------------------------------------------------------

(v109) vamos a hacer un menu emergente con las opciones de negrita y cursiva,asi el usuario podra cambiar el estilo del texto ya sea desde el menu principal o desde este menu emergente.

*/

package graficos;

import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;

public class ProcesadorTexto2 {
    public static void main(String[] args) {

        MarcoProcesador2 miMarco = new MarcoProcesador2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Frame
class MarcoProcesador2 extends JFrame {

    public MarcoProcesador2() {
        setTitle("Procesador de texto");
        setBounds(300, 250, 550, 400);

        LaminaProcesador2 miLamina = new LaminaProcesador2();
        add(miLamina);

        setVisible(true);
    }

}

// lamina
class LaminaProcesador2 extends JPanel {

    JTextPane miArea;
    JMenu fuente, estilo, tamaño;
    Font letra;

    public LaminaProcesador2() {

        setLayout(new BorderLayout());

        // segunda lamina para el menu
        JPanel laminaMenu = new JPanel();

        // crear menu
        JMenuBar miBarra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamaño = new JMenu("Tamaño");

        // aqui usamos la funcion para crear items de fuente,estilo y tamaño
        creaMenu("Arial", "fuente", "Arial", 9, 10, "");
        creaMenu("Courier", "fuente", "Courier", 9, 10, "");
        creaMenu("Verdana", "fuente", "Verdana", 9, 10, "");

        creaMenu("Negrita", "estilo", "", Font.BOLD, 1, "Primeros pasos/src/graficos/img/negrita.jpg");
        creaMenu("Cursiva", "estilo", "", Font.ITALIC, 1, "Primeros pasos/src/graficos/img/cursiva.png");

        // JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita",
        // new ImageIcon("Primeros pasos/src/graficos/img/negrita.jpg"));
        // JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva",
        // new ImageIcon("Primeros pasos/src/graficos/img/cursiva.png"));

        // negrita.addActionListener(new StyledEditorKit.BoldAction());
        // cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        // estilo.add(negrita);
        // estilo.add(cursiva);

        creaMenu("12", "tamaño", "", 9, 12, "");
        creaMenu("16", "tamaño", "", 9, 16, "");
        creaMenu("20", "tamaño", "", 9, 20, "");
        creaMenu("24", "tamaño", "", 9, 24, "");

        miBarra.add(fuente);
        miBarra.add(estilo);
        miBarra.add(tamaño);
        laminaMenu.add(miBarra);

        // agregamos menu a la zona norte
        add(laminaMenu, BorderLayout.NORTH);

        // area de texto en la zona central de la lamina principal
        miArea = new JTextPane();
        add(miArea, BorderLayout.CENTER);

        // ------------ menu emergente -----------------------
        JPopupMenu emergente = new JPopupMenu();

        // creamos los items para el menu,los ponemos a la escucha y los agregamos al
        // area d etexto
        JMenuItem negritaE = new JMenuItem("Negrita");
        JMenuItem cursivaE = new JMenuItem("Cursiva");

        negritaE.addActionListener(new StyledEditorKit.BoldAction());
        cursivaE.addActionListener(new StyledEditorKit.ItalicAction());

        emergente.add(negritaE);
        emergente.add(cursivaE);

        miArea.setComponentPopupMenu(emergente);

    }

    // funcion que construye los items del menu y pone a la escucha esos elementos
    public void creaMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam, String icon) {

        // aqui se construye cada item
        JMenuItem itemMenu = new JMenuItem(rotulo, new ImageIcon(icon));

        // aqui evaluo en que menu pongo cada item
        if (menu == "fuente") {
            fuente.add(itemMenu);
            if (tipoLetra == "Arial") {

                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Arial"));
            } else if (tipoLetra == "Courier") {
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Courier"));
            } else if (tipoLetra == "Verdana") {
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Verdana"));
            }

        } else if (menu == "estilo") {
            estilo.add(itemMenu);
            if (estilos == Font.BOLD) {
                itemMenu.addActionListener(new StyledEditorKit.BoldAction());
            } else if (estilos == Font.ITALIC) {

                itemMenu.addActionListener(new StyledEditorKit.ItalicAction());

            }

        } else if (menu == "tamaño") {
            tamaño.add(itemMenu);
            // uso clase interna de StyledEditorKit
            itemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño",
                    tam));
        }

    }

}