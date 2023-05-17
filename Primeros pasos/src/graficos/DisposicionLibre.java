/*(v118) las disposiciones libres nos permiten poner los elementos donde queramos.Lo que pasa es que toca trabajar con coordenadas y puede ser que una ventana con esta disposicion se vea de una forma en windows y se vea diferente en linux por ejemplo. 

1- para poner por ejemplo un boton donde queramos en nuestro contenedor,primero le decimos al contenedor que tendra un layout null.

2- el contenedor.la lamina en este caso,se divide en eje x y eje y, recordar que en java el punto 0,0 esta en la esquina superior izquierda,entonces con setBounds() ubicamos nuestro boton dentro del contenedor especificando las coordenadas que queremos darle.

---------------------------------------------------------------------------------
(v119) ahora, trabajar una disposicion libre asi no es muy eficiente porque toca estar viendo cada posicion y coordenadas de cada elemento que vamos a crear,si tenemos varios se vuelve mas complejo, la mejor forma de hacer una disposicion libre es crear nuestra propia disposicion o layout, esto lo podemos hacer creando una clase que cuando la necesitemos usar sea ella quien nos acomode los elementos. Para crear nuestras propias dispocisiones debemos crear una clase que implement la interfaz LayoutManager la cual tiene 5 metodos,algunos de estos metodos piden como parametro un objeto de tipo Container(el cual hace referencia al contenedor donde se usara este layout). Para crear un objeto de tipo Container pues usamos la clase Container y esta tiene dos metodos que nos permitiran contar el numero de elementos que usaremos con nuestro layout y capturar un elemento especifico, estos elementos en estos metodos se cuentan como con los arrays,osea comienza desde cero.

Crearemos un ejemplo de una layout propia creando una clase que nos permita poner elementos uno debajo de otro y en la parte izquierda de nuestro contenedor.Cuando creemos esta clase solo tendremos que ocuparnos de ir agregando los elementos al contenedor porque la clase los posicionara.

En la interfaz LayoutManager utilizaremos el metodo layoutContainer el cual nos permite especificar los elementos que necesitamos.

1- creo la clase implementando la interfaz, creo dos variables para las coordenadas iniciales, en el metodo layoutContainer creo una variable contador para saber cuantos elementos voy creando y otra para capturar el numero de elementos que se vayan almacenando en el contenedor.

2- despues recorro ese numero de elementos con un for,y dentro del for es donde capturo un elemento especifico con el metodo getComponent().

3- como vamos a crear parejas de elementos, un label y un cuadro de texto,debemos indicar que cuando agrege una pareja,la otra la agrege debajo,esto lo hacemos incrementando el valor de y,para esto le decimos a la variable contador que es la que va contando los elementos creados que cuando sea par incremente y,asi la proxima pareja se pone abajo,para esto usamos el operador % para indicar que cuando la variable contador dividia en dos el residuo es cero pues se sabe que es par.

4- creada la clase debemos indicarle al contenedor(la lamina) que el setLayout no sera null sino que sera del tipo de la clase que hemos echo.Ademas a la hora de agregarlos debo ir haciendolo en el orden indicado,osea el label de nombre primero,segundo el cuadro de texto de nombre,y asi sucesivamente.

5- esto en si nos permite olvidarnos del posicionamiento porque el trabajo lo hara esta clase,simplemente vamos creando los elementos que necesitemos y el layout los va acomodando.

Esta es la verdadera utilidad de usar una disposicion libre,crear una clase que haga el posicionamiento de los elementos.

--------------------------------------------------------
(v120) podemos poner estos elementos que creamos en el centro del contenedor,para eso debemos saber el ancho del contenedor con el metodo getWidth() de la clase Container.

1- la variable x la declaro pero no la inicio,la variable y la dejo como esta.
2- capturo el ancho con getWidth() y despues este ancho lo uso para saber el punto central con la variable x.
3- despues en setBounds le digo que el primer elemento debe estar en la posicion x-100,100 es el ancho del label,entonces a x le resto esos 100 para que se posicione bien y no salga corrido a la derecha.


*/

package graficos;

import javax.swing.*;
import java.awt.*;

public class DisposicionLibre {
    public static void main(String[] args) {

        MarcoLibre miMarco = new MarcoLibre();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// frame
class MarcoLibre extends JFrame {

    public MarcoLibre() {

        setTitle("Disposición Libre");
        setBounds(300, 250, 600, 400);

        LaminaLibre miLamina = new LaminaLibre();
        add(miLamina);

        setVisible(true);
    }
}

// lamina
class LaminaLibre extends JPanel {

    public LaminaLibre() {

        // asi establecemos la disposicion libre
        // setLayout(null);

        // asi establecemos nuestra propia dispocision
        setLayout(new layoutPropio());

        // creamos nuestro boton y con setBounds lo ubicamos.Toca con layoput libre
        // utilizar setBounds,aunque por defecto los botones tienen un tamaño,lo
        // establecemos en setBounds con ancho y alto.
        // JButton boton1 = new JButton("Boton 1");
        // JButton boton2 = new JButton("Boton 2");

        // boton1.setBounds(50, 50, 150, 50);
        // boton2.setBounds(250, 50, 150, 50);

        // add(boton1);
        // add(boton2);

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JLabel edad = new JLabel("Edad: ");
        JLabel telefono = new JLabel("Teléfono: ");

        // nombre.setBounds(50, 50, 100, 20);
        // apellido.setBounds(50, 150, 100, 20);

        JTextField cuadroNombre = new JTextField();
        JTextField cuadroApellido = new JTextField();
        JTextField cuadroEdad = new JTextField();
        JTextField cuadroTelefono = new JTextField();

        // cuadroNombre.setBounds(120, 50, 100, 20);
        // cuadroApellido.setBounds(120, 150, 100, 20);

        add(nombre);
        add(cuadroNombre);
        add(apellido);
        add(cuadroApellido);
        add(edad);
        add(cuadroEdad);
        add(telefono);
        add(cuadroTelefono);

    }
}

// clase que crea nuestro propio layout, primero creo una coordenadas iniciales
// para poder usar con setBounds.Esta clase en si es para ir ubicando los
// componentes que creemos y que vayamos adicionando al contenedor,la clase lo
// que hace es ubicar los elementos.En setBounds inicialmente le daremos un
// tamaño de 100 y 20 a los elementos. Despues de setBounds incrementamos x para
// que el otro elemento no lo ponga encima,este codigo es un poco dificil de ver
// porque es algo abstracto,pero tiene logica.
class layoutPropio implements LayoutManager {

    int x;
    int y = 20;
    int contador = 0;

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLayoutComponent'");
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLayoutComponent'");
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preferredLayoutSize'");
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minimumLayoutSize'");
    }

    @Override
    public void layoutContainer(Container parent) {

        int d = parent.getWidth();
        x = d / 2;
        int n = parent.getComponentCount();

        for (int i = 0; i < n; i++) {
            contador++;
            Component c = parent.getComponent(i);
            c.setBounds(x - 100, y, 100, 20);
            x += 100;

            if (contador % 2 == 0) {
                x = d / 2;
                y += 40;
            }

        }
    }

}