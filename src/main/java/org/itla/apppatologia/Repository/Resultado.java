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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "patologia.resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findByIdresultado", query = "SELECT r FROM Resultado r WHERE r.idresultado = :idresultado"),
    @NamedQuery(name = "Resultado.findByFecha", query = "SELECT r FROM Resultado r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Resultado.findByIdempleado", query = "SELECT r FROM Resultado r WHERE r.idempleado = :idempleado"),
    @NamedQuery(name = "Resultado.findByIdestudio", query = "SELECT r FROM Resultado r WHERE r.idestudioEstudio = :idestudio"),
    @NamedQuery(name = "Resultado.findByIdmetodo", query = "SELECT r FROM Resultado r WHERE r.idmetodo = :idmetodo"),
    @NamedQuery(name = "Resultado.findByEtiologia", query = "SELECT r FROM Resultado r WHERE r.etiologia = :etiologia"),
    @NamedQuery(name = "Resultado.findByPatogenia", query = "SELECT r FROM Resultado r WHERE r.patogenia = :patogenia"),
    @NamedQuery(name = "Resultado.findByCambioMorfologico", query = "SELECT r FROM Resultado r WHERE r.cambioMorfologico = :cambioMorfologico"),
    @NamedQuery(name = "Resultado.findByManifestacionClinica", query = "SELECT r FROM Resultado r WHERE r.manifestacionClinica = :manifestacionClinica"),
    @NamedQuery(name = "Resultado.findByRecomendacion", query = "SELECT r FROM Resultado r WHERE r.recomendacion = :recomendacion"),
    @NamedQuery(name = "Resultado.findByAviso", query = "SELECT r FROM Resultado r WHERE r.aviso = :aviso"),
    @NamedQuery(name = "Resultado.findByIsActivo", query = "SELECT r FROM Resultado r WHERE r.isActivo = :isActivo")})
public class Resultado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresultado")
    private Integer idresultado;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "idempleado")
    private short idempleado;
    @Basic(optional = false)
    @Column(name = "idestudio")
    private short idestudio;
    @Basic(optional = false)
    
    @Column(name = "idmetodo")
    private short idmetodo;
    @Basic(optional = false)
    @Column(name = "etiologia")
    private String etiologia;
    @Basic(optional = false)
    @Column(name = "patogenia")
    private String patogenia;
    @Basic(optional = false)
    @Column(name = "cambio_morfologico")
    private String cambioMorfologico;
    @Basic(optional = false)
    @Column(name = "manifestacion_clinica")
    private String manifestacionClinica;
    @Basic(optional = false)
    @Column(name = "recomendacion")
    private String recomendacion;
    @Basic(optional = false)
    @Column(name = "aviso")
    private String aviso;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @JoinColumn(name = "idestudio_estudio", referencedColumnName = "idestudio")
    @OneToOne
    private Estudio idestudioEstudio;
    @OneToOne(mappedBy = "idresultadoResultado")
    private Entrega entrega;
    @OneToMany(mappedBy = "idresultadoResultado")
    private Collection<Observacion> observacionCollection;

    public Resultado() {
    }

    public Resultado(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public Resultado(Integer idresultado, Date fecha, short idempleado, short idestudio, short idmetodo, String etiologia, String patogenia, String cambioMorfologico, String manifestacionClinica, String recomendacion, String aviso, boolean isActivo) {
        this.idresultado = idresultado;
        this.fecha = fecha;
        this.idempleado = idempleado;
        this.idestudio = idestudio;
        this.idmetodo = idmetodo;
        this.etiologia = etiologia;
        this.patogenia = patogenia;
        this.cambioMorfologico = cambioMorfologico;
        this.manifestacionClinica = manifestacionClinica;
        this.recomendacion = recomendacion;
        this.aviso = aviso;
        this.isActivo = isActivo;
    }

    public Integer getIdresultado() {
        return idresultado;
    }

    public void setIdresultado(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(short idempleado) {
        this.idempleado = idempleado;
    }

    public short getIdestudio() {
        return idestudio;
    }

    public void setIdestudio(short idestudio) {
        this.idestudio = idestudio;
    }

    public short getIdmetodo() {
        return idmetodo;
    }

    public void setIdmetodo(short idmetodo) {
        this.idmetodo = idmetodo;
    }

    public String getEtiologia() {
        return etiologia;
    }

    public void setEtiologia(String etiologia) {
        this.etiologia = etiologia;
    }

    public String getPatogenia() {
        return patogenia;
    }

    public void setPatogenia(String patogenia) {
        this.patogenia = patogenia;
    }

    public String getCambioMorfologico() {
        return cambioMorfologico;
    }

    public void setCambioMorfologico(String cambioMorfologico) {
        this.cambioMorfologico = cambioMorfologico;
    }

    public String getManifestacionClinica() {
        return manifestacionClinica;
    }

    public void setManifestacionClinica(String manifestacionClinica) {
        this.manifestacionClinica = manifestacionClinica;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    public Estudio getIdestudioEstudio() {
        return idestudioEstudio;
    }

    public void setIdestudioEstudio(Estudio idestudioEstudio) {
        this.idestudioEstudio = idestudioEstudio;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
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
        hash += (idresultado != null ? idresultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.idresultado == null && other.idresultado != null) || (this.idresultado != null && !this.idresultado.equals(other.idresultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Resultado[ idresultado=" + idresultado + " ]";
    }
    
}
