package momentoE3.modelo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import momentoE3.excepciones.CupoLlenoException;

public class Materia {
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int cuposDisponibles;
    private int creditos;
    private LinkedList<Materia> prerrequisitos;
    private Queue<Estudiante> colaEspera;
    private LinkedList<Estudiante> estudiantesInscritos;

    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.cuposDisponibles = cuposMaximos;
        this.creditos = creditos;
        this.prerrequisitos = new LinkedList<>();
        this.colaEspera = new ArrayDeque<>();
        this.estudiantesInscritos = new LinkedList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuposMaximos() {
        return cuposMaximos;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public int getCreditos() {
        return creditos;
    }

    public LinkedList<Materia> getPrerrequisitos() {
        return prerrequisitos;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public LinkedList<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void ocuparCupo() throws CupoLlenoException {
        if (cuposDisponibles <= 0) {
            throw new CupoLlenoException("La materia " + nombre + " ya no tiene cupos.");
        }
        cuposDisponibles--;
    }

    public void liberarCupo() {
        if (cuposDisponibles < cuposMaximos) {
            cuposDisponibles++;
        }
    }

    public boolean estaInscrito(Estudiante estudiante) {
        return estudiantesInscritos.contains(estudiante);
    }

    public void agregarInscrito(Estudiante estudiante) throws CupoLlenoException {
        if (estaInscrito(estudiante)) {
            return;
        }
        ocuparCupo();
        estudiantesInscritos.add(estudiante);
    }

    public boolean retirarInscrito(Estudiante estudiante) {
        boolean eliminado = estudiantesInscritos.remove(estudiante);
        if (eliminado) {
            liberarCupo();
        }
        return eliminado;
    }

    public void encolarEstudiante(Estudiante estudiante) {
        if (!colaEspera.contains(estudiante)) {
            colaEspera.offer(estudiante);
        }
    }
}
