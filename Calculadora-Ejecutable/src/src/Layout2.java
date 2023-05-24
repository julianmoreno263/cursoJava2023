
/*(v140) hay que aclarar que esta firma digital que hacemos nosotros es solo para probar que funciona al compartir el archivo .jar,osea no es una firma digital valida,porque para tener cada uno nuestra firma digital debemos solicitarla en la entidad correspondiente que la expide y esa si es legal,nosotros para esta prueba de ver como se crea y se firma un archivo.jar ponemos datos que pudieran ser falsos,entonces la firma digital legal hay que solicitarla.

Ahora,vamos a ver como hacer ejecutables java,osea como crear un archivo java que sea ejecutable sin necesidad de abrirlo por medio de un editor de codigo, pues java es multiplataforma por lo que los archivos ejecutables deben estar en capacidad de ejecutarse independiente del so, en windows los ejecutables son .exe,en linux .deb,en Macintosh son .app,y en solaris son .elf.Entonces los archivos .jar ejecutables son los que hacen que java sea multiplataforma.

Vamos a trabajar de nuevo con la calculadora y volverla ejecutable para que si se la damos a alguien,esta persona solamente debe tener el jdk instalado para poder ejecutar el programa,sin necesidad de editores.

1-creamos un nuevo proyecto y lo llamamos Calculadora-Ejecutable y alli ponemos nuestra calculadora.

2- en vsc para crear el archivo ejecutable es igual que cuando creo un .jar normal,solo que al darle a la flecha -> me sale el cuadro donde debo poner la clase main,alli la digito,no la selecciono con el mouse sino digito el nombre de la clase main y asi me crea el ejecutable,porque si la selecciono con el mouse me crea un archivo .jar normal comprimido.

3- Listo,este archivo ejecutable lo puedo compartir y el usuario solo debe tener instalado en el pc el jdk para darle click y ejecutarlo, no importa el SO del usuario,se ejecutara en cualquier SO desde que tenga el jdk instalado.

Ahora, si tenemos una aplicacion que usa recursos externos,por ejemplo una imagen que se encuentra en otra carpeta, al crear el ejecutable no tomara esta imagen,por lo que la aplicacion no funcionara como debiera,para corregir esto se utiliza el metodo getResources() de la clase class,esto aun no lo hemos visto con profundidad pero se vera mas adelante.En si con este metodo se le dice a la hora de empaquetar el programa en un jar ejecutable que carge los recursos externos.

1- Lo primero,si necesitamos por ejemplo una imagen, debemos poner esa imagen en la carpeta bin del proyecto, en el caso de que necesitemos en nuestro programa una imagen que estara en un boton,por ejemplo,para que esa imagen pueda ser cargada a la hora de hacer el jar ejecutable debemos crear un objeto tipo URL de la clase Net, y en ese objeto se guardar la imagen y despues ese objeto se le pasa al boton asi:

URL rutaBoton= Lamina.class.getResorce("imagen.png"), la lamina es el contenedor donde se usa este recurso,por ejemplo en este caso una lamina, y despues se crea el boton y se le pasa la imagen asi:

JButton miBoton= new JButton("Mostrar",new ImageIcon(rutaBoton)), asi se cargan recursos externos al empaquetar un jar ejecutable.

--------------------------------------------------------------------
(v142) ahora, vamos a ver jws, que es otra forma de empaquetar nuestras aplicaciones y poder distribuirlas de una manera mucho mejor que solo crear un .jar y enviarlo por correo. Cuando creamos un .jar ejecutable para enviarlo a varios usuarios puede que no sea la mejor forma porque por ejemplo si debo enviarlo a 3000 usuarios pues es una tarea muy dificil,ahora si la aplicacion necesita actualizarse me tocaria crear las actualizaciones y volver a enviar la aplicacion a los usuarios.

Para mejorara esto,se usa jws(java web start), que es en si empaquetar la aplicacion en un jar,pero se pone en un servidor remoto y a la vez se crea un archivo xml que debe tener la extension jnlp(java network launch protocol).Con esto se consigue que un usuario abra un navegador y digite la url con extension jnlp,al hacer esto se descargara el archivo xml de extension jnlp y se ejecutara la aplicacion java desde el servidor,osea en remoto.Esto hace posible que las aplicaciones no necesiten crearse como applets,si por ejemplo creamos asi nuestra calculadora,se ejecutaria desde este servidor con su marco y no como un applet.

Tambien se puede distribuir a miles de usuarios compartiendo la url, ademas se asegura que siempre este actualizada porque si se crea una actualizacion simplemente se reemplaza el jar en el servidor,esto es transparente para el cliente porque el navegador siempre ejecuta la aplicacion que esta cargada en cache,osea la version actual,si se actualiza el jar en el servidor,el navegador compara lo que tiene en cache con lo que hay en el servidor y si la version del servidor es mas actual la carga en cache y asi la mantiene actualizada,y esto es transparente para el usuario.Otra ventaja es que no hay que instalar nada en el pc, porque las aplicaciones se ejecutaran en el servidor.Para hacer esto seguimos estos pasos,por ejemplo vamos a trabajar con la calculadora y ponerla en el servidor remoto.

1- tomamos el proyecto de calculadora y creamos un jar normal(no ejecutable).


 */
