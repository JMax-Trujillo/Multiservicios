package Packages;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ej2 {
    public static void ejecutable(){
        
        Scanner sc = new Scanner(System.in);
        Statement stmt;
        ResultSet rs;
        int des_pan;
        
        String sqlESF = "SELECT * FROM entrevistadores;";
        do {
            try{
                Connection conn = DriverManager.getConnection(URL);
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlESF);

                System.out.println("====== Entrevistadores ======");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id")+
                    "| Nombre: " + rs.getString("nombre") +
                    "| correo: " + rs.getString("correo")+
                    "| Disponibilidad: " + rs.getString("disponibilidad"));
                }
                System.out.println("=============================");
                System.out.print("(PRESIONE ENTER para continuar)");
                String cach = sc.nextLine();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            do{
                Menu();
                System.out.print(":: ");
                des_pan = sc.nextInt();
                sc.nextLine();
            }while (des_pan < 1 || des_pan > 3);

            switch (des_pan) {
                case 1:
                    Sub_Ej2_01.ejecutable();

                    break;
                case 2:
                    Sub_Ej2_02.ejecutable();

                    break;
                default:
                    break;
            }

        }while(des_pan != 3);


    }

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void Menu(){
        System.out.println("============================================");
        System.out.println("MENU DE OPCIONES DE PANEL DE ENTREVISTADORES");
        System.out.println("============================================");
        System.out.println("Añadir nuevo entrevistador (1)");
        System.out.println("Eliminar entrevistador (2)");
        System.out.println("Salir (3)");
    }
}


