/*(v171) vamos a ver los estados de los hilos y su sincronizacion, los hilos pueden tener los siguientes estados:

1- nuevo, cuando se crea con new un nuevo hilo.

2- ejecutable, diferente a estar en ejecucion,puede haber un hilo bloqueado con sleep() y cuando el sleep se termina el hilo pasa de nuevo a ejecucion.

3- muerto,cuando termina la ejecucion del hilo ya sea porque lo paramos o porque se produjo una excepcion.

Ahora,para ver la sincronizacion de hilos vamos a crear un programa que maneje hilos normales y despues los sincronizamos.

Para crear un hilo podemos usar la interfaz Runnable como lo hicimos en la app pasada o tambien podemos heredar de Thread y asi tener todos los metodos disponibles para crear hilos.

1- creamos la clase que crea el hilo,sera un codigo sencillo que correra  un ciclo for.

2- en main creo las instancias de los hilos y lo corro con start, creo dos hilos para ver como se sincronizan.

3- Para saber cual hilo es el que se esta ejecutando, usamos el metodo getName() de la clase Thread,cada vez que s eejecuta un hilo java le da un nombre por defecto, como thraed-1,etc, entonces con este metodo podemos saber ese nombre del hilo.

4- si observamos, al ejecutar el programa se van intercalando los hilos,a veces sale el hilo1 despues el hilo2,despues pueden salir en orden,esto depende del procesador del pc,etc,pero se intercalan porque precisamente no estan sincronizados,para ver mejor que se van intercalando ponemos un sleep(),siempre dentro de un try-catch porque este sleep lanza una excepcion.

5- entonces, a veces necesitaremos que en un programa con varios hilos,se ejecute totalmente un hilo antes de comenzar el siguiente,esto es sincronizar hilos,y para esto utilizamos el metodo join() de la clase Thread el cual tambien lanza una exception del tipo InterrumpedException. Entonces este metodo lo utilizamos cuando arrancamos el hilo con start(). Al ejecutar el programa ya corre en orden cada hilo.

-----------------------------------------------------
       
(v172) ahora, tambien s epueden sincronizar hilos sin necesidad de decirles explicitamente que lo hagan,osea que nosotros no le digamos con join que s esincronizen sino que sean ellos los que s esincronicen automaticamente, por ejemplo la linea del mensaje:

     System.out.println("Terminada la ejecución de los hilos!");

esta linea pertenece al main del programa y se ejecuta despues de que los hilos han terminado,puede ser que queramos que el mainse ejecute a la vez que los hilos en segundo plano,por ejemplo en interfaces graficas cuando hacemos una tarea en una lamina y a la vez queremos que un menu de esa interfaz siga trabajando y nos deje hacer otras operaciones al tiempo.

Para esto lo que se hace es pasarle por ejemplo al hilo2 por parametro el hilo1,diciendole que espere a que el hilo que le pasamos por argumento se ejecute y despues si comienze su ejecucion.

1- creamos una segunda clase parecida a HilosVarios pero esta llevara constructor el cual recibe un parametro que sera de tipo Thread porque le pasaremos el hilo que queremos que primero ejecute.

2- despues dentro del metodo run usamos de nuevo al metodo join() para realizar la sincronizacion.

3- ya en el main por ejemplo hilo2 sera instancia de HilosVarios2 y le pasamos por parametro a hilo1, de esta forma no importa el orden de arranque de los hilos,si por ejemplo ponemos primero hilo2.start() y luego hilo1.start() se ejecutara de todas formas primero el hilo1 porque asi lo establecimos por el parametro del constructor de la instancia  hilo2. Asi en las llamadas de start de los hilos no necesitamos usar los join porque ya esta previamente establecido.

Ahora, con este forma de sincronizar,el main queda liberado,por lo que la linea del syso se ejecuta primero y despues van los hilos.

--------------------------------------------------

 */

package usoThreads;

public class SincronizandoHilos {

    public static void main(String[] args) {

        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);

        hilo2.start();
        hilo1.start();

        // aqui sincronizo los hilos con join()
        // hilo1.start();
        // try {
        // hilo1.join();
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // hilo2.start();
        // try {
        // hilo2.join();
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        System.out.println("Terminada la ejecución de los hilos!");

    }
}

// clase que crea los hilos,debe tener el metodo run()
class HilosVarios extends Thread {

    public void run() {

        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo: " + getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

// segunda clase que crea los hilos,pero tiene un constructor para pasarle por
// argumento el hilo que queremos que se ejecute primero,asi logramos que estos
// hilos se sincronicen entre ellos.
class HilosVarios2 extends Thread {

    private Thread hilo;

    public HilosVarios2(Thread hilo) {

        this.hilo = hilo;
    }

    public void run() {

        // aqui sincronizamos ese hilo que va por parametro
        try {
            hilo.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo: " + getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}