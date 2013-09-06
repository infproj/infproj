package rs.code9.videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.code9.videostore.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showHome(Model model){
		model.addAttribute("movies", service.getAllMovies());
		return("admin");
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String showMovie(Model model,@PathVariable("id") long id) {
		model.addAttribute("movie", service.getMovieById(id));
		return ("edit-movie");
	}
	

}
