package Season_8.Momento_2;

import Season_5.Momento_1.Contenedor;

public class Manifiesto {

    Contenedor[] lista;

    public Manifiesto(int tamaño){
        lista = new Contenedor[tamaño];
    }


    public void agregarContenedor (int index, Contenedor c) {

        lista[index] = c;
    }

    public double calcularPesoTotal(){

        double total = 0;

        if(int i = 0; i < lista.length; i++){
            total += lista[i].getPeso();
        }

        return total;
    }
}
