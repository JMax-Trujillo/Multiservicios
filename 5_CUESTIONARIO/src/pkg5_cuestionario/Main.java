package pkg5_cuestionario;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        P01NecesidadesLaborales p01 = new P01NecesidadesLaborales();
        P02SatisfaccionLaboral p02 = new P02SatisfaccionLaboral();
        P03SistemaSugerencias p03 = new P03SistemaSugerencias();
        P04CuestionarioCapacitacion p04 = new P04CuestionarioCapacitacion();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Necesidades Laborales");
            System.out.println("2. Satisfaccion Laboral");
            System.out.println("3. Sistema de Sugerencias");
            System.out.println("4. Cuestionario de Capacitacion");
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
