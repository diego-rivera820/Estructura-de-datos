package Season_4;

public class inventario {
    
    private producto[] productos;
    private int cantidadProductos;

    public inventario(int capacidad) {
        this.productos = new producto[capacidad];
        this.cantidadProductos = 0;
    }

    public void agregarProducto(producto p) {
        if (cantidadProductos < productos.length) {
            productos[cantidadProductos] = p;
            cantidadProductos++;
        } else {
            System.out.println("Inventario lleno. No se puede agregar más productos.");
        }
    }

    public void mostrarInventario() {
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println(productos[i]);
        }
    }
    
}
