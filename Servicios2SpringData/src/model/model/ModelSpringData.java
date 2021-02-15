package model.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dominio.Cliente;
import dominio.Servicio;
import model.data.ClienteRepositorio;
import model.data.ServicioRepositorio;
import model.modelInterface.ModeloInterface;

@Service
public class ModelSpringData implements ModeloInterface {
	
	@Autowired
	private ClienteRepositorio clientes;
	@Autowired
	private ServicioRepositorio servicios;
	
	

	@Override
	public boolean altaCliente(Cliente c) {
		// TODO Auto-generated method stub
		return clientes.save(c) != null ;
	}

	@Override
	public boolean altaServicio(Servicio s) {
		// TODO Auto-generated method stub
		return servicios.save(s) != null;
	}

	@Override
	public void bajaCliente(Cliente c) {
		// TODO Auto-generated method stub
		clientes.delete(c);
	}

	@Override
	public void bajaServicio(Servicio s) {
		servicios.delete(s);
	}

	@Override
	public List<Cliente> todosClientes() {
		
		
		return (List<Cliente>) clientes.findAll();
	}

	@Override
	public List<Servicio> todosServicios() {
		return (List<Servicio>) servicios.findAll();
	}

	@Override
	public Iterable<Cliente> paginaVariableCliente(int nPagina,int nElementos) {
		PageRequest page=new PageRequest(nPagina,nElementos);
		Iterable<Cliente> res=clientes.findAll(page);
		return res ;
	}

	@Override
	public List<Cliente> buscaClientePorNombre(String nombre) {
		// TODO Auto-generated method stub
		return clientes.findByNombreIgnoreCase(nombre);
	}

	@Override
	public List<Cliente> buscaClientePorNombreYEmail(String nombre, String email) {
		// TODO Auto-generated method stub
		return clientes.findByNombreIgnoreCaseAndEmailIgnoreCase(nombre, email);
	}

	@Override
	public Page<Cliente> paginaCliente(int nPagina, int nElementos) {
		PageRequest page=new PageRequest(nPagina,nElementos);
		
		return clientes.findAll(page);
	}

	@Override
	public List<Cliente> paginaConBusquedaPorNombreYEmail(String nombre, String email,int nPagina) {
		
		PageRequest page=new PageRequest(nPagina,10);
		Iterable<Cliente> res=clientes.findAll(page);
		List<Cliente> lC=new ArrayList<>();
		for(Cliente c: res) {
			if(c.getNombre().equalsIgnoreCase(nombre)&& c.getEmail().equalsIgnoreCase(email)) {
				lC.add(c);
			}
		}
		return lC;
	}

	@Override
	public List<Cliente> paginaConBusquedaPorNombreOEmail(String nombre, String email,int nPagina) {
		PageRequest page=new PageRequest(nPagina,10);
		Iterable<Cliente> res=clientes.findAll(page);
		List<Cliente> lC=new ArrayList<>();
		for(Cliente c: res) {
			if(c.getNombre().equalsIgnoreCase(nombre)|| c.getEmail().equalsIgnoreCase(email)) {
				lC.add(c);
			}
		}
	
		return lC;
	}

	@Override
	public List<Cliente> busquedaDeClientesPorNombreEmpiezaAndProvincia(String nombre, String provincia) {
		// TODO Auto-generated method stub
		return clientes.findByNombreEmpiezaAndProvinciaEmpieza(nombre, provincia);
	}

	@Override
	public List<Cliente> filtradoDeClienteCuyoIdSeaMayorDeCincuenta(String nombre, String provincia) {
	return this.busquedaDeClientesPorNombreEmpiezaAndProvincia(nombre, provincia). stream().filter(p -> p.getIdCliente() > 190).collect(Collectors.toList());
	}

	@Override
	public List<Cliente> busquedaDeClientePorNombreEmpiezaConAndEmail(String nombre, String email) {
		// TODO Auto-generated method stub
		return clientes.findByNombreStartingWithAndEmailStartingWith(nombre, email);
	}

	@Override
	public List<Cliente> busquedaDeClientePorNombreEmpiezaConAndEmailContieneAndOrdenacionPorAscendente(String nombre,
			String email) {
		// TODO Auto-generated method stub
		return clientes.findByNombreStartingWithAndEmailContainingOrderByProvinciaAsc(nombre, email);
	}

	@Override
	public List<Servicio> busquedaDeServicioEntreFechaInicioAndFinalOrdenacionPorDescripcion(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		// TODO Auto-generated method stub
		return servicios.findAllByFechaBetweenOrderByDescripcionDesc(fechaInicio, fechaFin);
	}

	@Override
	public List<Servicio> busquedaDeServicioDespuesDeUnaFecha(GregorianCalendar fecha1) {
		// TODO Auto-generated method stub
		return servicios.findByFechaAfter(fecha1);
	}

	@Override
	public List<Servicio> busquedaDeServicioMenorQueUnDineroOrAntesDeUnaFecha(Double precio, GregorianCalendar fecha) {
		// TODO Auto-generated method stub
		return servicios.findByImporteLessThanOrFechaBefore(precio, fecha);	}

	@Override
	public List<Servicio> busquedaDeServicioCuyoPrecioEsMayor(Double price) {
		// TODO Auto-generated method stub
		return servicios.findByImporteGreaterThan(price);
	}


	
	
	

}
