package Season_6;

import java.util.Random;


public class Suministro {

    static int[] energiaContenedores = new int[12];
    static int[][] mapaCarga = new int[3][3];

    public static void generarEnergia() {

        Random rand = new Random();

        int[] filtrados = new int[12];
        int contador = 0;

        for(int i = 0; i < energiaContenedores.length; i++) {
            energiaContenedores[i] = rand.nextInt(101) + 50;

            if(energiaContenedores[i] % 10 == 0) {
                filtrados[contador] = energiaContenedores[i];
                contador++;
            }
        }

        int k = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                if(k < contador) {
                    mapaCarga[i][j] = filtrados[k];
                    k++;
                } else {
                    mapaCarga[i][j] = -1;
                }
            }
        }

        System.out.println("Energia generada y mapa creado.");
    }

    public static void mostrarMapa() {

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(mapaCarga[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
