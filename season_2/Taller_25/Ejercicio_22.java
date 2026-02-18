package Taller_25;

import java.util.Scanner;

public class Ejercicio_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Filas: ");
        int f = sc.nextInt();
        System.out.print("Columnas: ");
        int c = sc.nextInt();

        int[][] mat = new int[f][c];
        System.out.println("Introduce la matriz:");

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Valor [" + i + "][" + j + "]: ");
                mat[i][j] = sc.nextInt();
            }
        }

        int max = mat[0][0], min = mat[0][0];
        int maxI = 0, maxJ = 0, minI = 0, minJ = 0;

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                    maxI = i;
                    maxJ = j;
                }
                if (mat[i][j] < min) {
                    min = mat[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }

        System.out.println("Mayor: " + max + " en (" + maxI + "," + maxJ + ")");
        System.out.println("Menor: " + min + " en (" + minI + "," + minJ + ")");
    }
}
