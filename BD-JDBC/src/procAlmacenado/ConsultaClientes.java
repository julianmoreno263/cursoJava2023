/*(v218) Procedimiento almacenado, instruccion sql que es usada repetida mente por varios usuarios en la misma bd,por lo que esa instruccion es major almacenarla en un procedimiento y cada usuario la llama cuando la necesita usar desde su propia aplicacion o pc,para llamar a ese procedimento se usa la instruccion “call” y el nombre del procedimiento,como una función.Trae ventajas de eficiencia y seguridad, se almacena esta instrucción en el servidor y no en cada aplicación del cliente por lo que es mejor.Un procedimiento almacenado puede ser una instrucción sql simple o puede ser un código con bucles,condicionales,etc,y pueden llevar parámetros.

Los procedimientos almacenados se crean en la bd,se almacenan en la bd, y para crearlos se usa una sintaxis parecida a la del lenguaje visualBasic o pascal,esto se puede hacer con bd que admitan procedimientos almacenados como mysql.

Entonces,por ejemplo vamos a crear un procedimiento para que nos muestre todos los clientes de la población de Barcelona de la tabla clientes.

1-	Se declara la creación del procedimento asi:  create procedure nombreProcedimiento().Los paréntesis es para pasar parámetros si se necesita,o sino se dejan en blanco,como una función.

2-	Se pone el código sql que almacenara el procedimiento.

create procedure muestra-clientes()
select * from clientes where población=”Barcelona”

al actualizar phpMyAdmin aparecerá en la bd la sección de procedimientos almacenados.Para utilizarlo vamos a hacer un programa que e stara dentro de un nuevo paquete en el proyecto de BD-JDBC. Para utilizar el procedimiento almacenado debo usar la interfaz CallableStatement y el metodo prepareCall(), en este metodo uso "{call nombre-procedimiento}" para llamarlo.

COMO VEMOS EN LOS RESULTADOS SE EJECUTA LA CONSULTA SELECT DEL PROCEDIMIENTO ALMACENADO,EN EL CLIENTE NO HAY NINGUNA CONSULTA SELECT(OSEA EN ESTE CODIGO), TODO EL TRABAJO SE LO DEJAMOS AL SERVIDOR PORQUE ALLI ES DONDE ESTA ALMACENADA LA CONSULTA,EL CLIENTE SOLO LA INVOCA CUANDO LA NECESITE USAR.

----------------------------------------------------
(v219) vamos a crear un procedimiento almacenado que reciba parametros y ademas que actualice registros en la tabla productos,actualizara los precios.Los parametros,como en las funciones,serviran para que el usuario sea el que pueda elegir que productos quiere actualizar(hay que tener en cuenta el tipo de los campos de la tabla,en mi tabla todos son de tipo string pero se debe tener en cuenta cuando son int,date,etc).

Entonces para crear este tipo de procedimiento almacenado es:

1- create procedure actualizaProd(parametroPrecio tipoParametro), se debe especificar el tipo del parametro y este debe ser igual al del campo de la tabla,osea si es varchar pues se pone varchar(15) y la longitud de ese campo,el del precio es varchar(15) y el nombrearticulo es varchar(20),vemos la tabla y asi mismo ponemos los tipos de datos y longitud.

             create procedure actualizaProd(nPrecio varchar(15), nArticulo varchar(20))

               update productos set precio=nPrecio where nombrearticulo=nArticulo

La novedad a la hora de hacer la llamada a un procedimiento que recibe parametros es que se indican estos con el simbolo ? asi:

         CallableStatement miProc = miConexion.prepareCall("{call actualizaProd(?,?)}");

Despues pasamos los parametros para que se almacenen en esos simbolos ? asi:

                      //aqui pasamos los parametros en orden a los ?
                        miProc.setString(1, miPrecio);
                        miProc.setString(2, miArticulo);

Por ultimo ejecutamos el procedimiento, como no vamos a recorrer ningun resultset,porque vamos es a actualizar registros,no usamos executeQuery() que nos devuelve un objeto resultset,usamos el metodo execute() el cual solo devuelve un boolean indicando true o false para si se ejecuto o no el procedimiento.

                        // ejecutamos el procedimiento
                        miProc.execute();

Como vemos, al hacer la llmada al procedimiento desde el cliente,le pasamos los parametros y el servidor es el que se encarga de realizar el trabajo porque el es el que tiene almacenado ese procedimiento.

 */

package procAlmacenado;

import java.sql.*;

public class ConsultaClientes {
    public static void main(String[] args) {

        try {

            // conexion a la bd
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // para usar el procedimento almacenado utilizo la interfaz CallableStatement
            CallableStatement miProc = miConexion.prepareCall("{call muestra_clientes()}");

            // para verlo puedo crear un resultset y recorrelo.
            ResultSet rs = miProc.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getString(1) + "" + rs.getString(2) + "" + rs.getString(3));
            }

            rs.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}