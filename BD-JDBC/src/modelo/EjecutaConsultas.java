package src.modelo;

import java.sql.*;

public class EjecutaConsultas {

    private String pruebas;

    // metodo que ejecuta las consultas a la bd
    public String filtraBD(String seccion, String pais) {

        pruebas = "";

        // evaluo las tres posibilidades que tiene el usuario
        if (!seccion.equals("Sección") && pais.equals("País")) {

            pruebas = "Escogiste sección!";

        } else if (seccion.equals("Sección") && !pais.equals("País")) {

            pruebas = "Escogiste país!";

        } else {

            pruebas = "Escogiste sección y país!";

        }

        return pruebas;

    }
}
