package Season_6;

public class mapaCarga {

    public static void main(String[] args) {

        // Creación de la matriz 3x3
        int[][] mc = new int[3][3];

        // Llenar la matriz (ejemplo: números consecutivos)
        int contador = 1;

        for (int i = 0; i < mc.length; i++) {
            for (int j = 0; j < mc[i].length; j++) {
                mc[i][j] = contador++;
            }
        }

        // Mostrar posiciones y elementos
        for (int i = 0; i < mc.length; i++) {
            for (int j = 0; j < mc[i].length; j++) {
                System.out.println("mc[" + i + "][" + j + "] = " + mc[i][j]);
            }
        }
    }

    public void mostrarMatriz() {

        System.out.println("\nEstado del Patio de Contenedores:\n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (mc[i][j] == null)
                    System.out.print("[   ]");
                else
                    System.out.print("[ X ]");
            }
            System.out.println();
        }
    }

}
