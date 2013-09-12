package rs.code9.videostore.service;

import java.util.List;

import rs.code9.videostore.model.Reserved;
import rs.code9.videostore.model.User;



public interface UserService {
	
	public User get(Long id); 
	
	public User create(User user);
	
	public List<User> findAll();
	
	void update(User user) throws IllegalArgumentException;

	public User getUserByEmail(String email);
	
	public List<Reserved> getReservationsForEmail(String email);
	
	public void deleteReservation(Long id);
}
