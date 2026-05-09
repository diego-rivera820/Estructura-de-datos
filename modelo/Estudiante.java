package modelo;

import java.util.LinkedList;

public class Estudiante extends Persona {
    private int semestreActual;


    //Arreglo nativo para notas
    private Double[][] notas;

    //lista enlazada para el historial
    private LinkedList<String> historialMaterias;

    public Estudiante(String id, String nombre, String email, int semestreActual){
        super(id, nombre, email);
        this.semestreActual = semestreActual;

        //inicializacion del arreglo estatico
        this.notas = new Double[10][20];
        this.historialMaterias = new LinkedList<>();

    }

    public int getSemestreActual(){
         return semestreActual;
        
    }

    //polimorfismo, sobreescritura del metodo de la clase padre
    @Override
    public void mostrarInformacion(){
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Email: " + this.email);
        System.out.println("Semestre Actual: " + this.semestreActual);
    }

    //los metodos para registrar notas se implementaran
    //en la capa de utilidaades/gestion  
}
