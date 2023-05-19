/*aqui en el marco ya le di layout tipo grid, ahora, con la clase creada de LaminaDialogos que es la que crea las cajas con los botones,aqui en el marco comienzo a instanciar esa clase para ir creando las cajas,como esa clase necesita en su constructor un array con los strings que llevaran los radio buttons pues creo primero esos arrays y despues instancio las cajas. 

A medida que vayamos creando las cajas,como el marco tiene disposicion gridLayout estas se van acomodando automaticamente.

(v126), ya creamos en el archivo de la lamina una funcion que le dara funcionalidad al boton de mostrar,esta funcion se encargara de mostrar el titulo del radio boton seleccionado,ahora aqui debemos poner nuestro boton de "Mostrar" a la escucha de un evento. 
*/

package appDialogos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

// frame
class MarcoDialogos extends JFrame {

    // variables para objetos de caja Tipo
    private LaminaDialogos laminaTipo, laminaTipoMensaje, laminaMensaje, laminaConfirmar, laminaOpcion, laminaEntrada;

    // variables para objetos de caja Mensaje
    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("Ejercicios/appDialogos/img/cuadro_azul.png");
    private Object objetoMensaje = new Date();
    private Component componenteMensaje = new LaminaEjemplo();

    // ---------------------------------------------------------------

