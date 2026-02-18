package Taller_25;

import java.util.*;

public class Ejercicio_2 {
    public static void main(String[] args) throws Exception {
            int[] a = {10, 20,15, 8, 12};
            int[] b = { 2, 3, 4, 1, 2};
            int[] c = { 3, 3, 5, 3, 1};
        
            int[] t = new int[5]; 
            //Reserva en memoria un arreglo de tamaño 5 para almacenar
            // la operacion del cálculo de cada trabajador
        
            for(int i = 0; i < a.length; i++){
            t[i] = a[i] + b[i] - c[i]; 
            //Almacena en el arreglo t la operación establecida en el pdf
            }

            for(int i = 0; i < a.length; i++){
            System.out.print("t[" + i + "]=" + t[i] + " | ");
            //Muestra la información que se almacenó en el arreglo t
        }
    }
}
