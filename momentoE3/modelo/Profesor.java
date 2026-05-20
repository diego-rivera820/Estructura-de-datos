package momentoE3.modelo;

public class Profesor extends Persona {
    private String departamento;

    public Profesor(String id, String nombre, String email, String departamento) {
        super(id, nombre, email);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Departamento: " + departamento);
    }
}
