package Taller_25;

public class Ejercicio_5 {
    public static void main(String[] args) {
        String[] desc = {"Pan", "Leche", "Huevos"};
        double[] pu = {2000, 3500, 500};
        int[] cc = {2, 3, 12};

        double[] tg = new double[pu.length];
        double totalGeneral = 0;
        double mayor = 0;
        String descrMayor = "";

        for (int i = 0; i < pu.length; i++) {
            tg[i] = pu[i] * cc[i];
            totalGeneral += tg[i];

            if (tg[i] > mayor) {
                mayor = tg[i];
                descrMayor = desc[i];
            }
        }

        System.out.println("Total general: " + totalGeneral);
        System.out.println("Producto con mayor gasto: " + descrMayor + " -> " + mayor);
    }
}
