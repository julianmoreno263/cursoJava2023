/*(v91) haremos otro ejercicio para manejar las areas de texto.Crearemos un area en la parte central del marco y en la parte de abajo creamos dos botones,uno al darle click pondra un texto y el otro al dar click pondra o quitara saltos de linea.

En este ejercicio el que tendra el layout de border layout sera el marco,y en su zona central le agregamos una lamina y en la zona sur otra para los botones.

NOTA IMPORTANTE: EL PROFESOR EN ESTE EJERCICIO CREA TODO EN UNA SOLA CLASE,LA CLASE DEL MARCO PARA MOSTRAR QUE SE PUEDE HACER,PERO NO ES LO ADECUADO,LO ADECUADO ES MODULARIZAR EL CODIGO, YO LO HAGO ASI EN MODULOS PARA ACOSTUMBRARME A TENER BUENAS PRACTICAS, AHORA, COMO LA CLASE OYENTE GESTIONABOTONES NECESITA USAR LA VARIABLE miArea PARA ESTABLECER UN TEXTO EN EL AREA DE TEXTO,PERO ESTA VARIABLE PERTENECE A OTRA CLASE,PARA PODER USARLA DECLARO ESA VARIABLE COMO static, ASI SIMPLEMENTE PARA USARLA EN OTRA CLASE LA LLAMO ANTEPONIENDO EL NOMBRE DE LA CLASE DONDE SE DECLARO,Y LISTO,ES MAS SENCILLO QUE PASANDO PARAMETROS ENTRE CONSTRUCTORES,AUNQUE NO QUEDARIA PRIVATE,PERO PARA ESTE EJERCICIO NOS SIRVE.

Como tengo el código,pues yo hago dos clases oyentes,una por cada boton,porque la funcionalidad es diferente.

Para el boton de salto de linea debe ser de tipo on/off, osea,si hay saltos de linea los quita cuando le demos click,y si no los hay los pone.Para esto debemos crear una variable que almacene lo contrario de lo que hay en el area de texto para los salatos de linea,osea,que almacene si hay saltos o no los hay,esto se logra usando el operador negacion y el metodo que nos captura los saltos de linea en el area d etexto getLineWrap().Despues le establecemos al area de texto estos saltos con el metodo setLineWrap().Tambien podemos evaluar segun haya saltos o no y cambiar el texto del boton. Podemos utilizar en vez de un if normal,un ternario para evaluar esto.


NOTA IMPORTANTE: PARA QUE EN LOS VIDEOS DE YOUTUBE NO ME SALGAN PROPAGANDAS LE PONGO AL FINAL DE LA URL UN PUNTO (.) Y LISTO.


*/

package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AreaTexto2 {

    public static void main(String[] args) {

        MarcoArea2 miMarco = new MarcoArea2();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

// marco
class MarcoArea2 extends JFrame {

    public MarcoArea2() {

        setTitle("Prueba de area de texto");
        setBounds(300, 250, 500, 350);

        // layout en el marco
        setLayout(new BorderLayout());

        // creo objeto de LaminaBotones y lo agrego a la zona sur del marco
        LaminaArea2 areaTexto = new LaminaArea2();
        add(areaTexto, BorderLayout.CENTER);

        // creo objeto de LaminaBotones y lo agrego a la zona sur del marco
        LaminaBotones botones = new LaminaBotones();
        add(botones, BorderLayout.SOUTH);

    }
}

// lamina botones
class LaminaBotones extends JPanel {

    static JButton saltoLinea;

    public LaminaBotones() {

        // creo boton de establecer texto y lo pongo a la escucha del evento
        JButton miTexto = new JButton("Poner Texto");
        miTexto.addActionListener(new PonerTexto());
        add(miTexto);

        // creo boton de saltar linea y lo pongo a la escucha del evento
        saltoLinea = new JButton("Salto de línea");
        saltoLinea.addActionListener(new PonerSalto());
        add(saltoLinea);

    }

}

// lamina area de texto
class LaminaArea2 extends JPanel {

    static JTextArea miArea;

    public LaminaArea2() {

        miArea = new JTextArea(20, 40);

        // nueva lamina con scroll y agregamos el area de texto
        JScrollPane laminaBarras = new JScrollPane(miArea);

        add(laminaBarras);
    }
}

// clase oyente para el boton de poner texto
class PonerTexto implements java.awt.event.ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        // evento que al dar click en el boton de poner texto agrega este texto al area
        LaminaArea2.miArea.append("En un lugar de la mancha de cuyo nombre no quiero acordarme...");
    }

}

// clase oyente para el boton de saltos de linea
class PonerSalto implements java.awt.event.ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean saltar = !LaminaArea2.miArea.getLineWrap();
        LaminaArea2.miArea.setLineWrap(saltar);

        LaminaBotones.saltoLinea.setText(saltar ? "Quitar salto!" : "Salto de línea");
    }

}