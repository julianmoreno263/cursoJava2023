package appDialogos;

import javax.swing.*;
import java.awt.*;

// lamina
class LaminaDialogos extends JPanel {

    public LaminaDialogos() {

        // layout lamina principal
        setLayout(new GridLayout(3, 3));

        // cajas tipo Box
        Box cajaTipo = Box.createHorizontalBox();
        cajaTipo.setBorder(BorderFactory.createLineBorder(Color.black));
        Box cajaTipoMensaje = Box.createHorizontalBox();
        cajaTipoMensaje.setBorder(BorderFactory.createLineBorder(Color.black));
        Box cajaMensaje = Box.createHorizontalBox();
        cajaMensaje.setBorder(BorderFactory.createLineBorder(Color.black));
        Box cajaConfirmar = Box.createHorizontalBox();
        cajaConfirmar.setBorder(BorderFactory.createLineBorder(Color.black));
        Box cajaOpcion = Box.createHorizontalBox();
        cajaOpcion.setBorder(BorderFactory.createLineBorder(Color.black));
        Box cajaEntrada = Box.createHorizontalBox();
        cajaEntrada.setBorder(BorderFactory.createLineBorder(Color.black));

        add(cajaTipo);
        add(cajaTipoMensaje);
        add(cajaMensaje);
        add(cajaConfirmar);
        add(cajaOpcion);
        add(cajaEntrada);

        // segunda lamina con su boton
        JPanel laminaBoton = new JPanel();
        JButton boton = new JButton("Mostrar");
        laminaBoton.add(boton);
        add(laminaBoton);

    }
}
