public class MostrarPatio {

    public static void mostrar(Contenedor[][] patio) {

        System.out.println("\n===== PATIO =====");

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                if (patio[i][j] == null) {
                    System.out.print("[ VACIO ] ");
                } else {
                    System.out.print("[ " + patio[i][j].getId() + " ] ");
                }
            }
            System.out.println();
        }
    }
}
