package momentoE3.modelo;

import momentoE3.excepciones.HorarioConflictivoException;

//salon de clases en un edificio

public class Aula {
    
    private String nombre;
    private int capacidad;

    //matriz para disponibilidad
    // 7 dias(0=Dom, 1=Lun...) x 24 horas (0 a 23)
    private boolean [][] horario;

    public Aula(String nombre, int capacidad){
        this.nombre = nombre;
        this.capacidad = capacidad;
        //al instanciar un arreglo boolean en java, todos los valores son false por defecto 
        // asumiremos que false = libre, y true = ocupado
        this.horario = new boolean[7][24];
    }

    public String getNombre(){
        return nombre;
    }

    public int getCapacidad(){
        return capacidad;
    }

    //consulta si un bloque especifico esta disponible
    public boolean consultarDisponibilidad(int dia, int hora){
        //retornamos lo contrario: si es false[libre] retorna true[disponible]
        return !this.horario[dia][hora];
    }

    //intenta reservar el aula por una cantidad de horas seguidas
    public void reservar(int dia, int hora, int duracion) throws HorarioConflictivoException{
        //validar que la reserva no pase de la media noche (hora 23)
        if(hora + duracion > 24){
            throw new HorarioConflictivoException("La reserva excede el límite del día.");            
        }

        //verificar que todos los bloques de la duracion esten libres primero
        for(int i = 0; i < duracion; i++){
            if (this.horario[dia][hora + i]){ //si es true esta ocupado
                throw new HorarioConflictivoException("Conflicto: El día " + dia + " a las " + (hora + i) + ":00 ya está reservado.");

            }
        }

        //si llegamos aqui todo el bloque esta libre procede a marcar como ocupado(true)
        for(int i = 0; i < duracion; i++) {
            if(hora + i < 24){ //prevencion de errores de indice
                this.horario[dia][hora + i] = true; //marcar como ocupado
            }
        }
    }

}
