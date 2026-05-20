package momentoE3.util;

import momentoE3.modelo.Estudiante;
import momentoE3.modelo.Materia;

public class AccionCancelarInscripcion implements AccionDeshacible {
    private GestorMaterias gestor;
    private Materia materia;
    private Estudiante estudiante;

    public AccionCancelarInscripcion(GestorMaterias gestor, Materia materia, Estudiante estudiante) {
        this.gestor = gestor;
        this.materia = materia;
        this.estudiante = estudiante;
    }

    @Override
    public void deshacer() {
        try {
            gestor.inscribirEstudiante(materia, estudiante);
        } catch (Exception e) {
            System.out.println("Error al deshacer cancelacion: " + e.getMessage());
        }
    }

    @Override
    public void rehacer() {
        materia.retirarInscrito(estudiante);
    }

    @Override
    public String obtenerDescripcion() {
        return "Cancelacion de inscripcion de " + estudiante.getNombre() + " en " + materia.getNombre();
    }
}
