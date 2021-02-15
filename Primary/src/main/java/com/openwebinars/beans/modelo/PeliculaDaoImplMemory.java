package com.openwebinars.beans.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.openwebinars.beans.dominio.Pelicula;
import com.openwebinars.beans.modeloInterface.CatalogoPeliculas;
import com.openwebinars.beans.modeloInterface.PeliculaDao;

public class PeliculaDaoImplMemory implements PeliculaDao{
private List<Pelicula> peliculas = new ArrayList<>();
	
	@Autowired
	//@Qualifier("catalogoActuales")
	private CatalogoPeliculas catalogoPeliculas;
	
	
	public void init() {
			peliculas.addAll(catalogoPeliculas.getPeliculas());
		
	}
	
	public Pelicula findById(int id) {
		return peliculas.get(id);
	}

	public Collection<Pelicula> findAll() {
		return peliculas;
	}

	public void insert(Pelicula pelicula) {
		peliculas.add(pelicula);
	}

	public void edit(Pelicula antigua, Pelicula nueva) {		
		peliculas.remove(antigua);
		peliculas.add(nueva);		
	}

	public void delete(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}

}
