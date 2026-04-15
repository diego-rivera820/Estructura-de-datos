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

        if (nivelEnergia > 100) {
        this.prioridad = "Alta";
        
        } else {
            this.prioridad = "Baja";
        }

    

    }

     /*Paso 1: Filtro de Energía (Arreglo 1D)
     Cree un arreglo de enteros llamado energiaContenedores con 12 valores aleatorios entre 50
     y 150. Genere un segundo arreglo que contenga únicamente los valores que sean múltiplos
     de 10. Los valores que no cumplan esta condición deben descartarse.
     */

    









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
