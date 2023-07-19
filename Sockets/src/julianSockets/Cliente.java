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

---------------------------------------------------------
(v192) vamos a comenzar a hacer nuestro chat, funcionara asi: crearemos por lo menos 2 clientes para que estos se comuniquen entre ellos a traves del servidor, para simular dos clientes usaremos virtualbox para crear dos maquinas virtuales e instalar los clientes alli.

1- lo primero es crear en nuestro cliente un area de texto para que tambien se pueda reflejar alli la conversacion o todo lo que reciba.

2- crearemos tambien encima del area de texto dos cuadros de texto,uno para introducir nuestro nombre y otro para ingresar la direccion ip del otro cliente con el que vamos a chatear para asi identificarse mejor.

3- como debemos enviar tres datos,el nick,la ip de destino y el mensaje,crearemos un objeto que tenga esos datos y el cliente receptor despues lo lea,para esto creamos una clase y en esta clase creamos los metodos setters y getters para manipular esos datos.

4- ahora en la clase de la lamina despues de la linea donde creamos el socket creamos el codigo para poder enviar estos tres datos por los correspondientes campos,las lineas donde creamos el flujo de salida y lo usamos ya no las necesitamos porque esa clase que usamos para crear el flujo de salida es DataOutputStream y sirve para un flujo de datos de texto,y como vamos a neviar un objeto debemos trabajar con ObjectOutputStream.

5-(v193) creamos el flujo de datos para enviar el objeto con ObjectOutputStream.Despues,como vamos a enviar un objeto por la red,debemos serializarlo,osea convertirlo en una serie de bytes para que pueda ir por la red,esto lo hacemos implementando la interfaz Serializable en la clase que crea el objeto,osea la clase PaqueteEnvio.

6- listo, ahora debemos ir al servidor y crear tres variables para almacenar la informacion que le llega de estos 3 datos, lo hacemos en el metodo run despues de crear el ServerSocket.

7- despues creamos un objeto del mismo tipo del que envia el cliente para que se almacenen alli esos 3 datos,osea de la clase PaqueteEnvio.

8- ahora en el while creo el flujo de datos d eentrada para recibir ese objeto,se hace con la clase ObjectInputStream.

9- ahora en el objeto que creamos de tipo PaqueteEnvio almacenamos lo que traiga este flujo de datos de entrada que es de tipo ObjectInputStream,pero como no son del mismo tipo debemos castear para que se pueda almacenar el flujo de datos en el objeto, con vsc lo hacemos automaticamente,ademas esto lanza una exception,entonces como esto ya esta dentro de un try-catch,adicionamos esta nueva exception en el catch que tenemos,dejamos que vsc lo haga por medio de la opcion que aparece al poner el cursor en el error "Add exception to existing catch clause".

10-ahora, almacenamos en cada variable de nick,ip,mensaje,los datos de ese objeto que recibio el servidor utilizando los getters correspondientes, y luego con append() envio esos datos al area de texto para que se puedan ver y cierro el socket. Hasta aqui ya tenemos la mitad del chat,porque ya se comunica del primer cliente al servidor y el servidor captura el objeto y lle los datos que tiene y los muestra,falta que el servidor envie los datos hacia un segundo cliente y ese segundo cliente los reciba,asi tendremos la comunicacion completa entre clientes a traves del servidor.

11-(v194) ahora vamos a hacer que el servidor sea capaz de reenviar la informacion que capturo del objeto del cliente emisor al cliente destino.Entonces en el while antes de cerrar el socket creamos un segundo socket que sera el puente de envio de los datos del servidor al cliente receptor,esto lo hacemos con la clase Socket y le pasamos la ip destino y un puerto.

12- ahora, debemos crear el flujo de datos para enviar el objeto,lo hacemos con ObjectOutputStream.

