package momentoE3.util;

import java.util.HashMap;
import momentoE3.excepciones.EstudianteNoEncontradoException;
import momentoE3.modelo.Estudiante;

public class GestorEstudiantes {
    private HashMap<String, Estudiante> directorioEstudiantes;

    public GestorEstudiantes() {
        this.directorioEstudiantes = new HashMap<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        directorioEstudiantes.put(estudiante.getId(), estudiante);
    }

    public Estudiante buscarEstudiante(String id) throws EstudianteNoEncontradoException {
        Estudiante estudiante = directorioEstudiantes.get(id);
        if (estudiante == null) {
            throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + id);
        }
        return estudiante;
    }

    public void mostrarEstudiantes() {
        if (directorioEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante estudiante : directorioEstudiantes.values()) {
            System.out.println("- ID: " + estudiante.getId() + " | Nombre: " + estudiante.getNombre());
        }
    }

    public Estudiante eliminarEstudiante(String id) throws EstudianteNoEncontradoException {
        Estudiante estudiante = buscarEstudiante(id);
        directorioEstudiantes.remove(id);
        return estudiante;
    }
}
