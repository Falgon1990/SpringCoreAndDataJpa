package com.openwebinars.javaconfig.modeloInterface;

import java.util.Collection;

import com.openwebinars.javaconfig.dominio.Pelicula;

public interface PeliculaDao {
	public Pelicula findById(int id);
	public Collection<Pelicula> findAll();
	public void insert(Pelicula pelicula);
	public void edit(Pelicula antigua, Pelicula nueva);
	public void delete(Pelicula pelicula);
}
