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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "patologia.medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByIdmedico", query = "SELECT m FROM Medico m WHERE m.idmedico = :idmedico"),
    @NamedQuery(name = "Medico.findByNombre", query = "SELECT m FROM Medico m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Medico.findByApellido", query = "SELECT m FROM Medico m WHERE m.apellido = :apellido"),
    @NamedQuery(name = "Medico.findByIsBorrado", query = "SELECT m FROM Medico m WHERE m.isBorrado = :isBorrado"),
    @NamedQuery(name = "Medico.findByIsActivo", query = "SELECT m FROM Medico m WHERE m.isActivo = :isActivo")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedico")
    private Integer idmedico;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicoMedico")
    private Collection<Fragmento> fragmentoCollection;
    @JoinColumn(name = "idcentro_medico_centro_medico", referencedColumnName = "idcentro_medico")
    @ManyToOne(optional = false)
    private CentroMedico idcentroMedicoCentroMedico;
    @JoinColumn(name = "idespecialidad_especialidad", referencedColumnName = "idespecialidad")
    @ManyToOne(optional = false)
    private Especialidad idespecialidadEspecialidad;

    public Medico() {
    }

    public Medico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Medico(Integer idmedico, String nombre, String apellido, boolean isBorrado, boolean isActivo) {
        this.idmedico = idmedico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.isBorrado = isBorrado;
        this.isActivo = isActivo;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
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
    public Collection<Fragmento> getFragmentoCollection() {
        return fragmentoCollection;
    }

    public void setFragmentoCollection(Collection<Fragmento> fragmentoCollection) {
        this.fragmentoCollection = fragmentoCollection;
    }

    public CentroMedico getIdcentroMedicoCentroMedico() {
        return idcentroMedicoCentroMedico;
    }

    public void setIdcentroMedicoCentroMedico(CentroMedico idcentroMedicoCentroMedico) {
        this.idcentroMedicoCentroMedico = idcentroMedicoCentroMedico;
    }

    public Especialidad getIdespecialidadEspecialidad() {
        return idespecialidadEspecialidad;
    }

    public void setIdespecialidadEspecialidad(Especialidad idespecialidadEspecialidad) {
        this.idespecialidadEspecialidad = idespecialidadEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedico != null ? idmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idmedico == null && other.idmedico != null) || (this.idmedico != null && !this.idmedico.equals(other.idmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Medico[ idmedico=" + idmedico + " ]";
    }
    
}
