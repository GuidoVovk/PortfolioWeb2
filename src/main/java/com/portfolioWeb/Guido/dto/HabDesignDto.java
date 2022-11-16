
package com.portfolioWeb.Guido.dto;

import javax.validation.constraints.NotBlank;


public class HabDesignDto {
    @NotBlank
    private String nombreHabDesign;
    @NotBlank
    private String porcentajeHabDesign;

    public HabDesignDto() {
    }

    public HabDesignDto(String nombreHabDesign, String porcentajeHabDesign) {
        this.nombreHabDesign = nombreHabDesign;
        this.porcentajeHabDesign = porcentajeHabDesign;
    }

    public String getNombreHabDesign() {
        return nombreHabDesign;
    }

    public void setNombreHabDesign(String nombreHabDesign) {
        this.nombreHabDesign = nombreHabDesign;
    }

    public String getPorcentajeHabDesign() {
        return porcentajeHabDesign;
    }

    public void setPorcentajeHabDesign(String porcentajeHabDesign) {
        this.porcentajeHabDesign = porcentajeHabDesign;
    }
    
    
}
