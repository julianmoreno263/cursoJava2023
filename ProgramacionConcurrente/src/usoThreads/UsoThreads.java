/*(v168) vamos a ver la programacion concurrete o por hilos(threads), en si es crear programas que sean multitarea,osea que puedan ejecutar varias tareas al mismo tiempo, hasta ahora solo hemos creado programas sencillos que son monotarea(de un unico hilo),es decir que solo ejecutan una tarea a la vez,para que ejecuten varias tareas deben esperar a que la primera termine de ejecutarse para poder ejecutar la siguiente. Para crear programas multitarea debemos usar la clase Thread y la interfaz Runnable.

Para comenzar, el profe nos dio este archivo de un programa normal que es monotarea y despues veremos como lo convertimos a multitarea.

Este programa construye un marco con dos laminas, cuando se pulse el boton de Dale saldra una pelota que rebotara por el marco cuando toque los bordes.

1- la clase Pelota se encarga de controlar el movimiento de la pelota por el marco, para eso tiene un metodo que recibe por parametro un objeto Rectangle2D que sirve para capturar el alto y ancho de la lamina.

2- la clase LaminaPelota crea la lamina donde estara la pelota rebotando y como en si son varias pelotas las que se van pintando, utilizamos PG con ArrayList para crear un array de varios objetos y almacenar alli las pelotas.

3- la clase MarcoRebote crea el marco y pone las laminas en este marco y los botones en las laminas, en el boton de Dale llama a la funcion comienza_el_juego() que en si pinta la pelota y con un for cuenta un cilco de 3000 vueltas por cada movimiento que hace la pelota.

Hasta aqui si ejecutamos el programa,por la velocidad del bucle que es de 3000, casi no se ve el movimiento de la pelota,recordar que este programa es de un unico hilo,osea monotarea.

Para que podamos ver bien el movimiento de la pelota deberiamos por cada vuelta de bucle crear una pausa en el hilo de ejecucion,para hacer una pausa en un hilo usamos la funcion sleep() la cual recibe un parametro de tipo Long que son los milisegundos que durara la pausa.

Si vemos este metodo en la API, pertenece a la clase Thread, es static(debe llamarse a la clase para usarlo),es void por lo que no devuelve nada y ademas lanza una excepcion de tipo InterrmpedException, esta excepcion hereda de Exception por lo que debemos usar el try-catch.

Listo,ya con esta pausa implementada se ve el movimiento de la pelota.

Ahora, el tema es que este programa es monotarea,solo tiene un hilo de ejecucion,por lo que hay que esperar a que la pelota termine de realizar los 3000 ciclos del bucle para poder ejecutar de nuevo el programa,osea si la pelota esta en movimiento y le doy al boton de Dale,no saldra una segunda pelota hasta que la primera termine,osea no se ejecuta un segundo hilo de ejecucion hasta que el primero acabe.Igual si intento darle Salir no me deja hasta que se termine de ejecutar el hilo, cada accion sera un hilo de ejecucion diferente.

Entonces en este programa nos conviene que sea multihilo para poder realizar varias acciones al tiempo,para crear un programa multitarea debemos realizar estos pasos:

1- Crear clase que implemente la interfaz Runnable con su metodo run()

2- escribir el codigo de la tarea dentro del metodo run(),osea el codigo del bucle for que es el que realiza la tarea.

3- instanciar la clase creada y almacenar la instancia en objeto de tipo Runnable.En este programa estos tres ultimos pasos los hago en el metodo comienza_el_juego() de la clase MarcoRebote porque este metodo es el que corre el programa.

4- crear instancia de la clase Thread y pasarle como parametro el objeto de tipo Runnable creado.

5- Poner en marcha el hilo de ejecucion con el metodo start() de la clase Thread.

Siguiendo estos pasos crearemos multiples hilos,por lo cual cada accion del programa se convierte en un hilo diferente y trabajan en simultaneo.Si ejecuto el programa y sale la primera pelota sera un primer hilo,si doy nuevamente Dale sin que se haya terminado el primer hilo me sale una segunda pelota(segundo hilo) y asi sucesivamente,tambien si doy salir se termina el programa aunque no se haya terminado de ejecutar.

-----------------------------------------------------------------------
(v169) vamos a ver como interrumpir un hilo de ejecucion, para esto debemos usar los metodos de la clase Thread  void interrupt(), boolean isInterrupted(),static boolean isInterrupted() y el metodo stop() el cual ya esta desaconsejado pero lo vemos por si lo encontramos en algun libro o tutorial antiguo.

Ahora, el metodo sleep que usamos para dar una pausa en un hilo esta preparado para lanzar una excepcion si se presenta, si nosotros pausamos con sleep() el hilo de ejecucion y tratamos de interrumpirlo con alguno de estos metodos es alli cuando el sleep lanzara la excepcion que es de tipo InterruptedException.

1- vamos a crear otro boton que sea el que me permita interrumpir el programa, esto en la clase MarcoRebote.

2- ahora, este boton llamara a un metodo detener() el cual utilizara el mismo objeto llamado hilo que creamos en el metodo comienza_el_juego() para detener ese mismo hilo, primero utilizaremos el metodo stop() para detener este hilo,este metodo esta desaconsejado pero aun funciona.

3- como hilo se declaro dentro del metodo comienza_el_juego no sera accesible en detener() por lo que la declaramos mejor fuera del metodo y asi sera accesible en ambos metodos.

4- ahora, en vez de utilizar stop utilizamos interrupt(), pero como dijimos,si el programa esta corriendo y lo pausamos con sleep() y despues le damos Detener lanzara una excepcion porque con sleep estara bloqueado el programa y si intentamos detenerlo lanzara la excepcion.Lo que se suele hacer en el catch del sleep es ponerle un System.exit(0) para que si le damos Detener pues cierre el programa.

5- ahora,la diferencia con interrupted y isInterrupted es que el primero sirve para cualquier hilo en ejecucion y el segundo para el hilo actual en ejecucion, por lo que para no usar el sleep podemos sustituir en un while el codigo del try-catch y usar junto a isInterrupted el metodo currentThread para evaluar si el hilo actual esta interrumpido o no.

-------------------------------------------------------------
(v170) ahora vamos a ver como detener varios hilos a voluntad,por ejemplo si tenemos 7 hilos en ejecucion, vamos a ver como detener el 3 o el 6,etc.Para esto primero debemos saber como esta trabajando nuestra app, cuando ejecutamos un hilo,osea pintamos una pelota y comienza a rebotar,se esta ejecutando la funcion comienza_el_juego(), esta funcion se encarga de generar un hilo al cual le da por nombre "hilo", cuando ejecutamos un segundo hilo como no pueden haber dos instancias con el mismo nombre, el segundo hilo se crea con el nombre "hilo",osea machaca al anterior,y el primer hilo se queda sin nombre pero sigue ejecutandose. Cuando damos "Detener", se ejecuta la funcion detener() la cual lo que hace es parar el hilo con el nombre "hilo" pero el otro hilo sin nombre sigue ejecutandose,por eso al detener el hilo se detiene siempre el ultimo hilo creado,el ultimo hilo en ejecucion.

Entonces, la solucion es ir creando hilos independientes,osea que cada hilo tenga su propio nombre para si poder detener el que necesitemos.

1- creamos tres botones para cada hilo,para eso bloqueamos el metodo que crea el boton "ponerBoton" y en MarcoRebote tambien quitamos las llamadas a este metodo.

2- como necesitare 3 hilos,pues creo tres variables de hilo1,hilo2,hilo3.

3- tambien creo tres variables de tipo JButton para arrancar cada hilo y otros 3 para detener cada hilo.

4- en el constructor de MarcoRebote creo las instancias de estos botones y pongo cada una a la escucha del evento con ActionListener, y los agrego a la lamina.

5- ahora, para que el metodo comeinza_el_juego() sea capaz de saber que hilo debe arrancar y detener, le pasamos en actionPerformed a la llamada del metodo el evento "e" como parametro, y en el propio metodo comienza_el_juego(ActionEvent evento) le pasamos tambien un argumento de tipo ActionEvent para que pueda recibir el parametro.Este objeto e es el que permitira saber cual boton se ha pulsado.

6- luego con if-else if voy evaluando cual boton es la fuente del evento y segun cada caso voy creando los correspondientes hilos, hago lo mismo para todos los botones,tanto los de detener como los de arrancar. Listo, asi ya funcionan los hilos independientes y sus correspondientes botones.

----------------------------------------------------------------


 */