NOTA: nosotros no vamos a hacer una segunda app cliente,sino que replicamos la que ya tenemos en una maquina virtual que tendra su propia ip, osea, el cliente que ya tenemos es el que se replica en los demas pc en donde queramos que este nuestro chat y cada uno de esos pcs tiene su ip,por eso despues usaremos virtualbox para simular un computador nuevo donde instalaremos nuestro cliente chat, y el servidor es un intermediario entre esos clientes.En virtualbox crearemos dos pc y alli ponemos los clientes cada uno con su ip,y en nuestro pc,en local,estara el servidor.Los clientes los convertimos a jar ejecutables y se los pasamos a estas maquinas virtuales,el servidor lo podemos abrir con vsc como lo hemos echo o tambien se podria poner en otra maquina virtual y pasarlo como jar ejecutable.

13-metemos el paquete con los datos en el flujo de reenvio con el metodo writeObject() y cerramos este segundo socket.

14- listo, ahora volvemos nuevamente al cliente y debemos crear el codigo para que tambien el cliente sea capaz de recibir informacion,para esto hacemos lo que ya hemos echo,poner el cliente a la escucha y tener un puerto de entrada para que reciba datos.Para que este a la escucha debemos hacer lo mismo que con el servidor,crear un hilo que s eeste ejecutando en segundo plano,implementamos en la clase de la lamina la interfaz Runnable y su metodo run().Para que el cliente este a la escucha de datos que le llegen,hacemos lo mismo que en el servidor,en run() creamos un ServerSocket pasandole el puerto que tiene que estar a la escucha,si en el servidor le dijimos que enviaria datos por el puerto 9090 pues ese mismo puerto es el que el cliente tiene que estar escuchando para recibir datos.Todo dentro de un try-catch.

15- creamos un socket,creamos una variable tipo PaqueteEnvio que almacene el objeto recibido.

16-para que el cliente este permanentemente a la escucha,ponemos dentro de un bucle while el socket del cliente que creamos con el metodo accept(), asi estara aceptando las conexiones que le lleguen del servidor.Despues creamos un flujo de datos de entrada para que sea capaz de transportar el objeto que le llega con los datos.

17-alamcenamos el objeto que viene por ese flujo de entrada en la variable de tipo PaqueteEnvio,igualñ que en el servidor se debe castear y manejar la exception,vsc lo hace automaticamente con la ayuda.

18-ya por ultimo, con append() visualizamos los datos que llegaron en el objeto en el area de texto del cliente utilizando los metodos getters,pues el objeto es de tipo PaqueteRecibido y este tiene estos metodos.

19-por ultimo,en el constructor de la lamina creamos el hilo y lo corremos,para que cuando se ejecute la app cliente este hilo corra automaticamente en segundo plano.

----------------------------------------------------------
(v195) vamos aterminar la app de chat y probarla desde varios pc.

1- voy a dejar un cliente y el servidor en un mismo pc y el otro cliente lo pongo en otro computador para asi comunicarlos despues.

2- ahora creo un jar ejecutable del cliente para usarlo en el otro pc.Logico para que en esa pc el archivo jar ejecutable pueda correr debe de tener instalado el jdk.Recordar que para generar un jar ejecutable en vsc simplemente me paro en la clase main de la que quiero generar el archivo,y en la parte inferior izquierda del vsc hay tres opciones,elijo JAVA PROJECTS y con la clase seleccionada le doy a la flecha ->,alli mesale un cuadro y debo digitar el nombre de la clase y doy enter y listo,se crea el ejecutable.

3- debo saber las ips de ambos clientes porque cuando quiera enviar un chat la gui de los clientes me pide un nick y la ip a donde quiero comunicarme.Con cmd y ipconfig puedo saber la ipv4, en mi caso que uso el pc portatil de Carlos tiene la ip 192.168.0.9, y en este otro pc donde esta el cliente y el servidor la ip es 192.168.0.3.

4- listo, si probamos la aplicacion colocando las ips correctamente en cada cliente,se comunican entre si con el servidor como intermediario.

