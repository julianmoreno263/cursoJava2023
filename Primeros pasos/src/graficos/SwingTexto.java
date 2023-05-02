/*(v86) vamos a ver los componentes swing de texto, veremos los cuadros de texto para poder escribir en ellos y los textArea, java tiene una clase llamada JTextComponent la cual tiene dos metodos setText() y getText() para manipular el texto de esos componentes,para crear cuadros de texto debemos usar la clase que hereda de JTextComponent llamada JTextField y para crear areas de texto usamos la clase JTextArea.Siempre ver primero la API para mirar las clases y sus constructores y metodos.

Para crear un campo de texto creamos un objeto de la clase JTextField en la lamina y lo agregamos a esta,si utilizamos el constructor por defecto(que no recibe parametros) nos sale un cuadro sin ancho.Podemos usar otro constructor que recibe un string,osea se puede poner como un placeholder.Podemos darle un ancho en una unidad de columnas.

Vamos a crear un cuadro de texto y un boton,y cuando pulsemos el boton capturamos el texto del cuadro y lo mostramos en consola.El metodo trim() ignora los espacios en blanco del campo de texto si los hay.Recordar que para que la clase oyente pueda acceder a la variable campo1,esta debe ser variable de clase,por lo que la declaramos fuera de cualquier metodo dentro de la clase LaminaTexto,y la encapsulamos como private para que no se pueda acceder a ella desde fuera de la clase LaminaTexto.

Despues d eesta practica,lo que haremos es comprobar una direccion de email,para esto primero le ponemos una etiqueta label al cuadro de texto,esto lo hacemos con la clase JLabel en el constructor de la lamina.




*/

package graficos;

import java.awt.event.*;

import javax.swing.*;

public class SwingTexto {
    public static void main(String[] args) {

        MarcoTexto miMarco = new MarcoTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoTexto extends JFrame {

    public MarcoTexto() {

        setBounds(300, 300, 600, 350);

        LaminaTexto miLamina = new LaminaTexto();
        add(miLamina);

        setVisible(true);

    }
}

// lamina
class LaminaTexto extends JPanel {

    private JTextField campo1;

    public LaminaTexto() {

        // etiqueta label
        JLabel texto1 = new JLabel("Email: ");
        add(texto1);

        // campo de texto
        campo1 = new JTextField(20);
        add(campo1);

        // creamos el boton,lo ponemos a la escucha del evento y lo agregamos a la
        // lamina
        JButton miBoton = new JButton("Mostrar Texto");
        DameTexto miEvento = new DameTexto();
        miBoton.addActionListener(miEvento);
        add(miBoton);
    }

    // clase oyente
    private class DameTexto implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println(campo1.getText().trim());
        }

    }
}