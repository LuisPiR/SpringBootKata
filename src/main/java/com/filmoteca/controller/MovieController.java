package com.filmoteca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.filmoteca.domain.Movie;
import com.filmoteca.service.ActorService;
import com.filmoteca.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	private final static String MOVIE_PATH = "movies/";

	private MovieService movieService;
	private ActorService actorService;
	
	@Autowired
	public MovieController(MovieService movieService, ActorService actorService) {
		this.movieService = movieService;
		this.actorService = actorService;
	}
	
	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("movies", movieService.list());
		return "index";
	}
	
	@RequestMapping("/view/{id}")
	public String read(@PathVariable Long id, Model model) {
		model.addAttribute("movie", this.movieService.read(id));
		return MOVIE_PATH + "movie";
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.POST)
	public String create(@Valid Movie movie, BindingResult bindingResults, Model model) {
		System.out.println("movie " + movie);
		this.movieService.save(movie);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("movie", this.movieService.read(id));
		model.addAttribute("actors", this.actorService.list());
		return MOVIE_PATH + "editMovie";
	}
	
	@RequestMapping( value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Long id) {
		this.movieService.delete(id);
		return "redirect:/";
	}
	
}
