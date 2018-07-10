package com.filmoteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filmoteca.service.MovieService;

@Controller
public class HomeController {

	private MovieService movieService;
	
	@Autowired
	public HomeController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("movies", this.movieService.getLastYearMovies());
		return "index";
	}
	
}
