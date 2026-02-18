package Taller_25;

import java.util.Scanner;

public class Ejercicio_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] toneladas = new int[12];
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        // Leer producción mensual
        for (int i = 0; i < toneladas.length; i++) {
            System.out.print("Toneladas de " + meses[i] + ": ");
            toneladas[i] = sc.nextInt();
        }

        // Calcular promedio
        int suma = 0;
        for (int t : toneladas) {
            suma += t;
        }
        double promedio = (double) suma / toneladas.length;

        // Contar meses arriba/abajo del promedio y hallar mayor
        int arriba = 0, abajo = 0;
        int mayor = toneladas[0], mesMayorIdx = 0;

        for (int i = 0; i < toneladas.length; i++) {
            if (toneladas[i] > promedio) arriba++;
            if (toneladas[i] < promedio) abajo++;
            if (toneladas[i] > mayor) {
                mayor = toneladas[i];
                mesMayorIdx = i;
            }
        }

        System.out.println("\nPromedio anual: " + promedio);
        System.out.println("Meses por encima del promedio: " + arriba);
        System.out.println("Meses por debajo del promedio: " + abajo);
        System.out.println("Mes con mayor producción: " + meses[mesMayorIdx] + " (" + mayor + " toneladas)");
    }
}
