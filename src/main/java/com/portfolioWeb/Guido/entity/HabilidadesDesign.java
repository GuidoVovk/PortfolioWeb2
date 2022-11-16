
package com.portfolioWeb.Guido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabilidadesDesign {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHabDesign;
    private String porcentajeHabDesign;

    public HabilidadesDesign() {
    }

    public HabilidadesDesign(String nombreHabDesign, String porcentajeHabDesign) {
        this.nombreHabDesign = nombreHabDesign;
        this.porcentajeHabDesign = porcentajeHabDesign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
