package rs.code9.videostore.service;

import java.util.List;

import rs.code9.videostore.model.User;



public interface UserService {
	
	public User get(Long id); 
	
	public List<User> findAll();
	
	void update(User user) throws IllegalArgumentException;
}
