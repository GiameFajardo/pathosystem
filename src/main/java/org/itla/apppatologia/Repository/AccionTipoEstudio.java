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
@Table(name = "patologia.accion_tipo_estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccionTipoEstudio.findAll", query = "SELECT a FROM AccionTipoEstudio a"),
    @NamedQuery(name = "AccionTipoEstudio.findByIdaccionTipoEstudio", query = "SELECT a FROM AccionTipoEstudio a WHERE a.idaccionTipoEstudio = :idaccionTipoEstudio"),
    @NamedQuery(name = "AccionTipoEstudio.findByNombre", query = "SELECT a FROM AccionTipoEstudio a WHERE a.nombre = :nombre")})
public class AccionTipoEstudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaccion_tipo_estudio")
    private Integer idaccionTipoEstudio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaccionTipoEstudioAccionTipoEstudio")
    private Collection<TipoEstudio> tipoEstudioCollection;

    public AccionTipoEstudio() {
    }

    public AccionTipoEstudio(Integer idaccionTipoEstudio) {
        this.idaccionTipoEstudio = idaccionTipoEstudio;
    }

    public AccionTipoEstudio(Integer idaccionTipoEstudio, String nombre) {
        this.idaccionTipoEstudio = idaccionTipoEstudio;
        this.nombre = nombre;
    }

    public Integer getIdaccionTipoEstudio() {
        return idaccionTipoEstudio;
    }

    public void setIdaccionTipoEstudio(Integer idaccionTipoEstudio) {
        this.idaccionTipoEstudio = idaccionTipoEstudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<TipoEstudio> getTipoEstudioCollection() {
        return tipoEstudioCollection;
    }

    public void setTipoEstudioCollection(Collection<TipoEstudio> tipoEstudioCollection) {
        this.tipoEstudioCollection = tipoEstudioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccionTipoEstudio != null ? idaccionTipoEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionTipoEstudio)) {
            return false;
        }
        AccionTipoEstudio other = (AccionTipoEstudio) object;
        if ((this.idaccionTipoEstudio == null && other.idaccionTipoEstudio != null) || (this.idaccionTipoEstudio != null && !this.idaccionTipoEstudio.equals(other.idaccionTipoEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.AccionTipoEstudio[ idaccionTipoEstudio=" + idaccionTipoEstudio + " ]";
    }
    
}
