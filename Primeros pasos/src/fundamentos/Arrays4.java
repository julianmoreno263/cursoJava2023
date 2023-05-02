package fundamentos;

/*vamos aver un ejercicio practico con arrays de dos dimensiones, el programa debe calcular los porcentaje en que se incrementa una cantidad a traves de varios años.Declaro variables double porque los resultados dan decimales.*/

public class Arrays4 {
    public static void main(String[] args) {

        double acumulado;
        double interes = 0.10; // esto es igual al 10%

        double saldo[][] = new double[6][5];

        // rellenamos con un for, la primera dimension en indice 0 le ponemos el valor
        // de 10000 porque todos los porcentajes de ese indice comienzan con ese
        // valor,(ver excel del video)
        for (int index = 0; index < 6; index++) {

            saldo[index][0] = 10000;
            acumulado = 10000;

            for (int j = 1; j < 5; j++) {
                // este es el calculo del porcentaje
                acumulado = acumulado + (acumulado * interes);
                // aqui mete en el array correspondiente el resultado
                saldo[index][j] = acumulado;

            }

            // aqui se incrementa el interes para poder calcular despues el interes al
            // 11%,12%,etc, asi cuando termine de rellenar el primer indice continua con el
            // siguiente y repite este ciclo.
            interes = interes + 0.01;
        }

        // aqui recorremos el array una vez se halla llenado
        for (int z = 0; z < 6; z++) {
            System.out.println();

            for (int h = 0; h < 5; h++) {
                System.out.printf("%1.2f", saldo[z][h]);
                System.out.print(" ");
            }
        }
    }
}
