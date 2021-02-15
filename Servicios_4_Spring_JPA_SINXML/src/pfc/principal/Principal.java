package pfc.principal;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pfc.configuracion.Configuracion;
import pfc.dominio.Cliente;
import pfc.dominio.Servicio;
import pfc.modelo.Modelo.ModeloSpringJpa;
import pfc.modelo.ModeloInterface.ModeloInterface;



public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto= new AnnotationConfigApplicationContext(Configuracion.class);
		ModeloInterface modelo= contexto.getBean(ModeloSpringJpa.class);
		
		
		// Borramos todos los clientes en la tabla clientes
			
		
			// Borramos todos los servicios en la tabla servicios
			for (Servicio s : modelo.consultaAllS()) {
				System.out.println(modelo.bajaS(s.getIdServicio()));
			}

			
		for (Cliente c : modelo.consultaAllC()) {
				System.out.println(modelo.bajaC(c.getIdCliente()));
			}
			// Creacion de Clientes y alta
			Cliente auxCliente = new Cliente();

			Cliente cliente1 = new Cliente("Murcia",  "Juan@prueba.com","Juan");
			Cliente cliente2 = new Cliente ("Alicante","Pedro@prueba.com","Pedro" );
			Cliente cliente3 = new Cliente( "Madrid","Luis@prueba.com","Luis" );
			int idC1;
			int idC2;
			int idC3;

			
			System.out.println();
			System.out.println("Alta de clientes en proceso");		
			
			 cliente1 = modelo.altaC(cliente1);
			idC1 = cliente1.getIdCliente();
			
			cliente2 = modelo.altaC(cliente2);
		idC2 = cliente2.getIdCliente();
			
			cliente3 = modelo.altaC(cliente3);
			idC3 = cliente3.getIdCliente();
			
			
			System.out.println("Registrado " + "Juan " + "con el id " + idC1);
			System.out.println("Registrado " + "Pedro " + "con el id " + idC2);
			System.out.println("Registrado " + "Luis " + "con el id " + idC3);
			
			
			System.out.println();

		// Creacion de servicios y alta
			Calendar fecha1 = new GregorianCalendar(1990, 1, 6);
			Calendar fecha2 = new GregorianCalendar(1940, 5, 7);
			Calendar fecha3 = new GregorianCalendar(1977, 2, 26);
			
	Servicio auxServicio = new Servicio();
			
			Servicio servicio1 = new Servicio("Renta",fecha1,150, cliente1);
		Servicio servicio2 = new Servicio("Gestion bancaria",fecha2,1222, cliente2);
			Servicio servicio3 = new Servicio("Gestion Fiscal",fecha3,900, cliente3);
			Servicio servicio4 = new Servicio("Gestion bancaria",fecha2,1222, cliente1);
			
		int idS1;
			int idS2;
			int idS3;
			
			
			System.out.println();
			System.out.println("Registro de servicios en proceso");		
			
			
			servicio1=modelo.altaS(servicio1);
			
		servicio2 = modelo.altaS(servicio2);
			
		
			idS1 = servicio1.getIdServicio();
			
			
			idS2 = servicio2.getIdServicio();
			
			servicio3 = modelo.altaS(servicio3);
			idS3 = servicio3.getIdServicio();
			
			
			System.out.println("Registrado " + "Renta " + "con el id " + idS1);
			System.out.println("Registrado " + "Gestion bancaria " + "con el id " + idS2);
			System.out.println("Registrado " + "Gestion Fiscal " + "con el id " + idS3);
			
			servicio1 = modelo.altaS(servicio4);
			idS1 = servicio1.getIdServicio();
			
		System.out.println("Registrado " + "Gestion bancaria " + "con el id " + idS1);
			
			System.out.println();
		
			
			// Prueba de metodos de Cliente
			
			System.out.println("Lista de clientes con servicios");
			for (Cliente c : modelo.consultaAllC())
				System.out.println(c);

			/*	for (Cliente c : modelo.consultaAllC()) {
			    System.out.println( "["+"Con nombre" +c.getNombre() +",Email " + c.getEmail()+",Provincia "+ c.getProvincia() +"]");
				for(Servicio s: c.getServicios() ) {
					System.out.println("Id de servicio "+s.getIdServicio() + ",nombre del servicio " + s.getDescripcion() + ", fecha del servicio " + s.getFecha() + " y su cliente es " +"["+"Con nombre" +s.getCliente().getNombre() +",Email " + s.getCliente().getEmail()+",Provincia "+ s.getCliente().getProvincia() + "id de cliente "+ s.getCliente().getIdCliente()+"]");
					
				}
				}
*/
			System.out.println();
			System.out.println("Baja de juan en proceso");	
			modelo.bajaC(idC1);
			
			System.out.println();
			System.out.println("Lista de clientes con servicios");
			for (Cliente c : modelo.consultaAllC())
				System.out.println(c);
			/*for (Cliente c : modelo.consultaAllC()) {
		    System.out.println( "["+"Con nombre" +c.getNombre() +",Email " + c.getEmail()+",Provincia "+ c.getProvincia() +"]");
			for(Servicio s: c.getServicios() ) {
				System.out.println("Id de servicio "+s.getIdServicio() + ",nombre del servicio " + s.getDescripcion() + ", fecha del servicio " + s.getFecha() + " y su cliente es " +"["+"Con nombre" +s.getCliente().getNombre() +",Email " + s.getCliente().getEmail()+",Provincia "+ s.getCliente().getProvincia() + "id de cliente "+ s.getCliente().getIdCliente()+"]");
				
			}
			}*/
		
			System.out.println();
			System.out.println("Modificación de pedro en proceso");		
			auxCliente = modelo.consultaC(idC2);
			auxCliente.setNombre("Pedro Zamora Zamora");
			modelo.modificacionC(auxCliente);
				
			System.out.println();
			System.out.println("Lista de clientes con servicios");
			
			for (Cliente c : modelo.consultaAllC()) 
				System.out.println(c);
			/*for (Cliente c : modelo.consultaAllC()) {
			    System.out.println( "["+"Con nombre" +c.getNombre() +",Email " + c.getEmail()+",Provincia "+ c.getProvincia() +"]");
				for(Servicio s: c.getServicios() ) {
					System.out.println("Id de servicio "+s.getIdServicio() + ",nombre del servicio " + s.getDescripcion() + ", fecha del servicio " + s.getFecha() + " y su cliente es " +"["+"Con nombre" +s.getCliente().getNombre() +",Email " + s.getCliente().getEmail()+",Provincia "+ s.getCliente().getProvincia() +"]");
					
				}
				}
			*/
			// Prueba metodos Servicio

		
			System.out.println("Lista de servicios con clientes");
			for (Servicio s : modelo.consultaAllS())
				System.out.println(s);
			/*for (Servicio s : modelo.consultaAllS())
			System.out.println("Id de servicio "+s.getIdServicio() + ",nombre del servicio " + s.getDescripcion() + ", fecha del servicio " + s.getFecha() + " y su cliente es " +"["+"Con nombre" +s.getCliente().getNombre() +",Email " + s.getCliente().getEmail()+",Provincia "+ s.getCliente().getProvincia() +"]");
			*/

			System.out.println();
			System.out.println("Baja de servicio 3");	
			modelo.bajaS(idS3);
			
			System.out.println();
			System.out.println("Lista de servicios con clientes");
			for (Servicio s : modelo.consultaAllS())
				System.out.println(s);
			
			/*	for (Servicio s : modelo.consultaAllS())
				System.out.println("Id de servicio "+s.getIdServicio() + ",nombre del servicio " + s.getDescripcion() + ", fecha del servicio " + s.getFecha() + " y su cliente es " +"["+"Con nombre" +s.getCliente().getNombre() +",Email " + s.getCliente().getEmail()+",Provincia "+ s.getCliente().getProvincia() +"]");
		*/
			System.out.println();
			System.out.println("Modificación de servicio Gestion");		
			auxServicio =modelo.consultaS(idS2);
			auxServicio.setDescripcion("Gestion empresarial");
			modelo.modificacionS(auxServicio);
				
			System.out.println();
			System.out.println("Lista de servicios con clientes");
			for (Servicio s : modelo.consultaAllS())
				System.out.println(s);
			
			/*for (Servicio s : modelo.consultaAllS())
			System.out.println("Id de servicio "+s.getIdServicio() + ",nombre del servicio " + s.getDescripcion() + ", fecha del servicio " + s.getFecha() + " y su cliente es " + "["+"Con nombre" +s.getCliente().getNombre() +",Email " + s.getCliente().getEmail()+",Provincia "+ s.getCliente().getProvincia() +"]");
	*/
			
	}

}
