package org.example;

public class Pronostico {

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }


    private String participante;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    public String getPronostico() {
        return pronostico;
    }

    private String pronostico;

    public Pronostico(String participante, String equipo1, String equipo2, String pronostico) {
        this.participante = participante;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.pronostico=pronostico;
    }


    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }
    private resultadoEnum pronosticoPartido;
    private resultadoEnum pronostico1;

    public resultadoEnum getPronostico1() {
        return this.pronostico1;
    }
    public void setPronostico(resultadoEnum pronosticoPartido) {
        this.pronosticoPartido = pronosticoPartido;
    }

    public resultadoEnum determinarResultado() {
        if (golesEquipo1 > golesEquipo2) {
            return resultadoEnum.E1;
        } else if (golesEquipo1 < golesEquipo2) {
            return resultadoEnum.E2;
        } else {
            return resultadoEnum.E0;
        }
    }

}
