/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e"),
    @NamedQuery(name = "Estudio.findByIdestudio", query = "SELECT e FROM Estudio e WHERE e.idestudio = :idestudio"),
    @NamedQuery(name = "Estudio.findByFecha", query = "SELECT e FROM Estudio e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Estudio.findByNumReclamacion", query = "SELECT e FROM Estudio e WHERE e.numReclamacion = :numReclamacion"),
    @NamedQuery(name = "Estudio.findByIsActivo", query = "SELECT e FROM Estudio e WHERE e.isActivo = :isActivo")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestudio")
    private Integer idestudio;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "num_reclamacion")
    private String numReclamacion;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @OneToOne(mappedBy = "idestudioEstudio")
    private Resultado resultado;
    @JoinColumn(name = "idfragmento_fragmento", referencedColumnName = "idfragmento")
    @OneToOne
    private Fragmento idfragmentoFragmento;
    @JoinColumn(name = "idpatologo_patologo", referencedColumnName = "idpatologo")
    @ManyToOne(optional = false)
    private Patologo idpatologoPatologo;
    @JoinColumn(name = "idtipo_estudio_tipo_estudio", referencedColumnName = "idtipo_estudio")
    @ManyToOne(optional = false)
    private TipoEstudio idtipoEstudioTipoEstudio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestudioEstudio")
    private Collection<Observacion> observacionCollection;

    public Estudio() {
    }

    public Estudio(Integer idestudio) {
        this.idestudio = idestudio;
    }

    public Estudio(Integer idestudio, Date fecha, String numReclamacion, boolean isActivo) {
        this.idestudio = idestudio;
        this.fecha = fecha;
        this.numReclamacion = numReclamacion;
        this.isActivo = isActivo;
    }

    public Integer getIdestudio() {
        return idestudio;
    }

    public void setIdestudio(Integer idestudio) {
        this.idestudio = idestudio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumReclamacion() {
        return numReclamacion;
    }

    public void setNumReclamacion(String numReclamacion) {
        this.numReclamacion = numReclamacion;
    }

    public boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Fragmento getIdfragmentoFragmento() {
        return idfragmentoFragmento;
    }

    public void setIdfragmentoFragmento(Fragmento idfragmentoFragmento) {
        this.idfragmentoFragmento = idfragmentoFragmento;
    }

    public Patologo getIdpatologoPatologo() {
        return idpatologoPatologo;
    }

    public void setIdpatologoPatologo(Patologo idpatologoPatologo) {
        this.idpatologoPatologo = idpatologoPatologo;
    }

    public TipoEstudio getIdtipoEstudioTipoEstudio() {
        return idtipoEstudioTipoEstudio;
    }

    public void setIdtipoEstudioTipoEstudio(TipoEstudio idtipoEstudioTipoEstudio) {
        this.idtipoEstudioTipoEstudio = idtipoEstudioTipoEstudio;
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
        hash += (idestudio != null ? idestudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.idestudio == null && other.idestudio != null) || (this.idestudio != null && !this.idestudio.equals(other.idestudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Estudio[ idestudio=" + idestudio + " ]";
    }
    
}
