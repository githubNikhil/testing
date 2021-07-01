package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User store(User user) {
		return userRepo.save(user);
	}
	
	public User findUser(int id) {
		return userRepo.findById(id).get();
	}
}
