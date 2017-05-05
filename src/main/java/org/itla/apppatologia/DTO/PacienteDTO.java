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
public class PacienteDTO {

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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the idtipoPaciente
     */
    public Integer getIdtipoPaciente() {
        return idtipoPaciente;
    }

    /**
     * @param idtipoPaciente the idtipoPaciente to set
     */
    public void setIdtipoPaciente(Integer idtipoPaciente) {
        this.idtipoPaciente = idtipoPaciente;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the isBorrado
     */
    public boolean isIsBorrado() {
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
     * @return the idtipoPacienteTipoPaciente
     */
    public Integer getIdtipoPacienteTipoPaciente() {
        return idtipoPacienteTipoPaciente;
    }

    /**
     * @param idtipoPacienteTipoPaciente the idtipoPacienteTipoPaciente to set
     */
    public void setIdtipoPacienteTipoPaciente(Integer idtipoPacienteTipoPaciente) {
        this.idtipoPacienteTipoPaciente = idtipoPacienteTipoPaciente;
    }
    private Integer idpaciente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private Integer idtipoPaciente;
    private String sexo;
    private boolean isBorrado;
    private boolean isActivo;
    private Integer idtipoPacienteTipoPaciente;
}
