package com.toto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toto.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
