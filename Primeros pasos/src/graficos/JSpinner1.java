
/*(v98) vamos a trabajar con elementos de tipo spinner,estos son cuadros de texto pero con botones de aumentar o disminuir, para trabajar con estos elementos debemos usar la clase JSpinner, esta tiene varios constructores,el por defecto crea un spinner normal y hay un contructor que pide un modelo de spinner(osea debemos indicarle que tipo de spinner vamos a usar,puede ser de tipo fechas,o valores de texto,etc).

Si por ejemplo queremos crear un spinner para fechas, debemos usar el constructor que nos pide un objeto de tipo SpinnerModel, y concretamente para los spinner de tipo fecha usamos la clase SpinnerDateModel.(ver API).

Tambien se puede crear un spinner para manipular texto con el modelo de la clase SpinnerListModel,el cual tiene un contructor que pide un array de tipo String,pues manipulara cadenas.(ver API).

Para cambiar el tamaño por defecto de un spinner(que es pequeño por defecto),utilizamos el metodo setPreferredSize(Dimension) el cual la clase JSpinner lo hereda de la clase JComponent,este metodo pide un objeto de tipo Dimension.(ver API).

1- creamos el objeto de tipo dimension,con el constructor que admite un ancho y un alto.
2- establecemos ese tamaño en nuestro objeto spinner con setPreferedSize().


Para el modelo de tipo list,podemos hace runa lista que nos traiga todas las fuentes instaladas en el pc,para eso podemos usar la clase GraphicsEnvironment y con el metodo getLocalGraphicsEnvironment y getAvalaibleFontFamilyNames nos traemos todas esas fuentes.

Con la clase SpinnerNumberModel podemos hacer el spinner numerico pero podemos especificar de donde a donde iran los numeros y de cuanto en cuanto van ascendiendo o descendiendo.

-----------------------------------------------------------------
(v99) podemos cambiar el comportamiento que tienen por defecto los botones d eincrementar y disminuir de los spinner de java,osea,que el boton de subir lo que haga es disminuir y el de bajar aumente,para esto java no tiene una clase o funcion especifica,por lo que debemos crear nuestra propia clase interna.Como en principio vamos a hacer un spinner de numeros,entonces esta clase debera heredar de SpinnerNumberModel para aprovechar las caracteristcas de esta clase.

Esta clase SpinnerNumberModel tiene dos metodos,getNextValue y getPreviousValue que me captura los valores del spinner, como estos metodos son heredados,los podemos sobreescribir para hacer que se comporten como necesitamos.Estos metodos nos devuelven un objeto de tipo Object,entonces al sobreescribirlos les indicamos que lo que devolveran sera un Object,y dentro del metodo le indicamos llamando al contructor padre que nos retorne el metodo contrario,osea en el next que nos devuelva el previo,y asi con el otro.

____________________________________________________________________________

clases internas anonimas, son clases internas pero sin nombre,es utilizar la clase que queremos instanciar,pero al poner new JSpinner(), dentro de los parametros instanciamos de una vez el objeto de la clase que vamos a usar y creamos alli mismo el codigo,esto ahorra codigo.

*/

package graficos;

import java.awt.*;
import javax.swing.*;

public class JSpinner1 {
    public static void main(String[] args) {

        MarcoSpinner miMarco = new MarcoSpinner();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoSpinner extends JFrame {

    public MarcoSpinner() {
        setTitle("JSpinner");
        setBounds(300, 250, 550, 350);

        LaminaSpinner miLamina = new LaminaSpinner();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaSpinner extends JPanel {

    public LaminaSpinner() {

        // array para la lista,asi nos traemos todas las fuentes instaladas en nuestro
        // pc.
        // String lista[] =
        // GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        // spinner de tipo number,especificamos en donde comienza,el valor minimo,el
        // maximo y va de uno en uno
        // JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));

        // aqui utilizamos nuestra clase interna para instanciar un objeto de tipo
        // MiModeloSpinner y crear el spinner de una vez
        // JSpinner control = new JSpinner(new MiModeloSpinner());

        // clase interna anonima,ahorra codigo,la clase interna es SpinnerNumberModel
        // que esta dentro de JSpinner.
        JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) {

            // sobreescribimos los metodos heredados
            public Object getNextValue() {

                return super.getPreviousValue();
            }

            public Object getPreviousValue() {

                return super.getNextValue();
            }
        });

        // objeto dimension para poder cambiar el tamaño del spinner
        Dimension d = new Dimension(200, 20);
        control.setPreferredSize(d);

        add(control);
    }

    // clase interna para cambiar el comportamiento por defecto de los botones del
    // spinner(invertir el comportamiento)
    // private class MiModeloSpinner extends SpinnerNumberModel {

    // public MiModeloSpinner() {

    // // llamamos al constructor padre
    // super(5, 0, 10, 1);

    // }

    // // sobreescribimos los metodos heredados
    // public Object getNextValue() {

    // return super.getPreviousValue();
    // }

    // public Object getPreviousValue() {

    // return super.getNextValue();
    // }
    // }
}