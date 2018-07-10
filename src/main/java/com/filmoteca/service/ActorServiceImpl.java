package com.filmoteca.service;

import org.springframework.stereotype.Service;

import com.filmoteca.domain.Actor;
import com.filmoteca.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	private ActorRepository actorRepository;
	
	public ActorServiceImpl(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	@Override
	public Iterable<Actor> list() {
		return actorRepository.findAll();
	}

	@Override
	public Actor read(Long id) {
		return actorRepository.findById(id).get();
	}

	@Override
	public Actor save(Actor actor) {
		return this.actorRepository.save(actor);
	}

	@Override
	public void delete(Long id) {
		this.actorRepository.deleteById(id);
	}

}
