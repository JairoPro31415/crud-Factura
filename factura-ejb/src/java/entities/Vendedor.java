/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VENDEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByCodvendedor", query = "SELECT v FROM Vendedor v WHERE v.codvendedor = :codvendedor")
    , @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vendedor.findByApellidos", query = "SELECT v FROM Vendedor v WHERE v.apellidos = :apellidos")
    , @NamedQuery(name = "Vendedor.findByDni", query = "SELECT v FROM Vendedor v WHERE v.dni = :dni")
    , @NamedQuery(name = "Vendedor.findByCelular", query = "SELECT v FROM Vendedor v WHERE v.celular = :celular")
    , @NamedQuery(name = "Vendedor.findByDireccion", query = "SELECT v FROM Vendedor v WHERE v.direccion = :direccion")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODVENDEDOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alumno")
    @SequenceGenerator(name = "seq_alumno", sequenceName = "INCREMENTO_ID_VENDEDOR", allocationSize = 1)
   
    private BigDecimal codvendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CELULAR")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DIRECCION")
    private String direccion;

    public Vendedor() {
    }

    public Vendedor(BigDecimal codvendedor) {
        this.codvendedor = codvendedor;
    }

    public Vendedor(BigDecimal codvendedor, String nombre, String apellidos, String dni, String celular, String direccion) {
        this.codvendedor = codvendedor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.celular = celular;
        this.direccion = direccion;
    }

    public BigDecimal getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(BigDecimal codvendedor) {
        this.codvendedor = codvendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvendedor != null ? codvendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codvendedor == null && other.codvendedor != null) || (this.codvendedor != null && !this.codvendedor.equals(other.codvendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vendedor[ codvendedor=" + codvendedor + " ]";
    }
    
}
