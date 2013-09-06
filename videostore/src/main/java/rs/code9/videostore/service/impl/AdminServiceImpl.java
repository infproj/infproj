package rs.code9.videostore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.code9.videostore.model.Admin;
import rs.code9.videostore.model.Movie;
import rs.code9.videostore.repository.AdminRepository;
import rs.code9.videostore.repository.MovieRepository;
import rs.code9.videostore.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		return  repository.findAll();
	}

	@Override
	public List<Movie> findMovieByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Movie getMovieById(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public Admin getAdminById(Long id) {
		
		return adminRepository.findOne(id);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

}
