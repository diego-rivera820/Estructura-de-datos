package Taller_25;

public class Ejercicio_19 {
    public static void main(String[] args) {
        int n = 5; // filas
        int m = 7; // columnas
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
