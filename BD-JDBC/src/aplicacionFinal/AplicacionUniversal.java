package aplicacionFinal;

import java.awt.*;

import javax.swing.*;
import java.sql.*;

/*(v224) vamos a hacer una aplicacion para terminar con la parte de jdbc, esta app lo que ahar sera traernos la informacion de la bd que elijamos,las que tenemos creadas en wampserver,la app debera usar streams de datos para poder conectar a un archivo txt externo donde estaran los datos de conexion a la bd,si cambiamos ese archivo externo en la parte del nombre de la bd a utilizar,la aplicacion debera ser capaz de leer ese archivo y utilizar la bd que se le indique.Tambien deberemos usar jdbc para conectar con la bd que elijamos y usar metadatos para leer la informacion de la bd,sus tablas y contenido,etc.Por eso esta aplicacion sera generica,osea no importa que tipo o bd se utilice debera ser capaz de leer los metadatos de dicha bd.El profe nos da el codigo del swing para la interfaz grafica que es muy sencillo.todo lo haremos en un unico archivo. */

public class AplicacionUniversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBBDD mimarco = new MarcoBBDD();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame {

	public MarcoBBDD() {

		setBounds(300, 300, 700, 700);

		LaminaBBDD milamina = new LaminaBBDD();

		add(milamina);

	}

}

class LaminaBBDD extends JPanel {

	private JComboBox comboTablas;
	private JTextArea areaInformacion;
	private Connection miConexion;

	public LaminaBBDD() {

		setLayout(new BorderLayout());

		comboTablas = new JComboBox();

		areaInformacion = new JTextArea();

		add(areaInformacion, BorderLayout.CENTER);

		add(comboTablas, BorderLayout.NORTH);

		// llamamos los metodos para la conexion y para cargar el combobox
		conectarBD();
		obtenerTablas();

	}

	// metodo para crear la conexion
	public void conectarBD() {

		miConexion = null;

		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// metodo para cargar el combobox al conectar la bd,apenas se abra la app debe
	// conectarse con la bd y cargar el combo box con las tablas de esa bd elegida
	public void obtenerTablas() {

		ResultSet miResultset = null;

		try {

			DatabaseMetaData datosBD = miConexion.getMetaData();

			miResultset = datosBD.getTables("pruebas", null, null, null);

			while (miResultset.next()) {

				comboTablas.addItem(miResultset.getString("TABLE_NAME"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
