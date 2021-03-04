package com.clase.spring.modelo.modelo;

import java.util.List;

import com.clase.spring.dominio.Cliente;
import com.clase.spring.dominio.Servicio;
import com.clase.spring.modelo.data.ClienteRepositorio;
import com.clase.spring.modelo.data.ServicioRepositorio;
import com.clase.spring.modelo.modeloInterface.ModeloInterface;

public class Modelo implements ModeloInterface{

	private ClienteRepositorio clienteRepositorio;
	private ServicioRepositorio servicioRepositorio;
	
	
	
	
	@Override
	public boolean altaCliente(Cliente c) {
		// TODO Auto-generated method stub
		return this.clienteRepositorio.save(c) != null;
	}

	@Override
	public void bajaCliente(int idCliente) {
		// TODO Auto-generated method stub
		this.clienteRepositorio.delete(idCliente);
	}

	@Override
	public void modificaCliente(Cliente c) {
		this.clienteRepositorio.save(c);
	}

	@Override
	public Cliente consultaCliente(int id) {
		// TODO Auto-generated method stub
		return this.clienteRepositorio.findOne(id);
	}

	@Override
	public boolean altaServicio(Servicio s) {
		// TODO Auto-generated method stub
		return this.servicioRepositorio.save(s) != null;
	}

	@Override
	public void bajaServicio(int idServicio) {
		this.servicioRepositorio.delete(idServicio);
	}
	

	@Override
	public void modificaServicio(Servicio s) {
		this.servicioRepositorio.save(s);
	}

	@Override
	public Servicio consultaServicio(int id) {
		// TODO Auto-generated method stub
		return this.servicioRepositorio.findOne(id); 
	}

	public ClienteRepositorio getClienteRepositorio() {
		return clienteRepositorio;
	}

	public void setClienteRepositorio(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}

	public ServicioRepositorio getServicioRepositorio() {
		return servicioRepositorio;
	}

	public void setServicioRepositorio(ServicioRepositorio servicioRepositorio) {
		this.servicioRepositorio = servicioRepositorio;
	}

	@Override
	public List<Cliente> allClientes() {
		// TODO Auto-generated method stub
		return this.clienteRepositorio.allClientes();
	}
//
//	@Override
//	public List<Servicio> allServicios() {
//		// TODO Auto-generated method stub
//		return this.servicioRepositorio.findAll();
//	}
	
	

}
