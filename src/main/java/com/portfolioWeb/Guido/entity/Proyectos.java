
package com.portfolioWeb.Guido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProyecto;
    private String descProyecto;
    private String imgProyecto;
    private String enlaceProyecto;

    public Proyectos() {
    }

    public Proyectos(String nombreProyecto, String descProyecto, String imgProyecto, String enlaceProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descProyecto = descProyecto;
        this.imgProyecto = imgProyecto;
        this.enlaceProyecto = enlaceProyecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
