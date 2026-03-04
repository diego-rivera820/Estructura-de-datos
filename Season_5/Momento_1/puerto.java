package Season_5.Momento_1;
import java.util.HashMap;

public class puerto {

    private Contenedor [][] matriz;
    private Buque [] buques;
    
    public puerto() {
        matriz = new Contenedor [10][10];
        buques = new Buque [10];
    }

    //Registrar buque
    public void registrarbuque(Buque buque){

        for (int i = 0; i < buques.length; i++){
            if (buques[i] == null){
                buques[i] = buque;
                System.out.println("buque registrado en pocision: " + i);
                return;
            }

        }
        System.out.println("No hay espacio disponible para mas buques.");

    }

    //Registrar contenedor (apilado)
    public void registrarContenedor(int columna, Contenedor contenedor){

        if (columna < 0 || columna > 10){
            System.out.println("columna no valida");
            return;

        }

        for (int fila = 9; fila >= 0; fila--){
            if (matriz[fila][columna] == null){
                matriz[fila][columna] = contenedor;
                System.out.println("contenedor registrado en pocision: " + fila + "," + columna);
                return;
            }
        }
        System.out.println("cvolumna llena, no se puede agregar mas contenedores.");

    }

    //Mostrar matriz
    public void mostrarMatriz(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (matriz[i][j] == null){
                    System.out.println("[  ]");

                } else {
                    System.out.println("[ x ]");
                }
            }
            System.out.println();
        }
    }

    //peso total
    public void mostrarPesoTotal(){
        double total = 0;
        HashMap<String, Integer> mapa = new HashMap<>();

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (matriz[i][j] != null){
                    String id = matriz[i][j].getId();
                    mapa.put(id, mapa.getOrDefault(id, 0) + 1);
                }
            }
        }
        System.out.println("contenedores agrupados por origen:");
        for (String id : mapa.keySet()) {
            System.out.println("- " + id + ": " + mapa.get(id));
        }
    }


    
}
