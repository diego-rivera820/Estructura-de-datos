package momentoE3.modelo;

public class RegistroNota {
    private int semestre;
    private int posicion;
    private String nombreMateria;
    private double nota;

    public RegistroNota(int semestre, int posicion, String nombreMateria, double nota) {
        this.semestre = semestre;
        this.posicion = posicion;
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public double getNota() {
        return nota;
    }
}
