package momentoE3.util;

// interfaz que define el comportamiento de cualquier operacion que pueda ser deshecha o rehecha
// esto aplica polimorfismo: la pila no necesita saber que accion esta deshaciendo, solo llama a este metodo

public interface AccionDeshacible {

    void deshacer();
    void rehacer();
    String obtenerDescripcion(); // para mostrar en consola que se deshizo

}
