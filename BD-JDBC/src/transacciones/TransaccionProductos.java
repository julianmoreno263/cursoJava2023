/*(v121) vamos a realizar un ejercicio mas de transacciones,vamos a trabajar con nuestra tabla productos y haremos 3 tareas, eliminamos los productos italianos,eliminamos los productos que tengan un precio mayor a 300 y por ultimo subiremos un 15% el precio a los demas productos,estas 3 tareas se hacen en una transaccion para que trabajen como un solo bloque.

Haremos un codigo adicional en este programa que sera para que le pregunte al usuario si quiere ejecutar la transaccion o no,es una opcion, en el caso de que si la quiera ejecutar debera evaluarse en el caso de que se produzca algun error con un rollback, esto se hace creando una funcion.
 */

package transacciones;

import java.sql.*;

import javax.swing.JOptionPane;

public class TransaccionProductos {
    public static void main(String[] args) {

        Connection miConexion = null;

        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // 1- establecemos el bloque de instrucciones sql para la transaccion
            miConexion.setAutoCommit(false);

            Statement miStatement = miConexion.createStatement();

            // consultas
            String instruccionSql_1 = "delete from productos where paisdeorigen='Italia'";
            String instruccionSql_2 = "delete from productos where precio>300";
            String instruccionSql_3 = "update productos set precio=precio*1.15";

            // codigo para que el usuario decida si quiere ejecutar la transaccion o no
            boolean ejecutar = ejecutarTransaccion();

            if (ejecutar) {

                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);

                miConexion.commit();

                System.out.println("Transacción ejecutada correctamente");

            } else {

                System.out.println("No se ejecutó la transacción,no hay cambios en la bd.");
            }

        } catch (Exception e) {

            e.printStackTrace();

            try {
                miConexion.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            System.out.println("Ocurrió un error en el programa!");
        }
    }

    // este metodo debe ser static porque como este metodo se llama dentro del main
    // el cual es un metodo static,implica que ese metodo que se llama tambien debe
    // ser static
    static boolean ejecutarTransaccion() {

        String ejecucion = JOptionPane.showInputDialog("Ejecutamos la transacción?");

        if (ejecucion.equals("Sí")) {
            return true;
        } else {
            return false;
        }
    }
}
