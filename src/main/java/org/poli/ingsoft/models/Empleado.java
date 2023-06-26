package org.poli.ingsoft.models;

import java.util.Date;

public class Empleado {
    private long emplId;
    private String emplPrimerNombre;
    private String emplSegundoNombre;
    private String emplEmail;
    private Date emplFechaNac;
    private int emplSueldo;
    private int emplComision;
    private int emplCargoId;
    private int emplGerenteId;
    private int emplDptoId;

    private boolean emplActivo;

    public Empleado() {
    }

    public Empleado(long emplId, String emplPrimerNombre, String emplSegundoNombre, String emplEmail,
                    Date emplFechaNac, int emplSueldo, int emplComision, int emplCargoId, int emplGerenteId,
                    int emplDptoId, boolean emplActivo) {
        this.emplId = emplId;
        this.emplPrimerNombre = emplPrimerNombre;
        this.emplSegundoNombre = emplSegundoNombre;
        this.emplEmail = emplEmail;
        this.emplFechaNac = emplFechaNac;
        this.emplSueldo = emplSueldo;
        this.emplComision = emplComision;
        this.emplCargoId = emplCargoId;
        this.emplGerenteId = emplGerenteId;
        this.emplDptoId = emplDptoId;
        this.emplActivo = emplActivo;
    }

    public long getEmplId() {
        return emplId;
    }

    public void setEmplId(long emplId) {
        this.emplId = emplId;
    }

    public String getEmplPrimerNombre() {
        return emplPrimerNombre;
    }

    public void setEmplPrimerNombre(String emplPrimerNombre) {
        this.emplPrimerNombre = emplPrimerNombre;
    }

    public String getEmplSegundoNombre() {
        return emplSegundoNombre;
    }

    public void setEmplSegundoNombre(String emplSegundoNombre) {
        this.emplSegundoNombre = emplSegundoNombre;
    }

    public String getEmplEmail() {
        return emplEmail;
    }

    public void setEmplEmail(String emplEmail) {
        this.emplEmail = emplEmail;
    }

    public Date getEmplFechaNac() {
        return emplFechaNac;
    }

    public void setEmplFechaNac(Date emplFechaNac) {
        this.emplFechaNac = emplFechaNac;
    }

    public int getEmplSueldo() {
        return emplSueldo;
    }

    public void setEmplSueldo(int emplSueldo) {
        this.emplSueldo = emplSueldo;
    }

    public int getEmplComision() {
        return emplComision;
    }

    public void setEmplComision(int emplComision) {
        this.emplComision = emplComision;
    }

    public int getEmplCargoId() {
        return emplCargoId;
    }

    public void setEmplCargoId(int emplCargoId) {
        this.emplCargoId = emplCargoId;
    }

    public int getEmplGerenteId() {
        return emplGerenteId;
    }

    public void setEmplGerenteId(int emplGerenteId) {
        this.emplGerenteId = emplGerenteId;
    }

    public int getEmplDptoId() {
        return emplDptoId;
    }

    public void setEmplDptoId(int emplDptoId) {
        this.emplDptoId = emplDptoId;
    }

    public boolean isEmplActivo() {
        return emplActivo;
    }

    public void setEmplActivo(boolean emplActivo) {
        this.emplActivo = emplActivo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "emplId=" + emplId +
                ", emplPrimerNombre='" + emplPrimerNombre + '\'' +
                ", emplSegundoNombre='" + emplSegundoNombre + '\'' +
                ", emplEmail='" + emplEmail + '\'' +
                ", emplFechaNac=" + emplFechaNac +
                ", emplSueldo=" + emplSueldo +
                ", emplComision=" + emplComision +
                ", emplCargoId=" + emplCargoId +
                ", emplGerenteId=" + emplGerenteId +
                ", emplDptoId=" + emplDptoId +
                ", emplActivo=" + emplActivo +
                '}';
    }
}
