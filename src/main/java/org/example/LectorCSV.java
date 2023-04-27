package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

                String participante = pronosticoFields[1];
                // Resto del código para procesar los pronósticos
                // ...

                System.out.println("Participante = " + participante);

                if(pronosticoFields[3].equals("X")) {
                    System.out.println("Gana Equipo 1" + "\n---------------");

                } else if(pronosticoFields[4].equals("X")) {
                    System.out.println("Empate" + "\n---------------");

                } else {
                    System.out.println("Gana Equipo 2" + "\n---------------");

                }

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

                String equipo1 = resultadoFields[3];
                String equipo2 = resultadoFields[8];
                int golesEquipo1 = Integer.parseInt(resultadoFields[5]);
                int golesEquipo2 = Integer.parseInt(resultadoFields[6]);
                // Resto del código para procesar los resultados
                // ...
                System.out.println("Equipo 1: " + equipo1 + ", Equipo 2: " + equipo2 + ", Goles Equipo 1: " + golesEquipo1 + ", Goles Equipo 2: " + golesEquipo2);



            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de resultados: " + e.getMessage());
        }
    }

    public void resultados() {
        Path resultados = Paths.get("src/main/java/org/example/resultados1.csv");
        Path pronostico = Paths.get("src/main/java/org/example/pronostico1.csv");


        String pronosticoString;
        String resultadosString;
        try {
            resultadosString = Files.readString(resultados);
            pronosticoString = Files.readString(pronostico);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
            throw new RuntimeException(e);
        }

        String[] resultadoFields = resultadosString.split("\n");
        String[] pronosticoFields = resultadosString.split("\n");



        /*String equipo1 = resultadoFields[3];
        String equipo2 = resultadoFields[8];
        int golesEquipo1 = Integer.parseInt(resultadoFields[5]);
        int golesEquipo2 = Integer.parseInt(resultadoFields[6]);

        if(golesEquipo1 > golesEquipo2 && pronosticoFields[3].equals("X")) {

        } else if(golesEquipo1 == golesEquipo2 && pronosticoFields[4].equals("X")){

        } else {

        }*/
    }
}