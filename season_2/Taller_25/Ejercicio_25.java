package Taller_25;

import java.util.Scanner;

public class Ejercicio_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] produccion = new int[20][7];   // 20 plantas x 7 días
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("Producción planta " + (i+1) + " día " + (j+1) + ": ");
                produccion[i][j] = sc.nextInt();
            }
        }

        // Planta con mayor producción semanal
        int maxTotal = 0;
        int plantaMax = 0;
        for (int i = 0; i < 20; i++) {
            int suma = 0;
            for (int j = 0; j < 7; j++) {
                suma += produccion[i][j];
            }
            if (suma > maxTotal) {
                maxTotal = suma;
                plantaMax = i;
            }
        }
        System.out.println("\nPlanta con mayor producción semanal: Planta " + (plantaMax+1) + " con " + maxTotal);

        // Día específico
        System.out.print("Ingresa número de día para comparar (1-7): ");
        int dia = sc.nextInt() - 1;

        int maxDia = 0;
        int plantaMaxDia = 0;
        for (int i = 0; i < 20; i++) {
            if (produccion[i][dia] > maxDia) {
                maxDia = produccion[i][dia];
                plantaMaxDia = i;
            }
        }
        System.out.println("Mayor producción en el día " + (dia+1) + ": Planta " + (plantaMaxDia+1) + " con " + maxDia);
    }
}
