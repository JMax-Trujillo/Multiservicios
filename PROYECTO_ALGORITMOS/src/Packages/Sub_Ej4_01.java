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

public class Sub_Ej4_01 {

    private static final String URL ="jdbc:sqlite:entrevista.db";

    public static void ejecutable(){

        ArrayList<String> lista_etrvtwo = new ArrayList<>();
        ArrayList<Integer> lista_etrvid = new ArrayList<>();
        ArrayList<Integer> lista_candid = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int id_ne, id_cand = -1, id_old = -1;



        try(
            Connection conn =DriverManager.getConnection(URL);
            PreparedStatement pstmt1 = conn.prepareStatement("SELECT id, nombre FROM entrevistadores WHERE disponibilidad='si';");
            ResultSet rs1 = pstmt1.executeQuery();
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT id, nombre, entrevistador_id FROM candidatos;");
            ResultSet rs2 = pstmt2.executeQuery();
            PreparedStatement pstmt3 = conn.prepareStatement("SELECT entrevistador_id FROM candidatos WHERE id=?;")){
                        // VER LOS ENTREVISTADORES LIBRES
            while (rs1.next()) {
                String valor_id_nomb = ("ID: " + Integer.toString(rs1.getInt("id")) + "| Nombre: " + rs1.getString("nombre"));
                if (valor_id_nomb.length()>15){
                    lista_etrvid.add(rs1.getInt("id"));
                    lista_etrvtwo.add(valor_id_nomb);
                }
            }
                        // VER ID DE LOS CANDIDATOS
            System.out.println("=== Selecciona ID del candidato ===");
            while (rs2.next()) {
                String valor_id_nomb = ("ID: " + Integer.toString(rs2.getInt("id")) + "| Nombre: " + rs2.getString("nombre"));
                System.out.println(valor_id_nomb);
                if (valor_id_nomb.length()>15){
                    lista_candid.add(rs2.getInt("id"));
                }
            }
            do{
                System.out.print("ID candidato: ");
                id_cand = sc.nextInt();
                sc.nextLine();
            }while(!(lista_candid.contains(id_cand)));

            //VER ID DEL ENTREVISTADOR DEL CANDIDATO
            pstmt3.setInt(1, id_cand);
            try(ResultSet rs3 = pstmt3.executeQuery()){
                if (rs3.next()) {
                    id_old = rs3.getInt("entrevistador_id");
                }
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        //COMPROBAR SI HAY ENTREVISTADORES DISPONIBLES
        System.out.println("======================================");
        if (lista_etrvtwo.size()>0){
            System.out.println("====== Entrevistadores libres ======");
            for (int i = 0; i < lista_etrvtwo.size(); i++){
                System.out.println(lista_etrvtwo.get(i));
            }

            System.out.println("Ignresa el ID del nuevo entrevistador");
            do{
                System.out.print("Nuevo entrevistador: ");
                id_ne = sc.nextInt();
                sc.nextLine();
            }while(!(lista_etrvid.contains(id_ne)));
            

            try(Connection conn = DriverManager.getConnection(URL)){
                try(PreparedStatement pstmt1 = conn.prepareStatement("UPDATE candidatos SET entrevistador_id=?")){
                    conn.setAutoCommit(false);
                    pstmt1.setInt(1, id_ne);
                    pstmt1.executeUpdate();

                    conn.commit();
                }
                try(PreparedStatement pstmt2 = conn.prepareStatement("UPDATE entrevistadores SET dispobilidad='no' WHERE id=?;")){
                    conn.setAutoCommit(false);
                    pstmt2.setInt(1, id_old);
                    pstmt2.executeUpdate();

                    conn.commit();
                }
                try(PreparedStatement pstmt3 = conn.prepareStatement("UPDATE entrevistadores SET disponibilidad='si' WHERE id=?;")){
                    conn.setAutoCommit(false);
                    pstmt3.setInt(1, id_ne);
                    pstmt3.executeUpdate();

                    conn.commit();
                }

            }catch(SQLException ex){
                ex.printStackTrace();
            }

            System.out.println("SE ACTUALIZÓ EL ENTREVISTADOR");
            System.out.print("(PRESIONE ENTER para continuar)");
            String cach = sc.nextLine();
            
        }else{
            System.out.println("NO HAY ENTREVISTADORES LIBRES");
            System.out.print("(PRESIONE ENTER para continuar)");
            String cach = sc.nextLine();
        }

        lista_etrvtwo.clear();
    }
}
