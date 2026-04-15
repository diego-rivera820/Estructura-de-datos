

import java.util.LinkedList;
import java.util.Queue;

public class Inspeccion {
Queue<Contenedor> cola;

   

    public Inspeccion(){

        cola = new LinkedList<>();

    }

    public void agregar(Contenedor c){
        cola.add(c);

    }

    public Contenedor atender(){
        return cola.poll();
    }

}
