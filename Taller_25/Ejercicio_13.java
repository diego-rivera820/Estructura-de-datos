package Taller_25;

public class Ejercicio_13 {
    public static void main(String[] args) {
        int[] A = {8, 5, 3, 10, 2, 8, 1};

        int suma = 0;
        for (int num : A) {
            suma += num;
        }

        double media = (double) suma / A.length;

        int[] mayores = new int[A.length];
        int[] menores = new int[A.length];
        int iMay = 0, iMen = 0;

        for (int num : A) {
            if (num > media) {
                mayores[iMay++] = num;
            } else if (num < media) {
                menores[iMen++] = num;
            }
        }

        System.out.println("Media: " + media);

        System.out.print("Mayores que la media: ");
        for (int i = 0; i < iMay; i++) {
            System.out.print(mayores[i] + " ");
        }

        System.out.print("\nMenores que la media: ");
        for (int i = 0; i < iMen; i++) {
            System.out.print(menores[i] + " ");
        }
    }
}
