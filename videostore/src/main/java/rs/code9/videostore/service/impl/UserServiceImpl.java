package rs.code9.videostore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import rs.code9.videostore.model.Reserved;
import rs.code9.videostore.model.User;
import rs.code9.videostore.repository.ReservedRepository;
import rs.code9.videostore.repository.UserRepository;
import rs.code9.videostore.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservedRepository resRepository;

	@Override
	public User get(Long id) {
		return userRepository.findOne(id);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
		public synchronized void update(User user) throws IllegalArgumentException {
			Assert.isTrue(userRepository.exists(user.getId()), "User must be in repository to update.");
			userRepository.save(user);
		}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public List<Reserved> getReservationsForEmail(String email) {
		
		return userRepository.getReservationsForEmail(email);
	}

	@Override
	public User create(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void deleteReservation(Long id) {
		
		resRepository.delete(id);
		
	}
		
	}
	
	



	
