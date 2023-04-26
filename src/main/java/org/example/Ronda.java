package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private List<Partido> partidos;

    public Ronda() {
        partidos = new ArrayList<>();
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}