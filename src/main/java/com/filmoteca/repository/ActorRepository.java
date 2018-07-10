package com.filmoteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.filmoteca.domain.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long>{

}
