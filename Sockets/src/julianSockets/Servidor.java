package julianSockets;

import java.awt.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

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

        setBounds(800, 300, 250, 350);
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

            while (true) {
                Socket miSocket = servidor.accept();

                // creamos flujo de entrada y alamcenamos el texto que llega
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensajeTexto = flujoEntrada.readUTF();

                // escribimos en el area de texto lo que viene del cliente y cerramos el socket
                areaTexto.append("\n" + mensajeTexto);
                miSocket.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
