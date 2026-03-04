package Season_5.Momento_1;

public class Buque {

    private String nombre;
    private String matricula;
    
    public Buque(String nombre, String matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "buque [nombre=" + nombre + ", matricula=" + matricula + "]";
    }

    

    
    
}
