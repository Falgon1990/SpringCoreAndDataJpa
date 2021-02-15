package model.modelInterface;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.domain.Page;

import dominio.Cliente;
import dominio.Servicio;

public interface ModeloInterface {

	boolean altaCliente(Cliente c);
	boolean altaServicio(Servicio s);
	//Baja de cliente 
	void bajaCliente(Cliente c);
	void bajaServicio(Servicio s);
	//Consulta de todos los clientes
	List<Cliente> todosClientes();
	List<Servicio> todosServicios();
	
//Un pequeño metodo de paginacion
	Iterable<Cliente> paginaVariableCliente(int nPagina,int nElementos);
Page<Cliente> paginaCliente(int nPagina,int nElementos);
	
//Metodos de spring de data por busca especial
List<Cliente> buscaClientePorNombre(String nombre);
List<Cliente> buscaClientePorNombreYEmail(String nombre,String email);

//Combinacion de metodos entre paginacion y busqueda por nombre
List<Cliente> paginaConBusquedaPorNombreYEmail(String nombre,String email,int nPagina);
List<Cliente> paginaConBusquedaPorNombreOEmail(String nombre,String email,int nPagina);

//Consultas  personalizadas 
List<Cliente> busquedaDeClientesPorNombreEmpiezaAndProvincia(String nombre,String provincia);
List<Cliente> filtradoDeClienteCuyoIdSeaMayorDeCincuenta( String nombre,String provincia);
//Consultas personalizada pero con Spring
List<Cliente> busquedaDeClientePorNombreEmpiezaConAndEmail(String nombre,String email);
List<Cliente> busquedaDeClientePorNombreEmpiezaConAndEmailContieneAndOrdenacionPorAscendente(String nombre,String email);
////Consultas  personalizadad con Spring pero con servicios
List<Servicio> busquedaDeServicioEntreFechaInicioAndFinalOrdenacionPorDescripcion(GregorianCalendar fechaInicio,GregorianCalendar fechaFin);
List<Servicio> busquedaDeServicioDespuesDeUnaFecha(GregorianCalendar fecha1);
List<Servicio> busquedaDeServicioMenorQueUnDineroOrAntesDeUnaFecha(Double precio,GregorianCalendar fecha);
List<Servicio> busquedaDeServicioCuyoPrecioEsMayor(Double price);


}
