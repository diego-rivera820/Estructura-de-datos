package Momento_3.util;

import modelo.Estudiante;
import excepciones.EstudianteNoEcontradoException;
import excepciones.EstudianteNoEncontradoException;

import java.util.HashMap;
import java.util.Map;

//gestor encargado de administrar las operaciones CRUD de los estudiantes

public class GestorEstudiante {

    //hashmap para indice rapido por id
    private HashMap<String, Estudiante> directorioEstudiantes;

    //constructor
    public GestorEstudiante(){
        //la llave/key sera el id y el valor sera el objeto del estudinate
        this.directorioEstudiantes = new HashMap<>();
    }

    //registrar un nuevo estudiante en el sistema
    public void registrarEstudiante(Estudiante estudiante){
        //put() inserta o actualiza el valor asociado a la llave
        directorioEstudiantes.put(estudiante.getId(), estudiante);
        System.out.println("Estudiante registrado exitosamente.");
    }

    //busca el estudiante usando el id
    //utilizara la excepcion personalizada EstudianteNoEcontradoException si no se encuentra el estudiante
    public Estudiante buscarEstudiante(String id) throws EstudianteNoEncontradoException {
        if (!directorioEstudiantes.containsKey(id)){
            throw new EstudianteNoEncontradoException("No existe un estudinate con el id: " + id);
        }
        //get() recupera el valor en tiempo constante O(1) gracias al hashmap
        return directorioEstudiantes.get(id);
    }

    //lista todos los estudiantes registrados
    public void listarEstudiantes() {
        if (directorioEstudiantes.isEmpty()){
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("---LISTA DE ESTUDIANTES---");
        for (Estudiante est : directorioEstudiantes.values()){
            System.out.println("- " + est.getId() + " : " + est.getNombre());
        }
    }

    //elimina a un estudiante del sistema
    public Estudiante eliminarEstudiante(String id) throwsEstudianteNoEncontradoException{
        Estudiante est = buscarEstudiante(id); //reutilizamos el metodo para validar
        directorioEstudiantes.remove(id);
        return est; //retornamos el objeto por si se necesita meter esta accion en la pila de deshacer
    } 
    
}
