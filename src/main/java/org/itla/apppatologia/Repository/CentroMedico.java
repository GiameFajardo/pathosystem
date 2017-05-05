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
@Table(name = "patologia.centro_medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroMedico.findAll", query = "SELECT c FROM CentroMedico c"),
    @NamedQuery(name = "CentroMedico.findByIdcentroMedico", query = "SELECT c FROM CentroMedico c WHERE c.idcentroMedico = :idcentroMedico"),
    @NamedQuery(name = "CentroMedico.findByNombre", query = "SELECT c FROM CentroMedico c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CentroMedico.findByDireccion", query = "SELECT c FROM CentroMedico c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "CentroMedico.findByTelefono", query = "SELECT c FROM CentroMedico c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "CentroMedico.findByIsBorrado", query = "SELECT c FROM CentroMedico c WHERE c.isBorrado = :isBorrado"),
    @NamedQuery(name = "CentroMedico.findByIsActivo", query = "SELECT c FROM CentroMedico c WHERE c.isActivo = :isActivo")})
public class CentroMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcentro_medico")
    private Integer idcentroMedico;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "is_borrado")
    private boolean isBorrado;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcentroMedicoCentroMedico")
    private Collection<Medico> medicoCollection;

    public CentroMedico() {
    }

    public CentroMedico(Integer idcentroMedico) {
        this.idcentroMedico = idcentroMedico;
    }

    public CentroMedico(Integer idcentroMedico, String nombre, String direccion, String telefono, boolean isBorrado, boolean isActivo) {
        this.idcentroMedico = idcentroMedico;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.isBorrado = isBorrado;
        this.isActivo = isActivo;
    }

    public Integer getIdcentroMedico() {
        return idcentroMedico;
    }

    public void setIdcentroMedico(Integer idcentroMedico) {
        this.idcentroMedico = idcentroMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getIsBorrado() {
        return isBorrado;
    }

    public void setIsBorrado(boolean isBorrado) {
        this.isBorrado = isBorrado;
    }

    public boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    @XmlTransient
    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcentroMedico != null ? idcentroMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroMedico)) {
            return false;
        }
        CentroMedico other = (CentroMedico) object;
        if ((this.idcentroMedico == null && other.idcentroMedico != null) || (this.idcentroMedico != null && !this.idcentroMedico.equals(other.idcentroMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.CentroMedico[ idcentroMedico=" + idcentroMedico + " ]";
    }
    
}
