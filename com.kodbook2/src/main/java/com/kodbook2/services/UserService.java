package com.kodbook2.services;

import com.kodbook2.entities.User;

public interface UserService {
	
	void addUser(User user);
	
	boolean userExists(String username,String email);
	
	boolean validateUser(String username,String password);
	
}
