package pkg4_tareas_empleado;

public class P03ConsultarTareasSimplificado {
    public static void ejecutable(){
        String[] tareas = {"Preparar informe", "Revisar correos", "Asistir a reunión"};
        String[] estados = {"Pendiente", "Completada", "Pendiente"};

        // Mostrar solo las tareas pendientes
        System.out.println("Tareas pendientes:");
        for (int i = 0; i < tareas.length; i++) { // Iterar sobre las tareas
            if (estados[i].equals("Pendiente")) { // Verificar si el estado es "Pendiente"
                System.out.println("- " + tareas[i]); // Imprimir las tareas pendientes
            }
        }
    }
}
