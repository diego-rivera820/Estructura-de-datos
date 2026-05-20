package momentoE3.util;

import momentoE3.modelo.Aula;

public class AccionLiberarHorario implements AccionDeshacible {
    private Aula aula;
    private int dia;
    private int hora;
    private int duracion;

    public AccionLiberarHorario(Aula aula, int dia, int hora, int duracion) {
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
    }

    @Override
    public void deshacer() {
        try {
            aula.reservar(dia, hora, duracion);
        } catch (Exception e) {
            System.out.println("Error al deshacer liberacion: " + e.getMessage());
        }
    }

    @Override
    public void rehacer() {
        try {
            aula.liberar(dia, hora, duracion);
        } catch (Exception e) {
            System.out.println("Error al rehacer liberacion: " + e.getMessage());
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Liberacion de aula " + aula.getNombre() + " dia " + dia + " hora " + hora;
    }
}
