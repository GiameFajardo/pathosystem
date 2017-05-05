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
public class PatologoDTO {
    
    private int idpatologo;
    private String nombre;
    private String apellido;
    private boolean isBorrado;
    private boolean isActivo;

    /**
     * @return the id
     */
    public int getIdpatologo() {
        return idpatologo;
    }

    /**
     * @param id the id to set
     */
    public void setIdpatologo(int id) {
        this.idpatologo = id;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the isBorrado
     */
    public boolean IsBorrado() {
        return isBorrado;
    }

    /**
     * @param isBorrado the isBorrado to set
     */
    public void setIsBorrado(boolean isBorrado) {
        this.isBorrado = isBorrado;
    }

    /**
     * @return the isActivo
     */
    public boolean IsActivo() {
        return isActivo;
    }

    /**
     * @param isActivo the isActivo to set
     */
    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }
    
}
