package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorCSV {
    private static String archivoCsv;
    private static String delimitador;

    public LectorCSV(String archivoCsv, String delimitador) {
        LectorCSV.archivoCsv = archivoCsv;
        LectorCSV.delimitador = delimitador;
    }

    public static List<Pronostico> getPronostico() throws IOException {
        List<Pronostico> pronosticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            int puntos= 0;
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(delimitador);
                Pronostico pronostico = new Pronostico(columnas[1], columnas[2], columnas[5], Integer.parseInt(columnas[3]), Integer.parseInt(columnas[4]));

                pronostico.setPronostico(pronostico.determinarResultado());
                resultadoEnum pronosticoPartido = pronostico.determinarResultado();

                if (pronosticoPartido == resultadoEnum.GANADOR_EQUIPO1) {
                    System.out.println(columnas[1] + " predijo que el partido " + columnas[2] + " vs " + columnas[5] + " tendría como resultado: " + "Ganador " + columnas[2]);
                } else if (pronosticoPartido == resultadoEnum.GANADOR_EQUIPO2) {
                    System.out.println(columnas[1] + " predijo que el partido " + columnas[2] + " vs " + columnas[5] + " tendría como resultado: " + "Ganador " + columnas[5]);
                } else if (pronosticoPartido == resultadoEnum.EMPATE) {
                    System.out.println(columnas[1] + " predijo que el partido " + columnas[2] + " vs " + columnas[5] + " tendría como resultado: Empate");
                }

                pronosticos.add(pronostico);
            }
        }

        return pronosticos;
    }

    public List<Partido> getResultado() throws IOException {
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
                } else if (resultadoPartido == resultadoEnum.EMPATE) {
                    System.out.println("El partido " + columnas[3] + " vs " + columnas[8] + " tuvo como resultado: Empate");
                }
                resultados.add(resultado);

            }
        }

        return resultados;

    }

    public void compararDatos(List<Partido> resultados, List<Pronostico> pronosticos) {
        for (Pronostico pronostico : pronosticos) {
            int puntos = 0;
            for (Partido resultado : resultados) {
                if (resultado.getResultado() == pronostico.getPronostico()){
                    puntos++;
                }
            }
            System.out.println("El pronóstico de " + pronostico.getParticipante() + " para el partido " +
                    pronostico.getEquipo1() + " vs " + pronostico.getEquipo2() + " tiene " + puntos + " puntos.");
        }
    }
}


