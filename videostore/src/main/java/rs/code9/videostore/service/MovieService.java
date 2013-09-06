package rs.code9.videostore.service;

import rs.code9.videostore.model.Event;
import rs.code9.videostore.model.Movie;

public interface MovieService {
	
	public Movie getMovieById(Long id);
	
	public boolean deleteMovie(Long id);
	
	public Movie create(Movie movie);
	
	public Event createEvent(Event event);

}
