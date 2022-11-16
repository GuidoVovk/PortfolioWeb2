
package com.portfolioWeb.Guido.dto;

import javax.validation.constraints.NotBlank;


public class HabSoftDto {
    @NotBlank
    private String nombreHabSoft;
    @NotBlank
    private String porcentajeHabSoft;

    public HabSoftDto() {
    }

    public HabSoftDto(String nombreHabSoft, String porcentajeHabSoft) {
        this.nombreHabSoft = nombreHabSoft;
        this.porcentajeHabSoft = porcentajeHabSoft;
    }

    public String getNombreHabSoft() {
        return nombreHabSoft;
    }

    public void setNombreHabSoft(String nombreHabSoft) {
        this.nombreHabSoft = nombreHabSoft;
    }

    public String getPorcentajeHabSoft() {
        return porcentajeHabSoft;
    }

    public void setPorcentajeHabSoft(String porcentajeHabSoft) {
        this.porcentajeHabSoft = porcentajeHabSoft;
    }
    
    
}
