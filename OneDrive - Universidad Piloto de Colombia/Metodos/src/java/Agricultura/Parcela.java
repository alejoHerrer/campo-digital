/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agricultura;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "parcela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcela.findAll", query = "SELECT p FROM Parcela p")
    , @NamedQuery(name = "Parcela.findById", query = "SELECT p FROM Parcela p WHERE p.id = :id")
    , @NamedQuery(name = "Parcela.findByUbicacion", query = "SELECT p FROM Parcela p WHERE p.ubicacion = :ubicacion")
    , @NamedQuery(name = "Parcela.findBySuperficie", query = "SELECT p FROM Parcela p WHERE p.superficie = :superficie")
    , @NamedQuery(name = "Parcela.findByTipoProduccion", query = "SELECT p FROM Parcela p WHERE p.tipoProduccion = :tipoProduccion")})
public class Parcela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Superficie")
    private String superficie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TipoProduccion")
    private String tipoProduccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parcela")
    private Collection<Cultivo> cultivoCollection;
    @JoinColumn(name = "Agricultor", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Agricultor agricultor;

    public Parcela() {
    }

    public Parcela(Integer id) {
        this.id = id;
    }

    public Parcela(Integer id, String ubicacion, String superficie, String tipoProduccion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
        this.tipoProduccion = tipoProduccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    @XmlTransient
    public Collection<Cultivo> getCultivoCollection() {
        return cultivoCollection;
    }

    public void setCultivoCollection(Collection<Cultivo> cultivoCollection) {
        this.cultivoCollection = cultivoCollection;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcela)) {
            return false;
        }
        Parcela other = (Parcela) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agricultura.Parcela[ id=" + id + " ]";
    }
    
}
