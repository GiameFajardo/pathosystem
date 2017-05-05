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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.tipo_estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstudio.findAll", query = "SELECT t FROM TipoEstudio t"),
    @NamedQuery(name = "TipoEstudio.findByIdtipoEstudio", query = "SELECT t FROM TipoEstudio t WHERE t.idtipoEstudio = :idtipoEstudio"),
    @NamedQuery(name = "TipoEstudio.findByNombre", query = "SELECT t FROM TipoEstudio t WHERE t.nombre = :nombre")})
public class TipoEstudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_estudio")
    private Integer idtipoEstudio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idaccion_tipo_estudio_accion_tipo_estudio", referencedColumnName = "idaccion_tipo_estudio")
    @ManyToOne(optional = false)
    private AccionTipoEstudio idaccionTipoEstudioAccionTipoEstudio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoEstudioTipoEstudio")
    private Collection<Estudio> estudioCollection;
    @Column(name = "precio")
    private float precio;
    
    public TipoEstudio() {
    }

    public TipoEstudio(Integer idtipoEstudio) {
        this.idtipoEstudio = idtipoEstudio;
    }

    public TipoEstudio(Integer idtipoEstudio, String nombre) {
        this.idtipoEstudio = idtipoEstudio;
        this.nombre = nombre;
    }

    public Integer getIdtipoEstudio() {
        return idtipoEstudio;
    }

    public void setIdtipoEstudio(Integer idtipoEstudio) {
        this.idtipoEstudio = idtipoEstudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AccionTipoEstudio getIdaccionTipoEstudioAccionTipoEstudio() {
        return idaccionTipoEstudioAccionTipoEstudio;
    }

    public void setIdaccionTipoEstudioAccionTipoEstudio(AccionTipoEstudio idaccionTipoEstudioAccionTipoEstudio) {
        this.idaccionTipoEstudioAccionTipoEstudio = idaccionTipoEstudioAccionTipoEstudio;
    }

    @XmlTransient
    public Collection<Estudio> getEstudioCollection() {
        return estudioCollection;
    }

    public void setEstudioCollection(Collection<Estudio> estudioCollection) {
        this.estudioCollection = estudioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoEstudio != null ? idtipoEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstudio)) {
            return false;
        }
        TipoEstudio other = (TipoEstudio) object;
        if ((this.idtipoEstudio == null && other.idtipoEstudio != null) || (this.idtipoEstudio != null && !this.idtipoEstudio.equals(other.idtipoEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.TipoEstudio[ idtipoEstudio=" + idtipoEstudio + " ]";
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
