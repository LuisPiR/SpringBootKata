package com.filmoteca.service;

import com.filmoteca.domain.User;

public interface UserService {

	public User findByNick(String nick);
	
}
