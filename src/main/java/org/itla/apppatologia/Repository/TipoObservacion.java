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
@Table(name = "patologia.tipo_observacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoObservacion.findAll", query = "SELECT t FROM TipoObservacion t"),
    @NamedQuery(name = "TipoObservacion.findByIdtipoObservacion", query = "SELECT t FROM TipoObservacion t WHERE t.idtipoObservacion = :idtipoObservacion"),
    @NamedQuery(name = "TipoObservacion.findByNombre", query = "SELECT t FROM TipoObservacion t WHERE t.nombre = :nombre")})
public class TipoObservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_observacion")
    private Integer idtipoObservacion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoObservacionTipoObservacion")
    private Collection<Observacion> observacionCollection;

    public TipoObservacion() {
    }

    public TipoObservacion(Integer idtipoObservacion) {
        this.idtipoObservacion = idtipoObservacion;
    }

    public TipoObservacion(Integer idtipoObservacion, String nombre) {
        this.idtipoObservacion = idtipoObservacion;
        this.nombre = nombre;
    }

    public Integer getIdtipoObservacion() {
        return idtipoObservacion;
    }

    public void setIdtipoObservacion(Integer idtipoObservacion) {
        this.idtipoObservacion = idtipoObservacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Observacion> getObservacionCollection() {
        return observacionCollection;
    }

    public void setObservacionCollection(Collection<Observacion> observacionCollection) {
        this.observacionCollection = observacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoObservacion != null ? idtipoObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoObservacion)) {
            return false;
        }
        TipoObservacion other = (TipoObservacion) object;
        if ((this.idtipoObservacion == null && other.idtipoObservacion != null) || (this.idtipoObservacion != null && !this.idtipoObservacion.equals(other.idtipoObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.TipoObservacion[ idtipoObservacion=" + idtipoObservacion + " ]";
    }
    
}
