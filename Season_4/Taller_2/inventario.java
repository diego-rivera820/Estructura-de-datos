package Season_4.Taller_2;

import java.util.Arrays;

public class inventario {

    private producto[] productos;

    

    public inventario(producto[] productos) {
        this.productos = productos;
    }



    public producto[] getProductos() {
        return productos;
    }



    public void setProductos(producto[] productos) {
        this.productos = productos;
    }

     public String buscarPorId(int id){
        String cadena = "";
        for (int i = 0; i < productos.length; i++) {
            if(id == productos[i].getId()){
                cadena = productos[i].toString();
            }else{
                cadena = "Producto NO Encontrado....";
            }
        }
        return cadena;
    }

    @Override
    public String toString() {
        return "Inventario [productos=" + Arrays.toString(productos) + "]";
    }
}
