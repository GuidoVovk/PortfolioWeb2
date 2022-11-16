
package com.portfolioWeb.Guido.dto;

import javax.validation.constraints.NotBlank;


public class ExpDto {
    
    @NotBlank
    private String nombreExp;
    private String nombreEmpresa;
    @NotBlank
    private String fechaExp;
    @NotBlank
    private String descripcionExp;

    public ExpDto() {
    }

    public ExpDto(String nombreExp, String nombreEmpresa, String fechaExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
    
    
}
