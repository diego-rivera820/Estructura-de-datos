package Taller_25;

import java.util.Scanner;

public class Ejercicio_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arreglo = {4, 6, 8, 2, 6, 9, 6, 1};
        System.out.print("Ingresa el número a buscar: ");
        int x = sc.nextInt();

        int contador = 0;
        for (int num : arreglo) {
            if (num == x) {
                contador++;
            }
        }

        System.out.println("El número " + x + " aparece " + contador + " veces.");
    }
}
