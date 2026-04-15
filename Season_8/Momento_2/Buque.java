package Season_8.Momento_2;

import java.util.Stack;

public class Buque {
    Stack<Contenedor> pila;

    public Buque() {
        pila = new Stack<>();
    }
    // Metodos para apilar y desapilar contenedores y demas
    public void apilar(Contenedor c) {
        pila.push(c);
    }

    public Contenedor desapilar() {
        return pila.pop();
    }

    // metodo quitar contenedor del fondo
    public void quitarFondo() {
        Stack<Contenedor> aux = new Stack<>();

        while (!pila.isEmpty()) {
            aux.push(pila.pop());
        }

        aux.pop(); // elimina el contenedor del fondo

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }

    // BONUS para apilar solo si el peso es menor o igual al del contenedor superior
    public boolean apilarSeguro(Contenedor c) {
        if (pila.isEmpty() || c.peso <= pila.peek().peso) {
            pila.push(c);
            return true;
        }
        return false;
    }
}
