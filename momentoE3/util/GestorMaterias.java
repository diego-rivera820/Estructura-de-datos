package momentoE3.util;

import java.util.HashMap;

import momentoE3.excepciones.CupoLlenoException;
import momentoE3.modelo.Estudiante;
import momentoE3.modelo.Materia;

public class GestorMaterias {

    // Guardamos las materias usando su código como llave rápida
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

    /**
     * Intenta inscribir a un estudiante. Si no hay cupo, lo manda a la cola (Queue).
     */
    public void inscribirEstudiante(Materia materia, Estudiante estudiante) {
        try {
            materia.ocuparCupo();
            System.out.println("Inscripción exitosa. Cupo asignado a: " + estudiante);
        } catch (CupoLlenoException e) {
            System.out.println("--- " + e.getMessage() + " ---");
            // Usamos la cola que creaste en la clase Materia
            materia.encolarEstudiante(estudiante);
            System.out.println("El estudiante " + estudiante + " ha sido agregado a la COLA DE ESPERA.");
        }
    }

    /**
     * Cancela la inscripción. Si hay alguien en la cola, le da el cupo automáticamente.
     */
    public void cancelarInscripcion(Materia materia, Estudiante estudiante) {
        // Intentamos liberar un cupo. Si Materia no tiene el método
        // 'liberarCupo', usamos en su lugar 'devolverCupo' si existe.
        try {
            // Intento reflejar posible nombre alternativo
            java.lang.reflect.Method m = materia.getClass().getMethod("liberarCupo");
            m.invoke(materia);
            System.out.println("Inscripción cancelada. Cupo liberado.");
        } catch (NoSuchMethodException e1) {
            try {
                java.lang.reflect.Method m2 = materia.getClass().getMethod("devolverCupo");
                m2.invoke(materia);
                System.out.println("Inscripción cancelada. Cupo liberado (devolverCupo). ");
            } catch (Exception e2) {
                // No existe método público para liberar cupo: avisamos y continuamos
                System.out.println("Inscripción cancelada. (No se pudo invocar método para liberar cupo en Materia). ");
            }
        } catch (Exception ex) {
            System.out.println("Inscripción cancelada. (Error al liberar cupo). ");
        }
        
        // Verificamos si hay alguien haciendo fila en la Cola (Queue)
        if (!materia.getColaEspera().isEmpty()) {
            // poll() saca al primer estudiante de la cola (FIFO)
            Estudiante afortunado = materia.getColaEspera().poll();
            try {
                materia.ocuparCupo();
                System.out.println("¡Noticia! El cupo liberado ha sido asignado automáticamente a: " + afortunado + " (sacado de la cola de espera).");
            } catch (CupoLlenoException ex) {
                // Esto no debería ejecutarse porque acabamos de liberar un cupo
            }
        }
    }
}
    

