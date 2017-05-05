/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.DTO;

import java.util.Date;

/**
 *
 * @author Giame
 */
public class EstudioDTO {

    /**
     * @return the idestudio
     */
    public Integer getIdestudio() {
        return idestudio;
    }

    /**
     * @param idestudio the idestudio to set
     */
    public void setIdestudio(Integer idestudio) {
        this.idestudio = idestudio;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the numReclamacion
     */
    public String getNumReclamacion() {
        return numReclamacion;
    }

    /**
     * @param numReclamacion the numReclamacion to set
     */
    public void setNumReclamacion(String numReclamacion) {
        this.numReclamacion = numReclamacion;
    }

    /**
     * @return the isActivo
     */
    public boolean isIsActivo() {
        return isActivo;
    }

    /**
     * @param isActivo the isActivo to set
     */
    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    /**
     * @return the idResultado
     */
    public Integer getIdResultado() {
        return idResultado;
    }

    /**
     * @param idResultado the idResultado to set
     */
    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    /**
     * @return the idfragmentoFragmento
     */
    public Integer getIdfragmentoFragmento() {
        return idfragmentoFragmento;
    }

    /**
     * @param idfragmentoFragmento the idfragmentoFragmento to set
     */
    public void setIdfragmentoFragmento(Integer idfragmentoFragmento) {
        this.idfragmentoFragmento = idfragmentoFragmento;
    }

    /**
     * @return the idpatologoPatologo
     */
    public Integer getIdpatologoPatologo() {
        return idpatologoPatologo;
    }

    /**
     * @param idpatologoPatologo the idpatologoPatologo to set
     */
    public void setIdpatologoPatologo(Integer idpatologoPatologo) {
        this.idpatologoPatologo = idpatologoPatologo;
    }

    /**
     * @return the idtipoEstudioTipoEstudio
     */
    public Integer getIdtipoEstudioTipoEstudio() {
        return idtipoEstudioTipoEstudio;
    }

    /**
     * @param idtipoEstudioTipoEstudio the idtipoEstudioTipoEstudio to set
     */
    public void setIdtipoEstudioTipoEstudio(Integer idtipoEstudioTipoEstudio) {
        this.idtipoEstudioTipoEstudio = idtipoEstudioTipoEstudio;
    }
    private Integer idestudio;
    
    private Date fecha;
   
    private String numReclamacion;
    
    private boolean isActivo;
    
    private Integer idResultado;
    
    private Integer idfragmentoFragmento;
    
    private Integer idpatologoPatologo;
    
    private Integer idtipoEstudioTipoEstudio;
}
