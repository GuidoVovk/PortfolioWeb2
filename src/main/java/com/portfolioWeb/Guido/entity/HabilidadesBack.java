
package com.portfolioWeb.Guido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadesBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHabBack;
    private String porcentajeHabBack;

    public HabilidadesBack() {
    }

    public HabilidadesBack(String nombreHabBack, String porcentajeHabBack) {
        this.nombreHabBack = nombreHabBack;
        this.porcentajeHabBack = porcentajeHabBack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
