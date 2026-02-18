package Taller_25;

public class Ejercicio_21 {
    public static void main(String[] args) {
        int[][] mat = {
            {2, 3, 4},
            {5, 6, 7},
            {8, 9, 10}
        };

        int M = mat.length;
        int[] sumPares = new int[M];

        for (int i = 0; i < M; i++) {
            int suma = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] % 2 == 0) {
                    suma += mat[i][j];
                }
            }
            sumPares[i] = suma;
        }

        System.out.print("Vector suma de pares: ");
        for (int val : sumPares) {
            System.out.print(val + " ");
        }
    }
}
