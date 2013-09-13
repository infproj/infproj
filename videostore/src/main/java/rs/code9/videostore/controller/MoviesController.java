package rs.code9.videostore.controller;

import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.code9.videostore.model.Movie;
import rs.code9.videostore.model.Reserved;
import rs.code9.videostore.model.Taken;
import rs.code9.videostore.model.User;
import rs.code9.videostore.service.MovieService;
import rs.code9.videostore.service.UserService;

@Controller
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	private MovieService service;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showMovie(Model model,@PathVariable("id") long id) {
		model.addAttribute("movie", service.getMovieById(id));
		return ("editMovies");
		
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updateMovie(@ModelAttribute("movie") Movie movie, @PathVariable("id") long id) {
		Assert.state(id == movie.getId(), "Correct ID on submission.");
		service.updateMovie(movie);
		return ("redirect:/admin");
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
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/rent", method = RequestMethod.POST)
	public String rentMovieWithoutReservation(Model model, @RequestParam("userEmail")String userEmail, @RequestParam("movieId") String movieId) {
		
		User user =userService.getUserByEmail(userEmail);
		Movie movie = service.getMovieById(Long.parseLong(movieId));
		if(movie.getStock()>0){
			Taken taken = new Taken();
			taken.setMovie(movie);
			taken.setUser(user);
			taken.setDateTime(new Date());
			Date returnTime = new Date();
			returnTime.setDate(returnTime.getDate()+2);
			taken.setReturnTime(returnTime);
			//updating stock
			movie.setStock(movie.getStock()-1);
			service.updateMovie(movie);
			Taken newTaken = service.rentMovie(taken);
			
			if (newTaken !=null)
				model.addAttribute("message","movie rented to user"+user.getEmail());
			else
				model.addAttribute("message", "an error occured, please try again");
		}else{
			model.addAttribute("message", "there are no available movies on stock, sorry");
		}
		
		
		return ("adminReservations");
	}
	
	
	@RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
	public String rentMovie(Model model,@PathVariable("id") long id ) {
		
		model.addAttribute("movieId", id);
		
		return ("adminReservations");
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
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/reservate/{id}", method = RequestMethod.GET)
	public String reserveMovie(Model model,@ModelAttribute("movie") Movie movie, @PathVariable("id") long id) {
		Assert.state(id == movie.getId(), "Correct ID on submission.");
		
		
		//izvuci usera i film, i za to kreirati event
		
		UserDetails u = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = u.getUsername();
		User user = userService.getUserByEmail(username);	//imam username, vadim objekat user za Event;
		long movieId = movie.getId();
		Movie mov = service.getMovieById(movieId);	//objekat Movie za event
		
		
		Reserved res = new Reserved();
		res.setMovie(mov);
		res.setUser(user);
		//use date and it's ok
		Date currentTime = new Date();
		res.setDateTime(currentTime);
		Date expTime = new Date();
		expTime.setDate(expTime.getDate()+2);		//vreme isteka rezervacije je 2 dana
		res.setExpireTime(expTime);
		
		service.reserveMovie(res);
		

		return ("home");
	}
	
}