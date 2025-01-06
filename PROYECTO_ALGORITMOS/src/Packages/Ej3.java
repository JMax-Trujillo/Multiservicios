package Packages;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ej3 {

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void ejecutable(){
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("====== Reservas de entrevista de trabajo ======");
        try{
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM candidatos;");
            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    "| Nombre: " + rs.getString("nombre") +
                    "| Correo: " + rs.getString("correo") +
                    "| Fecha: " + rs.getString("fecha") +
                    "| Hora: " + rs.getString("hora") +
                    "| ID entrevistador: " + rs.getInt("entrevistador_id")
                );
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        System.out.println("==============================");
        System.out.print("(PRESIONE ENTER para continuar)");
        String cach = sc.nextLine();

    }
}
