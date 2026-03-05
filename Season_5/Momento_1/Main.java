package Season_5.Momento_1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Puerto puerto = new Puerto();
        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Registrar Buque ");
            System.out.println("2. Registrar Contenedor");
            System.out.println("3. Mostrar peso total");
            System.out.println("4. Listar contenedores por origen");
            System.out.println("5. Mostrar matriz");
            System.out.println("6. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    puerto.registrarBuque();
                    break;

                case 2:
                    puerto.registrarContenedor();
                    break;

                case 3:
                    puerto.mostrarPesoTotal();
                    break;

                case 4:
                    puerto.listarPorOrigen();
                    break;

                case 5:
                    puerto.mostrarMatriz();
                    break;

                case 6:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}