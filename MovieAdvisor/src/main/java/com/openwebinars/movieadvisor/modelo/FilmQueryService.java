package com.openwebinars.movieadvisor.modelo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openwebinars.movieadvisor.daoInterface.FilmInterface;
import com.openwebinars.movieadvisor.dominio.Film;
import com.openwebinars.movieadvisor.modeloInterface.FilmQueryInterface;

/**
 * Implementaci�n del servicio de consulta sobre el repositorio.
 * Esta implementaci�n es algo lenta, ya que se basa en el uso
 * del API Stream de Java 8 sobre una lista bastante grande.
 * 
 * Una posible mejora ser�a utilizar como repositorio una base
 * de datos, y tener una implementaci�n de este servicio que hiciera
 * uso de Criteria API o QueryDSL. 
 * 
 * 
 * @author OpenWebinars
 *
 */
@Service
public class FilmQueryService implements FilmQueryInterface {

	@Autowired
	private FilmInterface dao;
	
	private Predicate<Film> predicate;
	
	@PostConstruct
	public void init() {
		predicate=null;
	}
	@Override
	public Collection<Film> exec() {
		
		// @formatter:off
				return dao.findAll()
						.stream()
						.filter(predicate)
						.collect(Collectors.toList()); 
				// @formatter:on
	}

	@Override
	public FilmQueryService anyGenre(String... genres) {
		Predicate<Film> pAnyGenre = (film -> Arrays.stream(genres).anyMatch(film.getGeneros()::contains));
		predicate = (predicate == null) ? pAnyGenre : predicate.and(pAnyGenre);
		return this;
	}

	@Override
	public FilmQueryService allGenres(String... genres) {
		Predicate<Film> pAllGenres = (film -> Arrays.stream(genres).allMatch(film.getGeneros()::contains));
		predicate = (predicate == null) ? pAllGenres : predicate.and(pAllGenres);
		return this;
	}

	@Override
	public FilmQueryService year(String year) {
		Predicate<Film> pYear = (film -> film.getYear().equalsIgnoreCase(year));
		predicate = (predicate == null) ? pYear : predicate.and(pYear);
		return this;
	}

	@Override
	public FilmQueryService betweenYears(String from, String to) {
		Predicate<Film> pBetweenYears = (film -> {
			LocalDate fromYear = LocalDate.of(Integer.parseInt(from), 1, 1);
			LocalDate toYear = LocalDate.of(Integer.parseInt(to), 1, 3);
			LocalDate filmYear = LocalDate.of(Integer.parseInt(film.getYear()), 1, 2);

			return filmYear.isAfter(fromYear) && filmYear.isBefore(toYear);
		});
		
		predicate = (predicate == null) ? pBetweenYears : predicate.and(pBetweenYears);

		return this;
	
	}

	@Override
	public FilmQueryService titleContains(String title) {
		Predicate<Film> pTitleContains  = (film -> film.getTitle().toLowerCase().contains(title.toLowerCase()));
		predicate = (predicate == null) ? pTitleContains : predicate.and(pTitleContains);
		
		return this;
	}

	

}
