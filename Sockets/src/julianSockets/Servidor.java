package julianSockets;

import java.awt.*;
import javax.swing.*;

public class Servidor {

    public static void main(String[] args) {

        MarcoServidor miMarco = new MarcoServidor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoServidor extends JFrame {

    public MarcoServidor() {

        setBounds(800, 300, 250, 350);
        setTitle("SERVIDOR");
        LaminaServidor miLamina = new LaminaServidor();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaServidor extends JPanel {

    private JTextArea areaTexto;

    public LaminaServidor() {

        setLayout(new BorderLayout());
        areaTexto = new JTextArea();
        add(areaTexto, BorderLayout.CENTER);

    }
}