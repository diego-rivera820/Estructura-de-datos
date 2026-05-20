package momentoE3.modelo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import momentoE3.excepciones.CupoLlenoException;

public class Materia {
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int cuposDisponibles;
    private int creditos;
    
    // Lista enlazada para pre-requisitos
    private LinkedList<Materia> prerrequisitos;
    
    // Cola para estudiantes en espera
    private Queue<Estudiante> colaEspera;

    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.cuposDisponibles = cuposMaximos;
        this.creditos = creditos;
        
        this.prerrequisitos = new LinkedList<>();
        this.colaEspera = new ArrayDeque<>(); 
    }

    // --- GETTERS EXACTOS QUE USA EL MAIN ---
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCuposDisponibles() { return cuposDisponibles; }
    public LinkedList<Materia> getPrerrequisitos() { return prerrequisitos; }
    public Queue<Estudiante> getColaEspera() { return colaEspera; }

    // --- MÉTODOS DE LÓGICA ---
    public void ocuparCupo() throws CupoLlenoException {
        if (this.cuposDisponibles <= 0) {
            throw new CupoLlenoException("La materia " + this.nombre + " ya no tiene cupos.");
        }
        this.cuposDisponibles--;
    }

    public void liberarCupo() {
        if (this.cuposDisponibles < this.cuposMaximos) {
            this.cuposDisponibles++;
        }
    }

    public void encolarEstudiante(Estudiante estudiante) {
        this.colaEspera.offer(estudiante);
    }
}