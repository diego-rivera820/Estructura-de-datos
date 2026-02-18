package Taller_25;

public class Ejercicio_7 {
    public static void main(String[] args) {
        int[] A = {5, 8, 3, 10, 7, 4, 9, 2, 12, 1};

        int[] pares = new int[A.length];
        int[] impares = new int[A.length];
        int p = 0, q = 0;

        for (int num : A) {
            if (num % 2 == 0) {
                pares[p++] = num;
            } else {
                impares[q++] = num;
            }
        }

        System.out.println("Pares:");
        for (int i = 0; i < p; i++) {
            System.out.print(pares[i] + " ");
        }

        System.out.println("\nImpares:");
        for (int i = 0; i < q; i++) {
            System.out.print(impares[i] + " ");
        }
    }
}

