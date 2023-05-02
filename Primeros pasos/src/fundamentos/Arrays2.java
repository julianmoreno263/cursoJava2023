package fundamentos;

/*vamos a ver los arrays de dos dimensiones, en si es tener un array dentro de otro, por ejemplo en el indice 0 del array principal ponemos no un dato normal sino un array,asi tenemos un array bidimensional.Vamos a crear un array de 4 posiciones y dentro de este otro array de 5 indices,por lo que tendremos 20 elementos en total y despues lo rellenamos con un for. Para imprimir un array bidimensional se haria asi:  miArray [][] en un println, y dentro de cada [] pongo los correspondientes indices de cada array a donde quiero apuntar. Para recorrer un array de estos debo utilizar dos bucles for anidados,el primer for recorre la primera dimension y el for anidado recorre la segunda.*/

public class Arrays2 {
    public static void main(String[] args) {

        // para declarar un array bidimensional usamos doble llaves y especificamos
        // cuantos elementos habra en cada array

        int miArray[][] = new int[4][5];

        miArray[0][0] = 12;
        miArray[0][1] = 122;
        miArray[0][2] = 80;
        miArray[0][3] = 45;
        miArray[0][4] = 47;

        miArray[1][0] = 11;
        miArray[1][1] = 3;
        miArray[1][2] = 90;
        miArray[1][3] = 1267;
        miArray[1][4] = 72;

        miArray[2][0] = 26;
        miArray[2][1] = 91;
        miArray[2][2] = 0;
        miArray[2][3] = 28;
        miArray[2][4] = 34;

        miArray[3][0] = 70;
        miArray[3][1] = 145;
        miArray[3][2] = 35;
        miArray[3][3] = 84;
        miArray[3][4] = 15;

        // recorrer array,aqui entra en el primer for y cae al segundo for,y ejecuta
        // todas las vueltas del segundo for primero(osea 5 vueltas) y cuando haya
        // terminado hay si vuelve al primer for el cual ya valdra 1 y se repite este
        // ciclo.
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 5; j++) {

                System.out.print(miArray[i][j] + " - ");
            }
        }

    }
}
