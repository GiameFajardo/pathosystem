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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.tipo_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaciente.findAll", query = "SELECT t FROM TipoPaciente t"),
    @NamedQuery(name = "TipoPaciente.findByIdtipoPaciente", query = "SELECT t FROM TipoPaciente t WHERE t.idtipoPaciente = :idtipoPaciente"),
    @NamedQuery(name = "TipoPaciente.findByNombre", query = "SELECT t FROM TipoPaciente t WHERE t.nombre = :nombre")})
public class TipoPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_paciente")
    private Integer idtipoPaciente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoPacienteTipoPaciente")
    private Collection<Paciente> pacienteCollection;

    public TipoPaciente() {
    }

    public TipoPaciente(Integer idtipoPaciente) {
        this.idtipoPaciente = idtipoPaciente;
    }

    public TipoPaciente(Integer idtipoPaciente, String nombre) {
        this.idtipoPaciente = idtipoPaciente;
        this.nombre = nombre;
    }

    public Integer getIdtipoPaciente() {
        return idtipoPaciente;
    }

    public void setIdtipoPaciente(Integer idtipoPaciente) {
        this.idtipoPaciente = idtipoPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoPaciente != null ? idtipoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaciente)) {
            return false;
        }
        TipoPaciente other = (TipoPaciente) object;
        if ((this.idtipoPaciente == null && other.idtipoPaciente != null) || (this.idtipoPaciente != null && !this.idtipoPaciente.equals(other.idtipoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.TipoPaciente[ idtipoPaciente=" + idtipoPaciente + " ]";
    }
    
}
