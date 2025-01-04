import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Reserva_producto reservar = new Reserva_producto();
        Verificar_producto verificar = new Verificar_producto();
        ActualizarProducto actualizar = new ActualizarProducto();
        Consultar_reserva consultar = new Consultar_reserva();
        
        Scanner sc = new Scanner(System.in);
        boolean is_active = true;
        while (is_active) {
            System.out.println("Escoje una opcion");
            System.out.println("1. Reservar");
            System.out.println("2. Verificar");
            System.out.println("3. Actualizar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            System.out.println("Escoje:  ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    reservar.ejecutable1();
                    break;
                case 2:
                    verificar.ejecutable2();
                    break;
                case 3:
                    actualizar.ejecutable3();
                    break;
                case 4:
                    consultar.ejecutable4();
                    break;
                case 5:
                    is_active = false;
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }
        }


    }
}
