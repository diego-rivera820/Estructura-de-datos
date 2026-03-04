package Season_5.Momento_1;

public class contenedor {

    private String id;
    private double peso;
    private String origen;
    
    public contenedor(String id, double peso, String origen) {
        this.id = id;
        this.peso = peso;
        this.origen = origen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return "contenedor [id=" + id + ", origen=" + origen + "]";
    }
    

    



    
    

    
}
