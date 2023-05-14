/*(v94) vamos a hacer un ejercicio con radio button,  vamos a poner un texto en la parte central del marco y en la parte sur ponemos varios radio button que me permitan cambiar el tamaño de ese texto.

Para saber en el metodo actionPerformed cual boton desencadeno el evento,podemos utilizar el metodo getSource() que se aplica al objeto evento e.




 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButton2 {
    public static void main(String[] args) {

        MarcoRadio2 miMarco = new MarcoRadio2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// marco
class MarcoRadio2 extends JFrame {

    public MarcoRadio2() {

        setTitle("Radio Buttons 2");
        setBounds(300, 250, 500, 350);

        LaminaButton2 miLamina = new LaminaButton2();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaButton2 extends JPanel {

    private JLabel texto;
    private JRadioButton boton1, boton2, boton3, boton4;

    public LaminaButton2() {

        // establezco layout
        setLayout(new BorderLayout());

        // creo texto
        texto = new JLabel("En un lugar de la mancha de cuyo nombre...");
        add(texto, BorderLayout.CENTER);

        // creo grupo y botones
        ButtonGroup miGrupo = new ButtonGroup();
        boton1 = new JRadioButton("Pequeño", false);
        boton2 = new JRadioButton("Mediano", true);
        boton3 = new JRadioButton("Grande", false);
        boton4 = new JRadioButton("Muy Grande", false);

        // agrego botones al grupo
        miGrupo.add(boton1);
        miGrupo.add(boton2);
        miGrupo.add(boton3);
        miGrupo.add(boton4);

        // creo el objeto oyente y pongo los botones a la escucha del evento
        EventoRadio miEvento = new EventoRadio();
        boton1.addActionListener(miEvento);
        boton2.addActionListener(miEvento);
        boton3.addActionListener(miEvento);
        boton4.addActionListener(miEvento);

        // creo lamina para poner alli los botones
        JPanel laminaRadio = new JPanel();
        laminaRadio.add(boton1);
        laminaRadio.add(boton2);
        laminaRadio.add(boton3);
        laminaRadio.add(boton4);

        // agrego segunda lamian a la principal en la zona sur
        add(laminaRadio, BorderLayout.SOUTH);

    }

    // clase interna oyente
    private class EventoRadio implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // aqui evaluamos que boton es el origen del evento
            if (e.getSource() == boton1) {
                texto.setFont(new Font("Serif", Font.PLAIN, 10));

            } else if (e.getSource() == boton2) {
                texto.setFont(new Font("Serif", Font.PLAIN, 14));

            } else if (e.getSource() == boton3) {
                texto.setFont(new Font("Serif", Font.PLAIN, 20));

            } else if (e.getSource() == boton4) {
                texto.setFont(new Font("Serif", Font.PLAIN, 26));

            }
        }

    }
}