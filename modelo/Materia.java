package modelo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

import excepciones.CupoLlenoException;
import excepciones.cupoLlenoException;

//representa una asignatura dentro del sistema academico

public class Materia {

    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int cuposDisponibles;
    private int creditos;

    //lista enlazada para prerequisitos
    private LinkedList<String> prerequisitos;

    //cola para estudiantes en espera
    private Queue<String> colaEspera;

    //constructor
    public Materia(String codigo, String nombre, int cuposMaximos, int creditos){
        this.codigo = codigo;
        this.nombree = nobre;
        this.cuposMaximos = cuposMaximos;
        this.cuposDisponibles = cuposMaximos;
        this.creditos = creditos;

        //inicializacion de estructuras
        this.preRequisitos = new LinkedList<>();

        //ArrayDeque es la mas eficiente de Queue
        this.colaEspera = ArrayDeque<>();
    }

    //getters
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCuposDisponobles(){
        return cuposDisponibles;
    }
    public Queue<Estudiante> getColaEspera(){
        return colaEspera;
    }

    //Agrega el codigo de una materia como prerequisitoo
    public void agregarPreRequisito(String codigomateria){
        this.preRequisitos.add(codigomateria);
    }

    //intenta ocupar un cupo, y si no lo hay lanzara una excepcion
    public void ocuparCupo() throws CupoLlenoException{
        if (this.cuposDisponibles <= 0){
            throw new CupoLlenoException("La materia " + this.nombre + " ya no tiene cupos");
        }
        this.cuposDisponibles--;
    }

    //libera un cupo
    public void liberaCupo(){
        if (this.cuposDisponibles < this.cuposMaximos){
            this.cuposDisponibles++;
        }
    }

    public void encolarEstudiante(Estudiante estudiante){
        this.colaEspera.offer(estudiante);
    }

}
