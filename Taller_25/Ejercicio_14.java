package Taller_25;

public class Ejercicio_14 {
    public static void main(String[] args) {
        int[] A = {4, 6, 8, 2, 6, 9, 5, 1};
        int[] B = new int[A.length - 1];

        for (int i = 0; i < B.length; i++) {
            B[i] = A[i + 1] - A[i];
        }

        System.out.print("Arreglo resultante: ");
        for (int num : B) {
            System.out.print(num + " ");
        }
    }
}

