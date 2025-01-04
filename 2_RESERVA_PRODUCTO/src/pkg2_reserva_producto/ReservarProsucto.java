package pkg2_reserva_producto;
import java.util.Scanner;
public class ReservarProsucto {
    public static void ejecutable(){
        System.out.println("BUSCAR UN PRODUCTO");
        Scanner sc = new Scanner(System.in);
        String[] productos = {"cables", "alambres", "tubos pvc", "interruptores", "placas", "conectores"};
        int[] cantidades = {10, 20, 15, 8, 12, 9};

        System.out.print("Ingresa el nombre del producto a buscar: ");
        String buscar = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i].equalsIgnoreCase(buscar)) {
                System.out.println("PRODUCTO: " + productos[i] + " - CANTIDAD: " + cantidades[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("EL PRODUCTO NO SE ENCUENTRA DISPONIBLE");
        }

        sc.close();
    }
}
