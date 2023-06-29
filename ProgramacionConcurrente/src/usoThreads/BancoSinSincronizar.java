/*(v173) vamos a ver porque a veces es importante sincronizar nuestras apps,sobretodo si manejamos varios hilos. Crearemos una app de un banco que tendra 100 cuentas, en principio cada cuenta tendra 2000 pesos,osea que en total el saldo sera de 200.000. Luego comenzaremos a realizar traspasos de dinero entre cada cuenta, cada traspaso sera un hilo,pero el saldo total debera ser siempre de 200.000, llegara un momento en que el saldo total sera menor de 200.000 porque las cuentas inicialmente no estaran sincronizadas y veremos porque pasa esto con el saldo total.

1- creamos la clase que crea el banco y esta clase debe de crear las cuentas y darle a cada cuenta 2000 pesos.Esto se establece en el constructor.

2- creamos un metodo que sea el encargado de realizar las transferencias entre cuentas,para esto debe usar tres parametros, uno para establecer la cuenta de origen,otro la cuenta destino y otro para la cantidad.

3- ahora,en este metodo lo primero es controlar que el saldo de la cuenta de origen no sea inferior a la cantidad que deseamos transferir, si esto pasa pues que no se haga la transferencia.

4- Luego imprimimos el hilo que esta realizando la transferencia,esto solo lo hacemos para despues poder localizar donde estara el error en la ejecucion del programa,es un mensaje informativo.Esto lo hacemos con currentThread().

5- ahora, descontamos de la cuenta origen la cantidad que queremos transferir.

6- creamos un mensaje con printf para que nos indique de que cuenta a que cuenta se realiza la transferencia y la cantidad de dinero que se va a transferir.

7- ahora,incrementamos el saldo de la cuenta de destino porque ya recibio mas dinero.

8- por ultimo indicamos el saldo total, pero para levar este calculo del saldo total creamos un metodo aparte que hara ese calculo.Se supone que en principio el saldo no debe cambiar,debe ser el de 200.000.

---------------------------------------------------
(v174) ahora, vamos a crear la clase que genere los hilos y con el metodo run los ejecute, el programa lo que debe de hacer es ir realizando transacciones entre cuentas automaticamente en un bucle infinito.Esta clase debe implementar la interfaz Runnable y su metodo run().

1- ya creada la clase debo crear un constructor y este debe de pedir 3 argumentos,uno para crear un objeto de tipo Banco porque necesitaremos instanciar el Banco y asi con este objeto utilizar los metodos que tiene, otro parametro sera para la cuanta de origen y otro para la cantidad a transferir.

2- ahora, como este programa correra en un bucle infinito realizando transferencias entre las cuentas creo en el metodo run un bucle while, la cuenta origen se la paso al constructor cuando instancie un objeto de esta clase,pero la cuenta destino sera aleatoria,por lo que usamos Math.random() para ir generando el numero de la cuenta destino(que sera cualquiera entre 0 y 99).

3- ahora, establecemos la cantidad maxima a transferir entre cuentas,como una cuenta tiene un saldo inicial de 2000, se parte de este monto y nuevamente con Math.random() se establece este valor.Por ejemplo, la variable cantidadMax tiene 2000, y si Math.random() genera el numero 0.785999, al multiplicar : cantidadMax*Math.random(), esa multiplicacion me dara 1500, entonces asi garantizo con el valor fijo de 2000 que nunca se transfiera mas de lo que la cuenta puede hacer.

4- ya por ultimo realizamos la transferencia,para esto pues utilizamos el metodo que creamos llamado transferencia() el cual nos pide 3 argumentos, y para poder utilizar este metodo pues necesito un objeto de la clase Banco,este objeto ya lo tenemos.

5-por ultimo,para poder ver en consola la ejecucion de los hilos los dormimos un poco con sleep() y esta vez en lugar de pasarle un tiempo fijo en milisegundos tambien usamos random() para que vaya generando esos tiempos,se multiplica por 10 paraque cuente en milisegundos.Como sleep lanza excepcion podemos meter todo el while dentro del try-catch.

6- Listo, ahora vamos a main y creamos una instancia de Banco, luego con un for recorremos las 100 cuentas, dentro de este for creamos un objeto de la clase que implementa la interfaz Runnable y el metodo run() que en si es el que corre los hilos,que es EjecucionTransferencias, esta clase en su constructor nos pide el banco,la cuenta origen que sera la i del for que es la que va recorriendo cada cuenta y la cantidad que seran los 2000. Luego creamos una instancia de Thread pasandole el objeto que creamos de EjecucionTransferencia y arrancamos el hilo con start().

8- listo,al ejecutar el programa vemos que el saldo total que deberia mantenerse en 200.000, en un momento es menor, a veces vuelve a 200.000 y despues vuelve y es menor. Recordar que hasta este punto el programa maneja hilos normales,no estan sincronizados.

-----------------------------------------------------------------------
(v175) vamos aver porque el saldo total se minimiza a veces, logico que esto es porque la aplicacion no tiene los hilos sincronizados pero vamos a ver en si que pasa,y ademas vamos a usar la clase ReentrantLock que sirve precisamente para sincronizar una aplicacion compleja que tiene multiples hilos, con join() sincronizamos hilos pero este sirve para aplicaciones mas basicas.

En si esto del saldo total pasa porque e stamos trabajando con programacion concurrente,osea varios hilos ejecutandose al tiempo, el metodo transferiri es el que hace el trabajo del programa cuando es llamado por el metodo run(), entonces en el metodo transferir,por ejemplo un primer hilo comienza a transferir dindero de a hacia b, por ejemplo 200pesos, y puede darse,porque como estamos trabajando con random() que otro segundo hilo tambien comienze a transferir dinero entre estas mismas cuentas solo que va un poco mas atras que el primer hilo. Cuando el hilo1 llega al final e imprime el saldo total, puede ser que la cuenta no sea correcta porque antes de que el hilo1 acabe el hilo2 tambien desconto mas dinero de esa misma cuenta origen,asi cuando el hilo1 llega al final para imprimir el saldo total la resta es diferente a lo que iba con el hilo1 y por eso el saldo total llega en ciertos momentos con un monto menor al esperado, y esto puede darse porque los metodos random() al ser aleatorios en un momento pueden llegar a tomar los mismos valores para varios hilos que se van ejecutando al tiempo.

Para solucionar esto en este tipo de programas es que se usa la clase ReentrantLock la cual implementa la interfaz Lock, y esta interfaz tiene varios metodos entre ellos el metodo lock y unlock.

El metodo lock bloquea un trozo de codigo del programa para que solo pueda ser ejecutado por un hilo simultaneamente. Osea, por ejemplo puede bloquear 50 lineas de codigo,para que esas lineas solo puedan ser ejecutadas por un unico hilo, y unlock() desbloquea esas 50 lineas de codigo para que el siguiente hilo pueda ejecutarlas.

Entonces, en nuestro programa, necesitamos bloquear con lock() el metodo transferencia() para que solo un hilo lo pueda acceder y asi ejecute su codigo, y luego al finalizar la ejecucion de ese hilo lo desbloqueamos con unlock() para que el hilo que viene atras ya pueda acceder y asi sucesivamente, por lo tanto no podran acceder varios hilos al tiempo en el metodo,solo sera uno a la vez y asi la cuenta del saldo total no se vera afectada.

1- debemos usar la clase ReentrantLock por lo que debemos importar el paquete java.util.concurrent.locks.ReentrantLock;

2- creamos una instancia de ReentrantLock la cual implemneta la interfaz Lock, en la clase Banco que es donde la vamos a usar porque alli esta el metodo transferencia que necesitamos bloquear.

3- con esta instancia creada vamos al metodo transferencia y la utilizamos rodeando el codigo interno del metodo con un try-finally, en el try ira el lock() y en el finally el unlock() y asi queda bloqueado el codigo que necesitamos que se ejecute un hilo a la vez.

Listo!, si ejecutamos el programa veremos que el saldo se mantiene en 200.000 y no se pierde en el camino por el bloqueo que hemos implementado.

-----------------------------------------------------------------
(v176) vamos a ver como crear condiciones para nuestros bloqueos,a veces sera necesario poner condiciones en los bloqueos. Para esto debemos conocer bien como trabaja nuestra app y sobre todo el metodo transferencia que es el que hace todo.

1- digamos que la cuenta 25 se ha ejecutado varias veces a lo largo de la ejecucion del programa,osea ha realizado varias transferencias de plata,por lo que su saldo de 2000 iniciales habra bajado, si por ejemplo nuevamente se llega a esa cuenta y se quiere transferir dinero pero su saldo es menor al monto que se quiere transferir es alli donde entra el if que evalua esta condicion y si es cierto el return no permite que se realice esta accion y lo que hace el return es devolver el programa hacia la clase EjecucionTransferencias pues desde alli es que se hace la llmada al metodo transferencia. Esto quiere decir que el resto del codigo del metodo transferencia no se ejecutaria y ese hilo se pierde. Lo que si se ejecutaria siempre es lo que esta en el finally del try, que es la instruccion de desbloquear el codigo para que el otro hilo que este detras esperando pueda acceder a el.

2- ahora, digamos que una condicion del negocio es que todas las transferencias deben de ejecutarse,osea no se puede perder ningun hilo, pero no pueden haber saldos negativos en las cuentas(porque si quitamos el return del if ya no se perdera el hilo,se ejecutaria todo, pero podrian darse cuentas con saldos negativos). Para esta situacion es que se usan condiciones en el bloqueo, y para esto se usa el metodo await(). Este metodo debe hacer dos cosas,pone el hilo que no se puede ejecutar porque no hay saldo suficiente a la espera,osea el hilo no se pierde sino que queda a la espera,y ademas libera el bloqueo para que continue otro hilo.

3- ahora, si un hilo esta a la espera,por ejemplo hilo7, y llega el hilo8 y realiza un ingreso de dinero a una cuenta, el hilo8 debera hacer dos cosas cuando haga el ingreso de dinero,primero desbloquea el codigo y segundo debe avisar a los hilos en espera que ha echo un ingreso de dinero a una cuenta para que esos hilos miren a ver si ese ingreso les sirve para poder ejecutar la transferencia que esta a la espera, de esta forma todas las transferencias se realizaran,ninguna se pierde.

4- entonces, para establecer en un bloqueo de hilos una condicion debemos usar el metodo newCondition() de la clasae ReentrantLock, este metodo devuelve un objeto de tipo Condition,esta es una interfaz y esta interfaz entre sus metodos tiene el metodo await(),este metodo pone a la espera a los hilos y este metodo lanza una excepcion de tipo InterruptedException.Tambien tiene el metodo signalAll() el cual le dice a los hilos que estan a la espera que despierten(ver API).

---------------------------------------------------------
(v177) vamos a ver como se crea la condicion en el codigo con bloqueo.

1- creamos en la clase donde esta el codigo bloqueado,el metodo transferencia, una variable de tipo Condition.

2- ahora, en el constructor de la clase Banco, indicamos que el bloqueo debera tener una condicion asi:

                        saldoSuficiente=cierreBanco.newCondition()

ponemos este codigo en el constructor para que cada vez que instanciemos un Banco, venga con un bloqueo con condicion.

3- ahora, en el metodo transferencia, vez de poner un if en el try,lo cambiamos por un while dejando la misma condicion, y quitamos el return porque ahora necesitamos que todos los hilos(las transferencias) se ejecuten(con el return se pierden los hilos), y dentro de e ste while es que ponemos este codigo:

                    saldoSuficiente.await()

osea,le estamos diciendo al codigo que "mientras la condicion del while sea verdadera(osea que el saldo de la cuenta origen es menor a la cantidad a transferir) pues que ese hilo permanezca a la espera". Recordar que como await lanza una exception toca rodearlo con un try-catch,o podemos indicarle al metodo transferencia que saldra una exception de tipo InterruptedExcetion por medio de un throws,si hacemos esto debemos rodear la llamad al metodo transferencia con un try-catch el cual ya lo tenemos rodeado cuando hacemos esa llamada en el metodo run.

4- por ultimo, con signalAll() le indicamos a los hilos que estan a la espera que despierten y miren si la condicion del while cambio para que puedan ejecutarse.Esto lo ponemos al final del try antes del finnaly,porque es en ese punto donde un hilo que si se pudo ejecutar finaliza su ejecucion,entonces apenas finaliza su ejecucion avisa a los que e stan a la espera que despierten.

Listo, de esta forma con condiciones de bloqueo ningun hilo muere,solo quedan ala espera para poderse ejecutar despues y asi todas las transferencias se realizan.

 */

package usoThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {
    public static void main(String[] args) {

        Banco b = new Banco();

        for (int i = 0; i < 100; i++) {

            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);

            Thread t = new Thread(r);

            t.start();

        }

    }
}

// clase del banco
class Banco {

    private final double cuentas[];
    private Lock cierreBanco = new ReentrantLock();
    private Condition saldoSuficiente;

    // constructor
    public Banco() {

        // creamos las 100 cuentas y le cargamos a cada una los 2000
        cuentas = new double[100];

        for (int i = 0; i < cuentas.length; i++) {

            cuentas[i] = 2000;
        }

        // aqui establecemos que cada vez que instanciemos un Banco este venga con una
        // condicion en el bloqueo.
        saldoSuficiente = cierreBanco.newCondition();
    }

    // metodo para las transferencias entre cuentas
    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

        // aqui bloqueamos el codigo para que solo lo acceda un hilo a la vez
        cierreBanco.lock();

        try {
            // aqui evaluamos que el saldo de la cuenta no sea inferior a la cantidad que
            // queremos transferir,si esto pasa no deja hacer nada con el return.Pero al
            // poner condicion de bloqueo usamos el metodo await() y deja a la espera el
            // hilo.
            while (cuentas[cuentaOrigen] < cantidad) {

                saldoSuficiente.await();

            }

            // imprimimos el hilo que realiza la transferencia actual
            System.out.println(Thread.currentThread());

            // aqui descontamos de la cuenta origen la cantidad que queremos transferir
            cuentas[cuentaOrigen] -= cantidad;

            // mensaje que indica la cantidad a transferir y entre que cuentas,usamos printf
            // para darle este formato y asi usar dos decimales.
            System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

            // aqui incrementamos el saldo de la cuenta destino
            cuentas[cuentaDestino] += cantidad;

            // aqui imprio el saldo total
            System.out.printf("Saldo total: %10.2f%n ", getSaldoTotal());

            // con esta instruccion le indicamos a los hilos que estan ala espera que
            // despierten y miren si la condicion del while a cambiado para que puedan
            // ejecutarse
            saldoSuficiente.signalAll();

        } finally {

            cierreBanco.unlock();
        }

    }

    // metodo para ir calculando el saldo total, aqui el bucle va sumando los 2000
    // de cada cuenta hasta llegar al total de los 200.000 de las 100 cuentas y nos
    // devuelve ese valor.
    public double getSaldoTotal() {
        double sumaCuentas = 0;

        for (double a : cuentas) {
            sumaCuentas += a;
        }

        return sumaCuentas;
    }
}

// clase que crea los hilos y los ejecuta
class EjecucionTransferencias implements Runnable {

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;

    // constructor
    public EjecucionTransferencias(Banco b, int de, double max) {

        this.banco = b;
        this.deLaCuenta = de;
        this.cantidadMax = max;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {

            while (true) {

                // esta sera la cuenta destino
                int paraLaCuenta = (int) (100 * Math.random());

                // asi se establece la cantidad maxima a transferir
                double cantidad = cantidadMax * Math.random();

                // aqui ejecutamos la transferencia usando el metodo transferencia de la clase
                // Banco,para ejecutar este metodo pues usamos el objeto tipo Banco.Este metodo
                // nos pide la cuenta origen,la cuenta destino y la cantidad a transferir que
                // sera aleatoria.
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);

                // creamos un sleep() con random para poder ver en consola la ejecucion de los
                // hilos
                Thread.sleep((int) Math.random() * 10);

            }

        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

}