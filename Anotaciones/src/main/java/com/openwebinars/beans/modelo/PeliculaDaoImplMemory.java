package com.openwebinars.beans.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.openwebinars.beans.dominio.Pelicula;
import com.openwebinars.beans.modeloInterface.PeliculaDao;

public class PeliculaDaoImplMemory implements PeliculaDao {
private List<Pelicula> peliculas = new ArrayList<>();
	
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
	
	public void init() {
		insert(new Pelicula("La guerra de las galaxias", "1977","Ciencia ficci�n"));
		insert(new Pelicula("La lista de Schindler","1993","Drama"));
		insert(new Pelicula("El Padrino", "1972", "Drama"));
		insert(new Pelicula("Apocalypse Now", "1979", "B�lico"));
		insert(new Pelicula("Gladiator", "2000", "Acci�n"));
		insert(new Pelicula("El Gran Dictador","1940","Comedia"));
		
		
	}
}
