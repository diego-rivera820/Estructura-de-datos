package momentoE3.util;

import momentoE3.modelo.Estudiante;
import momentoE3.modelo.Materia;

public class AccionInscribirEstudiante implements AccionDeshacible {
    private GestorMaterias gestor;
    private Materia materia;
    private Estudiante estudiante;

    public AccionInscribirEstudiante(GestorMaterias gestor, Materia materia, Estudiante estudiante) {
        this.gestor = gestor;
        this.materia = materia;
        this.estudiante = estudiante;
    }

    @Override
    public void deshacer() {
        materia.retirarInscrito(estudiante);
    }

    @Override
    public void rehacer() {
        try {
            gestor.inscribirEstudiante(materia, estudiante);
        } catch (Exception e) {
            System.out.println("Error al rehacer inscripcion: " + e.getMessage());
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Inscripcion de " + estudiante.getNombre() + " en " + materia.getNombre();
    }
}