package usoThreads;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame marco = new MarcoRebote();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);

	}

}

// Movimiento de la
// pelota-----------------------------------------------------------------------------------------

class Pelota {

	// Mueve la pelota invirtiendo posici�n si choca con l�mites

	public void mueve_pelota(Rectangle2D limites) {

		x += dx;

		y += dy;

		if (x < limites.getMinX()) {

			x = limites.getMinX();

			dx = -dx;
		}

		if (x + TAMX >= limites.getMaxX()) {

			x = limites.getMaxX() - TAMX;

			dx = -dx;
		}

		if (y < limites.getMinY()) {

			y = limites.getMinY();

			dy = -dy;
		}

		if (y + TAMY >= limites.getMaxY()) {

			y = limites.getMaxY() - TAMY;

			dy = -dy;

		}

	}

	// Forma de la pelota en su posici�n inicial

	public Ellipse2D getShape() {

		return new Ellipse2D.Double(x, y, TAMX, TAMY);

	}

	private static final int TAMX = 15;

	private static final int TAMY = 15;

	private double x = 0;

	private double y = 0;

	private double dx = 1;

	private double dy = 1;

}

// L�mina que dibuja las
// pelotas----------------------------------------------------------------------

class LaminaPelota extends JPanel {

	// A�adimos pelota a la l�mina

