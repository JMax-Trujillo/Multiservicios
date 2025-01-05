package pkg1_inventario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VerificarStock verificar = new VerificarStock();
        ValorTotal valor = new ValorTotal();
        InformeProductos informe = new InformeProductos();
        DuracionStock duracion = new DuracionStock();
        Scanner sc = new Scanner(System.in);
        boolean is_active = true;
        while (is_active) {
            System.out.println("Menu de opciones:");
            System.out.println("1. Identificar productos que esten por acabarse en el inventario");
            System.out.println("2. Calcular el valor total de los productos almacenados");
            System.out.println("3. Generar un informe de productos vendidos");
            System.out.println("4. Estimar el tiempo de duracion del stock actual basado en el consumo promedio diario");
            System.out.println("5. Salir del menú");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    verificar.ejecutable();
                    break;
                case 2:
                    valor.ejecutable();
                    break;
                case 3:
                    informe.ejecutable();
                    break;
                case 4:
                    duracion.ejecutable();
                    break;
                case 5:
                    is_active = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }

    }
    
}
