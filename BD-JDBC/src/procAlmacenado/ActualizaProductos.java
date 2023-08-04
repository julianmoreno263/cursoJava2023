package procAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class ActualizaProductos {
    public static void main(String[] args) {

        String miPrecio = JOptionPane.showInputDialog("Introduce precio");
        String miArticulo = JOptionPane.showInputDialog("Introduce artículo");

        try {

            // conexion a la bd
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // para usar el procedimento almacenado utilizo la interfaz
            // CallableStatement,para enviar parametros se indica con el simbolo ?
            CallableStatement miProc = miConexion.prepareCall("{call actualizaProd(?,?)}");

            // aqui pasamos los parametros en orden a los ?
            miProc.setString(1, miPrecio);
            miProc.setString(2, miArticulo);

            // ejecutamos el procedimiento
            miProc.execute();

            System.out.println("Registro actualizado!!");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}