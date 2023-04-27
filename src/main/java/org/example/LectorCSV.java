package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LectorCSV {
    private String pronosticosFile;
    private String resultadosFile;

    public LectorCSV(String pronosticosFile, String resultadosFile) {
        this.pronosticosFile = pronosticosFile;
        this.resultadosFile = resultadosFile;
    }

    public void leerPronosticos() {
        System.out.println("Pronósticos:");
        try {
            List<String> pronosticosLines = Files.readAllLines(Paths.get(pronosticosFile));
            int pronosticosLineCount = 0;
            for (String pronosticoLine : pronosticosLines) {
                if (pronosticosLineCount == 0) {
                    pronosticosLineCount++;
                    continue;
                }
                String[] pronosticoFields = pronosticoLine.split(",");

                String equipo1 = pronosticoFields[0];
                String equipo2 = pronosticoFields[1];
                String resultadoPronostico = pronosticoFields[2];
                // Resto del código para procesar los pronósticos
                // ...
                System.out.println("Equipo 1: " + equipo1 + ", Equipo 2: " + equipo2 + ", Pronóstico: " + resultadoPronostico);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pronósticos: " + e.getMessage());
        }
    }

    public void leerResultados() {
        System.out.println("\nResultados:");
        try {
            List<String> resultadosLines = Files.readAllLines(Paths.get(resultadosFile));
            int resultadosLineCount = 0;
            for (String resultadoLine : resultadosLines) {
                if (resultadosLineCount == 0) {
                    resultadosLineCount++;
                    continue;
                }
                String[] resultadoFields = resultadoLine.split(",");

                String equipo1 = resultadoFields[0];
                String equipo2 = resultadoFields[1];
                int golesEquipo1 = Integer.parseInt(resultadoFields[2]);
                int golesEquipo2 = Integer.parseInt(resultadoFields[3]);
                // Resto del código para procesar los resultados
                // ...
                System.out.println("Equipo 1: " + equipo1 + ", Equipo 2: " + equipo2 + ", Goles Equipo 1: " + golesEquipo1 + ", Goles Equipo 2: " + golesEquipo2);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de resultados: " + e.getMessage());
        }
    }

    public void compararResultados() {
        if (Pronostico.getEquipo1().getNombre().equals(Partido.getEquipo1().getNombre()) &&
                Pronostico.getEquipo2().getNombre().equals(Partido.getEquipo2().getNombre()) &&
                Pronostico.getPronosticoResultado() == Partido.getResultado()) {
            Pronostico.setPuntos(Pronostico.getPuntos() + 1);
        }
        System.out.println("Pronóstico para el partido " + pronostico.getEquipo1().getNombre() + " vs " + pronostico.getEquipo2().getNombre() + ": " + pronostico.getPronosticoResultado().toString() + ", Puntos: " + pronostico.getPuntos());
    }

}