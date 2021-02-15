package com.openwebinars.beans.modeloInterface;

import java.util.Collection;

import com.openwebinars.beans.dominio.Pelicula;



public interface PeliculaDao {
	public Pelicula findById(int id);
	public Collection<Pelicula> findAll();
	public void insert(Pelicula pelicula);
	public void edit(Pelicula antigua, Pelicula nueva);
	public void delete(Pelicula pelicula);
}
