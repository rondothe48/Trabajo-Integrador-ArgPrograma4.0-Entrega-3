package org.example;

public class Participante {
    public Participante(int idNombre, String name) {
       nombre = name;
    }
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
