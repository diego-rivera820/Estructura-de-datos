package Momento_3.util;

import excepciones.PilaDeshacerVaciaException;
import java.util.ArrayDeque;
import java.util.Deque;

//gestor encargado de administrar las operaciones de deshacer y rehacer usando pilas

public class GestorHistorial {

    //uso de pilas, usamos deque (double ended queue) implementado con arraydeque 
    // funcionando estrictamente como pila (push/pop)
    private Deque<AccionDeshacible> pilaDeshacer;
    private Deque<AccionDeshacible> pilaRehacer;

    public GestorHistorial(){
        this.pilaDeshacer = new ArrayDeque<>();
        this.pilaRehacer = new ArrayDeque<>();
    }

    //registra una nueva accionen el historial

    public void registrarAccion(AccionDeshacible accion){
        // push() inserta el elemento en la cima de la pila
        pilaDeshacer.push(accion);

        //al hacer una accion nueva, el futuro alternativo (rehacer) se borra
        pilaRehacer.clear();
    }

    //deshace la ultima accion realizada
    //@throws PilaDeshacerVaciaException si no hay nada que deshacer

    public void deshacer() throws PilaDeshacerVaciaException {
        if(pilaDeshacer.isEmpty()){
            throw new PilaDeshacerVaciaException("No hay operaciones para deshacer");
        }

        //pop saca el elemento de la cima de la pila
        AccionDeshacible accion = pilaDeshacer.pop();
        accion.deshacer(); //ejecutamos la logica de reversa

        //lo pasamos a la pila rehacer
        pilaRehacer.push(accion);
        System.out.println("Operacion deshecha: " + accion.obtenerDescripcion());
    }

    //rehace la ultima accion deshecha
    //lanza la excepcion si no hay nada que rehacer

    public void rehacer() throws PilaDeshacerVaciaException {
        if (pilaRehacer.isEmpty()){
            throw new PilaDeshacerVaciaException("No hay operaciones para rehacer")
        }

        AccionDeshacible accion = pilaRehacer.pop();
        accion.rehacer(); //ejecutamos la logica original nuevamente

        //lo devolvemos a la pila de deshacer
        pilaDeshacer.push(accion);
        System.out.println("Operacion rehecha: " + accion.obtenerDescripcion());
    }
}
