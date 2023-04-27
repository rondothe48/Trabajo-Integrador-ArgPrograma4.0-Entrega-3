package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {
    private final String archivo;

    public LectorCSV(String archivo) {
        this.archivo = archivo;
    }

    public List<Partido> leerPartidos() throws IOException {
        List<Partido> partidos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length != 5) {
                    throw new IllegalArgumentException("El archivo CSV de partidos debe tener 5 columnas.");
                }
                String equipo1 = datos[1].trim();
                String equipo2 = datos[4].trim();
                int golesequipo1 = Integer.parseInt(datos[2].trim());
                int golesequipo2 = Integer.parseInt(datos[3].trim());
                String resultado = datos[0].trim();
                partidos.add(new Partido(equipo1, equipo2, golesequipo1, golesequipo2, resultado));

                if (resultado.equals(String.valueOf(resultadoEnum.E1))) {
                    System.out.println("El partido " + datos[1] + " vs " + datos[4] + " tuvo como resultado: " + "Ganador " + datos[4]);
                } else if (resultado.equals(String.valueOf(resultadoEnum.E2))) {
                    System.out.println("El partido " + datos[1] + " vs " + datos[4] + " tuvo como resultado: " + "Ganador " + datos[1]);
                } else if (resultado.equals(String.valueOf(resultadoEnum.E0))) {
                    System.out.println("El partido " + datos[1] + " vs " + datos[4] + " tuvo como resultado: " + "Empate");
                }
            }
        }

        return partidos;
    }

    public List<Pronostico> leerPronosticos() throws IOException {
        List<Pronostico> pronosticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length != 4) {
                    throw new IllegalArgumentException("El archivo CSV de pronósticos debe tener 4 columnas.");
                }
                String participante = datos[1].trim();
                String equipo1 = datos[2].trim();
                String equipo2 = datos[3].trim();
                String pronostico = datos[0].trim();

                pronosticos.add(new Pronostico(participante, equipo1, equipo2, pronostico));

                if (pronostico.equals(String.valueOf(resultadoEnum.E1))) {
                    System.out.println(datos[1] + ":" + "El partido " + datos[2] + " vs " + datos[3] + " tendría como resultado: " + "Ganador " + datos[2]);
                } else if (pronostico.equals(String.valueOf(resultadoEnum.E2))) {
                    System.out.println(datos[1] + ":" + "El partido " + datos[2] + " vs " + datos[3] + " tendría como resultado: " + "Ganador " + datos[3]);
                } else if (pronostico.equals(String.valueOf(resultadoEnum.E0))) {
                    System.out.println(datos[1] + ":" + "El partido " + datos[2] + " vs " + datos[3] + " tendría como resultado: " + "Empate");
                }
            }
        }

        return pronosticos;
    }

    public void compararDatos(List<Partido> partidos, List<Pronostico> pronosticos) {
        int aciertos = 0;
        int total = Math.min(partidos.size(), pronosticos.size());
        for (int i = 0; i < total; i++) {
            Partido partido = partidos.get(i);
            Pronostico pronostico = pronosticos.get(i);
            if (partido.getEquipo1().equals(pronostico.getEquipo1()) &&
                    partido.getEquipo2().equals(pronostico.getEquipo2()) &&
                    partido.getResultado().equals(pronostico.getPronostico())) {
                aciertos++;
            }
        }
        System.out.println("Aciertos: " + aciertos + " de " + total);
    }


}



