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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.fragmento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fragmento.findByPacienteMedico", query = "SELECT f FROM Fragmento f, Medico m WHERE m.nombre=:nombreMedico"),
    @NamedQuery(name = "Fragmento.findAll", query = "SELECT f FROM Fragmento f"),
    @NamedQuery(name = "Fragmento.findByIdfragmento", query = "SELECT f FROM Fragmento f WHERE f.idfragmento = :idfragmento"),
    @NamedQuery(name = "Fragmento.findByFecha", query = "SELECT f FROM Fragmento f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Fragmento.findByOrigen", query = "SELECT f FROM Fragmento f WHERE f.origen = :origen"),
    @NamedQuery(name = "Fragmento.findByForma", query = "SELECT f FROM Fragmento f WHERE f.forma = :forma"),
    @NamedQuery(name = "Fragmento.findByEstructura", query = "SELECT f FROM Fragmento f WHERE f.estructura = :estructura"),
    @NamedQuery(name = "Fragmento.findByPeso", query = "SELECT f FROM Fragmento f WHERE f.peso = :peso"),
    @NamedQuery(name = "Fragmento.findByColor", query = "SELECT f FROM Fragmento f WHERE f.color = :color"),
    @NamedQuery(name = "Fragmento.findByDimension", query = "SELECT f FROM Fragmento f WHERE f.dimension = :dimension"),
    @NamedQuery(name = "Fragmento.findByDescripcion", query = "SELECT f FROM Fragmento f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Fragmento.findByDiagnostico", query = "SELECT f FROM Fragmento f WHERE f.diagnostico = :diagnostico"),
    @NamedQuery(name = "Fragmento.findByIsActivo", query = "SELECT f FROM Fragmento f WHERE f.isActivo = :isActivo")})
public class Fragmento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfragmento")
    private Integer idfragmento;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @Column(name = "forma")
    private String forma;
    @Basic(optional = false)
    @Column(name = "estructura")
    private String estructura;
    @Basic(optional = false)
    @Column(name = "peso")
    private String peso;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "dimension")
    private String dimension;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @JoinColumn(name = "idestado_fragmento_estado_fragmento", referencedColumnName = "idestado_fragmento")
    @ManyToOne(optional = false)
    private EstadoFragmento idestadoFragmentoEstadoFragmento;
    @JoinColumn(name = "idfrasco_frasco", referencedColumnName = "idfrasco")
    @OneToOne
    private Frasco idfrascoFrasco;
    @JoinColumn(name = "idmedico_medico", referencedColumnName = "idmedico")
    @ManyToOne(optional = false)
    private Medico idmedicoMedico;
    @JoinColumn(name = "idtipo_fragmento_tipo_fragmento", referencedColumnName = "idtipo_fragmento")
    @ManyToOne(optional = false)
    private TipoFragmento idtipoFragmentoTipoFragmento;
    @OneToOne(mappedBy = "idfragmentoFragmento")
    private Estudio estudio;

    public Fragmento() {
    }

    public Fragmento(Integer idfragmento) {
        this.idfragmento = idfragmento;
    }

    public Fragmento(Integer idfragmento, Date fecha, String origen, String forma, String estructura, String peso, String color, String dimension, String descripcion, String diagnostico, boolean isActivo) {
        this.idfragmento = idfragmento;
        this.fecha = fecha;
        this.origen = origen;
        this.forma = forma;
        this.estructura = estructura;
        this.peso = peso;
        this.color = color;
        this.dimension = dimension;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
        this.isActivo = isActivo;
    }

    public Integer getIdfragmento() {
        return idfragmento;
    }

    public void setIdfragmento(Integer idfragmento) {
        this.idfragmento = idfragmento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    public EstadoFragmento getIdestadoFragmentoEstadoFragmento() {
        return idestadoFragmentoEstadoFragmento;
    }

    public void setIdestadoFragmentoEstadoFragmento(EstadoFragmento idestadoFragmentoEstadoFragmento) {
        this.idestadoFragmentoEstadoFragmento = idestadoFragmentoEstadoFragmento;
    }

    public Frasco getIdfrascoFrasco() {
        return idfrascoFrasco;
    }

    public void setIdfrascoFrasco(Frasco idfrascoFrasco) {
        this.idfrascoFrasco = idfrascoFrasco;
    }

    public Medico getIdmedicoMedico() {
        return idmedicoMedico;
    }

    public void setIdmedicoMedico(Medico idmedicoMedico) {
        this.idmedicoMedico = idmedicoMedico;
    }

    public TipoFragmento getIdtipoFragmentoTipoFragmento() {
        return idtipoFragmentoTipoFragmento;
    }

    public void setIdtipoFragmentoTipoFragmento(TipoFragmento idtipoFragmentoTipoFragmento) {
        this.idtipoFragmentoTipoFragmento = idtipoFragmentoTipoFragmento;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfragmento != null ? idfragmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fragmento)) {
            return false;
        }
        Fragmento other = (Fragmento) object;
        if ((this.idfragmento == null && other.idfragmento != null) || (this.idfragmento != null && !this.idfragmento.equals(other.idfragmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Fragmento[ idfragmento=" + idfragmento + " ]";
    }
    
}
