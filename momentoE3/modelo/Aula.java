package momentoE3.modelo;

import momentoE3.excepciones.HorarioConflictivoException;

public class Aula {
    private String nombre;
    private int capacidad;
    private boolean[][] horario;

    public Aula(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.horario = new boolean[7][24];
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean consultarDisponibilidad(int dia, int hora) throws HorarioConflictivoException {
        validarDiaHora(dia, hora);
        return !horario[dia][hora];
    }

    public void reservar(int dia, int hora, int duracion) throws HorarioConflictivoException {
        validarBloque(dia, hora, duracion);

        for (int i = 0; i < duracion; i++) {
            if (horario[dia][hora + i]) {
                throw new HorarioConflictivoException("Conflicto: el dia " + dia + " a las " + (hora + i) + ":00 ya esta reservado.");
            }
        }

        for (int i = 0; i < duracion; i++) {
            horario[dia][hora + i] = true;
        }
    }

    public void liberar(int dia, int hora, int duracion) throws HorarioConflictivoException {
        validarBloque(dia, hora, duracion);

        for (int i = 0; i < duracion; i++) {
            horario[dia][hora + i] = false;
        }
    }

    private void validarDiaHora(int dia, int hora) throws HorarioConflictivoException {
        if (dia < 0 || dia > 6 || hora < 0 || hora > 23) {
            throw new HorarioConflictivoException("Dia u hora fuera de rango.");
        }
    }

    private void validarBloque(int dia, int hora, int duracion) throws HorarioConflictivoException {
        validarDiaHora(dia, hora);
        if (duracion <= 0 || hora + duracion > 24) {
            throw new HorarioConflictivoException("La operacion excede el limite del dia.");
        }
    }
}
