package Taller_25;

public class Ejercicio_26 {
    public static void main(String[] args) {
        String[] distribuidores = {"Norma", "Caribe", "Alpes", "Norma", "Caribe", "Alpes", "Norma", "Caribe"};
        String[] modelos = {"A","B","C","D","E","F","G","H"};
        double[] precios = {10, 12, 8, 15, 9, 14, 11, 13};

        int dias = 30;
        double[][] ventas = new double[8][dias];

        // Simular ventas diarias aleatorias
        for (int i = 0; i < 8; i++) {
            for (int d = 0; d < dias; d++) {
                ventas[i][d] = (Math.random() * 10 + 1) * precios[i];
            }
        }

        // a) Total por modelo
        double[] totalPorModelo = new double[8];
        for (int i = 0; i < 8; i++) {
            for (int d = 0; d < dias; d++) {
                totalPorModelo[i] += ventas[i][d];
            }
        }
        
        // b) Total por día
        double[] totalPorDia = new double[dias];
        for (int d = 0; d < dias; d++) {
            for (int i = 0; i < 8; i++) {
                totalPorDia[d] += ventas[i][d];
            }
        }

        // c) Modelo que más dinero produjo
        double maxProd = totalPorModelo[0];
        int idxMax = 0;
        for (int i = 1; i < 8; i++) {
            if (totalPorModelo[i] > maxProd) {
                maxProd = totalPorModelo[i];
                idxMax = i;
            }
        }

        System.out.println("Recaudación por modelo:");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%s (Distribuidor: %s) -> %.2f\n", modelos[i], distribuidores[i], totalPorModelo[i]);
        }

        System.out.println("\nTotal recaudado por día:");
        for (int d = 0; d < dias; d++) {
            System.out.printf("Día %d: %.2f\n", (d+1), totalPorDia[d]);
        }

        System.out.println("\nModelo que más dinero produjo: " + modelos[idxMax] + " -> " + maxProd);
    }
}
