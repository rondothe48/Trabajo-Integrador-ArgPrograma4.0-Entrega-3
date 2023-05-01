package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDeDatos {

    private String[] resultadoDFila;
    private String[] pronosticoDFila;
     BaseDeDatos() {
         StringBuilder resultadoString = new StringBuilder();
         StringBuilder pronosticoString = new StringBuilder();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argpro", "root", "332211");
            Statement stmtPronostico = con.createStatement();

            ResultSet rsPronostico = stmtPronostico.executeQuery("SELECT * FROM pronostico");
            while(rsPronostico.next()) {
                pronosticoString.append(rsPronostico.getString("ENUM")).append(",")
                        .append(rsPronostico.getString("Participante - nombre")).append(",")
                        .append(rsPronostico.getString("Equipo 1 - Nombre")).append(",")
                        .append(rsPronostico.getString("Equipo 2 - Nombre")).append(",")
                        .append(rsPronostico.getString("idNombre")).append("\n");
            }

            Statement stmtResultado = con.createStatement();

            ResultSet rsResultado = stmtResultado.executeQuery("SELECT * FROM resultado");
            while(rsResultado.next()) {
                resultadoString.append(rsResultado.getString("enum")).append(",")
                        .append(rsResultado.getString("Equipo 1 - nombre")).append(",")
                        .append(rsResultado.getString("Equipo 1 - cantidad goles")).append(",")
                        .append(rsResultado.getString("Equipo 2 - cantidad goles")).append(",")
                        .append(rsResultado.getString("equipo 2 - nombre")).append("\n");
            }

            con.close();

        } catch(Exception e) {System.out.println(e.getMessage());}

        resultadoDFila = resultadoString.toString().split("\n");
        pronosticoDFila = pronosticoString.toString().split("\n");

    }
    public String[] getResultadoDFila() {
         return resultadoDFila;
    }
    public String[] getPronosticoDFila() {
         return pronosticoDFila;
    }
}
