package pkg4_tareas_empleado;

import java.time.LocalDate;

public class P04InformeMensualSimplificado {
    public static void ejecutable(){
        // Definición de un arreglo de tareas
        String[] tareas = {"Preparar informe", "Revisar correos", "Asistir a capacitación"};
        
        // Definición de un arreglo de estados correspondientes a las tareas
        String[] estados = {"Completada", "Completada", "Pendiente"};
        
        // Definición de un arreglo de fechas correspondientes a las tareas
        LocalDate[] fechas = {
            LocalDate.of(2023, 12, 5), // Fecha de la primera tarea
            LocalDate.of(2023, 12, 15), // Fecha de la segunda tarea
            LocalDate.of(2023, 12, 20) // Fecha de la tercera tarea
        };

        // Imprimir el encabezado del informe de tareas completadas en diciembre
        System.out.println("Tareas completadas en diciembre:");

        // Bucle que recorre todas las tareas
        for (int i = 0; i < tareas.length; i++) {
            // Verificación de dos condiciones:
            // 1. Si el estado de la tarea es "Completada"
            // 2. Si la tarea fue realizada en el mes de diciembre (mes = 12)
            if (estados[i].equals("Completada") && fechas[i].getMonthValue() == 12) {
                // Si ambas condiciones se cumplen, imprime la tarea con su fecha
                System.out.println("- " + tareas[i] + " (Fecha: " + fechas[i] + ")");
            }
        }
    }
}
