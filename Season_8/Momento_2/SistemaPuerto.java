import java.util.*;

import Season_5.Momento_1.Contenedor;

public class SistemaPuerto {

    Contenedor[] manifiesto = new Contenedor[5];
    Contenedor[][] patio = new Contenedor[3][3];
    Queue<Contenedor> inspeccion = new LinkedList<>();
    Stack<Contenedor> buque = new Stack<>();

    int contador = 1;

    //  generar y meter al manifiesto
    public void generarContenedores() {
        for (int i = 0; i < manifiesto.length; i++) {
            manifiesto[i] = Generador.generar(contador++);
        }
        System.out.println("Contenedores generados!");
    }

    //  mostrar manifiesto
    public void mostrarManifiesto() {
        double total = 0;

        for (Contenedor c : manifiesto) {
            if (c != null) {
                System.out.println(c);
                total += c.peso;
            }
        }

        System.out.println("Peso total: " + total);
    }

    //  mover a patio
    public void moverAPatio() {
        for (Contenedor c : manifiesto) {
            if (c != null) {
                if (!ubicarEnPatio(c)) {
                    System.out.println("Puerto Saturado!");
                    return;
                }
            }
        }
        System.out.println("Movidos al patio!");
    }

    private boolean ubicarEnPatio(Contenedor c) {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }

    //  enviar a inspección
    public void enviarInspeccion() {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                Contenedor c = patio[i][j];

                if (c != null && (c.prioridad == 3)) {
                    inspeccion.add(c);
                    patio[i][j] = null;
                }
            }
        }
        System.out.println("Enviados a inspección!");
    }

    //  procesar inspección
    public void procesarInspeccion() {
        while (!inspeccion.isEmpty()) {
            Contenedor c = inspeccion.poll();
            System.out.println("Inspeccionado: " + c);

            apilarSeguro(c);
        }
    }

    //  cargar buque
    public void cargarBuque() {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                Contenedor c = patio[i][j];

                if (c != null) {
                    apilarSeguro(c);
                    patio[i][j] = null;
                }
            }
        }
        System.out.println("Buque cargado!");
    }

    //  pila con regla BONUS
    private void apilarSeguro(Contenedor c) {
        if (buque.isEmpty() || c.peso <= buque.peek().peso) {
            buque.push(c);
        } else {
            System.out.println("No se pudo apilar (peso mayor): " + c.id);
        }
    }

    //  mostrar buque
    public void mostrarBuque() {
        System.out.println("Contenido del buque:");
        for (Contenedor c : buque) {
            System.out.println(c);
        }
    }

    public void quitarFondoBuque() {
    if (buque.isEmpty()) {
        System.out.println("El buque está vacío");
        return;
    }

    Stack<Contenedor> aux = new Stack<>();

    // pasar todo
    while (!buque.isEmpty()) {
        aux.push(buque.pop());
    }

    // eliminar el fondo
    Contenedor eliminado = aux.pop();
    System.out.println("Eliminado del fondo: " + eliminado);

    // devolver
    while (!aux.isEmpty()) {
        buque.push(aux.pop());
    }
}

}
