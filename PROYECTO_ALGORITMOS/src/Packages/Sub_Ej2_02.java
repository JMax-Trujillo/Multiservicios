package Packages;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sub_Ej2_02 {

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void ejecutable(){

        Statement stmt;
        ResultSet rs;
        ArrayList<Integer> lista_etrv_id = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int des_id;

        System.out.println("===============================================================================");
        System.out.println("Ingresa el ID del entrevistador a eliminar (SI NO ESTÄ DISPONIBLE NO APARECERÄ)");
        try{
            Connection conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id, nombre FROM entrevistadores WHERE disponibilidad='si';");
            System.out.println("====== Entrevistadores ======");
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id") + "| Nombre: " + rs.getString("nombre"));
                lista_etrv_id.add(Integer.parseInt(rs.getString("id")));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        if(lista_etrv_id.size() != 0){
            do{
                System.out.print("Entrevistador ID: ");
                des_id = sc.nextInt();
                sc.nextLine();
                
            }while(!(lista_etrv_id.contains(des_id)));

            try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM entrevistadores WHERE id=?;")){
                    conn.setAutoCommit(false);
                    pstmt.setInt(1, des_id);
                    pstmt.executeUpdate();

                    conn.commit();

            }catch (SQLException ex){
                ex.printStackTrace();
            }
            
            System.out.println("ENTREVISTADOR ELIMINADO");
            System.out.print("(PRESIONE ENTER para continuar)");
            String cach = sc.nextLine();
    
        }else{
            System.out.println("NO SE PUEDEN ELIMINAR ENTREVISTADORES EN ESTE MOMENTO");
            System.out.print("(PRESIONE ENTER para continuar)");
            String cach = sc.nextLine();
        }
    }
}
