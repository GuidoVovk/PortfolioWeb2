
package com.portfolioWeb.Guido.dto;

import javax.validation.constraints.NotBlank;

public class HabDto {
    @NotBlank
    private String nombreHab;
    @NotBlank
    private String porcentajeHab;

    public HabDto() {
    }

    public HabDto(String nombreHab, String porcentajeHab) {
        this.nombreHab = nombreHab;
        this.porcentajeHab = porcentajeHab;
    }

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public String getPorcentajeHab() {
        return porcentajeHab;
    }

    public void setPorcentajeHab(String porcentajeHab) {
        this.porcentajeHab = porcentajeHab;
    }
    
    
}
