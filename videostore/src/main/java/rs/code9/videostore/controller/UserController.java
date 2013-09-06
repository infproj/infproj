package rs.code9.videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.code9.videostore.service.UserService;

@Controller
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public String showHome(Model model, @PathVariable(value="id") long id){
		model.addAttribute("user", userService.get(id));
		return("edit");
	}

}
