package momentoE3.util;

import java.util.ArrayDeque;
import java.util.Deque;

//gestor encargado de mostrar los reportes y permitir la navegacion hacia atras usando una pila

public class GestorReportes {

    //pila para guardar el historial de reportes vistos
    private Deque<String> pilaNavegacion;

    public GestorReportes(){
        this.pilaNavegacion = new ArrayDeque<>();
    }


    //muestra un nuevo reporte y lo guarda en la cima de la pila

    public void verNuevoReporte(String reporte){
        System.out.println(reporte);
        //se guarda el reporte en la pila para poder volver a él luego
        pilaNavegacion.push(reporte);
    }

    //funcion "atras", saca el reporte actual y muestra el anterior

    public void navegarAtras(){
        if (pilaNavegacion.isEmpty()){
            System.out.println("Error: No hay reportes en el historial para retroceder");
            return;
        }

        //si solo hay un reporte, es el actual no podemos ir mas atras
        if (pilaNavegacion.size() == 1){
            System.out.println("Estas en el primer reporte visto. No puedes ir mas atras");
            return;
        }

        //sacamos de la pila el reporte que quedo en la cima, que es el anterior
        pilaNavegacion.pop();

        //miramos el reporte que quedo en la cima, que es el anterior
        String reporteAnterior = pilaNavegacion.peek();

        System.out.println("\n--- VOLVIENDO AL REPORTE ANTERIOR ---");
        System.out.println(reporteAnterior);
    }
    
}
