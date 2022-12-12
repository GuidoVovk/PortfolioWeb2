
package com.portfolioWeb.Guido.dto;



import javax.validation.constraints.NotBlank;

public class EduDto {
    
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String fechaEdu;

    public EduDto() {
    }

    public EduDto(String nombreEdu, String tituloEdu, String descripcionEdu, String fechaEdu) {
        this.nombreEdu = nombreEdu;
        this.tituloEdu = tituloEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }
    
    
}
