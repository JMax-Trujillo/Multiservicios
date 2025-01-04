/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2_reserva_producto;

import java.util.Scanner;

/**
 *
 * @author nanci
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ReservaProducto reserva = new ReservaProducto();
        VerificarProducto verificar = new VerificarProducto();
        ActualizarProducto actualizar = new ActualizarProducto();
        ConsultarReserva consultar = new ConsultarReserva();
        // TODO code application logic here
        boolean is_active = true;
        while (is_active) {
            System.out.println("Menu de opciones");
            System.out.println("1. Reserva");
            System.out.println("2. Verifica");
            System.out.println("3. Actualiza");
            System.out.println("4. Consultar");
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
