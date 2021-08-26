/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Vendedor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.VendedorFacade;

/**
 *
 * @author jailu
 */
@Named(value = "empleadoController")
@SessionScoped
public class empleadoController implements Serializable {

    @EJB
    private VendedorFacade vendedorFacade;
    private Vendedor vendedor;
    /**
     * Creates a new instance of empleadoController
     */
    public empleadoController() {
        this.vendedor= new Vendedor();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
     //Metodo para listar Alumnos
    public List<Vendedor> listaTodosVendedores(){
        return vendedorFacade.findAll();
    }
    
    public String addVendedor(){
        vendedorFacade.create(vendedor);
        this.vendedor=new Vendedor();
        return "/index";
    }
    
    
    
    public String prepareEditVendedor(Vendedor a){
        this.vendedor=a;
        return "edit";
    }
      
    
    public String editVendedor(){
        this.vendedorFacade.edit(vendedor);
        this.vendedor=new Vendedor();
        return "index";
    }
    
    public void deleteVendedor(Vendedor a){
        this.vendedorFacade.remove(a);
    }
    
    
    
}
