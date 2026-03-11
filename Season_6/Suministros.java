package Season_6;

import java.util.Random;

public class Suministros {

    private String id;
    private int nivelEnergia;
    private String prioridad;

    public Suministros(String id, Double nivelEnergia, String prioridad) {
        Random r = new Random();
        this.id = id;
        this.nivelEnergia = 50 + r.nextInt() * 101;// entre 50 y 150
        this.prioridad = prioridad;

        if (nivelEnergia > 100)

        {
            this.prioridad = "Alta";
        } else {
            this.prioridad = "Baja";
        }

        

    }

     

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

}
