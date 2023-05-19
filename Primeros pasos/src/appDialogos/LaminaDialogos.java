/* esta clase sera para la lamina que contendra las cajas tipo Boxlayout, el constructor  recibira dos argumentos String,uno para el titulo de la caja y otro sera un array de string para las opciones de los radiobuttons.

1- para crear un borde en una caja o contenedor, hay una clase BorderFactory la cual tiene varios metodos,entre ellos el metodo createTitleBorder(de estos hay varios,hay sobrecarga de metodos), entre estos hay uno con dos argumentos,uno para el tipo de borde y otro para el titulo,el tipo de borde lo podemos establecer con el metodo createEtchetBorder el cual crea un borde con la misma apariencia del contenedor, estos metodos para el tipo de borde tambien estan en la misma clase BorderFactory(los que estan en la parte de arriba en la API).

2- entonces para crear un borde usamos el metodo de jpanel setBorder y dentro de el usamos BorderFactory y el metodo createTitleBorder.

3- para crear las cajas debemos indicarle a la lamina que tendra un layout de tipo BoxLayout, la clase BoxLayout tiene una constante llamada Y_AXIS la cual le indica a la caja que los elementos que pongamos en ella se colocaran verticalmente,esto nos sirve porque los radiobuttons que creemos en las cajas seran verticales y si redimensionamos ellos se adapataran automaticamente.

-------------------------------------------------------------
(v126) ya creada la parte grafica,vamos a comenzar a dar funcionaliodad,comenzamos con el boton de mostrar,para que cuando lo pulsemos nos saque la opcion seleccionada de las cajas.Para esto hacemos una funcion aqui en la lamina que crea las cajas con los botones.Esta funcion sera de tipo String porque debe devolverme los strings que haya en las cajas.
*/

package appDialogos;

import javax.swing.*;
import java.awt.*;

// lamina
class LaminaDialogos extends JPanel {

    private ButtonGroup grupo;

    public LaminaDialogos(String titulo, String opciones[]) {

        // creamos borde para las cajas
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));

        // establecemos el layout,el contenedor es this(la propia clase LaminaDialogos)
        // y los elementos se pondran verticalmente
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // creamos el grupo para los radiobuttons,asi solo se puede seleccionar uno
        grupo = new ButtonGroup();

        // aqui vamos creando los radio buttons que van en la caja usando el array de
        // strings para poner el titulo de cada radio button dependiendo lo que le
        // pasemos a esa caja en el argumento array opciones[], y se agrega a la lamina
        // y por ultimo al grupo.Despues le digo que deje seleccionado el radio button
        // con posicion 0 del array.
        for (int i = 0; i < opciones.length; i++) {

            JRadioButton bot = new JRadioButton(opciones[i]);

            // aqui creamos la accion de comando para el boton,con el metodo
            // setActionCommand, este metodo lo hereda la clase JRadioButton,y este metodo
            // pide un String para darle un nombre a esa accion,entonces como string le
            // pasamos el array de stringcon el indice que este en ese momento.(ver API.)
            bot.setActionCommand(opciones[i]);

            add(bot);
            grupo.add(bot);
            bot.setSelected(i == 0);
        }
    }

    // funcion que devuelve los strings(titulos de radio buttons) de las cajas, como
    // los botones estan agrupados, la clase ButtonGroup tiene un metodo
    // getSelection() el cual me devuelve el boton seleccionado,devuelve un objeto
    // de tipo ButtonModel,y ButtonModel es una interfaz la cual entre sus metodos
    // tiene uno llamado getActionCommand que devuelve un String que es lo que
    // necesitamos que devuelva(osea nos de el titulo del boton seleccionado.(ver
    // API).
    public String dameSeleccion() {

        // primero creo un objeto de tipo ButtonModel porque como usare getSelection (de
        // la clase ButtonGroup,la cual ya esta instanciada con el objeto "grupo")y esta
        // funcion devuelve un objeto de ese tipo entonces lo creo.

        // ButtonModel miBoton = grupo.getSelection();

        // ahora, como esta funcion lo que debe devolver es un string, creo un objeto de
        // tipo String para usar el metodo de getActionCommand de la interfaz
        // ButtonModel,y este metodo si devuelve un string que es el titulo del boton
        // que este seleccionado.

        // String s = miBoton.getActionCommand();

        // estas lineas se pueden simplificar en una sola asi:
        return grupo.getSelection().getActionCommand();

    }
}
