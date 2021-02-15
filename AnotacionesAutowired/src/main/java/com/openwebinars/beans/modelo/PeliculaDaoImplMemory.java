package com.openwebinars.beans.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.openwebinars.beans.dominio.Pelicula;
import com.openwebinars.beans.modeloInterface.CatalogoPeliculas;
import com.openwebinars.beans.modeloInterface.PeliculaDao;


public class PeliculaDaoImplMemory implements PeliculaDao {

private List<Pelicula> peliculas = new ArrayList<>();
	
//@Autowired(required=false)
//private Set<CatalogoPeliculas> catalogosPeliculas;

//@Autowired
//public PeliculaDaoImplMemory(@Nullable Set<CatalogoPeliculas> catalogosPeliculas) {
//	this.catalogosPeliculas = catalogosPeliculas;
//}

//Quitar los beans comentados en el xml para ver el funcionaminento 
private Set<CatalogoPeliculas> catalogosPeliculas;
@Autowired
public void setCatalogosPeliculas(Optional<Set<CatalogoPeliculas>> catalogosPeliculas) {
	this.catalogosPeliculas = catalogosPeliculas.orElse(null);
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
	
	public void init() {
		if(this.catalogosPeliculas!=null) {
		for(CatalogoPeliculas c: this.catalogosPeliculas) {
			peliculas.addAll(c.getPeliculas());
		}
		}
	}

}
