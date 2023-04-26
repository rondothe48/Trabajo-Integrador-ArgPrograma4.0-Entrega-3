package org.example;
public class Pronostico {
    private Equipo equipo1;
    private Equipo equipo2;
    private resultadoPartido pronosticoResultado;

    public Pronostico(Equipo equipo1, Equipo equipo2, resultadoPartido pronosticoResultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.pronosticoResultado = pronosticoResultado;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public resultadoPartido getPronosticoResultado() {
        return pronosticoResultado;
    }
}
