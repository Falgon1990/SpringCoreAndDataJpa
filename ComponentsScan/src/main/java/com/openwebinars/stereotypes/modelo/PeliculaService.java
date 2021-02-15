package com.openwebinars.stereotypes.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openwebinars.stereotypes.dominio.Pelicula;
import com.openwebinars.stereotypes.modeloInterface.PeliculaDao;

@Service
public class PeliculaService {
	@Autowired
	private PeliculaDao peliculaDao;
	
	public void setPeliculaDao(PeliculaDao peliculaDao) {
		this.peliculaDao = peliculaDao;
	}
		
	public List<Pelicula> pelisPorGenero(String genero) {
		return peliculaDao
				.findAll()
				.stream()
				.filter(p -> p.getGenero().equalsIgnoreCase(genero))
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
