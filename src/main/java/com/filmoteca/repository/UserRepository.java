package com.filmoteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.filmoteca.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByNick(String nick);
	
}
