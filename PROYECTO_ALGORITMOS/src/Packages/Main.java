package Packages;

import java.util.Scanner;;



public class Main {
    public static void main(String[] args) {

        int des;

        Scanner sc = new Scanner(System.in);
        do {
            do {
                Menu();
                System.out.print(":: ");
                des = sc.nextInt();
                sc.nextLine();
            }while (des > 5 || des < 1);

            switch (des) {
                case 1:
                    Ej1.ejecutable();
                    break;
                case 2:
                    Ej2.ejecutable();
                    break;
                case 3:
                    Ej3.ejecutable();
                    break;
                case 4:
                    Ej4.ejecutable();
                    break;
                default:
                    break;    
            }
        }while (des != 5);

    }

    public static void Menu(){
        System.out.println("=====================================================");
        System.out.println("''MENÚ DE OPCIONES RESERVA DE ENTREVISTA DE TRABAJO''");
        System.out.println("=====================================================");
        System.out.println("Iniciar reserva de entrevista (1)"); //Hacer que la hora no sea unica
        System.out.println("panel de entrevistadores (2)");
        System.out.println("Visualizar reservas de entrevista (3)");
        System.out.println("Editar reservas de entrevista (4)");
        System.out.println("Salir del menú (5)");
    }
}