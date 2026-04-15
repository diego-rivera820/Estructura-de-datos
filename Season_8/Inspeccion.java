package Season_8;

import java.util.LinkedList;
import java.util.Queue;

public class Inspeccion {
Queue<Contenedor> cola;

   

    public Inspeccion(){

        cola = new likendlist<> ();

    }

    public void agregar(Contenedor c){
        cola.add(c);

    }

    public Contenedor atender(){
        return cola.poll();
    }

}
