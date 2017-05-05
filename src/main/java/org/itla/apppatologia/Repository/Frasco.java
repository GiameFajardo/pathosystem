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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sony
 */
@Entity
@Table(name = "patologia.frasco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frasco.findAll", query = "SELECT f FROM Frasco f"),
    @NamedQuery(name = "Frasco.findByIdfrasco", query = "SELECT f FROM Frasco f WHERE f.idfrasco = :idfrasco"),
    @NamedQuery(name = "Frasco.findByIdfragmento", query = "SELECT f FROM Frasco f WHERE f.idfragmento = :idfragmento"),
    @NamedQuery(name = "Frasco.findByIsActivo", query = "SELECT f FROM Frasco f WHERE f.isActivo = :isActivo")})
public class Frasco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfrasco")
    private Integer idfrasco;
    @Column(name = "idfragmento")
    private Short idfragmento;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @OneToOne(mappedBy = "idfrascoFrasco")
    private Fragmento fragmento;
    @JoinColumn(name = "idpaciente_paciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Paciente idpacientePaciente;

    public Frasco() {
    }

    public Frasco(Integer idfrasco) {
        this.idfrasco = idfrasco;
    }

    public Frasco(Integer idfrasco, boolean isActivo) {
        this.idfrasco = idfrasco;
        this.isActivo = isActivo;
    }

    public Integer getIdfrasco() {
        return idfrasco;
    }

    public void setIdfrasco(Integer idfrasco) {
        this.idfrasco = idfrasco;
    }

    public Short getIdfragmento() {
        return idfragmento;
    }

    public void setIdfragmento(Short idfragmento) {
        this.idfragmento = idfragmento;
    }

    public boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    public Fragmento getFragmento() {
        return fragmento;
    }

    public void setFragmento(Fragmento fragmento) {
        this.fragmento = fragmento;
    }

    public Paciente getIdpacientePaciente() {
        return idpacientePaciente;
    }

    public void setIdpacientePaciente(Paciente idpacientePaciente) {
        this.idpacientePaciente = idpacientePaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfrasco != null ? idfrasco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frasco)) {
            return false;
        }
        Frasco other = (Frasco) object;
        if ((this.idfrasco == null && other.idfrasco != null) || (this.idfrasco != null && !this.idfrasco.equals(other.idfrasco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Frasco[ idfrasco=" + idfrasco + " ]";
    }
    
}
