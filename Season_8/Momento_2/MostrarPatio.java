package Season_8.Momento_2;

public void mostrarPatio() {
    System.out.println("\n--- PATIO ---");

    for (int i = 0; i < patio.length; i++) {
        for (int j = 0; j < patio[i].length; j++) {

            if (patio[i][j] == null) {
                System.out.print("[ VACIO ] ");
            } else {
                System.out.print("[" + patio[i][j].id + "] ");
            }

        }
        System.out.println();
    }
}
