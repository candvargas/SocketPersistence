package org.poli.ingsoft.models;

import java.util.Date;

public class Historico {
    private int emphistId;
    private Date emphistFechaRetiro;
    private int emphistCargoId;
    private int emphistDptoId;

    public Historico() {
    }

    public Historico(int emphistId, Date emphistFechaRetiro, int emphistCargoId, int emphistDptoId) {
        this.emphistId = emphistId;
        this.emphistFechaRetiro = emphistFechaRetiro;
        this.emphistCargoId = emphistCargoId;
        this.emphistDptoId = emphistDptoId;
    }

    public int getEmphistId() {
        return emphistId;
    }

    public void setEmphistId(int emphistId) {
        this.emphistId = emphistId;
    }

    public Date getEmphistFechaRetiro() {
        return emphistFechaRetiro;
    }

    public void setEmphistFechaRetiro(Date emphistFechaRetiro) {
        this.emphistFechaRetiro = emphistFechaRetiro;
    }

    public int getEmphistCargoId() {
        return emphistCargoId;
    }

    public void setEmphistCargoId(int emphistCargoId) {
        this.emphistCargoId = emphistCargoId;
    }

    public int getEmphistDptoId() {
        return emphistDptoId;
    }

    public void setEmphistDptoId(int emphistDptoId) {
        this.emphistDptoId = emphistDptoId;
    }
}
