package pkg2_reserva_producto;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservarProducto {
    public static void ejecutable(){
        System.out.println("RESERVAR PRODUCTO");
        Scanner sc = new Scanner(System.in);

        ArrayList<String> nombresClientes = new ArrayList<>();
        ArrayList<String> productosReservados = new ArrayList<>();
        ArrayList<Integer> cantidadesReservadas = new ArrayList<>();

        System.out.println("--- SISTEMA DE RESERVAS DE PRODUCTOS ---");

        while (true) {
            System.out.println("\n1. Registrar reserva");
            System.out.println("2. Mostrar reservas");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1: 
                    System.out.print("Ingresa el nombre del cliente: ");
                    String nombreCliente = sc.nextLine();
                    
                    System.out.print("Ingresa el nombre del producto a reservar: ");
                    String nombreProducto = sc.nextLine();
                    
                    System.out.print("Ingresa la cantidad a reservar: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine(); 

                    
                    nombresClientes.add(nombreCliente);
                    productosReservados.add(nombreProducto);
                    cantidadesReservadas.add(cantidad);

                    System.out.println("¡Reserva registrada exitosamente!");
                    break;

                case 2: 
                    System.out.println("\n--- RESERVAS REALIZADAS ---");
                    if (nombresClientes.isEmpty()) {
                        System.out.println("No hay reservas registradas.");
                    } else {
                        for (int i = 0; i < nombresClientes.size(); i++) {
                            System.out.println(nombresClientes.get(i) + " reservo " + 
                                               productosReservados.get(i) + ": " + 
                                               cantidadesReservadas.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del sistema de reservas...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opcion no valida. ¡Intenta nuevamente!");
            }
        }
    }
}
