package org.poli.ingsoft.models;

public class Cargo {
    private int cargoId;
    private String cargoNombre;
    private int cargoSueldoMinimo;
    private int cargoSueldoMaximo;

    public Cargo() {
    }

    public Cargo(int cargoId, String cargoNombre, int cargoSueldoMinimo, int cargoSueldoMaximo) {
        this.cargoId = cargoId;
        this.cargoNombre = cargoNombre;
        this.cargoSueldoMinimo = cargoSueldoMinimo;
        this.cargoSueldoMaximo = cargoSueldoMaximo;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoNombre() {
        return cargoNombre;
    }

    public void setCargoNombre(String cargoNombre) {
        this.cargoNombre = cargoNombre;
    }

    public int getCargoSueldoMinimo() {
        return cargoSueldoMinimo;
    }

    public void setCargoSueldoMinimo(int cargoSueldoMinimo) {
        this.cargoSueldoMinimo = cargoSueldoMinimo;
    }

    public int getCargoSueldoMaximo() {
        return cargoSueldoMaximo;
    }

    public void setCargoSueldoMaximo(int cargoSueldoMaximo) {
        this.cargoSueldoMaximo = cargoSueldoMaximo;
    }
}
