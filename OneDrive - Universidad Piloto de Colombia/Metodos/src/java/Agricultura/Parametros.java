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
@Table(name = "parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")
    , @NamedQuery(name = "Parametros.findById", query = "SELECT p FROM Parametros p WHERE p.id = :id")
    , @NamedQuery(name = "Parametros.findByNombre", query = "SELECT p FROM Parametros p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Parametros.findByTemperatura", query = "SELECT p FROM Parametros p WHERE p.temperatura = :temperatura")
    , @NamedQuery(name = "Parametros.findByHumedad", query = "SELECT p FROM Parametros p WHERE p.humedad = :humedad")
    , @NamedQuery(name = "Parametros.findByMaleza", query = "SELECT p FROM Parametros p WHERE p.maleza = :maleza")
    , @NamedQuery(name = "Parametros.findByPesoPromedio", query = "SELECT p FROM Parametros p WHERE p.pesoPromedio = :pesoPromedio")})
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Temperatura")
    private double temperatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Humedad")
    private double humedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Maleza")
    private double maleza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PesoPromedio")
    private double pesoPromedio;

    public Parametros() {
    }

    public Parametros(Integer id) {
        this.id = id;
    }

    public Parametros(Integer id, String nombre, double temperatura, double humedad, double maleza, double pesoPromedio) {
        this.id = id;
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.maleza = maleza;
        this.pesoPromedio = pesoPromedio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public double getMaleza() {
        return maleza;
    }

    public void setMaleza(double maleza) {
        this.maleza = maleza;
    }

    public double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
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
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agricultura.Parametros[ id=" + id + " ]";
    }
    
}