    public MarcoDialogos() {
        setTitle("Prueba de diálogos");
        setBounds(300, 250, 600, 450);

        // lamina principal con grid layout de 2 x 3
        JPanel laminaGrid = new JPanel();
        laminaGrid.setLayout(new GridLayout(2, 3));

        // arrays de strings para cada caja
        String arrayTipo[] = { "Mensaje", "Confirmar", "Opción", "Entrada" };
        String arrayTipoMensaje[] = { "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE",
                "PLAIN_MESSAGE" };
        String arrayMensaje[] = { "Cadena", "Icono", "Componente", "Otros", "Object[]" };
        String arrayConfirmar[] = { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" };
        String arrayOpcion[] = { "String[]", "Icon[]", "Object[]" };
        String arrayEntrada[] = { "Campo de texto", "Combo" };

        // instancias para crear las cajas
        laminaTipo = new LaminaDialogos("Tipo", arrayTipo);
        laminaTipoMensaje = new LaminaDialogos("Tipo de Mensaje", arrayTipoMensaje);
        laminaMensaje = new LaminaDialogos("Mensaje", arrayMensaje);
        laminaConfirmar = new LaminaDialogos("Confirmar", arrayConfirmar);
        laminaOpcion = new LaminaDialogos("Opción", arrayOpcion);
        laminaEntrada = new LaminaDialogos("Entrada", arrayEntrada);

        // agrego las instancias de cajas a la cuadricula
        laminaGrid.add(laminaTipo);
        laminaGrid.add(laminaTipoMensaje);
        laminaGrid.add(laminaMensaje);
        laminaGrid.add(laminaConfirmar);
        laminaGrid.add(laminaOpcion);
        laminaGrid.add(laminaEntrada);

        // agrego la grid al marco
        add(laminaGrid);

        // boton y lamina inferior donde va el boton agregados al marco en zona sur.El
        // boton lo ponemos a la escucha d eun evento.
        JButton mostrar = new JButton("Mostrar");
        mostrar.addActionListener(new AccionMostrar());
        JPanel laminaBoton = new JPanel();
        laminaBoton.add(mostrar);
        add(laminaBoton, BorderLayout.SOUTH);

    }

    // ---------------------------------------------------------------

    // (v128)ahora creamos una funcion para el cuadro Mensaje, el cual cambiara el
    // mensaje de la ventana emergente que hayamos seleccionado en el cuadro
    // Tipo,esta funcion debe ser capaz de poner el mensaje que se
    // seleccione,osea,si en el cuadro mensaje se selecciona un icono pues debe
    // ponerle un icono a la ventana emergente,etc.El ultimo else con el return null
    // es para quitar el error que sale del metodo,porque cuando se evaluan los if
    // pueden ser que se ejecuten o no,osea se devuelve algo con return o no,pero
    // como el codigo no puede saber si se devuelve algo toca psarle
    // obligatoriamente un return ya sea null para que la funcion retorne algo, osea
    // nos aseguramos que para el compilador de java siempre haya un return.
    public Object dameMensaje() {

        // capturo el string del radio button seleccionado del cuadro Mensaje
        String s = laminaMensaje.dameSeleccion();

        // aqui evaluo que objeto debe poner esta funcion segun el radio button
        // seleccionado
        if (s.equals("Cadena")) {

            return cadenaMensaje;
        } else if (s.equals("Icono")) {

            return iconoMensaje;
        } else if (s.equals("Componente")) {

            return componenteMensaje;
        } else if (s.equals("Otros")) {

            return objetoMensaje;
        } else if (s.equals("Object[]")) {

            // esta opcion mostarar en la ventana todos los objetos del cuadro Mensaje
            return new Object[] { cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje };
        } else {
            return null;
        }
    }

    // ---------------------------------------------------------------

    // funcion para establecer el tipo de mensaje,osea el icono de las ventanas
    // emergentes,si es una ventana de informacion que salga el icono de una
    // i,etc.Para capturara el tipo de mensaje debemos ver en la API los valores
    // enteros de los mensajes en la clase JOptionPane,por ejemplo para un mensaje
    // de tipo ERROR_MESSAGE el valor es de 0,etc.por esto la funcion devolvera un
    // int.Esta funcion como devuelve un int, me sirve tambien para evaluar el tipo
    // de botones de las ventanas emergentes,osea los botones de YES,NO,CANCEL,ETC,
    // osea esta funcion evaluara dos cuadros,el de "Tipo de Mensaje" y el cuadro
    // "Confirmar" que es el que establece los botones de las ventanas
    // emergentes.ara esto le pasamos un parametro de tipo LaminaDialogos para que
    // pueda gestionar varios cuadros,recordar que los cuadros son de tipo
    // LaminaDialogos. El cuadro "Confirmar" que tiene las diferentes opciones de
    // tipos de botones solo trabaja cuando en el cuadro "Tipo" se ha seleccionado
    // la opcion de "Confirmar",porque esa opcion es la que saca ventanas de
    // showConfirmDialog.
    public int dameTipo(LaminaDialogos lamina) {

        // capturo el string seleccionado del cuadro Tipo Mensaje
        String s = lamina.dameSeleccion();

        // aqui evaluo que objeto debe poner esta funcion segun el radio button
        // seleccionado
        if (s.equals("ERROR_MESSAGE") || s.equals("	YES_NO_OPTION")) {

            return 0;
        } else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {

            return 1;
        } else if (s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) {

            return 2;
        } else if (s.equals("QUESTION_MESSAGE")) {

            return 3;
        } else if (s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")) {

            return -1;
        } else {
            return 0;
        }

    }

    // ---------------------------------------------------------------

    // funcion que da las opciones del cuadro "opcion",el cual es una ventana de
    // tipo showOptionDialog.Como las opciones de este cuadro son arrays de
    // objetos,la funcion nos tendra que devolver un array de objetos.Cuando ponemos
    // en la funcion el argumento lamina lo que hacemos es capturar alli la lamina o
    // el cuadro seleccionado,en este caso sera el cuadro "Opcion", y dentro de la
    // funcion la variable s lo que hace es capturar el string(titulo) del radio
    // button seleccionado.
    public Object[] dameOpciones(LaminaDialogos lamina) {

        // capturo el string seleccionado del cuadro Tipo Mensaje
        String s = lamina.dameSeleccion();

        // aqui evaluo que objeto debe poner esta funcion segun el radio button
        // seleccionado
        if (s.equals("String[]")) {

            return new String[] { "Amarillo", "Azul", "Rojo" };
        } else if (s.equals("Icon[]")) {

            return new Object[] { new ImageIcon("Ejercicios/appDialogos/img/cuadro_amarillo.png"),
                    new ImageIcon("Ejercicios/appDialogos/img/cuadro_azul.png"),
                    new ImageIcon("Ejercicios/appDialogos/img/cuadro_rojo.png") };
        } else if (s.equals("Object[]")) {

            return new Object[] { cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje };
        } else {
            return null;
        }

    }

    // ---------------------------------------------------------------

    // clase oyente para el boton mostrar,aqui usamos la funcion que hicimos en
    // LaminaDialogos, lo podemos usar aqui porque cuando llamamos a cada caja,estas
    // cajas sonde tipo LaminaDialogos,y esa es la clase donde tambien esta esa
    // funcion.Asi,el boton mostrar nos sacara el titulo del radio button que
    // seleccionemos.Ahora,esta clase debe ir creando los cuadros emergentes, que es
    // para lo que se hace en si este programa,para ir mostrando los cuadros de tipo
    // JOptionPane.Por ejemplo si pulsamos en el primer radio button de la primera
    // caja que es "Mensaje" pues nos debe sacar un cuadro emergente de tipo
    // showMessageDialoge. En este metodo vamos reemplazando el argumento "Mensaje"
    // de las ventanas por la funcion que nos establece el mensaje seleccionado en
    // el cuadro Mensaje,osea el metodo de arriba dameMensaje.
    private class AccionMostrar implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // System.out.println(laminaTipo.dameSeleccion());
            if (laminaTipo.dameSeleccion().equals("Mensaje")) {

                JOptionPane.showMessageDialog(MarcoDialogos.this, dameMensaje(), "Título", dameTipo(laminaTipoMensaje));

            } else if (laminaTipo.dameSeleccion().equals("Confirmar")) {

                JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(), "Título", dameTipo(laminaConfirmar),
                        dameTipo(laminaTipoMensaje));

            } else if (laminaTipo.dameSeleccion().equals("Opción")) {

                JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(), "Título", 1,
                        dameTipo(laminaTipoMensaje), null, dameOpciones(laminaOpcion),
                        null);

            } else if (laminaTipo.dameSeleccion().equals("Entrada")) {

                if (laminaEntrada.dameSeleccion().equals("Campo de texto")) {

                    JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Título",
                            dameTipo(laminaTipoMensaje));
                } else {

                    JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Título",
                            dameTipo(laminaTipoMensaje), null, new String[] { "Amarillo", "Azul", "Rojo" }, "Azul");

                }

            }

        }
    }

}

// ---------------------------------------------------------------

// clase para la lamina que se guarda en la variable componenteMensaje y que
// mostrara esa lamina si se da click en la opción componente de la caja
// Mensaje, esta lamina tendra un rectangulo amarillo que sera el que se
// muestre,para esto sobreescribimos el metodo paintComponent.
class LaminaEjemplo extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // aqui se hace el casting de graphics a graphics2d
        Graphics2D g2 = (Graphics2D) g;

        // creamos el rectangulo y lo pintamos de amarillo
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.YELLOW);
        g2.fill(rectangulo);
    }

}
