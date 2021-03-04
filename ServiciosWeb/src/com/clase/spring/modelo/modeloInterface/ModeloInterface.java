package com.clase.spring.modelo.modeloInterface;

import java.util.List;

import com.clase.spring.dominio.Cliente;
import com.clase.spring.dominio.Servicio;

public interface ModeloInterface {

	boolean altaCliente(Cliente c);
	void bajaCliente(int idCliente);
	void modificaCliente(Cliente c);
	Cliente consultaCliente(int id);
List<Cliente> allClientes();
	
	boolean altaServicio(Servicio s);
	void bajaServicio(int idServicio);
	void modificaServicio(Servicio s);
	Servicio consultaServicio(int id);
//	List<Servicio> allServicios();
}
