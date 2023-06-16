/*(v157) vamos a ver la serializacion de objetos, serializar un objeto es pasarlo a bytes con el proposito de poder almacenarlo en un dispositivo electronico fisico,como una usb,un disco duro,etc, y tambien poder distribuirlo en red o enviarlo por red hacia otros dispositivos.

Para serializar un objeto en java debemos utilizar la interfaz Serializable la cual no tiene metodos, ademas para poder crear un objeto para que sea serializable usamos las clases ObjectOutputStream y ObjectInputStream, ObkectOutputStream nos sirve para crear un flujo de datos y sacar de nuestro programa java un objeto serializable al exterior,esto lo hacemos utilizando el metodo writeObject de esta clase(osea se escribe el objeto serializable para sacarlo del programa), y con la clase ObjectInputStream creamos un flujo de datos(stream) para capturar en nuestro programa un objeto serializable usando el metodo readObject() de esta clase.

Vamos a serializar objetos con un ejercicio, estos objetos serializados los almacenaremos en nuestro disco duro y despues los rescataremos.Utilizaremos el ejemplo de la clase Empleado y la clase Administrador, en ambas usaremos el metodo de la clase Object(clase cosmica,de donde se desprenden todas las demas clases de java) toString(), este metodo al ver la API lo describe como el metodo que da una descripcion de la clase,osea es como usar el System.out.println() que hemos venido usando para describir lo que hace la clase o los resultados que arroja,este metodo toString lo heredan todas las demas clases de java porque esta en la clase Object que es la clase padre en la API.

La clave del ejercicio esta en el metodo main donde creamos un array personal[] donde vamos a almacenar los objetos tipo empleado para despues serializar ese array y almacenarlo en el disco duro y despues rescatarlo e imprimirlo en consola,osea hacemos ambos pasos de una vez,serializarlo y despues deserializarlo para poder mostrarlo.

PASOS:

1- primero debemos ver que tipo de objeto es el que vamos a serializar,en este caso es un objeto de tipo Empleado,por lo que debemos ubicarnos en la clase Empleado e implementar alli la interfaz Serializable.

2- para crear el objeto serializable usamos la clase ObjectOutputStream con su metodo writeObject,este metodo lanza una exception por lo que debe estar dentro de try-catch, entonces en el metodo main creamos este try-catch y alli creamos el objeto serializable.Como la clase ObjectOutputStream tiene un constructor que pide un objeto de tipo OutputStream podemos pasarle un objeto de tipo FileOutputStream que hereda de OutputStream(ver API),con este objeto le indicamos la ruta donde queremos almacenar nuestro objeto serializable,vamos a ponerlo en una carpeta llamada objetosSerializados ubicada en cursojava2023 y le ponemos como nombre de archivo "empleado.dat",con esa extension.Hasta aqui indicamos donde queremos que se guarde el objeto que vamos a serializar,osea en el archivo empleado.dat.Este es el flujo de datos.

3-ahora con el metodo writeObject escribimos ese objeto serializable que sera el array personal[].No olvidar cerrar el stream con close(). Hasta aqui ya creamos el objeto serializado y lo escribimos,osea lo sacamos hacia un archivo externo de nuestro disco duro.Si corremos el programa y sale un error simplemente damos CTRL+SHIFT+P y damos en Java: Clean Java Language Server Workspace y listo.Vemos que se crea en la carpeta objetosSerializados el archivo empleados.dat que pesa 1kb.

4-para recuperar y leer este archivo en nuestro programa java hacemos lo mismo,creamos un flujo pero esta vez de entrada con ObjectInputStream y un objeto tipo FileInputStream y le pasamos la misma ruta del archivo empleados.dat porque ese archivo es el que va a leer.

5-ahora, como nuestro objeto que recuperamos es un array,debemos guardarlo en algun lugar,como es un array pues creamos un array para guardarlo,no podemos guardarlo en una variable int,etc, y este array es de tipo Empleado.Ahora,para leerlo usamos el metodo readObject de esta clase ObjectInputStream,y este metodo devuelve un object,por lo que debemos castear el tipo de dato de object a Empleado para poder usar este metodo(ver API).

6-por ultimo,ya con este array recuperado en nuestro programa,para poder verlo en consola debemos recorrerlo,usaremos un bucle for-each el cual tiene una sintaxis mas sencilla.Listo,al correr el programa debe aparecer en consola la informacion de los empleados creados en el array.

NOTA: EL TEXTO QUE SALE EN CONSOLA DE LOS RESULTADOS ES LA EJECUCION DEL METODO toString, PORQUE ESTE METODO SE IMPLEMENTO EN LA CLASE eMPLEADO PARA DARNOS UN TEXTO CON LA DESCRIPCION DE LOS RESULTADOS,AL INVOCAR UN OBJETO DE TIPO EMPLEADO SE EJECUTARA ESTE METODO.

El método toString te devuelve una representación en cadena de texto del objeto sobre el cual lo invoques. Es muy útil cuando quieres devolver un resumen del estado interno del objeto.


------------------------------------------------------------------------
(v158) vamos a ver como se trabaja la serializacion cuando hay cambio de versiones en nuestro programa java.Cuando queremos enviar por medio de nuestro programa java un objeto serializado a otro pc por la red, ese otro pc debe tener la misma version de nuestro programa java,osea la copia que ese otro pc receptor debe tener debe ser identica. Cuando creamos un programa java, aunque no lo veamos,ese programa tiene un numero identificativo unico,como un id unico,ese numero se denomina SHA, el compilador java analiza todas las clases del programa,etc y crea esa huella.Ese numero SHA es un numero de 20 bytes denominado serialVersionUID. Tanto el emisor del objeto serializado como el pc receptor deben tener ese mismo SHA, y si es el mismo se puede enviar el objeto sin problemas.

Ahora, si nuestro programa sufre una actualizacion,automaticamente cambia el numero SHA, por lo que si la copia del programa receptor no tiene el mismo numero,cuando el emisor intente enviar un objeto serializado,el receptor no lo podra leer.

Para solucionar esto, podemos hacer nuestro propio numero serialVersionUID, creando una constante static(que sera de la propia clase) y asi ese numero no cambia,por lo que si hacemos una actualizacion del programa,aunque el receptor no tenga esa actualizacion,podra seguir leyendo los objetos serializados que le enviemos.

La constante que se debe escribir es de tipo Long,asi: private static final long serialVersionUID=1L;

Y se pone en la clase que implementa la interfaz Serializable y las que hereden de esta clase.De esta forma,aunque se hagan cambios en el emisor,el receptor puede seguir leyendo los objetos serializables que se le envien,logico,si se cambia ese numero en el receptor,el emisor tambien debe hacer el cambio para que ambos tengan el mismo numero.Lo importante es que ambos tengan el mismo numero para poder trabajar con los objetos serializados.


 */

