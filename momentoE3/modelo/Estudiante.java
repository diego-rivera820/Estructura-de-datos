package momentoE3.modelo;

import java.util.LinkedList;

public class Estudiante extends Persona {
    private int semestreActual;
    private String[][] nombresMaterias;
    private Double[][] notas;
    private LinkedList<String> historialMaterias;

    public Estudiante(String id, String nombre, String email, int semestreActual) {
        super(id, nombre, email);
        this.semestreActual = semestreActual;
        this.nombresMaterias = new String[10][20];
        this.notas = new Double[10][20];
        this.historialMaterias = new LinkedList<>();
    }

    public int getSemestreActual() {
        return semestreActual;
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }

    public RegistroNota registrarNotas(int semestre, String nombreMateria, double nota) {
        int indiceSemestre = semestre - 1;

        if (indiceSemestre < 0 || indiceSemestre >= 10) {
            System.out.println("Error: semestre invalido.");
            return null;
        }

        for (int i = 0; i < 20; i++) {
            if (notas[indiceSemestre][i] == null) {
                notas[indiceSemestre][i] = nota;
                nombresMaterias[indiceSemestre][i] = nombreMateria;
                historialMaterias.add(nombreMateria + " (Semestre " + semestre + ")");
                return new RegistroNota(semestre, i, nombreMateria, nota);
            }
        }

        System.out.println("Error: No se pueden registrar mas de 20 materias por semestre.");
        return null;
    }

    public void eliminarNota(RegistroNota registro) {
        if (registro == null) {
            return;
        }

        int indiceSemestre = registro.getSemestre() - 1;
        int posicion = registro.getPosicion();

        if (indiceSemestre >= 0 && indiceSemestre < 10 && posicion >= 0 && posicion < 20) {
            notas[indiceSemestre][posicion] = null;
            nombresMaterias[indiceSemestre][posicion] = null;
            historialMaterias.remove(registro.getNombreMateria() + " (Semestre " + registro.getSemestre() + ")");
        }
    }

    public void restaurarNota(RegistroNota registro) {
        if (registro == null) {
            return;
        }

        int indiceSemestre = registro.getSemestre() - 1;
        int posicion = registro.getPosicion();

        if (indiceSemestre >= 0 && indiceSemestre < 10 && posicion >= 0 && posicion < 20) {
            notas[indiceSemestre][posicion] = registro.getNota();
            nombresMaterias[indiceSemestre][posicion] = registro.getNombreMateria();
            String textoHistorial = registro.getNombreMateria() + " (Semestre " + registro.getSemestre() + ")";
            if (!historialMaterias.contains(textoHistorial)) {
                historialMaterias.add(textoHistorial);
            }
        }
    }

    public boolean aproboMateria(String nombreMateria) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (nombresMaterias[i][j] != null
                        && nombresMaterias[i][j].equalsIgnoreCase(nombreMateria)
                        && notas[i][j] != null
                        && notas[i][j] >= 3.0) {
                    return true;
                }
            }
        }
        return false;
    }

    public double calcularPromedioSemestre(int semestre) {
        int indiceSemestre = semestre - 1;
        double suma = 0;
        int cantidad = 0;

        if (indiceSemestre < 0 || indiceSemestre >= 10) {
            return 0.0;
        }

        for (int i = 0; i < 20; i++) {
            if (notas[indiceSemestre][i] != null) {
                suma += notas[indiceSemestre][i];
                cantidad++;
            }
        }

        return cantidad == 0 ? 0.0 : suma / cantidad;
    }

    public double calcularPromedioAcumulado() {
        double suma = 0;
        int cantidad = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null) {
                    suma += notas[i][j];
                    cantidad++;
                }
            }
        }

        return cantidad == 0 ? 0.0 : suma / cantidad;
    }

    public String generarReporteReprobadas() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- MATERIAS REPROBADAS ---\n");
        boolean hayReprobadas = false;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null && notas[i][j] < 3.0) {
                    reporte.append(nombresMaterias[i][j])
                           .append(" - Nota: ")
                           .append(notas[i][j])
                           .append(" - Semestre ")
                           .append(i + 1)
                           .append("\n");
                    hayReprobadas = true;
                }
            }
        }

        if (!hayReprobadas) {
            reporte.append("No tiene materias reprobadas.\n");
        }

        return reporte.toString();
    }

    public String generarReporteAcademico() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE ACADEMICO ---\n");
        reporte.append("Estudiante: ").append(nombre).append(" (ID: ").append(id).append(")\n");

        int materiasAprobadas = 0;
        int materiasReprobadas = 0;

        for (int i = 0; i < 10; i++) {
            boolean tieneNotas = false;

            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null) {
                    if (!tieneNotas) {
                        reporte.append("Semestre ").append(i + 1).append(":\n");
                        tieneNotas = true;
                    }

                    reporte.append(nombresMaterias[i][j]).append(": ").append(notas[i][j]).append("\n");

                    if (notas[i][j] >= 3.0) {
                        materiasAprobadas++;
                    } else {
                        materiasReprobadas++;
                    }
                }
            }

            if (tieneNotas) {
                reporte.append("Promedio Semestre: ")
                       .append(String.format("%.2f", calcularPromedioSemestre(i + 1)))
                       .append("\n\n");
            }
        }

        reporte.append("=== RESUMEN ===\n");
        reporte.append("Promedio acumulado: ").append(String.format("%.2f", calcularPromedioAcumulado())).append("\n");
        reporte.append("Materias aprobadas: ").append(materiasAprobadas).append("\n");
        reporte.append("Materias reprobadas: ").append(materiasReprobadas).append("\n");

        return reporte.toString();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Semestre Actual: " + semestreActual);
        System.out.println("Promedio acumulado: " + String.format("%.2f", calcularPromedioAcumulado()));
    }
}
