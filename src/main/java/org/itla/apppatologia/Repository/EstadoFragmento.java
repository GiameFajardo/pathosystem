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
@Table(name = "patologia.estado_fragmento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoFragmento.findAll", query = "SELECT e FROM EstadoFragmento e"),
    @NamedQuery(name = "EstadoFragmento.findByIdestadoFragmento", query = "SELECT e FROM EstadoFragmento e WHERE e.idestadoFragmento = :idestadoFragmento"),
    @NamedQuery(name = "EstadoFragmento.findByNombre", query = "SELECT e FROM EstadoFragmento e WHERE e.nombre = :nombre")})
public class EstadoFragmento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado_fragmento")
    private Integer idestadoFragmento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoFragmentoEstadoFragmento")
    private Collection<Fragmento> fragmentoCollection;

    public EstadoFragmento() {
    }

    public EstadoFragmento(Integer idestadoFragmento) {
        this.idestadoFragmento = idestadoFragmento;
    }

    public EstadoFragmento(Integer idestadoFragmento, String nombre) {
        this.idestadoFragmento = idestadoFragmento;
        this.nombre = nombre;
    }

    public Integer getIdestadoFragmento() {
        return idestadoFragmento;
    }

    public void setIdestadoFragmento(Integer idestadoFragmento) {
        this.idestadoFragmento = idestadoFragmento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Fragmento> getFragmentoCollection() {
        return fragmentoCollection;
    }

    public void setFragmentoCollection(Collection<Fragmento> fragmentoCollection) {
        this.fragmentoCollection = fragmentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoFragmento != null ? idestadoFragmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFragmento)) {
            return false;
        }
        EstadoFragmento other = (EstadoFragmento) object;
        if ((this.idestadoFragmento == null && other.idestadoFragmento != null) || (this.idestadoFragmento != null && !this.idestadoFragmento.equals(other.idestadoFragmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.EstadoFragmento[ idestadoFragmento=" + idestadoFragmento + " ]";
    }
    
}
