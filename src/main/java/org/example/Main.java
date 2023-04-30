package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argpro", "root", "332211");
            Statement stmt = con.createStatement();

            ResultSet rs=stmt.executeQuery("SELECT * FROM pronostico");
            while(rs.next()) System.out.println(rs.getInt(1));

            
            stmt.close();
        } catch(Exception e) {
            System.out.println(e);
        }




        System.out.println("\n---------------- RESULTADOS ----------------");

        LectorCSV lector = new LectorCSV("src/main/java/org/example/resultados1.csv");
        List<Partido> resultados = lector.leerPartidos();
        /*for (Partido r : resultados) {
            System.out.println(r.getEquipo1() + " vs " + r.getEquipo2() + " - Goles del equipo 1: " + r.getGolesEquipo1() + " - Goles del equipo 2: " + r.getGolesEquipo2() );
        }*/

        System.out.println("\n---------------- PRONOSTICO MARIANA ----------------");

        LectorCSV lector2 = new LectorCSV("src/main/java/org/example/pronostico1.csv");
        List<Pronostico> pronostico2 = lector2.leerPronosticos();
        lector2.compararDatos(resultados, pronostico2);
        /*for (Pronostico p : pronostico) {
            System.out.println("Los puntajes son:");
        }*/
        System.out.println("\n---------------- PRONOSTICO PEDRO ----------------");

        LectorCSV lector3 = new LectorCSV("src/main/java/org/example/pronostico.csv");
        List<Pronostico> pronostico = lector3.leerPronosticos();
        lector3.compararDatos(resultados, pronostico);


    }
}