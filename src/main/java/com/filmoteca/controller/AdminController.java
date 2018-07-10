package com.filmoteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filmoteca.domain.Actor;
import com.filmoteca.domain.Movie;
import com.filmoteca.service.ActorService;
import com.filmoteca.service.MovieService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final static String ADMIN_PATH = "admin/";

	private MovieService movieService;
	private ActorService actorService;
	
	@Autowired
	public AdminController(MovieService movieService, ActorService actorService) {
		this.movieService = movieService;
		this.actorService = actorService;
	}
	
	@RequestMapping("movies/")
	public String movies(Model model) {
		model.addAttribute("movies", movieService.list());
		return ADMIN_PATH + "adminMovies";
	}
	
	@RequestMapping("/add/movie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "movies/editMovie";
	}
	
	@RequestMapping("actors/")
	public String actors(Model model) {
		model.addAttribute("actors", actorService.list());
		return ADMIN_PATH + "adminActors";
	}
	
	@RequestMapping("/add/actor")
	public String addActor(Model model) {
		model.addAttribute("actor", new Actor());
		return "actors/editActor";
	}
	
	
	
}
