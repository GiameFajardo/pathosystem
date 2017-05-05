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
public class ResultadoDTO {

    /**
     * @return the idresultado
     */
    public Integer getIdresultado() {
        return idresultado;
    }

    /**
     * @param idresultado the idresultado to set
     */
    public void setIdresultado(Integer idresultado) {
        this.idresultado = idresultado;
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
     * @return the idempleado
     */
    public Integer getIdempleado() {
        return idempleado;
    }

    /**
     * @param idempleado the idempleado to set
     */
    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

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
     * @return the idmetodo
     */
    public Integer getIdmetodo() {
        return idmetodo;
    }

    /**
     * @param idmetodo the idmetodo to set
     */
    public void setIdmetodo(Integer idmetodo) {
        this.idmetodo = idmetodo;
    }

    /**
     * @return the etiologia
     */
    public String getEtiologia() {
        return etiologia;
    }

    /**
     * @param etiologia the etiologia to set
     */
    public void setEtiologia(String etiologia) {
        this.etiologia = etiologia;
    }

    /**
     * @return the patogenia
     */
    public String getPatogenia() {
        return patogenia;
    }

    /**
     * @param patogenia the patogenia to set
     */
    public void setPatogenia(String patogenia) {
        this.patogenia = patogenia;
    }

    /**
     * @return the cambioMorfologico
     */
    public String getCambioMorfologico() {
        return cambioMorfologico;
    }

    /**
     * @param cambioMorfologico the cambioMorfologico to set
     */
    public void setCambioMorfologico(String cambioMorfologico) {
        this.cambioMorfologico = cambioMorfologico;
    }

    /**
     * @return the manifestacionClinica
     */
    public String getManifestacionClinica() {
        return manifestacionClinica;
    }

    /**
     * @param manifestacionClinica the manifestacionClinica to set
     */
    public void setManifestacionClinica(String manifestacionClinica) {
        this.manifestacionClinica = manifestacionClinica;
    }

    /**
     * @return the recomendacion
     */
    public String getRecomendacion() {
        return recomendacion;
    }

    /**
     * @param recomendacion the recomendacion to set
     */
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    /**
     * @return the aviso
     */
    public String getAviso() {
        return aviso;
    }

    /**
     * @param aviso the aviso to set
     */
    public void setAviso(String aviso) {
        this.aviso = aviso;
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
     * @return the idestudioEstudio
     */
    public Integer getIdestudioEstudio() {
        return idestudioEstudio;
    }

    /**
     * @param idestudioEstudio the idestudioEstudio to set
     */
    public void setIdestudioEstudio(Integer idestudioEstudio) {
        this.idestudioEstudio = idestudioEstudio;
    }
    
    private Integer idresultado;
    private Date fecha;
    private Integer idempleado;
    private Integer idestudio;
    private Integer idmetodo;
    private String etiologia;
    private String patogenia;
    private String cambioMorfologico;
    private String manifestacionClinica;
    private String recomendacion;
    private String aviso;
    private boolean isActivo;
    private Integer idestudioEstudio;
}
