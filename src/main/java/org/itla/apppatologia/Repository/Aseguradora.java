/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.Repository;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "patologia.aseguradora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aseguradora.findAll", query = "SELECT a FROM Aseguradora a"),
    @NamedQuery(name = "Aseguradora.findByIdaseguradora", query = "SELECT a FROM Aseguradora a WHERE a.idaseguradora = :idaseguradora"),
    @NamedQuery(name = "Aseguradora.findByNombre", query = "SELECT a FROM Aseguradora a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aseguradora.findByDireccion", query = "SELECT a FROM Aseguradora a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Aseguradora.findByTelefono", query = "SELECT a FROM Aseguradora a WHERE a.telefono = :telefono")})
public class Aseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaseguradora")
    private Integer idaseguradora;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "idaseguradoraAseguradora")
    private Collection<Caso> casoCollection;

    public Aseguradora() {
    }

    public Aseguradora(Integer idaseguradora) {
        this.idaseguradora = idaseguradora;
    }

    public Aseguradora(Integer idaseguradora, String nombre, String telefono) {
        this.idaseguradora = idaseguradora;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Aseguradora(Integer idaseguradora, String nombre, String telefono, String direccion) {
        this.idaseguradora = idaseguradora;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdaseguradora() {
        return idaseguradora;
    }

    public void setIdaseguradora(Integer idaseguradora) {
        this.idaseguradora = idaseguradora;
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

    @XmlTransient
    public Collection<Caso> getCasoCollection() {
        return casoCollection;
    }

    public void setCasoCollection(Collection<Caso> casoCollection) {
        this.casoCollection = casoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaseguradora != null ? idaseguradora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aseguradora)) {
            return false;
        }
        Aseguradora other = (Aseguradora) object;
        if ((this.idaseguradora == null && other.idaseguradora != null) || (this.idaseguradora != null && !this.idaseguradora.equals(other.idaseguradora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Aseguradora[ idaseguradora=" + idaseguradora + " ]";
    }
    
}
