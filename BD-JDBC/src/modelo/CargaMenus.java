package src.modelo;

import java.sql.*;

public class CargaMenus {

    // creo objeto de tipo Conexion
    public Conexion miConexion;
    public ResultSet rs, rs2;

    // constructor
    public CargaMenus() {

        // creo una conexion
        miConexion = new Conexion();

    }

    // metodo que tendra la consulta para cargar los items en el comboBox de
    // secciones y de paises
    public String ejecutaConsultas() {

        Productos miProducto = null;

        // establezco conexion usando el metodo dameConexion() del controlador,aqui me
        // conecto a la bd
        Connection accesoBD = miConexion.dameConexion();

        try {

            // creo objeto statement
            Statement secciones = ((Connection) accesoBD).createStatement();
            Statement paises = ((Connection) accesoBD).createStatement();

            // creo consulta sql guardandola en el resultset correspondiente
            rs = secciones.executeQuery("select distinctrow seccion from productos ");
            rs2 = paises.executeQuery("select distinctrow paisdeorigen from productos ");

            miProducto = new Productos();
            miProducto.setSeccion(rs.getString(1));
            miProducto.setpOrigen(rs2.getString(1));

            rs.close();
            rs2.close();

            // cierro la conexion
            accesoBD.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return miProducto.getSeccion();
    }

}
