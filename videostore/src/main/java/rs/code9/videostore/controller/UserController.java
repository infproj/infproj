package rs.code9.videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.code9.videostore.model.User;
import rs.code9.videostore.service.UserService;

@Controller
@RequestMapping("/home")
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
	

	
}



