package momentoE3.util;

import java.util.TreeMap;
import momentoE3.modelo.Aula;

public class GestorAulas {
    private TreeMap<String, Aula> directorioAulas;

    public GestorAulas() {
        this.directorioAulas = new TreeMap<>();
    }

    public void registrarAula(Aula aula) {
        directorioAulas.put(aula.getNombre(), aula);
    }

    public Aula buscarAula(String nombre) {
        return directorioAulas.get(nombre);
    }

    public void listarAulasOrdenadas() {
        if (directorioAulas.isEmpty()) {
            System.out.println("No hay aulas registradas.");
            return;
        }

        System.out.println("--- AULAS DISPONIBLES ---");
        for (Aula aula : directorioAulas.values()) {
            System.out.println("Aula: " + aula.getNombre() + " - Capacidad: " + aula.getCapacidad());
        }
    }
}
