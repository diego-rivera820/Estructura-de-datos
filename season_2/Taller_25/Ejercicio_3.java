package Taller_25;

public class Ejercicio_3 {

    public static void main (String[] args){

        int[] a = {17, 20,15, 8, 12, 19};

        int sumaPares = 0;
        int sumaImpares = 0;

        for(int i = 0; i < a.length; i++){
            int numero = a[i];
        

            if (numero % 2 == 0){
                sumaPares += numero;
            }
            else {
                sumaImpares += numero;
            }
        }
        System.out.println("Suma de números pares: " + sumaPares);
        System.out.println("Suma de números impares: " + sumaImpares);

    }
    
}
