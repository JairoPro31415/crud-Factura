/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Producto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import model.ProductoFacade;

/**
 *
 * @author jailu
 */
@Named(value = "productoController")
@SessionScoped
public class productoController implements Serializable {

    @EJB
    private ProductoFacade productoFacade;
    private Producto producto;
    private List<SelectItem> listProductos;
    /**
     * Creates a new instance of productoController
     */
    
    
    public productoController() {
        this.producto= new Producto();
    }

    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<SelectItem> getListProductos() {
        this.listProductos= new ArrayList<SelectItem>();
        List<Producto> c= listaTodosProductos();
        listProductos.clear();
        for (Producto pro: c) {
            SelectItem clienteItem= new SelectItem(pro.getCodproducto(), pro.getNombre());
            this.listProductos.add(clienteItem);
        }
        return listProductos;
      
    }
    
    
    
    public List<Producto> listaTodosProductos(){
        return productoFacade.findAll();
    }
    
    public String addProducto(){
        productoFacade.create(producto);
        this.producto=new Producto();
        return "/index";
    }
    
    
    
    public String prepareEditProducto(Producto a){
        this.producto=a;
        return "edit";
    }
      
    
    public String editProducto(){
        this.productoFacade.edit(producto);
        this.producto=new Producto();
        return "index";
    }
    
    public void deleteProducto(Producto a){
        this.productoFacade.remove(a);
    }
    
    
}
