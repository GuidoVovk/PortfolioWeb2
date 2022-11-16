
package com.portfolioWeb.Guido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadesSoft {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHabSoft;
    private String porcentajeHabSoft;

    public HabilidadesSoft() {
    }

    public HabilidadesSoft(String nombreHabSoft, String porcentajeHabSoft) {
        this.nombreHabSoft = nombreHabSoft;
        this.porcentajeHabSoft = porcentajeHabSoft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
