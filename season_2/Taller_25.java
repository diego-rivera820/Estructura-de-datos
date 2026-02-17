import java.util.Scanner;

public class Taller_25 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de elementos del arreglo: ");
        int n = sc.nextInt();

        int [] a = new int[n];

        for (int i = 0; i < a.length; i++){
            System.out.println("Ingrese el elemento " + (i+1) + ": ");
            a[i] = sc.nextInt();
        }

        int total = 0;
        for(int i = 0; i < a.length; i++){
            total += a[i];
        }
        System.out.println("La suma de los elementos del arreglo es: " + total);

    }
}
