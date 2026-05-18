package Momento_3;

import modelo.*;
import util.*;
import excepciones.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //inicializacion de gestores y herramientas

        Scanner scanner = new Scanner(System.in);
        GestorEstudiantes gestorEstudiantes = new GestorEstudiantes();
        GestorAulas gestorAulas = new GestorAulas();
        GestroRutas gestorRutas = new GestorRutas();
        GestorHistorial gestorHistorial = new GestorHistorial();
        GestorReportes gestorReportes = new GestorReportes();

        // precarga de algunos datos para no empezar en cero
        gestorAulas.registrarAula(new Aula("101", 30));
        gestorAulas.registrarAula(new Aula("Laboratorio A", 20));

        boolean salir = false;

        // bucle principal del menu
        while (!salir){
            System.out.println("\n=============================================================");
            System.out.println("   PLANIFICACION ACADEMICA - SISTEMA UNIVERSITARIO");
            System.out.println("============================================================");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por ID");
            System.out.println("3. Listar todos los estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("11. Reservar horario en aula");
            System.out.println("15. Calcular ruta mas corta entre edificios");
            System.out.println("17. Ver reporte academico");
            System.out.println("18. Navegar reporte anterior (Atras)");
            System.out.println("19. Deshacer ultima operacion");
            System.out.println("20. Rehacer ultima operacion");
            System.out.println("22. Salir");
            System.out.println("Seleccione una opcion: ");

            int opcion;
            try {
                //leemos el numero y limpiamos el buffer del enter
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                System.out.println("Error: Por favor ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer si metió una letra
                continue; // Volver a mostrar el menú
            }

            //manejo de opciones con switch
            //englobamos el Switch en un try-catch para atrapar mis excepciones 
            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Ingrese Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Ingrese Semestre Actual: ");
                        int semestre = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        Estudiante nuevo = new Estudiante(id, nombre, email, semestre);
                        gestorEstudiantes.registrarEstudiante(nuevo);
                        break;

                    case 2:
                        System.out.print("Ingrese ID a buscar: ");
                        String idBuscar = scanner.nextLine();
                        Estudiante estEncontrado = gestorEstudiantes.buscarEstudiante(idBuscar);
                        estEncontrado.mostrarInformacion();
                        break;

                    case 3:
                        gestorEstudiantes.listarEstudiantes();
                        break;

                    case 4:
                        System.out.print("Ingrese ID del estudiante a eliminar: ");
                        String idEliminar = scanner.nextLine();
                        Estudiante eliminado = gestorEstudiantes.eliminarEstudiante(idEliminar);
                        
                        // REGISTRAMOS LA ACCIÓN PARA PODER DESHACERLA
                        AccionEliminarEstudiante accion = new AccionEliminarEstudiante(gestorEstudiantes, eliminado);
                        gestorHistorial.registrarAccion(accion);
                        System.out.println("Estudiante eliminado.");
                        break;

                    case 11:
                        System.out.print("Nombre del aula (ej. 101): ");
                        String nombreAula = scanner.nextLine();
                        Aula aula = gestorAulas.buscarAula(nombreAula);
                        if (aula == null) {
                            System.out.println("Aula no encontrada.");
                            break;
                        }
                        System.out.print("Día (0=Dom, 1=Lun, ..., 6=Sab): ");
                        int dia = scanner.nextInt();
                        System.out.print("Hora (0 a 23): ");
                        int hora = scanner.nextInt();
                        System.out.print("Duración (horas): ");
                        int duracion = scanner.nextInt();
                        scanner.nextLine();

                        aula.reservar(dia, hora, duracion);
                        System.out.println("Reserva exitosa.");
                        break;

                    case 15:
                        gestorRutas.mostrarEdificios();
                        System.out.print("ID Edificio Origen: ");
                        int origen = scanner.nextInt();
                        System.out.print("ID Edificio Destino: ");
                        int destino = scanner.nextInt();
                        scanner.nextLine();
                        
                        // Precargamos una ruta de prueba rápida (ej. Ingeniería a Rectoría)
                        gestorRutas.agregarConexion(0, 2, 150); // Ing -> Cafetería
                        gestorRutas.agregarConexion(2, 3, 180); // Cafetería -> Rectoría
                        
                        gestorRutas.calcularRutaMasCorta(origen, destino);
                        break;

                    case 17:
                        System.out.print("Ingrese ID del estudiante: ");
                        String idReporte = scanner.nextLine();
                        Estudiante estReporte = gestorEstudiantes.buscarEstudiante(idReporte);
                        
                        // Agregamos una nota de prueba para ver el resultado
                        estReporte.registrarNota(1, "Cálculo I", 4.5);
                        
                        String reporte = estReporte.generarReporteAcademico();
                        gestorReportes.verNuevoReporte(reporte);
                        break;

                    case 18:
                        gestorReportes.navegarAtras();
                        break;

                    case 19:
                        gestorHistorial.deshacer();
                        break;

                    case 20:
                        gestorHistorial.rehacer();
                        break;

                    case 22:
                        salir = true;
                        System.out.println("Saliendo del sistema académico...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (EstudianteNoEncontradoException | HorarioConflictivoException | PilaDeshacerVaciaException e) {
                // AQUÍ ATRAPAMOS NUESTRAS EXCEPCIONES PERSONALIZADAS
                System.out.println("--- ALERTA DEL SISTEMA ---");
                System.out.println(e.getMessage());
            } catch (Exception e) {
                // Atrapa cualquier otro error inesperado para que el programa no se caiga
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    } 
}
