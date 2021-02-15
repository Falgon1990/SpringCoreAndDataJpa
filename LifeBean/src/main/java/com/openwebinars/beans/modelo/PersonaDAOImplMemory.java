package com.openwebinars.beans.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.openwebinars.beans.dominio.Persona;

public class PersonaDAOImplMemory implements PersonaDAO {
	//InitializingBean DisposableBean la version con interfaces
	List<Persona> personas = new ArrayList<Persona>();

	public Persona findByIndex(int index) {
		return personas.get(index);
	}

	public List<Persona> findAll() {
		return personas;
	}

	public void insert(Persona persona) {
		personas.add(persona);
	}

	public void edit(int index, Persona persona) {
		personas.remove(index);
		personas.add(index, persona);
	}

	public void delete(int index) {
		personas.remove(index);
	}

	public void delete(Persona persona) {
		personas.remove(persona);
	}
	
	
	public void init() throws Exception {
		insert(new Persona("Luismi", 35));
		insert(new Persona("Ana", 32));
		insert(new Persona("Pepe", 34));
		insert(new Persona("Julia", 39));
	}


	public void destroy() throws Exception {
		System.out.println("Limpiando los datos de la lista");
		personas.clear();
	}

}
