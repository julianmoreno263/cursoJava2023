package julianSockets;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

import julianSockets.LaminaCliente.PaqueteEnvio;

public class Servidor {

    public static void main(String[] args) {

        MarcoServidor miMarco = new MarcoServidor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoServidor extends JFrame implements Runnable {

    private JTextArea areaTexto;

    public MarcoServidor() {

        setBounds(800, 300, 300, 350);
        setTitle("SERVIDOR");

        // lamina
        JPanel miLamina = new JPanel();
        miLamina.setLayout(new BorderLayout());
        areaTexto = new JTextArea();
        miLamina.add(areaTexto, BorderLayout.CENTER);
        add(miLamina);

        setVisible(true);

        // creamos el hilo
        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    @Override
    public void run() {
        // System.out.println("Estoy a la escucha");

        try {
            // ponemos el servidor a la escucha
            ServerSocket servidor = new ServerSocket(9999);

            // variables para capturar los datos del cliente
            String nick, ip, mensaje;

            // ArrayList que alamcena las ips de los clientes que se vayan conectando
            ArrayList<String> listaIp = new ArrayList<>();

            // objeto para almacenar estos datos
            PaqueteEnvio paqueteRecibido;

            while (true) {
                Socket miSocket = servidor.accept();

                // flujo de datos de entrada para recibir el objeto
                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());

                // almacenamos en el objeto lo que le llega por el flujo de datos
                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();

                // almacenamos en cada variable los datos que llegan del objeto
                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();

                if (!mensaje.equals("online")) {

                    // escribimos en el area de texto lo que viene del cliente y cerramos el socket
                    areaTexto.append("\n" + "De " + nick + ": " + mensaje + " para " + ip);

                    // segundo socket para reenvio de informacion
                    Socket envioDestino = new Socket(ip, 9090);

                    // creamos flujo para reenvio de informacion
                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(envioDestino.getOutputStream());

                    // metemos el paquete de datos dentro de este flujo para el reenvio y cerramos
                    // este flujo de datos y el socket
                    paqueteReenvio.writeObject(paqueteRecibido);
                    paqueteReenvio.close();
                    envioDestino.close();

                    // creamos flujo de entrada y alamcenamos el texto que llega
                    // DataInputStream flujoEntrada = new
                    // DataInputStream(miSocket.getInputStream());
                    // String mensajeTexto = flujoEntrada.readUTF();

                    // // escribimos en el area de texto lo que viene del cliente y cerramos el
                    // socket
                    // areaTexto.append("\n" + mensajeTexto);
                    miSocket.close();

                } else {

                    // --------- DETECTA ONLINE --------------------------

                    // aqui guardamos la ip como tipo InetAdress y despues con getHostAdress le
                    // damos formato de tipo string
                    InetAddress localizacion = miSocket.getInetAddress();
                    String ipRemota = localizacion.getHostAddress();

                    // prueba para ver si detecta las ip
                    System.out.println("Online " + ipRemota);

                    // aqui se va llenando el ArrayList con las ips
                    listaIp.add(ipRemota);

                    // metemos ese ArrayList con las ips en el paquete a enviar a los clientes
                    paqueteRecibido.setIps(listaIp);

                    // foreach para recorrer el arrayList y enviar el paquete a cada cliente con los
                    // datos de las ips conectadas
                    for (String z : listaIp) {

                        System.out.println("Array: " + z);

                        // segundo socket para reenvio de informacion
                        Socket envioDestino = new Socket(z, 9090);

                        // creamos flujo para reenvio de informacion
                        ObjectOutputStream paqueteReenvio = new ObjectOutputStream(envioDestino.getOutputStream());

                        // metemos el paquete de datos dentro de este flujo para el reenvio y cerramos
                        // este flujo de datos y el socket
                        paqueteReenvio.writeObject(paqueteRecibido);
                        paqueteReenvio.close();
                        envioDestino.close();
                        miSocket.close();
                    }

                    // ----------------------------------------
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
