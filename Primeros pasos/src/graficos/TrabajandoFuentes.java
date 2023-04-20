/*vamos a trabajar con fuentes y como establecer diferentes tipos de fuentes, en el archivo Pruebas.java creamos un programa que nos dice si tenemos un tipo de fuente instalada o no. Para trabajar con fuentes con la clase Graphics2d, utilizamos el metodo setFont(fuente) y se le pasa el tipo de fuente, y junto con la clase Font que tiewne varios constructores podemos crear un objeto con el constructor Font(tipo,estilo,tamaño) que nos pide estos parametros y es mas facil de utilizar.*/

package graficos;

import javax.swing.*;
import java.awt.*;

public class TrabajandoFuentes {
    public static void main(String[] args) {

        MarcoFuentes miMarco = new MarcoFuentes();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoFuentes extends JFrame {

    public MarcoFuentes() {

        setTitle("Prueba con fuentes");
        setSize(400, 400);

        LaminaFuentes miLamina = new LaminaFuentes();
        add(miLamina);
    }
}

class LaminaFuentes extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // aqui creamos el objeto de tipo Font para la fuente que queremos establecer,y
        // escribimos un texto con este tipo de fuente
        Font miFuente = new Font("JetBrains Mono", Font.BOLD, 26);
        g2.setFont(miFuente);
        g2.setColor(Color.BLUE);
        g2.drawString("Julián Moreno", 100, 100);

        // podemos instanciar dentro de setFont el objeto de clase Font de una vez,como
        // con los colores
        g2.setFont(new Font("Arial", Font.ITALIC, 30));
        g2.setColor(new Color(103, 120, 45).brighter());
        g2.drawString("Programador Java", 100, 200);

    }
}