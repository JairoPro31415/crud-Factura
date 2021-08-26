/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jailu
 */
@Entity
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByCodfactura", query = "SELECT f FROM Factura f WHERE f.codfactura = :codfactura")
    , @NamedQuery(name = "Factura.findByNumerofactura", query = "SELECT f FROM Factura f WHERE f.numerofactura = :numerofactura")
    , @NamedQuery(name = "Factura.findByCodvendedor", query = "SELECT f FROM Factura f WHERE f.codvendedor = :codvendedor")
    , @NamedQuery(name = "Factura.findByCodcliente", query = "SELECT f FROM Factura f WHERE f.codcliente = :codcliente")
    , @NamedQuery(name = "Factura.findByTotalventa", query = "SELECT f FROM Factura f WHERE f.totalventa = :totalventa")
    , @NamedQuery(name = "Factura.findByFecharegistro", query = "SELECT f FROM Factura f WHERE f.fecharegistro = :fecharegistro")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODFACTURA")
    private BigDecimal codfactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMEROFACTURA")
    private String numerofactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODVENDEDOR")
    private BigInteger codvendedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCLIENTE")
    private BigInteger codcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TOTALVENTA")
    private String totalventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;

    public Factura() {
    }

    public Factura(BigDecimal codfactura) {
        this.codfactura = codfactura;
    }

    public Factura(BigDecimal codfactura, String numerofactura, BigInteger codvendedor, BigInteger codcliente, String totalventa, Date fecharegistro) {
        this.codfactura = codfactura;
        this.numerofactura = numerofactura;
        this.codvendedor = codvendedor;
        this.codcliente = codcliente;
        this.totalventa = totalventa;
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getCodfactura() {
        return codfactura;
    }

    public void setCodfactura(BigDecimal codfactura) {
        this.codfactura = codfactura;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public BigInteger getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(BigInteger codvendedor) {
        this.codvendedor = codvendedor;
    }

    public BigInteger getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(BigInteger codcliente) {
        this.codcliente = codcliente;
    }

    public String getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(String totalventa) {
        this.totalventa = totalventa;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfactura != null ? codfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codfactura == null && other.codfactura != null) || (this.codfactura != null && !this.codfactura.equals(other.codfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Factura[ codfactura=" + codfactura + " ]";
    }
    
}
