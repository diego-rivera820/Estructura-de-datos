package momentoE3.util;

import java.util.Stack;

public class GestorRutas {
    private final int NUM_EDIFICIOS = 5;
    private int[][] matrizAdyacencia;
    private String[] nombresEdificios;
    private final int INFINITO = 999999;

    public GestorRutas() {
        matrizAdyacencia = new int[NUM_EDIFICIOS][NUM_EDIFICIOS];
        nombresEdificios = new String[]{"Ingenieria", "Biblioteca", "Cafeteria", "Rectoria", "Laboratorio"};

        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            for (int j = 0; j < NUM_EDIFICIOS; j++) {
                matrizAdyacencia[i][j] = (i == j) ? 0 : INFINITO;
            }
        }
    }

    public void agregaConexion(int origen, int destino, int distancia) {
        if (!indiceValido(origen) || !indiceValido(destino) || distancia <= 0) {
            System.out.println("Datos de conexion invalidos.");
            return;
        }

        matrizAdyacencia[origen][destino] = distancia;
        matrizAdyacencia[destino][origen] = distancia;
    }

    public void mostrarEdificios() {
        System.out.println("Edificios registrados:");
        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            System.out.println(i + ": " + nombresEdificios[i]);
        }
    }

    public void calcularRutaMasCorta(int origen, int destino) {
        if (!indiceValido(origen) || !indiceValido(destino)) {
            System.out.println("Origen o destino invalido.");
            return;
        }

        int[] distancias = new int[NUM_EDIFICIOS];
        boolean[] visitados = new boolean[NUM_EDIFICIOS];
        int[] previo = new int[NUM_EDIFICIOS];

        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            distancias[i] = INFINITO;
            visitados[i] = false;
            previo[i] = -1;
        }

        distancias[origen] = 0;

        for (int i = 0; i < NUM_EDIFICIOS - 1; i++) {
            int u = distanciaMinima(distancias, visitados);
            if (u == -1) {
                break;
            }

            visitados[u] = true;

            for (int v = 0; v < NUM_EDIFICIOS; v++) {
                if (!visitados[v]
                        && matrizAdyacencia[u][v] != INFINITO
                        && distancias[u] != INFINITO
                        && distancias[u] + matrizAdyacencia[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + matrizAdyacencia[u][v];
                    previo[v] = u;
                }
            }
        }

        imprimirRuta(origen, destino, distancias, previo);
    }

    private int distanciaMinima(int[] distancias, boolean[] visitados) {
        int min = INFINITO;
        int minIndex = -1;

        for (int v = 0; v < NUM_EDIFICIOS; v++) {
            if (!visitados[v] && distancias[v] <= min) {
                min = distancias[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void imprimirRuta(int origen, int destino, int[] distancias, int[] previo) {
        if (distancias[destino] == INFINITO) {
            System.out.println("No hay ruta disponible entre estos edificios.");
            return;
        }

        Stack<Integer> ruta = new Stack<>();
        int actual = destino;

        while (actual != -1) {
            ruta.push(actual);
            actual = previo[actual];
        }

        StringBuilder camino = new StringBuilder();
        int nodoAnterior = ruta.pop();
        camino.append(nombresEdificios[nodoAnterior]);

        while (!ruta.isEmpty()) {
            int nodoSiguiente = ruta.pop();
            int metrosTramo = matrizAdyacencia[nodoAnterior][nodoSiguiente];
            camino.append(" -> ")
                  .append(nombresEdificios[nodoSiguiente])
                  .append(" (")
                  .append(metrosTramo)
                  .append("m)");
            nodoAnterior = nodoSiguiente;
        }

        System.out.println("--- RESULTADO ---");
        System.out.println("Ruta mas corta:");
        System.out.println(camino);
        System.out.println("Distancia TOTAL: " + distancias[destino] + " metros");
    }

    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < NUM_EDIFICIOS;
    }
}
