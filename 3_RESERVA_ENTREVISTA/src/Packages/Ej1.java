package Packages;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.ArrayList;

public class Ej1 {
    public static void ejecutable(){
        String nombre_us, correo_us, fecha_us, hora_us;
        int num_us;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el número de reservas");
        num_us = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num_us; i ++){
            System.out.println("====================================");
            System.out.print("Nombre: ");
            nombre_us = sc.nextLine();
            System.out.print("Correo: ");
            correo_us = sc.nextLine();
            System.out.print("Fecha: ");
            fecha_us = sc.nextLine();
            System.out.print("Hora: ");
            hora_us = sc.nextLine();
            
            insertarReserva(nombre_us, correo_us, fecha_us, hora_us);
        }
    }

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void insertarReserva(String nombre_us, String correo_us, String fecha_us, String hora_us){
        
        int des_id;
        Scanner sc = new Scanner(System.in);
        String sqlE = "SELECT id, nombre FROM entrevistadores WHERE disponibilidad='si';";
        ArrayList<Integer> lista_ids = new ArrayList<>();

        Statement stmt;
        ResultSet rs;

        try{
            Connection conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlE);
            System.out.println("======== IDs libres ========");
            while (rs.next()){
                System.out.println("ID: " + rs.getString("id") + " Nombre: " + rs.getString("nombre"));
                int num_id = Integer.parseInt(rs.getString("id"));
                lista_ids.add(num_id);
            }
            System.out.println("============================");
            System.out.print("(PRESIONA ENTER para continuar)");
            String cach = sc.nextLine();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        if (lista_ids.size()>0){
            System.out.println("Selecciona un entrevistador por su ID");
            do {
                System.out.print("Elegir ID: ");
                des_id = sc.nextInt();
                sc.nextLine();
            }while(!(lista_ids.contains(des_id)));

            try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE entrevistadores SET disponibilidad='no' WHERE id=?;"
                    )){
                conn.setAutoCommit(false);
                pstmt.setInt(1,des_id);
                pstmt.executeUpdate();
            
                conn.commit();

            }catch (SQLException ex){
                ex.printStackTrace();
            }
        
            String sqlC = "INSERT INTO candidatos (nombre, correo, fecha, hora, entrevistador_id) VALUES (?, ?, ?, ?, ?)";
            try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sqlC)){
                conn.setAutoCommit(false);
                pstmt.setString(1, nombre_us);
                pstmt.setString(2, correo_us);
                pstmt.setString(3, fecha_us);
                pstmt.setString(4, hora_us);
                pstmt.setInt(5, des_id);
                pstmt.executeUpdate();

                conn.commit();

            }catch(SQLException ex){
            ex.printStackTrace();
            }
            lista_ids.clear();
        }else{
            System.out.println("\nNo hay entrevistadores libres\n");
            lista_ids.clear();
        }
    }
}
