/*(v205) vamos a ver como hacer consultas preparadas en jdbc,estas consultas son muy utiles porque permiten:

1- pasar parametros a las consultas sql

2- evitan ataques de inyeccion sql

3- tienen un mejor rendimiento(son precompiladas y reutilizables),en si al hacer una consulta preparada la puedo ejecutar varias veces con diferentes parametros para ver diferentes datos d emi bd,por esto se dice que tienen un mejor rendimiento,porque una consulta se puede utilizar varias veces para varias cosas solo cambiando los parametros.

La sinatxis de una consulta preparada es:

                    "select from productos where seccion=?"

El valor del parametro se sustituye por un simbolo ?,esto permite reutilizarla solo cambiando el parametro.

Para crear una consulta preparada en jdbc usamos el metodo prepareStatement de la interfaz Connection, este metodo es sobrecargado,uno de estos metodos solo pide la consulta sql.

Este metodo nos devuelve un objeto de la interfaz PreparedStatement, esta interfaz tiene todos sus metodos parecidos con el nombre iniciando en set,y no devuelven nada,void,todos estos metodos reciben 2 argumentos,el primero siempre sera de tipo int y el segundo puede ser de otro tipo.Estos metodos lo que hacen es establecer el parametro para la consulta.

1- para crear el objeto de tipo statement:

        PreparedStatement sql=conexion.preparedStatement( "select from productos where seccion=?");

2- ya con este objeto creado,creamos los parametros que iran en los ? de la consulta con los metodos set de esta interfaz PreparedStatement:

                        sql.setString(1,'Deportes');

3- despues con un resultset ejecutamos la consulta con el metodo executeQuery() y la recorremos con un bucle.

                        ResulSet rs= sql.executeQuery();

Lo bueno de este tipo de consultas preparadas es que la puedo reutilizar solo cambiando los parametros y asi no tengo necesidad de crear varias consultas.
                        

*/

package src.conectaDB;

import java.sql.*;

public class ConsultaPreparada {
    public static void main(String[] args) {

        try {

            // 1- crear conexion
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // 2- preparara la consulta
            PreparedStatement sql = miConexion.prepareStatement(
                    "select nombrearticulo,seccion,paisdeorigen from productos where seccion=? and paisdeorigen=?");

            // 3-establecer parametros de consulta con los metodos set de la interfaz
            // PreparedStatement
            sql.setString(1, "Deporte");
            sql.setString(2, "Usa");

            // 4- ejecutar y recorrer el resultset
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getString("NOMBREARTICULO") + " " + rs.getString("SECCION")
                        + " " + rs.getString("PAISDEORIGEN"));
            }

            // 5- cerramos el resultset para liberar memoria
            rs.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No conecta la BD");
            e.printStackTrace();
        }
    }
}
