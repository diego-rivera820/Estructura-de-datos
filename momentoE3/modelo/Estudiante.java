package momentoE3.modelo;

import java.util.LinkedList;

public class Estudiante extends Persona {
    private int semestreActual;

    private String[][] nombresMaterias;
    //Arreglo nativo para notas
    private Double[][] notas;

    //lista enlazada para el historial
    private LinkedList<String> historialMaterias;

    public Estudiante(String id, String nombre, String email, int semestreActual){
        super(id, nombre, email);
        this.semestreActual = semestreActual;

        // inicializacion del arreglo estatico
        this.notas = new Double[10][20];
        this.historialMaterias = new LinkedList<>();
        this.nombresMaterias = new String[10][20];

    }

    public int getSemestreActual(){
         return semestreActual;
        
    }

    public void registrarNotas(int semestre, String nombreMateria, double nota){
        int indiceSemestre = semestre - 1;

        //buscamos el primer espacio vacio en ese semestre 
        for(int i = 0; i < 20; i++){
            if (this.notas[indiceSemestre][i] == null){
                this.notas[indiceSemestre][i] = nota;
                this.nombresMaterias[indiceSemestre][i] = nombreMateria;
                // registrar en el historial de materias cursadas
                this.historialMaterias.add(nombreMateria + " (Semestre " + semestre + ")");
                return; //salimos apenas registremos la nota
            }
        }
        System.out.println("Error: No se pueden registrar mas de 20 materias por semestre");
    }

    //genera un string con el reporte completo del estudiante 
    public String generarReporteAcademico(){
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE ACADEMICO ---\n");
        reporte.append("Estudiante: ").append(this.nombre).append(" ID: ").append(this.id).append(")\n");

        int materiasAprobadas = 0;
        int materiasReprobadas = 0;
        double sumaTotalAcumulada = 0;
        int totalMateriasCursadas = 0;

        // recorremos los diez semestres
        for (int i = 0; i < 10; i++){
            double sumaSemestre = 0;
            int materiasSemestre = 0;
            boolean tieneNotas = false;

            //recorremos las 20 posibles materias de ese semestre 
            for (int j = 0; j < 20; j++){
                if (this.notas[i][j] != null){ // solo procesamos si hay una nota real
                    if(!tieneNotas){
                        reporte.append("Semestre ").append(i + 1).append(":\n");
                        tieneNotas = true;
                    }

                    double notaActual = this.notas[i][j];
                    reporte.append(this.nombresMaterias[i][j]).append(": ").append(notaActual).append("\n");

                    sumaSemestre += notaActual;
                    materiasSemestre++;

                    //logica de aprobacion escala 0 a 5, aprueba con 3.0
                    if (notaActual >= 3.0){
                        materiasAprobadas++;
                    } else {
                        materiasReprobadas++;
                    }
                }
            } 

            //si curso materias en ese semestre calculamos su promedio
            if(tieneNotas){
                double promedioSemestre = sumaSemestre / materiasSemestre;
                reporte.append("Promedio Semestre: ").append(String.format("%.2f", promedioSemestre)).append("\n\n");
                
                sumaTotalAcumulada += sumaSemestre;
                totalMateriasCursadas += materiasSemestre;
            }
        }

        reporte.append("=== RESUMEN ===\n");
        if (totalMateriasCursadas > 0){
            double promedioAcumulado = sumaTotalAcumulada / totalMateriasCursadas;
            reporte.append("Promedio acumulado: ").append(String.format("%.2f", promedioAcumulado)).append("\n");
        } else {
            reporte.append("Promedio acumulado: 0.0 (sin notas aun)\n");
        }
        reporte.append("Materias aprobadas: ").append(materiasAprobadas).append("\n");
        reporte.append("Materias reprobadas: ").append(materiasReprobadas).append("\n");

        return reporte.toString();
    }

    //polimorfismo, sobreescritura del metodo de la clase padre
    @Override
    public void mostrarInformacion(){
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Email: " + this.email);
        System.out.println("Semestre Actual: " + this.semestreActual);
    }

   
}
