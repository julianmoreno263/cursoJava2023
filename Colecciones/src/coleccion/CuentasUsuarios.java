package coleccion;

import java.util.*;

public class CuentasUsuarios {
    public static void main(String[] args) {

        // creamos instancias de Cliente
        Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
        Cliente cl2 = new Cliente("Rafael Nadal", "00002", 300000);
        Cliente cl3 = new Cliente("Penelope Cruz", "00003", 400000);
        Cliente cl4 = new Cliente("Julio Iglesias", "00004", 600000);

        // creamos la coleccion de tipo set inicialmente,pero no podemos hacer new Set
        // porque Set es una interfaz y no se puede instanciar una interfaz,por lo que
        // debemos buscar una clase que implemente la interfaz Set e instanciar d eesa
        // clase,para esto vemos en la API la interfaz Set y hay salen las clases que la
        // implementan. Escogemos la clase segun sus ventajas y segun lo que
        // necesitamos.Para este primer ejemplo nos sirve la clase HashSet del paquete
        // java.util, asi que instanciamos de esta clase asi:

        // NOTA: SI AL HACER ESTO PRESENTA ERRORES Y NO DEJA UTILIZAR EL HashSet,
        // LIMPIAR EL ESPACIO DE TRABAJO DEL SERVIDOR CON: CTRL+SHIFT+P -> Clean Java
        // Language Server Workspace.
        Set<Cliente> clientesBanco = new HashSet<Cliente>();

        // ahora, para agregar a este tipo de coleccion Set,se tiene el metodo add(),
        // ver API en Set.
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);

        // recorremos la coleccion con un foreach, recorremos todos los objetos de tipo
        // Cliente de la coleccion clientesBanco,esta es la forma de leer la condicion
        // de un for-each.Dentro del bucle imprimimos los clientes usando los metodos
        // getters que creamos en la clase Cliente. Listo, apareceran en desorden porque
        // HashSet no permite el ordenamiento.
        for (Cliente cliente : clientesBanco) {

            System.out.println(cliente.getNombre() + " " + cliente.getNumCuenta() + " " + cliente.getSaldo());
        }

    }
}
