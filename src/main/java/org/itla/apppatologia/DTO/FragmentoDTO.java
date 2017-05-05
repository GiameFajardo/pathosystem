/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.DTO;

import java.util.Date;

/**
 *
 * @author sony
 */
public class FragmentoDTO {

    /**
     * @return the idEstado
     */
    public Integer getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the idTipo
     */
    public Integer getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
    
    private int id;
    private String paciente;
    private String medico;
    private String empleado;
    private Date fecha;
    private String tipoFragmento;
    private String estadoFragmento;
    private String origen;
    private String forma;
    private String estructura;
    private String pero;
    private String dimencion;
    private String color;
    private String descripcion;
    private String diagnostico;
    private Integer idPaciente;
    private Integer idFrasco;
    private Integer idMedico;
    private Integer idEstado;
    private Integer idTipo;
    private boolean isActivo;

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
     * @return the paciente
     */
    public String getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the medico
     */
    public String getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }

    /**
     * @return the empleado
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
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
     * @return the tipoFragmento
     */
    public String getTipoFragmento() {
        return tipoFragmento;
    }

    /**
     * @param tipoFragmento the tipoFragmento to set
     */
    public void setTipoFragmento(String tipoFragmento) {
        this.tipoFragmento = tipoFragmento;
    }

    /**
     * @return the estadoFragmento
     */
    public String getEstadoFragmento() {
        return estadoFragmento;
    }

    /**
     * @param estadoFragmento the estadoFragmento to set
     */
    public void setEstadoFragmento(String estadoFragmento) {
        this.estadoFragmento = estadoFragmento;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the forma
     */
    public String getForma() {
        return forma;
    }

    /**
     * @param forma the forma to set
     */
    public void setForma(String forma) {
        this.forma = forma;
    }

    /**
     * @return the estructura
     */
    public String getEstructura() {
        return estructura;
    }

    /**
     * @param estructura the estructura to set
     */
    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    /**
     * @return the pero
     */
    public String getPero() {
        return pero;
    }

    /**
     * @param pero the pero to set
     */
    public void setPero(String pero) {
        this.pero = pero;
    }

    /**
     * @return the dimencion
     */
    public String getDimencion() {
        return dimencion;
    }

    /**
     * @param dimencion the dimencion to set
     */
    public void setDimencion(String dimencion) {
        this.dimencion = dimencion;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
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
     * @return the idFrasco
     */
    public Integer getIdFrasco() {
        return idFrasco;
    }

    /**
     * @param idFrasco the idFrasco to set
     */
    public void setIdFrasco(Integer idFrasco) {
        this.idFrasco = idFrasco;
    }

    /**
     * @return the idMedico
     */
    public Integer getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return the idPaciente
     */
    public Integer getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
}
