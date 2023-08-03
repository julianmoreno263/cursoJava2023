/*(v204) vamos a ver como crear consultas de tipo insert,update y delete desde java con jdbc.Recordar que el resultset es una tabla virtual que se crea cuando hago una consulta select para ver los datos,como en estas otras consultas no quiero ver nada sino modificar la bd no utilizaremos el codigo que crea un resultset.

1- utilizo todo el codigo del video anterior del try-catch el cual tiene lo referente a la conexion,cambiara la consulta y no utilizaremos el codigio del resultset.

2- creo la consulta sql, primero haremos un insert.

----------------------------------------------------



 */

package conectaDB;

import java.sql.*;

public class ModificaBD {
    public static void main(String[] args) {

        try {

            // 1-creamos la conexion,debemos usar la clase DriverManager del paquete
            // java.sql y su metodo getConnection(),usamos el que nos pide url,usuario y
            // contraseña porque estamos usando mysql.Este metodo nos devuelve un objeto de
            // tipo Connection la cual es una interfaz.
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // 2- creamos el objeto statement,para esto utilizamos el metodo
            // createStatement() de la interfaz Connection el cual devuelve un objeto tipo
            // Statement la cual tambien es una interfaz
            Statement miStatement = miConexion.createStatement();

            // 3- consulta sql,como estamos en este punto usando la interfaz Statement,busco
            // un metodo de esta interfaz que me permita ejecutar la consulta,y este metodo
            // es executeUpdate(String sql),pues permite ejecutar consultas tipo
            // insert,update o delete(ver API).
            // String sql = "insert into productos (codigoarticulo,nombrearticulo,precio)
            // values('AR42','Pantalon','44')";

            // consulta de actualizacion,actualizamos el precio al doble
            // String sql = "update productos set precio=precio*2 where
            // codigoarticulo='AR42'";

            // consulta de eliminacion,no olvidar nunca poner el where para no eliminar toda
            // la tabla
            String sql = "delete from productos where codigoarticulo='AR42'";

            // 4-ejecutamos la consulta y podemos poner un mensaje en consola
            miStatement.executeUpdate(sql);

            System.out.println("Tabla productos modificada correctamente!");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No conecta la BD");
            e.printStackTrace();
        }
    }
}
