

public class Patio {

    Contenedor[][] matriz;

    public Patio(int filas, int columnas) {
        matriz = new Contenedor[filas][columnas];
    }

    public boolean ubicarContenedor(Contenedor c) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == null) {
                    matriz[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }
}
