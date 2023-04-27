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
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(delimitador);
                Pronostico pronostico = new Pronostico(columnas[1], columnas[2], columnas[6], columnas[4]);
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
                    System.out.println("El equipo ganador es: " + columnas[3]);
                } else if (resultadoPartido == resultadoEnum.GANADOR_EQUIPO2) {
                    System.out.println("El equipo ganador es: " + columnas[8]);
                } else {
                    System.out.println("El partido terminó en empate.");
                }
                resultados.add(resultado);
            }
        }

        return resultados;
    }
}
