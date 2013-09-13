package rs.code9.videostore.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import rs.code9.videostore.model.Admin;
import rs.code9.videostore.model.Reserved;
import rs.code9.videostore.model.Taken;
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
	
	@RequestMapping(value = "/findMov",method = RequestMethod.POST)
	public String findMovie(Model model,@RequestParam("name") String name){
		model.addAttribute("movies", service.findMovieByName(name));
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
		return("adminList");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAdmins(Model model){
		model.addAttribute("admins", service.getAllAdmins());
		return("adminList");
	}
	
	@RequestMapping(value = "/new",method = RequestMethod.GET)
	public String newAdmin(Model model){
		model.addAttribute("admin", new Admin());
		model.addAttribute("newAdmin",true);
		return("newAdmin");
	}
	
	@RequestMapping(value = "/new",method = RequestMethod.POST)
	public String addNewAdmin(Model model,
			@ModelAttribute("admin") @Valid Admin admin,
			BindingResult result
			){
		if (result.hasErrors()) {
			model.addAttribute("Admin", admin);
			model.addAttribute("newAdmin",true);
			return ("editAdmins");
		}
		@SuppressWarnings("unused")
		Admin newAdmin = service.create(admin);
		return ("redirect:/admin/");
	}
	
	@RequestMapping(value = "/reservations",method = RequestMethod.GET)
	public String rentReserved(Model model){
		
		model.addAttribute("reservations", service.getAllReservations());
		
		return("adminReservations");
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
	public String srentReservedMovie(Model model, @PathVariable("id") long id) {
		
		Reserved res = service.getReservation(id);
		
		Taken tak = new Taken();
		
		tak.setMovie(res.getMovie());
		tak.setUser(res.getUser());
		tak.setDateTime(new Date());
		Date returnTime = new Date();
		returnTime.setDate(returnTime.getDate()+2);
		tak.setReturnTime(returnTime);
		service.saveTaken(tak);
		service.deleteReservation(res);
		
		return ("redirect:/admin/reservations/");
	}


}
