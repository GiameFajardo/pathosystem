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
@Table(name = "patologia.patologo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patologo.findByIdNombreApellido", query = "SELECT p FROM Patologo p WHERE p.idpatologo = :idpatologo OR p.nombre = :nombre OR p.apellido = :apellido"),
    @NamedQuery(name = "Patologo.findIlikeNombre", query = "SELECT p FROM Patologo p WHERE LOWER(p.nombre) LIKE LOWER(:nombre)"),
    @NamedQuery(name = "Patologo.findIlikeNombreApellido", query = "SELECT p FROM Patologo p WHERE LOWER(p.nombre) LIKE LOWER(:nombre) OR LOWER(p.apellido) LIKE LOWER(:apellido)"),
    @NamedQuery(name = "Patologo.findAll", query = "SELECT p FROM Patologo p"),
    @NamedQuery(name = "Patologo.findByIdpatologo", query = "SELECT p FROM Patologo p WHERE p.idpatologo = :idpatologo"),
    @NamedQuery(name = "Patologo.findByNombre", query = "SELECT p FROM Patologo p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Patologo.findByApellido", query = "SELECT p FROM Patologo p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Patologo.findByIsBorrado", query = "SELECT p FROM Patologo p WHERE p.isBorrado = :isBorrado"),
    @NamedQuery(name = "Patologo.findByIsBorradoIsActivo", query = "SELECT p FROM Patologo p WHERE p.isBorrado = :isBorrado AND p.isActivo = :isActivo"),
    @NamedQuery(name = "Patologo.findByIsActivo", query = "SELECT p FROM Patologo p WHERE p.isActivo = :isActivo"),
    @NamedQuery(name = "Patologo.exist", query = "SELECT COUNT(p) FROM Patologo p WHERE p.idpatologo = :idpatologo")})
public class Patologo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpatologo")
    private Integer idpatologo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "is_borrado")
    private boolean isBorrado;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpatologoPatologo")
    private Collection<Estudio> estudioCollection;

    public Patologo() {
    }

    public Patologo(Integer idpatologo) {
        this.idpatologo = idpatologo;
    }

    public Patologo(Integer idpatologo, String nombre, String apellido, boolean isBorrado, boolean isActivo) {
        this.idpatologo = idpatologo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.isBorrado = isBorrado;
        this.isActivo = isActivo;
    }

    public Integer getIdpatologo() {
        return idpatologo;
    }

    public void setIdpatologo(Integer idpatologo) {
        this.idpatologo = idpatologo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    public Collection<Estudio> getEstudioCollection() {
        return estudioCollection;
    }

    public void setEstudioCollection(Collection<Estudio> estudioCollection) {
        this.estudioCollection = estudioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpatologo != null ? idpatologo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patologo)) {
            return false;
        }
        Patologo other = (Patologo) object;
        if ((this.idpatologo == null && other.idpatologo != null) || (this.idpatologo != null && !this.idpatologo.equals(other.idpatologo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Patologo[ idpatologo=" + idpatologo + " ]";
    }
    
}
