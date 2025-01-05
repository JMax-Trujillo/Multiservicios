package pkg4_tareas_empleado;

import java.util.Scanner;

public class P02ActualizarTareasSimplificado {
    public static void ejecutable(){
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer datos del usuario

        // Lista de tareas y sus estados iniciales
        String[] tareas = {"Preparar informe", "Revisar correos", "Asistir a reunión"};
        String[] estados = {"Pendiente", "Pendiente", "Pendiente"};

        // Mostrar tareas con sus estados
        System.out.println("Tareas:");
        for (int i = 0; i < tareas.length; i++) {
            System.out.println((i + 1) + ". " + tareas[i] + " [" + estados[i] + "]");
        }

        // Solicitar al usuario que seleccione una tarea para actualizar
        System.out.print("\nSeleccione tarea a actualizar (1-" + tareas.length + "): ");
        int seleccion = scanner.nextInt() - 1; // Convertir entrada a índice (restar 1)

        // Validar selección del usuario
        if (seleccion >= 0 && seleccion < tareas.length) {
            // Alternar estado entre "Pendiente" y "Completada"
            estados[seleccion] = estados[seleccion].equals("Pendiente") ? "Completada" : "Pendiente";
            System.out.println("\nEstado actualizado: " + tareas[seleccion] + " [" + estados[seleccion] + "]");
        } else {
            System.out.println("\nSelección inválida. Por favor, intente nuevamente.");
        }
    }
}
