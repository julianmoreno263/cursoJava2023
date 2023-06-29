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



 */

package usoThreads;

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

    // constructor
    public Banco() {

        // creamos las 100 cuentas y le cargamos a cada una los 2000
        cuentas = new double[100];

        for (int i = 0; i < cuentas.length; i++) {

            cuentas[i] = 2000;
        }
    }

    // metodo para las transferencias entre cuentas
    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {

        // aqui evaluamos que el saldo de la cuenta no sea inferior a la cantidad que
        // queremos transferir,si esto pasa no deja hacer nada con el return.
        if (cuentas[cuentaOrigen] < cantidad) {
            return;
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