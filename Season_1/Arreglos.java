import java.util.*;

public class Arreglos {

    public static void main(String[] args) throws Exception {
        // creaccion de los arreglos/Arrays/vector. (de la forma lenta)
        /*
         * int[] a = {2,6,8,1,20,40,7,3,5};
         * System.out.println("a[4]=" + a[4]); //20
         * System.out.println("a[7]=" + a[7]); //3
         * System.out.println("a[2]=" + a[2]); //8
         * System.out.println("a[0]=" + a[0]); //2
         * System.out.println("a[1]=" + a[1]); //6
         * System.out.println("a[1]=" + a[1]); //6
         */

        int[] a = { 2, 6, 8, 1, 20, 40, 7, 3, 5 };

        System.out.println("tamaño del arreglo: " + a.length);

        // implementacion del for para que lo recorra mucho mas (rapido)

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }
        // forma larga
        // int suma = (2+6+8+1+20+40+7+3+5);
        // System.out.println("La suma de los vectores:" + suma);

        // int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }
        System.out.println("la suma de los vectores es:" + suma);
        // obtener la suma de los numeros pares y de los numeros impares

        // mostrar los elementos que estan en las posiciones pares del arreglo
    }
}
