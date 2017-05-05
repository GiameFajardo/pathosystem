/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.DTO;

/**
 *
 * @author Giame
 */
public class CasoDTO {

    /**
     * @return the idcaso
     */
    public Integer getIdcaso() {
        return idcaso;
    }

    /**
     * @param idcaso the idcaso to set
     */
    public void setIdcaso(Integer idcaso) {
        this.idcaso = idcaso;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the numero_reclamacion
     */
    public String getNumero_reclamacion() {
        return numero_reclamacion;
    }

    /**
     * @param numero_reclamacion the numero_reclamacion to set
     */
    public void setNumero_reclamacion(String numero_reclamacion) {
        this.numero_reclamacion = numero_reclamacion;
    }

    /**
     * @return the numero_poliza
     */
    public String getNumero_poliza() {
        return numero_poliza;
    }

    /**
     * @param numero_poliza the numero_poliza to set
     */
    public void setNumero_poliza(String numero_poliza) {
        this.numero_poliza = numero_poliza;
    }

    /**
     * @return the porciento_cobertura
     */
    public float getPorciento_cobertura() {
        return porciento_cobertura;
    }

    /**
     * @param porciento_cobertura the porciento_cobertura to set
     */
    public void setPorciento_cobertura(float porciento_cobertura) {
        this.porciento_cobertura = porciento_cobertura;
    }

    /**
     * @return the is_active
     */
    public boolean isIs_active() {
        return is_active;
    }

    /**
     * @param is_active the is_active to set
     */
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    /**
     * @return the idpaciente
     */
    public Integer getIdpaciente() {
        return idpaciente;
    }

    /**
     * @param idpaciente the idpaciente to set
     */
    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    /**
     * @return the idaseguradora
     */
    public Integer getIdaseguradora() {
        return idaseguradora;
    }

    /**
     * @param idaseguradora the idaseguradora to set
     */
    public void setIdaseguradora(Integer idaseguradora) {
        this.idaseguradora = idaseguradora;
    }
    
    private Integer idcaso;
    private String estado;
    private String numero_reclamacion;
    private String numero_poliza;
    private float porciento_cobertura;
    private boolean is_active;
    private Integer idpaciente;
    private Integer idaseguradora;
    private Integer idfragmento;

    /**
     * @return the idfragmento
     */
    public Integer getIdfragmento() {
        return idfragmento;
    }

    /**
     * @param idfragmento the idfragmento to set
     */
    public void setIdfragmento(Integer idfragmento) {
        this.idfragmento = idfragmento;
    }
}
