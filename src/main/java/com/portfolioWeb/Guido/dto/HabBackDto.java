
package com.portfolioWeb.Guido.dto;

import javax.validation.constraints.NotBlank;


public class HabBackDto {
    @NotBlank
    private String nombreHabBack;
    @NotBlank
    private String porcentajeHabBack;

    public HabBackDto() {
    }

    public HabBackDto(String nombreHabBack, String porcentajeHabBack) {
        this.nombreHabBack = nombreHabBack;
        this.porcentajeHabBack = porcentajeHabBack;
    }

    public String getNombreHabBack() {
        return nombreHabBack;
    }

    public void setNombreHabBack(String nombreHabBack) {
        this.nombreHabBack = nombreHabBack;
    }

    public String getPorcentajeHabBack() {
        return porcentajeHabBack;
    }

    public void setPorcentajeHabBack(String porcentajeHabBack) {
        this.porcentajeHabBack = porcentajeHabBack;
    }
    
    
}
