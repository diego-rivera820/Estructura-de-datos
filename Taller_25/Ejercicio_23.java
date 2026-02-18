package Taller_25;

public class Ejercicio_23 {
    public static void main(String[] args) {
        int[][] mat = {
            {3, -7, 2},
            {-8, 5, -1},
            {0, -4, 9}
        };

        int filas = mat.length;
        int[] mayorAbs = new int[filas];

        for (int i = 0; i < filas; i++) {
            int max = Math.abs(mat[i][0]);
            for (int j = 1; j < mat[i].length; j++) {
                if (Math.abs(mat[i][j]) > max) {
                    max = Math.abs(mat[i][j]);
                }
            }
            mayorAbs[i] = max;
        }

        System.out.print("Vector mayor valor absoluto: ");
        for (int val : mayorAbs) {
            System.out.print(val + " ");
        }
    }
}
