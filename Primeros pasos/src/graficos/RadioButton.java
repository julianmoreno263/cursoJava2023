/*(v93) vamos a ver como crear radio buttons en java,para esto utilizamos la clase JRadioButton, con esta clase creamos botones de tipo radio,como la diferencia entre los radio y los check es que los radio solo se puede seleccionar uno a la vez, debemos agruparlos para darles esta funcionalidad,esto lo hacemos con la clase ButtonGroup 

1- creo un grupo con BotoonGroup
2- creo los botones con JRadioButton y puedo usar el constructor que permite pasarle un string para identificar el boton y un boolean para establecer si ese boton esta seleccionado o no por defecto.
3- agrupo los botones en el grupo que cree de uno en uno.
4- por ultimo se agregan los botones a la lamina de  uno en uno, no se agrega el grupo,se agregan los botones.

Puedo hacer varios grupos si lo necesito.



*/

package graficos;

import javax.swing.*;

public class RadioButton {
    public static void main(String[] args) {

        MarcoRadio miMarco = new MarcoRadio();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoRadio extends JFrame {

    public MarcoRadio() {

        setTitle("Radio Buttons");
        setBounds(300, 250, 500, 350);

        LaminaButton miLamina = new LaminaButton();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaButton extends JPanel {

    public LaminaButton() {

        ButtonGroup miGrupo = new ButtonGroup();
        ButtonGroup miGrupo1 = new ButtonGroup();

        JRadioButton boton1 = new JRadioButton("Azul", false);
        JRadioButton boton2 = new JRadioButton("Rojo", true);
        JRadioButton boton3 = new JRadioButton("Verde", false);
        JRadioButton boton4 = new JRadioButton("Masculino", false);
        JRadioButton boton5 = new JRadioButton("Femenino", false);

        miGrupo.add(boton1);
        miGrupo.add(boton2);
        miGrupo.add(boton3);
        miGrupo1.add(boton4);
        miGrupo1.add(boton5);

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);

    }
}