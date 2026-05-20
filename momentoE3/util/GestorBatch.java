package momentoE3.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import momentoE3.excepciones.ArchivoInvalidoException;
import momentoE3.modelo.Estudiante;
import momentoE3.modelo.Materia;

public class GestorBatch {
    private Queue<SolicitudInscripcion> colaProcesamiento;

    public GestorBatch() {
        this.colaProcesamiento = new ArrayDeque<>();
    }

    public void cargarArchivo(String rutaArchivo) throws ArchivoInvalidoException {
        colaProcesamiento.clear();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                linea = linea.trim();

                if (linea.isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length != 2) {
                    throw new ArchivoInvalidoException("Linea invalida " + numeroLinea + ": " + linea);
                }

                colaProcesamiento.offer(new SolicitudInscripcion(partes[0].trim(), partes[1].trim()));
            }
        } catch (IOException e) {
            throw new ArchivoInvalidoException("No se pudo leer el archivo: " + e.getMessage());
        }
    }

    public void procesar(GestorEstudiantes gestorEstudiantes, GestorMaterias gestorMaterias) {
        int total = colaProcesamiento.size();
        int exitosas = 0;
        int fallidas = 0;
        int contador = 1;

        System.out.println("Se encolaron " + total + " solicitudes.");
        System.out.println("Procesando cola...");

        while (!colaProcesamiento.isEmpty()) {
            SolicitudInscripcion solicitud = colaProcesamiento.poll();

            try {
                Estudiante estudiante = gestorEstudiantes.buscarEstudiante(solicitud.getIdEstudiante());
                Materia materia = gestorMaterias.buscarMateria(solicitud.getCodigoMateria());

                if (materia == null) {
                    throw new Exception("No existe la materia " + solicitud.getCodigoMateria());
                }

                boolean inscrita = gestorMaterias.inscribirEstudiante(materia, estudiante);
                if (inscrita) {
                    exitosas++;
                    System.out.println("[" + contador + "/" + total + "] "
                            + solicitud.getIdEstudiante() + " -> " + solicitud.getCodigoMateria() + " -> Exitosa");
                } else {
                    fallidas++;
                    System.out.println("[" + contador + "/" + total + "] "
                            + solicitud.getIdEstudiante() + " -> " + solicitud.getCodigoMateria() + " -> Fallida");
                }
            } catch (Exception e) {
                fallidas++;
                System.out.println("[" + contador + "/" + total + "] "
                        + solicitud.getIdEstudiante() + " -> " + solicitud.getCodigoMateria()
                        + " -> Fallida: " + e.getMessage());
            }

            contador++;
        }

        System.out.println("=== RESUMEN ===");
        System.out.println("Exitosas: " + exitosas);
        System.out.println("Fallidas: " + fallidas);
    }
}
