package Taller_25;

public class Ejercicio_4 {

    
        public static void main(String[] args) {
            int[] edades1 = {10, 25, 30, 18};
            int[] edades2 = {22, 40, 35, 28};

            int mayor = edades1[0];

            for (int edad : edades1) {
                if (edad > mayor) {
                mayor = edad;
                }   
            }

            for (int edad : edades2) {
                if (edad > mayor) {
                mayor = edad;
                }
            }

            System.out.println("El mayor valor es: " + mayor);
        }
}

    

