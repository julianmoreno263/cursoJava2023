/*(v121) veremos como crear ventanas emergentes, hay tres grandes grupos de ventanas:
 1- cuadros de dialogo- como las creadas con JOptionPane,dan un mensaje o permiten introducir informacion

 2- seleccion de archivos, como la ventana en windows cuando uno adjunta un archivo desde un correo y sale la ventana de navegacion de archivos para buscar el archivo a adjuntar, utilizamos la clase JFileChooser.

 3- selector de color,utilizamos la clase JColorChoose.

 Haremos un ejemplo con JOptionPane.

 */

package graficos;

import javax.swing.*;
import java.awt.event.*;

public class VentanasEmergentes {
    public static void main(String[] args) {

        MarcoVentanas miMarco = new MarcoVentanas();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// frame
class MarcoVentanas extends JFrame {

    public MarcoVentanas() {
        setTitle("Ventanas Emergentes");
        setBounds(300, 250, 550, 350);

        LaminaVentanas miLamina = new LaminaVentanas();
        add(miLamina);

        setVisible(true);
    }

}

// lamina
class LaminaVentanas extends JPanel {

    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;

    public LaminaVentanas() {

        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        boton3 = new JButton("Boton 3");
        boton4 = new JButton("Boton 4");

        boton1.addActionListener(new AccionBotones());
        boton2.addActionListener(new AccionBotones());
        boton3.addActionListener(new AccionBotones());
        boton4.addActionListener(new AccionBotones());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);

    }

    private class AccionBotones implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == boton1) {

                // System.out.println("Boton 1 pulsado!");

                // mensaje sencillo
                // JOptionPane.showMessageDialog(LaminaVentanas.this, "Boton 1 pulsado");

                // metodo con mas argumentos para personalizarlo,si cambio el ultimo argumento a
                // 1,2,3,etc, se cambia el icono de la ventana.
                JOptionPane.showMessageDialog(LaminaVentanas.this, "Boton 1 pulsado", "Advertencia", 0);

            } else if (e.getSource() == boton2) {

                // System.out.println("Boton 2 pulsado!");
                JOptionPane.showInputDialog(LaminaVentanas.this, "Introduce el nombre");

            } else if (e.getSource() == boton3) {

                // System.out.println("Boton 3 pulsado!");
                JOptionPane.showConfirmDialog(LaminaVentanas.this, "Deseas salir del programa?");

            } else if (e.getSource() == boton4) {

                // System.out.println("Boton 4 pulsado!");
                JOptionPane.showOptionDialog(LaminaVentanas.this, "Elige", "Opciones", 1, 1, null, null, null);

            }

        }

    }
}