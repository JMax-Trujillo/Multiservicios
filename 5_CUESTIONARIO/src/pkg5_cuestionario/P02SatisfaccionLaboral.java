package pkg5_cuestionario;

import java.util.Scanner;

public class P02SatisfaccionLaboral {
    public static void ejecutable() {
        Scanner scanner = new Scanner(System.in);
        
        // Variables para almacenar los resultados
        String[] nombresEmpleados = new String[100];  
        double[] promediosSatisfaccion = new double[100];
        String[] nivelesSatisfaccion = new String[100];
        int cantidadEmpleados = 0;
        
        while (true) {
            // Pedir el nombre del empleado
            System.out.println(".........................................................");
            System.out.print("Ingrese el nombre del empleado (o 'salir' para terminar y mostrar resultados ): ");
            String nombre = scanner.nextLine();
            
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }
            
            //nombre del empleado
            nombresEmpleados[cantidadEmpleados] = nombre;
            
            // Preguntar por la satisfacción con diferentes aspectos
            System.out.println("Evaluación de la satisfacción laboral para " + nombre);
            
            System.out.print("¿Qué tan satisfecho está con su trabajo (de 1 a 5)? ");
            int trabajo = scanner.nextInt();
            
            System.out.print("¿Qué tan satisfecho está con la relación con sus compañeros (de 1 a 5)? ");
            int compañeros = scanner.nextInt();
            
            System.out.print("¿Qué tan satisfecho está con la relación con su supervisor (de 1 a 5)? ");
            int supervisor = scanner.nextInt();
            
            System.out.print("¿Qué tan satisfecho está con las oportunidades de crecimiento profesional (de 1 a 5)? ");
            int crecimiento = scanner.nextInt();
            
            System.out.print("¿Qué tan satisfecho está con los beneficios laborales (de 1 a 5)? ");
            int beneficios = scanner.nextInt();
        
            int puntuacionTotal = trabajo + compañeros + supervisor + crecimiento + beneficios;
            
            // Calcular el promedio de satisfacción
            double promedio = puntuacionTotal / 5.0;
            promediosSatisfaccion[cantidadEmpleados] = promedio;
        
            String nivel;
            if (promedio >= 4) {
                nivel = "Alta";
            } else if (promedio >= 3) {
                nivel = "Media";
            } else {
                nivel = "Baja";
            }
            nivelesSatisfaccion[cantidadEmpleados] = nivel;
            
            cantidadEmpleados++;

            scanner.nextLine();
        }
        
        System.out.println("\nResumen de los resultados de satisfacción laboral de todos los empleados:");
        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println("\nEmpleado: " + nombresEmpleados[i]);
            System.out.println("Promedio de satisfacción: " + promediosSatisfaccion[i]);
            System.out.println("Nivel de satisfacción: " + nivelesSatisfaccion[i]);
            System.err.println("________________________________________________________");
        }
        
    }
}
