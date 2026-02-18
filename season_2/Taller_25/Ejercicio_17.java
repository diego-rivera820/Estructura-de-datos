package Taller_25;

public class Ejercicio_17 {
    public static void main(String[] args) {
        int[][] mat = {
            {2, 4, 6},
            {1, 3, 5},
            {7, 8, 9}
        };

        for (int i = 0; i < mat.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sumaFila += mat[i][j];
            }
            System.out.println("Suma de fila " + i + ": " + sumaFila);
        }

        for (int j = 0; j < mat[0].length; j++) {
            int sumaCol = 0;
            for (int i = 0; i < mat.length; i++) {
                sumaCol += mat[i][j];
            }
            System.out.println("Suma de columna " + j + ": " + sumaCol);
        }
    }
}
