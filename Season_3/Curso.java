package Season_3;

public class Curso {

    private int id;
    private String nombreCurso;
    private String profesor;
    private int numEstudiantes;
    
    public Curso(int id, String nombreCurso, String profesor, int numEstudiantes) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.numEstudiantes = numEstudiantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nombreCurso=" + nombreCurso + ", profesor=" + profesor + ", numEstudiantes="
                + numEstudiantes + "]";
    }
    
    
}
