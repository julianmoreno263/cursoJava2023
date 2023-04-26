/*(v74) vamos a ver eventos de focus, cuando un elemento tiene el focus o no,podemos usar la interfaz FocusListener que solo tiene dos metodos para poder manejar si un elemento tiene el focus o lo perdio.Tambien hay una clase adapatadora para utilizarla en vez de la interfaz si queremos,se llama FocusAdapter.Pero esta interface es para elementos en general,como botones,fromularios,etc, para manejar el foco de las ventanas toca usar la interfaz WindowFocusListener o su clase adaptadora WindowAdapter.

Vamos a crear dos cuadros de texto JTextField para manejar el foco entre ellos, para eso primero invalidamos el layout por defecto que java le da a los elementos en una ventana,el layout es la posicion que toman los elementos en la ventana,y en java por defecto los pone en la parte de arriba y centrados.Para invalidar el layout se utiliza el metodo setLayout(null) y asi ya puedo ubicar los elementos donde yo quiera.

Para crear los cuadros de textos utilizo la clase JTextField(ver API), esta clase tiene sobrecarga de constructores.

NOTA: LAS VARIABLES CUADRO1 Y CUADRO2 PARA GUARDAR LOS OBJETOS TIPO JTEXTFIELD LAS DECLARAMOS PRIMERO FUERA DEL METODO PAINTCOMPONENT PORQUE DESPUES VOY A TENER QUE USARLAS FUERA DE ESTE METODO PERO EN LA MISMA CLASE,SI LAS DECLARO DENTRO DE PAINTCOMPONENT Y CREO LAS INSTANCIAS AL TIEMPO DESPUES NO PODRIA USARLAS FUERA DE ESE METODO, DE ESTA FORMA QUEDAN COMO VARIABLES DE CLASE.

puedo usar setBounds tambien con elementos,para posicionar los cuadros de texto lo puedo utilizar,porque como puse null el layout ahora debo posisiconar estos cuadros.

La clase oyente LanzaFocus debe ser clase interna de LaminaFocus para que pueda acceder a los objetos de cuadro1 y cuadro2.Ahora ya puedo crear un objeto de esta clase oyente y utilizarlo dentro de los metodos de la interfaz FocusListener junto a los objetos creados para asi determinar cual objeto tiene el foco, poniendolos a la escucha con addFocusListener.

-------------------------------------------------------------------
(v75) vamos a completar este ejercicio validando una direccion de email, esta direccion la escribimos en el primer cuadro y cuando pasemos al segundo cuadro de texto(osea cuando este cuadro1 pierda el foco) nos dira si la direccion es correcta o no, asi que programamos el codigo dentro del metodo focusLost().Para evaluar el email,creamos un bucle for que vaya recorriendo el email y evalue con el metodo charAt() si hay una arroba en la cadena d estring,si la hay pasara una variable booleana a true.

NOTA: PARA QUE SE TOME EL @ COMO UN CARACTER TOCA PONERLO ENTRE COMILLAS SIMPLES,SI LO PONGO ENTRE COMILLAS DOBLES LO TOMA COMO UNA CADENA Y SALE UN ERROR DE COMPARACION DE TIPOS,PORQUE NO SE PUEDE COMPARAR UN STRING CON UN CARACTER, TOCA VALIDAR ASI:  if (email.charAt(i) == '@')


 */

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eventos7 {
    public static void main(String[] args) {

        MarcoEventos7 miMarco = new MarcoEventos7();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// marco
class MarcoEventos7 extends JFrame {

    public MarcoEventos7() {

        setVisible(true);
        setBounds(450, 300, 600, 450);

        add(new LaminaFoco());

    }

}

// lamina
class LaminaFoco extends JPanel {

    // variables para los cuadros de texto
    JTextField cuadro1;
    JTextField cuadro2;

    // sobreescribimos el metodo paintComponent
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        setLayout(null);

        // creamos los dos cuadros de texto
        cuadro1 = new JTextField();
        cuadro2 = new JTextField();

        cuadro1.setBounds(180, 10, 150, 20);
        cuadro2.setBounds(180, 50, 150, 20);

        // los agrego a la lamina
        add(cuadro1);
        add(cuadro2);

        // creo objeto oyente para el foco
        LanzaFocus elFoco = new LanzaFocus();
        cuadro1.addFocusListener(elFoco);
        cuadro2.addFocusListener(elFoco);

    }

    // clase oyente sera interna para que pueda acceder a los campos cuadro1 y
    // cuadro2
    class LanzaFocus implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("He ganado el foco!");
        }

        @Override
        public void focusLost(FocusEvent e) {

            boolean comprobacion = false;
            String email = cuadro1.getText();

            for (int i = 0; i < email.length(); i++) {

                if (email.charAt(i) == '@') {

                    comprobacion = true;
                }
            }

            if (comprobacion) {
                System.out.println("Email correcto!");
            } else {
                System.out.println("Email incorrecto!");
            }
        }

    }
}
