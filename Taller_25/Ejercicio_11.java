package Taller_25;

public class Ejercicio_11 {
    public static void main(String[] args) {
        int[] A = {-3, 0, 5, -1, 2, 0, -7, 6};

        int[] negativos = new int[A.length];
        int[] ceros = new int[A.length];
        int[] positivos = new int[A.length];

        int nNeg = 0, nCero = 0, nPos = 0;

        for (int num : A) {
            if (num < 0) {
                negativos[nNeg++] = num;
            } else if (num == 0) {
                ceros[nCero++] = num;
            } else {
                positivos[nPos++] = num;
            }
        }

        System.out.print("Negativos: ");
        for (int i = 0; i < nNeg; i++) System.out.print(negativos[i] + " ");

        System.out.print("\nCeros: ");
        for (int i = 0; i < nCero; i++) System.out.print(ceros[i] + " ");

        System.out.print("\nPositivos: ");
        for (int i = 0; i < nPos; i++) System.out.print(positivos[i] + " ");
    }
}