	public void add(Pelota b) {

		pelotas.add(b);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for (Pelota b : pelotas) {

			g2.fill(b.getShape());
		}

	}

	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

// Marco con l�mina y
// botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame {

	private LaminaPelota lamina;
	Thread hilo1, hilo2, hilo3;
	JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;

	public MarcoRebote() {

		setBounds(400, 300, 600, 350);

		setTitle("Rebotes");

		lamina = new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();

		// creo los botones de arrancar para trabajar con hilos independientes
		arranca1 = new JButton("Hilo 1");
		arranca1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comienza_el_juego(e);
			}

		});

		arranca2 = new JButton("Hilo 2");
		arranca2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comienza_el_juego(e);
			}

		});

		arranca3 = new JButton("Hilo 3");
		arranca3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comienza_el_juego(e);
			}

		});

		// botones de detener
		detener1 = new JButton("Detener 1");
		detener1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detener(e);
			}

		});

		detener2 = new JButton("Detener 2");
		detener2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detener(e);
			}

		});

		detener3 = new JButton("Detener 3");
		detener3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detener(e);
			}

		});

		laminaBotones.add(arranca1);
		laminaBotones.add(arranca2);
		laminaBotones.add(arranca3);
		laminaBotones.add(detener1);
		laminaBotones.add(detener2);
		laminaBotones.add(detener3);

		// ----------------------------------------------

		// ponerBoton(laminaBotones, "Dale!", new ActionListener() {

		// public void actionPerformed(ActionEvent evento) {

		// comienza_el_juego();
		// }

		// });

		// ponerBoton(laminaBotones, "Salir", new ActionListener() {

		// public void actionPerformed(ActionEvent evento) {

		// System.exit(0);

		// }

		// });

		// // crea el boton de interrumpir
		// ponerBoton(laminaBotones, "Detener", new ActionListener() {

		// public void actionPerformed(ActionEvent evento) {

		// detener();

		// }

		// });

		add(laminaBotones, BorderLayout.SOUTH);
	}

	// Ponemos botones

	// public void ponerBoton(Container c, String titulo, ActionListener oyente) {

	// JButton boton = new JButton(titulo);

	// c.add(boton);

	// boton.addActionListener(oyente);

	// }

	// A�ade pelota y la bota 1000 veces

	public void comienza_el_juego(ActionEvent evento) {

		Pelota pelota = new Pelota();

		lamina.add(pelota);

		// aqui creo una instancia de la clase que implementa Runnable
		Runnable r = new PelotaHilos(pelota, lamina);

		// if para ir evaluando que boton se ha pulsado y crear el hilo correspondiente
		if (evento.getSource().equals(arranca1)) {
			// creo una instancia d ela clase Thread y le paso este objeto Runnable
			// utilizando el constructor que pide un objeto de este tipo,la clase Thread
			// tiene sobrecarga de constructores.
			hilo1 = new Thread(r);

			// con start() de la clase Thread comienzo la ejecucion del hilo
			hilo1.start();

		} else if (evento.getSource().equals(arranca2)) {
			hilo2 = new Thread(r);
			hilo2.start();

		} else if (evento.getSource().equals(arranca3)) {
			hilo3 = new Thread(r);
			hilo3.start();
		}

	}

	public void detener(ActionEvent evento) {

		// metodo desaconsejado
		// hilo.stop();

		if (evento.getSource().equals(detener1)) {

			hilo1.interrupt();

		} else if (evento.getSource().equals(detener2)) {
			hilo2.interrupt();

		} else if (evento.getSource().equals(detener3)) {
			hilo3.interrupt();
		}

	}

}

// clase que implementara los hilos de ejecucion
class PelotaHilos implements Runnable {

	private Pelota pelota;
	private Component componente;

	// metodo constructor que recibira un objeto de tipo Pelota y otro de tipo
	// Component que sera en si la lamina donde rebota la pelota
	public PelotaHilos(Pelota unaPelota, Component unComponente) {

		this.pelota = unaPelota;
		this.componente = unComponente;
	}

	// en este metodo de la interfaz Runnable implementamos el codigo del for que es
	// el que hace el movimiento de la pelota,asi que lo cortamos de la clase donde
	// estaba y lo pegamos aqui
	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("Estado del hilo al comenzar " + Thread.currentThread().isInterrupted());

		// aqui indicamos que mientras el hilo actual no este interrumpido pinte la
		// pelota
		while (!Thread.currentThread().isInterrupted()) {

			pelota.mueve_pelota(componente.getBounds());

			componente.paint(componente.getGraphics());

			// aqui usamos sleep() para poder hacer la pausa en el hilo,la haremos de 4
			// milisegundos
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				// System.out.println("Programa bloqueado,imposible su interrpción");
				// System.exit(0);
				Thread.currentThread().interrupt();
			}
		}

		System.out.println("Estado del hilo al terminar " + Thread.currentThread().isInterrupted());

		// for (int i = 1; i <= 3000; i++) {

		// }

		throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
