package pkg5_cuestionario;

import java.util.ArrayList;
import java.util.Scanner;

public class P01NecesidadesLaborales {
    public static void ejecutable(){
        Scanner scanner = new Scanner(System.in);
        
        // lista para los resultados
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        // preguntas 
        String[] preguntas = {
            "¿Consideras que las condiciones de seguridad son adecuadas para las actividades que realizas? ¿Por qué?",
            "¿Te sientes Suficientemente capacitado para realizar tus actividades laborales?",
            "¿Consideras que deberian recibir mas equipos de proteccion? ¿cuales consideras?",
            "¿las herramientas que utilizas en tu trabajo son adecuadas? ¿Que herramientas crees que hacen falta?",
            "¿Las condicione sen tu area de trabajo son adecuadas?",
            "¿Qué sugerirías para mejorar la comunicación interna?",
            "¿Consideras que los plazos de entrega son adecuados?",
            "¿El liderazgo es efectivo en tu área?",
            "¿Te gustaría recibir más capacitación?",
            "¿Qué mejoras propondrías en los beneficios laborales?"
        };

        //ingresar encuestas
        while (true) {
          
            System.out.print("\nIngrese el nombre del empleado o 'salir' para terminar y mostrar resultados): ");
            String nombre = scanner.nextLine();
            
            if (nombre.equalsIgnoreCase("salir")) {
                break; 
            }
            
        
            String[] respuestas = new String[10];
            
           
            System.out.println("\nResponda las siguientes preguntas, " + nombre + ":");
            for (int i = 0; i < preguntas.length; i++) {
                System.out.print(preguntas[i] + ": ");
                respuestas[i] = scanner.nextLine();
            }
            
            // objeto con el nombre y las respuestas
            empleados.add(new Empleado(nombre, respuestas));
        }
        
        // Imprimir los resultados de todos los empleados
        System.out.println("\nResumen de los resultados de necesidades de todos los empleados:");
        for (Empleado empl : empleados) {
            System.out.println("\nEmpleado: " + empl.nombre);
            for (int i = 0; i < preguntas.length; i++) {
                System.out.println(preguntas[i] + ": " + empl.respuestas[i]);
            }
        }
    }
}

class Empleado {
    String nombre;
    String[] respuestas;

    // Constructor para el objeto Empleado
    public Empleado(String nombre, String[] respuestas) {
        this.nombre = nombre;
        this.respuestas = respuestas;
    }
}