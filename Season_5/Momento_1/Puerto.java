package Season_5.Momento_1;

import java.util.HashMap;

public class Puerto {

    private Contenedor[][] matriz;
    private Buque[] buques;

    public Puerto() {
        matriz = new Contenedor[10][10];
        buques = new Buque[10];
    }

    // Registrar buque automático
    public void registrarBuque() {

        for (int i = 0; i < buques.length; i++) {
            if (buques[i] == null) {
                buques[i] = new Buque();
                System.out.println("Buque registrado: " + buques[i]);
                return;
            }
        }

        System.out.println("No hay espacio para más buques.");
    }

    // Registrar contenedor automático
    public void registrarContenedor() {

        Contenedor nuevo = new Contenedor();

        for (int col = 0; col < 10; col++) {

            for (int fila = 9; fila >= 0; fila--) {

                if (matriz[fila][col] == null) {

                    matriz[fila][col] = nuevo;
                    System.out.println("Contenedor agregado en Fila " + fila + ", Columna " + col);
                    return;
                }
            }
        }

        System.out.println("No hay espacio disponible en la matriz.");
    }

    public void mostrarMatriz() {

        System.out.println("\nEstado del Patio de Contenedores:\n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] == null)
                    System.out.print("[   ]");
                else
                    System.out.print("[ X ]");
            }
            System.out.println();
        }
    }

    public void mostrarPesoTotal() {

        double total = 0;

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if (matriz[i][j] != null)
                    total += matriz[i][j].getPeso();

        System.out.printf("Peso total: %.2f toneladas\n", total);
    }

    public void listarPorOrigen() {

        HashMap<String, Integer> mapa = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (matriz[i][j] != null) {

                    String origen = matriz[i][j].getOrigen();
                    mapa.put(origen, mapa.getOrDefault(origen, 0) + 1);
                }
            }
        }

        System.out.println("\nContenedores por país:");

        for (String pais : mapa.keySet()) {
            System.out.println(pais + ": " + mapa.get(pais));
        }
    }
}