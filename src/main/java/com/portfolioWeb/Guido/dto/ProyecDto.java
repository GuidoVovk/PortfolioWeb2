
package com.portfolioWeb.Guido.dto;

import javax.validation.constraints.NotBlank;


public class ProyecDto {
    
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descProyecto;
    private String imgProyecto;
    private String enlaceProyecto;

    public ProyecDto() {
    }

    public ProyecDto(String nombreProyecto, String descProyecto, String imgProyecto, String enlaceProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descProyecto = descProyecto;
        this.imgProyecto = imgProyecto;
        this.enlaceProyecto = enlaceProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescProyecto() {
        return descProyecto;
    }

    public void setDescProyecto(String descProyecto) {
        this.descProyecto = descProyecto;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

    public String getEnlaceProyecto() {
        return enlaceProyecto;
    }

    public void setEnlaceProyecto(String enlaceProyecto) {
        this.enlaceProyecto = enlaceProyecto;
    }
    
    
}
