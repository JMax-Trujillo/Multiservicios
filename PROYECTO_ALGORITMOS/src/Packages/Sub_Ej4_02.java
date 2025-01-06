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


public class Sub_Ej4_02 {

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void ejecutable(){

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>lista_id = new ArrayList<>();
        int des_id2;
        String fecha_ne, hora_ne;
        
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
        System.out.println("=== Idique la nueva fecha y hora ===");
        System.out.print("Fecha: ");
        fecha_ne = sc.nextLine();
        System.out.print("Hora: ");
        hora_ne = sc.nextLine();

        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement("UPDATE candidatos SET fecha=?, hora=? WHERE id=?;")){
            conn.setAutoCommit(false);
            pstmt.setString(1, fecha_ne);
            pstmt.setString(2, hora_ne);
            pstmt.setInt(3, des_id2);
            pstmt.executeUpdate();

            conn.commit();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        System.out.println("FECHA Y HORA DE ENTREVISTA ACTUALIZADOS");
        System.out.print("(PRESIONE ENTER para continuar)");
        String cach = sc.nextLine();
    }
}
