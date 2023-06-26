package org.poli.ingsoft.models;

/**
 * DTO entity Departamento
 */
public class Departamento {
    private int dptoId;
    private String deptoNombre;

    public Departamento() {
    }

    public Departamento(int dptoId, String deptoNombre) {
        this.dptoId = dptoId;
        this.deptoNombre = deptoNombre;
    }

    public int getDptoId() {
        return dptoId;
    }

    public void setDptoId(int dptoId) {
        this.dptoId = dptoId;
    }

    public String getDeptoNombre() {
        return deptoNombre;
    }

    public void setDeptoNombre(String deptoNombre) {
        this.deptoNombre = deptoNombre;
    }
}
