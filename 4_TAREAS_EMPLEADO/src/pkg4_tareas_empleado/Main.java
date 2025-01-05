package pkg4_tareas_empleado;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        P01ListaTareasSimplificado p01 = new P01ListaTareasSimplificado(); 
        P02ActualizarTareasSimplificado p02 = new P02ActualizarTareasSimplificado();
        P03ConsultarTareasSimplificado p03 = new P03ConsultarTareasSimplificado();
        P04InformeMensualSimplificado p04 = new P04InformeMensualSimplificado();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Lista de Tareas");
            System.out.println("2. Actualizar Tareas");
            System.out.println("3. Consultar Tareas");
            System.out.println("4. Informe Mensual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    p01.ejecutable();
                    break;
                case 2:
                    p02.ejecutable();
                    break;
                case 3:
                    p03.ejecutable();
                    break;
                case 4:
                    p04.ejecutable();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
    
}
