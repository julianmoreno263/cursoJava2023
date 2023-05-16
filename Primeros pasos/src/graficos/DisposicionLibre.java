/*(v118) las disposiciones libres nos permiten poner los elementos donde queramos.Lo que pasa es que toca trabajar con coordenadas y puede ser que una ventana con esta disposicion se vea de una forma en windows y se vea diferente en linux por ejemplo. 

1- para poner por ejemplo un boton donde queramos en nuestro contenedor,primero le decimos al contenedor que tendra un layout null.

2- el contenedor.la lamina en este caso,se divide en eje x y eje y, recordar que en java el punto 0,0 esta en la esquina superior izquierda,entonces con setBounds() ubicamos nuestro boton dentro del contenedor especificando las coordenadas que queremos darle.


*/

package graficos;

import javax.swing.*;

public class DisposicionLibre {
    public static void main(String[] args) {

        MarcoLibre miMarco = new MarcoLibre();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// frame
class MarcoLibre extends JFrame {

    public MarcoLibre() {

        setTitle("Disposición Libre");
        setBounds(300, 250, 600, 400);

        LaminaLibre miLamina = new LaminaLibre();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaLibre extends JPanel {

    public LaminaLibre() {

        // asi establecemos la disposicion libre
        setLayout(null);

        // creamos nuestro boton y con setBounds lo ubicamos.Toca con layoput libre
        // utilizar setBounds,aunque por defecto los botones tienen un tamaño,lo
        // establecemos en setBounds con ancho y alto.
        // JButton boton1 = new JButton("Boton 1");
        // JButton boton2 = new JButton("Boton 2");

        // boton1.setBounds(50, 50, 150, 50);
        // boton2.setBounds(250, 50, 150, 50);

        // add(boton1);
        // add(boton2);

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        nombre.setBounds(50, 50, 100, 20);
        apellido.setBounds(50, 150, 100, 20);

        JTextField cuadroNombre = new JTextField();
        JTextField cuadroApellido = new JTextField();
        cuadroNombre.setBounds(120, 50, 100, 20);
        cuadroApellido.setBounds(120, 150, 100, 20);

        add(nombre);
        add(apellido);
        add(cuadroNombre);
        add(cuadroApellido);

    }
}