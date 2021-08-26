/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jailu
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodproducto", query = "SELECT p FROM Producto p WHERE p.codproducto = :codproducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByStockminimo", query = "SELECT p FROM Producto p WHERE p.stockminimo = :stockminimo")
    , @NamedQuery(name = "Producto.findByStockactual", query = "SELECT p FROM Producto p WHERE p.stockactual = :stockactual")
    , @NamedQuery(name = "Producto.findByCodigobarra", query = "SELECT p FROM Producto p WHERE p.codigobarra = :codigobarra")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPRODUCTO")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto")
   @SequenceGenerator(name = "seq_producto", sequenceName = "INCREMENTO_COD_PRODUCTO", allocationSize = 1)
  
    private BigDecimal codproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRECIO")
    private String precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STOCKMINIMO")
    private BigInteger stockminimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STOCKACTUAL")
    private BigInteger stockactual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODIGOBARRA")
    private String codigobarra;

    public Producto() {
    }

    public Producto(BigDecimal codproducto) {
        this.codproducto = codproducto;
    }

    public Producto(BigDecimal codproducto, String nombre, String precio, BigInteger stockminimo, BigInteger stockactual, String codigobarra) {
        this.codproducto = codproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stockminimo = stockminimo;
        this.stockactual = stockactual;
        this.codigobarra = codigobarra;
    }

    public BigDecimal getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(BigDecimal codproducto) {
        this.codproducto = codproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public BigInteger getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(BigInteger stockminimo) {
        this.stockminimo = stockminimo;
    }

    public BigInteger getStockactual() {
        return stockactual;
    }

    public void setStockactual(BigInteger stockactual) {
        this.stockactual = stockactual;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproducto != null ? codproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codproducto == null && other.codproducto != null) || (this.codproducto != null && !this.codproducto.equals(other.codproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Producto[ codproducto=" + codproducto + " ]";
    }
    
}
