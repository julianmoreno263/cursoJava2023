/*(v89) aqui vamos a hacer un ejercicio de poner en un campo de texto un password y que tenga un numero minimo y maximo de caracteres y el campose pondra en rojo si la contraseña no esta cumpliendo con estas condiciones.

Para crear dos label con dos campos de texto en la parte de arriba del marco y en la parte de abajo un boton,la lamina principal sera de tipo border layout, creamos una segunda lamina donde estaran los campos de texto y la agregamos en la parte norte de la lamina principal,y en la parte sur de la lamina principal ponemos un boton.

Para el campo del password,debera tener minimo 8 caracteres,el campo estara en rojo hasta que tenga 8 caracteres,al tener los 8 se pondra en blanco,y como maximo tendra 12 caracteres,entonces si me paso de los 12 se pone de nuevo en rojo.Para esto usaremos las interfaces y metodos del video anterior para controlar estos campos.

Para capturar el texto en el campo del password,que es de tipo JPasswordField usamos el metodo getPassword(),este metodo devuelve un array de tipo char(ver API),por lo que s epuede recorrer con un bucle.Los campos JTextField o JPasswordField tienen un metodo para poder establecer el fondo de un color,se llama setBackground().

Por ultimo instanciamos la clase que maneja los eventos creando un objeto de esta,y ponemos el campo password a la escucha de este objeto evento con addDocumentListener(),para ponerlo a la escucha primero creamos un objeto de tipo Document y este objeto es el que en si se pone a la escucha,se puede hacer todo en una sola linea.

Listo,el codigo del if lo podemos usar tambien en el metodo removeUpdate() para que si vamos borrando tambien se resalte el color de fondo del campo.



 */

package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;

public class PruebaJtextField2 {
    public static void main(String[] args) {

        MarcoPassw miMarco = new MarcoPassw();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoPassw extends JFrame {

    public MarcoPassw() {

        setBounds(300, 300, 500, 350);

        LaminaPassw miLamina = new LaminaPassw();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaPassw extends JPanel {

    JPasswordField password;

    public LaminaPassw() {

        setLayout(new BorderLayout());

        // segunda lamina,el layout es de grid(2 filas y 2 columnas) y estara en la zona
        // norte
        JPanel laminaSuperior = new JPanel();
        laminaSuperior.setLayout(new GridLayout(2, 2));
        add(laminaSuperior, BorderLayout.NORTH);

        // etiquetas para la laminaSuperior y cuadros de texto,para el password se usa
        // la clase JPasswordField
        JLabel etiqueta1 = new JLabel("Usuario: ");
        JLabel etiqueta2 = new JLabel("Password: ");
        JTextField usuario = new JTextField(15);
        password = new JPasswordField(15);

        // ponemos a la escucha del evento al campo password creando primero un objeto
        // de la clase oyente
        CompruebaPassw miEvento = new CompruebaPassw();
        password.getDocument().addDocumentListener(miEvento);

        // agregamos a la laminaSuperior estos elementos,en el orden en que queremos que
        // se muestren segun la grilla que creamos.
        laminaSuperior.add(etiqueta1);
        laminaSuperior.add(usuario);
        laminaSuperior.add(etiqueta2);
        laminaSuperior.add(password);

        // boton
        JButton miBoton = new JButton("Enviar");
        add(miBoton, BorderLayout.SOUTH);

    }

    // clase interna oyente
    private class CompruebaPassw implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {

            // capturamos lo que se ingrese en el campo de password
            char contraseña[];
            contraseña = password.getPassword();

            // aqui evaluamos el password y resaltamos el color de fondo del campo.
            if (contraseña.length < 8 || contraseña.length > 12) {

                password.setBackground(Color.RED);

            } else {

                password.setBackground(Color.WHITE);
            }

        }

        @Override
        public void removeUpdate(DocumentEvent e) {

            // capturamos lo que se ingrese en el campo de password
            char contraseña[];
            contraseña = password.getPassword();

            // aqui evaluamos el password y resaltamos el color de fondo del campo.
            if (contraseña.length < 8 || contraseña.length > 12) {

                password.setBackground(Color.RED);

            } else {

                password.setBackground(Color.WHITE);
            }

        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }

    }
}
