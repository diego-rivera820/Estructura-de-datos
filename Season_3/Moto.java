package Season_3;

public class Moto {
//Atributos
    private int Modelo;
    private String Marca;
    private String Color;
    private Double cilindraje;
    private Double Precio;
    
    public Moto(int modelo, String marca, String color, Double cilindraje, Double precio) {
        Modelo = modelo;
        Marca = marca;
        Color = color;
        this.cilindraje = cilindraje;
        Precio = precio;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }


    
}
