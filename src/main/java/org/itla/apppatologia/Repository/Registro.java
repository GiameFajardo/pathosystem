/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.Repository;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdregistro", query = "SELECT r FROM Registro r WHERE r.idregistro = :idregistro"),
    @NamedQuery(name = "Registro.findByFecha", query = "SELECT r FROM Registro r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Registro.findByTabla", query = "SELECT r FROM Registro r WHERE r.tabla = :tabla"),
    @NamedQuery(name = "Registro.findByDescripcion", query = "SELECT r FROM Registro r WHERE r.descripcion = :descripcion")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro")
    private Integer idregistro;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "tabla")
    private String tabla;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idcaso_caso", referencedColumnName = "idcaso")
    @ManyToOne(optional = false)
    private Caso idcasoCaso;
    @JoinColumn(name = "idempleado_empleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado idempleadoEmpleado;

    public Registro() {
    }

    public Registro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Registro(Integer idregistro, Date fecha) {
        this.idregistro = idregistro;
        this.fecha = fecha;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Caso getIdcasoCaso() {
        return idcasoCaso;
    }

    public void setIdcasoCaso(Caso idcasoCaso) {
        this.idcasoCaso = idcasoCaso;
    }

    public Empleado getIdempleadoEmpleado() {
        return idempleadoEmpleado;
    }

    public void setIdempleadoEmpleado(Empleado idempleadoEmpleado) {
        this.idempleadoEmpleado = idempleadoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Registro[ idregistro=" + idregistro + " ]";
    }
    
}
