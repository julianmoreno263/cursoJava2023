/*(v210) vamos a ver el patron de arquitectura ModeloVistaControlador o MVC, este modelo separa la logica del programa(datos),la interfaz de usuario y las comunicaciones(eventos),esto tiene varias ventajas,entre ellas la modularizacion del programa,la reutilizacion de codigo,mayor facilidad en el desarrollo y en el mantenimiento.


El modelo se encarga de todo lo relacionado con los datos y su encapsulacion,la vista todo lo de la gui y el controlador(los eventos) se encarga de la conexion entre la vista y el modelo.

Cuando un usuario realiza una accion desde la gui esta se pasa al controlador, el controlador procesa este evento y le pasa los datos al modelo para que este realice la consulta a la bd y carge los resultados,despues el modelo le pasa estos datos de vuelta al controlador y este le envia esa informacion a la vista para que la muestre en pantalla.

Vamos a seguir trabajando con la app que nos trae datos de la tabla productos y que la hicimos toda en un unico archivo, para esto crearemos tres paquetes para el modelo,vista y el controlador y asi separar la app,crearemos un 4 paquete para poner alli el metodo main y desde alli ejecutar la app,este 4 paquete se llamara principal.

Cada vez que queramos usar una clase de otro paquete debemos importar ese paquete.

-----------------------------------------------------------------------------
(v211)La conexion se crea en el modelo

En el modelo el mvc establece que todos los datos que se vayan a manejar se deben de encapsular para que no sean accesibles desde fuera.En esta app los datos que se manejan de la tabla de la bd son nombrearticulo,precio,seccion y paisdeorigen,luego estos datos son los que se deben de encapsular para solo poder ser manipulados por los correspondientes metodos getters y setters.

Inicialmente para este ejercicio les daremos un estado inicial a estos datos desde el constructor del modelo.Para crear los getters y setters para acceder a estos campos encapsulados dejamos que sea vsc el que los genere.

Ahora, ya dividido el codigo en sus archivos correspondientes debemos hacer que la app funcione,lo primero es hacer que al abrir la app se cargen los items de los comboBox y esto se hace con un evento que es "al abrir la app".

1- el evento de abrir la app se crea en el controlador y este evento debe cargar los comboBox,entonces esa accion de cargar los items de cada comboBox es una consulta a la bd,por lo que eso debe ir en el modelo.Segun como uno piense la app asi mismo va viendo que ocurre y que debe de ir en cada parte del mvc.

2- primero vamos a trabajar en el modelo para cargar esos datos en los comboBox,  entonces creo otra clase en el modelo, como se va a hacer una consulta a la bd debo traerme la conexion que esta en el controlador.Despues creo la consulta sql,sera una consulta normal,por ahora no sera preparada.

----------------------------------------------------------------------------------------
(v212) ahora debemos crear la interaccion entre el modelo que ya ejecuta la consulta a la bd y la vista,para que los datos que tiene el modelo en el resultset puedan viajar y se cargen en el comboBox correspondiente a las secciones, esto lo hacemos en el controlador.

1- para esto,primero debemos decirle al marco que cuando se abra(evento abrir) ejecute el metodo que realiza la consulta en el modelo y cargue esos datos en el comboBox,porque apenas abramos la app se deben de poder mostrar los items de cada comboBox.Ese evento que comunicara a vista y modelo lo hacemos en el controlador(el controlador maneja los eventos).

Entonces,como vamos a necesitar el resultset del modelo y el comboBox de secciones de la vista y estos campos estan en distintos paquetes y son private,nos saltaremos la regla de que esos campos deben ser encapsulados y solo deberan ser accesibles por los respectivos metodos y los pondremos public en este ejercicio para no complicarse mas.

2- ahora en el controlador creo otra clase para que gestione este evento que necesitamos.Como este evento es un evento de ventana(al abrir la ventana) debemos implementar la interfaz WindowListener y asi poder utilizar el metodo windowOpened(). Como WindowListener tiene varios metodos y solo necesitamos uno, mejor heredamos de la clase adaptadora WindowAdapter que implementa WindowListener y asi podemos utilizar solo el metodo que necesitamos que es windowOpened() sobreescrito y recibe un parametro de tipo WindowEvent.

3- creo dos objetos,uno de tipo CargaSecciones y otro de tipo MarcoAplicacion porque voy a tener que hacer referencia al metodo ejecutaConsultas() del modelo y al comboBox de la vista.

4- para que esta clase controladora pueda manipular un comboBox que es de la clase MarcoAplicacion2 debo pasarle un objeto de este tipo,y esto lo hago creando un cosntructor y pasandole un objeto de tipo MarcoAplicacion2 como parametro,asi al tener este objeto ya puede acceder por medio de ese objeto al comboBox que necesita.

5- ahora,en el metodo que gestionara el evento llamamos al metodo del modelo que ejecuta la consulta,osea el metodo ejecutaConsultas(), y como este metodo retorna el resultset con los datos entonces recorro ese resultset y lo almaceno en el comboBox de la vista.

6- por ultimo,para que este evento se ejecute,debemnos ir a la vista y decirle al marco que debe estar a la escucha de ese evento,porque ese evento se dispara cuando se abre la app,osea cuando se abre el marco para que cargen los comboBox con los datos.Esto se hace en la clase MarcoAplicacion2 con el metodo addWindowListener(porque es un evento de ventana) al que se le pasa esa clase ControladorCargaSecciones y como esta clase pide un parametro de tipo MarcoAplicacion2 pues ese objeto que se le pasa es el mismo marco,osea se pone this.

LISTOO!!  APENAS CARGE LA APP CARGAN TAMBIEN LOS ITEMS DEL COMBO DE SECCIONES.

------------------------------------------------------
(v213) correccion de errores en el codigo,sobretodo se cambio el metodo ejecutaConsultas de la clase CargaSecciones del modelo.

------------------------------------------------------------------
(v214) vamos a crear ahora el codigo para cargar los paises en el otro comboBox,lo haremos en el mismo archivo de las secciones por lo que le cambiamos el nombre a este archivo para que se llame CargaMenus.java, lo mismo para la clase del controlador ControladorCargaSecciones.

1- ahora, en CargaMenus del modelo creo otro resultset para los paises,tambien creo su correspondiente statement para despues crear la consulta sql.Esto dentro del metodo ejecutaConsultas().

2- ahora, en el controlador en la clase ControladorCargaMenus en el while donde recorre los resultset creo otro while para el resultset de paises.Hay que hacer dos while para esto porque como las consultas sql tienen "distinctrow" no pueden ir devolviendo secciones y paises a la vez.

-----------------------------------------------------------
(v215) ahora, vamos a hacer que el boton del marco responda a eventos,y que se ejecuten las consultas correspondientes segun lo que el usuario escoja en cada comboBox,para esto debemos hacer otro archivo en modelo para las consultas correspondientes y otro archivo en controlador para que gestione el evento del boton al dar click y asi ejecute las consultas.

1- primero hacemos la clase del modelo para crear las consultas a la bd segun lo que escoja el usuario,la llamaremos EjecutaConsultas.java. En esta clase creamos un metodo que ejecutara las consultas y ese metodo despues sera llamado por el evento que dispare al dar click en el boton.

2- en este metodo se evalua con los correspondientes if-else if, las tres posibilidades que escoja el usuario,osea si escogio solo seccion,solo pais o escogio ambas.

3- ahora creamos la clase para que gestione el evento click del boton y asi se ejecute la respectiva consulta que hay en el modelo.Como esta clase gestionara eventos debe implementar la interfaz ActionListener,debemos importar el paquete java.awt.event.Desde esta clase debemos ser capaces de hacer dos cosas:

- acceder a la clase EjecutaConsultas del modelo para poder acceder a su metodo filtraDB que creamos para poder ejecutar las respectivas consultas,para esto debo importar el paquete del modelo y despues crear un objeto de esa clase para poder acceder al metodo filtraDB.

-Y tambien esta clase del controlador debe poder recibir por parametro un objeto de la clase MarcoAplicacion2 de la vista para poder acceder al boton y manipularlo,para esto importamos tambien el paquete vista.Ese parametro se le pasa por medio del metodo constructor.

4- creo un campo de clase de tipo MarcoAplicacion2 y con este campo dentro del metodo actionPerformed puedo seleccionar lo que el usuario escoja en secciones y paises.

5-despues pongo en el area de texto del marco el resultado de la consulta,esto lo hago usando el metodo append() y dentro de este metodo llamo al metodo del modelo que ejecuta estas consultas.Para poder llamar a ese metodo lo hago creando un objeto de tipo EjecutaConsultas que es la clase del modelo.

6- ahora ponemos el boton del marco a la escucha del evento para que cuando se haga click se ejecute el controlador, esto se hace en el archivo MarcoAplicacion2,utilizando addActionListener(new ControladorBotonEjecuta(this)).El this hace referencia al propio marco porque el constructor de ControladorBotonEjecuta() pide un objeto de tipo del marco.

Listo!! hasta aqui ya esta el boton a la escuha del evento y pone los strings iniciales que creamos de prueba en las consultas en el area de texto,ahora debemos crear las consultas pertinentes.





 */

package src.principal;

import javax.swing.JFrame;

import src.vista.*;

public class EjecutaMVC {
    public static void main(String[] args) {

        // instanciamos el marco de la app
        MarcoAplicacion2 miMarco = new MarcoAplicacion2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}
