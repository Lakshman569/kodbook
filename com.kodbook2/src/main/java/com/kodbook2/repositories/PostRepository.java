package com.kodbook2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook2.entities.Post;

public interface PostRepository extends JpaRepository<Post,Long>{

}
