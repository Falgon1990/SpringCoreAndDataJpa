package pfc.modelo.Modelo;

import java.util.List;

import pfc.modelo.DaoInterface.ClienteDAOInterface;
import pfc.modelo.DaoInterface.ServicioDAOInterface;
import pfc.modelo.Modelo.*;
import pfc.modelo.ModeloInterface.ModeloInterface;
import pfc.dominio.Cliente;
import pfc.dominio.Servicio;

public class ModeloSpringJpa implements ModeloInterface{
	
	private ClienteDAOInterface  clientes;
	 private ServicioDAOInterface servicios;
		
	
	 
	 
	public void setClientes(ClienteDAOInterface clientes) {
			this.clientes = clientes;
		}
	public void setServicios(ServicioDAOInterface servicios) {
			this.servicios = servicios;
		}

	@Override
	public Cliente altaC(Cliente c) { return clientes.altaC(c);}
	@Override
	public Servicio altaS(Servicio s) {return servicios.altaS(s);
	}
	@Override
	public boolean bajaS(int idServicio) {
		return servicios.bajaS(idServicio);
	}
	@Override
	public boolean bajaC(int idCliente) {
		return clientes.bajaC(idCliente);
	}
	@Override
	public boolean modificacionC(Cliente c) {
		return clientes.modificacionC(c);
	}
	@Override
	public boolean modificacionS(Servicio s) {
		return servicios.modificacionS(s);
	}
	@Override
	public Cliente consultaC(int idCliente) {
	return clientes.consultaC(idCliente);
	}
	@Override
	public Servicio consultaS(int idServicio) {
	return servicios.consultaS(idServicio);
	}
	@Override
	public List<Servicio> consultaAllS() {
		// TODO Auto-generated method stub
		return servicios.consultaAllS();
	}
	@Override
	public List<Cliente> consultaAllC() {
		// TODO Auto-generated method stub
		return clientes.consultaAllC();
	}
	
	
	
}
