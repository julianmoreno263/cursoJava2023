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

6- en actionPerformed creamos un objeto de tipo Socket pasandole la direccion de red y el puerto.Como estamos trabajando en local,la direccion ip sera la de mi pc,la veo con un ipconfig en el cmd(segun el pc donde este trabajando, mi ip es la misma del pc de carlos).El puerto que pide debe ser uno que no se este usando,por ejemplo el 80 lo usa el navegador,etc,entonces tomamos un puerto por ejemplo 9999,todo esto dentro del try-catch.

7-(v191) ahora debemos crear un flujo de datos para poder transladar la informacion del cliente hasta el servidor a traves del socket.Despues de crear el socket creo el flujo de datos de salida con la clase DataOutputStream, este clase tiene un constructor que pide un objeto de tipo OutputStream, la clase Socket tiene un metodo getOutputStream que devuelve un objeto OutputStream en definitiva lo que se quiere indicar al flujo de datos por donde debe circular, osea indicarle que debe pasar por el socket que hemos creado(ver API).

8- ahora le indicamos al flujo de salida que es lo que va a viajar por el, osea el texto que se escribe en el campo detexto del cliente.

9-por ultimo se cierra el flujo de datos con close()

10-listo, ahora debemos decirle al servidor que abra el puerto 9999 por donde recibira ese flujo de datos. El servidor tiene que hacer dos tareas,recibir el texto del cliente y en segundo plano permanecer a la escucha teniendo ese puerto abierto.Para hacer que el servidor este escuchando en segundo plano debemos crearle un hilo con la interfaz Runnable y implementando su metodo run.Vamos ala clase del marco en el servidor e implementamos la interfaz, el codigo que se encargara de estar a la escucha sera el codigo del metodo run.

11- ya implementada la interfaz y su metodo run creamos el hilo en el constructor del marco,y para probar que funciona podemos en run() poner un mensaje y cuando ejecutemos el servidor saldra ese mensaje en consola.

12- listo,ahora para poner ese hilo a la escucha, debemos usar la clase ServerSocket dentro de run() la cual tiene un constructor que pide el puerto y ademas tiene un metodo accept() que es el que pone en escucha a la app, este metodo le dice que acepte las conexiones que vienen del exterior.Debemos importar el paquete java.net para usar esta clase, y ademas se debe usar try-catch. 

13- listo,ya esta abierto el puerto de entrada, ahora debemos crear el flujo de datos de entrada para que pueda recoger los datos que vienen del flujo de salida del cliente,esto lo hacemos utilizando la clase DataInputStream, debemos importar el paquete java.io.Despues de creado el flujo de entrada debemos almacenar en una variable el texto que viene desde el cliente,lo hacemos con el metodo readUTF().

14- por ultimo,debemos decirle al area de texto del servidor que vaya escribiendo el texto que nos llego,lo hacemos utilizando el metodo appen(), y al final cerramos el socket con el metodo close().Listo!!, si pruebo la aplicacion,lo qu escribo en el cliente debe verse en el servidor.Ahora, si intento escribir nuevamente y enviar otro mensaje no hace nada porque le dijimos al final al servidor que cerrarar el socket,para que nos deje seguir enviando texto debemos poner el codigo que esta dentro del try en un bucle while para que una vez cerrado el socket vuelva y habra la conexion desde el metodo accept() y asi sucesivamente.Este bucle no incide en el funcionamiento de la app del servidor porque se esta ejecutando en segundo plano en un hilo,osea,si la ventana del servidor tuviera menus o campos de texto,etc, estos se pueden utilizar sin problema porque la funcionalidad del socket esta en segundo plano en un hilo.De esta forma ya recibe varios mensajes porque se cierra el socket pero despues vuelve a abrir la conexion.Si queremos podemos poner estas apps en un jar ejecutable para que sea independiente del vsc.



*/

package julianSockets;

import javax.swing.*;
import java.awt.event.*;
import java.io.DataOutputStream;
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
                // creamos el socket
                Socket miSocket = new Socket("192.168.0.3", 9999);

                // creamos el flujo de datos indicando que debe ir por el socket
                DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());

                // indicamos que el texto del cliente va a viajar por este flujo
                flujoSalida.writeUTF(campo.getText());

                // cerramos el flujo
                flujoSalida.close();
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