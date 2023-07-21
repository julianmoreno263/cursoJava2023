/*(v206) vamos a hacer una practica guiada de una app que consulte a la bd por medio de jdbc, podremos escoger en la gui la seccion a la que queremos consultar , el pais o ambas y nos mostrara en el area de texto los resultados de esa consulta,el profe nos da el codigo de la gui con swing.

1- primero vamos a hacer que los comboBox de la seccion y pais se llenen automaticamente con los campos que esten en la tabla,asi si mas adelante se agrega un campo o se elimina,esto se vera reflejado automaticamente en la app.Entonces para comenzar a hacer esto lo primero es crear en el constructor del Marco la conexion a la bd con su try-catch.

2- en la consulta sql,debemos usar el predicado "distinctrow" para que solo carge las secciones que son diferentes,osea no repita secciones,si no ponemos esto la consulta traera todo lo que esta en el campo seccion,y como hay 42 registros y hay secciones repetidas pues nos traera todas esas secciones repetidas y solo necesitamos llenar el comboBox con una seccion de cada una,para esto se usa el "distinctrow".(investigar sql).

--------------------------------------------------
(v208) ahora vamos a crear la consulta preparada con el simbolo ? para que se puedan pasar la seccion y el pais como parametros y asi nos arroje los resultados en el area de texto.

1- creo variables de tipo PreparedStatement donde almacenaremos el objeto de tipo PreparedStatement que establece el parametro de la consulta utilizando los metodos de esta interfaz,osea aqui se almacenara la consulta sql.

2- creo a la vez variables de tipo final para que no puedan ser manipuladas o cambiadas para las consultas sql.

3- la consulta debe ejecutarse cuando se pulse el boton,entonces debemos ponerlo a la escucha de un evento,el profe crea primero un metodo que sera el que ejecute la consulta y cuando se pulse el boton se llamara a ese metodo,y despues ponemos el boton a la escucha del evento.

--------------------------------------------------------------
(v208) ahora, vamos a hacer que con el mismo boton se puedan realizar las consultas ya sea solo de seccion,o solo de pais o de ambas,para evaluar esto,puedo utilizar el texto que se le dio acada comboBox, si se eligio algo en el comboBox con el texto "sección" quiere decir que ese texto no aparece seleccionado,porque se le selecciono una seccion como deporte,ferreteria,etc,entonces ese comboBox se esta usando porque se evalua que se eligio algo diferente al texto "sección" y asi sabremos que se esta usando ese comboBox, lo mismo para el otro de pais,y se puede evaluar igual si se estan usando ambos.

-------------------------------------------------------
(v209) el profe hace un video corto para corregir errores que el tuvo por copiar y pegar codigo.Hasta aqui la app ya funciona pero mas adelante la retomamos para mejorarle cosas.

 */

package src.conectaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AplicacionConsulta {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame mimarco = new MarcoAplicacion();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class MarcoAplicacion extends JFrame {

    private Connection miConexion;

    private JComboBox secciones;

    private JComboBox paises;

    private JTextArea resultado;

    private PreparedStatement enviaConsultaSeccion;

    private PreparedStatement enviaConsultaPais;

    private PreparedStatement enviaConsultaPaisSecc;

    private final String sqlSeccion = "select nombrearticulo,seccion,precio,paisdeorigen from productos where seccion=?";

    private final String sqlPais = "select nombrearticulo,seccion,precio,paisdeorigen from productos where paisdeorigen=?";

    private final String sqlPaisSecc = "select nombrearticulo,seccion,precio,paisdeorigen from productos where seccion=? and paisdeorigen=?";

    public MarcoAplicacion() {

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

        // aqui creamos el boton,lo ponemos a la escucha del evento click para que
        // ejecute el metodo ejecutaConsulta() y lo agregamos a la lamina.
        JButton botonConsulta = new JButton("Consulta");
        botonConsulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutaConsulta();
            }

        });

        add(botonConsulta, BorderLayout.SOUTH);

        // ----------------------------------------------

        try {
            // 1- conexion a la bd
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // 2- statement
            Statement miStatement = miConexion.createStatement();

            // 3- consulta sql para la seccion
            String sql = "select distinctrow seccion from productos ";

            // 4-resultset
            ResultSet miResulset = miStatement.executeQuery(sql);

            // 5-recorrer resultset e incluirlo en el comboBox correspondiente
            while (miResulset.next()) {

                secciones.addItem(miResulset.getString("seccion"));
            }

            // 6-cerramos el resultset
            miResulset.close();

            // ----------------------------------------------
            // creamos el codigo para llenar el comboBox de pais,podemos usar las variables
            // anteriores,sin necesidad de declararlas de nuevo.

            // 1- consulta sql para los paises
            sql = "select distinctrow paisdeorigen from productos ";

            // 2-resultset
            miResulset = miStatement.executeQuery(sql);

            // 3-recorrer resultset e incluirlo en el comboBox correspondiente
            while (miResulset.next()) {

                paises.addItem(miResulset.getString("paisdeorigen"));
            }

            // 4-cerramos el resultset
            miResulset.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No conecta la BD");
            e.printStackTrace();
        }

    }

    // metodo que ejecuta la consulta
    public void ejecutaConsulta() {

        // 1- creamos un resultset
        ResultSet rs = null;

        try {

            // esta linea resetea el textArea, asi cada vez que se haga una consulta el area
            // estara en blanco y solo muestra los resultados de esa consulta y no los suma
            // con los anteriores
            resultado.setText("");

            // 2- capturo lo que el usuario eligio en el comboBox,como esto devuelve un
            // Object debemos castear a String
            String seccion = (String) secciones.getSelectedItem();
            String pais = (String) paises.getSelectedItem();

            // evaluo si se esta escogiendo el comboBox de seccion,pais o ambos segun su
            // texto
            if (!seccion.equals("Sección") && pais.equals("País")) {

                // 3-uso la variable PreparedStatement que cree para crear objeto statement,debo
                // usar la conexion y el metodo preparedStatement() al que le paso la consulta
                // parametrizada sql.
                enviaConsultaSeccion = miConexion.prepareStatement(sqlSeccion);

                // 4-le paso por parametro lo que el usuario escogio en el comboBox a esta
                // consulta preparada,con setString(1,seccion), el 1 es el numero del
                // parametro("?"),como la consulta solo tiene un ? pues se le pone 1 porque es
                // el unico.
                enviaConsultaSeccion.setString(1, seccion);

                // 5- ejecutamos la consulta y estos resultados se almacenan en el objeto
                // resultset
                rs = enviaConsultaSeccion.executeQuery();

            } else if (seccion.equals("Sección") && !pais.equals("País")) {

                enviaConsultaPais = miConexion.prepareStatement(sqlPais);

                enviaConsultaPais.setString(1, pais);

                rs = enviaConsultaPais.executeQuery();
            } else if (!seccion.equals("Sección") && !pais.equals("País")) {

                enviaConsultaPaisSecc = miConexion.prepareStatement(sqlPaisSecc);

                enviaConsultaPaisSecc.setString(1, seccion);
                enviaConsultaPaisSecc.setString(2, pais);

                rs = enviaConsultaPaisSecc.executeQuery();

            }

            // 6-recorremos el resultset y lo mostramos en el text area,con append() se va a
            // gregando a un JTextArea.
            while (rs.next()) {

                resultado.append(rs.getString("nombrearticulo"));
                resultado.append(", ");
                resultado.append(rs.getString("seccion"));
                resultado.append(", ");
                resultado.append(rs.getString("precio"));
                resultado.append(", ");
                resultado.append(rs.getString("paisdeorigen"));
                resultado.append("\n");

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
