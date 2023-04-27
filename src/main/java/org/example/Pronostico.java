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

    public String getResultadoPronostico() {
        return resultadoPronostico;
    }

    public void setResultadoPronostico(String resultadoPronostico) {
        this.resultadoPronostico = resultadoPronostico;
    }

    private String participante;
    private String equipo1;
    private String equipo2;
    private String resultadoPronostico;

    public Pronostico(String participante, String equipo1, String equipo2, String resultadoPronostico) {
        this.participante = participante;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultadoPronostico = resultadoPronostico;
    }


    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }
}
