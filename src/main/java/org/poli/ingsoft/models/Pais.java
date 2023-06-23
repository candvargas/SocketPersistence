package org.poli.ingsoft.models;

public class Pais {
    private int paisId;
    private String paisNombre;

    public Pais() {
    }

    public Pais(int paisId, String paisNombre) {
        this.paisId = paisId;
        this.paisNombre = paisNombre;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }
}
