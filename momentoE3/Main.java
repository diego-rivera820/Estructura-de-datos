package momentoE3;

import java.util.Scanner;
import momentoE3.modelo.Aula;
import momentoE3.modelo.Estudiante;
import momentoE3.modelo.Facultad;
import momentoE3.modelo.Materia;
import momentoE3.modelo.RegistroNota;
import momentoE3.util.AccionCancelarInscripcion;
import momentoE3.util.AccionEliminarEstudiante;
import momentoE3.util.AccionInscribirEstudiante;
import momentoE3.util.AccionLiberarHorario;
import momentoE3.util.AccionRegistrarNota;
import momentoE3.util.AccionReservarHorario;
import momentoE3.util.GestorAulas;
import momentoE3.util.GestorBatch;
import momentoE3.util.GestorEstudiantes;
import momentoE3.util.GestorHistorial;
import momentoE3.util.GestorMaterias;
import momentoE3.util.GestorReportes;
import momentoE3.util.GestorRutas;

public class Main {
    public static void main(String[] args) {
        GestorEstudiantes gestorEstudiantes = new GestorEstudiantes();
        GestorAulas gestorAulas = new GestorAulas();
        GestorRutas gestorRutas = new GestorRutas();
        GestorHistorial gestorHistorial = new GestorHistorial();
        GestorReportes gestorReportes = new GestorReportes();
        GestorMaterias gestorMaterias = new GestorMaterias();
        GestorBatch gestorBatch = new GestorBatch();

        Facultad[] facultades = new Facultad[5];
        facultades[0] = new Facultad("Ingenieria");
        facultades[1] = new Facultad("Basicas");
        facultades[2] = new Facultad("Economicas");
        facultades[3] = new Facultad("Humanas");
        facultades[4] = new Facultad("Salud");

        gestorAulas.registrarAula(new Aula("101", 30));
        gestorAulas.registrarAula(new Aula("202", 40));
        gestorAulas.registrarAula(new Aula("Laboratorio", 25));

        gestorRutas.agregaConexion(0, 1, 120);
        gestorRutas.agregaConexion(0, 2, 150);
        gestorRutas.agregaConexion(2, 3, 180);
        gestorRutas.agregaConexion(1, 4, 200);
        gestorRutas.agregaConexion(4, 3, 100);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            try {
                int opcion = leerEntero(scanner, "Seleccione una opcion: ");

                switch (opcion) {
                    case 1:
                        registrarEstudiante(scanner, gestorEstudiantes);
                        break;
                    case 2:
                        buscarEstudiante(scanner, gestorEstudiantes);
                        break;
                    case 3:
                        gestorEstudiantes.mostrarEstudiantes();
                        break;
                    case 4:
                        eliminarEstudiante(scanner, gestorEstudiantes, gestorHistorial);
                        break;
                    case 5:
                        crearMateria(scanner, gestorMaterias);
                        break;
                    case 6:
                        agregarPrerrequisito(scanner, gestorMaterias);
                        break;
                    case 7:
                        mostrarPrerrequisitos(scanner, gestorMaterias);
                        break;
                    case 8:
                        inscribirEstudiante(scanner, gestorEstudiantes, gestorMaterias, gestorHistorial);
                        break;
                    case 9:
                        cancelarInscripcion(scanner, gestorEstudiantes, gestorMaterias, gestorHistorial);
                        break;
                    case 10:
                        mostrarColaEspera(scanner, gestorMaterias);
                        break;
                    case 11:
                        reservarHorario(scanner, gestorAulas, gestorHistorial);
                        break;
                    case 12:
                        liberarHorario(scanner, gestorAulas, gestorHistorial);
                        break;
                    case 13:
                        consultarHorario(scanner, gestorAulas);
                        break;
                    case 14:
                        agregarConexion(scanner, gestorRutas);
                        break;
                    case 15:
                        calcularRuta(scanner, gestorRutas);
                        break;
                    case 16:
                        registrarNota(scanner, gestorEstudiantes, gestorHistorial);
                        break;
                    case 17:
                        verReporteAcademico(scanner, gestorEstudiantes, gestorReportes);
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
                    case 21:
                        procesarBatch(scanner, gestorBatch, gestorEstudiantes, gestorMaterias);
                        break;
                    case 22:
                        listarFacultades(facultades);
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=======================================================");
        System.out.println("     SISTEMA DE GESTION UNIVERSITARIA - MOMENTO 3      ");
        System.out.println("=======================================================");
        System.out.println(" [ GESTION DE ESTUDIANTES ]");
        System.out.println("   1. Registrar estudiante    |  3. Listar estudiantes");
        System.out.println("   2. Buscar estudiante       |  4. Eliminar estudiante");
        System.out.println("-------------------------------------------------------");
        System.out.println(" [ GESTION DE MATERIAS ]");
        System.out.println("   5. Crear materia           |  8. Inscribir estudiante");
        System.out.println("   6. Agregar pre-requisito   |  9. Cancelar inscripcion");
        System.out.println("   7. Mostrar pre-requisitos  | 10. Mostrar cola de espera");
        System.out.println("-------------------------------------------------------");
        System.out.println(" [ HORARIOS ]");
        System.out.println("  11. Reservar horario        | 12. Liberar horario");
        System.out.println("  13. Consultar disponibilidad");
        System.out.println("-------------------------------------------------------");
        System.out.println(" [ RUTAS, REPORTES Y LOTES ]");
        System.out.println("  14. Agregar conexion        | 15. Calcular ruta mas corta");
        System.out.println("  16. Registrar nota          | 17. Ver reporte academico");
        System.out.println("  18. Navegar reporte atras   | 21. Procesar archivo CSV");
        System.out.println("-------------------------------------------------------");
        System.out.println(" [ SISTEMA ]");
        System.out.println("  19. Deshacer accion         | 20. Rehacer accion");
        System.out.println("  22. Ver facultades          |  0. Salir");
        System.out.println("=======================================================");
    }

    private static void registrarEstudiante(Scanner scanner, GestorEstudiantes gestor) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        int semestre = leerEntero(scanner, "Semestre actual: ");

        gestor.registrarEstudiante(new Estudiante(id, nombre, email, semestre));
        System.out.println("Estudiante registrado exitosamente.");
    }

    private static void buscarEstudiante(Scanner scanner, GestorEstudiantes gestor) throws Exception {
        System.out.print("ID a buscar: ");
        String id = scanner.nextLine();
        gestor.buscarEstudiante(id).mostrarInformacion();
    }

    private static void eliminarEstudiante(Scanner scanner, GestorEstudiantes gestor, GestorHistorial historial) throws Exception {
        System.out.print("ID a eliminar: ");
        String id = scanner.nextLine();
        Estudiante eliminado = gestor.eliminarEstudiante(id);
        historial.registrarAccion(new AccionEliminarEstudiante(gestor, eliminado));
        System.out.println("Estudiante eliminado. Esta accion se puede deshacer.");
    }

    private static void crearMateria(Scanner scanner, GestorMaterias gestor) {
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        int cupos = leerEntero(scanner, "Cupos maximos: ");
        int creditos = leerEntero(scanner, "Creditos: ");

        gestor.crearMateria(new Materia(codigo, nombre, cupos, creditos));
        System.out.println("Materia creada.");
    }

    private static void agregarPrerrequisito(Scanner scanner, GestorMaterias gestor) {
        System.out.print("Codigo de materia base: ");
        String codigoBase = scanner.nextLine();
        System.out.print("Codigo de materia requisito: ");
        String codigoRequisito = scanner.nextLine();

        gestor.agregarPrerrequisito(gestor.buscarMateria(codigoBase), gestor.buscarMateria(codigoRequisito));
        System.out.println("Operacion finalizada.");
    }

    private static void mostrarPrerrequisitos(Scanner scanner, GestorMaterias gestor) {
        System.out.print("Codigo de materia: ");
        String codigo = scanner.nextLine();
        Materia materia = gestor.buscarMateria(codigo);

        if (materia == null) {
            System.out.println("No existe esa materia.");
            return;
        }

        if (materia.getPrerrequisitos().isEmpty()) {
            System.out.println("La materia no tiene pre-requisitos.");
            return;
        }

        System.out.println("--- PRE-REQUISITOS DE " + materia.getNombre() + " ---");
        for (Materia requisito : materia.getPrerrequisitos()) {
            System.out.println("- " + requisito.getCodigo() + " | " + requisito.getNombre());
        }
    }

    private static void inscribirEstudiante(Scanner scanner, GestorEstudiantes gestorEstudiantes,
            GestorMaterias gestorMaterias, GestorHistorial historial) throws Exception {
        System.out.print("ID Estudiante: ");
        String id = scanner.nextLine();
        System.out.print("Cod Materia: ");
        String codigo = scanner.nextLine();

        Estudiante estudiante = gestorEstudiantes.buscarEstudiante(id);
        Materia materia = gestorMaterias.buscarMateria(codigo);
        boolean inscrito = gestorMaterias.inscribirEstudiante(materia, estudiante);

        if (inscrito) {
            historial.registrarAccion(new AccionInscribirEstudiante(gestorMaterias, materia, estudiante));
        }
    }

    private static void cancelarInscripcion(Scanner scanner, GestorEstudiantes gestorEstudiantes,
            GestorMaterias gestorMaterias, GestorHistorial historial) throws Exception {
        System.out.print("ID Estudiante: ");
        String id = scanner.nextLine();
        System.out.print("Cod Materia: ");
        String codigo = scanner.nextLine();

        Estudiante estudiante = gestorEstudiantes.buscarEstudiante(id);
        Materia materia = gestorMaterias.buscarMateria(codigo);
        boolean cancelada = gestorMaterias.cancelarInscripcion(materia, estudiante);

        if (cancelada) {
            historial.registrarAccion(new AccionCancelarInscripcion(gestorMaterias, materia, estudiante));
        }
    }

    private static void mostrarColaEspera(Scanner scanner, GestorMaterias gestor) {
        System.out.print("Cod Materia: ");
        String codigo = scanner.nextLine();
        Materia materia = gestor.buscarMateria(codigo);

        if (materia == null) {
            System.out.println("No existe esa materia.");
            return;
        }

        if (materia.getColaEspera().isEmpty()) {
            System.out.println("No hay estudiantes en cola de espera.");
            return;
        }

        int posicion = 1;
        for (Estudiante estudiante : materia.getColaEspera()) {
            System.out.println("Posicion " + posicion + ": " + estudiante.getNombre());
            posicion++;
        }
    }

    private static void reservarHorario(Scanner scanner, GestorAulas gestor, GestorHistorial historial) throws Exception {
        gestor.listarAulasOrdenadas();
        System.out.print("Nombre del aula: ");
        String nombreAula = scanner.nextLine();
        int dia = leerEntero(scanner, "Dia 0=Domingo, 1=Lunes ... 6=Sabado: ");
        int hora = leerEntero(scanner, "Hora 0-23: ");
        int duracion = leerEntero(scanner, "Duracion en horas: ");

        Aula aula = gestor.buscarAula(nombreAula);
        if (aula == null) {
            System.out.println("No existe esa aula.");
            return;
        }

        aula.reservar(dia, hora, duracion);
        historial.registrarAccion(new AccionReservarHorario(aula, dia, hora, duracion));
        System.out.println("Reserva exitosa.");
    }

    private static void liberarHorario(Scanner scanner, GestorAulas gestor, GestorHistorial historial) throws Exception {
        gestor.listarAulasOrdenadas();
        System.out.print("Nombre del aula: ");
        String nombreAula = scanner.nextLine();
        int dia = leerEntero(scanner, "Dia 0=Domingo, 1=Lunes ... 6=Sabado: ");
        int hora = leerEntero(scanner, "Hora 0-23: ");
        int duracion = leerEntero(scanner, "Duracion en horas: ");

        Aula aula = gestor.buscarAula(nombreAula);
        if (aula == null) {
            System.out.println("No existe esa aula.");
            return;
        }

        aula.liberar(dia, hora, duracion);
        historial.registrarAccion(new AccionLiberarHorario(aula, dia, hora, duracion));
        System.out.println("Horario liberado.");
    }

    private static void consultarHorario(Scanner scanner, GestorAulas gestor) throws Exception {
        gestor.listarAulasOrdenadas();
        System.out.print("Nombre del aula: ");
        String nombreAula = scanner.nextLine();
        int dia = leerEntero(scanner, "Dia 0=Domingo, 1=Lunes ... 6=Sabado: ");
        int hora = leerEntero(scanner, "Hora 0-23: ");

        Aula aula = gestor.buscarAula(nombreAula);
        if (aula == null) {
            System.out.println("No existe esa aula.");
            return;
        }

        System.out.println(aula.consultarDisponibilidad(dia, hora) ? "Disponible." : "Ocupado.");
    }

    private static void agregarConexion(Scanner scanner, GestorRutas gestor) {
        gestor.mostrarEdificios();
        int origen = leerEntero(scanner, "Origen: ");
        int destino = leerEntero(scanner, "Destino: ");
        int distancia = leerEntero(scanner, "Distancia en metros: ");
        gestor.agregaConexion(origen, destino, distancia);
        System.out.println("Conexion registrada.");
    }

    private static void calcularRuta(Scanner scanner, GestorRutas gestor) {
        gestor.mostrarEdificios();
        int origen = leerEntero(scanner, "Origen: ");
        int destino = leerEntero(scanner, "Destino: ");
        gestor.calcularRutaMasCorta(origen, destino);
    }

    private static void registrarNota(Scanner scanner, GestorEstudiantes gestor, GestorHistorial historial) throws Exception {
        System.out.print("ID Estudiante: ");
        String id = scanner.nextLine();
        Estudiante estudiante = gestor.buscarEstudiante(id);
        int semestre = leerEntero(scanner, "Semestre: ");
        System.out.print("Nombre materia: ");
        String materia = scanner.nextLine();
        double nota = leerDouble(scanner, "Nota: ");

        RegistroNota registro = estudiante.registrarNotas(semestre, materia, nota);
        if (registro != null) {
            historial.registrarAccion(new AccionRegistrarNota(estudiante, registro));
            System.out.println("Nota registrada.");
        }
    }

    private static void verReporteAcademico(Scanner scanner, GestorEstudiantes gestor, GestorReportes reportes) throws Exception {
        System.out.print("ID Estudiante: ");
        String id = scanner.nextLine();
        Estudiante estudiante = gestor.buscarEstudiante(id);
        String reporte = estudiante.generarReporteAcademico() + "\n" + estudiante.generarReporteReprobadas();
        reportes.verNuevoReporte(reporte);
    }

    private static void procesarBatch(Scanner scanner, GestorBatch batch,
            GestorEstudiantes gestorEstudiantes, GestorMaterias gestorMaterias) throws Exception {
        System.out.print("Ruta del archivo CSV: ");
        String ruta = scanner.nextLine();
        batch.cargarArchivo(ruta);
        batch.procesar(gestorEstudiantes, gestorMaterias);
    }

    private static void listarFacultades(Facultad[] facultades) {
        System.out.println("--- FACULTADES ---");
        for (Facultad facultad : facultades) {
            System.out.println("- " + facultad.getNombre());
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private static double leerDouble(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }
}
