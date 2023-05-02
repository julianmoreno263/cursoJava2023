/*(v80) vamos a ver como tener una fuente y varios oyentes, por ejemplo  creamos una ventana con dos botones,un boton sera "nuevo" y el otro "cerrar", cuando demos click en nuevo se creara una nueva ventana, podemos crear el numero de ventanas que queramos,y si le damos cerrar,se cerraran todas las ventanas a la vez,este sera en si el efecto que queremos ver,que cuando le demos cerrar(osea una sola fuente de evento) se cierren todas las ventanas(multiples oyentes).

El boton de cerrar lo creo fuera del constructor de la lamina porque despues lo voy a tener que utilizar dentro de otors metodos de esa misma clase,por eso no debe pertenecer a un metodo en particular sino a la propia clase.


ahora,debemos hacer que el boton nuevo sea fuente de evento y debemos crear una clase que sea la clase oyente,para esto debemos utilizar el concepto de clases internas.Entonces dentro de la clase de la lamina creamos la clase oyente que implementara la interfaz ActionListener.Cuando se cree un objeto oyente,lo que pasara es que llamara al constructor de la clase que crea nuevas ventanas y nos creara esas ventanas nuevas.

Para decirle a java que el boton sera una fuente de evento,lo que hacemos es crear un objeto de la clase oyente en el constructor de la lamina y al boton decirle que use el metodo addActionListener y pasarle como parametro ese objeto oyente.

--------------------------------------------------------------------
Listo hasta aqui, ahora lo que nos interesa es que al abrir varias ventanas,osea multiples oyentes,las podamos cerrar todas a la vez con el unico boton de cerrar,osea con una sola fuente.Para esto,se crea una clase oyente que sera clase interna de la clase que construye las nuevas ventanas,osea la clase MarcoEmergente,porque lo que quiero cerrar son precisamente esas ventanas nuevas que se crearon.Para esto se usa el metodo dispose() el cual lo hereda la clase JFrame de la clase Window(ver API).Este metodo dispose lo que hace es liberar todos los recursos de las ventanas creadas.

Ahora,como el boton de cerrar es la fuente, y este boton esta en una clase diferente a la que crea los marcos nuevos,le pasamos por parametro al constructor de la clase MarcoEmergente ese boton,porque este boton debemos usarlo en la clase MarcoEmergente pues es la fuente del evento la cual debera implementarse con la clase oyente del evento,que es la clase interna CierraTodo.Asi pasando por parametro el objeto boton cerrar podemos usarlo en una clase diferente a la que se creo.

Entonces al pasarle ese parametro al constructor de MarcoEmergente, al crear un objeto de esa clase debo pasarle ese parametro obligatoriamente,y hay es donde paso el botonCerrar,cuando creo un objeto de esa clase.En si, hay estoy teniendo una referencia del botonCerrar en la clase MarcoEmergente,no le estoy creando un boton de cerrar a cada ventana nueva,solo pongo la referencia para poder usar ese botonCerrar como fuente del evento y que el objeto oyente(un objeto de la clase CierraTodo) lo pueda usar. Listo,aqui ya tenemos una sola fuente y multiples oyentes(ventanas) de un evento.

NOTA: ME SALIA UN ERROR CON EL JBUTTON DE CERRAR,ERA PORQUE ESTA VARIABLE DE  JButton botonCerrar; YA LA HABIA DECLARADO,Y EN LINEAS MAS ABAJO LA USE PERO PUSE DE NUEVO EL TIPO JButton, Y POR ESO ME APARECIA EL ERROR,SIMPLEMENTE EN LA LINEA DONDE USO ESA VARIABLE LE QUITE EL JButton,PORQUE YA NO LO NECESITA,YA LA HABIA DECLARADO DE ESE TIPO. 



 */

package graficos;

import javax.swing.*;
import java.awt.event.*;

public class Eventos10 {
    public static void main(String[] args) {

        MarcoEventos10 miMarco = new MarcoEventos10();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// marco
class MarcoEventos10 extends JFrame {

    public MarcoEventos10() {
        setTitle("Multiples oyentes");
        setBounds(600, 100, 300, 200);

        LaminaPrincipal miLamina = new LaminaPrincipal();
        add(miLamina);
    }

}

// lamina
class LaminaPrincipal extends JPanel {

    JButton botonCerrar;

    public LaminaPrincipal() {

        JButton botonNuevo = new JButton("Nuevo");
        add(botonNuevo);

        botonCerrar = new JButton("Cerrar Todo");
        add(botonCerrar);

        // pongo el boton nuevo como fuente de evento
        OyenteNuevo miOyente = new OyenteNuevo();
        botonNuevo.addActionListener(miOyente);
    }

    // clase interna oyente
    class OyenteNuevo implements java.awt.event.ActionListener {

        public void actionPerformed(ActionEvent e) {

            MarcoEmergente marco = new MarcoEmergente(botonCerrar);
            marco.setVisible(true);
        }
    }
}

// clase para crear las nuevas ventanas,la variable contador debera ser static
// para poder ser compartida por todas las ventanas que se creen,ademas la
// ponemos private.Ademas utilizamos este contador para darles posiciones
// diferentes a cada nueva ventana.Como aqui debo usar la fuente que sera el
// botonCerrar que e sta en otra clase,creo un parametro de tipo JButton para
// hacer referencia a ese boton y poder usarlo en esta clase.
class MarcoEmergente extends JFrame {

    private static int contador = 0;

    public MarcoEmergente(JButton botonDeCerrar) {

        contador++;

        setTitle("Ventana " + contador);
        setBounds(40 * contador, 40 * contador, 300, 200);

        // creo objeto oyente y lo pongo a la escucha del evento,el cual lo desencadena
        // el boton cerrarTodo,este lo referencio al pasarlo como parametro del
        // constructor de esta clase.
        CierraTodo oyenteCerrar = new CierraTodo();
        botonDeCerrar.addActionListener(oyenteCerrar);

    }

    // clase interna oyente que cierra las ventanas creadas cuando se de click en el
    // boton cerrar todo
    class CierraTodo implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            dispose();
            contador = 0;// reseteamos el contador
        }

    }
}
