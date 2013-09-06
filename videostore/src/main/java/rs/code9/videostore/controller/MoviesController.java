package rs.code9.videostore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.code9.videostore.model.Movie;
import rs.code9.videostore.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	private MovieService service;
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showMovie(Model model,@PathVariable("id") long id) {
		model.addAttribute("movie", service.getMovieById(id));
		return ("editMovies");
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(Model model,@PathVariable("id") long id) {
		service.deleteMovie(id);
		return ("admin");
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newMovie(Model model) {
		
		model.addAttribute("movie", new Movie());
		model.addAttribute("newMovie", true);
		return ("editMovies");
	}
	
	@RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
	public String rentMovie(Model model) {
		
		
	//	service.createEvent(event);
		
		return ("admin");
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public ModelAndView newUser(
			@ModelAttribute("movie") @Valid Movie movie,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("editMovies", "movie", movie).addObject("newMovie", true);
		}
		
		@SuppressWarnings("unused")
		Movie newMovie = service.create(movie);
		return new ModelAndView("admin");
	}
	
}
