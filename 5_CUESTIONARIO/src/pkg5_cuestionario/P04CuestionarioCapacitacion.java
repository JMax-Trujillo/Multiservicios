package pkg5_cuestionario;

import java.util.ArrayList;
import java.util.Scanner;

class Evaluacion {
    String nombreEmpleado;
    ArrayList<String> respuestas;

    public Evaluacion(String nombreEmpleado, ArrayList<String> respuestas) {
        this.nombreEmpleado = nombreEmpleado;
        this.respuestas = respuestas;
    }
}

public class P04CuestionarioCapacitacion {
    static String[] preguntas = {
        "1. ¿Qué es la misión de la empresa?",
        "2. ¿Cómo se describe la visión de la empresa?",
        "3. ¿Qué significa el concepto de 'trabajo en equipo'?",
        "4. ¿Cómo puedes contribuir al bienestar en el lugar de trabajo?",
        "5. ¿Cuál es la política de seguridad laboral de la empresa?"
    };
    public static void ejecutable() {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        
        while (true) {
            
            System.out.print("Ingrese el nombre del empleado o 'salir' para terminar y mostrar resultados): ");
            String nombre = scanner.nextLine();
            
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }
            
            ArrayList<String> respuestas = new ArrayList<>();
            
            System.out.println("Cuestionario para " + nombre + ":");
            for (String preg : preguntas) {
                System.out.println(preg);
                System.out.print("Respuesta: ");
                String respuesta = scanner.nextLine();
                respuestas.add(respuesta);
            }
            
            evaluaciones.add(new Evaluacion(nombre, respuestas));
        }
        
        System.out.println("\nResumen de las evaluaciones de todos los empleados:");
        for (Evaluacion eval : evaluaciones) {
            System.out.println("\nEmpleado: " + eval.nombreEmpleado);
            System.out.println("Respuestas:");
            for (String respuesta : eval.respuestas) {
                System.out.println(" - " + respuesta);
            }
        }
        
    }
}
