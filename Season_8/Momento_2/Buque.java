import java.util.Stack;

public class Buque {

    Stack<Contenedor> pila;

    public Buque() {
        pila = new Stack<>();
    }

    public void apilar(Contenedor c) {

        if (pila.isEmpty() || c.getPeso() <= pila.peek().getPeso()) {
            pila.push(c);
            System.out.println("✅ Contenedor cargado");
        } else {
            System.out.println("❌ No se puede apilar (peso mayor)");
        }
    }

    public void mostrar() {

        if (pila.isEmpty()) {
            System.out.println("⚠️ Buque vacío");
            return;
        }

        System.out.println("\n--- BUQUE ---");
        for (Contenedor c : pila) {
            System.out.println(c);
        }
    }
}
