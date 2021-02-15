package com.openwebinars.beans.modelo;

import java.util.List;

import com.openwebinars.beans.dominio.Persona;

public interface PersonaDAO {
	public Persona findByIndex(int index);
	public List<Persona> findAll();
	public void insert(Persona persona);
	public void edit(int index, Persona persona);
	public void delete(int index);
	public void delete(Persona persona);
}
