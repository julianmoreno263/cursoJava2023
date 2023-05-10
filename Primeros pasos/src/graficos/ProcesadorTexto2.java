/* 
 * ---------------------------------------------------------------------------
(v106) hasta aqui ya tenemos la funcionalidad del editor de texto,pero tiene algunas falencias,por ejemplo si quiero desactivar la negrita o cursiva no lo hace, para manejar mejor los textos en un componente de tipo swing tenemos la clase StyledEditorKit,para esto vamos a crear este nuevo archivo con parte del codigo anterior.

Entonces utilizando esta clase el codigo se abrevia mas para trabajar con elementos de texto de swing.

1- la clase interna sobra,entonces la eliminamos.Esto porque esta clase StyledEditorKit tiene sus propias clases internas,hay una para alinear el texto,otra para ponerlo en negrita,etc(ver API),para utilizar esta clase debo importar javax.swing.text.

2- ahora vamos a nuestra funcion y por ejemplo en el else if donde se evalua el tamaño usamos la clasee interna de FontSizeAction de StyledEditorKit.FontSizeAction pide dos parametros,un nombre identificativo para la accion que se va a ejecutar(osea como se va a cambiar el tamaño se pone un nombre para esta accion), y la variable donde se pasa el tamaño por parametro a nuestra funcion,osea el parametro tam.

NOTA: ME DABA UN ERROR DE COMPILACION Y NO EJECUTABA BIEN EL PROGRAMA PORQUE AL COPIAR Y PEGAR EL CODIGO DEL ARCHIVO ANTERIOR NO CAMBIE EL NOMBRE DE LAS CLASES Y QUEDARON IGUALES,RECORDAR QUE EN UN MISMO PAQUETE NO DEBEN HABER DOS CLASES CON EL MISMO NOMBRE,ESTO APLICA TAMBIEN PARA LAS CLASES DE LOS MARCOS Y LAS LAMINAS.

Listo!!  asi se abrevia mas el codigo utilizando esta clase para manipular los textos,esto funciona con JTextPane,con JTextArea no porque esa clase es mas compleja,pero asi es mas facil y se entiende mejor.
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