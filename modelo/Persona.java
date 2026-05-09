package modelo;

/*clase abstracta para representar cualquier persona de la universidad
  se aplica encapsulamineto con atributos protegidos
*/

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String email;

    //constructor
    public Persona(String id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // getters 
    public String getid(){return id;}
    public String getnombre(){return nombre;}
    public String getemail(){return email;}

    //Metodo abstracto que obliga a las clases hijas a implementrl polimorfismo
    public abstract void mostrarInformacion();
}
