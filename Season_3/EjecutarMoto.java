package Season_3;

public class EjecutarMoto {

    public static void main(String[] args){

        
        //creacion del arreglo de 8 motos
        Moto [] m = new Moto[8];

        //creacion de los objetos de tipo moto y almacenados en cada pocicion de l arreglo
        m[0] = new Moto(2026, "AKT Turing", "Negro", 125.0, 1250.0 );
        m[1] = new Moto(2025, "kawasaki ninja", "verde", 400.0, 25000.0 );
        m[2] = new Moto(2026, "honda CBR", "roja", 350.0, 15000.0 );
        m[3] = new Moto(2027, "honda C90", "DoradoNegro", 90.0, 10000.0 );
        m[4] = new Moto(2015, "sym Automatica", "Blanco", 150.0, 4500.0 );
        m[5] = new Moto(2027, "Susuki", "Azul", 150.0, 10000.0 );
        m[6] = new Moto(2027, "BMW", "Gris", 1200.0, 40000.0 );
        m[7] = new Moto(2027, "Harley Davidson", "Negro", 1800.0, 35000.0 );

        //Operaciones con los objetos del arreglo
        System.out.println(m[5]);
        double promedio = 0.0;
        int suma = 0;
        for(int i = 0; i < m.length; i ++){
            suma += m[i].getModelo();
        }
        System.out.println("el promedio del modelo de las 8 motos es de:" + (suma / m.length));

        // obtener las motos que puedo comprar con un presupuesto de 20.000 dolares
        String cad = "\n";
        for(int i = 0; i < m.length; i ++){
            if(m[i].getPrecio() <= 20000.0){
                cad += "-" + m[i].getMarca() + " " + m[i].getPrecio() + "\n";
            }
        }
        System.out.println("las motos que puedo comprar con 20000.0US son:" + cad);
    }
    
}
