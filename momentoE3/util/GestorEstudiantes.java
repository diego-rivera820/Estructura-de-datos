package momentoE3.util;

import momentoE3.modelo.Estudiante;
import momentoE3.excepciones.EstudianteNoEncontradoException;
import java.util.HashMap;

public class GestorEstudiantes {
    
    private HashMap<String, Estudiante> directorioEstudiantes;

    public GestorEstudiantes() {
        this.directorioEstudiantes = new HashMap<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        directorioEstudiantes.put(estudiante.getId(), estudiante);
    }

    public Estudiante buscarEstudiante(String id) throws EstudianteNoEncontradoException {
        if (!directorioEstudiantes.containsKey(id)) {
            throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + id);
        }
        return directorioEstudiantes.get(id);
    }

    public void mostrarEstudiantes() {
        if (directorioEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (Estudiante est : directorioEstudiantes.values()) {
            System.out.println("- ID: " + est.getId() + " | Nombre: " + est.getNombre());
        }
    }

    public Estudiante eliminarEstudiante(String id) throws EstudianteNoEncontradoException {
        Estudiante est = buscarEstudiante(id);
        directorioEstudiantes.remove(id);
        return est;
    }
}