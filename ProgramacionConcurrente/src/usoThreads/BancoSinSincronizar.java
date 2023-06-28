/*(v173) vamos a ver porque a veces es importante sincronizar nuestras apps,sobretodo si manejamos varios hilos. Crearemos una app de un banco que tendra 100 cuentas, en principio cada cuenta tendra 2000 pesos,osea que en total el saldo sera de 200.000. Luego comenzaremos a realizar traspasos de dinero entre cada cuenta, cada traspaso sera un hilo,pero el saldo total debera ser siempre de 200.000, llegara un momento en que el saldo total sera menor de 200.000 porque las cuentas inicialmente no estaran sincronizadas y veremos porque pasa esto con el saldo total.

1- creamos la clase que crea el banco y esta clase debe de crear las cuentas y darle a cada cuenta 2000 pesos.Esto se establece en el constructor.

2- creamos un metodo que sea el encargado de realizar las transferencias entre cuentas,para esto debe usar tres parametros, uno para establecer la cuenta de origen,otro la cuenta destino y otro para la cantidad.

3- ahora,en este metodo lo primero es controlar que el saldo de la cuenta de origen no sea inferior a la cantidad que deseamos transferir, si esto pasa pues que no se haga la transferencia.

4- Luego imprimimos el hilo que esta realizando la transferencia,esto solo lo hacemos para despues poder localizar donde estara el error en la ejecucion del programa,es un mensaje informativo.Esto lo hacemos con currentThread().

5- ahora, descontamos de la cuenta origen la cantidad que queremos transferir.

6- creamos un mensaje con printf para que nos indique de que cuenta a que cuenta se realiza la transferencia y la cantidad de dinero que se va a transferir.

7- ahora,incrementamos el saldo de la cuenta de destino porque ya recibio mas dinero.

8- por ultimo indicamos el saldo total, pero para levar este calculo del saldo total creamos un metodo aparte que hara ese calculo.Se supone que en principio el saldo no debe cambiar,debe ser el de 200.000.


 */

package usoThreads;

public class BancoSinSincronizar {
    public static void main(String[] args) {

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
