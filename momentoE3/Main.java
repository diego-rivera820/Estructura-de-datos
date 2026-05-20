package momentoE3;

import momentoE3.modelo.*;
import momentoE3.util.*;
import momentoE3.excepciones.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorEstudiantes gestorEstudiantes = new GestorEstudiantes();
        GestorAulas gestorAulas = new GestorAulas();
        GestorRutas gestorRutas = new GestorRutas();
        GestorHistorial gestorHistorial = new GestorHistorial();
        GestorReportes gestorReportes = new GestorReportes();
        GestorMaterias gestorMaterias = new GestorMaterias();

        String[] facultades = new String[]{"Ingeniería", "Básicas", "Económicas", "Humanas", "Salud"};

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

       while (!salir) {
            System.out.println("\n=======================================================");
            System.out.println("     SISTEMA DE GESTIÓN UNIVERSITARIA - MOMENTO 3      ");
            System.out.println("=======================================================");
            System.out.println(" [ GESTIÓN DE ESTUDIANTES ]");
            System.out.println("   1. Registrar estudiante    |  3. Listar estudiantes");
            System.out.println("   2. Buscar estudiante       |  4. Eliminar estudiante");
            System.out.println("-------------------------------------------------------");
            System.out.println(" [ GESTIÓN DE MATERIAS E INSCRIPCIONES ]");
            System.out.println("   5. Crear materia           |  8. Inscribir estudiante");
            System.out.println("   6. Asignar pre-requisito   |  9. Cancelar inscripción");
            System.out.println("   7. Ver pre-requisitos      | 10. Ver cola de espera");
            System.out.println("-------------------------------------------------------");
            System.out.println(" [ UTILIDADES DEL SISTEMA ]");
            System.out.println("  19. Deshacer acción         | 22. Ver Facultades");
            System.out.println("  20. Rehacer acción          |  0. SALIR DEL SISTEMA");
            System.out.println("=======================================================");
            System.out.print("➤ Ingrese una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                

                switch (opcion) {
                    case 1:
                        System.out.print("ID: "); String id = scanner.nextLine();
                        System.out.print("Nombre: "); String nombre = scanner.nextLine();
                        Estudiante nuevoEst = new Estudiante(id, nombre, "correo@univ.edu", 1);
                        gestorEstudiantes.registrarEstudiante(nuevoEst);
                        System.out.println("Registrado.");
                        break;
                    case 2:
                        System.out.print("ID a buscar: "); String idBus = scanner.nextLine();
                        System.out.println("Encontrado: " + gestorEstudiantes.buscarEstudiante(idBus).getNombre());
                        break;
                    case 3: gestorEstudiantes.mostrarEstudiantes(); break;
                    case 4:
                        System.out.print("ID a eliminar: "); String idEli = scanner.nextLine();
                        Estudiante eliminado = gestorEstudiantes.eliminarEstudiante(idEli);
                        gestorHistorial.registrarAccion(new AccionEliminarEstudiante(gestorEstudiantes, eliminado));
                        System.out.println("Eliminado. (Deshacible)");
                        break;
                    case 5:
                        System.out.print("Código: "); String cod = scanner.nextLine();
                        System.out.print("Nombre: "); String nom = scanner.nextLine();
                        gestorMaterias.crearMateria(new Materia(cod, nom, 2, 3));
                        System.out.println("Materia creada.");
                        break;
                    case 6:
                        System.out.print("Cod Base: "); String mBase = scanner.nextLine();
                        System.out.print("Cod Req: "); String mReq = scanner.nextLine();
                        gestorMaterias.buscarMateria(mBase).getPrerrequisitos().add(gestorMaterias.buscarMateria(mReq));
                        System.out.println("Requisito agregado.");
                        break;
                    case 8:
                        System.out.print("ID Estudiante: "); String idIns = scanner.nextLine();
                        System.out.print("Cod Materia: "); String codIns = scanner.nextLine();
                        gestorMaterias.inscribirEstudiante(gestorMaterias.buscarMateria(codIns), gestorEstudiantes.buscarEstudiante(idIns));
                        break;
                    case 9:
                        System.out.print("ID Estudiante: "); String idCan = scanner.nextLine();
                        System.out.print("Cod Materia: "); String codCan = scanner.nextLine();
                        gestorMaterias.cancelarInscripcion(gestorMaterias.buscarMateria(codCan), gestorEstudiantes.buscarEstudiante(idCan));
                        break;
                    case 10:
                        System.out.print("Cod Materia: "); String codCol = scanner.nextLine();
                        for(Estudiante e : gestorMaterias.buscarMateria(codCol).getColaEspera()) System.out.println(e.getNombre());
                        break;
                    case 19: gestorHistorial.deshacer(); break;
                    case 20: gestorHistorial.rehacer(); break;
                    case 22: for(String f : facultades) System.out.println(f); break;
                    case 0: salir = true; break;
                }
            } catch (Exception e) {
                System.out.println("Error o dato inválido.");
                if(scanner.hasNextLine()) scanner.nextLine();
            }
        }
    }
}