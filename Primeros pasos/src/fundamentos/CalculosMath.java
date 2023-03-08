public class CalculosMath {
    public static void main(String[] args) {

        // para ver que reciben por parametro los metodos,debemos tener a la mano la api
        // de java y asi usar bien los metodos de las clases,aqui el metodo sqrt
        // devuelve un double,por eso la variable donde almacenemos el resultado debemos
        // declararla como double
        // double raiz = Math.sqrt(9); //sqrt para sacar raiz cuadrada

        double base = 5;
        double exponente = 3;

        // el metodo round retorna un int, si le pasamos un double retorna un dato de
        // tipo long,osea me saca un error porque intentamos guardar un long en un int,
        // aqui usamos refundicion o casteo para pasar el tipo de dato a otro,lo
        // indicamos al inicio de la instruccion entre parentesis.
        // int resultado = (int) Math.round(num1);//round redondea numeros

        // metodo pow es para calcular la potencia de un numero,pide la base y exponente
        // ambos de tipo double,retorna un double
        double resultado = Math.pow(base, exponente);

        System.out.println("El resultado de la operación es " + resultado);
    }
}
