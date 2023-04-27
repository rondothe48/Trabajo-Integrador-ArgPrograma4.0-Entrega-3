package org.example;

public class Partido {

    private resultadoEnum resultadoPartido;

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

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }


    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(String equipo1, String equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;

    }
    public void setResultado(resultadoEnum resultadoPartido) {
        this.resultadoPartido = resultadoPartido;
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