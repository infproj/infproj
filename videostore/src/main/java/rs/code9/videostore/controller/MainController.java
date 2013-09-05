package rs.code9.videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.code9.videostore.service.MainService;

@Controller
@RequestMapping("/home")
public class MainController {
	
	@Autowired
	private MainService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showHome(Model model){
		model.addAttribute("movies", service.getAllMovies());
		return("home");
	}

}