package Season_5.Momento_1;

import java.util.Random;

public class Buque {

    private String nombre;
    private String matricula;

    private static String[] nombres = {
            "Titan", "Poseidón", "Atlántico",
            "Mar Azul", "Neptuno", "Caribe",
            "Pacifico", "Libertad", "Oceanic", "Imperial"
    };

    public Buque() {
        Random r = new Random();

        this.nombre = nombres[r.nextInt(nombres.length)];
        this.matricula = "MAT-" + (1000 + r.nextInt(9000));
    }

    @Override
    public String toString() {
        return nombre + " - " + matricula;
    }
}

    
    

