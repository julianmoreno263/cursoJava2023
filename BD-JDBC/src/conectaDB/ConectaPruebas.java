/*(v201) vamos a comenzar a ver jdbc(java data base connectivity), esto es un driver para poder conectar nuestras apps de java con bd de cualquier tipo, el jdbc lo da el sgbd,osea si vamos a trabajar con una bd tipo mysql debemos descargar el correspondiente jdbc para ese gestor.

Para trabajar con bd en java usaremos los paquetes java.sql y javax.sql, tambien la clase DriverManager con sus correspondientes interfaces.Para acceder alas bd con java se deben de seguir 4 pasos:

1- establecer conexion con la bd, aqui se crea un objeto tipo conexion el cual tiene un string con la informacion de la bd a conectar, tiene esta estructura: driver - protocolo driver - detalles de conexion del driver, por ejemplo para una conexion mysql:

                        "jdbc:       mysql:      //localhost:9999/gestionPedidos"
                       (driver)   (protocolo)       (detalles de conexion del driver)

La conexion lanza una excepcion por lo que debemos usar try-catch.

2- crear un objeto statement, con el objeto conexion del paso anterior usamos el metodo createStatement() y se crea un objeto tipo statement.

3- ejecutar sentencia sql, con el objeto statement usamos el metodo executeQuery("sentencia sql") y se crea el resultset.

4- leer el resultset utilizando los metodos getString() o next() dentro de un bucle while,etc.

Entonces, antes de todo debemos tener la bd mysql(trabajaremos con este sgbd), el driver jdbc para mysql, y creamos el proyecto en vsc.

1- una vez creado el proyecto en vsc debemos agregar a la path del proyecto el driver mysql, para esto en vsc seleccionamos la carpeta del proyecto,click derecho,Add Folder to Java Source Path, despues de hacer esto vamos abajo a la izquierda en JAVA PROJECTS y debemos ver agregado el proyecto,lo seleccionamos y mas abajo en "Referenced Libraries" le damos al + y seleccionamos el archivo .jar del jdbc que descargamos y listo.

NOTA: DEBEMOS ESCRIBIR BIEN LOS DATOS EN EL METODO getConnection() BIEN ESCRITOS PARA QUE NO SALGA ERROR Y SE CONECTE LA BD:

    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");


Ahora,despues de configurar esto creamos nuestra clase para crear la conexion a la bd.

NOTA: SI ESTAMOS EN phpMyAdmin podemos poner en sql esta sentencia para saber el puerto de nuestro servidor(se supone que por defecto es 3306):

                    show variables where variable_name in('hostname','port')

nos saca una tabla con el nombre de host y lo mas importante el puerto.

 */

package src.conectaDB;

import java.sql.*;

public class ConectaPruebas {
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

            // 3- ejecutamos la sentencia sql con el objeto statement,la interfaz Staemnet
            // tiene un metodo executeQuery() al cual se le pasa la consulta sql,y este
            // devuelve un objeto de tipo Resulset la cual tambien es una interfaz.
            ResultSet miResulset = miStatement.executeQuery("select * from productos");

            // 4- recorremos el resultset con un bucle y usando los metodos de la interfaz
            // Resulset, en la condicion le decimos que "mientras haya un proximo registro
            // despues del cursor" recorra el resulset.Despues si quiero imprimir en consola
            // los resultados,puedo usar el metodo getString("nombre de columna") de la
            // interfaz ResultSet que pide el nombre de la columna que queremos ver.
            while (miResulset.next()) {

                System.out.println(miResulset.getString("CODIGOARTICULO") + " " + miResulset.getString("NOMBREARTICULO")
                        + " " + miResulset.getString("PRECIO"));
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No conecta la BD");
            e.printStackTrace();
        }
    }
}
