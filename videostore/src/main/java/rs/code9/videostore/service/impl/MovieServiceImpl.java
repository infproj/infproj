package rs.code9.videostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.code9.videostore.model.Event;
import rs.code9.videostore.model.Movie;
import rs.code9.videostore.model.Reserved;
import rs.code9.videostore.model.Taken;
import rs.code9.videostore.repository.EventRepository;
import rs.code9.videostore.repository.MovieRepository;
import rs.code9.videostore.repository.ReservedRepository;
import rs.code9.videostore.repository.TakenRepository;
import rs.code9.videostore.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private EventRepository eRepository;
	
	@Autowired
	private ReservedRepository reserveRepository;
	
	@Autowired 
	private TakenRepository takenRepository;
	
	@Override
	public Movie getMovieById(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public boolean deleteMovie(Long id) {
		
		try{
			repository.delete(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Movie create(Movie movie) {
		return repository.save(movie);
	}

	@Override
	public Event createEvent(Event event) {
		
		return eRepository.save(event);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		
		return repository.save(movie);
	}

	@Override
	public Reserved reserveMovie(Reserved res) {
		
		return reserveRepository.save(res);
	}

	@Override
	public Taken rentMovie(Taken tek) {
		
		return takenRepository.save(tek);
		
	}
	

}
