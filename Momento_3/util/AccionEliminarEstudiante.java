package Momento_3.util;

import modelo.Estudiante;

//clase que encapsula la accion de eliminar un estudiante para poder deshacerla

public class AccionEliminarEstudiante implements AccionDeshacible {
    
    private GestorEstudiante gestor;
    private Estudiante estudianteEliminado;

    public AccionEliminarEstudiante(GestorEstudiante gestor, Estudiante estudianteEliminado){
        this.gestor = gestor;
        //guardamos el estado anterior 
        this.estudianteEliminado = estudianteEliminado;
    }

    @Override
    public void deshacer(){
        //la reversa de eliminar es volver a registrarlo
        gestor.registrarEstudiante(estudianteEliminado); 
    }

    @Override
    public void rehacer(){
        try {
            // volvemos a ejecutar la eliminacion
            gestor.eliminarEstudiante(estudianteEliminado.getId());
        } catch (Exception e){
            System.out.println("Error al rehacer: " + e.getMessage());
        }
    }

    @overraid
    public String obtenerDescripcion() {
        return "Eliminacion del estudiante " + estudianteEliminado.getNombre();
    }
    
}