package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout2 {
    public static void main(String[] args) {

        MarcoCalculadora miMarco = new MarcoCalculadora();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}

// marco
class MarcoCalculadora extends JFrame {

    public MarcoCalculadora() {

        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);

        LaminaDisplay miLamina = new LaminaDisplay();
        add(miLamina);

    }

}

// lamina para el display
class LaminaDisplay extends JPanel {

    private JPanel miLamina2;
    private JButton pantalla;
    private boolean principio;
    private double resultado;
    private String ultimaOperacion = "=";

    public LaminaDisplay() {

        principio = true;

        setLayout(new BorderLayout());
        pantalla = new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla, BorderLayout.NORTH);

        // creamos el objeto de tipo ActionListener para el oyente de los botones
        // numericos
        java.awt.event.ActionListener insertar = new InsertaNumero();

        // creamos el objeto de tipo ActionListener para el oyente de los botones de las
        // operaciones
        java.awt.event.ActionListener orden = new AccionOrden();

        // segunda lamina para los botones,con el metodo ponerBoton creamos cada
        // boton,tener en cuenta que los botones se van agregando por filas.
        miLamina2 = new JPanel();
        miLamina2.setLayout(new GridLayout(4, 4));
        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBoton("/", orden);
        ponerBoton("4", insertar);
        ponerBoton("5", insertar);
        ponerBoton("6", insertar);
        ponerBoton("*", orden);
        ponerBoton("1", insertar);
        ponerBoton("2", insertar);
        ponerBoton("3", insertar);
        ponerBoton("-", orden);
        ponerBoton("0", insertar);
        ponerBoton(".", insertar);
        ponerBoton("=", orden);
        ponerBoton("+", orden);

        // agregamos esta lamina ala parte central de la primera
        add(miLamina2, BorderLayout.CENTER);

    }

    // funcion para agregar los botones en la segunda lamina y ponerlos a la escucha
    // del evento
    public void ponerBoton(String rotulo, java.awt.event.ActionListener oyente) {

        JButton boton = new JButton(rotulo);
        boton.addActionListener(oyente);
        miLamina2.add(boton);
    }

    // clase interna que maneja los eventos para los botones numericos
    private class InsertaNumero implements java.awt.event.ActionListener {

        public void actionPerformed(ActionEvent e) {

            // capturamos el texto del boton pulsado y lo ponemos en el display,en setText
            // debemos indicar que al texto que tenga el display le ponga a continuacion el
            // nuevo texto de entrada y no que lo reemplace,porque en una calculadora al ir
            // oprimiendo botones de numeros,esos nuemros van apareciendo en el display uno
            // despues del otro,no se reemplazan.
            String entrada = e.getActionCommand();

            // codigo para que si el boton pulsado es el primero en pulsarse,pues borre el
            // cero del display y comience a poner los numeros,para que principio sea true y
            // se pueda ejecutar este if lo ponemos en true en el constructor de la
            // lamina,como este constructor se ejecuta al iniciar el programa entonces le
            // decimos que principio es true porque es la primera vez que se ejecuta y entra
            // en el if y pone el display en blanco,se quita el cero inicial,si no es la
            // primera vez que se ejecuta no hay necesidad de usar este
            // if y los numeros se van poniendo uno despues del otro.Recordar que al
            // declarar una variable booleana,si no se inicia,esta se pone en false por
            // defecto.
            if (principio) {
                pantalla.setText(" ");
                principio = false;
            }

            pantalla.setText(pantalla.getText() + entrada);

        }
    }

    // clase interna que maneja los eventos para los botones de las operaciones
    private class AccionOrden implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // variable para guardar la operacion que el usuario pulso
            String operacion = e.getActionCommand();

            calcular(Double.parseDouble(pantalla.getText()));

            ultimaOperacion = operacion;

            principio = true;
        }

        public void calcular(double x) {

            if (ultimaOperacion.equals("+")) {

                resultado += x;

            } else if (ultimaOperacion.equals("-")) {

                resultado -= x;
            } else if (ultimaOperacion.equals("*")) {

                resultado *= x;
            } else if (ultimaOperacion.equals("/")) {

                resultado /= x;
            } else if (ultimaOperacion.equals("=")) {

                resultado = x;
            }

            // le ponemos el string "" para concatenarlo con la variable resultado y que no
            // me de error,porque el metodo setText espera un string y si le ponemos
            // resultado solo(el cual es un double) saca error,por eso lo concatenamos con
            // un string.
            pantalla.setText("" + resultado);
        }

    }

}
