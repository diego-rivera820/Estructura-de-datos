package Momento_3.util;

import modelo.Aula;
import java.util.TreeMap;

//gestor encargado de administrar las aulas del campus
public class GestorAulas {

    //treemap para mantener las aulas ordenadas alfabeticamente
    private TreeMap<String, Momento_3.modelo.Aula> directorioAulas;

    public GestorAulas(){
        //el treemap ordenara automaticamente los elementos usando la llave (String nombre)
        this.directorioAulas = new TreeMap<>();
    }

    public void registrarAula(Aula aula){
        this.directorioAulas.put(aula.getNombre(), aula);
    }

    public Aula buscarAula(String nombre){
        return this.directorioAulas.get(nombre);
   }

   //muestra las aulas disponibles. el treemap garantiza que salgan en orden
   public void listarAulasOrdenadas(){
        if(directorioAulas.isEmpty()){
            System.out.println("No hay aulas registradas.");
            return;
        }
            System.out.println("--- AULAS DISPONIBLES (Orden Alfabético) ---");
             // Al iterar los valores de un TreeMap, Java respeta el orden de las llaves
            for (Aula aula : directorioAulas.values()) {
                System.out.println("Aula: " + aula.getNombre() + " - Capacidad: " + aula.getCapacidad() + " estudiantes.");{
            
            }
   }
    
}
