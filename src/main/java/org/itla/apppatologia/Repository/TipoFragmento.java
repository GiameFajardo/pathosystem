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
@Table(name = "patologia.tipo_fragmento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFragmento.findAll", query = "SELECT t FROM TipoFragmento t"),
    @NamedQuery(name = "TipoFragmento.findByIdtipoFragmento", query = "SELECT t FROM TipoFragmento t WHERE t.idtipoFragmento = :idtipoFragmento"),
    @NamedQuery(name = "TipoFragmento.findByNombre", query = "SELECT t FROM TipoFragmento t WHERE t.nombre = :nombre")})
public class TipoFragmento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_fragmento")
    private Integer idtipoFragmento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoFragmentoTipoFragmento")
    private Collection<Fragmento> fragmentoCollection;

    public TipoFragmento() {
    }

    public TipoFragmento(Integer idtipoFragmento) {
        this.idtipoFragmento = idtipoFragmento;
    }

    public TipoFragmento(Integer idtipoFragmento, String nombre) {
        this.idtipoFragmento = idtipoFragmento;
        this.nombre = nombre;
    }

    public Integer getIdtipoFragmento() {
        return idtipoFragmento;
    }

    public void setIdtipoFragmento(Integer idtipoFragmento) {
        this.idtipoFragmento = idtipoFragmento;
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
        hash += (idtipoFragmento != null ? idtipoFragmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFragmento)) {
            return false;
        }
        TipoFragmento other = (TipoFragmento) object;
        if ((this.idtipoFragmento == null && other.idtipoFragmento != null) || (this.idtipoFragmento != null && !this.idtipoFragmento.equals(other.idtipoFragmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.TipoFragmento[ idtipoFragmento=" + idtipoFragmento + " ]";
    }
    
}
