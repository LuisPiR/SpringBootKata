package com.filmoteca.service;

import java.util.List;

import com.filmoteca.domain.Movie;

public interface MovieService {
	
	public Iterable<Movie> list();
	
	public Movie read(Long id);
	
	public Movie save(Movie movie);
	
	public void delete(Long id);

	public List<Movie> getLastYearMovies();
}
