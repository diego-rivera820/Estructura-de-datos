public class Manifesto {

    Contenedor[] lista;

    public Manifesto(int tamaño) {
        lista = new Contenedor[tamaño];
    }

    public void agregarContenedor(int index, Contenedor c) {
        lista[index] = c;
    }

    public double calcularPesoTotal() {
        double total = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                total += lista[i].getPeso();
            }
        }

        return total;
    }
}
