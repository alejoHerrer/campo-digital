/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agricultura;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "cultivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cultivo.findAll", query = "SELECT c FROM Cultivo c")
    , @NamedQuery(name = "Cultivo.findById", query = "SELECT c FROM Cultivo c WHERE c.id = :id")
    , @NamedQuery(name = "Cultivo.findByFechaSiembra", query = "SELECT c FROM Cultivo c WHERE c.fechaSiembra = :fechaSiembra")
    , @NamedQuery(name = "Cultivo.findByFechaEsperada", query = "SELECT c FROM Cultivo c WHERE c.fechaEsperada = :fechaEsperada")
    , @NamedQuery(name = "Cultivo.findByCantidad", query = "SELECT c FROM Cultivo c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "Cultivo.findByUnidades", query = "SELECT c FROM Cultivo c WHERE c.unidades = :unidades")})
public class Cultivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FechaSiembra")
    private String fechaSiembra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FechaEsperada")
    private String fechaEsperada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Unidades")
    private String unidades;
    @JoinColumn(name = "Parcela", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Parcela parcela;

    public Cultivo() {
    }

    public Cultivo(Integer id) {
        this.id = id;
    }

    public Cultivo(Integer id, String fechaSiembra, String fechaEsperada, int cantidad, String unidades) {
        this.id = id;
        this.fechaSiembra = fechaSiembra;
        this.fechaEsperada = fechaEsperada;
        this.cantidad = cantidad;
        this.unidades = unidades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public String getFechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(String fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
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
        if (!(object instanceof Cultivo)) {
            return false;
        }
        Cultivo other = (Cultivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agricultura.Cultivo[ id=" + id + " ]";
    }
    
}
