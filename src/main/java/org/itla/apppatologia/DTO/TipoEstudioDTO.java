/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.DTO;

/**
 *
 * @author sony
 */
public class TipoEstudioDTO {
    
    private int id;
    private String nombre;
    private String accionTipoEstudio;
    private float precio;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the accionTipoEstudio
     */
    public String getAccionTipoEstudio() {
        return accionTipoEstudio;
    }

    /**
     * @param accionTipoEstudio the accionTipoEstudio to set
     */
    public void setAccionTipoEstudio(String accionTipoEstudio) {
        this.accionTipoEstudio = accionTipoEstudio;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
