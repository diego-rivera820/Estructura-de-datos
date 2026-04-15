

import java.util.Random;

public class Generador {
    static Random r = new Random();

    public static Contenedor generar(int num) {
        String id = "C" + num;
        double peso = 50 + r.nextInt(200); // entre 50 y 250
        int prioridad = 1 + r.nextInt(3); // 1 a 3

        return new Contenedor(id, peso, prioridad);
    }
}