5- ahora, para corregir, solo se ve en el campo de chat de cada cliente lo que ese cliente recibe,en un chat se ve toda la conversacion,osea lo que el cliente escribe y lo que recibe,entonces para que los clientes puedan tambien ver en el campo de chat lo que escriben creamos esta linea en el actionPerformed del cliente:

                    campoChat.append("\n" + campo.getText())

esto en si, lo ponemos al principio de actionPerformed() e indica que le agrege al campo de chat lo que el usuario va escribiendo en el cuadro de texto.

NOTA: COMO HICIMOS UNA MODIFICACION EN EL PROGRAMA DEBEMOS GENERAR NUEVAMENTE EL JAR EJECUTABLE PARA QUE TENGA ESTA MODIFICACION.

--------------------------------------------------------------
(v196) vamos a realizar mejoras al chat.

1- vamos a hacer que al abiri el cliente,primero se abra un JOptionPane y nos pregunte el nick,y al escribirlo,abra la ventana del cliente y aparezca ese nick en una etiqueta label,asi no se podra cambiar el nick sobre la marcha,ese nick queda hay mientras chateamos.

2- en el cuadro para meter la ip es mejor tener un comboBox en donde aparezcan todas las ips que esten online en ese momento, esto se puede hacer mejor con componentes avanzados de swing como las JList,pero como no las hemos visto entonces mejor con comboBox.La idea es que cuando se abra un cliente, envie una señal al servidor y el servidor al llegarle esa señal envie la ip de ese cliente al resto de clientes,asi sabran cuales ips estan online,cada ip que vaya recibiendo el servidor y envie a los demas clientes se ira cargando en el comboBox.

3-para que el cliente envie una señal al servidor debemos crear un evento de ventana para que apenas se abra el cliente envie un paquete de datos al servidor y el servidor sepa la ip de ese cliente que le llegara en ese paquete de datos.Primero trabajaremos con el servidor para que detecte las ips de los clientes que esten abiertos,para esto usamos el metodo getInetAdress() de la clase Socket y la clase InetAdress.

getInetAdress() devuelve la ip de donde esta conectado el socket del servidor,osea la ip del cliente,este metodo devuelve un dato de tipo InetAdress y esa clase tiene un metodo getHostAdress() que devuelve la ip pero como string.

Entonces , en el metodo run del servidor en el while,creamos una variable de tipo InetAdress y con el metodo getInetAdress almacenamos alli la ip del cliente conectado,aunque no estara todavia en formato de tipo string.

En el cliente para crear el evento de ventana para enviar la señal al servidor debemos crear una clase que gestione ese evento.Despues de crear la clase del evento la instanciamos en el constructor del marco porque apenas se abra el marco en el navegador se debe ejecutar el evento,osea ejecutamos la clase del evento,esto lo hacemos instanciando esa clase del evento dentro del metodo addWindowListener()

----------------------------------------------------
(v198) para que las ips se cargen dinamicamente en el desplegable de cada cliente a medida que se vayan conectando,creamos un ArrayList en el servidor donde vamos almacenando las ips detectadas por el servidor y despues este ArrayList lo iran leyendo los clientes y lo cargaran en cada uno de sus desplegables.

-----------------------------------------------------------------
(v199) hasta ahora la app chat trabaja asi: cuando abrimos un cliente este crea un paquete con el nick,la ip de destino que estara en principio vacia hasta que se cargen en el ArrayList del servidor y despues se lean,y un mensaje y a la vez este paquete lo envia al servidor.

Despues el servidor cuando le llega este paquete,detecta la ip del cliente que le envio ese paquete gracias al socket que se crea para la comunicacion entre ese cliente y el servidor,y esa ip es la que se va almacenando en el ArrayList, gracias al metodo getInetAdress de la clase Socket el servidor puede detectar las ips de los clientes.

