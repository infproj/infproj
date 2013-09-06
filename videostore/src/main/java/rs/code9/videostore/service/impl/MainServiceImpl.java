package rs.code9.videostore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.videostore.model.Movie;
import rs.code9.videostore.repository.MovieRepository;
import rs.code9.videostore.service.MainService;

@Service
@Transactional(readOnly=true)
public class MainServiceImpl implements MainService{

	
	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<Movie> getAllMovies() {
		return  repository.findAll();
	}

	@Override
	public List<Movie> findMovieByName(String name) {
		return repository.findByName(name);
	}

}
