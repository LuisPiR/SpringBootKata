package com.filmoteca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.filmoteca.domain.Actor;
import com.filmoteca.service.ActorService;

@Controller
@RequestMapping("/actor")
public class ActorController {
	
	private final static String MOVIE_PATH = "actors/";

	private ActorService actorService;
	
	@Autowired
	public ActorController(ActorService actorService) {
		this.actorService = actorService;
	}
	
	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("actors", actorService.list());
		return MOVIE_PATH + "actors";
	}
	
	@RequestMapping("/view/{id}")
	public String read(@PathVariable Long id, Model model) {
		model.addAttribute("actor", this.actorService.read(id));
		return MOVIE_PATH + "actor";
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.POST)
	public String create(@Valid Actor actor, BindingResult bindingResults, Model model) {
		this.actorService.save(actor);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("actor", this.actorService.read(id));
		return MOVIE_PATH + "editActor";
	}
	
	@RequestMapping( value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Long id) {
		this.actorService.delete(id);
		return "redirect:/";
	}
	
}
