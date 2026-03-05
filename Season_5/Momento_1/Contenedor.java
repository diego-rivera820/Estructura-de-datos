package Season_5.Momento_1;

import java.util.Random;

public class Contenedor {

    private static int contador = 1;
    private String codigo;
    private double peso;
    private String origen;

    private static String[] paises = {
            "Colombia", "China", "Estados Unidos",
            "Brasil", "Alemania", "Japón",
            "México", "España", "Canadá", "Chile"
    };

    public Contenedor() {
        Random r = new Random();

        this.codigo = "CONT-" + contador++;
        this.peso = 5 + (45 * r.nextDouble()); // Entre 5 y 50 toneladas
        this.origen = paises[r.nextInt(paises.length)];
    }

    public double getPeso() {
        return peso;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
    



    
    

    

