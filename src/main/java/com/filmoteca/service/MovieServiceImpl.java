package com.filmoteca.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filmoteca.domain.Movie;
import com.filmoteca.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;
	
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@Override
	public Iterable<Movie> list() {
		return this.movieRepository.findAll();
	}

	@Override
	public Movie read(Long id) {
		return this.movieRepository.findById(id).get();
	}

	@Override
	public Movie save(Movie movie) {
		return this.movieRepository.save(movie);
	}

	@Override
	public void delete(Long id) {
		this.movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> getLastYearMovies() {
		Calendar firstDayYear = Calendar.getInstance();
		firstDayYear.set(Calendar.MONTH, 0);
		firstDayYear.set(Calendar.DATE, 1);
		firstDayYear.set(Calendar.HOUR_OF_DAY, 0);
		firstDayYear.set(Calendar.MINUTE, 0);
		firstDayYear.set(Calendar.SECOND, 0);
		System.out.println(firstDayYear.getTime());
		return this.movieRepository.findAllByDorGreaterThanEqualOrderByDorDesc(firstDayYear.getTime());
	}

}