1- debemos crear ese ArrayList porque aun no lo hemos echo,debe ser un ArrayList el que almacene las ips porque estos son dinamicos a diferencia de los arrays normales que toca pasarles un tamaño fijo,porque puede que se conecten dos o mas clientes, no sabemos cuantos se conectaran.Este ArrayList lo creamos en el metodo run del servidor pero fuera del while para que no se resetee cada vez que se conecte un cliente.Ese array se va llenando en el else con el metodo add().

2-ahora,para que el servidor envie a los clientes ese array con las ips,no vamos a hacer de nuevo un socket y otro flujo de datos con otro paquete de datos,lo que haremos es en el paquete que se construye en la clase PaqueteEnvio con los datos del cliente,ademas de esos datos hacer que tambien se cree un ArrayList con sus correspondientes getters y setters para poder manipularlo.

3- ahora,con el arrayList del servidor que tiene las ips que se van conectando,lo debo meter en el paquete que se va a enviar a los clientes desde el servidor.Este paquete ya tendra 4 datos,el nick,la ip,el mensaje y un arrayList.Entonces,como el paquete que se envia a los clientes desde el servidor es el que creamos que se llama paqueteRecibido de tipo PaqueteEnvio,con el metodo setter que acabamos de crear para el arrayList metemos en ese paquete el arrayList con la lista de ips,esto es en el servidor,en el metodo run en el else.

4- ahora luego de esta linea,creamos un foreach para recorrer ese arrayList y dentro de el ponemos el codigo que ya hemos echo donde se crea un socket,un flujo de datos y se envia el paquete a los clientes.Asi cada cliente tendra una lista actualizada de las ips que esten online en ese momento.

5- luego, aqui en el cliente se recibe ese paquete en el metodo run,entonces  con un if evaluamos si el mensaje del paquete no es "online",osea que ya estamos chateando,ponemos un mensaje en el campo de texto,si el mensaje es "online" es que el cliente se acaba de conectar entonces el mensaje que ponemos sera con la ip del cliente conectado.

6- en el else, es donde creamos el codigo para que las ips que viene del paquete se almacenen en el comboBox,asi cuando se conecta un cliente,esa ip se va viendo reflejada en el comboBox.(v200)



*/

package julianSockets;

import javax.swing.*;

import julianSockets.LaminaCliente.PaqueteEnvio;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.util.ArrayList;

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

        // creamos el evento de ventana
        addWindowListener(new EnvioOnLine());
    }
}

// lamina
class LaminaCliente extends JPanel implements Runnable {

    private JTextField campo;
    private JComboBox<String> ip;
    private JLabel nick;
    private JButton miBoton;
    private JTextArea campoChat;

