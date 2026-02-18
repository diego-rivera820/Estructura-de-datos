package Taller_25;

public class Ejercicio_16 {
    public static void main(String[] args) {
        String[] nombres = {"Pedro", "Laura", "Jorge", "Ana"};
        int[] edades = {45, 30, 55, 28};
        char[] sexos = {'M', 'F', 'M', 'F'};

        int sumaEdades = 0;
        for (int edad : edades) {
            sumaEdades += edad;
        }
        double promedio = (double) sumaEdades / edades.length;

        int idxMenor = 0, idxMayor = 0;
        for (int i = 1; i < edades.length; i++) {
            if (edades[i] < edades[idxMenor]) idxMenor = i;
            if (edades[i] > edades[idxMayor]) idxMayor = i;
        }

        int contMayorPromedioF = 0, contMenorPromedioM = 0;
        for (int i = 0; i < edades.length; i++) {
            if (sexos[i] == 'F' && edades[i] > promedio) contMayorPromedioF++;
            if (sexos[i] == 'M' && edades[i] < promedio) contMenorPromedioM++;
        }

        System.out.println("Edad promedio: " + promedio);
        System.out.println("Profesor más joven: " + nombres[idxMenor]);
        System.out.println("Profesor con mayor edad: " + nombres[idxMayor]);
        System.out.println("Número de profesoras con edad mayor al promedio: " + contMayorPromedioF);
        System.out.println("Número de profesores con edad menor al promedio: " + contMenorPromedioM);
    }
}

