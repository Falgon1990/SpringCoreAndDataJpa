package com.clase.spring.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.clase.spring.dominio.Cliente;
import com.clase.spring.dominio.Servicio;
import com.clase.spring.modelo.modelo.Modelo;

public class Controlador implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Modelo modelo;
/**Admin*/
private Cliente cliente;
private ArrayList<Cliente> clientes;
/**Login*/
private String password;
private String nombre;
private String lgn;
/**Usuario*/
private ArrayList<Servicio> servicios;
/**Comprobacion*/



public Modelo getModelo() {return modelo;}
public void setModelo(Modelo modelo) {this.modelo = modelo;}


public Controlador() {
	cliente=new Cliente();
	
}

/**
 * Metodos del administrador
 */

public void actualizaListaClientes() {
this.clientes=(ArrayList<Cliente>) this.getModelo().allClientes();
 
}

	
public void seleccionar(Cliente c) {
	this.cliente=c;
	this.modelo.modificaCliente(cliente);
}
/**Metodos de login*/
//public String registroCliente() {
//   cliente.setRol("ROLE_USER");
//   modelo.altaCliente(cliente);
//   return "pLogin.xhtml?faces-redirect=true";
//}

public String login() {
	 FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext extenalContext = facesContext.getExternalContext();
	    RequestDispatcher dispatcher = ((ServletRequest)extenalContext.getRequest()).getRequestDispatcher("/j_spring_security_check");
	    
	    try {dispatcher.forward((ServletRequest)extenalContext.getRequest(), (ServletResponse)extenalContext.getResponse());} 
	    catch (ServletException | IOException e) {e.printStackTrace();}
	    
	    facesContext.responseComplete();
	    return null;
}

/**Getters And Setters*/
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public ArrayList<Cliente> getClientes() {
	return clientes;
}
public void setClientes(ArrayList<Cliente> clientes) {
	this.clientes = clientes;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getLgn() {
	return lgn;
}
public void setLgn(String lgn) {
	this.lgn = lgn;
}
public ArrayList<Servicio> getServicios() {
	return servicios;
}
public void setServicios(ArrayList<Servicio> servicios) {
	this.servicios = servicios;
}






}
