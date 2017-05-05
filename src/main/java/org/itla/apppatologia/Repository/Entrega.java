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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "patologia.entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findByIdentrega", query = "SELECT e FROM Entrega e WHERE e.identrega = :identrega")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identrega")
    private Short identrega;
    @JoinColumn(name = "idresultado_resultado", referencedColumnName = "idresultado")
    @OneToOne
    private Resultado idresultadoResultado;
    @Column(name = "is_pago")
    private boolean is_pago;
    public Entrega() {
    }

    public Entrega(Short identrega) {
        this.identrega = identrega;
    }

    public Short getIdentrega() {
        return identrega;
    }

    public void setIdentrega(Short identrega) {
        this.identrega = identrega;
    }

    public Resultado getIdresultadoResultado() {
        return idresultadoResultado;
    }

    public void setIdresultadoResultado(Resultado idresultadoResultado) {
        this.idresultadoResultado = idresultadoResultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identrega != null ? identrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.identrega == null && other.identrega != null) || (this.identrega != null && !this.identrega.equals(other.identrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itla.apppatologia.modelo.entity.Entrega[ identrega=" + identrega + " ]";
    }

    /**
     * @return the is_pago
     */
    public boolean getIs_pago() {
        return is_pago;
    }

    /**
     * @param is_pago the is_pago to set
     */
    public void setIs_pago(boolean is_pago) {
        this.is_pago = is_pago;
    }
    
}
