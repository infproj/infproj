package rs.code9.videostore.service;

import java.util.List;

import rs.code9.videostore.model.Admin;
import rs.code9.videostore.model.Movie;
import rs.code9.videostore.model.Reserved;
import rs.code9.videostore.model.Taken;

public interface AdminService {

	public List<Movie> getAllMovies();

	public List<Movie> findMovieByName(String name);

	public Movie getMovieById(Long id);
	
	public Admin getAdminById(Long id);
	
	public Admin create(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public List<Reserved> getAllReservations();
	
	public Reserved getReservation(long id);
	
	public void saveTaken(Taken tek);
	
	public void deleteReservation(Reserved res);
	
	public List<Admin> getAllAdmins();
	

}
