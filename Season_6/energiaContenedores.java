package Season_6;

import java.util.Random;

public class energiaContenedores {

     int energiaContenedores[] = new int[12];
        public void llenarEnergiaContenedores() {
            Random r = new Random();
            for (int i = 0; i < energiaContenedores.length; i++) {
                energiaContenedores[i] = 50 + r.nextInt() * 100;//entre 50 y 150
            }
        }
         
    }

