/*(v86) vamos a ver los componentes swing de texto, veremos los cuadros de texto para poder escribir en ellos y los textArea, java tiene una clase llamada JTextComponent la cual tiene dos metodos setText() y getText() para manipular el texto de esos componentes,para crear cuadros de texto debemos usar la clase que hereda de JTextComponent llamada JTextField y para crear areas de texto usamos la clase JTextArea.Siempre ver primero la API para mirar las clases y sus constructores y metodos.

Para crear un campo de texto creamos un objeto de la clase JTextField en la lamina y lo agregamos a esta,si utilizamos el constructor por defecto(que no recibe parametros) nos sale un cuadro sin ancho.Podemos usar otro constructor que recibe un string,osea se puede poner como un placeholder.Podemos darle un ancho en una unidad de columnas.

Vamos a crear un cuadro de texto y un boton,y cuando pulsemos el boton capturamos el texto del cuadro y lo mostramos en consola.El metodo trim() ignora los espacios en blanco del campo de texto si los hay.Recordar que para que la clase oyente pueda acceder a la variable campo1,esta debe ser variable de clase,por lo que la declaramos fuera de cualquier metodo dentro de la clase LaminaTexto,y la encapsulamos como private para que no se pueda acceder a ella desde fuera de la clase LaminaTexto.

Despues d eesta practica,lo que haremos es comprobar una direccion de email,para esto primero le ponemos una etiqueta label al cuadro de texto,esto lo hacemos con la clase JLabel en el constructor de la lamina.

---------------------------------------------------------------------------------
(v87) ahora vamos a validar la direccion de email,para esto en actionPerformed creamos dos variables,una para guardar el texto que se ingrese en el campo de texto y la otra para contar si hay una arroba,o no la hay,o hay varias,si hay varias o no hay el email sera incorrecto.

Tambien podemos hacer que el resultado de si el email es correcto o no aparezca en la misma lamina,para esto creamos un JLabel que sera el que muestre este mensaje.
Iniciamos ese JLabel en el constructor de la lamina como un texto vacio.Y despues en el codigo de la validacion usamos este JLabel con el metodo setText() y le ponemos el correspondiente mensaje.

Podemos hacer que este mensaje aparezca en el centro de la ventana,para esto,a la primera lamina le ponemos un layout de border layout, y creamos una segunda lamina donde sera flow layout y alli ponemos el cuadro de texto y el boton,y despues le decimos a la primera lamina que el cuadro ira en el lado norte y el mensaje en el centro.

Para poner en la lamina 2 los elementos de cuadro de texto,label y boton simplemente lo indicamos asi: miLamina2.add(campo1), y asi con los demas elementos.




*/

package graficos;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

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
    private JLabel resultado;

    public LaminaTexto() {

        // establecemos border layout
        setLayout(new BorderLayout());

        // creo segunda lamina con flow layout y la agrego a la zona norte de la primera
        // lamina.
        JPanel miLamina2 = new JPanel();
        miLamina2.setLayout(new FlowLayout());
        add(miLamina2, BorderLayout.NORTH);

        // JLable para mostrar el resultado de la validacion del email,JLabel tiene un
        // constructor que me permite establecer un texto por defecto y la alineacion
        // horizontal,esto me permite posicionarlo en la ventana horizontalmente con las
        // constantes CENTER,NORTH,etc,(ver API).
        resultado = new JLabel("", JLabel.CENTER);

        // etiqueta label
        JLabel texto1 = new JLabel("Email: ");
        miLamina2.add(texto1);

        // campo de texto
        campo1 = new JTextField(20);
        miLamina2.add(campo1);

        // AQUI APARECERA EL MENSAJE DE EMAIL CORRECTO O INCORRECTO DEL JLABEL, LO
        // AGREGO EN LA ZONA CENTER DE LA PRIMERA LAMINA.
        add(resultado, BorderLayout.CENTER);

        // creamos el boton,lo ponemos a la escucha del evento y lo agregamos a la
        // lamina
        JButton miBoton = new JButton("Mostrar Texto");
        DameTexto miEvento = new DameTexto();
        miBoton.addActionListener(miEvento);
        miLamina2.add(miBoton);
    }

    // clase oyente
    private class DameTexto implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int correcto = 0;
            String email = campo1.getText().trim();

            // recorro el email,y con un if evaluo si el caracter del email en la posicion i
            // es igual a un @ pues incremente la variable correcto en 1,para determinar si
            // el email es valido o no,si se encuentra con mas @ se incrementara esta
            // variable pero ya no sera correcto el email.
            for (int i = 0; i < email.length(); i++) {

                if (email.charAt(i) == '@') {

                    correcto++;
                }
            }

            if (correcto != 1) {

                resultado.setText("Email incorrecto!!");

            } else {

                resultado.setText("Email correcto!!");
            }

            // System.out.println(campo1.getText().trim());
        }

    }
}