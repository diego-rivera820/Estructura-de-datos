package momentoE3.util;

import momentoE3.modelo.Aula;

public class AccionReservarHorario implements AccionDeshacible {
    private Aula aula;
    private int dia;
    private int hora;
    private int duracion;

    public AccionReservarHorario(Aula aula, int dia, int hora, int duracion) {
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
    }

    @Override
    public void deshacer() {
        try {
            aula.liberar(dia, hora, duracion);
        } catch (Exception e) {
            System.out.println("Error al deshacer horario: " + e.getMessage());
        }
    }

    @Override
    public void rehacer() {
        try {
            aula.reservar(dia, hora, duracion);
        } catch (Exception e) {
            System.out.println("Error al rehacer horario: " + e.getMessage());
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Reserva de aula " + aula.getNombre() + " dia " + dia + " hora " + hora;
    }
}
