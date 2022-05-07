package com.toto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.toto.model.User;
import com.toto.repository.UserRepository;
import com.toto.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserApiController {
	
	@Autowired
	private final UserRepository repository;

	UserApiController(UserRepository repository) {
	    this.repository = repository;
	  }

	  @GetMapping("/users")
	  List<User> all() {
		  return repository.findAll();
	  }

	  @PostMapping("/users")
	  User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }

	  @GetMapping("/users/{id}")
	  User one(@PathVariable Long id) {
	    
	    return repository.findById(id)
	      .orElse(null);
	  }

	  @PutMapping("/users/{id}")
	  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(user -> {
//	        user.setTitle(newUser.getTitle());
	//        user.setContent(newUser.getContent());
	        return repository.save(user);
	      })
	      .orElseGet(() -> {
	        newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }

	  @DeleteMapping("/users/{id}")
	  void deleteUser(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
}
