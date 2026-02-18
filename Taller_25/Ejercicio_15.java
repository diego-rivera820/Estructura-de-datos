package Taller_25;

public class Ejercicio_15 {
    public static void main(String[] args) {
        String[] nombres = {"Ana", "Luis", "Carlos", "María"};
        double[] sueldos = {1500, 2000, 2000, 1800};

        double suma = 0;
        for (double s : sueldos) {
            suma += s;
        }

        double promedio = suma / sueldos.length;

        System.out.println("Sueldo promedio: " + promedio);
        System.out.println("Trabajadores con sueldo igual al promedio:");

        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i] == promedio) {
                System.out.println(nombres[i]);
            }
        }
    }
}
    

