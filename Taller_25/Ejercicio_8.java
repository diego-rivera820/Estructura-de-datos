package Taller_25;

import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[30];

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Número " + (i+1) + ": ");
            nums[i] = sc.nextInt();
        }

        int mayor = nums[0], menor = nums[0];
        int repMayor = 0, repMenor = 0;

        for (int n : nums) {
            if (n > mayor) mayor = n;
            if (n < menor) menor = n;
        }

        for (int n : nums) {
            if (n == mayor) repMayor++;
            if (n == menor) repMenor++;
        }

        System.out.println("Mayor: " + mayor + ", se repite: " + repMayor);
        System.out.println("Menor: " + menor + ", se repite: " + repMenor);
    }
}

