package com.kodbook2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook2.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsername(String username);
	
	User findByEmail(String email);
}
