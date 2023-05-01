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

        for (int i = 1; i < pronosticoDFila.length; i++) {

            String[] pronosticoColumn = pronosticoDFila[i].split(",");

            if(idNombre != Integer.parseInt(pronosticoColumn[4])) {
                Participante nuevoParticipante = new Participante(Integer.parseInt(pronosticoColumn[4]), pronosticoColumn[1]);
                participantes.add(nuevoParticipante);
                idNombre++;
            }
            
        }

    }
}
