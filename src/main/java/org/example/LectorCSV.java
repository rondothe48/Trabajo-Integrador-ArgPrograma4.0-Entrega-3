package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {
    private static String archivoCsv;
    private static String delimitador;

    public LectorCSV(String archivoCsv, String delimitador) {
        LectorCSV.archivoCsv = archivoCsv;
        LectorCSV.delimitador = delimitador;
    }

    public static List<Pronostico> leerPronosticos() throws IOException {
        List<Pronostico> pronosticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            int puntos= 0;
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(delimitador);
                Pronostico pronostico = new Pronostico(columnas[1], columnas[2], columnas[6], columnas[4]);

                if (columnas[3].equalsIgnoreCase("X")) {
                    System.out.println(columnas[1] + " predijo que "  + columnas[2] + " vs " + columnas[6] + " tendría como resultado: "  + "Ganador " + columnas[2]);
                } else if (columnas[5].equalsIgnoreCase("X")) {
                    System.out.println(columnas[1] + " predijo que "  + columnas[2] + " vs " + columnas[6] + " tendría como resultado: "  + "Ganador " + columnas[6]);
                } else {
                    System.out.println(columnas[1] + " predijo que "  + columnas[2] + " vs " + columnas[6] + " tendría como resultado: Empate");
                }

                pronosticos.add(pronostico);
            }
        }

        return pronosticos;
    }
    public List<Partido> leerResultados() throws IOException {
        List<Partido> resultados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(delimitador);
                Partido resultado = new Partido(columnas[3], columnas[8], Integer.parseInt(columnas[5]), Integer.parseInt(columnas[6]));
                resultado.setResultado(resultado.determinarResultado());
                resultadoEnum resultadoPartido = resultado.determinarResultado();

                if (resultadoPartido == resultadoEnum.GANADOR_EQUIPO1) {
                    System.out.println("El partido " + columnas[3] + " vs " + columnas[8] + " tuvo como resultado: " + "Ganador " + columnas[3]);
                } else if (resultadoPartido == resultadoEnum.GANADOR_EQUIPO2) {
                    System.out.println("El partido " + columnas[3] + " vs " + columnas[8] + " tuvo como resultado: " + "Ganador " + columnas[8]);
                } else {
                    System.out.println("El partido " + columnas[3] + " vs " + columnas[8] + " tuvo como resultado: Empate");
                }
                resultados.add(resultado);
            }
        }

        return resultados;
    }
}
