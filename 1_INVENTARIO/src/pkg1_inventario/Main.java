package pkg1_inventario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        VerificarStock verificarStock = new VerificarStock();
        ValorTotal valorTotal = new ValorTotal();
        InformeProductos informeProductos = new InformeProductos();
        DuracionStock duracionStock = new DuracionStock();
        AgregarProducto agregarProducto = new AgregarProducto();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Verificar stock");
            System.out.println("2. Calcular valor total del inventario");
            System.out.println("3. Informe de productos");
            System.out.println("4. Calcular duración del stock");
            System.out.println("5. Agregar nuevo producto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    verificarStock.mostrarStock(inventario);
                    break;
                case 2:
                    valorTotal.calcularValorTotal(inventario);
                    break;
                case 3:
                    informeProductos.mostrarInforme(inventario);
                    break;
                case 4:
                    duracionStock.calcularDuracion(inventario);
                    break;
                case 5:
                    agregarProducto.agregarNuevoProducto(inventario);
                    break;
                case 6:
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
