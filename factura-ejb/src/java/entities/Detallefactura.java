/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author jailu
 */
@Entity
@Table(name = "DETALLEFACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d")
    , @NamedQuery(name = "Detallefactura.findByCoddetalle", query = "SELECT d FROM Detallefactura d WHERE d.coddetalle = :coddetalle")
    , @NamedQuery(name = "Detallefactura.findByCodfactura", query = "SELECT d FROM Detallefactura d WHERE d.codfactura = :codfactura")
    , @NamedQuery(name = "Detallefactura.findByCodproducto", query = "SELECT d FROM Detallefactura d WHERE d.codproducto = :codproducto")
    , @NamedQuery(name = "Detallefactura.findByCodbarra", query = "SELECT d FROM Detallefactura d WHERE d.codbarra = :codbarra")
    , @NamedQuery(name = "Detallefactura.findByNombreproducto", query = "SELECT d FROM Detallefactura d WHERE d.nombreproducto = :nombreproducto")
    , @NamedQuery(name = "Detallefactura.findByCantidad", query = "SELECT d FROM Detallefactura d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallefactura.findByPreciototal", query = "SELECT d FROM Detallefactura d WHERE d.preciototal = :preciototal")
    , @NamedQuery(name = "Detallefactura.findByTotal", query = "SELECT d FROM Detallefactura d WHERE d.total = :total")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODDETALLE")
    private String coddetalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODFACTURA")
    private String codfactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODPRODUCTO")
    private String codproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODBARRA")
    private String codbarra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBREPRODUCTO")
    private String nombreproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CANTIDAD")
    private String cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRECIOTOTAL")
    private String preciototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TOTAL")
    private String total;

    public Detallefactura() {
    }

    public Detallefactura(String coddetalle) {
        this.coddetalle = coddetalle;
    }

    public Detallefactura(String coddetalle, String codfactura, String codproducto, String codbarra, String nombreproducto, String cantidad, String preciototal, String total) {
        this.coddetalle = coddetalle;
        this.codfactura = codfactura;
        this.codproducto = codproducto;
        this.codbarra = codbarra;
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
        this.preciototal = preciototal;
        this.total = total;
    }

    public String getCoddetalle() {
        return coddetalle;
    }

    public void setCoddetalle(String coddetalle) {
        this.coddetalle = coddetalle;
    }

    public String getCodfactura() {
        return codfactura;
    }

    public void setCodfactura(String codfactura) {
        this.codfactura = codfactura;
    }

    public String getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    public String getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(String preciototal) {
        this.preciototal = preciototal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddetalle != null ? coddetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.coddetalle == null && other.coddetalle != null) || (this.coddetalle != null && !this.coddetalle.equals(other.coddetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detallefactura[ coddetalle=" + coddetalle + " ]";
    }
    
}
