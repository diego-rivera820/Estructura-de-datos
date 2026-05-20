package momentoE3.modelo;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String email;

    public Persona(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public abstract void mostrarInformacion();
}
