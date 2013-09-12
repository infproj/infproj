package rs.code9.videostore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.code9.videostore.model.User;
import rs.code9.videostore.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public String showHome(Model model, @PathVariable(value="id") long id){
		model.addAttribute("user", userService.get(id)).addAttribute("newUser", false);
		return("edit");
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
		Assert.state(id == user.getId(), "Correct ID on submission.");
		userService.update(user);
		return ("redirect:/home/");
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newUserBlank(Model model){
		model.addAttribute("user", new User()).addAttribute("newUser",true);
		return("edit");
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String newUser(Model model,
			@ModelAttribute("user") @Valid User user,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("user", user).addAttribute("newUser",true);
			return ("edit");
		}
		
		User newUser = userService.create(user);
		return ("home");
	}
	
	
	@RequestMapping(value="/reservations", method = RequestMethod.GET)
	public String getReservations(Model model){
		
		UserDetails userDet = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = userDet.getUsername();
		System.out.println(email);
		model.addAttribute("reservations", userService.getReservationsForEmail(email));
		return("reservations");
	}
	
	@RequestMapping(value="/cancelReservation/{id}", method = RequestMethod.GET)
	public String cancelReservation(Model model, @PathVariable("id") long id){
		
		userService.deleteReservation(id);
		
		return("redirect:/users/reservations");
	}

	
}



