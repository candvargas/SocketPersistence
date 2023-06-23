package org.poli.ingsoft.models;

public class Ciudad {
    private int ciudId;
    private int ciudPaisId;
    private String ciudNombre;

    public Ciudad() {
    }

    public Ciudad(int ciudId, int ciudPaisId, String ciudNombre) {
        this.ciudId = ciudId;
        this.ciudPaisId = ciudPaisId;
        this.ciudNombre = ciudNombre;
    }

    public int getCiudId() {
        return ciudId;
    }

    public void setCiudId(int ciudId) {
        this.ciudId = ciudId;
    }

    public int getCiudPaisId() {
        return ciudPaisId;
    }

    public void setCiudPaisId(int ciudPaisId) {
        this.ciudPaisId = ciudPaisId;
    }

    public String getCiudNombre() {
        return ciudNombre;
    }

    public void setCiudNombre(String ciudNombre) {
        this.ciudNombre = ciudNombre;
    }
}
