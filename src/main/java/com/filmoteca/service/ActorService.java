package com.filmoteca.service;

import com.filmoteca.domain.Actor;

public interface ActorService {
	
	public Iterable<Actor> list();
	
	public Actor read(Long id);
	
	public Actor save(Actor actor);
	
	public void delete(Long id);
}
