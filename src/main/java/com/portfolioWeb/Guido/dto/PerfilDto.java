
package com.portfolioWeb.Guido.dto;

import javax.validation.constraints.NotBlank;


public class PerfilDto {
    
    @NotBlank
    private String nombrePerfil;
    @NotBlank
    private String nombrePuesto;
    @NotBlank
    private String descPerfil;
    private String imgPerfil;

    public PerfilDto() {
    }

    public PerfilDto(String nombrePerfil, String nombrePuesto, String descPerfil, String imgPerfil) {
        this.nombrePerfil = nombrePerfil;
        this.nombrePuesto = nombrePuesto;
        this.descPerfil = descPerfil;
        this.imgPerfil = imgPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }
    
    
}