package serializacion;

import java.util.*;
import java.io.*;

public class Serializando {
    public static void main(String[] args) {

        Administrador jefe = new Administrador("Juan", 800, 2017, 03, 8);
        jefe.setIncentivo(5000);
        Empleado personal[] = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
        personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);

        // creacion del objeto serializable
        try {

            // flujo de datos,aqui creamos el flujo de datos y el objeto
            // serializable,escribimos el objeto array en el flujo de datos y cerramos el
            // flujo
            ObjectOutputStream archivoEscrito = new ObjectOutputStream(new FileOutputStream(
                    "objetosSerializados/empleado.dat"));

            archivoEscrito.writeObject(personal);
            archivoEscrito.close();

            // ----------------------------------------------
            // aqui leemos el objeto,osea lo volvemos a traer a nuestro programa java y lo
            // imprimimos en consola,lo debemos guardar en un array tipo Empleado pues el
            // array empleados[] es de ese tipo,y por ultimo lo recorremos con un for-each.
            ObjectInputStream archivoLeido = new ObjectInputStream(
                    new FileInputStream("objetosSerializados/empleado.dat"));

            Empleado arrayRecuperado[] = (Empleado[]) archivoLeido.readObject();
            archivoLeido.close();

            for (Empleado e : arrayRecuperado) {

                System.out.println(e);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}

// -------------------------------------------------

class Empleado implements Serializable {
    String nombre;
    double sueldo;
    Date fechaContrato;

    // constante serialVersionUID para tener un numero SHA de la version constante
    private static final long serialVersionUID = 1L;

    public Empleado(String n, double s, int agno, int mes, int dia) {
        nombre = n;
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
        fechaContrato = calendario.getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public void SubirSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    public String toString() {
        return "El empleado " + nombre + " tiene un sueldo de: " + sueldo + " y la fecha de contrato es: "
                + fechaContrato;
    }

}

// -------------------------------------------------

class Administrador extends Empleado {
    private double incentivo;

    // constante serialVersionUID para tener un numero SHA de la version constante
    private static final long serialVersionUID = 1L;

    public Administrador(String n, double s, int agno, int mes, int dia) {
        super(n, s, agno, mes, dia);
        incentivo = 0;
    }

    public double getSueldo() {
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    public String toString() {
        return super.toString() + " Incentivo = " + incentivo;
    }

}
