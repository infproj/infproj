package rs.code9.videostore.service;

import java.util.List;

import rs.code9.videostore.model.Movie;


public interface MainService {
	
	public List<Movie> getAllMovies();
	
	public List<Movie> findMovieByName(String name);

}
