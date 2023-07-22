package src.modelo;

import java.sql.*;
import src.controlador.*;

public class CargaSecciones {

    // creo objeto de tipo Conexion
    Conexion miConexion;
    public ResultSet rs;

    // constructor
    public CargaSecciones() {

        // creo una conexion
        miConexion = new Conexion();

    }

    // metodo que tendra la consulta para cargar las secciones en el comboBox de
    // secciones
    public String ejecutaConsultas() {

        // creo objeto de tipo Producto
        Productos miProducto = null;

        // establezco conexion usando el metodo dameConexion() del controlador,aqui me
        // conecto a la bd
        Connection accesoBD = miConexion.dameConexion();

        try {

            // creo objeto statement
            Statement miStatement = ((Connection) accesoBD).createStatement();

            // creo consulta sql guardandola en el resultset y lo recorremos
            rs = miStatement.executeQuery("select distinctrow seccion from productos ");

            while (rs.next()) {

                // a cada vuelta de bucle se crea un objeto miProducto y almacena una seccion y
                // la retorna
                miProducto = new Productos();

                miProducto.setSeccion(rs.getString("seccion"));

                return miProducto.getSeccion();
            }

            rs.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        // este metodo al final siempre retorna la seccion que haya en el objeto
        // miProducto,ya sea que entre en el try o en el catch
        return miProducto.getSeccion();
    }

}
