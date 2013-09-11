package rs.code9.videostore.service;

import rs.code9.videostore.model.Event;
import rs.code9.videostore.model.Movie;
import rs.code9.videostore.model.Reserved;

public interface MovieService {
	
	public Movie getMovieById(Long id);
	
	public Movie updateMovie(Movie movie);
	
	public boolean deleteMovie(Long id);
	
	public Movie create(Movie movie);
	
	public Event createEvent(Event event);
	
	public Reserved reserveMovie( Reserved res);

}
