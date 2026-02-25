package Season_3;

public class EjecutarCurso {

    public static void main(String[] args){

        //creacion del arreglo de 5 cursos
        Curso [] c = new Curso[5];

        //creacion de los objetos de tipo curso y almacenados en cada pocicion de l arreglo
        c[0] = new Curso(98002, "Programacion Orientada a Objetos",  "Jairo", 100);
        c[1] = new Curso(98003, "Estructura de Datos",  "Pedro", 120);
        c[2] = new Curso(98004, "Base de Datos",  "Maria", 150);
        c[3] = new Curso(98001, "Desarrollo Web",  "Carlos", 200);
        c[4] = new Curso(98005, "inteligencia artificial",  "Ana", 250);

        //Operaciones con los objetos del arreglo
        
        int totalEstudiantes = 0;
        int suma = 0;
        for(int i = 0; i < c.length; i ++){
            suma += c[i].getNumEstudiantes();
        }
        System.out.println("el numero total de estudiantes de los cursos es de:" + suma);

    }
    
}
