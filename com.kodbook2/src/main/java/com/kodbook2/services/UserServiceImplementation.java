package com.kodbook2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook2.entities.User;
import com.kodbook2.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository repo;

	@Override
	public void addUser(User user) {
		
		repo.save(user);
		
	}

	@Override
	public boolean userExists(String username, String email) {
		
		User user1=repo.findByUsername(username);
		User user2=repo.findByEmail(email);
		if(user1!=null || user2!=null)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean validateUser(String username, String password) {
		String dbpass=repo.findByUsername(username).getPassword();
		if(password.equals(dbpass))
		{
			return true;
		}
		
		return false;
	}
	

}
