package src.controlador;

import java.sql.*;

public class Conexion {

    private Connection miConexion = null;

    public Conexion() {

    }

    // metodo que hace la conexion
    public Connection dameConexion() {
        try {
            // 1- conexion a la bd
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No conecta la BD");
            e.printStackTrace();
        }

        return miConexion;
    }
}
