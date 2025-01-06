package Packages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Sub_Ej2_01 {

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void ejecutable(){

        String nomb_etrv, correo_etrv;
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================================================");
        System.out.println("Ingresa los datos del nuevo entrevistador (OBLIGATORIO LLENAR TODOS LOS CAMPOS)");
        do {
            System.out.print("Nombre: ");
            nomb_etrv = sc.nextLine();
        }while (nomb_etrv.length()<1);
        do {
            System.out.print("Correo: ");
            correo_etrv = sc.nextLine();
        }while (correo_etrv.length()<1);

        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO entrevistadores (nombre, correo, disponibilidad) VALUES (?, ?, 'si');");){
                conn.setAutoCommit(false);
                pstmt.setString(1, nomb_etrv);
                pstmt.setString(2, correo_etrv);
                pstmt.executeUpdate();

                conn.commit();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        System.out.println("DATOS INGRESADOS");
        System.out.print("(PRESIONE ENTER para continuar)");
        String cach = sc.nextLine();

    }
    

}
