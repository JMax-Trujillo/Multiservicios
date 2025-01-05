package pkg4_tareas_empleado;

import java.util.ArrayList;
import java.util.Scanner;

public class P01ListaTareasSimplificado {
    public static void ejecutable(){
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer datos del usuario
        ArrayList<String> tareas = new ArrayList<>(); // Crear una lista dinámica para almacenar tareas

        System.out.print("Nombre del empleado: ");
        String empleado = scanner.nextLine(); // Leer el nombre del empleado desde el teclado

        System.out.println("Ingrese tareas (deje vacío para terminar):");
        while (true) {
            String tarea = scanner.nextLine(); // Leer cada tarea del usuario
            if (tarea.isEmpty()) break;       // Terminar el bucle si el usuario deja vacío
            tareas.add(tarea);                // Agregar la tarea a la lista
        }

        // Mostrar las tareas ingresadas
        System.out.println("\nEmpleado: " + empleado + " - Tareas:");
        for (int i = 0; i < tareas.size(); i++) { // Iterar sobre la lista de tareas
            System.out.println((i + 1) + ". " + tareas.get(i)); // Imprimir cada tarea
        }
    }
}
