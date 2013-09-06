package rs.code9.videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.code9.videostore.model.Admin;
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
	
	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
	public String editAdmin(Model model,@PathVariable("id") long id){
		model.addAttribute("admin", service.getAdminById(id));
		return("editAdmins");
	}
	
	@RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
	public String updateAdmin(@ModelAttribute("admin") Admin admin, @PathVariable("id") long id){
		Assert.state(id == admin.getId(), "Correct ID on submission.");
		service.updateAdmin(admin);
		return("editAdmins");
	}
	
	
	

}
