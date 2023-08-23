/*(v222) Metadatos son la informacion de la bd, los datos son la informacion que guardamos en la bd.

Hay 3 tipos de metadatos:

1- relativos,son los metadatos de la información de la bd,como la versión,gestor de la bd,driver y la versión del driver,etc.

2-relativos a un conjunto de resultados,los que se almacenan en un resultset, como los nombres de las tablas,los campos de las tablas,los tipos de los campos,etc.

3- relativos a los parámetros de una sentencia preparada.

Los metadatos están pensados para cuando se crean aplicaciones genéricas,osea aplicaciones que se puedan conectar a cualquier gestor de bd.

Para obtener los metadatos con java debemos utilizar la interfaz Connection y su método getMetaData() y este método devuelve un objeto de tipo DatabaseMetaData, cuando conectamos con un gestor de bd toda la información de ese gestor se almacena en un objeto de este tipo.

DatabaseMetaData es una interfaz y tiene varios métodos que pueden capturar la información de la bd,como la versión,las tablas,el driver,etc.

Crearemos un ejemplo de como ver estos metadatos, creamos un nuevo paquete en nuestro proyecto para este ejercicio.

vamos a crear un metodo static que muestre la informacion de la bd,osea los metadatos, debe ser static porque como vamos a llamar a este metodo en el main y el main es un metodo static por eso debe ser static,recordar que no podemos hacer una llamada dentro de un metodo static a otro metodo que no lo sea.

el metodo getMetadata() pertenece a la interfaz Connection por lo que debemos utilizar nuestra conexion para usar este metodo.

------------------------------------------------------------
(v223) vamos  ahora en este mismo ejercicio a crear otro metodo que nos devuelva los metadatos de las propias tablas, esta informacion de metadatos sera por ejemplo el nombre de los campos de la tabla,etc.

si en el parametro catalog del metodo getTables le especifico el nombre de la bd de la que quiero obtener la informacion de las tablas me aparece las tablas de esa bd,porque si lo dejo null me aparece mucha informacion junto a las tablas de la bd,por eso esos parametros ayudan a afinar la busqueda,tambien puedo utilizar comodines para las busquedas,por ejemplo en el 3 parametro que es el tableNamePattern puedo usar por ejemplo el comodin % para buscar tablas que comienzen por la letra especificada,por ejemplo: "p%", me traera las tablas que comiencen por la letra p.


*/

package metaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoMetaDatos {
    public static void main(String[] args) {

        // mostrarInfoBD();
        mostrarInfoTabla();
    }

    // metodo static para traer la informacion de la bd
    static void mostrarInfoBD() {

        Connection miConexion = null;

        try {

            // creamos la conexion
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // obtener metadatos
            DatabaseMetaData datosBD = miConexion.getMetaData();

            // mostrar info de la bd
            System.out.println("Gestor de BD " + datosBD.getDatabaseProductName());
            System.out.println("Versión del gestor de BD " + datosBD.getDatabaseProductVersion());
            System.out.println("Nombre del driver de la BD " + datosBD.getDriverName());
            System.out.println("Versión del driver de la BD " + datosBD.getDriverVersion());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                miConexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // metodo para obtener los metadatos de la tabla productos
    static void mostrarInfoTabla() {

        Connection miConexion = null;
        ResultSet miResultset = null;

        try {

            // creamos la conexion
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // obtener metadatos
            DatabaseMetaData datosBD = miConexion.getMetaData();

            // lista de tablas,utilizamos el metodo getTables() de la interfaz
            // DatabaseMetaData,este metodo puede recibir 4 parametros para afinar la
            // busqueda,se pueden dejar como null para traer toda la informacion de la
            // bd,osea las tablas que tiene,si tiene procedimientos almacenados creados
            // tambien los mostrara,etc.
            System.out.println("Lista de tablas de la BD");

            miResultset = datosBD.getTables("pruebas", null, null, null);

            while (miResultset.next()) {

                System.out.println(miResultset.getString("TABLE_NAME"));

            }

            // lista de columnas de la tabla productos
            System.out.println("------------------------------");
            System.out.println("Campos de tabla productos");

            miResultset = datosBD.getColumns(null, null, "productos", null);

            while (miResultset.next()) {

                System.out.println(miResultset.getString("COLUMN_NAME"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                miConexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
