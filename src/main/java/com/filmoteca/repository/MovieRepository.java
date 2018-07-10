package com.filmoteca.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.filmoteca.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

	List<Movie> findAllByDorGreaterThanEqualOrderByDorDesc(Date date);
	
}
