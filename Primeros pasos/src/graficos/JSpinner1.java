
/*(v98) vamos a trabajar con elementos de tipo spinner,estos son cuadros de texto pero con botones de aumentar o disminuir, para trabajar con estos elementos debemos usar la clase JSpinner, esta tiene varios constructores,el por defecto crea un spinner normal y hay un contructor que pide un modelo de spinner(osea debemos indicarle que tipo de spinner vamos a usar,puede ser de tipo fechas,o valores de texto,etc).

Si por ejemplo queremos crear un spinner para fechas, debemos usar el constructor que nos pide un objeto de tipo SpinnerModel, y concretamente para los spinner de tipo fecha usamos la clase SpinnerDateModel.(ver API).

Tambien se puede crear un spinner para manipular texto con el modelo de la clase SpinnerListModel,el cual tiene un contructor que pide un array de tipo String,pues manipulara cadenas.(ver API).

Para cambiar el tamaño por defecto de un spinner(que es pequeño por defecto),utilizamos el metodo setPreferredSize(Dimension) el cual la clase JSpinner lo hereda de la clase JComponent,este metodo pide un objeto de tipo Dimension.(ver API).

1- creamos el objeto de tipo dimension,con el constructor que admite un ancho y un alto.
2- establecemos ese tamaño en nuestro objeto spinner con setPreferedSize().


Para el modelo de tipo list,podemos hace runa lista que nos traiga todas las fuentes instaladas en el pc,para eso podemos usar la clase GraphicsEnvironment y con el metodo getLocalGraphicsEnvironment y getAvalaibleFontFamilyNames nos traemos todas esas fuentes.

Con la clase SpinnerNumberModel podemos hacer el spinner numerico pero podemos especificar de donde a donde iran los numeros y de cuanto en cuanto van ascendiendo o descendiendo.

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
        JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));

        // objeto dimension para poder cambiar el tamaño del spinner
        Dimension d = new Dimension(200, 20);
        control.setPreferredSize(d);

        add(control);
    }
}