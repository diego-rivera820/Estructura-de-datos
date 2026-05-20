package momentoE3.util;

import java.util.ArrayDeque;
import java.util.Deque;

public class GestorReportes {
    private Deque<String> pilaNavegacion;

    public GestorReportes() {
        this.pilaNavegacion = new ArrayDeque<>();
    }

    public void verNuevoReporte(String reporte) {
        System.out.println(reporte);
        pilaNavegacion.push(reporte);
    }

    public void navegarAtras() {
        if (pilaNavegacion.isEmpty()) {
            System.out.println("No hay reportes en el historial.");
            return;
        }

        if (pilaNavegacion.size() == 1) {
            System.out.println("Estas en el primer reporte visto. No puedes ir mas atras.");
            return;
        }

        pilaNavegacion.pop();
        System.out.println("\n--- VOLVIENDO AL REPORTE ANTERIOR ---");
        System.out.println(pilaNavegacion.peek());
    }
}
