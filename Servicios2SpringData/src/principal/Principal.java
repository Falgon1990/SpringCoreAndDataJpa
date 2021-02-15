package principal;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;

import configuracion.Configuracion;
import dominio.Cliente;
import dominio.Servicio;
import model.model.ModelSpringData;
import model.modelInterface.ModeloInterface;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		ModeloInterface modelo = contexto.getBean(ModelSpringData.class);
//	for(Cliente c : modelo.todosClientes() ) {
//	modelo.bajaCliente(c);
//	}
//	
//	for(Servicio s : modelo.todosServicios() ) {
//	modelo.bajaServicio(s);
//	}
	
		Cliente cliente1 = new Cliente("Murcia",  "Juan@prueba.com","Juan");
	
	
//		Cliente auxCliente = new Cliente();
//
//		Cliente cliente1 = new Cliente("Murcia",  "Juan@prueba.com","Juan");
//		Cliente cliente2 = new Cliente ("Alicante","Pedro@prueba.com","Pedro" );
//		Cliente cliente3 = new Cliente( "Madrid","Luis@prueba.com","Luis" );
//		Cliente cliente4 = new Cliente( "Galicia","Juan@prueba.com","Juan" );
//		Cliente cliente5 = new Cliente( "Alava","Juan@prueba.com","Juan" );
//		Cliente cliente6 = new Cliente( "Alava","MariaJose@prueba.com","Jose" );

//		
//		System.out.println();
//		System.out.println("Alta de clientes en proceso");		
//		
//		System.out.println( modelo.altaCliente(cliente1));
//		System.out.println( modelo.altaCliente(cliente2));
//		System.out.println( modelo.altaCliente(cliente3));
//	    System.out.println(modelo.altaCliente(cliente4));
//	    System.out.println(modelo.altaCliente(cliente5));
//	    System.out.println(modelo.altaCliente(cliente6));
//		     
	   System.out.println("Metodo de paginacion en la pagina numero 1");	
	
		Iterable<Cliente> res = modelo.paginaVariableCliente(1,5);
		
		for(Cliente t: res){
		     System.out.println(t);
		  }	
		
		System.out.println("\nMetodos de busqueda por nombre\n");
		for(Cliente c:modelo.buscaClientePorNombre("Juan")) {
			System.out.println(c);
		}
		
		
		System.out.println("\nMetodo de paginacion en la pagina numero 2\n");
		Page<Cliente> paginaCliente= modelo.paginaCliente(2, 5);
	for(Cliente c :	paginaCliente.getContent()	) {
		System.out.println(c);
	}
	
	System.out.println("\nPaginacion total\n ");
	for(int i=0;i<paginaCliente.getTotalPages();i++) {
		Page<Cliente> paginaCliente1= modelo.paginaCliente(i, 5);
		for(Cliente c :	paginaCliente1.getContent()	) {
			System.out.println(c);
			
		}
	System.out.println("Pagina " + i);
	}

	
	System.out.println("\nBusqueda de clientes por letra que empieza y provincia que empieza\n ");
	
   List<Cliente> c=modelo.busquedaDeClientesPorNombreEmpiezaAndProvincia("j", "m");
  c.forEach(System.out::println);

	System.out.println("\nBusqueda de clientes por letra que empieza y provincia y su id sea mayor de  de 50 \n");
	
c=modelo.filtradoDeClienteCuyoIdSeaMayorDeCincuenta("j", "m");
c.forEach(System.out::println);
	
System.out.println("\nBusqueda de clientes por Nombre y Email\n");
c=modelo.busquedaDeClientePorNombreEmpiezaConAndEmail("j", "j");
c.stream().forEach(System.out::println);
System.out.println("\n\n");

System.out.println("\n Busqueda de clientes por Nombre y Email por Ordenacion Ascendente \n ");
c=modelo.busquedaDeClientePorNombreEmpiezaConAndEmailContieneAndOrdenacionPorAscendente("j", "j");
c.stream().forEach(System.out::println);


	
Calendar fecha1 = new GregorianCalendar(1990, 1, 6);
Calendar fecha2 = new GregorianCalendar(1940, 5, 7);
Calendar fecha3 = new GregorianCalendar(1977, 2, 26);

//Servicio servicio1 = new Servicio("Renta",fecha1,150, cliente1);
//Servicio servicio2 = new Servicio("Gestion bancaria",fecha2,1222, cliente2);
//	Servicio servicio3 = new Servicio("Gestion Fiscal",fecha3,900, cliente3);
//	Servicio servicio4 = new Servicio("Gestion bancaria",fecha1,1222, cliente1);
//	
//System.out.println(	modelo.altaServicio(servicio1));
//System.out.println(	modelo.altaServicio(servicio2));
//System.out.println(	modelo.altaServicio(servicio3));
//System.out.println(	modelo.altaServicio(servicio4));


/**
 * Algunos de metodos de busqueda con valores numeros, propios de spring data .
 */ 
System.out.println("\n Busqueda de Servicios entre dos Fechas cuya ordenacion es por descripcion de tipo descendentes\n");
List<Servicio> lS=modelo.busquedaDeServicioEntreFechaInicioAndFinalOrdenacionPorDescripcion(new GregorianCalendar(1977,1,6),new GregorianCalendar(1990,2,6));
lS.stream().forEach(System.out::println);
System.out.println("\n\nLista de servicio con precio es superior a 150 \n ");
List<Servicio> ls=modelo.busquedaDeServicioCuyoPrecioEsMayor(150.0);
ls.forEach(System.out::println);


System.out.println("\n Busqueda de servicios despues de una fecha \n");
ls=modelo.busquedaDeServicioDespuesDeUnaFecha(new GregorianCalendar(1967,6,2));
ls.forEach(System.out::println);
System.out.println("\n Filtrado por importe obteniendo la descripcion utilizando java 8 ");
ls.stream().filter(p -> p.getImporte() > 150.00).map(p -> p.getDescripcion()).forEach(System.out::println);

System.out.println("\n Busqueda de servicios si es menor que un importe o antes de una fecha");
ls=modelo.busquedaDeServicioMenorQueUnDineroOrAntesDeUnaFecha(899.0, new GregorianCalendar(1976,6,2));
ls.forEach(System.out::println);




		((AnnotationConfigApplicationContext) contexto).close();
		

		

		
	}

}
