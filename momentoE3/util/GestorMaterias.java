package momentoE3.util;

import java.util.HashMap;
import momentoE3.excepciones.ColaDeEsperaVaciaException;
import momentoE3.excepciones.CupoLlenoException;
import momentoE3.excepciones.PreRequisitoNoAprobadoException;
import momentoE3.modelo.Estudiante;
import momentoE3.modelo.Materia;

public class GestorMaterias {
    private HashMap<String, Materia> directorioMaterias;

    public GestorMaterias() {
        this.directorioMaterias = new HashMap<>();
    }

    public void crearMateria(Materia materia) {
        directorioMaterias.put(materia.getCodigo(), materia);
    }

    public Materia buscarMateria(String codigo) {
        return directorioMaterias.get(codigo);
    }

    public void agregarPrerrequisito(Materia materiaBase, Materia prerrequisito) {
        if (materiaBase == null || prerrequisito == null) {
            System.out.println("Materia base o pre-requisito invalido.");
            return;
        }

        if (!materiaBase.getPrerrequisitos().contains(prerrequisito)) {
            materiaBase.getPrerrequisitos().add(prerrequisito);
        }
    }

    public boolean inscribirEstudiante(Materia materia, Estudiante estudiante)
            throws PreRequisitoNoAprobadoException {
        if (materia == null || estudiante == null) {
            System.out.println("Materia o estudiante invalido.");
            return false;
        }

        if (materia.estaInscrito(estudiante)) {
            System.out.println("El estudiante ya esta inscrito en esta materia.");
            return false;
        }

        validarPrerrequisitos(materia, estudiante);

        try {
            materia.agregarInscrito(estudiante);
            System.out.println("Inscripcion exitosa para: " + estudiante.getNombre());
            return true;
        } catch (CupoLlenoException e) {
            materia.encolarEstudiante(estudiante);
            System.out.println(e.getMessage());
            System.out.println("El estudiante " + estudiante.getNombre() + " fue agregado a la cola de espera.");
            return false;
        }
    }

    public boolean cancelarInscripcion(Materia materia, Estudiante estudiante) {
        if (materia == null || estudiante == null) {
            System.out.println("Materia o estudiante invalido.");
            return false;
        }

        boolean eliminado = materia.retirarInscrito(estudiante);

        if (!eliminado) {
            System.out.println("El estudiante no estaba inscrito en esta materia.");
            return false;
        }

        System.out.println("Inscripcion cancelada. Cupo liberado.");
        asignarPrimerEstudianteEnCola(materia);
        return true;
    }

    public void asignarPrimerEstudianteEnCola(Materia materia) {
        if (materia == null || materia.getColaEspera().isEmpty()) {
            return;
        }

        Estudiante siguiente = materia.getColaEspera().poll();
        try {
            materia.agregarInscrito(siguiente);
            System.out.println("Cupo asignado automaticamente a: " + siguiente.getNombre());
        } catch (CupoLlenoException e) {
            materia.encolarEstudiante(siguiente);
        }
    }

    public Estudiante sacarPrimeroCola(Materia materia) throws ColaDeEsperaVaciaException {
        if (materia == null || materia.getColaEspera().isEmpty()) {
            throw new ColaDeEsperaVaciaException("La cola de espera esta vacia.");
        }
        return materia.getColaEspera().poll();
    }

    private void validarPrerrequisitos(Materia materia, Estudiante estudiante)
            throws PreRequisitoNoAprobadoException {
        for (Materia requisito : materia.getPrerrequisitos()) {
            if (!estudiante.aproboMateria(requisito.getNombre())) {
                throw new PreRequisitoNoAprobadoException(
                    "El estudiante no ha aprobado el pre-requisito: " + requisito.getNombre()
                );
            }
        }
    }
}
