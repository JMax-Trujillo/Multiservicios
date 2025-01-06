package Packages;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sub_Ej4_03 {

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void ejecutable(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>lista_id = new ArrayList<>();
        int des_id2, id_oldw =-1;
        
        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement("SELECT id, nombre, entrevistador_id FROM candidatos;");
        ResultSet rs = pstmt.executeQuery()){
            while (rs.next()) {
                System.out.println("ID: " + Integer.toString(rs.getInt("id")) + "| Nombre: " + rs.getString("nombre"));
                lista_id.add(rs.getInt("id"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        System.out.println("=== Seleccione ID del candidato ===");
        do{
            System.out.print("ID: ");
            des_id2 = sc.nextInt();
            sc.nextLine();
        }while(!(lista_id.contains(des_id2)));

        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM candidatos WHERE id=?;");
        PreparedStatement pstmt2 = conn.prepareStatement("SELECT entrevistador_id FROM candidatos WHERE id=?");
        PreparedStatement pstmt3 = conn.prepareStatement("UPDATE entrevistadores SET disponibilidad='si' WHERE id=?;")){
            conn.setAutoCommit(false);
           

            
            pstmt2.setInt(1, des_id2);
            try(ResultSet rs = pstmt2.executeQuery()){
                if (rs.next()) {
                    id_oldw = rs.getInt("entrevistador_id");
                }
            }
            pstmt3.setInt(1, id_oldw);
            pstmt3.executeUpdate();

            pstmt.setInt(1, des_id2);
            pstmt.executeUpdate();

            conn.commit();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        System.out.println("RESERVA ELIMINADA");
        System.out.print("(PRESIONE ENTER para continuar)");
        String cach = sc.nextLine();
    }
}
