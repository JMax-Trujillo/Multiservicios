package pkg2_reserva_producto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RegistroProductos reserva = new RegistroProductos();
        VerificarProducto verificar = new VerificarProducto();
        ActualizarProducto actualizar = new ActualizarProducto();
        ReservarProducto consultar = new ReservarProducto();
        boolean is_active = true;
        while (is_active) {
            System.out.println("Menu de opciones");
            System.out.println("1. Registrar");
            System.out.println("2. Verifica");
            System.out.println("3. Actualiza");
            System.out.println("4. Reservar");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    reserva.ejecutable();
                    break;
                case 2:
                    verificar.ejecutable();
                    break;
                case 3:
                    actualizar.ejecutable();                
                    break;
                case 4:
                    consultar.ejecutable();
                    break;
                case 5:
                    is_active = false;
                    System.out.println("Has salido");
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }
        }
    }
    
}
