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
@Table(name = "agricultor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agricultor.findAll", query = "SELECT a FROM Agricultor a")
    , @NamedQuery(name = "Agricultor.findById", query = "SELECT a FROM Agricultor a WHERE a.id = :id")
    , @NamedQuery(name = "Agricultor.findByCedula", query = "SELECT a FROM Agricultor a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "Agricultor.findByNombres", query = "SELECT a FROM Agricultor a WHERE a.nombres = :nombres")
    , @NamedQuery(name = "Agricultor.findByTelefono", query = "SELECT a FROM Agricultor a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Agricultor.findByDireccion", query = "SELECT a FROM Agricultor a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Agricultor.findByZona", query = "SELECT a FROM Agricultor a WHERE a.zona = :zona")})
public class Agricultor implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agricultor")
    private Collection<Parcela> parcelaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cedula")
    private int cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Zona")
    private String zona;

    public Agricultor() {
    }

    public Agricultor(Integer id) {
        this.id = id;
    }

    public Agricultor(Integer id, int cedula, String nombres, int telefono, String direccion, String zona) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
        this.zona = zona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
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
        if (!(object instanceof Agricultor)) {
            return false;
        }
        Agricultor other = (Agricultor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agricultura.Agricultor[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Parcela> getParcelaCollection() {
        return parcelaCollection;
    }

    public void setParcelaCollection(Collection<Parcela> parcelaCollection) {
        this.parcelaCollection = parcelaCollection;
    }
    
}
