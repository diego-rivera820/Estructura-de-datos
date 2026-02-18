package Taller_25;

import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio_12 {
    public static void main(String[] args) {
        int[] A = {4, 6, 8, 2, 6, 9, 6, 1};
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el valor x: ");
        int x = sc.nextInt();

        ArrayList<Integer> posiciones = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == x) {
                posiciones.add(i);
            }
        }

        System.out.print("Posiciones donde aparece " + x + ": ");
        for (int pos : posiciones) {
            System.out.print(pos + " ");
        }
    }
}
