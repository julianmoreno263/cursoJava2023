/*aqui en el marco ya le di layout tipo grid, ahora, con la clase creada de LaminaDialogos que es la que crea las cajas con los botones,aqui en el marco comienzo a instanciar esa clase para ir creando las cajas,como esa clase necesita en su constructor un array con los strings que llevaran los radio buttons pues creo primero esos arrays y despues instancio las cajas. 

A medida que vayamos creando las cajas,como el marco tiene disposicion gridLayout estas se van acomodando automaticamente.

(v126), ya creamos en el archivo de la lamina una funcion que le dara funcionalidad al boton de mostrar,esta funcion se encargara de mostrar el titulo del radio boton seleccionado,ahora aqui debemos poner nuestro boton de "Mostrar" a la escucha de un evento. 
*/

package appDialogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// frame
class MarcoDialogos extends JFrame {

    // variables para objetos de caja Tipo
    private LaminaDialogos laminaTipo, laminaTipoMensaje, laminaMensaje, laminaConfirmar, laminaOpcion, laminaEntrada;

    // variables para objetos de caja Mensaje
    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("Primeros pasos/src/appDialogos/img/cuadro_azul.png");
    private Object objetoMensaje = new Date();
    private Component componentMensaje = new LaminaEjemplo();

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
        String arrayOpcion[] = { "Strin[]", "Icon[]", "Object[]" };
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

    // clase oyente para el boton mostrar,aqui usamos la funcion que hicimos en
    // LaminaDialogos, lo podemos usar aqui porque cuando llamamos a cada caja,estas
    // cajas sonde tipo LaminaDialogos,y esa es la clase donde tambien esta esa
    // funcion.Asi,el boton mostrar nos sacara el titulo del radio button que
    // seleccionemos.Ahora,esta clase debe ir creando los cuadros emergentes, que es
    // para lo que se hace en si este programa,para ir mostrando los cuadros de tipo
    // JOptionPane.Por ejemplo si pulsamos en el primer radio button de la primera
    // caja que es "Mensaje" pues nos debe sacar un cuadro emergente de tipo
    // showMessageDialoge.
    private class AccionMostrar implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // System.out.println(laminaTipo.dameSeleccion());
            if (laminaTipo.dameSeleccion().equals("Mensaje")) {

                JOptionPane.showConfirmDialog(MarcoDialogos.this, "Mensaje", "Título", 0);

            } else if (laminaTipo.dameSeleccion().equals("Confirmar")) {

                JOptionPane.showConfirmDialog(MarcoDialogos.this, "Confirmar", "Título", 0, 0);

            } else if (laminaTipo.dameSeleccion().equals("Opción")) {

                JOptionPane.showOptionDialog(MarcoDialogos.this, "Opción", "Título", 0, 0, null, null, null);

            } else if (laminaTipo.dameSeleccion().equals("Entrada")) {

                JOptionPane.showInputDialog(MarcoDialogos.this, "Entrada", "Título", 0);
            }

        }
    }

}