package momentoE3.util;
import momentoE3.modelo.Estudiante;

public class AccionEliminarEstudiante implements AccionDeshacible {
    private GestorEstudiantes gestor;
    private Estudiante estudianteEliminado;

    public AccionEliminarEstudiante(GestorEstudiantes gestor, Estudiante estudianteEliminado) {
        this.gestor = gestor;
        this.estudianteEliminado = estudianteEliminado; 
    }

    @Override
    public void deshacer() { 
        // la reversa de eliminar es volver a registrarlo
        gestor.registrarEstudiante(estudianteEliminado); 
    }

    @Override
    public void rehacer() { 
        try { 
            // CORRECCIÓN: Usamos getId() porque el gestor elimina por ID, no por nombre
            gestor.eliminarEstudiante(estudianteEliminado.getId()); 
        } catch (Exception e) {
            System.out.println("Error al rehacer: " + e.getMessage());
        }
    }

    @Override
    public String obtenerDescripcion() { 
        // CORRECCIÓN: La 'N' de getNombre() va en mayúscula
        return "Eliminacion del estudiante " + estudianteEliminado.getNombre(); 
    }
}