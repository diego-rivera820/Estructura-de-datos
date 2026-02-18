package Taller_25;

public class Ejercicio_10 {
    public static void main(String[] args) {
        int[] A = {8, 5, 3, 10, 2, 8, 1};
        int n = A.length;
        int[] B = new int[n / 2];

        for (int i = 0; i < B.length; i++) {
            B[i] = A[i] + A[n - 1 - i];
        }

        System.out.print("Arreglo resultante: ");
        for (int num : B) {
            System.out.print(num + " ");
        }
    }
}
