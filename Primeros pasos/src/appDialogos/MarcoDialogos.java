package appDialogos;

import javax.swing.*;
import java.awt.*;

// frame
class MarcoDialogos extends JFrame {

    public MarcoDialogos() {
        setTitle("Prueba de diálogos");
        setBounds(300, 250, 600, 450);

        // lamina con grid layout de 2 x 3
        JPanel laminaGrid = new JPanel();
        laminaGrid.setLayout(new GridLayout(2, 3));

    }
}
