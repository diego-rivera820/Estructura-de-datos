package momentoE3.util;

import momentoE3.modelo.Estudiante;
import momentoE3.modelo.RegistroNota;

public class AccionRegistrarNota implements AccionDeshacible {
    private Estudiante estudiante;
    private RegistroNota registro;

    public AccionRegistrarNota(Estudiante estudiante, RegistroNota registro) {
        this.estudiante = estudiante;
        this.registro = registro;
    }

    @Override
    public void deshacer() {
        estudiante.eliminarNota(registro);
    }

    @Override
    public void rehacer() {
        estudiante.restaurarNota(registro);
    }

    @Override
    public String obtenerDescripcion() {
        return "Registro de nota de " + estudiante.getNombre() + " en " + registro.getNombreMateria();
    }
}
