/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.Repository;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.observacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observacion.findAll", query = "SELECT o FROM Observacion o"),
    @NamedQuery(name = "Observacion.findByIdobservacion", query = "SELECT o FROM Observacion o WHERE o.idobservacion = :idobservacion"),
//    @NamedQuery(name = "Observacion.findByIdestudio", query = "SELECT o FROM Observacion o WHERE o.idestudio_estudio = :idestudio"),
    @NamedQuery(name = "Observacion.findByDescripcion", query = "SELECT o FROM Observacion o WHERE o.descripcion = :descripcion")})
public class Observacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idobservacion")
    private Integer idobservacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idestudio_estudio", referencedColumnName = "idestudio")
    @ManyToOne(optional = false)
    private Estudio idestudioEstudio;
    @JoinColumn(name = "idresultado_resultado", referencedColumnName = "idresultado")
    @ManyToOne
    private Resultado idresultadoResultado;
    @JoinColumn(name = "idtipo_observacion_tipo_observacion", referencedColumnName = "idtipo_observacion")
    @ManyToOne(optional = false)
    private TipoObservacion idtipoObservacionTipoObservacion;

    public Observacion() {
    }

    public Observacion(Integer idobservacion) {
        this.idobservacion = idobservacion;
    }

    public Observacion(Integer idobservacion, String descripcion) {
        this.idobservacion = idobservacion;
        this.descripcion = descripcion;
    }

    public Integer getIdobservacion() {
        return idobservacion;
    }

    public void setIdobservacion(Integer idobservacion) {
        this.idobservacion = idobservacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estudio getIdestudioEstudio() {
        return idestudioEstudio;
    }

    public void setIdestudioEstudio(Estudio idestudioEstudio) {
        this.idestudioEstudio = idestudioEstudio;
    }

    public Resultado getIdresultadoResultado() {
        return idresultadoResultado;
    }

    public void setIdresultadoResultado(Resultado idresultadoResultado) {
        this.idresultadoResultado = idresultadoResultado;
    }

    public TipoObservacion getIdtipoObservacionTipoObservacion() {
        return idtipoObservacionTipoObservacion;
    }

    public void setIdtipoObservacionTipoObservacion(TipoObservacion idtipoObservacionTipoObservacion) {
        this.idtipoObservacionTipoObservacion = idtipoObservacionTipoObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobservacion != null ? idobservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacion)) {
            return false;
        }
        Observacion other = (Observacion) object;
        if ((this.idobservacion == null && other.idobservacion != null) || (this.idobservacion != null && !this.idobservacion.equals(other.idobservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Observacion[ idobservacion=" + idobservacion + " ]";
    }
    
}
