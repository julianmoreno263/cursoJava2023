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

-----------------------------------------------------------------------------------------
(v112) vamos a crear una barra de herramientas en nuestro procesador de texto,lo crearemos a la izquierda.

1- estara en la lamina principal,por lo que nos ubicamos en el contructor de la lamina.
2- en principio tendra dos botones,uno para negrita y otro para cursiva.
3-por defecto la barra pone los botones juntos horizontalmente, si queremos cambiar esta disposicion de los botones usamos el metodo setOrientation() de la clase JToolBar.(ver API). este metodo requiere un argumento de tipo int que es el valor de horizontal(0) o vertical(1).
4-podemos hacer otra funcionalidad que nos permita subrayar un texto,la clase StyledEditorKit tiene una clase llamada UnderlineAction,esta nos permite subrayar un texto.
5-podemos hacer mas botones para cambiar el color de un texto,esto con la clase ForegroundAction de StyledEditorKit. El constructor de esta clase pide un string y un objeto de tipo Color.(ver API).
6-ponemos en la barra 4 botones mas para la alineacion del texto(centrado,justificado,izquierda,derecha), esto lo hacemos con la clase AligmentAction de StyledEditorKit.Esta clase pide un string para descripcion de la accion y un int que sera el valor de cada posicion,en la API no establece si por ejemplo la izquierda vale 1 o 2,etc,no dice,solo dice que este parametro int debe ser >=0, por lo que toca ir probando,por ejemplo a la izquierda le ponemos 0,a la derecha 1,etc,y dependiendo como salga el texto alineado vamos cambiando esos valores.Pero izquierda es 0,centro es 1,derecha es 2 y justificado es 3.(ver API).

---------------------------------------------------------------------------------------------
(v114) listo,ya esta nuestra barra,pero hay mucho codigo,asi que debemos optimizarlo,podemos crear una funcion para mejorar este codigo.

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
    JButton negritaBarra, cursivaBarra, subrayadoBarra, amarilloBarra, azulBarra, rojoBarra, izquierdoBarra,
            derechoBarra, centroBarra, justificadoBarra;
    JToolBar barra;

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

        // -------------------------------------------------------------
        // barra de herramientas
        // JToolBar barra = new JToolBar();

        // botones para la barra,los ponemos a la escucha con addActionListener y la
        // clase StyledEditorKit.
        // JButton negritaBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/negrita.jpg"));
        // JButton cursivaBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/cursiva.png"));
        // JButton subrayadoBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/subrayado.png"));
        // JButton amarilloBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/amarilla.jpg"));
        // JButton azulBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/azul.png"));
        // JButton rojoBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/rojo.jpg"));
        // JButton izquierdoBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/izquierda.png"));
        // JButton derechoBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/derecha.png"));
        // JButton centroBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/centrado.png"));
        // JButton justificadoBarra = new JButton(new ImageIcon("Primeros
        // pasos/src/graficos/img/justificado.png"));

        // negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
        // cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
        // subrayadoBarra.addActionListener(new StyledEditorKit.UnderlineAction());
        // amarilloBarra.addActionListener(new
        // StyledEditorKit.ForegroundAction("texto-amarillo", Color.YELLOW));
        // azulBarra.addActionListener(new
        // StyledEditorKit.ForegroundAction("texto-azul", Color.BLUE));
        // rojoBarra.addActionListener(new
        // StyledEditorKit.ForegroundAction("texto-rojo", Color.RED));
        // izquierdoBarra.addActionListener(new
        // StyledEditorKit.AlignmentAction("texto-izquierda", 0));
        // centroBarra.addActionListener(new
        // StyledEditorKit.AlignmentAction("texto-centro", 1));
        // derechoBarra.addActionListener(new
        // StyledEditorKit.AlignmentAction("texto-derecha", 2));
        // justificadoBarra.addActionListener(new
        // StyledEditorKit.AlignmentAction("texto-justificado", 3));

        // barra.add(negritaBarra);
        // barra.add(cursivaBarra);
        // barra.add(subrayadoBarra);
        // barra.add(amarilloBarra);
        // barra.add(azulBarra);
        // barra.add(rojoBarra);
        // barra.add(izquierdoBarra);
        // barra.add(derechoBarra);
        // barra.add(centroBarra);
        // barra.add(justificadoBarra);

        barra = new JToolBar();
        creaBarra("Primeros pasos/src/graficos/img/negrita.jpg").addActionListener(new StyledEditorKit.BoldAction());
        creaBarra("Primeros pasos/src/graficos/img/cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
        creaBarra("Primeros pasos/src/graficos/img/subrayado.png")
                .addActionListener(new StyledEditorKit.UnderlineAction());

        barra.addSeparator();
        creaBarra("Primeros pasos/src/graficos/img/amarilla.jpg")
                .addActionListener(new StyledEditorKit.ForegroundAction("texto-amarillo", Color.YELLOW));
        creaBarra("Primeros pasos/src/graficos/img/azul.png")
                .addActionListener(new StyledEditorKit.ForegroundAction("texto-amarillo", Color.BLUE));
        creaBarra("Primeros pasos/src/graficos/img/rojo.jpg")
                .addActionListener(new StyledEditorKit.ForegroundAction("texto-amarillo", Color.RED));

        barra.addSeparator();
        creaBarra("Primeros pasos/src/graficos/img/izquierda.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("texto-izquierda", 0));
        creaBarra("Primeros pasos/src/graficos/img/centrado.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("texto-centrado", 1));
        creaBarra("Primeros pasos/src/graficos/img/derecha.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("texto-derecha", 2));
        creaBarra("Primeros pasos/src/graficos/img/justificado.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("texto-justificado", 3));

        barra.setOrientation(1);

        // agregamos la barra a la lamina en la zona izquierda
        add(barra, BorderLayout.WEST);

    }

    // funcion para crear los botones de la barra de herramientas para abreviar asi
    // el codigo anterior,como nos devolvera un objeto de tipo JButton podemos
    // utilizar con esta funcion el metodo addActionListener para ir creando los
    // botones y en la misma linea ponerlos a la escucha.

    public JButton creaBarra(String ruta) {

        JButton boton = new JButton(new ImageIcon(ruta));
        barra.add(boton);
        return boton;
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