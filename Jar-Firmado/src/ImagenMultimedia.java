/*(v138) vamos a ver como se firman digitalmente los archivos .jar que enviamos hacia la red, la firma de archivos es una medidad de seguridad que le indica al usuario que va a recibir nuestro programa java que este es confiable,a veces el programa en java para ejecutarse debe poder acceder a archivos del ordenador del usuario donde va a correr, por defecto el archivo .jar no tiene permisoso para acceder a recursos de los pcs donde se va a ejecutar por seguridad,asi que nosotros como programadores debemos firmar los archivos .jar que enviamos para que los usuarios sepan que es confiable,esto lo hacemos con una firma digital la cual en principio tiene informacion sobre nombre del programador,organizacion,departamento,ciudad,pais.

Para firmar el .jar se necesitan dos cosas:

1- Crear la firma digital con la herramienta keytool.
2- Firmar la aplicacion .jar con el certificado generado,esto lo hacemos con la herramienta jarsigner.

Estas dos herramientas vienen dentro del jdk. Para ver como firmar una aplicacion vamos a crear un nuevo proyecto y sera una aplicacion que muestre una imagen en una lamina,luego la empaquetamos y vemos como se firma para poder enviar ese paquete a un correo, no cree un applet como en el video porque estos estan descontinuados desde jdk9 y yo tengo la ultima version,voy a ver si asi me sale.

--------------------------------------------------
(v139) vamos entonces a firmar el archivo .jar,primero toca generarlo empaquetando el proyecto.

1- ya con el proyecto empaquetado abrimos cmd como administrador,y nos vamos hasta el archivo ejecutable de keytool siguiendo la ruta donde tengamos instalado el jdk,la mia es:

C:\Program Files\Java\jdk-17\bin>

ya parados aqui doy el siguiente comando para crear la firma:

keytool -genkey -alias jotavalida -validity 150 -keyalg rsa -v

el alias es solo un nombre para la firma "jotavalida", el -validity es el numero de dias que estara habilitada esa firma(puse 150),el -keyalg rsa es el algoritmo que se va a usar y el -v es solo para ir viendo en consola el proceso de creacion de la firma al dar enter.

al dar enter comienza a pedirnos una serie de datos para crear la firma,como una clave,nuestro nombre,nombre de la organizacion,ciudad,codigo de 2 letras del pais,y sale un resumen,le decimos si y despues nos pide la contraseña y listo.

La clave que le puse es: jota1177, la organizacion puse "scorpion software", departamento de desarrollo "dto desarrollo",este es el resumen de datos para esta firma:

Is CN=julian moreno, OU=dto desarrollo, O=scorpion software, L=Bogota, ST=Colombia, C=CO correct? yes

2- lista la firma,ahora firmamos el archivo .jar, como lo tenemos creado en la misma carpeta del proyecto lo puedo cortar y pegarlo en la carpeta bin del jdk donde se encuentra la herramienta keytool y jarsigner.exe que es con la que firmaremos el archivo.La instruccion completa queda asi:

C:\Program Files\Java\jdk-17\bin>jarsigner.exe Jar-Firmado.jar jotavalida -verbose

jotavalida es el alias que creamos,verbose es para que nos muestre lo que va haciendo.Despues nos pide la contraseña y listo,queda firmado el archivo,aparece "jar signed".

3- listo,ahora puedo nuevamente cortar y pegar el .jar en la carpeta bin del proyecto.Ya lo puedo compartir o enviar por red y la persona que lo vaya a abrir puede confiar por la firma que tiene,le saldra un mensaje de advertencia antes de abrirlo.

--------------------------------------------------------------------
(v140) hay que aclarar que esta firma digital que hacemos nosotros es solo para probar que funciona al compartir el archivo .jar,osea no es una firma digital valida,porque para tener cada uno nuestra firma digital debemos solicitarla en la entidad correspondiente que la expide y esa si es legal,nosotros para esta prueba de ver como se crea y se firma un archivo.jar ponemos datos que pudieran ser falsos,entonces la firma digital legal hay que solicitarla.

Ahora,vamos a ver como hacer ejecutables java,osea como crear un archivo java que sea ejecutable sin necesidad de abrirlo por medio de un editor de codigo, pues java es multiplataforma por lo que los archivos ejecutables deben estar en capacidad de ejecutarse independiente del so, en windows los ejecutables son .exe,en linux .deb,en Macintosh son .app,y en solaris son .elf.Entonces los archivos .jar ejecutables son los que hacen que java sea multiplataforma.

Vamos a trabajar de nuevo con la calculadora y volverla ejecutable para que si se la damos a alguien,esta persona solamente debe tener el jdk instalado para poder ejecutar el programa,sin necesidad de editores.

1-creamos un nuevo proyecto y lo llamamos Calculadora-Ejecutable y alli ponemos nuestra calculadora.


 */

import javax.swing.*;
import java.awt.*;

public class ImagenMultimedia {

    public static void main(String[] args) {

        MarcoIcono miMarco = new MarcoIcono();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

// frame
class MarcoIcono extends JFrame {

    public MarcoIcono() {

        setTitle("Icono");
        setBounds(300, 250, 550, 350);

        LaminaIcono miLamina = new LaminaIcono();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaIcono extends JPanel {

    Image icono;

    public void paint(Graphics g) {

        super.paintComponent(g);

        icono = new ImageIcon("bin/logo.jpg").getImage();
        g.drawImage(icono, 50, 50, LaminaIcono.this);

    }

}