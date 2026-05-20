package momentoE3.util;

import java.util.ArrayDeque;
import java.util.Deque;
import momentoE3.excepciones.PilaDeshacerVaciaException;

public class GestorHistorial {
    private Deque<AccionDeshacible> pilaDeshacer;
    private Deque<AccionDeshacible> pilaRehacer;

    public GestorHistorial() {
        this.pilaDeshacer = new ArrayDeque<>();
        this.pilaRehacer = new ArrayDeque<>();
    }

    public void registrarAccion(AccionDeshacible accion) {
        pilaDeshacer.push(accion);
        pilaRehacer.clear();
    }

    public void deshacer() throws PilaDeshacerVaciaException {
        if (pilaDeshacer.isEmpty()) {
            throw new PilaDeshacerVaciaException("No hay operaciones para deshacer.");
        }

        AccionDeshacible accion = pilaDeshacer.pop();
        accion.deshacer();
        pilaRehacer.push(accion);
        System.out.println("Operacion deshecha: " + accion.obtenerDescripcion());
    }

    public void rehacer() throws PilaDeshacerVaciaException {
        if (pilaRehacer.isEmpty()) {
            throw new PilaDeshacerVaciaException("No hay operaciones para rehacer.");
        }

        AccionDeshacible accion = pilaRehacer.pop();
        accion.rehacer();
        pilaDeshacer.push(accion);
        System.out.println("Operacion rehecha: " + accion.obtenerDescripcion());
    }
}
