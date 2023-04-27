package org.example;

public class Partido {

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

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    private String resultado;

    public Partido(String equipo1, String equipo2, int golesEquipo1, int golesEquipo2, String resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.resultado= resultado;

    }
    private resultadoEnum resultadoPartido;
    private resultadoEnum resultado1;

    public resultadoEnum getResultado1() {
        return this.resultado1;
    }
    public void setResultado(resultadoEnum resultadoPartido) {
        this.resultadoPartido = resultadoPartido;
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