    public LaminaCliente() {

        // codigo para el nick del usuario
        String nickUusario = JOptionPane.showInputDialog("Nick: ");
        JLabel nNick = new JLabel("Nick: ");
        add(nNick);
        nick = new JLabel();
        nick.setText(nickUusario);
        add(nick);

        JLabel texto = new JLabel("Online: ");
        add(texto);

        ip = new JComboBox<String>();
        ip.addItem("192.168.0.3");
        ip.addItem("192.168.0.9");

        add(ip);

        campoChat = new JTextArea(12, 20);
        add(campoChat);

        campo = new JTextField(20);
        add(campo);

        // creamos boton y la instancia del evento y la pasamos al boton
        miBoton = new JButton("Enviar");
        EnviaTexto miEvento = new EnviaTexto();
        miBoton.addActionListener(miEvento);

        add(miBoton);

        // creamos el hilo de esta clase(this)
        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    // clase interna para evento del boton
    private class EnviaTexto implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // esta linea permite que lo que escribimos se vea en el area de texto del chat
            campoChat.append("\n" + campo.getText());

            // System.out.println(campo.getText());

            // SOCKET
            try {
                // creamos el socket
                Socket miSocket = new Socket("192.168.0.3", 9999);

                // objeto con los 3 datos a enviar que llegan de los cuadros de texto
                // correspondientes
                PaqueteEnvio datos = new PaqueteEnvio();
                datos.setNick(nick.getText());

                // usamos getSelectedItem para capturar lo que hay en cada item del comboBox de
                // las ips.Como setIp pide un string como parametro usamos toString para pasar
                // esta ip a string,o lo castemaos a String.
                datos.setIp(ip.getSelectedItem().toString());
                datos.setMensaje(campo.getText());

                // flujo de datos de salida para enviar el objeto datos utilizando el socket
                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatos.writeObject(datos);
                miSocket.close();

                // creamos el flujo de datos indicando que debe ir por el socket
                // DataOutputStream flujoSalida = new
                // DataOutputStream(miSocket.getOutputStream());

                // // indicamos que el texto del cliente va a viajar por este flujo
                // flujoSalida.writeUTF(campo.getText());

                // // cerramos el flujo
                // flujoSalida.close();
            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println(e1.getMessage());
            }
        }

    }

    // clase que crea los objetos con los datos del mensaje a enviar
    static class PaqueteEnvio implements Serializable {

        private String nick, ip, mensaje;
        private ArrayList<String> ips;

        // getters y setters
        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public ArrayList<String> getIps() {
            return ips;
        }

        public void setIps(ArrayList<String> ips) {
            this.ips = ips;
        }

    }

    @Override
    public void run() {

        try {

            // ponemos el cliente a la escucha
            ServerSocket servidorCliente = new ServerSocket(9090);

            // creamos el socket y la variable que almacena el objeto recibido
            Socket cliente;
            PaqueteEnvio paqueteRecibido;

            // ponemos permanentemente al cliente a la escucha
            while (true) {

                // aceptamos las conexiones externas
                cliente = servidorCliente.accept();

                // creamos el flujo de datos de entrada
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

                // almacenamos el objeto que llega por ese flujo de datos
                paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();

                // if para evaluar si se acaba de conectar o no un cliente y dependiendo de esto
                // ponemos un mensaje en el area de texto del chat
                if (!paqueteRecibido.getMensaje().equals("online")) {

                    // visualizamos los datos en el area de texto
                    campoChat.append("\n" + "De " + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
                } else {

                    // campoChat.append("\n" + paqueteRecibido.getIps());

                    ArrayList<String> ipsMenu = new ArrayList<>();
                    ipsMenu = paqueteRecibido.getIps();

                    // con este codigo evitamos duplicidad de las ips cada vez que se conecte un
                    // cliente y se genere un nuevo ArrayList con las ips.El metodo removeAllItems()
                    // pertenece a la clase ComboBox.Asi,antes de agregar el arrayList actualizado
                    // en elfor, se borra lo que pudiera haber en el comboBox.
                    // ip.removeAllItems();

                    for (String z : ipsMenu) {

                        ip.addItem(z);
                    }
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

// clase que gestiona el evento de ventana para enviar una señal al
// servidor,hereda de la clase adaptadora WindowAdapter, recordemos que una
// clase adaptadora al implementar interfaces permite que no tengamos que
// sobreescribir todos los emtodos de la interfaz,WindowAdapter implemneta la
// interfaz WindowListener la cual tiene muchos metodos,con esta clase
// adapatadora solo usamos los que necesitamos, en este caso solo usamos el
// metodo windowOpened() para que la accion se ejecute al abrir la ventana.
class EnvioOnLine extends WindowAdapter {

    public void windowOpened(WindowEvent e) {

        try {
            // creamos un socket
            Socket miSocket = new Socket("192.168.0.3", 9999);

            // creamos el paquete donde van los datos
            PaqueteEnvio datos = new PaqueteEnvio();
            datos.setMensaje("online");

            // creamos flujo de datos y con writeObject le pasamos el objeto que ira por ese
            // flujo
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
            paqueteDatos.writeObject(datos);

            miSocket.close();

        } catch (Exception e2) {
            // TODO: handle exception
        }
    }

}