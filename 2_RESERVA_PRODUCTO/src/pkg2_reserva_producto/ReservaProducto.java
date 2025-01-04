package pkg2_reserva_producto;
import java.util.Scanner;
public class ReservaProducto {
    public static void ejecutable(){
        System.out.println("REGISTRO DE PRODUCTOS");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el numero de productos a registrar: ");
        int numero=sc.nextInt();
        sc.nextLine();
        String[] productos = new String[numero];
        int[] cantidades = new int[numero];
        int contador = 0;

        System.out.println("¡PRODUCTOS REGISTRADOS!:");
        while (contador < numero) {
            System.out.print("Ingresa el nombre del producto: ");
            productos[contador] = sc.nextLine();

            System.out.print("Ingresa la cantidad del producto: ");
            cantidades[contador] = sc.nextInt();
            sc.nextLine(); 

            contador++;
        }

        System.out.println("\nInventario registrado:");
        for (int i = 0; i < contador; i++) {
            System.out.println(productos[i] + ": " + cantidades[i] + " unidades");
        }

        sc.close();
    }

    }

