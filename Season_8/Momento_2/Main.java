import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaPuerto sistema = new SistemaPuerto(3, 3);

        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Agregar contenedor");
            System.out.println("2. Ver patio");
            System.out.println("3. Enviar a inspección");
            System.out.println("4. Procesar inspección");
            System.out.println("5. Cargar buque");
            System.out.println("6. Ver buque");
            System.out.println("7. Peso total");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Peso (usar punto): ");
                    double peso = sc.nextDouble();

                    System.out.print("Prioridad: ");
                    int prioridad = sc.nextInt();

                    Contenedor c = new Contenedor(id, peso, prioridad);
                    sistema.agregarAlPatio(c);
                    break;

                case 2:
                    sistema.mostrarPatio();
                    break;

                case 3:
                    sistema.enviarInspeccion();
                    break;

                case 4:
                    sistema.procesarInspeccion();
                    break;

                case 5:
                    sistema.cargarBuque();
                    break;

                case 6:
                    sistema.mostrarBuque();
                    break;

                case 7:
                    System.out.println("Peso total: " + sistema.pesoTotal());
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
