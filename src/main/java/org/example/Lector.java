package org.example;

import java.util.ArrayList;

public class Lector {
    public Lector(String[] resultadoDFila, String[] pronosticoDFila) {
        this.resultadoDFila = resultadoDFila;
        this.pronosticoDFila = pronosticoDFila;
    }

    private String[] resultadoDFila;
    private String[] pronosticoDFila;

    public void Funcion() {

        ArrayList<Participante> participantes = new ArrayList<>();
        int idNombre = 0;

        //separamos las filas en columnas
        for (int i = 1; i < pronosticoDFila.length; i++) {

            String[] pronosticoColumn = pronosticoDFila[i].split(",");

            //creamos array de participante
            if(idNombre != Integer.parseInt(pronosticoColumn[4])) {
                Participante nuevoParticipante = new Participante(Integer.parseInt(pronosticoColumn[4]), pronosticoColumn[1]);
                participantes.add(nuevoParticipante);
                idNombre++;
            }

            //intentamos hacer la comparacion de datos
            int aciertos = 0;
            for(int j=1; j < resultadoDFila.length; j++) {
                String[] resultadoColumn = resultadoDFila[j].split(",");

                //no funca
                if(pronosticoColumn[0].equals(resultadoColumn[0])) {
                    System.out.println(pronosticoColumn[1]);
                    aciertos++;
                }
            }

        }

    }
}
