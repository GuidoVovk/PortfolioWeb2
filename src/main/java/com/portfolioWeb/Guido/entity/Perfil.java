
package com.portfolioWeb.Guido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePerfil;
    private String nombrePuesto;
    private String descPerfil;
    private String imgPerfil;

    public Perfil() {
    }

    public Perfil(String nombrePerfil, String nombrePuesto, String descPerfil, String imgPerfil) {
        this.nombrePerfil = nombrePerfil;
        this.nombrePuesto = nombrePuesto;
        this.descPerfil = descPerfil;
        this.imgPerfil = imgPerfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
