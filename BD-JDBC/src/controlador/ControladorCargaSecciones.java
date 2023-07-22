package src.controlador;

import src.vista.*;
import src.modelo.*;

import java.awt.event.*;

public class ControladorCargaSecciones extends WindowAdapter {

    CargaSecciones obj = new CargaSecciones();
    private MarcoAplicacion2 elMarco;

    // constructor
    public ControladorCargaSecciones(MarcoAplicacion2 elMarco) {

        this.elMarco = elMarco;
    }

    public void windowOpened(WindowEvent e) {

        // llamo al metodo del modelo que ejecuta la consulta por medio de este objeto
        obj.ejecutaConsultas();

        // recorro el resulset que arroja este metodo y envio al comboBox los datos
        try {

            while (obj.rs.next()) {

                // aqui meto los datos del resulset en el comboBox de secciones
                elMarco.secciones.addItem(obj.rs.getString("seccion"));
            }

        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();

        }
    }
}
