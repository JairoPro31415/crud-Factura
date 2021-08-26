/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Cliente;
import entities.Vendedor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import model.ClienteFacade;

/**
 *
 * @author jailu
 */
@Named(value = "clienteController")
@SessionScoped
public class clienteController implements Serializable {

    @EJB
    private ClienteFacade clienteFacade;
    private Cliente cliente;
    private BigDecimal codCliente;
    private List<Cliente> listaClientes;
    private List<SelectItem> listClientes;
    /**
     * Creates a new instance of clienteController
     */
    
    public clienteController() {
        this.cliente=new Cliente();
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<SelectItem> getListClientes() {
        this.listClientes= new ArrayList<SelectItem>();
        List<Cliente> c= listaTodosClientes();
        listClientes.clear();
        for (Cliente cli: c) {
            SelectItem clienteItem= new SelectItem(cli.getCodcliente(), cli.getNombre());
            this.listClientes.add(clienteItem);
        }
        return listClientes;
    }
    
    
    
    public List<Cliente> listaTodosClientes(){
     
        return clienteFacade.findAll();
    }
    
    public String addCliente(){
        clienteFacade.create(cliente);
        this.cliente=new Cliente();
        return "/index";
    }
    
    
    
    public String prepareEditCliente(Cliente a){
        this.cliente=a;
        return "edit";
    }
      
    
    public String editCliente(){
        this.clienteFacade.edit(cliente);
        this.cliente=new Cliente();
        return "index";
    }
    
    public void deleteCliente(Cliente a){
        this.clienteFacade.remove(a);
    }
    
    public void obtenerClientePorCodigo(Cliente c){
        Object o= (Object)c.getCodcliente();
        this.cliente=clienteFacade.find(o);
    }
    
    public void probando(){
       
        this.codCliente=null;
        BigDecimal codCliente=this.cliente.getCodcliente();
        System.out.println(cliente.getCodcliente()+"EEE");
        this.cliente=this.clienteFacade.find(codCliente);
       
       
    }
    
  
    
}
