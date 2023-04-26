package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pronosticosFile = "Proyecto\\src\\pronostico.csv"; // Ruta del archivo CSV de pronósticos
        String resultadosFile = "Proyecto\\src\\resultados.csv"; // Ruta del archivo CSV de resultados

        // Crear una instancia de la clase LectorCSV
        LectorCSV lectorCSV = new LectorCSV(pronosticosFile, resultadosFile);

        // Leer los pronósticos
        lectorCSV.leerPronosticos();

        // Leer los resultados
        lectorCSV.leerResultados();

    }
}