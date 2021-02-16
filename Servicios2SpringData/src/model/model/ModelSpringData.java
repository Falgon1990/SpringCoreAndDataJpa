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
/**
*Indicamos con el estereotipo @Service que esta clase va albergar la logica de negocio,
*Centralizamos toda la parte de acceso a datos en un unico modelo , para que luego sea mas comodo utilzar los metodos 
* de ambos repositorios.
*/
@Service
public class ModelSpringData implements ModeloInterface {
	/**
	*
	*Autoinyectamos los objetos de lo repositorios por medio de la intefaz , si hubiera mas clases
	*que implementase esta interfaz , produciria una exception , debido a que no sabria cual bean inyectar ,
	* se podria modificar este comportamiento para evitar esa exception pues poniendo un Qualifier,o Primary.
	*Puesto que el autoinyectado lo realizamos en ela propiedad no es necesario tener los setter.
	*/
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
	/**
	*Aqui vamos a utilizar paginacion con un metodo que nos permite devolver una pagina en concreto , con un numero de elementos
	* determinado , devolvera un tipo iterable ,crearemos una instancia de pageRequest que implementa la interfaz pageable.
	*/
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
	/**
	*
	*Aunque si bien es cierto que en el principal no esta probado este metodo, si que lo he dejado implementado 
	* para probarlo en un futuro , si vosotros quereis probarlo e mirar su funcionamiento ,o corregirlo  o mejorarlo
	* podeis.
	**/
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
	/**
	*
	*Si bien el resto de metodos no los comento bueno por que no tienen ninguna caracteristica especial , este si porque cogiendo 
	*una metodo declarado , podemos modificarlo pues ya sea agrupandolo, filtrandolo ... en mi caso lo realizo con java 8
	* convirtiendo el arrayList en un stream(un Stream es un flujo de datos) de clientes , cuya flitracion sera de id del mismo a partir de 190 ,
	*es una errataa en el nombre del metodo , recolectamos los datos del stream y lo reconvertimos de nuevo en un lista.
	*/
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
