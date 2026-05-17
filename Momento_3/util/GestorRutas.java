package Momento_3.util;

import java.util.Stack;

//gestor encargado de las rutas del campus utilizando grafos y el algoritmo de dijkstra

public class GestorRutas {

    private final int NUM_EDIFICIOS = 5;
    // matriz nativa para distancias
    private int[][] matrizAdyacencia;
    //arreglo nativo para mapear el indice numerico al nombre del edificio
    private String[] nombresEdificios;

    //uso un valor muy alto para representar el infinnito(no hay conexion directa)
    private final int INFINITO = 999999;

    public GestorRutas(){
        matrizAdyacencia = new int[NUM_EDIFICIOS][NUM_EDIFICIOS];
        nombresEdificios = new String[]{"ingenieria", "Biblioteca", "Cafeteria", "Rectoria", "Laboratorio"};

        //inicializamos la matriz. si i == j la distancia es 0. sino, es infinito
        for (int i = 0; i < NUM_EDIFICIOS; i++){
            for(int j = 0; j < NUM_EDIFICIOS; j++){
                if (i == j) {
                    matrizAdyacencia[i][j] = 0;
                } else {
                    matrizAdyacencia[i][j] = INFINITO;
                }
            }
        }
    }

    //agrega un camino entre dos edificios (grafo no dirigido)
    public void agregaConexion(int origen, int destino, int distancia){
        //al ser no dirigido, la distancia es igual en ambos sentidos
        matrizAdyacencia[origen][destino] = distancia;
        matrizAdyacencia[destino][origen] = distancia;
    }

    public void mostrarEdificios(){
        System.out.println("Edificios registrados:");
        for (int i = 0; i < NUM_EDIFICIOS; i++){
            System.out.println(i + ": " + nombresEdificios[i]);
        }
    }

    //implementacion pura del algoritmo de dijkstra
    public void calcularRutaMasCorta(int origen, int destino){
        int[] distancias = new int[NUM_EDIFICIOS]; //guarda la distancia minima desde el origen
        boolean[] visitados = new boolean[NUM_EDIFICIOS]; // marca los nodos ya procesados
        int[] previo = new int[NUM_EDIFICIOS]; //guarda el nodo anterior para reconstruir la ruta
    
        //configuracion inicial
        for (int i = 0; i < NUM_EDIFICIOS; i++){
            distancias[i] = INFINITO;
            visitados[i] = false;
            previo[i] = -1; //significa que no tiene nodo previo aun
        }
        distancias[origen] = 0; // la distancia al origen es 0

        //procesar todos los vertices
        for(int i = 0; i < NUM_EDIFICIOS - 1; i++){
            //encontrar el vertice no visitado con la dstancia minima
            int u = distanciaMinima(distancia, visitados);
            visitados[u] = true;

            //actualizar las distancias de los vertices adyacentes al vertice seleccionado (u)
            for (int v = 0; v < NUM_EDIFICIOS; v++){
                //si no ha sido visitado hay conexion (!= INFINITO) y el camino a traves de la ues mas corto
                if(!visitados[v] && matrizAdyacencia[u][v] != INFINITO
                    && distancias[u] + matrizAdyacencia[u][v] < distancias[v]){

                        distancias[v] = distancias[u] + matrizAdyacencia[u][v];
                        previo[v] = u; //guardamos de donde venimos para poder dibujar la ruta luego
                }
                
            }
        }

        //imprimir el resultado (el camino completo y la distancia total)
        imprimirRuta(origen, destino, distancias, previo);
    }

    //metodo auxiliar para encontrar el vertice de la distancia minima
    private int distanciaMinima(int[] distancias, boolena[] visitados){
        int min = INFINITO;
        int minIndex = -1;

        for(int v = 0; v < NUM_EDIFICIOS; v++){
            if (!visitados[v] && distancias[v] <= min){
                min = distancias[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void imprimirRuta(int origen; int destino; int[] distancias, int[] previo){
        if(distancias[destino] == INFINITO){
            System.out.println("No hay ruta disponible entre estos edificios");
            return;
        }

        System.out.println("--- RESULTADO ---");
        System.out.println("Ruta mas corta:");

        //uso la clase stack de java como auxiliar rapido para invertir el orden del camino
        Stack<Integer> ruta = new Stack<>();
        int actual = destino;

        //Rastrear hacia atras desde el destino hasta el origen
        while(actual != -1){
            ruta.push(actual);
            actual = previo[actual];
        }

        //imprimir sacando de la pila
        StringBuldier caminoAImprimir = new StringBuldier();
        int nodoAnterior = ruta.pop();
        caminoAImprimir.append(nombresEdificios[nodoAnterior]);

        While (!ruta.isEmpty()){
            int nodoSiguiente = ruta.pop();
            int metrosTramo = matrizAdyacencia[nodoAnterior][nosoSiguiente];
            caminoAImprimir.Append(" -> ").append(nombresEdificios)[nodoSiguiente]).append(" (").append(metrosTramo).append("m)");
            nodoAnterior = nodoSiguiente;
        }

        System.out.println(caminoAImprimir.toString());
        System.out.println("Distancia TOTAL: " + distancias[destino] + " metros");
    }
    
}
