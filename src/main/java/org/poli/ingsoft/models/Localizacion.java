package org.poli.ingsoft.models;

public class Localizacion {
    private int localizId;
    private int localizCiudadId;
    private String localizDireccion;

    public Localizacion() {
    }

    public Localizacion(int localizId, int localizCiudadId, String localizDireccion) {
        this.localizId = localizId;
        this.localizCiudadId = localizCiudadId;
        this.localizDireccion = localizDireccion;
    }

    public int getLocalizId() {
        return localizId;
    }

    public void setLocalizId(int localizId) {
        this.localizId = localizId;
    }

    public int getLocalizCiudadId() {
        return localizCiudadId;
    }

    public void setLocalizCiudadId(int localizCiudadId) {
        this.localizCiudadId = localizCiudadId;
    }

    public String getLocalizDireccion() {
        return localizDireccion;
    }

    public void setLocalizDireccion(String localizDireccion) {
        this.localizDireccion = localizDireccion;
    }
}
