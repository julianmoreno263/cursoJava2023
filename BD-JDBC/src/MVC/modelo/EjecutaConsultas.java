package MVC.modelo;

import java.sql.*;

public class EjecutaConsultas {

    // campos para la conexion,el resulset y cada consulta preparada y la consulta
    // como tal
    private Conexion miConexion;
    private ResultSet rs;
    private PreparedStatement enviaConsulta;
    private final String sqlSeccion = "select nombrearticulo,seccion,precio,paisdeorigen from productos where seccion=?";
    private final String sqlPais = "select nombrearticulo,seccion,precio,paisdeorigen from productos where paisdeorigen=?";
    private final String sqlTodos = "select nombrearticulo,seccion,precio,paisdeorigen from productos where seccion=? AND paisdeorigen=?";

    // constructor
    public EjecutaConsultas() {
        // creo una nueva conexion
        miConexion = new Conexion();
    }

    // metodo que ejecuta las consultas a la bd
    public ResultSet filtraBD(String seccion, String pais) {

        // aqui usamos la conexion
        Connection conecta = miConexion.dameConexion();

        // iniciamos el objeto resultset en null
        rs = null;

        try {

            // evaluo las tres posibilidades que tiene el usuario
            if (!seccion.equals("Sección") && pais.equals("País")) {

                // aqui preparamos la consulta cuando el usuario escoge una seccion
                enviaConsulta = conecta.prepareStatement(sqlSeccion);

                // aqui establecemos en el parametro ? de la consulta sql la seccion que se pasa
                // por parametro a este metodo,este parametro seccion es la seccion que el
                // usuario escoja
                enviaConsulta.setString(1, seccion);

                // ejecutamos la consulta y almacenamos los resultados en el resultset
                rs = enviaConsulta.executeQuery();

            } else if (seccion.equals("Sección") && !pais.equals("País")) {

                enviaConsulta = conecta.prepareStatement(sqlPais);
                enviaConsulta.setString(1, pais);
                rs = enviaConsulta.executeQuery();

            } else {

                enviaConsulta = conecta.prepareStatement(sqlTodos);
                enviaConsulta.setString(1, seccion);
                enviaConsulta.setString(2, pais);

                rs = enviaConsulta.executeQuery();

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return rs;

    }
}
