/*(v190) Socket permite crear aplicaciones cliente-servidor,osea mover información desde un cliente a un servidor.Un socket es como un puente virtual para enviar esa información entre el cliente y el servidor.Debemos crear la app cliente y la app servidor y después se comunican creando el socket.

Para hacer el socket necesitamos saber el dominio o la ip del servidor y el puerto.Tambien necesitaremos crear en el cliente un outputStream y en el servidor un inputStream(flujos de datos).Este tipo de app de cliente servidor sirven entre otras cosas para hacer virus,utilizando una app cliente y haciendo que el computador remoto instale la app remota y usando un socket se puede controlar el pc remoto.

Vamos a hacer una app cliente y otra servidor con swing y las comunicaremos con un socket,para esto trabajaremos el servidor en local.Esto será una aplicación de un chat.

la idea es que en la aplicacion cliente hay un cuadro de texto y en la app servidor hay un textArea, entonces cuando escribamos en el cuadro de texto del cliente,por medio de un socket aparecera lo que escribimos en el textArea del servidor,como un chat,aunque por ahora solo sera de una via.

1- le damos funcionalidad al boton del cliente para que pueda enviar los datos,creamos una clase interna para esto en la lamina,esta clase es la que tiene el evento que se dispara,actionPerformed().

2- ahora creamos una instancia de esa clase interna para poner el boton a la escucha de ese evento.Lo hacemos en el constructor antes de agregar el boton a la lamina.Probamos que sirva usando un syso en actionPerformed que me imprima lo que escribo usando el metodo getText() del objeto JTextField.

3-listo,ya sabiendo que el boton responde al evento,construimos el socket en el actionPerformed(), de esta forma al pulsar el boton,este debera crear el socket y enviar los datos a traves de el al servidor.

4-para crear un socket usamos la clase Socket la cual tiene sobrecarga de constructores,usamos el constructor que pide por parametro un puerto y la direccion de red,porque vamos a conectarlo a un servidor.Tener en cuenta que esta clase Socket lanza una exception de tipo IOException.

PASOS PARA EL SOCKET:

5- importar paquete java.net

6- en actionPerformed creamos un objeto de tipo Socket pasandole la direccion de red y el puerto.Como estamos trabajando en local,la direccion ip sera la de mi pc,la veo con un ipconfig en el cmd(segun el pc donde este trabajando).El puerto que pide debe ser uno que no se este usando,por ejemplo el 80 lo usa el navegador,etc,entonces tomamos un puerto por ejemplo 9999,todo esto dentro del try-catch.

7- ahora debemos crear un flujo de datos para poder transladar la informacion del cliente hasta el servidor a traves del socket.



*/

package julianSockets;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {

        MarcoCliente miMarco = new MarcoCliente();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// marco
class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(300, 300, 250, 350);
        LaminaCliente miLamina = new LaminaCliente();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaCliente extends JPanel {

    private JTextField campo;
    private JButton miBoton;

    public LaminaCliente() {

        JLabel texto = new JLabel("CLIENTE");
        add(texto);

        campo = new JTextField(20);
        add(campo);

        // creamos boton y la instancia del evento y la pasamos al boton
        miBoton = new JButton("Enviar");
        EnviaTexto miEvento = new EnviaTexto();
        miBoton.addActionListener(miEvento);

        add(miBoton);
    }

    // clase interna para evento del boton
    private class EnviaTexto implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // System.out.println(campo.getText());

            // SOCKET
            try {
                Socket miSocket = new Socket("192.168.0.3", 9999);
            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println(e1.getMessage());
            }
        }

    }
}