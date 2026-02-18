package Taller_25;

public class Ejercicio_6 {
    public static void main(String[] args) {
        double[] alquileres = {800, 1200, 1500, 1000};
        double[] porcentajes = {10, 15, 12, 8};

        double[] ganancias = new double[alquileres.length];

        for (int i = 0; i < alquileres.length; i++) {
            ganancias[i] = alquileres[i] * porcentajes[i] / 100;
        }

        for (int i = 0; i < ganancias.length; i++) {
            System.out.println("Ganancia vivienda " + (i+1) + ": " + ganancias[i]);
        }
    }
}

