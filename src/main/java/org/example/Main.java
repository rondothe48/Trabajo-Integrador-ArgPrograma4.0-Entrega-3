package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argpro", "root", "332211");
            Statement statement = con.createStatement();
            statement.execute("SELECT * FROM pronostico");
        } catch(Exception e) {
            System.out.println(e);
        }
        String pronosticosFile = "src/main/java/org/example/pronostico1.csv"; // Ruta del archivo CSV de pronósticos
        String resultadosFile = "src/main/java/org/example/resultados1.csv"; // Ruta del archivo CSV de resultados

        // Crear una instancia de la clase LectorCSV
        LectorCSV lectorCSV = new LectorCSV(pronosticosFile, resultadosFile);

        // Leer los pronósticos
        lectorCSV.leerPronosticos();

        // Leer los resultados
        lectorCSV.leerResultados();



        List<Partido> listaDePartidos = new ArrayList<>();
        List<Equipo> listaDeEquipos = new ArrayList<>();
        Equipo argentina = new Equipo("Argentina");
        Equipo brazil = new Equipo("Brazil");
        Equipo panama = new Equipo("panama");
        Equipo trinidadytobago = new Equipo("Trinidad y Tobago");

        Partido partido = new Partido(argentina, brazil, 1, 2);
        listaDePartidos.add(partido);

    }
}