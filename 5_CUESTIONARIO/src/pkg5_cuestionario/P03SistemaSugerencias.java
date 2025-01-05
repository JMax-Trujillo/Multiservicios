package pkg5_cuestionario;

import java.util.ArrayList;
import java.util.Scanner;

public class P03SistemaSugerencias {
    public static void ejecutable() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sugerencia> sugerencias = new ArrayList<>();
        
        while (true) {
           
            System.out.print("Ingrese el nombre del empleado o 'salir' para terminar y mostrar resultados: ");
            String nombre = scanner.nextLine();
            
            if (nombre.equalsIgnoreCase("salir")) {
                break; 
            }
            
            System.out.print("Ingrese su sugerencia: ");
            String sugerencia = scanner.nextLine();

            sugerencias.add(new Sugerencia(nombre, sugerencia));
        }

        System.out.println("\nSugerencias de todos los empleados:");
        for (Sugerencia sug : sugerencias) {
            System.out.println("\nEmpleado: " + sug.nombreEmpleado);
            System.out.println("Sugerencia: " + sug.sugerencia);
        }
      
    }
}

class Sugerencia {
    String nombreEmpleado;
    String sugerencia;

    public Sugerencia(String nombreEmpleado, String sugerencia) {
        this.nombreEmpleado = nombreEmpleado;
        this.sugerencia = sugerencia;
    }
}