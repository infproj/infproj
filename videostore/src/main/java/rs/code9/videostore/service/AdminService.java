package rs.code9.videostore.service;

import java.util.List;

import rs.code9.videostore.model.Admin;
import rs.code9.videostore.model.Movie;

public interface AdminService {

	public List<Movie> getAllMovies();

	public List<Movie> findMovieByName(String name);

	public Movie getMovieById(Long id);
	
	public Admin getAdminById(Long id);
	
	public Admin updateAdmin(Admin admin);
}
