package pkg2_reserva_producto;
import java.util.ArrayList;
import java.util.Scanner;

public class ActualizarProducto {
    public static void ejecutable(){
        System.out.println("ACTUALIZAR EL STOCK DE UN PRODUCTO");
        Scanner sc = new Scanner(System.in);

        // Inventario inicial
        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        // Agregando algunos productos iniciales
        productos.add("cables");
        cantidades.add(100);
        productos.add("tubos pvc");
        cantidades.add(80);
        productos.add("alambres");
        cantidades.add(50);
        productos.add("fusiles");
        cantidades.add(40);
        productos.add("interruptores");
        cantidades.add(45);
        productos.add("tomacorrientes");
        cantidades.add(35);
        productos.add("placas");
        cantidades.add(30);

        while (true) {
            System.out.println("\n--- GESTION DE INVENTARIO ---");
            System.out.println("1. Actualizar cantidad de producto");
            System.out.println("2. Eliminar producto del inventario");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: 
                    System.out.print("Ingresa el nombre del producto a actualizar: ");
                    String nombreActualizar = sc.nextLine();
                    int indexActualizar = productos.indexOf(nombreActualizar);

                    if (indexActualizar != -1) {
                        System.out.print("Ingresa la nueva cantidad: ");
                        int nuevaCantidad = sc.nextInt();
                        cantidades.set(indexActualizar, nuevaCantidad);
                        System.out.println("¡Cantidad actualizada exitosamente!");
                    } else {
                        System.out.println("El producto no está en el inventario.");
                    }
                    break;

                case 2: 
                    System.out.print("Ingresa el nombre del producto a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    int indexEliminar = productos.indexOf(nombreEliminar);

                    if (indexEliminar != -1) {
                        productos.remove(indexEliminar);
                        cantidades.remove(indexEliminar);
                        System.out.println("¡Producto eliminado exitosamente!");
                    } else {
                        System.out.println("El producto no está en el inventario.");
                    }
                    break;

                case 3: 
                    System.out.println("\n--- INVENTARIO ---");
                    if (productos.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        for (int i = 0; i < productos.size(); i++) {
                            System.out.println(productos.get(i) + " - Cantidad: " + cantidades.get(i));
                        }
                    }
                    break;

                case 4: 
                    System.out.println("Saliendo del sistema de gestion de inventarios...");
                    return;

                default:
                    System.out.println("Opcion no valida. Intenta nuevamente.");
            }
        }
    }
}
