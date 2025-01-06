package Packages;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ej4 {

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void ejecutable(){
        Scanner sc = new Scanner(System.in);
        int des_rsv;
        do {
            do {
                Menu();
                des_rsv = sc.nextInt();
                sc.nextLine();    
            }while (des_rsv<1 || des_rsv >4);

            switch (des_rsv) {
                case 1:
                    Sub_Ej4_01.ejecutable();
                    break;
                case 2:
                    Sub_Ej4_02.ejecutable();
                    break;
                case 3:
                    Sub_Ej4_03.ejecutable();
                    break;
            }
        }while(des_rsv != 4);
    }

    public static void Menu(){
        System.out.println("==============================");
        System.out.println("MENU DE RESERVAS DE ENTREVISTA");
        System.out.println("==============================");
        System.out.println("Cambiar entrevistador (1)");
        System.out.println("Cambiar fecha y hora (2)");
        System.out.println("Eliminar reserva (3)");
        System.out.println("Salir (4)");
    }
}
