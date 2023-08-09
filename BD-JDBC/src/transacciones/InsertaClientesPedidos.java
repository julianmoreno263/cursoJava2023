/*(v220) vamos a ver las transacciones sql manejadas por medio de jdbc, transacciones son varias instrucciones sql trabajando en grupo, cuando hay varias sentencias sql juntas se les dice que son unidades de trabajo.
Por ejemplo,si tenemos una bd en la que tenemos que realizar periódicamente tres tareas por ejemplo borrar los empleados jubilados,después ingresar los nuevos trabajadores y por ultimo subirles el sueldo a todos, para asi tener actualizada la bd, utilizo una transacción para que estas tres tareas trabajen en conjunto y se ejecuten en orden.

La transacción tiene como característica que las consultas se deben de ejecutar todas o no se ejecuta ninguna,a esto en bd se le conoce como ACID(atomicidad,consistencia,aislamiento,durabilidad), la atomicidad es la característica de todo o nada,osea se ejecutan todas las tareas o ninguna, la consistencia se relaciona con la integridad de los datos,osea si se produce un error durante la ejecución de la transacción,se revierte todo y los datos se dejan como estaban antes de la transacción.  

Para trabajar con transacciones en jdbc utilizaremos 3 metodos del objeto Connection:

1-setAutoCommit(), le dice a la app java que las instrucciones sql de la app se pueden tratar como un bloque,por defecto este método es true,osea le esta indicando a java que las instrucciones sql se trataran individualmente, si especificamos este método como false le indicamos que las instrucciones sql pueden ser tratadas como bloque.

2- commit(), este método confirma el bloque de instrucciones o transacción,osea da el ok.

3- roolBack revierte la transacción,en caso de algún fallo en la transacción,este método revierte los cambios y deja la bd como estaba antes de ejecutar la transacción,garantiza la integridad de los datos.

Vamos a hacer un ejercicio con la bd pruebas específicamente manejando las tablas de clientes y pedidos las cuales están relacionadas,no puede existir un pedido que no pertenezca a un cliente y no puede haber un cliente que no haya echo pedidos.

El profe nos da este archivo donde inicialmente no tenemos transaccion niguna, por lo que las dos instrucciones sql se ejecutan individualmente,por lo que si depronto se ejecuta la primera sentencia y crea el cliente pero al ejecutar la segunda sentencia se produce un error,no se crea el pedido,y lo que queremos es que se creen los clientes siempre y cuando se les cree un correspondiente pedido,y viceversa,para asi mantener la integridad de la informacion,es aqui donde debemos usar las tranasacciones.

1- entonces,para crear la transaccion le decimos a java que las instrucciones sql trabajaran en bloque,usando el metodo setAutoCommit(false) del objeto Connect,osea de la conexion.

2-despues de ejecutar las instrucciones sql,le doy el ok con el metodo commit()

3- en el catch trato el posible error usando el metodo roolback(), debo declarar la variable miConexion fuera del bloque try para poder usarlo despues en el catch,entonces lo declaro iniciandolo en null(porque es un objeto),este rollback() tambien debe ir dentro de un try-catch.

Listoo!, ya con esto,las sentencias sql trabajan en bloque,si por ejemplo una falla,no se ejecuta nada y el roolback asegura la integridad de los datos dejandolos como estaban.Por ejemplo una instruccion sql puede estar mal escrita,se escribio un campo mal,entonces esto da un error al ejecutar las instrucciones pero la bd estara protegida y no se realizara cambio alguno hasta que se corrija el error.
 */

package transacciones;

import java.sql.*;

public class InsertaClientesPedidos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection miConexion = null;

		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

			// 1- establecemos el bloque de instrucciones sql para la transaccion
			miConexion.setAutoCommit(false);

			Statement miStatement = miConexion.createStatement();

			String instruccionSql_1 = "INSERT INTO CLIENTES (CODIGOCLIENTE, EMPRESA, DIRECCION) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";

			miStatement.executeUpdate(instruccionSql_1);

			String instruccionSql_2 = "INSERT INTO PEDIDOS (NUMEROPEDIDO, CODIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";

			miStatement.executeUpdate(instruccionSql_2);

			// 2- le doy el ok al bloque de instrucciones sql
			miConexion.commit();

			System.out.println("Datos INSERTADOS correctamente");

		} catch (Exception e) {

			System.out.println("ERROR EN LA INSERCION DE DATOS!!");

			// 3- uso rollback() para tratar el posible error si se presenta en la ejecucion
			// de la transaccion
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();

		}

	}

}
