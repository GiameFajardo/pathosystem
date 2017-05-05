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
@Table(name = "patologia.paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.idpaciente = :idpaciente"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByApellido", query = "SELECT p FROM Paciente p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Paciente.findByDireccion", query = "SELECT p FROM Paciente p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByIdtipoPaciente", query = "SELECT p FROM Paciente p WHERE p.idtipoPaciente = :idtipoPaciente"),
    @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Paciente.findByIsBorrado", query = "SELECT p FROM Paciente p WHERE p.isBorrado = :isBorrado"),
    @NamedQuery(name = "Paciente.findByIsActivo", query = "SELECT p FROM Paciente p WHERE p.isActivo = :isActivo")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "idtipo_paciente")
    private short idtipoPaciente;
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "is_borrado")
    private boolean isBorrado;
    @Basic(optional = false)
    @Column(name = "is_activo")
    private boolean isActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpacientePaciente")
    private Collection<Frasco> frascoCollection;
//    @OneToOne(mappedBy = "idpacientePaciente")
//    private Caso caso;
    //PRUEBA PARA OBTENER LOS CASOS DEL PACIENTE
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpacientePaciente")
    private Collection<Caso> casoCollection;
    
    
    @JoinColumn(name = "idtipo_paciente_tipo_paciente", referencedColumnName = "idtipo_paciente")
    @ManyToOne(optional = false)
    private TipoPaciente idtipoPacienteTipoPaciente;

    public Paciente() {
    }

    public Paciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Paciente(Integer idpaciente, String nombre, String apellido, String telefono, String direccion, Date fechaNacimiento, short idtipoPaciente, boolean isBorrado, boolean isActivo) {
        this.idpaciente = idpaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.idtipoPaciente = idtipoPaciente;
        this.isBorrado = isBorrado;
        this.isActivo = isActivo;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public short getIdtipoPaciente() {
        return idtipoPaciente;
    }

    public void setIdtipoPaciente(short idtipoPaciente) {
        this.idtipoPaciente = idtipoPaciente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    public Collection<Frasco> getFrascoCollection() {
        return frascoCollection;
    }

    public void setFrascoCollection(Collection<Frasco> frascoCollection) {
        this.frascoCollection = frascoCollection;
    }

//    public Caso getCaso() {
//        return caso;
//    }
//
//    public void setCaso(Caso caso) {
//        this.caso = caso;
//    }

    public TipoPaciente getIdtipoPacienteTipoPaciente() {
        return idtipoPacienteTipoPaciente;
    }

    public void setIdtipoPacienteTipoPaciente(TipoPaciente idtipoPacienteTipoPaciente) {
        this.idtipoPacienteTipoPaciente = idtipoPacienteTipoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Paciente[ idpaciente=" + idpaciente + " ]";
    }

    /**
     * @return the casoCollection
     */
    public Collection<Caso> getCasoCollection() {
        return casoCollection;
    }

    /**
     * @param casoCollection the casoCollection to set
     */
    public void setCasoCollection(Collection<Caso> casoCollection) {
        this.casoCollection = casoCollection;
    }
    
}
