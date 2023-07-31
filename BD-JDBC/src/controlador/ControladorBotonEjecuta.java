package src.controlador;

import src.modelo.*;
import src.vista.*;

import java.awt.event.*;
import java.sql.*;

public class ControladorBotonEjecuta implements ActionListener {

    private EjecutaConsultas obj = new EjecutaConsultas();
    private MarcoAplicacion2 elMarco;
    private ResultSet resultadoConsulta;

    // constructor
    public ControladorBotonEjecuta(MarcoAplicacion2 elMarco) {

        this.elMarco = elMarco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // almaceno lo que el usuario escoja
        String seleccionSeccion = (String) elMarco.secciones.getSelectedItem();
        String seleccionPais = (String) elMarco.paises.getSelectedItem();

        resultadoConsulta = obj.filtraBD(seleccionSeccion, seleccionPais);

        try {

            // con esto reseteamos el area de texto cada vez que saque nuevos resultados
            elMarco.resultado.setText("");

            while (resultadoConsulta.next()) {

                elMarco.resultado.append(resultadoConsulta.getString(1));
                elMarco.resultado.append(", ");

                elMarco.resultado.append(resultadoConsulta.getString(2));
                elMarco.resultado.append(", ");

                elMarco.resultado.append(resultadoConsulta.getString(3));
                elMarco.resultado.append(", ");

                elMarco.resultado.append(resultadoConsulta.getString(4));
                elMarco.resultado.append("\n");
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

}
