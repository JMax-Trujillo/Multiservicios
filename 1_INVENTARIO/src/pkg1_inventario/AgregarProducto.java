package pkg1_inventario;

import java.util.Scanner;

public class AgregarProducto {
    public void agregarNuevoProducto(Inventario inventario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese el ID del nuevo producto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la cantidad inicial del producto: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el costo unitario del producto: ");
        double costo = scanner.nextDouble();

        System.out.print("Ingrese el consumo diario del producto: ");
        int consumoDiario = scanner.nextInt();

        inventario.agregarProducto(id, nombre, cantidad, costo, consumoDiario);
        System.out.println("Producto agregado exitosamente al inventario.");
    }
}
