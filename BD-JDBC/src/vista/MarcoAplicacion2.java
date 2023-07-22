package src.vista;

import java.awt.*;
import javax.swing.*;

import src.controlador.*;

public class MarcoAplicacion2 extends JFrame {

    public JComboBox secciones;

    public JComboBox paises;

    public JTextArea resultado;

    private final String sqlSeccion = "select nombrearticulo,seccion,precio,paisdeorigen from productos where seccion=?";

    private final String sqlPais = "select nombrearticulo,seccion,precio,paisdeorigen from productos where paisdeorigen=?";

    private final String sqlPaisSecc = "select nombrearticulo,seccion,precio,paisdeorigen from productos where seccion=? and paisdeorigen=?";

    public MarcoAplicacion2() {

        setTitle("Consulta BBDD");

        setBounds(500, 300, 400, 400);

        setLayout(new BorderLayout());

        JPanel menus = new JPanel();

        menus.setLayout(new FlowLayout());

        secciones = new JComboBox();

        secciones.setEditable(false);

        secciones.addItem("Sección");

        paises = new JComboBox();

        paises.setEditable(false);

        paises.addItem("País");

        resultado = new JTextArea(4, 50);

        resultado.setEditable(false);

        add(resultado);

        menus.add(secciones);

        menus.add(paises);

        add(menus, BorderLayout.NORTH);

        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta = new JButton("Consulta");

        add(botonConsulta, BorderLayout.SOUTH);

        // aqui ponemos al boton a la escucha del evento click el cual llamara al
        // controlador ControladorBotonEjecuta y este a la vez ejecuta las consultas del
        // modelo, se le pasa el propio marco por parametro.
        botonConsulta.addActionListener(new ControladorBotonEjecuta(this));

        // aqui ponemos este marco a la escucha del evento de tipo ventana para que
        // apenas abra la app cargen los datos en el comboBox de seccion y pais
        addWindowListener(new ControladorCargaMenus(this));
    }
}