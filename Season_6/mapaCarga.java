package Season_6;

public class mapaCarga {

    private energiaContenedores[][] matriz;

    
    public mapaCarga() {
         matriz = new energiaContenedores[10][10];
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

}
