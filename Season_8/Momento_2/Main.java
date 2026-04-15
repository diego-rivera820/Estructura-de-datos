package Season_8.Momento_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaPuerto sistema = new SistemaPuerto();

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Generar contenedores");
            System.out.println("2. Ver manifiesto");
            System.out.println("3. Mover a patio");
            System.out.println("4. Enviar a inspección");
            System.out.println("5. Procesar inspección");
            System.out.println("6. Cargar buque");
            System.out.println("7. Ver buque");
            System.out.println("8. Ver patio");
            System.out.println("9. Quitar fondo del buque");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sistema.generarContenedores();
                    break;
                case 2:
                    sistema.mostrarManifiesto();
                    break;
                case 3:
                    sistema.moverAPatio();
                    break;
                case 4:
                    sistema.enviarInspeccion();
                    break;
                case 5:
                    sistema.procesarInspeccion();
                    break;
                case 6:
                    sistema.cargarBuque();
                    break;
                case 7:
                    sistema.mostrarBuque();
                    break;
                case 8:
                    sistema.mostrarPatio();
                    break;
                case 9:
                    sistema.quitarFondoBuque();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
