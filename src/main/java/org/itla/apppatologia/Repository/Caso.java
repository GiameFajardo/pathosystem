/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.Repository;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.caso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caso.findAll", query = "SELECT c FROM Caso c"),
    @NamedQuery(name = "Caso.findByIdcaso", query = "SELECT c FROM Caso c WHERE c.idcaso = :idcaso"),
    @NamedQuery(name = "Caso.findByIdFragmento", query = "SELECT c FROM Caso c WHERE c.idfragmento = :idfragmento"),
    @NamedQuery(name = "Caso.findByEstado", query = "SELECT c FROM Caso c WHERE c.estado = :estado"),
    @NamedQuery(name = "Caso.findByNumeroReclamacion", query = "SELECT c FROM Caso c WHERE c.numeroReclamacion = :numeroReclamacion"),
    @NamedQuery(name = "Caso.findByNumeroPoliza", query = "SELECT c FROM Caso c WHERE c.numeroPoliza = :numeroPoliza"),
    @NamedQuery(name = "Caso.findByIsActivo", query = "SELECT c FROM Caso c WHERE c.isActivo = :isActivo")})
public class Caso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcaso")
    private Integer idcaso;
    @Column(name = "estado")
    private String estado;
    @Column(name = "numero_reclamacion")
    private String numeroReclamacion;
    @Column(name = "numero_poliza")
    private String numeroPoliza;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcasoCaso")
    private Collection<Registro> registroCollection;
    @JoinColumn(name = "idaseguradora_aseguradora", referencedColumnName = "idaseguradora")
    @ManyToOne
    private Aseguradora idaseguradoraAseguradora;
    @JoinColumn(name = "idpaciente_paciente", referencedColumnName = "idpaciente")
    @ManyToOne
    private Paciente idpacientePaciente;
    @Column(name = "porciento_cobertura")
    private float porciento_cobertura;
    @Column(name="idfragmento")
    private Integer idfragmento;
    
    public Caso() {
    }

    public Caso(Integer idcaso) {
        this.idcaso = idcaso;
    }

    public Caso(Integer idcaso, boolean isActivo) {
        this.idcaso = idcaso;
        this.isActivo = isActivo;
    }

    public Integer getIdcaso() {
        return idcaso;
    }

    public void setIdcaso(Integer idcaso) {
        this.idcaso = idcaso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroReclamacion() {
        return numeroReclamacion;
    }

    public void setNumeroReclamacion(String numeroReclamacion) {
        this.numeroReclamacion = numeroReclamacion;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    @XmlTransient
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }

    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }

    public Aseguradora getIdaseguradoraAseguradora() {
        return idaseguradoraAseguradora;
    }

    public void setIdaseguradoraAseguradora(Aseguradora idaseguradoraAseguradora) {
        this.idaseguradoraAseguradora = idaseguradoraAseguradora;
    }

    public Paciente getIdpacientePaciente() {
        return idpacientePaciente;
    }

    public void setIdpacientePaciente(Paciente idpacientePaciente) {
        this.idpacientePaciente = idpacientePaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaso != null ? idcaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caso)) {
            return false;
        }
        Caso other = (Caso) object;
        if ((this.idcaso == null && other.idcaso != null) || (this.idcaso != null && !this.idcaso.equals(other.idcaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Caso[ idcaso=" + idcaso + " ]";
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
