import java.util.*;

public class SistemaPuerto {

    private Contenedor[][] patio;
    private Stack<Contenedor> buque;
    private Queue<Contenedor> inspeccion;

    public SistemaPuerto(int filas, int columnas) {
        patio = new Contenedor[filas][columnas];
        buque = new Stack<>();
        inspeccion = new LinkedList<>();
    }

    // =========================
    // AGREGAR AL PATIO
    // =========================
    public void agregarAlPatio(Contenedor c) {

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    System.out.println("✔ Contenedor agregado al patio");
                    return;
                }
            }
        }

        System.out.println("❌ Patio lleno");
    }

    // =========================
    // MOSTRAR PATIO
    // =========================
    public void mostrarPatio() {

        System.out.println("\n===== PATIO =====");

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                if (patio[i][j] == null) {
                    System.out.print("[ VACIO ] ");
                } else {
                    System.out.print("[ " + patio[i][j].getId() + " ] ");
                }
            }
            System.out.println();
        }
    }

    // =========================
    // ENVIAR A INSPECCIÓN
    // =========================
    public void enviarInspeccion() {

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                Contenedor c = patio[i][j];

                if (c != null && c.getPrioridad() == 3) {
                    inspeccion.add(c);
                    patio[i][j] = null;
                }
            }
        }

        System.out.println("✔ Contenedores enviados a inspección");
    }

    // =========================
    // PROCESAR INSPECCIÓN
    // =========================
    public void procesarInspeccion() {

        while (!inspeccion.isEmpty()) {
            Contenedor c = inspeccion.poll();
            System.out.println("Inspeccionado: " + c.getId());

            cargarAlaPila(c);
        }
    }

    // =========================
    // CARGAR BUQUE DESDE PATIO
    // =========================
    public void cargarBuque() {

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                Contenedor c = patio[i][j];

                if (c != null) {
                    cargarAlaPila(c);
                    patio[i][j] = null;
                }
            }
        }

        System.out.println("✔ Proceso de carga finalizado");
    }

    // =========================
    // REGLA DE PILA (CLAVE DEL PDF)
    // =========================
    private void cargarAlaPila(Contenedor c) {

        if (buque.isEmpty()) {
            buque.push(c);
            return;
        }

        Contenedor cima = buque.peek();

        if (c.getPeso() <= cima.getPeso()
                && c.getPrioridad() >= cima.getPrioridad()) {

            buque.push(c);

        } else {
            System.out.println("❌ No se puede apilar: " + c.getId());
        }
    }

    // =========================
    // MOSTRAR BUQUE
    // =========================
    public void mostrarBuque() {

        System.out.println("\n===== BUQUE =====");

        if (buque.isEmpty()) {
            System.out.println("Vacío");
            return;
        }

        for (Contenedor c : buque) {
            System.out.println(c);
        }
    }

    // =========================
    // PESO TOTAL
    // =========================
    public double pesoTotal() {

        double total = 0;

        for (Contenedor c : buque) {
            total += c.getPeso();
        }

        return total;
    }
}
