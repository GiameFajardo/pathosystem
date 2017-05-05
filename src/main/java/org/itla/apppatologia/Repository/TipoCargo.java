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
@Table(name = "patologia.tipo_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCargo.findAll", query = "SELECT t FROM TipoCargo t"),
    @NamedQuery(name = "TipoCargo.findByIdtipoCargo", query = "SELECT t FROM TipoCargo t WHERE t.idtipoCargo = :idtipoCargo"),
    @NamedQuery(name = "TipoCargo.findByNombre", query = "SELECT t FROM TipoCargo t WHERE t.nombre = :nombre")})
public class TipoCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_cargo")
    private Integer idtipoCargo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoCargoTipoCargo")
    private Collection<Empleado> empleadoCollection;

    public TipoCargo() {
    }

    public TipoCargo(Integer idtipoCargo) {
        this.idtipoCargo = idtipoCargo;
    }

    public TipoCargo(Integer idtipoCargo, String nombre) {
        this.idtipoCargo = idtipoCargo;
        this.nombre = nombre;
    }

    public Integer getIdtipoCargo() {
        return idtipoCargo;
    }

    public void setIdtipoCargo(Integer idtipoCargo) {
        this.idtipoCargo = idtipoCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoCargo != null ? idtipoCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCargo)) {
            return false;
        }
        TipoCargo other = (TipoCargo) object;
        if ((this.idtipoCargo == null && other.idtipoCargo != null) || (this.idtipoCargo != null && !this.idtipoCargo.equals(other.idtipoCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.TipoCargo[ idtipoCargo=" + idtipoCargo + " ]";
    }
    
}
