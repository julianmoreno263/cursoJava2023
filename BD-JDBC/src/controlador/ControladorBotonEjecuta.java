package src.controlador;

import src.modelo.*;
import src.vista.*;

import java.awt.event.*;

public class ControladorBotonEjecuta implements ActionListener {

    private EjecutaConsultas obj = new EjecutaConsultas();
    private MarcoAplicacion2 elMarco;

    // constructor
    public ControladorBotonEjecuta(MarcoAplicacion2 elMarco) {

        this.elMarco = elMarco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // almaceno lo que el usuario escoja
        String seleccionSeccion = (String) elMarco.secciones.getSelectedItem();
        String seleccionPais = (String) elMarco.paises.getSelectedItem();

        // escribo lo que las consultas arrojen en el area de texto del amrco
        elMarco.resultado.append(obj.filtraBD(seleccionSeccion, seleccionPais));

        // salto de linea en el area de texto para que muestre los resultados uno debajo
        // del otro si damos click en el boton varias veces
        elMarco.resultado.append("\n");

    }

}
