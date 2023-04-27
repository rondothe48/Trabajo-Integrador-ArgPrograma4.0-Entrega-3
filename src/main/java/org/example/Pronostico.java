package org.example;

import com.mysql.cj.protocol.x.XProtocolRow;

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

    public Pronostico(String participante, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2) {
        this.participante = participante;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }


    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }
    private resultadoEnum pronosticoPartido;
    private resultadoEnum pronostico;

    public resultadoEnum getPronostico() {
        return this.pronostico;
    }
    public void setPronostico(resultadoEnum pronosticoPartido) {
        this.pronosticoPartido = pronosticoPartido;
    }

    public resultadoEnum determinarResultado() {
        if (golesEquipo1 > golesEquipo2) {
            return resultadoEnum.GANADOR_EQUIPO1;
        } else if (golesEquipo1 < golesEquipo2) {
            return resultadoEnum.GANADOR_EQUIPO2;
        } else {
            return resultadoEnum.EMPATE;
        }
    }

}
